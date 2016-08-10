package helpers;

import java.util.UUID;
public class HelperRandomClass {

    public static String getRandomString() {

        return UUID.randomUUID().toString().replace("-","").substring(20);
    }

    public static String getRandomEmail(){ return getRandomString() + "@mail.ru" ;}
    public static String getRandomPassword() { return  "A" + getRandomString(); }
    public static String getRandomUserName() {return getRandomString(); }
    public static String getRandomFirstName() { return  getRandomString().substring(7);}
    public static String getRandomLastName() { return getRandomString().substring(7); }


}

