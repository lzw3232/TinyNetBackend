package edu.tju.scs.TinyNetBackend.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;


@Slf4j
public class TokenUtil {

    private final static int DURATION_TIME = 2;

    private final static String secret ="lzw";
    public static String getToken(String aud) {
//        Algorithm algorithm = Algorithm.HMAC256(secret);
//        return JWT.create()
//                .withIssuer("tiny_net")
//                .withAudience(aud)
////                .withExpiresAt(new Date(System.currentTimeMillis() + DURATION_TIME))
//                .sign(algorithm);

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("auth0")    // 发布者
                    .withIssuedAt(new Date())   // 生成签名的时间
                    .withExpiresAt(DateUtils.addHours(new Date(), DURATION_TIME))   // 生成签名的有效期,小时
                    .withClaim("name", aud) // 插入数据
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException e) {
            e.printStackTrace();
            //如果Claim不能转换为JSON，或者在签名过程中使用的密钥无效，那么将会抛出JWTCreationException异常。
            return "";
        }

    }

    public static boolean parseToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build();
            DecodedJWT jwt = verifier.verify(token); //解码JWT ，verifier 可复用
            // 获取开始生效时间/创建时时间
            Date date1=jwt.getExpiresAt(); // =>Sat Jan 11 22:25:13 CST 2020
            Date date2=new Date();
            int x = date1.compareTo(date2);
            if(x==1){
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }


    public static String getAudience(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0") //匹配指定的token发布者 auth0
                    .build();
            DecodedJWT jwt = verifier.verify(token); //解码JWT ，verifier 可复用

//            // 获取withIssuer 设置的值
//            System.out.println(jwt.getIssuer()); // => auth0
//
//            // 获取开始生效时间/创建时时间
//            System.out.println(jwt.getIssuedAt()); // =>Sat Jan 11 20:25:13 CST 2020
//
//            // 获取过期时间，
//            System.out.println(jwt.getExpiresAt()); //=>Sat Jan 11 22:25:13 CST 2020
//
            // 获取Claim中的值
            Map<String, Claim> claims = jwt.getClaims();
            Claim claim = claims.get("name");
            //System.out.println(claim.asString()); // => wuyuwei
            return claim.asString();


            //System.out.println(jwt);
//        return jwt.getPayload();
//            //return JWT.decode(token).getAudience().get(0);
//            return JWT.decode(token).getAudience().get(1);
        } catch (JWTDecodeException e) {
            return null;
        }
    }



    public static void main(String[] args){
//        Algorithm algorithm = Algorithm.HMAC256("secret");
//        String token = JWT.create()
//                .withIssuer("auth0")
//                .sign(algorithm);
//        System.out.println(token);
//        Algorithm algorithm1 = Algorithm.HMAC256("secret");
//        JWTVerifier verifier = JWT.require(algorithm1)
//                .withIssuer("auth0")
//                .build(); //Reusable verifier instance
//        DecodedJWT jwt = verifier.verify(token);
//        System.out.println(jwt.getHeader());
//        System.out.println(jwt.getPayload());
//        System.out.println(jwt.getSignature());
//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJhdXRoMCIsIm5hbWUiOiI0IiwiZXhwIjoxNTk5ODE2OTE0LCJpYXQiOjE1OTk4MDk3MTR9._6tKJ42Tyd1LQdO_Ol_PgWfjnvXOJ6x8Ne6fQnVr4Jw";
//        parseToken(token);
        //System.out.println(parseToken("lee","tju",a));

        System.out.println(getToken("lzw"));
        System.out.println(getAudience("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJhdXRoMCIsIm5hbWUiOiJsenciLCJleHAiOjE2MDAxNjIwNjYsImlhdCI6MTYwMDE1NDg2Nn0.iZfwEoyp0fbp3_eMEXdj3lWKrlvpdd4D3rcBLzW3N64"));
    }
}
