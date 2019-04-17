package com.owner.sys.login.service.impl;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owner.core.util.ASSESTSLog;
import com.owner.core.util.CommonUtil;
import com.owner.sys.login.entity.UserEntity;
import com.owner.sys.login.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	public UserEntity getUser(String userName) {
		if(StringUtils.isEmpty(userName)){
			return null;
		}
		UserEntity user = sqlSession.selectOne("user.query_user_info", userName);
		if(CommonUtil.isNotEmpty(user)){
			ASSESTSLog.info(log, "query user success!");
			return user;
		}
		return null;
	}

}
