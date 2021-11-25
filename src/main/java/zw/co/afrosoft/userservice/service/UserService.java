package zw.co.afrosoft.userservice.service;

import org.springframework.http.ResponseEntity;
import zw.co.afrosoft.userservice.ValueObjects.ResponseTemplate;
import zw.co.afrosoft.userservice.domain.User;

public interface UserService {
    User saveUser(User user);

    ResponseTemplate getUserWithDepartment(Long userId);
}
