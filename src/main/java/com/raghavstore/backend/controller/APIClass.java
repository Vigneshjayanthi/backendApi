package com.raghavstore.backend.controller;


;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/products")
public class APIClass {

    @RequestMapping(method = RequestMethod.GET,path="/Test")
    public String getHelloWorld(){
        return "Hello world from gradle and spring boot";
    }

    @RequestMapping(method = RequestMethod.GET,path="/Test1")
    public String getHelloWorld1(){
        return "Hello world from gradle and spring boot1";
    }

    @RequestMapping(method = RequestMethod.GET,path="/Test2")
    public String getHelloWorld2(){
        return "Hello world from gradle and spring boot 12344";
    }

    @RequestMapping(method = RequestMethod.GET,path="/Test3")
    public String getHelloWorld3(){
        return "Hello world from gradle and spring boot 5 times reload";
    }

    @RequestMapping(method = RequestMethod.GET, path= "product/list")
    public ResponseEntity getListOfProduct(){
        List<String> listOfObject = Arrays.asList("Vignesh","vignesh");
        ResponseEntity re;
        if(!listOfObject.isEmpty()){
            re = new ResponseEntity<>(listOfObject, HttpStatus.OK);
        }
        else{
            re = new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        return re;
    }



}
