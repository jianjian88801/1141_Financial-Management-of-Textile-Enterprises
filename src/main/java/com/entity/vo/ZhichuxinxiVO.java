package com.entity.vo;

import com.entity.ZhichuxinxiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 支出信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhichuxinxi")
public class ZhichuxinxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 支出名目
     */

    @TableField(value = "zhichuxinxi_mingmu_name")
    private String zhichuxinxiMingmuName;


    /**
     * 支出类型
     */

    @TableField(value = "zhichuxinxi_types")
    private Integer zhichuxinxiTypes;


    /**
     * 支出金额
     */

    @TableField(value = "zhichuxinxi_money")
    private Double zhichuxinxiMoney;


    /**
     * 备注
     */

    @TableField(value = "zhichu_content")
    private String zhichuContent;


    /**
     * 支出时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "zhichuxinxi_time")
    private Date zhichuxinxiTime;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：支出名目
	 */
    public String getZhichuxinxiMingmuName() {
        return zhichuxinxiMingmuName;
    }


    /**
	 * 获取：支出名目
	 */

    public void setZhichuxinxiMingmuName(String zhichuxinxiMingmuName) {
        this.zhichuxinxiMingmuName = zhichuxinxiMingmuName;
    }
    /**
	 * 设置：支出类型
	 */
    public Integer getZhichuxinxiTypes() {
        return zhichuxinxiTypes;
    }


    /**
	 * 获取：支出类型
	 */

    public void setZhichuxinxiTypes(Integer zhichuxinxiTypes) {
        this.zhichuxinxiTypes = zhichuxinxiTypes;
    }
    /**
	 * 设置：支出金额
	 */
    public Double getZhichuxinxiMoney() {
        return zhichuxinxiMoney;
    }


    /**
	 * 获取：支出金额
	 */

    public void setZhichuxinxiMoney(Double zhichuxinxiMoney) {
        this.zhichuxinxiMoney = zhichuxinxiMoney;
    }
    /**
	 * 设置：备注
	 */
    public String getZhichuContent() {
        return zhichuContent;
    }


    /**
	 * 获取：备注
	 */

    public void setZhichuContent(String zhichuContent) {
        this.zhichuContent = zhichuContent;
    }
    /**
	 * 设置：支出时间
	 */
    public Date getZhichuxinxiTime() {
        return zhichuxinxiTime;
    }


    /**
	 * 获取：支出时间
	 */

    public void setZhichuxinxiTime(Date zhichuxinxiTime) {
        this.zhichuxinxiTime = zhichuxinxiTime;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
