/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
// needed for ArrayLists
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * This class is the organising model class for our 
 * Application
 * we don't need multiple instances of this class
 * later we will make this an object with a single instance
 * at the moment we set the instance manually in the initialisation code
 * it should conform to a pseudo singleton pattern
 * 
 * @author dave
 */
public class ApplicationModel {
    // this should hold a reference to the one and only instance of an ApplicationModel object
    private static ApplicationModel instance;
    
    /**
     *
     * @return the one instance of ApplicationModel
     */
    public static ApplicationModel getInstance() {
        return instance;
    }

    /**
     * For setting the only instance of ApplicationModel
     * in a proper Singleton Pattern this would not be required
     * @param instance
     */
    public static void setInstance(ApplicationModel instance) {
        ApplicationModel.instance = instance;
    }
}
