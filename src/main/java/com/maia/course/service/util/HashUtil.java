package com.maia.course.service.util;

import org.apache.commons.codec.digest.DigestUtils;

/* 
 * Class Responsavel por Gerar a Criptografia da Senha.*/

public class HashUtil {

	public static String getSecuretHash(String text) {
		String hash = DigestUtils.sha256Hex(text);
		return hash;
	}

}
