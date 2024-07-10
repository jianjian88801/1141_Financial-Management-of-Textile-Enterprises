package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 收费信息
 *
 * @author 
 * @email
 */
@TableName("shoufeixinxi")
public class ShoufeixinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShoufeixinxiEntity() {

	}

	public ShoufeixinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Shoufeixinxi{" +
            "id=" + id +
            ", mingmuName=" + mingmuName +
            ", shoufeixinxiTypes=" + shoufeixinxiTypes +
            ", shoufeixinxiYushouMoney=" + shoufeixinxiYushouMoney +
            ", shoufeixinxiShishouMoney=" + shoufeixinxiShishouMoney +
            ", shoufeiTime=" + shoufeiTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
