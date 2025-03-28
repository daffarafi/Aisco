package aisco.paymentgateway;
import aisco.paymentgateway.core.PaymentGateway;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class PaymentGatewayFactory {
    private static final Logger LOGGER = Logger.getLogger(PaymentGatewayFactory.class.getName());
    
    private PaymentGatewayFactory() {}
    
    public static PaymentGateway createPaymentGateway(String fullyQualifiedName, Object... args) {
        PaymentGateway gateway = null;
        try {
            // Get the class
            Class<?> clz = Class.forName(fullyQualifiedName);
            
            // Find a constructor that matches the number of arguments
            Constructor<?>[] constructors = clz.getConstructors();
            Constructor<?> matchingConstructor = null;
            
            for (Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() == args.length) {
                    matchingConstructor = constructor;
                    break;
                }
            }
            
            if (matchingConstructor == null) {
                LOGGER.severe("No matching constructor found for the given arguments");
                System.exit(60);
            }
            
            // Create the instance
            gateway = (PaymentGateway) matchingConstructor.newInstance(args);
        }  catch (IllegalArgumentException e)
        {
            LOGGER.severe("Failed to create instance of Payment Gateway.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
            System.exit(20);
        }
        catch (ClassCastException e)
        {   LOGGER.severe("Failed to create instance of Payment Gateway.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to cast the object");
            System.exit(30);
        }
        catch (ClassNotFoundException e)
        {
        	System.out.println(e.getMessage());
            LOGGER.severe("Failed to create instance of Payment Gateway.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Class not Found");
            System.exit(40);
        }
        catch (Exception e)
        {
            System.out.println(e);
            LOGGER.severe("Failed to create instance of Financial Report.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(50);
        }
        return gateway;
    }
}