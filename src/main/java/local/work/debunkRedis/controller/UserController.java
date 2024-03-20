package local.work.debunkRedis.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import local.work.debunkRedis.redisEntity.User;
import local.work.debunkRedis.redisRepository.UserRepository;

@RestController
public class UserController {

    private UserRepository userRepository;


    private RedisTemplate<String, Object> redisTemplate;

    public UserController(UserRepository userRepository, RedisTemplate<String, Object> redisTemplate){
        this.userRepository = userRepository;
        this.redisTemplate = redisTemplate;
    }

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(){
        User user = new User();
        user.setUsername("alex");
        user.setCity("atlana");
        // userRepository.save(user);
        redisTemplate.opsForValue().set(user.getUsername(), user);
        System.out.println(redisTemplate.opsForValue().get("alex"));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
