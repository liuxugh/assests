package com.owner.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.owner.core.util.ASSESTSLog;

public class LoginInterceptor implements HandlerInterceptor {
	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		//CauxghLog.info(log, "登录过滤验证");
		// TODO 暂时注释掉，拦截器配好后放开
		/*UserEntity userLogin = (UserEntity) request.getSession().getAttribute(CommonCodeConstant.LOGIN_SYS_USER);
		if (!CommonUtil.isEmpty(userLogin)) {
			return true;
		}*/
		ASSESTSLog.info(log, "未登录的访问请求");
		response.sendRedirect(request.getContextPath() + "/loginPage");
		return false;
	}

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
