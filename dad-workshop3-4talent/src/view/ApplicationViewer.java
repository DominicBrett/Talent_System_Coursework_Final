/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import model.ApplicationModel;
import javax.swing.*;
/**
 * The Application Viewer is created by ApplicationControl
 * when the Application starts
 * If the ApplicationModel has data in it then this data should added 
 * to the Viewer on creation
 * The ApplicationViewer should be updated whenever data is added or changed
 * 
 * @author dave
 */
public class ApplicationViewer extends JFrame {
   
    private JTextArea agencyDisplay = new JTextArea();
//    
public void jFramePrint()
{
    this.add(agencyDisplay);
    this.setSize(600,600);
    this.agencyDisplay.append(ApplicationModel.getInstance().printAgencies());
////    this.setVisible(true);
    
}
    // this should hold a reference to the one and only instance of an ApplicationViewer object
       
   private static ApplicationViewer instance;
   
    /**
     *
     * @return the one instance of ApplicationViewer
     */
    public static ApplicationViewer getInstance() {
        return instance;
    }


    // use a phony Singleton to make the instance of the Viewer available throughout the application
     /**
     * For setting the only instance of ApplicationViewer
     * in a proper Singleton Pattern this would not be required
     * @param instance
     */
    public static void setInstance(ApplicationViewer instance) {
        ApplicationViewer.instance = instance;
    }

    

        
      
    
  
    
    
}

    
  
 