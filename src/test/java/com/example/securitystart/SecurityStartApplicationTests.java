package com.example.securitystart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityStartApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void addNewAdvert() {
		//AdvertRepository repository=new AdvertRepository();
		Advert advert=new Advert(1L,"Space Station ISS",1,"Is in low orbit, no shiping","Z","USD");
		Assertions.assertEquals("Space Station ISS", advert.getName());
	}
}
