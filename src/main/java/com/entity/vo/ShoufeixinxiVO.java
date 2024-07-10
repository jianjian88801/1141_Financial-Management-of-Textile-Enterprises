package com.entity.vo;

import com.entity.ShoufeixinxiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 收费信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shoufeixinxi")
public class ShoufeixinxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 收费名目
     */

    @TableField(value = "mingmu_name")
    private String mingmuName;


    /**
     * 收费类型
     */

    @TableField(value = "shoufeixinxi_types")
    private Integer shoufeixinxiTypes;


    /**
     * 预售金额
     */

    @TableField(value = "shoufeixinxi_yushou_money")
    private Double shoufeixinxiYushouMoney;


    /**
     * 实收金额
     */

    @TableField(value = "shoufeixinxi_shishou_money")
    private Double shoufeixinxiShishouMoney;


    /**
     * 收费时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shoufei_time")
    private Date shoufeiTime;


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
	 * 设置：收费名目
	 */
    public String getMingmuName() {
        return mingmuName;
    }


    /**
	 * 获取：收费名目
	 */

    public void setMingmuName(String mingmuName) {
        this.mingmuName = mingmuName;
    }
    /**
	 * 设置：收费类型
	 */
    public Integer getShoufeixinxiTypes() {
        return shoufeixinxiTypes;
    }


    /**
	 * 获取：收费类型
	 */

    public void setShoufeixinxiTypes(Integer shoufeixinxiTypes) {
        this.shoufeixinxiTypes = shoufeixinxiTypes;
    }
    /**
	 * 设置：预售金额
	 */
    public Double getShoufeixinxiYushouMoney() {
        return shoufeixinxiYushouMoney;
    }


    /**
	 * 获取：预售金额
	 */

    public void setShoufeixinxiYushouMoney(Double shoufeixinxiYushouMoney) {
        this.shoufeixinxiYushouMoney = shoufeixinxiYushouMoney;
    }
    /**
	 * 设置：实收金额
	 */
    public Double getShoufeixinxiShishouMoney() {
        return shoufeixinxiShishouMoney;
    }


    /**
	 * 获取：实收金额
	 */

    public void setShoufeixinxiShishouMoney(Double shoufeixinxiShishouMoney) {
        this.shoufeixinxiShishouMoney = shoufeixinxiShishouMoney;
    }
    /**
	 * 设置：收费时间
	 */
    public Date getShoufeiTime() {
        return shoufeiTime;
    }


    /**
	 * 获取：收费时间
	 */

    public void setShoufeiTime(Date shoufeiTime) {
        this.shoufeiTime = shoufeiTime;
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
