
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
 * 支出信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhichuxinxi")
public class ZhichuxinxiController {
    private static final Logger logger = LoggerFactory.getLogger(ZhichuxinxiController.class);

    @Autowired
    private ZhichuxinxiService zhichuxinxiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YuangongService yuangongService;
    @Autowired
    private CaiwurenyuanService caiwurenyuanService;


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
        PageUtils page = zhichuxinxiService.queryPage(params);

        //字典表数据转换
        List<ZhichuxinxiView> list =(List<ZhichuxinxiView>)page.getList();
        for(ZhichuxinxiView c:list){
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
        ZhichuxinxiEntity zhichuxinxi = zhichuxinxiService.selectById(id);
        if(zhichuxinxi !=null){
            //entity转view
            ZhichuxinxiView view = new ZhichuxinxiView();
            BeanUtils.copyProperties( zhichuxinxi , view );//把实体数据重构到view中

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
    public R save(@RequestBody ZhichuxinxiEntity zhichuxinxi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhichuxinxi:{}",this.getClass().getName(),zhichuxinxi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZhichuxinxiEntity> queryWrapper = new EntityWrapper<ZhichuxinxiEntity>()
            .eq("zhichuxinxi_mingmu_name", zhichuxinxi.getZhichuxinxiMingmuName())
            .eq("zhichuxinxi_types", zhichuxinxi.getZhichuxinxiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhichuxinxiEntity zhichuxinxiEntity = zhichuxinxiService.selectOne(queryWrapper);
        if(zhichuxinxiEntity==null){
            zhichuxinxi.setInsertTime(new Date());
            zhichuxinxi.setCreateTime(new Date());
            zhichuxinxiService.insert(zhichuxinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhichuxinxiEntity zhichuxinxi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhichuxinxi:{}",this.getClass().getName(),zhichuxinxi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ZhichuxinxiEntity> queryWrapper = new EntityWrapper<ZhichuxinxiEntity>()
            .notIn("id",zhichuxinxi.getId())
            .andNew()
            .eq("zhichuxinxi_mingmu_name", zhichuxinxi.getZhichuxinxiMingmuName())
            .eq("zhichuxinxi_types", zhichuxinxi.getZhichuxinxiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhichuxinxiEntity zhichuxinxiEntity = zhichuxinxiService.selectOne(queryWrapper);
        if(zhichuxinxiEntity==null){
            zhichuxinxiService.updateById(zhichuxinxi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        zhichuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ZhichuxinxiEntity> zhichuxinxiList = new ArrayList<>();//上传的东西
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
                            ZhichuxinxiEntity zhichuxinxiEntity = new ZhichuxinxiEntity();
//                            zhichuxinxiEntity.setZhichuxinxiMingmuName(data.get(0));                    //支出名目 要改的
//                            zhichuxinxiEntity.setZhichuxinxiTypes(Integer.valueOf(data.get(0)));   //支出类型 要改的
//                            zhichuxinxiEntity.setZhichuxinxiMoney(data.get(0));                    //支出金额 要改的
//                            zhichuxinxiEntity.setZhichuContent("");//照片
//                            zhichuxinxiEntity.setZhichuxinxiTime(new Date(data.get(0)));          //支出时间 要改的
//                            zhichuxinxiEntity.setInsertTime(date);//时间
//                            zhichuxinxiEntity.setCreateTime(date);//时间
                            zhichuxinxiList.add(zhichuxinxiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        zhichuxinxiService.insertBatch(zhichuxinxiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
