package co.develhope.logging.controllers;

import co.develhope.logging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  A basic controller that has 3 mappings
 *
 * @author Tania Ielpo
 */

@RestController
public class BasicController {

    Logger logger= LoggerFactory.getLogger(BasicController.class);

    @Autowired
    BasicService basicService;

    /**
     * / : returns just a welcome message and logs it
     * @return A string with a welcome message
     */

    @GetMapping("/")
    public String getHello(){

        logger.info("This is a message in getHello() method in controller");
        return "Hello";
    }

    /**
     * /exp: returns a service that:
     * takes the 2 numeric env values, then logs and returns the power (exponent) of the 2 values
     * logs when starting and when finishing the calculation
     * @return a double with the result
     */

    @GetMapping("/exp")
    public double power(){
        logger.info("this is a log in power() method in controller");
        return basicService.getPower();
    }

    /**
     * /get-errors: throws a new custom error that will be logged
     */

    @GetMapping("/get-errors")
    public void getError(){
        Error error = new Error("This is a CUSTOM error");
        logger.error("This is the ERROR logging: ", error);
    }
}
