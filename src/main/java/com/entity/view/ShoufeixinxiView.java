package com.entity.view;

import com.entity.ShoufeixinxiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 收费信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shoufeixinxi")
public class ShoufeixinxiView extends ShoufeixinxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 收费类型的值
		*/
		private String shoufeixinxiValue;



	public ShoufeixinxiView() {

	}

	public ShoufeixinxiView(ShoufeixinxiEntity shoufeixinxiEntity) {
		try {
			BeanUtils.copyProperties(this, shoufeixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 收费类型的值
			*/
			public String getShoufeixinxiValue() {
				return shoufeixinxiValue;
			}
			/**
			* 设置： 收费类型的值
			*/
			public void setShoufeixinxiValue(String shoufeixinxiValue) {
				this.shoufeixinxiValue = shoufeixinxiValue;
			}












}
