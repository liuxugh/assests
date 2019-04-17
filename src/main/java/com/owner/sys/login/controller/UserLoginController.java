package com.owner.sys.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.owner.core.util.ASSESTSLog;
import com.owner.core.util.CommonUtil;
import com.owner.core.util.MD5Util;
import com.owner.sys.login.entity.UserEntity;
import com.owner.sys.login.service.UserService;

@Controller
public class UserLoginController {
	//log
	private static final Logger log = LoggerFactory.getLogger(UserLoginController.class);
	
	private static String INDEX_PAGE = "/index"; // 首页页面
	private static String LOGIN_PAGE = "/login"; // 登录页面
	private static String CHANGE_PASS_PAGE = "/changePass";//修改密码页面
	
	@Autowired
	private UserService userService;

	
	@RequestMapping(value = "/loginPage",method=RequestMethod.GET)
	public String LoginPage() {
		ASSESTSLog.info(log, "welcome to assests manage system");
		return LOGIN_PAGE;
	}
	
	@RequestMapping(value="userLogin",method=RequestMethod.POST)
	public String login(UserEntity userlogin,Model model,HttpServletRequest request) {
		ASSESTSLog.info(log, "用户登录"+userlogin.getUserName());
		UserEntity user = userService.getUser(userlogin.getUserName());
		if(CommonUtil.isEmpty(user)) {
			model.addAttribute("userLoginError", "用户名密码错误，请重新登录");
			return LOGIN_PAGE;
		}
		String userPwd = MD5Util.string2MD5(userlogin.getUserPass());
		if(userPwd.equals(user.getUserPass())) {
			if("1".equals(user.getUserStatus())) {
				request.getSession().setAttribute("loginUser", user);
				return "redirect:/indexPage";
			} else {
					model.addAttribute("userLoginError","该用户已被禁用，请重新登录");
			}
		}else {
			model.addAttribute("userLoginError", "用户名密码错误，请重新登录");
		}
		return LOGIN_PAGE;
	}
}
