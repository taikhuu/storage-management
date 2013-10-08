package tai.com.khuu.storage.web.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tai.com.khuu.storage.web.model.User;

@Controller
@RequestMapping("support_api")
public class SupportAPIController {
    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping( value="/create_user",method=RequestMethod.GET)
    public ModelAndView createUser(@RequestParam String userName,@RequestParam String passWord)
    {
        ShaPasswordEncoder encoder=new ShaPasswordEncoder(256);
        encoder.setEncodeHashAsBase64(true);
        Session session =sessionFactory.openSession();
        ModelAndView returnModelAndView=new ModelAndView("apisuccess");
        User user=new User();
        user.setUsername(userName);
        user.setPassword(encoder.encodePassword(passWord, userName));
        session.save(user);
        session.flush();
        session.close();
        returnModelAndView.setViewName("testfile");
        return returnModelAndView;
    }
    @RequestMapping(value="/test_login",method=RequestMethod.GET)
    @ResponseBody
    public String testLogin(){
        return "test";
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    
}
