package com.javatechie.email.api;

import com.javatechie.email.api.entity.Metting;
import com.javatechie.email.api.service.EmailService;
import com.javatechie.email.api.service.MettingService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootEmailFreemarkerApplicationTests {

	@Autowired
	private EmailService service;

    @Autowired
    private MettingService mettingService;

	@Test
    @Ignore
	public void contextLoads() {
	service.sendEmail();
	}


    @Test
    public void getAllMettings() {
        mettingService.getAll();
    }



    @Test
    public void addMetting() {
        Metting metting = new Metting();
        metting.setMettingDate(LocalDate.of(2018,11,11));
        mettingService.saveMettigDate(metting);
    }

}
