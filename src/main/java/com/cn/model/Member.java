package com.cn.model;

import com.cn.base.BasicModel;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @ClassName Member
 * @Description TODO 
 * @Author hiwower@gmail.com
 * @Date Sun Oct 22 15:44:06 CST 2017
 */

public class Member extends BasicModel {
	// SerialVersionUID
	private static final long serialVersionUID = 15086582468443L;
	// 主键
	private Integer id;
	// 用户名
	@NotNull(message = "用户名不能为空")
	private String userName;
	// 收入
	@DecimalMin(value = "1000.00", message = "工资必须大于1000.00")
	@DecimalMax(value = "10000.00", message = "工资必须小于10000.00")
	@NumberFormat(pattern = "#,###.##")
	private Integer salary;
	// 密码
	@Size(min = 2, max = 6, message = "长度是2-6之间")
	private String password;
	// 电话
	@Pattern(regexp = "1[3|4|5|8][0-9]\\d{4,8}")
	private String phone;

	public Member() { }

	public Member(Integer id, String userName, Integer salary, String password, String phone) {
		super();
		this.id = id;
		this.userName = userName;
		this.salary = salary;
		this.password = password;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}

