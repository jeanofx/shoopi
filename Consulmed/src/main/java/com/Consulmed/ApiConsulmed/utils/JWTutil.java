
package com.Consulmed.ApiConsulmed.utils;


import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Manesh
 */

@Component
public class JWTutil {
    
    @Value("${security.jwt.secret}")
    private String key;
    
    @Value("${security.jwt.issuer}")
    private String issuer;
    
    @Value("${security.jwt.ttlMillis}")
    private long ttlMillis;
    
    private final Logger log = LoggerFactory
            .getLogger(JWTutil.class);
    
    //Creación de un nuevo token
    
    public String create (String id, String subject){
        
        // JWT revision del algoritmo usado para asignar el token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        
        long nowMillis = System.currentTimeMillis();
        Date now = new Date (nowMillis);
        
        // Firma con el JWT
        
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        
        //Establecer las exclamaciones de JWT
        JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);
        
        if (ttlMillis >= 0){
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        //Crea el JWT y lo serializa en una cadena compacta segura para URL
        return builder.compact();

       }
        //Metodo para validar y leer el JWT
        public String getValue(String jwt) {
            //Esta línea arrojará una excepción si no es un JWS firmado
            Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(key))
                    .parseClaimsJws(jwt).getBody();

            return claims.getSubject();
    }
        public String getKey(String jwt) {
            //Esta línea arrojará una excepción si no es un JWS firmado
            Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(key))
                    .parseClaimsJws(jwt).getBody();

            return claims.getId();
        }
    
}
