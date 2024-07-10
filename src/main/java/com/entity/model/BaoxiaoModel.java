package com.entity.model;

import com.entity.BaoxiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 报销信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BaoxiaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 申请人
     */
    private Integer yuangongId;


    /**
     * 报销名目
     */
    private String baoxiaoName;


    /**
     * 报销类型
     */
    private Integer baoxiaoTypes;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 报销金额
     */
    private Double baoxiaoMoney;


    /**
     * 报销详情
     */
    private String baoxiaoContent;


    /**
     * 是否同意
     */
    private Integer baoxiaoYesnoTypes;


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
	 * 获取：申请人
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 设置：申请人
	 */
    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：报销名目
	 */
    public String getBaoxiaoName() {
        return baoxiaoName;
    }


    /**
	 * 设置：报销名目
	 */
    public void setBaoxiaoName(String baoxiaoName) {
        this.baoxiaoName = baoxiaoName;
    }
    /**
	 * 获取：报销类型
	 */
    public Integer getBaoxiaoTypes() {
        return baoxiaoTypes;
    }


    /**
	 * 设置：报销类型
	 */
    public void setBaoxiaoTypes(Integer baoxiaoTypes) {
        this.baoxiaoTypes = baoxiaoTypes;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：报销金额
	 */
    public Double getBaoxiaoMoney() {
        return baoxiaoMoney;
    }


    /**
	 * 设置：报销金额
	 */
    public void setBaoxiaoMoney(Double baoxiaoMoney) {
        this.baoxiaoMoney = baoxiaoMoney;
    }
    /**
	 * 获取：报销详情
	 */
    public String getBaoxiaoContent() {
        return baoxiaoContent;
    }


    /**
	 * 设置：报销详情
	 */
    public void setBaoxiaoContent(String baoxiaoContent) {
        this.baoxiaoContent = baoxiaoContent;
    }
    /**
	 * 获取：是否同意
	 */
    public Integer getBaoxiaoYesnoTypes() {
        return baoxiaoYesnoTypes;
    }


    /**
	 * 设置：是否同意
	 */
    public void setBaoxiaoYesnoTypes(Integer baoxiaoYesnoTypes) {
        this.baoxiaoYesnoTypes = baoxiaoYesnoTypes;
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
