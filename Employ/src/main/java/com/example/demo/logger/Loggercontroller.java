package com.example.demo.logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Loggercontroller {
@Autowired
Loggerservice ls;

@PostMapping("/loggersval")
public int logval() {
return ls.logs();
}
}

