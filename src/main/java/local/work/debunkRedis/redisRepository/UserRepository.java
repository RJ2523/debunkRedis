package local.work.debunkRedis.redisRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import local.work.debunkRedis.redisEntity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
    
}
