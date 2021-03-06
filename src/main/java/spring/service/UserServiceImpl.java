package spring.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import spring.dao.UserDAO;
import spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserDAO userDao;

    public List<User> getListFromService() {
            return userDao.getUserList();
    }

    @Override
    public User show(int id) {
        return userDao.show(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User updatedUser) {
        userDao.update(updatedUser);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public User getUserByLogin(String name) {
        return userDao.getUserByLogin(name);
    }

    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userDao.getUserByLogin(name);
    }


}
