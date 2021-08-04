package top.kmirror.word.service;

import top.kmirror.word.entity.User;

public interface UserService {
    User doLogin(String username, String password);

    Boolean doRegister(User user);
}
