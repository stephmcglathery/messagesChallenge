package com.example.demo.controller;

import com.example.demo.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@Controller
@EnableAutoConfiguration
@Api(value="Demo Controller")
@RequestMapping(value = "/demo")
public class DemoController extends BaseController{

    @Autowired
    DemoService demoService;

    @ResponseBody
    @ApiOperation(value = "Hash message", consumes = "application/json")
    @RequestMapping(path="/messages", method = RequestMethod.POST)
    public String hashMessage(@Valid @RequestBody String message) throws NoSuchAlgorithmException {

        return demoService.hashMessage(message);
    }

    @ResponseBody
    @GetMapping("/messages/{hash}")
    @ApiOperation(value = "Retrieve message from hash")
    public String getMessageFromHash(@PathVariable String hash) {
        return demoService.getMessageFromHash(hash);
    }
}