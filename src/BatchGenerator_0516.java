/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author kinining
 */
public class BatchGenerator_0516 {

    private static String[] args;
    public static XMLData xml;
    private static String backup = "/Users/kinining/Coder/Java/TestGenerator_0516/TestConfigBackup.xml";
    
    public static void main(String argv[]) {
final UI ui;
        try {

            String source = "/Users/kinining/Coder/Java/TestGenerator_0516/TestConfig.xml";
            
            
            //Moved below to FileIO
            /*
            File fXmlFile = new File("/Users/kinining/Coder/Java/TestGenerator_0516/TestConfig.xml");
    //        File fXmlFile = new File("D:\\Downloads\\XML\\FrontEnd_6.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            //read tags into TestID []
            ArrayList<TestID> tests;
            Node nNode;
            NodeList nNodeList;
            Element eElement;
            

            //Get Path
            nNodeList = doc.getElementsByTagName("Path");
            nNode = nNodeList.item(0);
            String path = nNode.getTextContent();

            //Get Test information from TestID 
            nNodeList = doc.getElementsByTagName("TestID");
            tests = new ArrayList(nNodeList.getLength());
            for(int j = 0; j<nNodeList.getLength(); j++) {
                nNode = nNodeList.item(j);         
                if(nNode.getNodeType()==Node.ELEMENT_NODE) {
                    tests.add(j, new TestID(nNode));
                }
            }
            */
            
            xml = FileIO.readXML(source);
            /*
            String[] pt = {"0", "0", "0", "0"};
            String[] tt = {"0", "0", "0", "0"};
            TestID tmp1 = new TestID("0099", "PSC", "King", "Taipei", pt, tt);
            xml.addTest(tmp1);
            
            String[] pt2 = {"0", "0", "0", "0"};
            String[] tt2 = {"0", "0", "0", "0"};
            TestID tmp2 = new TestID("0099", "Genite101", "King", "Taipei", pt2, tt2);
            xml.addTest(tmp2);
            */
           
            FileIO.xmlWrite(xml, backup);
            FileIO.genBash(xml);
            
            ui = new UI();
            ui.addXML(xml);

            
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ui.setVisible(true);
            }
            });
            
            
            
            
            
            
            /*Below source has been moved to the Writer


            //Print test case 
    //        TestID tmp = tests[0];
    //        System.out.println(tmp.getTemplate());
    //        System.out.println(tmp.getTestID());
    //        System.out.println(tmp.getFunction());
    //        System.out.println(tmp.getTarget());
    //        System.out.println(tmp.getPoint(0));
    //        System.out.println(tmp.getPoint(1));
    //        System.out.println(tmp.getPoint(2));
    //        System.out.println(tmp.getPoint(3));
    //        System.out.println(tmp.getTime(0));
    //        System.out.println(tmp.getTime(1));
    //        System.out.println(tmp.getTime(2));
    //        System.out.println(tmp.getTime(3));
            //Generate Batch files
    //        System.out.println("Time of Generate : " + nNodeList.getLength());
            for(int i = 0; i< nNodeList.getLength(); i++){
    //            System.out.print( i+1 );
                TestID tmp = (TestID) tests.get(i);
//            System.out.println(tmp.getTemplate());
//            System.out.println(tmp.getTestID());
//            System.out.println(tmp.getFunction());
//            System.out.println(tmp.getTarget());
//            System.out.println(tmp.getPoint(0));
//            System.out.println(tmp.getPoint(1));
//            System.out.println(tmp.getPoint(2));
//            System.out.println(tmp.getPoint(3));
//            System.out.println(tmp.getTime(0));
//            System.out.println(tmp.getTime(1));
//            System.out.println(tmp.getTime(2));
//            System.out.println(tmp.getTime(3));

                //Generate batch 
                String filename = tmp.getTemplate()+"_"+tmp.getFunction()+"_"+tmp.getTarget();
                System.out.print(filename+"\r\n");
                FileWriter fw=new FileWriter(filename+".bat",true);
                fw.write("@ECHO OFF\r\n");
                fw.write(
                    "rem ***********************************************************************\r\n" +
                    "rem Test ID: "+tmp.getTestID()+"\r\n" + 
                    "rem Template: "+tmp.getTemplate()+"\r\n" +
                    "rem Test Function: "+tmp.getFunction()+"   "+tmp.getTarget()+"\r\n" +
                    "rem ***********************************************************************\r\n");
                fw.write("\r\n");
                fw.write("\r\n");
                fw.write("\r\n");

                fw.write(":: CREATE VARIABLE %TIMESTAMP%\r\n");
                fw.write("for /f \"tokens=1-8 delims=.:/-, \" %%i in ('echo exit^|cmd /q /k\"prompt $D $T\"') do (\r\n");
                fw.write("for /f \"tokens=2-4 delims=/-,() skip=1\" %%a in ('echo.^|date') do (\r\n");
                fw.write("set dow=%%l\r\n");
                fw.write("set mm=%%j\r\n");
                fw.write("set dd=%%k\r\n");
                fw.write("set yy=%%i\r\n");
                fw.write("set hh=%%m\r\n");
                fw.write("set min=%%n\r\n");
                fw.write("set sec=%%o\r\n");
                fw.write("set hsec=%%p\r\n");
                fw.write(")\r\n");
                fw.write(")\r\n");
                fw.write("\r\n");
                fw.write("\r\n");

                fw.write(":: ensure that hour is always 2 digits\r\n");
                fw.write("if %hh%==0 set hh=00\r\n");
                fw.write("if %hh%==1 set hh=01\r\n");
                fw.write("if %hh%==2 set hh=02\r\n");
                fw.write("if %hh%==3 set hh=03\r\n");
                fw.write("if %hh%==4 set hh=04\r\n");
                fw.write("if %hh%==5 set hh=05\r\n");
                fw.write("if %hh%==6 set hh=06\r\n");
                fw.write("if %hh%==7 set hh=07\r\n");
                fw.write("if %hh%==8 set hh=08\r\n");
                fw.write("if %hh%==9 set hh=09\r\n");
                fw.write("\r\n");
                fw.write("\r\n");
                fw.write(":: assign timeStamp:\r\n");
                fw.write(":: Add the date and time parameters as necessary - \" yy-mm-dd-dow-min-sec-hsec \"\r\n");
                fw.write("set hm=%hh%%min%\r\n");
                fw.write("set hms=%hh%%min%%sec%\r\n");
                fw.write("\r\n");
                fw.write("\r\n");
                fw.write("\r\n");
                fw.write("set test="+filename+"\r\n");
                fw.write("set hmi_path=/sdcard/%test%_%hms%.png\r\n");
                fw.write("set local_path="+path+"/Autotest_%timestamp%\r\n");
                fw.write("\r\n");
                fw.write("\r\n");
                fw.write("\r\n");
                fw.write(":%test%\r\n");
                fw.write("echo %test%\r\n");
                fw.write("adb shell \"input tap "+tmp.getPoint(0)+"\"\r\n");
                fw.write("timeout "+tmp.getTime(0)+"\r\n");
                fw.write("adb shell \"input tap "+tmp.getPoint(1)+"\"\r\n");
                fw.write("timeout "+tmp.getTime(1)+"\r\n");
                fw.write("adb shell \"input tap "+tmp.getPoint(2)+"\"\r\n");
                fw.write("timeout "+tmp.getTime(2)+"\r\n");
                fw.write("\r\n");
                fw.write("\r\n");
                fw.write("\r\n");
                fw.write(":screenshot\r\n");
                fw.write("adb shell \"screencap% %hmi_path%\"\r\n");
                fw.write("adb pull %hmi_path% %local_path%\r\n");
                fw.write("\r\n");
                fw.write("adb shell \"input tap Pone4\""+tmp.getPoint(3)+"\r\n");
                fw.write("timeout "+tmp.getTime(3)+"\r\n");
                fw.write("\r\n");
                fw.write("\r\n");
                fw.write("\r\n");
                fw.close();
            }
*/      } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void updateXMLData(String data, int row, int col) {
        //xml.updateTest(data, row, col);
        
        System.out.println("changign data");
        ArrayList<TestID> tests = xml.getTests();
        TestID item = tests.get(row);
        switch(col) {
                case 0:
                    item.setTemplate(data);
                    tests.set(row, item);
                    break;
                case 1:
                    item.setTestID(data);
                    tests.set(row, item);
                    xml.setTests(tests);
                    System.out.println("raw data: " + data);
                    System.out.println("change testid");
                    System.out.println("just changed data: " + xml.getTests().get(0).getTestID());
                    break;
                case 2:
                    item.setFunction(data);
                    tests.set(row, item);
                    break;
                case 3:
                    item.setTarget(data);
                    tests.set(row, item);
                    break;
                case 4:
                    item.setPoint(0, data);
                    tests.set(row, item);
                    break;
                case 5:
                    item.setPoint(1, data);
                    tests.set(row, item);
                    break;
                case 6:
                    item.setPoint(2, data);
                    tests.set(row, item);
                    break;
                case 7:
                    item.setPoint(3, data);
                    tests.set(row, item);
                    break;
                case 8:
                    item.setTime(0, data);
                    tests.set(row, item);
                    break;
                case 9:
                    item.setTime(1, data);
                    tests.set(row, item);
                    break;
                case 10:
                    item.setTime(2, data);
                    tests.set(row, item);
                    break;
                case 11:
                    item.setTime(3, data);
                    tests.set(row, item);
                    break;
        }
        xml.setTests(tests);
        System.out.println("just changed data: " + xml.getTests().get(0).getTestID());
    }

    public static void saveXMLtoFile() {
        System.out.println("changed data: " + xml.getTests().get(0).getTestID());
        FileIO.xmlWrite(xml, backup);
        System.out.println("saved data");
    }
}
        
    