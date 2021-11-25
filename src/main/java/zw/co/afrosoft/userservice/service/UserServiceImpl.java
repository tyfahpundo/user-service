package zw.co.afrosoft.userservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import zw.co.afrosoft.userservice.ValueObjects.Department;
import zw.co.afrosoft.userservice.ValueObjects.ResponseTemplate;
import zw.co.afrosoft.userservice.domain.User;
import zw.co.afrosoft.userservice.persistence.UserRepository;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }
    @Autowired
    private final RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        log.info("Inside the saveUser method of UserService");
        return userRepository.save(user);
    }

    @Override
    public ResponseTemplate getUserWithDepartment(Long userId) {
        log.info("Inside the getUserWithDepartment method of UserService");
        ResponseTemplate vo = new ResponseTemplate();
        User user = userRepository.findByUserId(userId);
        Department department =
                restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId()
                ,Department.class);
        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
