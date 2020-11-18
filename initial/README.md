# Exercise 1 : Create web application with Spring boot.

1. Create a Web Controller, Create new folder `controllers` in `src\main\java\main\com\kbtg\tech\` and java file `CheckoutController.java` and insert code below.
```java
package com.kbtg.tech.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CheckoutController {

	@GetMapping("/Checkout")
	public String greeting() {
		return "checkout";
	}
  
  @PostMapping("/Confirm")
	public String greeting() {
		return "confirm";
	}

}
```
2. 



