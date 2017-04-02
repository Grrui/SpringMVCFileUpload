package ustc.gr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Black on 2017/4/2.
 */
@Controller
public class LoginController {

    @RequestMapping(value="/login")
    public ModelAndView login(
            String loginName,String password,
            ModelAndView mv,HttpSession session){
        System.out.println("?????");
        if(loginName != null && loginName.equals("admin")&&password != null && password.equals("admin")){
            User user = new User();
            user.setLoginName(loginName);
            user.setPassword(password);
            session.setAttribute("user",user);
            mv.setViewName("redirect:uploadForm");
        }else{
            mv.addObject("message","登录名或密码错误，重新登录");
            mv.setViewName("loginForm");
        }
        return mv;
    }

}
