/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 *
 * @author kinining
 */
public class FileIO {

    public static XMLData readXML(String source) {
        XMLData xmlData = null;
        ArrayList<TestID> tests = null;
        
        try {
            File fXmlFile = new File(source);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            
            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();
            
            //Get Path
            NodeList nNodeList = doc.getElementsByTagName("Path");
            Node nNode = nNodeList.item(0);
            String path = nNode.getTextContent();
            
            //Get Date
            nNodeList = doc.getElementsByTagName("Date");
            nNode = nNodeList.item(0);
            String date = nNode.getTextContent();
            
            //Get Version- auto set to 1 for now
            String version = "1";
            
            //Get Test information from TestID 
            nNodeList = doc.getElementsByTagName("TestID");
            tests = new ArrayList(nNodeList.getLength());
            for(int j = 0; j<nNodeList.getLength(); j++) {
                nNode = nNodeList.item(j);         
                if(nNode.getNodeType()==Node.ELEMENT_NODE) {
                    tests.add(j, new TestID(nNode));
                }
            }
            
            xmlData = new XMLData(source, path, date, version, tests);
        
        } catch(Exception e) {
            e.printStackTrace();
        }
        return xmlData;
    }
    
    public static XMLData readXML(File fXmlFile) {
        XMLData xmlData = null;
        ArrayList<TestID> tests = null;
        
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            
            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();
            
            //Get Path
            NodeList nNodeList = doc.getElementsByTagName("Path");
            Node nNode = nNodeList.item(0);
            String path = nNode.getTextContent();
            
            //Get Date
            nNodeList = doc.getElementsByTagName("Date");
            nNode = nNodeList.item(0);
            String date = nNode.getTextContent();
            
            //Get Version- auto set to 1 for now
            String version = "1";
            
            //Get Test information from TestID 
            nNodeList = doc.getElementsByTagName("TestID");
            tests = new ArrayList(nNodeList.getLength());
            for(int j = 0; j<nNodeList.getLength(); j++) {
                nNode = nNodeList.item(j);         
                if(nNode.getNodeType()==Node.ELEMENT_NODE) {
                    tests.add(j, new TestID(nNode));
                }
            }
            
            xmlData = new XMLData(fXmlFile.getPath(), path, date, version, tests);
            System.out.println(fXmlFile.getPath());
        
        } catch(Exception e) {
            e.printStackTrace();
        }
        return xmlData;
    }
    
    public static void xmlBackup(String source, String backup) {
        try {
            File fXmlFile = new File(source);
            //fw=new FileWriter("/Users/kinining/Coder/Java/TestGenerator_0516/TestConfig.xml",false);
            File fBackup = new File(backup);
            backupCopy(fXmlFile, fBackup);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean xmlWrite(XMLData xml, String backup) {
        String source = xml.getSource();
        xmlBackup(source, backup);
        
        ArrayList<TestID> tests = xml.getTests();
        String currentTemplate = null;
        TestID currentTest;
        Iterator i = tests.iterator();
        
        try {
            //FileWriter fw=new FileWriter("TestConfigTest.xml",false);
            //when ready, switch the above to the below.  the above writes to a test xml, not the real one
            FileWriter fw=new FileWriter(source, false);
            
            fw.write("<?xml version=\"1.0\"?>\n");
            fw.write("<FrontEnd>\n");
            fw.write("\t<Date>" + xml.getDate() + "</Date>\n");
            fw.write("\t<Path>" + xml.getPath() + "</Path>\n");
            
            while(i.hasNext())  {
                currentTest = (TestID) i.next();
                if(currentTemplate == null || currentTest.getTemplate().compareTo(currentTemplate)!=0) {
                    if(currentTemplate != null) {
                        fw.write("\t</Template>\n");
                    }
                    currentTemplate = currentTest.getTemplate();
                    fw.write("\t<Template Temp=\"" + currentTemplate + "\">\n");
                } 

                fw.write("\t\t<TestID TID=\"" + currentTest.getTestID() + "\">\n");
                fw.write("\t\t\t<Function F=\"" + currentTest.getFunction() + "\" Target=\"" + currentTest.getTarget() + "\" />\n");
                
                Iterator j = currentTest.getActions().iterator();
                Action action;
                fw.write("\t\t\t<ActionList>\n");
                while(j.hasNext()) {
                    action = (Action)j.next();
                    fw.write("\t\t\t\t<Action Type=\"" + action.getType() + "\">" + action.getData() + "</Action>\n");
                }
                fw.write("\t\t\t</ActionList>\n");
                /*
                 * Changed to action list
                String[] p = currentTest.getPoint();
                fw.write("\t\t\t<Point Pone=\"" + p[0] + "\" Ptwo=\"" + p[1] + "\" Pthree=\"" + p[2] + "\" Pfour=\"" + p[3] + "\" />\n");
                
                String[] t = currentTest.getTime();
                fw.write("\t\t\t<Time Tone=\"" + t[0] + "\" Ttwo=\"" + t[1] + "\" Tthree=\"" + t[2] + "\" Tfour=\"" + t[3] + "\" />\n");*/
                
                fw.write("\t\t</TestID>\n");
            }
            
            fw.write("\t</Template>\n</FrontEnd>");
            fw.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public static void genBash(XMLData xml) {
        
        Iterator i = xml.getTests().iterator();
        try {
            while(i.hasNext()) {
                TestID tmp = (TestID) i.next();


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
                fw.write("set local_path="+xml.getPath()+"/Autotest_%timestamp%\r\n");
                fw.write("\r\n");
                fw.write("\r\n");
                fw.write("\r\n");
                fw.write(":%test%\r\n");
                fw.write("echo %test%\r\n");
                /*fw.write("adb shell \"input tap "+tmp.getPoint(0)+"\"\r\n");
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
                fw.write("timeout "+tmp.getTime(3)+"\r\n");*/
                fw.write("\r\n");
                fw.write("\r\n");
                fw.write("\r\n");
                fw.close();
            }
                } catch (Exception e) {
                    e.printStackTrace();
            }
    }
    
    private static void backupCopy(File source, File dest)
        throws IOException {
    FileInputStream input = null;
    FileOutputStream output = null;
    try {
        input = new FileInputStream(source);
        output = new FileOutputStream(dest);
        byte[] buf = new byte[512];
        int bytesRead;
        while ((bytesRead = input.read(buf)) > 0) {
            output.write(buf, 0, bytesRead);
        }
    } finally {
        input.close();
        output.close();
    }
}

}
