package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1532959
 */
public class Agency {

 
       private String agency;
    private String name1;
        private String name;
    private String dateJoined;
    private String dailyRate;
    private String notes;
    private String aList[];
     private String addList[];
     private String address= "";
    public Agency(String agency,String name,String dateJoined, String dailyRate,String notes)
    {
        this.agency = agency;
        this.name = name;
        this.dateJoined = dateJoined;
        this.dailyRate = dailyRate;
        this.notes = notes;
    }
    public Agency(String testString)
    {
        this.name1 = testString;
        this.aList = name1.split(",");
        this.name = aList[0];
        this.agency = aList[1];
        this.dateJoined = aList[2];
        this.dailyRate = aList[3];
         this.notes = aList[4];
         this.addList = agency.split(":");
        
    }

    @Override
    public String toString() {
      for (String element: addList)
      {
          address += element;
          address += "\n";
      }
        return name + "\n" + address +  dateJoined + "\n" +  dailyRate + "\n" +  notes + "\n" + "\n";
    }
    
       public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(String dailyRate) {
        this.dailyRate = dailyRate;
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

    public String[] getAddList() {
        return addList;
    }

    public void setAddList(String[] addList) {
        this.addList = addList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}

