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
```javascript
<script type="text/javascript" src="https://dev-kpaymentgateway.kasikornbank.com/ui/v2/kpayment.min.js" 
                                data-apikey="pkey_test_1GzaL0tZIZVQPJk1CZYGpIA4qRL3uo4y6"
                                data-name="Silpakorn University" 
                                data-description="Silpakorn Shop" 
                                data-amount="199" 
                                data-currency="THB"
                                data-savecard=false 
                            >
```



