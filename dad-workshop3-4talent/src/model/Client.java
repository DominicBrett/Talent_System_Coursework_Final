/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dominic
 */
public class Client {

  
   
        private String name1;
       private String client;
      
       private String location;
       private String date;
       private String num;
       private String notes;   
    private String aList[];
   
  
    public Client(String testString)
    {
        this.name1 = testString;
        this.aList = name1.split(",");
        this.client= aList[0];
        this.location = aList[1];
        this.date = aList[2];
        this.num = aList[3];
         this.notes = aList[4];
    }
    
      @Override
    public String toString() {
   
        return client + "	"+ "\n" + location + "	" + "\n" + date + "	" + "\n" + num  + "	" + "\n" + notes+ "\n";
    }
          public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String[] getaList() {
        return aList;
    }

    public void setaList(String[] aList) {
        this.aList = aList;
    }
    
   
}
