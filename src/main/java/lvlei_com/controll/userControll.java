package lvlei_com.controll;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import lvlei_com.po.User;
import lvlei_com.service.IUserService;
import util.convert;


/**
 * @author lvlei
 * springmvc 保存session的方式
 * 1 controll 方法里面传入 HttpSession httpSession set进去
 * 2 @SessionAttributes("userid")    modelMap.addAttribute("userid",u.getId());

 * 
 */


@Controller
@RequestMapping("/UserControll")
@SessionAttributes("userid") 
public class userControll {

	@Resource
	IUserService UserService;
	@RequestMapping("/register")
	@ResponseBody
	public boolean register(HttpSession httpSession,HttpServletResponse res, HttpServletRequest req, ModelMap modelMap, String username,
			String password, String sex, String age, String email, String phone, String birth) {
		User u = new User();
		if (age != null) {
			u.setAge(Integer.parseInt(age));
		}
		if (!StringUtils.isEmpty(birth)) {
			u.setBirth(convert.String2Date(birth));
		}
		u.setEmail(email);
		u.setPassword(password);
		u.setPhone(phone);
		u.setSex(sex);
		u.setUsername(username);
		// releasePram2Bean(req, u);
		boolean a = UserService.register(u);
		modelMap.addAttribute("userid",u.getId());
		return a;
	}

	@RequestMapping("/login")
	@ResponseBody
	public ModelAndView login(HttpServletResponse res, HttpServletRequest req, ModelMap modelMap, String username,
			String password, String sex, String age, String email, String phone, String birth) {
		ModelAndView ModelAndView = new ModelAndView("index.html");
		User u = new User();
		if (age != null) {
			u.setAge(Integer.parseInt(age));
		}
		if (!StringUtils.isEmpty(birth)) {
			u.setBirth(convert.String2Date(birth));
		}
		u.setEmail(email);
		u.setPassword(password);
		u.setPhone(phone);
		u.setSex(sex);
		u.setUsername(username);
		User a = UserService.getUser(u);
		if (a != null) {
			modelMap.put("user", a);
			modelMap.addAttribute("userid",u.getId());
			return ModelAndView;
		} else {
			return null;
		}
	}

	public void releasePram2Bean(HttpServletRequest req, Object u) {

	}
}
