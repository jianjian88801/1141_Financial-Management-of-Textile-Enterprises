
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 财务人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/caiwurenyuan")
public class CaiwurenyuanController {
    private static final Logger logger = LoggerFactory.getLogger(CaiwurenyuanController.class);

    @Autowired
    private CaiwurenyuanService caiwurenyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YuangongService yuangongService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        else if("财务人员".equals(role))
            params.put("caiwurenyuanId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = caiwurenyuanService.queryPage(params);

        //字典表数据转换
        List<CaiwurenyuanView> list =(List<CaiwurenyuanView>)page.getList();
        for(CaiwurenyuanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        CaiwurenyuanEntity caiwurenyuan = caiwurenyuanService.selectById(id);
        if(caiwurenyuan !=null){
            //entity转view
            CaiwurenyuanView view = new CaiwurenyuanView();
            BeanUtils.copyProperties( caiwurenyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody CaiwurenyuanEntity caiwurenyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,caiwurenyuan:{}",this.getClass().getName(),caiwurenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<CaiwurenyuanEntity> queryWrapper = new EntityWrapper<CaiwurenyuanEntity>()
            .eq("username", caiwurenyuan.getUsername())
            .or()
            .eq("caiwurenyuan_phone", caiwurenyuan.getCaiwurenyuanPhone())
            .or()
            .eq("caiwurenyuan_id_number", caiwurenyuan.getCaiwurenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CaiwurenyuanEntity caiwurenyuanEntity = caiwurenyuanService.selectOne(queryWrapper);
        if(caiwurenyuanEntity==null){
            caiwurenyuan.setCreateTime(new Date());
            caiwurenyuan.setPassword("123456");
            caiwurenyuanService.insert(caiwurenyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者财务人员手机号或者财务人员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CaiwurenyuanEntity caiwurenyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,caiwurenyuan:{}",this.getClass().getName(),caiwurenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<CaiwurenyuanEntity> queryWrapper = new EntityWrapper<CaiwurenyuanEntity>()
            .notIn("id",caiwurenyuan.getId())
            .andNew()
            .eq("username", caiwurenyuan.getUsername())
            .or()
            .eq("caiwurenyuan_phone", caiwurenyuan.getCaiwurenyuanPhone())
            .or()
            .eq("caiwurenyuan_id_number", caiwurenyuan.getCaiwurenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CaiwurenyuanEntity caiwurenyuanEntity = caiwurenyuanService.selectOne(queryWrapper);
        if("".equals(caiwurenyuan.getCaiwurenyuanPhoto()) || "null".equals(caiwurenyuan.getCaiwurenyuanPhoto())){
                caiwurenyuan.setCaiwurenyuanPhoto(null);
        }
        if(caiwurenyuanEntity==null){
            caiwurenyuanService.updateById(caiwurenyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者财务人员手机号或者财务人员身份证号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        caiwurenyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<CaiwurenyuanEntity> caiwurenyuanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            CaiwurenyuanEntity caiwurenyuanEntity = new CaiwurenyuanEntity();
//                            caiwurenyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //caiwurenyuanEntity.setPassword("123456");//密码
//                            caiwurenyuanEntity.setCaiwurenyuanName(data.get(0));                    //财务人员姓名 要改的
//                            caiwurenyuanEntity.setCaiwurenyuanPhone(data.get(0));                    //财务人员手机号 要改的
//                            caiwurenyuanEntity.setCaiwurenyuanIdNumber(data.get(0));                    //财务人员身份证号 要改的
//                            caiwurenyuanEntity.setCaiwurenyuanPhoto("");//照片
//                            caiwurenyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            caiwurenyuanEntity.setCaiwurenyuanEmail(data.get(0));                    //电子邮箱 要改的
//                            caiwurenyuanEntity.setCreateTime(date);//时间
                            caiwurenyuanList.add(caiwurenyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //财务人员手机号
                                if(seachFields.containsKey("caiwurenyuanPhone")){
                                    List<String> caiwurenyuanPhone = seachFields.get("caiwurenyuanPhone");
                                    caiwurenyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> caiwurenyuanPhone = new ArrayList<>();
                                    caiwurenyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("caiwurenyuanPhone",caiwurenyuanPhone);
                                }
                                //财务人员身份证号
                                if(seachFields.containsKey("caiwurenyuanIdNumber")){
                                    List<String> caiwurenyuanIdNumber = seachFields.get("caiwurenyuanIdNumber");
                                    caiwurenyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> caiwurenyuanIdNumber = new ArrayList<>();
                                    caiwurenyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("caiwurenyuanIdNumber",caiwurenyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<CaiwurenyuanEntity> caiwurenyuanEntities_username = caiwurenyuanService.selectList(new EntityWrapper<CaiwurenyuanEntity>().in("username", seachFields.get("username")));
                        if(caiwurenyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CaiwurenyuanEntity s:caiwurenyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //财务人员手机号
                        List<CaiwurenyuanEntity> caiwurenyuanEntities_caiwurenyuanPhone = caiwurenyuanService.selectList(new EntityWrapper<CaiwurenyuanEntity>().in("caiwurenyuan_phone", seachFields.get("caiwurenyuanPhone")));
                        if(caiwurenyuanEntities_caiwurenyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CaiwurenyuanEntity s:caiwurenyuanEntities_caiwurenyuanPhone){
                                repeatFields.add(s.getCaiwurenyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [财务人员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //财务人员身份证号
                        List<CaiwurenyuanEntity> caiwurenyuanEntities_caiwurenyuanIdNumber = caiwurenyuanService.selectList(new EntityWrapper<CaiwurenyuanEntity>().in("caiwurenyuan_id_number", seachFields.get("caiwurenyuanIdNumber")));
                        if(caiwurenyuanEntities_caiwurenyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CaiwurenyuanEntity s:caiwurenyuanEntities_caiwurenyuanIdNumber){
                                repeatFields.add(s.getCaiwurenyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [财务人员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        caiwurenyuanService.insertBatch(caiwurenyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        CaiwurenyuanEntity caiwurenyuan = caiwurenyuanService.selectOne(new EntityWrapper<CaiwurenyuanEntity>().eq("username", username));
        if(caiwurenyuan==null || !caiwurenyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(caiwurenyuan.getId(),username, "caiwurenyuan", "财务人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","财务人员");
        r.put("username",caiwurenyuan.getCaiwurenyuanName());
        r.put("tableName","caiwurenyuan");
        r.put("userId",caiwurenyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody CaiwurenyuanEntity caiwurenyuan){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<CaiwurenyuanEntity> queryWrapper = new EntityWrapper<CaiwurenyuanEntity>()
            .eq("username", caiwurenyuan.getUsername())
            .or()
            .eq("caiwurenyuan_phone", caiwurenyuan.getCaiwurenyuanPhone())
            .or()
            .eq("caiwurenyuan_id_number", caiwurenyuan.getCaiwurenyuanIdNumber())
            ;
        CaiwurenyuanEntity caiwurenyuanEntity = caiwurenyuanService.selectOne(queryWrapper);
        if(caiwurenyuanEntity != null)
            return R.error("账户或者财务人员手机号或者财务人员身份证号已经被使用");
        caiwurenyuan.setCreateTime(new Date());
        caiwurenyuanService.insert(caiwurenyuan);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        CaiwurenyuanEntity caiwurenyuan = new CaiwurenyuanEntity();
        caiwurenyuan.setPassword("123456");
        caiwurenyuan.setId(id);
        caiwurenyuanService.updateById(caiwurenyuan);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        CaiwurenyuanEntity caiwurenyuan = caiwurenyuanService.selectOne(new EntityWrapper<CaiwurenyuanEntity>().eq("username", username));
        if(caiwurenyuan!=null){
            caiwurenyuan.setPassword("123456");
            boolean b = caiwurenyuanService.updateById(caiwurenyuan);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrCaiwurenyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        CaiwurenyuanEntity caiwurenyuan = caiwurenyuanService.selectById(id);
        if(caiwurenyuan !=null){
            //entity转view
            CaiwurenyuanView view = new CaiwurenyuanView();
            BeanUtils.copyProperties( caiwurenyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
