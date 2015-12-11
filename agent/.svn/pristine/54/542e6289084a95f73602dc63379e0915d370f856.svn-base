package com.harmony.themis.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
// default package

import org.hibernate.annotations.GenericGenerator;



/**
 * SystemConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="HM_SYSTEM_CONFIG")
public class SystemConfig  implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2827001692616443779L;

	// Fields    
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")	
     private String id;
	
	/**
	 * 系统名称
	 */
    @Column(name = "SYSTEM_NAME")
     private String systemName;

	/**
	 * 允许上传的最大文件大小
	 */
    @Column(name = "ALLOW_MAXIMUMSIZE")
     private Long allowMaximumSize;   
 
	/**
	 * 允许上传的文件类型
	 */
	@Transient
     private String allowFileTypes;   
 
    /**
     * 声音提醒文件名称
     */
	@Transient
	private String awakeFileName;   
	
    /**
     * 声音提醒文件路径
     */
	@Transient
	private String awakeFilePath;   
    
    /**
     * 普通消息间隔时间
     */
    @Column(name = "AWAKE_INTERVAL")
     private Integer awakeInterval;
    
    /**
     * 在线状态间隔时间
     */
    @Column(name = "ONLINE_INTERVAL")
     private Integer onlineInterval;
    
    /**
     * 聊天消息间隔时间
     */
    @Column(name = "CHAT_INTERVAL")
     private Integer chatInterval;
    
    /**
     * 按时发送时间基准
     */
    @Column(name = "ON_SCHEDULE")
     private Integer onSchedule;
        
    /**
     * 聊天组织简称标记
     */
    @Column(name = "CHAT_SHORT_FLAG")
    private boolean chatShortFlag;
    
    /**
     * 值班组织简称标记
     */
    @Column(name = "DUTY_SHORT_FLAG")
    private boolean dutyShortFlag;
    
    /**
     * 电话本组织简称标记
     */
    @Column(name = "PHONE_SHORT_FLAG")
    private boolean phoneShortFlag;
    
    /**
     * 组织维护简称标记
     */
    @Column(name = "ADMIN_SHORT_FLAG")
    private boolean adminShortFlag;
    
    /**
     * 是否使用值班验证码(0:全不使用 1:基层 2：中间级 4:顶级)
     */
    @Column(name = "USE_VALIDATE_CODE")
    private Integer useValidateCode; 
    
    /**
     * 上传超时时间
     */
    @Column(name = "UPLOAD_TIMEOUT")
     private Integer uploadTimeout;
    
    /**
     * 当天开始时间
     */
    @Column(name = "DAY_STARTTIME")
     private String dayStartTime;
    
    /**
     * 当天结束时间
     */
    @Column(name = "DAY_ENDTIME")
     private String dayEndTime;

    /**
     * 系统使用的界面主题
     */
     private String theme;

    /**
     * 地图定位名称
     */
    @Column(name = "GIS_NAME")
     private String gisName;
    
    /**
     * 地图定位地址
     */
    @Column(name = "GIS_ADDRESS")
     private String gisAddress;
    
    /**
     * 地图定位API密钥
     */
    @Column(name = "GIS_API_KEY")
     private String gisApiKey;
    
    /**
     * 地图默认经度
     */
    @Column(name = "GIS_LONG")
     private double gisLong;
    
    /**
     * 地图默认纬度
     */
    @Column(name = "GIS_LAT")
     private double gisLat;
    
    
    /**
     * 是否包含视频模块
     */
    @Column(name = "VIDEO_FLAG")
     private boolean videoFlag;
    
    /**
     * 视频服务器IP
     */
    @Column(name = "VIDEO_IP")
     private String videoIp;
    
    /**
     * 视频服务器UDP端口
     */
    @Column(name = "VIDEO_UDP_PORT")
     private String videoUdpPort;   
     
    /**
     * 视频应用服务器地址
     */
    @Column(name = "VIDEO_APP_URL")
    private String videoAppUrl;  
    
    /**
     * 是否启用短信功能
     */
    @Column(name = "SMS_FLAG")
     private boolean smsFlag;
    
    /**
     * 短信客户编号
     */
    @Column(name = "SMS_CUSTOM_NUM")   
	private String smsCustomNum;
    
    /**
     * 短信客户编号扩展
     */
    @Column(name = "SMS_CUSTOM_NUM_EXT")   
	private String smsCustomNumExt;
    
    /**
     * 短信接口密码
     */
    @Column(name = "SMS_INTERFACE_PWD")   
	private String smsInterfacePwd;
    
    /**
     * 短信WSDL地址
     */
    @Column(name = "SMS_WSDL_URL")   
	private String smsWsdlUrl;
    
    /**
     * 是否启用短信功能(new)
     */
    @Column(name = "SMS2_FLAG")   
	private boolean sms2Flag;
    
    /**
     * 短信数据库地址(new)
     */
    @Column(name = "SMS2_DB_ADDRESS")   
	private String sms2DbAddress;
    
    /**
     * 短信数据库名称(new)
     */
    @Column(name = "SMS2_DB_NAME")   
	private String sms2DbName;
    
    /**
     * 短信接口编码(new)
     */
    @Column(name = "SMS2_API_ID")   
	private String sms2ApiId;
    
    /**
     * 短信接口登录名(new)
     */
    @Column(name = "SMS2_API_NAME")   
	private String sms2ApiName;
    
    /**
     * 短信接口登陆密码(new)
     */
    @Column(name = "SMS2_API_PASSWORD")   
	private String sms2ApiPassword;
    
    // Constructors

    /** default constructor */
    public SystemConfig() {
    }

	/** minimal constructor */
    public SystemConfig(String systemName) {
        this.systemName = systemName;
    }
    
    /** full constructor */
    public SystemConfig(String systemName, String allowFiletype, Integer awakeInterval, String gisName, String gisAddress, String gisApiKey) {
        this.systemName = systemName;
        this.awakeInterval = awakeInterval;
        this.gisName = gisName;
        this.gisAddress = gisAddress;
        this.gisApiKey = gisApiKey;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getSystemName() {
        return this.systemName;
    }
    
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public Integer getAwakeInterval() {
        return this.awakeInterval;
    }
    
    public void setAwakeInterval(Integer awakeInterval) {
        this.awakeInterval = awakeInterval;
    }

    public String getGisName() {
        return this.gisName;
    }
    
    public void setGisName(String gisName) {
        this.gisName = gisName;
    }

    public String getGisAddress() {
        return this.gisAddress;
    }
    
    public void setGisAddress(String gisAddress) {
        this.gisAddress = gisAddress;
    }

    public String getGisApiKey() {
        return this.gisApiKey;
    }
    
    public void setGisApiKey(String gisApiKey) {
        this.gisApiKey = gisApiKey;
    }
   
	
	public Long getAllowMaximumSize() {
		return allowMaximumSize;
	}

	public void setAllowMaximumSize(Long allowMaximumSize) {
		this.allowMaximumSize = allowMaximumSize;
	}
	
	public String getAwakeFileName() {
		return awakeFileName;
	}

	public void setAwakeFileName(String awakeFileName) {
		this.awakeFileName = awakeFileName;
	}

	/**
	 * 比较两个对象是否相同，主键相同则两个对象相同
	 */
    public boolean equals(Object obj) {
    	if(obj == null || !(obj instanceof SystemConfig)) {
    		return false;
    	}else {
    		return this.getId().equals(((SystemConfig)obj).getId());
    	}
   }

	public Integer getUploadTimeout() {
		return uploadTimeout;
	}

	public void setUploadTimeout(Integer uploadTimeout) {
		this.uploadTimeout = uploadTimeout;
	}

	public String getAwakeFilePath() {
		return awakeFilePath;
	}

	public void setAwakeFilePath(String awakeFilePath) {
		this.awakeFilePath = awakeFilePath;
	}

	public String getAllowFileTypes() {
		return allowFileTypes;
	}

	public void setAllowFileTypes(String allowFileTypes) {
		this.allowFileTypes = allowFileTypes;
	}

	public String getDayStartTime() {
		return dayStartTime;
	}

	public void setDayStartTime(String dayStartTime) {
		this.dayStartTime = dayStartTime;
	}

	public String getDayEndTime() {
		return dayEndTime;
	}

	public void setDayEndTime(String dayEndTime) {
		this.dayEndTime = dayEndTime;
	}

	public Integer getOnlineInterval() {
		return onlineInterval;
	}

	public void setOnlineInterval(Integer onlineInterval) {
		this.onlineInterval = onlineInterval;
	}

	public Integer getChatInterval() {
		return chatInterval;
	}

	public void setChatInterval(Integer chatInterval) {
		this.chatInterval = chatInterval;
	}

	public boolean isChatShortFlag() {
		return chatShortFlag;
	}

	public void setChatShortFlag(boolean chatShortFlag) {
		this.chatShortFlag = chatShortFlag;
	}

	public boolean isDutyShortFlag() {
		return dutyShortFlag;
	}

	public void setDutyShortFlag(boolean dutyShortFlag) {
		this.dutyShortFlag = dutyShortFlag;
	}

	public boolean isAdminShortFlag() {
		return adminShortFlag;
	}

	public void setAdminShortFlag(boolean adminShortFlag) {
		this.adminShortFlag = adminShortFlag;
	}

	public boolean isPhoneShortFlag() {
		return phoneShortFlag;
	}

	public void setPhoneShortFlag(boolean phoneShortFlag) {
		this.phoneShortFlag = phoneShortFlag;
	}


	public Integer getUseValidateCode() {
		return useValidateCode;
	}

	public void setUseValidateCode(Integer useValidateCode) {
		this.useValidateCode = useValidateCode;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Integer getOnSchedule() {
		return onSchedule;
	}

	public void setOnSchedule(Integer onSchedule) {
		this.onSchedule = onSchedule;
	}

	public double getGisLong() {
		return gisLong;
	}

	public void setGisLong(double gisLong) {
		this.gisLong = gisLong;
	}

	public double getGisLat() {
		return gisLat;
	}

	public void setGisLat(double gisLat) {
		this.gisLat = gisLat;
	}

	public boolean isVideoFlag() {
		return videoFlag;
	}

	public void setVideoFlag(boolean videoFlag) {
		this.videoFlag = videoFlag;
	}

	public String getVideoIp() {
		return videoIp;
	}

	public void setVideoIp(String videoIp) {
		this.videoIp = videoIp;
	}

	public String getVideoUdpPort() {
		return videoUdpPort;
	}

	public void setVideoUdpPort(String videoUdpPort) {
		this.videoUdpPort = videoUdpPort;
	}

	public String getVideoAppUrl() {
		return videoAppUrl;
	}

	public void setVideoAppUrl(String videoAppUrl) {
		this.videoAppUrl = videoAppUrl;
	}

	public String getSmsCustomNum() {
		return smsCustomNum;
	}

	public void setSmsCustomNum(String smsCustomNum) {
		this.smsCustomNum = smsCustomNum;
	}

	public String getSmsCustomNumExt() {
		return smsCustomNumExt;
	}

	public void setSmsCustomNumExt(String smsCustomNumExt) {
		this.smsCustomNumExt = smsCustomNumExt;
	}

	public String getSmsInterfacePwd() {
		return smsInterfacePwd;
	}

	public void setSmsInterfacePwd(String smsInterfacePwd) {
		this.smsInterfacePwd = smsInterfacePwd;
	}

	public String getSmsWsdlUrl() {
		return smsWsdlUrl;
	}

	public void setSmsWsdlUrl(String smsWsdlUrl) {
		this.smsWsdlUrl = smsWsdlUrl;
	}

	public boolean isSmsFlag() {
		return smsFlag;
	}

	public void setSmsFlag(boolean smsFlag) {
		this.smsFlag = smsFlag;
	}

	public String getSms2ApiId() {
		return sms2ApiId;
	}

	public void setSms2ApiId(String sms2ApiId) {
		this.sms2ApiId = sms2ApiId;
	}

	public String getSms2ApiName() {
		return sms2ApiName;
	}

	public void setSms2ApiName(String sms2ApiName) {
		this.sms2ApiName = sms2ApiName;
	}

	public String getSms2ApiPassword() {
		return sms2ApiPassword;
	}

	public void setSms2ApiPassword(String sms2ApiPassword) {
		this.sms2ApiPassword = sms2ApiPassword;
	}

	public String getSms2DbAddress() {
		return sms2DbAddress;
	}

	public void setSms2DbAddress(String sms2DbAddress) {
		this.sms2DbAddress = sms2DbAddress;
	}

	public String getSms2DbName() {
		return sms2DbName;
	}

	public void setSms2DbName(String sms2DbName) {
		this.sms2DbName = sms2DbName;
	}

	public boolean isSms2Flag() {
		return sms2Flag;
	}

	public void setSms2Flag(boolean sms2Flag) {
		this.sms2Flag = sms2Flag;
	}


}