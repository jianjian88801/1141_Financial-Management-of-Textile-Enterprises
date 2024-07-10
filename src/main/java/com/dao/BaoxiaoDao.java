package com.dao;

import com.entity.BaoxiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BaoxiaoView;

/**
 * 报销信息 Dao 接口
 *
 * @author 
 */
public interface BaoxiaoDao extends BaseMapper<BaoxiaoEntity> {

   List<BaoxiaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
