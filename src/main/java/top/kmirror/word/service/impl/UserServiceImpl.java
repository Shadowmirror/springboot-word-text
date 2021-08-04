package top.kmirror.word.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.kmirror.word.entity.User;
import top.kmirror.word.repository.UserRepository;
import top.kmirror.word.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User doLogin(String username, String password) {
        User user = userRepository.findByUsername(username);
        return (user != null && user.getPassword().equals(password)) ? user : null;
    }

    @Override
    public Boolean doRegister(User user) {
        userRepository.save(user);
        return true;
    }
}
