package am.monamie.app.service;

import am.monamie.app.models.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {



   Map<String,User> getUser(User user);


   User saveAndFlush(User user);

   Optional<User> findByLogin(String login);

   Optional<User> findByLoginAndPassword(String login,String password);


}
