import java.util.Scanner; 
import javafx.application.Application; 
import javafx.application.Platform; 
import javafx.stage.Stage; 
import javafx.scene.control.*; 
import java.util.Optional; 
import java.util.List; 
import java.util.ArrayList; 
import javafx.scene.Node; 
import javafx.scene.Scene; 

 
import javax.swing.*; 

/**
 * The Day class is a JavaFX application class which allows the user to select various operations related to ascertaining the day of the week.
 * @author Sapper
 * @version 1
 * email: email
 * FEB2018
 */
public class Day extends Application{

	/**
	 * The main() method is not used in this JavaFX class, it serves as a backup call.
	 * @param args command line arguments passed into a String array.
	 */
    public static void main(String[] args) { 
        launch(args); 
    } 

    /**
     * The start() method is the entry point of the application.  The start method of the Applicaton class is overridden.
     * @param primaryStage instance of a Stage object.
     */
    @Override 
    public void start(Stage primaryStage) { 
	WeekDay test = new WeekDay();

 
        List<String> choices = new ArrayList<>(); 
        choices.add("Set the day"); 
        choices.add("Print the day"); 
        choices.add("Get the day"); 
        choices.add("Get the next day"); 
        choices.add("Get the previous day"); 
        choices.add("Add a number of days and find out what day it will be"); 
        choices.add("Subtract a number of days and find out what day it was"); 

 
        ChoiceDialog<String> dialog = new ChoiceDialog<>("Choose an operation to perform", choices); 

 
        dialog.setTitle("Actions"); 
        dialog.setHeaderText("What would you like to know?"); 
        //dialog.setContentText("Please choose an action\nThe day is: " + test.getDay()); 
 
        int count = 0; 
	loop:
	do { 
        	dialog.setContentText("Please choose an action\nThe day is: " + test.getDay()); 
 
            Optional<String> selection = dialog.showAndWait(); 
 
            if (selection.isPresent()) { 
                String selected = selection.get(); 
                switch (selected) { 
                    case "Please choose an action": 
                        Alert noAction = new Alert(Alert.AlertType.INFORMATION); 
                        noAction.setHeaderText("Please choose an action"); 
                        noAction.showAndWait(); 
                        break; 
                    case "Set the day": 
                        String name = JOptionPane.showInputDialog(null, "Enter the day you want"); 
                        test.setDay(name); 
                        break; 
                    case "Print the day": 
                        JOptionPane.showMessageDialog(null, test.toString()); 
                        break; 
                    case "Get the day": 
                        JOptionPane.showMessageDialog(null, test.getDay()); 
                        break; 
                    case "Get the next day": 
                        JOptionPane.showMessageDialog(null, test.calculateDay(1)); 
                        break; 
                    case "Get the previous day": 
                        JOptionPane.showMessageDialog(null, test.calculateDay(-1)); 
                        break; 
                    case "Add a number of days and find out what day it will be": 
                        String numOfDays = JOptionPane.showInputDialog(null, "Enter the number of days you want to add:"); 
                        int numOfDays1 = Integer.parseInt(numOfDays); 
                        JOptionPane.showMessageDialog(null, "The resultant day will be: " + test.calculateDay(numOfDays1)); 
                        break; 
                    case "Subtract a number of days and find out what day it was": 
                        String numOfDays2 = JOptionPane.showInputDialog(null, "Enter the number of days you want to subtract with a negative sign:"); 
                        int numOfDays3 = Integer.parseInt(numOfDays2); 
                        JOptionPane.showMessageDialog(null, "The resultant day will be: " + test.calculateDay(numOfDays3)); 
                        break; 
                    default: 
                        JOptionPane.showMessageDialog(null, "yolo"); 
                } 
                count++; 
            } else { 
                JOptionPane.showMessageDialog(null, test.toString()); 
                break loop; 

 
            } 
        }while(choices != null); 
    } 

 
} 



class WeekDay { 
    private String[] day = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"}; 
    private String name;
    int returnIdx;    
 
     public WeekDay() {  
         this.name = "no day selected"; 
     } 
     public WeekDay(String name) {  
         this.name = name; 
     } 
 
     public String getDay() {  
         return this.name; 
     } 
 
 
     public void setDay(String name) { 
         this.name = name; 
     } 
 
 
     public int getIdx(String name) {
	// int returnIdx;    
         for (int i = 0; i < day.length; i++) { 
             if (day[i].equalsIgnoreCase(name)) { 
                 returnIdx = i; 
             } 
         } 
         return returnIdx; 
     } 
 
 
     public String calculateDay(int numberOfDays) { 
         String message = ""; 
         int dayIdx = getIdx(this.name); 
         if ((numberOfDays >= 0)) { 
             message = day[(dayIdx + numberOfDays) % 7]; 
         } else if ((numberOfDays < 0)){ 
             message = day[((7 - (Math.abs(numberOfDays) % 7)) + dayIdx) % 7]; 
         } else { 
             message = "invalid day"; 
         } 
         return message; 
     } 
 
 
     public String getNextDay() { 
         return calculateDay(1); 
     } 
     public String getPreviousDay() { 
         return calculateDay(-1); 
     } 
 
 
     @Override 
     public String toString() { 
         return "The name of the day is: " + name; 
     } 
 
 
 
 
 } 

