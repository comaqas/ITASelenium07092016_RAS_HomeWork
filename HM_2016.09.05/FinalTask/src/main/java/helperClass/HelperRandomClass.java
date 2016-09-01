package helperClass;


import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;

public class HelperRandomClass {

    public static String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(20);
    }

    public static String getRandomEmail(){
        int lenght =8;

        String email = "Mail"+RandomStringUtils.randomNumeric(lenght) + "@gmail.com";
        return email;
    }

    public static String getRandomStringOfLetters(){
        int length =20;

        Random rng = new Random();
        String characters = "qwertyuiopasdfghjklzxcvbnm";

        char[] text = new char[length];

        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    public static String getRandomPassword(){
        return "Password"+getRandomString();
    }

    public static String getRandomDayOfBirth(){
        int randomInt = new Random().nextInt(27) + 1;

        return Integer.toString(randomInt);
    }

    public static String getRandomMonthOfBirh(){
        String[] Months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};

        return Months[new Random().nextInt(11)];
    }

    public static String getRandomYearOfBirth(){
        int randomInt = new Random().nextInt(30) + 1980;

        return Integer.toString(randomInt);
    }

    public static int getRandomFoundItem(int allFoundItems){
        return new Random().nextInt(allFoundItems);
    }
}
