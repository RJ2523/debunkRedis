package local.work.debunkRedis.redisEntity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@Data
@RedisHash("User")
public class User implements Serializable {
    @Id
    private String username;
    private List<String> token;
    private String city;
}
