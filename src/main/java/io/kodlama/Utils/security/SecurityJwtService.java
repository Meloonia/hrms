package io.kodlama.Utils.security;


import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public interface SecurityJwtService {
    boolean validateJwt(String token);
    String generateJwt(String payload) throws InvalidKeyException, NoSuchAlgorithmException;
    String getValueFromJWT(String token);
}
