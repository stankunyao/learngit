/**
 * 软件著作权：北京东方正通科技有限公司
 *
 * 系统名称：值守应急系统产品（themis）
 *
 * 文件名称：DictAction.java
 *
 * 工程名：  themis_V1.0
 *		 
 * 版本历史：2008-11-09
 * 
 * 
 */
package com.harmony.themis.commons.web.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.harmony.core.user.online.domain.OnlineUser;
import com.harmony.core.user.online.service.impl.DefaultOnlineUserService;
import com.harmony.themis.commons.MessageConstants;
import com.harmony.themis.commons.bean.LoginUserInfo;
import com.harmony.themis.commons.util.ListRange;


public class OnlineUserAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1693046889554781322L;

	protected final Log logger = LogFactory.getLog(getClass());


	/**
	 * 取得。
	 * 
	 */
	public void getOnlineUser() {

		try {
			//取得在线人员的信息列表
			DefaultOnlineUserService online = new DefaultOnlineUserService();
			Map map = online.getUsers();
			
//			Set set = map.keySet();
//			Iterator it = set.iterator();
//			while (it.hasNext()) {
//				String str = (String) it.next();
//				OnlineUser onlineUser = (OnlineUser) map.get(str);
//				LoginUserInfo  userInfo = new LoginUserInfo();
//				userInfo.setUserId(onlineUser.getUserId());
//				list.add(userInfo);
//			}
//			//System.out.println("=====================:"+map.toString());
			this.outJsonByMsg(map);		
		} catch (Exception e) {	
			this.outJsonByErrorMsg(e);	
		} 
	}
}

