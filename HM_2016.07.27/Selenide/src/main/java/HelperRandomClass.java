import java.util.Date;
import java.util.UUID;

public class HelperRandomClass {
    public static String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(20);
    }
    public static String getRandomSubject(){
        return getRandomString()+"_"+new Date().toString().replaceAll(" ", "").replaceAll(":", "");
    }
}


