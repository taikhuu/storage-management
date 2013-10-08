package tai.com.khuu.storage.web.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tai.com.khuu.storage.web.model.User;
import tai.com.khuu.storage.web.util.Error;
import tai.com.khuu.storage.web.util.ViewList;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private SessionFactory sessionFactory;
    @RequestMapping(value="/create",method=RequestMethod.GET)
    public ModelAndView create_user(){
        User user=new User();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("");
        return modelAndView;
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create_user(@ModelAttribute @Valid User user,
            RedirectAttributes redirectAttributes,Errors errors) {
        ModelAndView returnView = new ModelAndView("redirect:user_create_result");
        Session session = sessionFactory.openSession();
        Query query = session
                .createQuery("select * from User u where u.userName=:userName");
        query.setParameter("userName", user.getUsername());
        User user1 = (User) query.uniqueResult();
        if (user1 != null) {
            errors.rejectValue("userName","User is already exist");
            redirectAttributes
                    .addFlashAttribute(
                            "error_list",
                            new ArrayList<tai.com.khuu.storage.web.util.Error<String, String, String>>() {
                                {

                                    add(new Error<String, String, String>("",
                                            "User is already exist",
                                            "Choose another username"));
                                }
                            });
            return returnView;
        }
        session.persist(user);
        return returnView;
    }
    
    @RequestMapping("/user_create_result")
    public ModelAndView user_result() {
        ModelAndView modelAndView=new ModelAndView(ViewList.USER_CREATE_RESULT.getViewName());
        return modelAndView;
    }
}
