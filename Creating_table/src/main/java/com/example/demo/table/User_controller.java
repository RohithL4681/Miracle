package com.example.demo.table;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User_controller {
@Autowired
User_service us;
@PostMapping("/insert")
public User insert(@RequestBody User u ) {
	return us.insertData(u);
	
}
@GetMapping("/fetchdata")
public List<User> read() {
    return us.readData();
}
//@DeleteMapping("/delete/{userId}")
//public ResponseEntity<String> delete(@PathVariable("userId") long userId) {
//    us.delete(userId);
//    return ResponseEntity.ok("User deleted successfully");
//}


}
