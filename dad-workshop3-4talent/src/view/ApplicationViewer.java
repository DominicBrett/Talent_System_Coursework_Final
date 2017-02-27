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
          private boolean cName = true;
        private JLabel southNote = new JLabel("All :       ");
        private JTextField searchFeild = new JTextField();
          private JLabel searchLabel = new JLabel("   Search Agencies & Clients :   ");
                 private JButton searchButton = new JButton("Search");
      private JButton searchParamReset = new JButton("Reset Search Filters");
      private JButton sortClientName = new JButton("Order By Client Name");
       private JLabel southClientLabel = new JLabel("Clients :       ");
 
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
                clientsDisplay.setText(ApplicationModel.getInstance().printClientsZA());
                agenciesDisplay.setText(ApplicationModel.getInstance().printAgenciesZA());
                azSort.setText("A/Z");
                aZ = false;
            }
            else
            {
                agenciesAverageDisplay.setText(ApplicationModel.getInstance().printAverageClientRate());
                ApplicationModel.getInstance().sortAgenciesByNameAndClient();
                  clientsDisplay.setText(ApplicationModel.getInstance().printClients());
                     ApplicationModel.getInstance().sortAgenciesByName();
                       agenciesDisplay.setText(ApplicationModel.getInstance().printAgencies());
                azSort.setText("Z/A");
                aZ = true;
            }
            
        }
    });
    searchButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           
           String a = searchFeild.getText();
           agenciesDisplay.setText(ApplicationModel.getInstance().printAgenciesSearch(a));
           clientsDisplay.setText(ApplicationModel.getInstance().printClientsSearch(a));
        }
    });
     searchParamReset.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           
          
           agenciesDisplay.setText(ApplicationModel.getInstance().printAgencies());
           clientsDisplay.setText(ApplicationModel.getInstance().printClients());
           agenciesAverageDisplay.setText(ApplicationModel.getInstance().printAverageClientRate());
        }
    });
     sortClientName.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (cName == true)
            {
                
                clientsDisplay.setText(ApplicationModel.getInstance().printClientsSortName());
               
                sortClientName.setText("Order By Client Agency");
                cName = false;
            }
            else
            {
                  clientsDisplay.setText(ApplicationModel.getInstance().printClients());
               
                sortClientName.setText("Order By Client Name");
                cName = true;
            }
            
        }
    });
        searchFeild.setColumns(50);
    
        
    controlPanel.add(southNote);
    controlPanel.add(azSort);
    controlPanel.add(southClientLabel);
        controlPanel.add(sortClientName);
    controlPanel.add(searchLabel);
    controlPanel.add(searchFeild);
    controlPanel.add(searchButton);
    controlPanel.add(searchParamReset);
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

    
  
 