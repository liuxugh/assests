package com.owner.sys.login.service;

import com.owner.sys.login.entity.UserEntity;

public interface UserService {

	/** 
	* @Description 方法描述: 通过用户名查询用户 <pre>
	* @param  参数说明: <pre>    
	* @return  返回值类型: UserEntity <pre>  
	* @author 作者:  刘旭 <pre>
	* @date 时间: Apr 15, 2019 12:15:51 AM <pre> 
	* @throws 异常: <pre>
	*/
	public UserEntity getUser(String userName);
}
