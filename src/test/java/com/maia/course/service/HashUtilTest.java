package com.maia.course.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.maia.course.service.util.HashUtil;

@RunWith(SpringRunner.class)
public class HashUtilTest {

	@Test
	public void getHash() {
		String hash = HashUtil.getSecuretHash("123456789");
		
		System.out.println("Hash: " + hash);

		assertThat(hash.length()).isEqualTo(32);
	}

}
