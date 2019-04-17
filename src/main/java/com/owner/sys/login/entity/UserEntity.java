package com.owner.sys.login.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="tbl_user_login")
public class UserEntity {
	
	/**
	 * id
	 */
	@Id
	@Column(name="USER_ID")
	private String userId;
	
	/**
     * 用户名
     */
	@Column(name="USER_ACCOUNT")
	private String userAccount;
	/**
     * 登录名
     */
	@Column(name="USER_NAME")
	private String userName;
	
	/**
     * 密码
     */
	@Column(name="USER_PASS")
	private String userPass;
	
	/**
     * 用户状态
     */
	@Column(name="USER_STATUS")
	private String userStatus;
	
	/**
     * 电话
     */
	@Column(name="TELPHONE")
	private String telPhone;
	
	/**
     * 邮箱
     */
	@Column(name="EMAIL")
	private String Email;
	
	/**
     * 性别
     */
	@Column(name="SEX")
	private int sex;
	
	/**
	 * 创建人id
	 */
	@Column(name="CREATEID")
	private String createID;
	
	/**
	 * 更新人id
	 */
	@Column(name="UPDATEID")
	private String updateID;
	
	/**
	 * 创建时间
	 */
	@Column(name="CREATE_TIME")
	private Date createTime;
	/**
	 * 更新时间
	 */
	@Column(name="UPDATE_TIME")
	private Date updateTime;
	/**
	 * 所属部门
	 */
	@Column(name="DEPARTMENT_ID")
	private String departmentId;
	
	
	/**
	 * 角色
	 */
	@Column(name="ROLE")
	private String role;
	
	/**
	 * 部门名称
	 */
	@Column(name="DEPARTMENT_NAME")
	private String departmentName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getCreateID() {
		return createID;
	}

	public void setCreateID(String createID) {
		this.createID = createID;
	}

	public String getUpdateID() {
		return updateID;
	}

	public void setUpdateID(String updateID) {
		this.updateID = updateID;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
