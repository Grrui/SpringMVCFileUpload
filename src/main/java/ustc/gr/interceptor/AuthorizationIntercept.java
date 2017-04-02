package ustc.gr.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import ustc.gr.controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Black on 2017/4/2.
 */
public class AuthorizationIntercept implements HandlerInterceptor{

    //不拦截登录请求
    private static final String[] IGNORE_URI = {"/loginForm","/login"};

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle...");
        //判断是否登录
        boolean flag = false;
        //获取请求路径进行判断
        String servletPath = httpServletRequest.getServletPath();
        for(String s :IGNORE_URI){
            if(servletPath.contains(s)){
                flag = true;
                break;
            }
        }
        //拦截请求
        if(!flag){
            //1.获取session中用户
            User user = (User)httpServletRequest.getSession().getAttribute("user");
            //2.判断是否已经登录
            if(user==null){
                flag = false;
                httpServletRequest.setAttribute("message","请先登录网站");
                httpServletRequest.getRequestDispatcher("/loginForm.jsp").forward(httpServletRequest,httpServletResponse);
            }else{
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle....");
//        modelAndView.addObject("message","要登录先！");
//        modelAndView.setViewName("loginForm");

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion....");
    }
}
