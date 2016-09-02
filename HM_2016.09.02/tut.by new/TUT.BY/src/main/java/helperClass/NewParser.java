package helperClass;

import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class NewParser {

    public static String[] getDataFromXML(){
            String[] userInfo = new String[4];
        try {
            File inputFile = new File("userInfo.xml");
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("user");

            Node node1 = nList.item(0);
            Element eElement1 = (Element) node1;
            userInfo[0] = eElement1.getElementsByTagName("username").item(0).getTextContent();
            userInfo[1] = eElement1.getElementsByTagName("userpassword").item(0).getTextContent();

            Node node2 = nList.item(1);
            Element eElement2 = (Element) node2;
            userInfo[2] = eElement2.getElementsByTagName("username").item(0).getTextContent();
            userInfo[3] = eElement2.getElementsByTagName("userpassword").item(0).getTextContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    public static String[] getDataFromCSV(){
        String[] userInfo = new String[4];

        String csvFile = "userInfo.csv";

        BufferedReader br = null;

        String line = "";

        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                userInfo = line.split(cvsSplitBy);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  userInfo;
    }
    public enum  Parsers{xml,csv};

    public static String[] getDataFrom(Parsers parser) {
        String[] data = null;

        if(parser==Parsers.xml) {
            data = getDataFromXML();
        } else if(parser==Parsers.csv) {
            data = getDataFromCSV();
        }
        return data;
    }
}


