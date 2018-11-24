package am.monamie.app.repository;

import am.monamie.app.models.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


    @Override
    User saveAndFlush(User user);

    User getUserByLogin(User user);

    Optional<User> findByLogin(String login);
    Optional<User> findByLoginAndPassword(String login,String password);
}
