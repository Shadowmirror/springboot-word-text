package top.kmirror.word.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.kmirror.word.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
//    @Query(nativeQuery = true, value = "select * from user where username = ?1")
    User findByUsername(String username);
}
