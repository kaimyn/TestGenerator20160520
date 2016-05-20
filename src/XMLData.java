/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author kinining
 */
public class XMLData {
    private String source;
    private String path;
    private String date;
    private String version;
    private ArrayList<TestID> tests;
    
    public XMLData(String source, String path, String date, String version, ArrayList<TestID> tests) {
        this.source = source;
        this.path = path;
        this.date = date;
        this.version = version;
        this.tests = tests;
    }
    
    public String getPath() {
        return path;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getVersion() {
        return version;
    }
    
    public ArrayList<TestID> getTests() {
        return tests;
    }
    
    public String getSource() {
        return source;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }
    
    public void setTests(ArrayList<TestID> tests) {
        this.tests = tests;
    }
    
    public void setSource(String source) {
        this.source = source;
    }
    
    public void addTest(TestID test) {
        tests.add(test);
        Collections.sort(tests);
    }
    
    public TestID removeTest(int row) {
        TestID target = tests.get(row);
        tests.remove(row);
        return target;
    }
    
}
