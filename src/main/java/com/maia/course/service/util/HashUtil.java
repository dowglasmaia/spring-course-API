package com.maia.course.service.util;


import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/* 
 * Class Responsavel por Gerar a Criptografia da Senha.*/
@Component
public class HashUtil {

	public static String getSecuretHash(String text) {
		String hash = DigestUtils.md5DigestAsHex(text.getBytes());
		return hash;
	}

}
