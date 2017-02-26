    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
// needed for ArrayLists

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.io.IOException;

/**
 * This class is the organising model class for our Application we don't need
 * multiple instances of this class later we will make this an object with a
 * single instance at the moment we set the instance manually in the
 * initialisation code it should conform to a pseudo singleton pattern
 *
 * @author dave
 */
public class ApplicationModel {

    // this should hold a reference to the one and only instance of an ApplicationModel object
    private static ApplicationModel instance;


    private List<Agency> agencies = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();
    public List<Agency> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<Agency> agencies) {
        this.agencies = agencies;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
   
    /**
     *
     * @return the one instance of ApplicationModel
     */

    
     /**
     * Important:
     * readAgencies(String fileName, String fileName2) creates objects for both the agencies and clients. fileName is for "talent_agencies.txt"
     * while fileName2 is for "talent_clients.txt".
     */
    BufferedReader infile = null;
    String txtString;
    int i = 0;
    
   public void readAgencies(String fileName, String fileName2)
   {
    try {
    infile = new BufferedReader(new FileReader(fileName));
    // Reads first line so while statment dosen't
        txtString = infile.readLine();

        while ((txtString = infile.readLine()) != null) {
            Agency agency = new Agency(txtString);

            if (agency != null) {
                agencies.add(agency);
                i++;
               
            }
        }
    } 
    catch(IOException e)
      {
          //debugging
          e.printStackTrace();
    }
    finally
    {
        if (infile != null) {
            try {
                infile.close();
                sortAgenciesByName();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    infile = null;
    txtString = "";
    int i2 = 0;
    try {
    infile = new BufferedReader(new FileReader(fileName2));
    // Reads first line so while statment dosen't
        txtString = infile.readLine();

        while ((txtString = infile.readLine()) != null) {
            Client client = new Client(txtString);

            if (client != null) {
                clients.add(client);
                i2++;
               
            }
        }
    } 
    catch(IOException e)
      {
          //debugging
          e.printStackTrace();
    }
    finally
    {
        if (infile != null) {
            try {
                infile.close();
                sortAgenciesByName();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
    
  
    
   
   
public String printAgencies()
{
    String output = "";
    for (Agency a: agencies)
    {
        output += a.toString();
    }
    return output;
}
public void sortAgenciesByName()
{
 Collections.sort(agencies, (Agency a, Agency b) -> a.getName().compareToIgnoreCase(b.getName()));
}
public void sortAgenciesByNameAndClient()
{
 Collections.sort(clients, (Client a, Client b) -> a.getClient().compareToIgnoreCase(b.getClient()));
}

public String printClients()
{
    String output = "";
    for (Client a: clients)
    {
        output += a.toString();
    }   
    return output;
}   


    public static ApplicationModel getInstance() {
        return instance;
    }

    /**
     * For setting the only instance of ApplicationModel in a proper Singleton
     * Pattern this would not be required
     *
     * @param instance
     */
    public static void setInstance(ApplicationModel instance) {
        ApplicationModel.instance = instance;
    }

}
