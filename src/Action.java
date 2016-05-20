
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apple
 */
public class Action {
    
    private String type;
    private String data;
    
    public Action(String type, String data) {
        this.type = type;
        this.data = data;
    }
    
    public void updateAction(String type, String data) {
        this.type = type;
        this.data = data;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public String getType() {
        return type;
    }
    
    public String getData() {
        return data;
    }
}