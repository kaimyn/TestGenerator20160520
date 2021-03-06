/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 *
 * @author ESPD-DQA-I7
 */
public class TestID implements Comparable<TestID>{
    Node testIDNode;
    String testID;
    String template;
    String function;
    String target;
    String[] p;
    String[] t;
    
    public TestID (Node testID) {
        this.testIDNode = testID;
        readNode();
    }
    
    public TestID(String testid, String template, String function, String target, String[] p, String[] t) {
        this.testID = testid;
        this.template = template;
        this.function = function;
        this.target = target;
        this.p = p;
        this.t = t;
    }
    
    private void readNode() {
        testID = ((Element)testIDNode).getAttribute("TID");
        
        Element eElement = (Element) testIDNode.getParentNode();
        template = eElement.getAttribute("Temp");
        
        NodeList childNodes = testIDNode.getChildNodes();
        eElement = (Element) childNodes.item(1);
        function = eElement.getAttribute("F");
        target = eElement.getAttribute("Target");
        
        eElement = (Element) childNodes.item(3);
        p = new String[4];
        
        p[0] = eElement.getAttribute("Pone");
        p[1] = eElement.getAttribute("Ptwo");
        p[2] = eElement.getAttribute("Pthree");
        p[3] = eElement.getAttribute("Pfour");
        
        eElement = (Element) childNodes.item(5);
        t = new String[4];
        t[0] = eElement.getAttribute("Tone");
        t[1] = eElement.getAttribute("Ttwo");
        t[2] = eElement.getAttribute("Tthree");
        t[3] = eElement.getAttribute("Tfour");
    }
    
    @Override public int compareTo(TestID other) {
        
        if(this == other) return 0;
        
        if(this.template.compareTo(other.getTemplate()) == 0) {
            return this.testID.compareTo(other.getTestID());
        }
        return template.compareTo(other.getTemplate());
    }
    
    public String getTemplate() {
        return template;
    }
    
    public String getTestID() {
        return testID;
    }
    
    public String getFunction() {
        return function;
    }
    
    public String getTarget() {
        return target;
    }
    
    public String[] getPoint() {
        return p;
    }
    
    public String getPoint(int i) {
        return p[i];
    }
    
    public String[] getTime() {
        return t;
    }
    
    public String getTime(int i) {
        return t[i];
    }
    
    public void setPoint(int i, String value) {
        p[i] = value;
    }
    
    public void setTime(int i, String value) {
        t[i] = value;
    }
    
    public void setTemplate(String template) {
        this.template = template;
    }
    
    public void setFunction(String function) {
        this.function = function;
    }
    
    public void setTarget(String target) {
        this.target = target;
    }
    
    public void setTestID(String testID) {
        this.testID = testID;
    }
    
}
