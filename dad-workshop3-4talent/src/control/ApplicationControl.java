/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import javax.swing.JTextArea;
import view.ApplicationViewer;
import model.ApplicationModel;


/**
 * This will be the entry point to our Application and will create the 
 * main ApplicationView Window and put the initial data into the model
 * if present
 * @author dave
 */
public class ApplicationControl {
       
    public static void main(String[] args){
      ApplicationModel am = new ApplicationModel();
      ApplicationModel.setInstance(am);
      ApplicationModel.getInstance().readAgencies("talent_agencies.txt");
      ApplicationModel.getInstance().readClients("talent_clients.txt");
   
       ApplicationViewer av = new ApplicationViewer();
      ApplicationViewer.setInstance(av);
      ApplicationViewer.getInstance().jFramePrint();
       
        
   
      
    }
}
 