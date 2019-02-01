package com.javatechie.email.api.service;

import com.javatechie.email.api.entity.Metting;
import com.javatechie.email.api.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MettingService {

    @Autowired
    MeetingRepository meetingRepository;

    public void saveMettigDate(Metting metting){
        meetingRepository.save(metting);
    }

    public List<Metting> getAll(){
        List<Metting> all = meetingRepository.findAll();
        all.forEach((a)-> System.out.println(a));
        return meetingRepository.findAll();
    }

}
