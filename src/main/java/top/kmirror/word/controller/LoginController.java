package top.kmirror.word.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kmirror.word.entity.User;
import top.kmirror.word.entity.Result;
import top.kmirror.word.service.UserService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(LoginForm loginForm, HttpServletRequest request) {
        User user = userService.doLogin(loginForm.getUsername(), loginForm.getPassword());
        request.getSession().setAttribute("user", user);
        return user != null ? new Result("成功", true, user) : new Result("失败", false, null);
    }

    @PostMapping("/register")
    public Result register(RegisterForm registerForm) {
        User user = new User();
        user.setUsername(registerForm.getUsername());
        user.setPassword(registerForm.getPassword());
        Boolean result = userService.doRegister(user);
        return result ? new Result("成功", true, user) : new Result("失败", false, null);
    }
}


class RegisterForm {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class LoginForm {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


