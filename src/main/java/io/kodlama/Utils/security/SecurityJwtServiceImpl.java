package io.kodlama.Utils.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class SecurityJwtServiceImpl implements SecurityJwtService {
    private final String SALT = "asdfashkgdfajhsgdfqwtyerqwueasdjgfasd";
    private final ObjectMapper objectMapper;

    public SecurityJwtServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private String doHMACSHA256(String part1AndPart2, String secretKey)
            throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secretKey.getBytes(), "HS256"));
        byte[] hashBytes = mac.doFinal(part1AndPart2.getBytes());
        String hash = Base64.getEncoder().encodeToString(hashBytes);
        return hash;
    }

    @Override
    public boolean validateJwt(String jwt) {
        try {
            if (jwt == null || jwt.length() < 1) {
                return false;
            }
            String[] parts = jwt.split("\\.");


            String PART3 = parts[2];
            String PART1_PART2 = parts[0] + "." + parts[1];
            String jwtSignature = Base64.getEncoder().encodeToString(
                    (doHMACSHA256(PART1_PART2, SALT)).getBytes(StandardCharsets.UTF_8));
            return jwtSignature.equals(PART3);
        } catch (InvalidKeyException e) {
            return false;
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }


    @Override
    public String generateJwt(String payload) throws InvalidKeyException, NoSuchAlgorithmException {
        String HEADER = "{\"alg\": \"HS256\", \"typ\": \"JWT\"}";
        String PAYLOAD = payload;
        String PART1 = Base64.getEncoder().encodeToString(HEADER.getBytes(StandardCharsets.UTF_8));
        String PART2 = Base64.getEncoder().encodeToString(PAYLOAD.getBytes(StandardCharsets.UTF_8));
        String PART1_PART2 = PART1 + "." + PART2;
        String PART3 = Base64.getEncoder().encodeToString(
                (doHMACSHA256(PART1_PART2, SALT)).getBytes(StandardCharsets.UTF_8));
        String JWT_TOKEN = PART1_PART2 + "." + PART3;
        return JWT_TOKEN;
    }

    @Override
    public String getValueFromJWT(String jwt) {
        String[] parts = jwt.split("\\.");
        String PART2 = new String(Base64.getDecoder().decode((parts[1].getBytes(StandardCharsets.UTF_8))),
                StandardCharsets.UTF_8);
        return PART2;
    }

   /* @Override
    public Kullanici getKullaniciFromJWT(String token) throws IOException {
        if (token == null) {
            return null;
        }
        String[] parts = token.split("\\.");
        String PART2 = new String(Base64.getDecoder().decode((parts[1].getBytes(StandardCharsets.UTF_8))),
                StandardCharsets.UTF_8);
        return objectMapper.readValue(PART2, Kullanici.class);
    }
*/


}
