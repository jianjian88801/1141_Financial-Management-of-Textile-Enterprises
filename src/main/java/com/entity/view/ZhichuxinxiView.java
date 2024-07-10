package com.entity.view;

import com.entity.ZhichuxinxiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 支出信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zhichuxinxi")
public class ZhichuxinxiView extends ZhichuxinxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 支出类型的值
		*/
		private String zhichuxinxiValue;



	public ZhichuxinxiView() {

	}

	public ZhichuxinxiView(ZhichuxinxiEntity zhichuxinxiEntity) {
		try {
			BeanUtils.copyProperties(this, zhichuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 支出类型的值
			*/
			public String getZhichuxinxiValue() {
				return zhichuxinxiValue;
			}
			/**
			* 设置： 支出类型的值
			*/
			public void setZhichuxinxiValue(String zhichuxinxiValue) {
				this.zhichuxinxiValue = zhichuxinxiValue;
			}












}
