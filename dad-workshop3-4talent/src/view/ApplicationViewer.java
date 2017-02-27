/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
   
    private JTabbedPane tabs = new JTabbedPane();
     private JTextArea agenciesDisplay = new JTextArea();
        private JTextArea clientsDisplay = new JTextArea();
        private JTextArea agenciesAverageDisplay = new JTextArea();
        private JPanel controlPanel = new JPanel();
        private JButton azSort = new JButton("A/Z");
        private boolean aZ = true;
   
 
//    
public void jFramePrint()
{
   
    this.setLayout(new BorderLayout());
    this.add(controlPanel,BorderLayout.SOUTH);
    azSort.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (aZ == true)
            {
                agenciesAverageDisplay.setText(ApplicationModel.getInstance().printAverageZA());
                azSort.setText("A/Z");
                aZ = false;
            }
            else
            {
                agenciesAverageDisplay.setText(ApplicationModel.getInstance().printAverageClientRate());
                azSort.setText("Z/A");
                aZ = true;
            }
            
        }
    });
    controlPanel.add(azSort);
    this.setSize(1920,1040);
    this.setTitle("Talent Agency Viewer");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   
    agenciesDisplay.append(ApplicationModel.getInstance().printAgencies());
    clientsDisplay.append(ApplicationModel.getInstance().printClients());
    agenciesAverageDisplay.append(ApplicationModel.getInstance().printAverageClientRate());
    tabs.add("Agencies", agenciesDisplay);
    tabs.add("Clients", clientsDisplay);
    tabs.add("Average Rating", agenciesAverageDisplay);
    this.add(tabs);
 this.setVisible(true);
    
}
public ActionListener sortClick() {
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                
            }
        };
                return action;
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

    
  
 