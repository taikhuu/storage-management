package tai.com.khuu.storage.web.security.userdetails;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class HibernateUserDetailServices implements UserDetailsService {
    private static final Logger LOG=LoggerFactory.getLogger(HibernateUserDetailServices.class);
    @Autowired(required=true)
    @Qualifier(value="sessionFactory")
    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {
        LOG.info((sessionFactory==null?"null factory fuck it":"yay"));
        Session session =sessionFactory.openSession();
        Query authenticateQuery= session.getNamedQuery("authenticate");
        authenticateQuery.setParameter("username", username);
        List<UserDetails> userDetails=null;
        try{
        userDetails=authenticateQuery.list();
        LOG.info(Integer.toString(userDetails.size()));
        }catch(HibernateException ex){
            LOG.error("cannot get user details",ex);
            throw new UsernameNotFoundException("critical error cannot login",ex);
        }finally{
            session.close();
        }
        UserDetails userDetail=null;
        if(!userDetails.isEmpty())
        {
            userDetail=(UserDetails)userDetails.get(0);
        }
        return userDetail;
    }
}
