package com.dao;

import com.entity.ShoufeixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShoufeixinxiView;

/**
 * 收费信息 Dao 接口
 *
 * @author 
 */
public interface ShoufeixinxiDao extends BaseMapper<ShoufeixinxiEntity> {

   List<ShoufeixinxiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
