package com.entity.model;

import com.entity.ShoufeixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 收费信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShoufeixinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 收费名目
     */
    private String mingmuName;


    /**
     * 收费类型
     */
    private Integer shoufeixinxiTypes;


    /**
     * 预售金额
     */
    private Double shoufeixinxiYushouMoney;


    /**
     * 实收金额
     */
    private Double shoufeixinxiShishouMoney;


    /**
     * 收费时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shoufeiTime;


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
	 * 获取：收费名目
	 */
    public String getMingmuName() {
        return mingmuName;
    }


    /**
	 * 设置：收费名目
	 */
    public void setMingmuName(String mingmuName) {
        this.mingmuName = mingmuName;
    }
    /**
	 * 获取：收费类型
	 */
    public Integer getShoufeixinxiTypes() {
        return shoufeixinxiTypes;
    }


    /**
	 * 设置：收费类型
	 */
    public void setShoufeixinxiTypes(Integer shoufeixinxiTypes) {
        this.shoufeixinxiTypes = shoufeixinxiTypes;
    }
    /**
	 * 获取：预售金额
	 */
    public Double getShoufeixinxiYushouMoney() {
        return shoufeixinxiYushouMoney;
    }


    /**
	 * 设置：预售金额
	 */
    public void setShoufeixinxiYushouMoney(Double shoufeixinxiYushouMoney) {
        this.shoufeixinxiYushouMoney = shoufeixinxiYushouMoney;
    }
    /**
	 * 获取：实收金额
	 */
    public Double getShoufeixinxiShishouMoney() {
        return shoufeixinxiShishouMoney;
    }


    /**
	 * 设置：实收金额
	 */
    public void setShoufeixinxiShishouMoney(Double shoufeixinxiShishouMoney) {
        this.shoufeixinxiShishouMoney = shoufeixinxiShishouMoney;
    }
    /**
	 * 获取：收费时间
	 */
    public Date getShoufeiTime() {
        return shoufeiTime;
    }


    /**
	 * 设置：收费时间
	 */
    public void setShoufeiTime(Date shoufeiTime) {
        this.shoufeiTime = shoufeiTime;
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
