package com.entity.model;

import com.entity.ZhichuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 支出信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhichuxinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 支出名目
     */
    private String zhichuxinxiMingmuName;


    /**
     * 支出类型
     */
    private Integer zhichuxinxiTypes;


    /**
     * 支出金额
     */
    private Double zhichuxinxiMoney;


    /**
     * 备注
     */
    private String zhichuContent;


    /**
     * 支出时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date zhichuxinxiTime;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：支出名目
	 */
    public String getZhichuxinxiMingmuName() {
        return zhichuxinxiMingmuName;
    }


    /**
	 * 设置：支出名目
	 */
    public void setZhichuxinxiMingmuName(String zhichuxinxiMingmuName) {
        this.zhichuxinxiMingmuName = zhichuxinxiMingmuName;
    }
    /**
	 * 获取：支出类型
	 */
    public Integer getZhichuxinxiTypes() {
        return zhichuxinxiTypes;
    }


    /**
	 * 设置：支出类型
	 */
    public void setZhichuxinxiTypes(Integer zhichuxinxiTypes) {
        this.zhichuxinxiTypes = zhichuxinxiTypes;
    }
    /**
	 * 获取：支出金额
	 */
    public Double getZhichuxinxiMoney() {
        return zhichuxinxiMoney;
    }


    /**
	 * 设置：支出金额
	 */
    public void setZhichuxinxiMoney(Double zhichuxinxiMoney) {
        this.zhichuxinxiMoney = zhichuxinxiMoney;
    }
    /**
	 * 获取：备注
	 */
    public String getZhichuContent() {
        return zhichuContent;
    }


    /**
	 * 设置：备注
	 */
    public void setZhichuContent(String zhichuContent) {
        this.zhichuContent = zhichuContent;
    }
    /**
	 * 获取：支出时间
	 */
    public Date getZhichuxinxiTime() {
        return zhichuxinxiTime;
    }


    /**
	 * 设置：支出时间
	 */
    public void setZhichuxinxiTime(Date zhichuxinxiTime) {
        this.zhichuxinxiTime = zhichuxinxiTime;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
