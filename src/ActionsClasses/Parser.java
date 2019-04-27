package ActionsClasses;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Parser {
    public static Map<String,String> isoDecMap = new HashMap<>();
    public static Map<String,String> isoHexMap = new HashMap<>();
    public static Map<String,String> isoOctMap = new HashMap<>();

    public static void parseFile(File file){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try{
            builder = factory.newDocumentBuilder();
        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }
        Document document = null;
        try {
            document = builder.parse(file);
        }catch (SAXException | IOException e){
            e.printStackTrace();
        }

        Node root = document.getDocumentElement();
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++){
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element)nodeList.item(i);
                if (element.getElementsByTagName("TYPE").item(0).getTextContent().equals("ISO-8859-5")){
                    isoDecMap.put(element.getAttribute("char"),
                            element.getElementsByTagName("DEC").item(0).getTextContent());
                    isoHexMap.put(element.getAttribute("char"),
                            element.getElementsByTagName("HEX").item(0).getTextContent());
                    isoOctMap.put(element.getAttribute("char"),
                            element.getElementsByTagName("OCT").item(0).getTextContent());
                }
            }
        }
//        Iterator<Map.Entry<String, String>> iterator = isoDecMap.entrySet().iterator();
//
//        while (iterator.hasNext())
//        {
//            Map.Entry<String, String> pair = iterator.next();
//            String key = pair.getKey();
//            String value = pair.getValue();
//            System.out.println(key + ":" + value);
//        }
    }
}
