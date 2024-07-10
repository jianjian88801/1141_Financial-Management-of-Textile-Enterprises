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
 * 报销信息
 *
 * @author 
 * @email
 */
@TableName("baoxiao")
public class BaoxiaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BaoxiaoEntity() {

	}

	public BaoxiaoEntity(T t) {
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
     * 申请人
     */
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 报销名目
     */
    @TableField(value = "baoxiao_name")

    private String baoxiaoName;


    /**
     * 报销类型
     */
    @TableField(value = "baoxiao_types")

    private Integer baoxiaoTypes;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 报销金额
     */
    @TableField(value = "baoxiao_money")

    private Double baoxiaoMoney;


    /**
     * 报销详情
     */
    @TableField(value = "baoxiao_content")

    private String baoxiaoContent;


    /**
     * 是否同意
     */
    @TableField(value = "baoxiao_yesno_types")

    private Integer baoxiaoYesnoTypes;


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
	 * 设置：申请人
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 获取：申请人
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：报销名目
	 */
    public String getBaoxiaoName() {
        return baoxiaoName;
    }


    /**
	 * 获取：报销名目
	 */

    public void setBaoxiaoName(String baoxiaoName) {
        this.baoxiaoName = baoxiaoName;
    }
    /**
	 * 设置：报销类型
	 */
    public Integer getBaoxiaoTypes() {
        return baoxiaoTypes;
    }


    /**
	 * 获取：报销类型
	 */

    public void setBaoxiaoTypes(Integer baoxiaoTypes) {
        this.baoxiaoTypes = baoxiaoTypes;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：报销金额
	 */
    public Double getBaoxiaoMoney() {
        return baoxiaoMoney;
    }


    /**
	 * 获取：报销金额
	 */

    public void setBaoxiaoMoney(Double baoxiaoMoney) {
        this.baoxiaoMoney = baoxiaoMoney;
    }
    /**
	 * 设置：报销详情
	 */
    public String getBaoxiaoContent() {
        return baoxiaoContent;
    }


    /**
	 * 获取：报销详情
	 */

    public void setBaoxiaoContent(String baoxiaoContent) {
        this.baoxiaoContent = baoxiaoContent;
    }
    /**
	 * 设置：是否同意
	 */
    public Integer getBaoxiaoYesnoTypes() {
        return baoxiaoYesnoTypes;
    }


    /**
	 * 获取：是否同意
	 */

    public void setBaoxiaoYesnoTypes(Integer baoxiaoYesnoTypes) {
        this.baoxiaoYesnoTypes = baoxiaoYesnoTypes;
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
        return "Baoxiao{" +
            "id=" + id +
            ", yuangongId=" + yuangongId +
            ", baoxiaoName=" + baoxiaoName +
            ", baoxiaoTypes=" + baoxiaoTypes +
            ", insertTime=" + insertTime +
            ", baoxiaoMoney=" + baoxiaoMoney +
            ", baoxiaoContent=" + baoxiaoContent +
            ", baoxiaoYesnoTypes=" + baoxiaoYesnoTypes +
            ", createTime=" + createTime +
        "}";
    }
}
