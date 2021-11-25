package zw.co.afrosoft.userservice.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.userservice.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserId(Long userId);
}
