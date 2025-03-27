package aisco.donation;
import aisco.donation.core.Donation;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class DonationFactory
{
    private static final Logger LOGGER = Logger.getLogger(DonationFactory.class.getName());

    private DonationFactory()
    {

    }

    public static Donation createDonation(String fullyQualifiedName, Object ... base) {
        Donation record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getConstructors()[0];
            record = (Donation) constructor.newInstance(base);
        }
        catch (IllegalArgumentException e)
        {
            LOGGER.severe("Failed to create instance of Donation.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
            System.exit(20);
        }
        catch (ClassCastException e)
        {   LOGGER.severe("Failed to create instance of Donation.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to cast the object");
            System.exit(30);
        }
        catch (ClassNotFoundException e)
        {
            LOGGER.severe("Failed to create instance of Donation.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Decorator can't be applied to the object");
            System.exit(40);
        }
        catch (Exception e)
        {
            LOGGER.severe("Failed to create instance of Donation.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(50);
        }
        return record;
    }

}