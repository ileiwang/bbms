package cc.ileiwang.bbms.interceptor;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cc.ileiwang.bbms.domain.Admin;
import cc.ileiwang.bbms.domain.Student;
import cc.ileiwang.bbms.util.common.BBMSConstants;

/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog www.ileiwang.cc
* @version 2018年5月8日 下午5:46:46
*/
public class AuthorizedInterceptor implements HandlerInterceptor{
	
	private static final String[] IGNORE_URI = { "/loginForm", "/login", "/404.html" ,"/findpasswd","/forgetpasswd","/register"};

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean flag = false;
		String servletPath = request.getServletPath();
		for (String s : IGNORE_URI) {
			if (servletPath.contains(s)) {
				flag = true;
				Random  rand = new Random();
				int numa = rand.nextInt(20);
				int numb = rand.nextInt(20);
				int result1 = numa+numb;
				String result = Integer.toString(result1);
				request.setAttribute("numa", numa);
				request.setAttribute("numb", numb);
				request.setAttribute("result", result);
				break;
			}
		}
		if (!flag) {
			Student student = (Student) request.getSession().getAttribute(BBMSConstants.STUDENT_SESSION);
			Admin admin = (Admin) request.getSession().getAttribute(BBMSConstants.ADMIN_SESSION);
			if (student == null&&admin==null) {
				//随机生成两个数字，其和作为验证码
				Random  rand = new Random();
				int numa = rand.nextInt(20);
				int numb = rand.nextInt(20);
				int result1 = numa+numb;
				String result = Integer.toString(result1);
				request.setAttribute("numa", numa);
				request.setAttribute("numb", numb);
				request.setAttribute("result", result);
				request.setAttribute("message", "请先登录再访问网站!");
				request.getRequestDispatcher(BBMSConstants.LOGIN).forward(request, response);
				return flag;
			} else {
				flag = true;
			}
		}
		return flag;
	}
}
