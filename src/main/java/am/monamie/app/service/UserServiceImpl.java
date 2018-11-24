package am.monamie.app.service;

import am.monamie.app.models.User;
import am.monamie.app.models.UserLoginPost;
import am.monamie.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public UserLoginPost userLoginPost;

    @Override
    public Map<String, User> getUser(User user) {
        Map<String, User> map = new HashMap<>();
        map.put("data", userRepository.getUserByLogin(user));
        return map;
    }


    @Override
    public User saveAndFlush(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login,password);
    }


}
