package com.harmony.themis.commons.web.form;

import java.util.List;

public class TreeForm {
	/**
	  * qtip
	  */
	 private String qtip;
	 /**
	  * oText
	  */
	 private String backText;
	 
	 /**
	  * 组织关系ID
	  */
	 private String id;
	 
	 /**
	  * 组织ID
	  */
	 private String orgId;
	 
	 /**
	  * 组织名称
	  */
	 private String orgName;
	 
	 /**
	  * 人员ID
	  */
	 private String perId;
	 
	 /**
	  * 用户ID
	  */
	 private String userId;
	 
	 /**
	  * 父组织关系ID
	  */
	 private String parentId;
	 
	 /**
	  * 是否可以发送
	  */
	 private String sendFlag;
	 /**
	  * 文本
	  */
	 private String text;
	 
	 /**
	  * 是否是叶子结点
	  */
	 private boolean leaf;
	 
	 /**
	  * 是否为业务使用单位
	  */
	 private boolean systemFlag;
	 
	 /**
	  * 状态值
	  */
	 private String status;
	 
	 /**
	  * 样式表
	  */
	 private String iconCls;
	 
	 /**
	  * 排序
	  */
	 private Double sequence;
	 
	 /**
	  * 是否包含复选框
	  */
	 private boolean checked = false;
	 
	 /**
	  * 是否展开
	  */
	 private boolean expanded = false;
	 
	 /**
	  * 是否为引用关系
	  */
	 private boolean ref = false;
	 
	 /**
	  * 是否为领导
	  */
	 private boolean leader = false;
	 
	 /**
	  * 是否为实际单位
	  */
	 private boolean orgFlag = false;
	 
	 /**
	  * 机构级别(0:下级,1:中间级,2:顶级)
	  */
	 private String level;

	 /**
	  * 子树
	  */
	 private List<TreeForm> children;

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public List<TreeForm> getChildren() {
		return children;
	}

	public void setChildren(List<TreeForm> children) {
		this.children = children;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	/**
	 * @return the iconCls
	 */
	public String getIconCls() {
		return iconCls;
	}

	/**
	 * @param iconCls the iconCls to set
	 */
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}		


	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the orgId
	 */
	public String getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId the orgId to set
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	
	
	public Double getSequence() {
		return sequence;
	}

	public void setSequence(Double sequence) {
		this.sequence = sequence;
	}
	
	public String getPerId() {
		return perId;
	}

	public void setPerId(String perId) {
		this.perId = perId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	

	/**
	 * 比较两个对象是否相同，主键相同则两个对象相同
	 */
    public boolean equals(Object obj) {
    	if(obj == null || !(obj instanceof TreeForm)) {
    		return false;
    	}else {
    		return this.getId().equals(((TreeForm)obj).getId());
    	}
   }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isRef() {
		return ref;
	}

	public void setRef(boolean ref) {
		this.ref = ref;
	}

	public boolean isLeader() {
		return leader;
	}

	public void setLeader(boolean leader) {
		this.leader = leader;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getSendFlag() {
		return sendFlag;
	}

	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
	}

	public boolean isOrgFlag() {
		return orgFlag;
	}

	public void setOrgFlag(boolean orgFlag) {
		this.orgFlag = orgFlag;
	}

	public boolean isSystemFlag() {
		return systemFlag;
	}

	public void setSystemFlag(boolean systemFlag) {
		this.systemFlag = systemFlag;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getQtip() {
		return qtip;
	}

	public void setQtip(String qtip) {
		this.qtip = qtip;
	}

	public String getBackText() {
		return backText;
	}

	public void setBackText(String backText) {
		this.backText = backText;
	}
 
}
