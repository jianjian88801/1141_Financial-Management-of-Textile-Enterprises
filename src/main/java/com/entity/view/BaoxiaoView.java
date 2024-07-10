package com.entity.view;

import com.entity.BaoxiaoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 报销信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("baoxiao")
public class BaoxiaoView extends BaoxiaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 报销类型的值
		*/
		private String baoxiaoValue;
		/**
		* 是否同意的值
		*/
		private String baoxiaoYesnoValue;



		//级联表 yuangong
			/**
			* 员工姓名
			*/
			private String yuangongName;
			/**
			* 员工手机号
			*/
			private String yuangongPhone;
			/**
			* 员工身份证号
			*/
			private String yuangongIdNumber;
			/**
			* 员工头像
			*/
			private String yuangongPhoto;
			/**
			* 电子邮箱
			*/
			private String yuangongEmail;

	public BaoxiaoView() {

	}

	public BaoxiaoView(BaoxiaoEntity baoxiaoEntity) {
		try {
			BeanUtils.copyProperties(this, baoxiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 报销类型的值
			*/
			public String getBaoxiaoValue() {
				return baoxiaoValue;
			}
			/**
			* 设置： 报销类型的值
			*/
			public void setBaoxiaoValue(String baoxiaoValue) {
				this.baoxiaoValue = baoxiaoValue;
			}
			/**
			* 获取： 是否同意的值
			*/
			public String getBaoxiaoYesnoValue() {
				return baoxiaoYesnoValue;
			}
			/**
			* 设置： 是否同意的值
			*/
			public void setBaoxiaoYesnoValue(String baoxiaoYesnoValue) {
				this.baoxiaoYesnoValue = baoxiaoYesnoValue;
			}


















				//级联表的get和set yuangong
					/**
					* 获取： 员工姓名
					*/
					public String getYuangongName() {
						return yuangongName;
					}
					/**
					* 设置： 员工姓名
					*/
					public void setYuangongName(String yuangongName) {
						this.yuangongName = yuangongName;
					}
					/**
					* 获取： 员工手机号
					*/
					public String getYuangongPhone() {
						return yuangongPhone;
					}
					/**
					* 设置： 员工手机号
					*/
					public void setYuangongPhone(String yuangongPhone) {
						this.yuangongPhone = yuangongPhone;
					}
					/**
					* 获取： 员工身份证号
					*/
					public String getYuangongIdNumber() {
						return yuangongIdNumber;
					}
					/**
					* 设置： 员工身份证号
					*/
					public void setYuangongIdNumber(String yuangongIdNumber) {
						this.yuangongIdNumber = yuangongIdNumber;
					}
					/**
					* 获取： 员工头像
					*/
					public String getYuangongPhoto() {
						return yuangongPhoto;
					}
					/**
					* 设置： 员工头像
					*/
					public void setYuangongPhoto(String yuangongPhoto) {
						this.yuangongPhoto = yuangongPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getYuangongEmail() {
						return yuangongEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYuangongEmail(String yuangongEmail) {
						this.yuangongEmail = yuangongEmail;
					}




}
