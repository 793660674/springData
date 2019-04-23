/**SbootController**/
package com.springdata.demo.controller;

import com.springdata.demo.popj.Sboot;
import com.springdata.demo.repository.SbootRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by atben
 * 2018-01-24 14:31
 */
@RestController
@EnableAutoConfiguration
public class SbootController {

    @Autowired
    private SbootRepositoty sbootRepositoty;

    @RequestMapping(value = "/hi")
    public String hi(){

        return "hi!";
    }

    @GetMapping(value = "/list")
    public List<Sboot> list(){

        return sbootRepositoty.findAll();
    }

    @GetMapping(value = "/delete")
    public int deletelist(int id){
        sbootRepositoty.deleteById(id);
        return 1;
    }

    @GetMapping(value = "/add")
    public Sboot add(){
        Sboot sb=new Sboot();
        sb.setTest1("ceshi");
        sb.setTest2("ceshi2");
        sbootRepositoty.save(sb);
        return sb;
    }
}
