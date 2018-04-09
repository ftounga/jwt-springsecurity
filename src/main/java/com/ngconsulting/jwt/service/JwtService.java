package com.ngconsulting.jwt.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngconsulting.jwt.bean.SecretKeyProvider;
import com.ngconsulting.jwt.model.MinimaProfile;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

private static final String ISSUER = "in.ngconsulting.jwt";

@Autowired
private SecretKeyProvider secretKeyProvider;

public String tokenFor(MinimaProfile minimaProfile) throws URISyntaxException, IOException {
	
	byte[] secretKey = secretKeyProvider.getKey();
	Instant expiration = LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.UTC);
	return Jwts.builder()
			.setSubject(minimaProfile.getUsername())
			.setExpiration(Date.from(expiration))
			.setIssuer(ISSUER)
			.signWith(SignatureAlgorithm.HS512, secretKey)
			.compact();	
}
}
