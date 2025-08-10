/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MusicLibraryApplication;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author matt
 */
public class ErrorBox extends Stage  
{
        
            //private fields
    private String Error;
 
    
//return the error message
    private String getError(){
        
        return Error;
    }
    
   //overloaded constructor
    public ErrorBox(String Error)
    {
        this.Error = Error;
    }
    
       
    //main scene
    public Scene ErrorSecene()
    {
        //create a new border pane
        BorderPane mainPane = new BorderPane();
        
       
        //create a new text that has the error message
       Text errorMessage = new Text("Error, " + Error + " Happend");
        
       //set the font of the error message
       errorMessage.setFont(new Font(20) );
      
       
       //set the center of the pane to the error message
       mainPane.setCenter(errorMessage);
       
        
        
        
        //create a new button
        Button OkayBtn = buttonOkay();
        
        //craeate an hbox for the button
        HBox hbox = new HBox(OkayBtn);
        
        //set the hbox alignment to the center
        hbox.setAlignment(Pos.BOTTOM_CENTER);
        
        
        
        //set the mainpane  bottom to the hbox
        mainPane.setBottom(hbox);
        
       
        //create a new scene
         Scene sc = new Scene( mainPane,  500, 200);
        
         //set the stage title
         
         this.setTitle("Error");
         
         //make the stage not resizeable
         this.setResizable(false);
         
         //return the scene
        return sc;
    }
    
    
    
    //button okay method
    private Button buttonOkay()
    {
    
        //create a new button
    Button Okay = new Button("Ok");
    
    //set the font of the button to 20
    Okay.setFont( new Font(20));
    
    //regestar a action with a button
    Okay.setOnAction(e ->{ 
    
        //close the stage
       this.close();
    
    });
    
    
    return Okay;
    
}
    
    
    
} 
    
    

