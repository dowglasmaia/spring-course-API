package com.maia.course.service.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/* 
 * Class Responsavel por Gerar a Criptografia da Senha.*/
@Component
public class HashUtil {

	public static String getSecuretHash(String text) {
		String hash = DigestUtils.sha256Hex(text);
		return hash;
	}

}
