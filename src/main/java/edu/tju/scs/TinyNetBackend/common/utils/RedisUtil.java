package edu.tju.scs.TinyNetBackend.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.logging.ErrorManager;


@Slf4j
@Component
public class RedisUtil {

    private final static int EXPIRE_TIME = 900;

    @Autowired
    protected StringRedisTemplate stringRedisTemplate;


    public boolean setAndExpire(String key, String value){
        try {
            stringRedisTemplate.opsForValue().set(key, value, EXPIRE_TIME, TimeUnit.SECONDS);
            return true;
        } catch (Exception e){
            log.error("Redis set and expire failed, {} ", e.getMessage());
            return false;
        }
    }

    public String get(String key){
        try {
            String result = stringRedisTemplate.opsForValue().get(key);
            return result;
        } catch (Exception e) {
            log.error("Redis get failed, {} ", e.getMessage());
            return null;
        }
    }

    public boolean del(String key){
        try {
            stringRedisTemplate.delete(key);
            return true;
        } catch (Exception e) {
            log.error("Redis del failed, {} ", e.getMessage());
            return false;
        }
    }

    public void updateExpire(String key){
        try {
            Long remain = stringRedisTemplate.opsForValue().getOperations().getExpire(key);
            if(remain != null && remain < 900 / 2) {
                stringRedisTemplate.opsForValue().getOperations().expire(key, EXPIRE_TIME, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            log.error("Redis expire failed, {} ", e.getMessage());
        }
    }

}
