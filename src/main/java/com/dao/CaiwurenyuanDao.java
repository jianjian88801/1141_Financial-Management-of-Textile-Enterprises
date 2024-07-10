package com.dao;

import com.entity.CaiwurenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.CaiwurenyuanView;

/**
 * 财务人员 Dao 接口
 *
 * @author 
 */
public interface CaiwurenyuanDao extends BaseMapper<CaiwurenyuanEntity> {

   List<CaiwurenyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
