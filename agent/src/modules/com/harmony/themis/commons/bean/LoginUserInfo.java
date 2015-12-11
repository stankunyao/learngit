package com.harmony.themis.commons.bean;

/**
 * 用户信息
 * @author Administrator
 *
 */
public class LoginUserInfo  implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4800916185189511587L;
	// 用户ID
	private String userId;
	// 人员ID
	private String perId;
	// 人员组织关系ID
	private String personRelaId;
	// 人员名称
	private String perName;
	// 电话
	private String phone;
	// 组织ID
	private String orgId;
	// 组织全称
	private String orgName;
	
	// 组织编码
	private String orgCode;
	
	// 组织简称
	private String orgShortName;
	
	// 打印单位名字
	private String printOrgname;
	
	// 事发区域规范名称
	private String areaName;
	
	// 舆情信息关键字
	private String opinonKeyword;
	
	// 是否是超级管理员
	private boolean adminFlag;
	
	// 是否有上级
	private boolean hasSuperior;
	
	// 是否有下级
	private boolean hasJunior;
	
	// 是否为公用值班账号
	private boolean publicFlag;
	
	// 是否为值班状态（即以验证码登录）
	private boolean dutyFlag;
	
    // 是否属于多个单位
    private boolean multiOrgFlag;	
	
	// 上级组织ID数组
	private String[] superiorOrgIds;
	
	// 下级组织ID数组
	private String[] juniorOrgIds;
	
	// 同级组织ID数组
	private String[] brotherOrgIds;

	// 下级组织ID数组
	private String subOrgIds;
	
	//下级组织ID数组
	private String supOrgIds;
	
	// 同级组织ID数组
	private String sameGradeOrgIds;	
	
	private String upRight;
	
	private String sameRight;
	
	private String downRight;
	
	private String pdaPhoneNumber;
	public String getPerId() {
		return perId;
	}

	public void setPerId(String perId) {
		this.perId = perId;
	}

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgShortName() {
		return orgShortName;
	}

	public void setOrgShortName(String orgShortName) {
		this.orgShortName = orgShortName;
	}

	public boolean isHasSuperior() {
		return hasSuperior;
	}

	public void setHasSuperior(boolean hasSuperior) {
		this.hasSuperior = hasSuperior;
	}

	public boolean isHasJunior() {
		return hasJunior;
	}

	public void setHasJunior(boolean hasJunior) {
		this.hasJunior = hasJunior;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String[] getSuperiorOrgIds() {
		return superiorOrgIds;
	}

	public void setSuperiorOrgIds(String[] superiorOrgIds) {
		this.superiorOrgIds = superiorOrgIds;
	}

	public String[] getJuniorOrgIds() {
		return juniorOrgIds;
	}

	public void setJuniorOrgIds(String[] juniorOrgIds) {
		this.juniorOrgIds = juniorOrgIds;
	}

	public String getPersonRelaId() {
		return personRelaId;
	}

	public void setPersonRelaId(String personRelaId) {
		this.personRelaId = personRelaId;
	}

	public boolean isAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(boolean adminFlag) {
		this.adminFlag = adminFlag;
	}

	public boolean isPublicFlag() {
		return publicFlag;
	}

	public void setPublicFlag(boolean publicFlag) {
		this.publicFlag = publicFlag;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isDutyFlag() {
		return dutyFlag;
	}

	public void setDutyFlag(boolean dutyFlag) {
		this.dutyFlag = dutyFlag;
	}

	public String[] getBrotherOrgIds() {
		return brotherOrgIds;
	}

	public void setBrotherOrgIds(String[] brotherOrgIds) {
		this.brotherOrgIds = brotherOrgIds;
	}

	public String getSubOrgIds() {
		return subOrgIds;
	}

	public void setSubOrgIds(String subOrgIds) {
		this.subOrgIds = subOrgIds;
	}

	public String getSameGradeOrgIds() {
		return sameGradeOrgIds;
	}

	public void setSameGradeOrgIds(String sameGradeOrgIds) {
		this.sameGradeOrgIds = sameGradeOrgIds;
	}

	public String getSupOrgIds() {
		return supOrgIds;
	}

	public void setSupOrgIds(String supOrgIds) {
		this.supOrgIds = supOrgIds;
	}

	public String getDownRight() {
		return downRight;
	}

	public void setDownRight(String downRight) {
		this.downRight = downRight;
	}

	public String getSameRight() {
		return sameRight;
	}

	public void setSameRight(String sameRight) {
		this.sameRight = sameRight;
	}

	public String getUpRight() {
		return upRight;
	}

	public void setUpRight(String upRight) {
		this.upRight = upRight;
	}

	public boolean isMultiOrgFlag() {
		return multiOrgFlag;
	}

	public void setMultiOrgFlag(boolean multiOrgFlag) {
		this.multiOrgFlag = multiOrgFlag;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getOpinonKeyword() {
		return opinonKeyword;
	}

	public void setOpinonKeyword(String opinonKeyword) {
		this.opinonKeyword = opinonKeyword;
	}

	public String getPrintOrgname() {
		return printOrgname;
	}

	public void setPrintOrgname(String printOrgname) {
		this.printOrgname = printOrgname;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getPdaPhoneNumber() {
		return pdaPhoneNumber;
	}

	public void setPdaPhoneNumber(String pdaPhoneNumber) {
		this.pdaPhoneNumber = pdaPhoneNumber;
	}
    

}
