package co.develhope.logging.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @author Tania Ielpo
 */

@Service
public class BasicService {

    @Autowired
    Environment environment;

    Logger logger= LoggerFactory.getLogger(BasicService.class);


    /**
     * takes the 2 numeric env values, then logs and returns the power (exponent) of the 2 values
     * logs when starting and when finishing the calculation
     * @return a double with the result
     */
    public double getPower(){

        logger.debug("Starting calculation");
        double n1 = Double.parseDouble(environment.getProperty("myCustomVarTree.n1"));
        double n2 = Double.parseDouble(environment.getProperty("myCustomVarTree.n2"));
        double result=Math.pow(n1,n2);
        logger.debug("Ending calculation");
        return result;
    }
}
