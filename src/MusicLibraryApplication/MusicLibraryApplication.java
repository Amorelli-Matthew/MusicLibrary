/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MusicLibraryApplication;

import java.util.GregorianCalendar;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;




/*
Name: Matthew Amorelli

Date: November 6, 2022

Assignment : Midterm

Description: a program that stores a collection of songs
*/

public class MusicLibraryApplication extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Application.launch(args);
    }
    

 //create a new ListView;
       ListView<String> SongsListView  = new ListView<>();

//globle arrayl list 
       SongCollection<EntryInterface> MusicCollection = new SongCollection<EntryInterface>(SongsListView){};
       

      
       
 
       
    @Override
    public void start(Stage stage) throws Exception {
    
        //int id, String name, String artist, String album,  GregorianCalendar date,  String SongDes;
        
        
        //create a new main pane
        BorderPane MainPane = new BorderPane();

    
        //create a new label pane
        VBox labelPane = makeLabelBox();
        
        //allign its pos to topleft
        labelPane.setAlignment(Pos.TOP_LEFT);
     
       //call the button new entry  mthod and return the object to button new entry reference var
      Button  btn_newEntery = buttonNewEntry();
        

        //call the button view collection  mthod and return the object to button view colection eference var
       Button btn_ViewCollection = ButtonViewCollection(MainPane);
       
       //create new buttons 
       Button btn_LoadCollection = LoadCollection(MainPane); 
       
       Button  btn_SaveFile = SaveToFile(MainPane);
       
       Button btn_quit = new Button("Quit");
       
       //set the font of the quit button
       btn_quit.setFont(new Font(15));
       
       //create event handler to for quit button
       btn_quit.setOnAction( new EventHandler<ActionEvent>()
       {
           
           @Override
                 public void handle(ActionEvent E)
                    {    
                             //stop the application
                                 System.exit(0);
                   }
       
             }
       );
       
       
       //add buttons to hbox
       HBox ButtonHbox = new HBox( btn_newEntery, btn_ViewCollection, btn_LoadCollection, btn_SaveFile,  btn_quit);
       
       //set the spacing of button hbox
       ButtonHbox.setSpacing( 10);
       
       
       //set the allignment of hbox
       ButtonHbox.setAlignment(Pos.CENTER);
       
       //set the bottom of the mainpane to button hbox
       MainPane.setBottom( ButtonHbox);
   
       //set the top of the mainpane to labelpane
       MainPane.setTop(  labelPane);
     
       //create a new scene with mainpane
       Scene sc = new Scene(MainPane, 700, 500);
        
       //set the scene to the stage
      stage.setScene( sc);
        
      
        //set the title
        stage.setTitle("Music Midterm");
        
        
        //Make the application not resizable
        stage.setResizable(false);
       
    //display the the stage
        stage.show();
    
        

    }
    
    
    //method to create label box
    public static VBox makeLabelBox() {
            
        //create title label
        Label  Lbl_Title = new Label("Music Midterm App");

        //create name label
        Label Lbl_Name = new Label("Matthew Amorelli");
        
        //create assignmnet label
        Label lbl_Assignment = new Label("Java fall 2022 Midterm");
        
        //create data label
        Label lbl_Data = new Label("music");
        
        //return vbox
        return  new VBox(Lbl_Title , Lbl_Name,  lbl_Assignment, lbl_Data);
        
        
}
    
    
    //method for button that creates a new entry
    private  Button buttonNewEntry()
    {
        //create a new button
        Button BtnEntry = new Button("New Entry");
        
        //set the font
        BtnEntry.setFont(new Font(15) );
        
        //registar btn entry with an event handler
        BtnEntry.setOnAction(Ae -> {
        
            //try statement
            try
            {
                //create a new entry Scene object
                   newEntryScene EntryStage = new newEntryScene( );

                   
                   //set the stage title
                   EntryStage.setTitle("New Entry");
                   
                   //pass musicCollection for this
                      Scene newEntryScene = EntryStage.mainScene(  MusicCollection );
                   
                   //set the scene of the stage to new entry scene
                   EntryStage.setScene(   newEntryScene );

                   //make the stage non resizeable
                   EntryStage.setResizable(false);
                   

                   //display the Entry stage
                   EntryStage.show();
               }
            
        //catch any exceptions
                catch(Exception ex)
                {
                    //display any errors
                    System.out.println("Error, open again");
                    
                }
        }
        );

        
        //return btn entry 
        return BtnEntry;
        
        
    }
    
    
    //method for button that displays the collection
    private  Button ButtonViewCollection(BorderPane mp)
    {
        
        //create a new button
        Button btn_ViewCollection  = new Button(" View Collection");
        
       //set the font
       btn_ViewCollection.setFont(new Font(15) );
        
        //regester a collection with the set on action object
     btn_ViewCollection.setOnAction(ActionEvent -> {
        
        
         
            //set the center of the songlist
            mp.setCenter(SongsListView);
            

            //display the music collection
          MusicCollection.printAll( true);


     }
        );
     
     //create eventhandler on when the item is clicked
     SongsListView.setOnMouseClicked(
     
             new  EventHandler<MouseEvent>()
             {
                 @Override
                 
                 public void handle(MouseEvent e)
                 {
                     
                     //call the delte conform box
                     DeleteStage Dstage = new DeleteStage(MusicCollection, SongsListView);
                     
                      //set the scene of the stage                                         
                     Dstage.setScene( Dstage.MainScene()     );
                  
                    //set the title
                     Dstage.setTitle("Delete?");
                     
                  //display the dstage
                    Dstage.show();
                   
                   
                 }
                 
             }
                  
             
                  );
     
        
        
        
        return  btn_ViewCollection;
        
    }
 
   
   //method for the save to file button 
    private  Button SaveToFile(BorderPane mp)
    {
        
        //create a new button
      Button  btn_SaveFile = new Button("Save to File");
      
      
       //set the font
   
       btn_SaveFile.setFont(new Font(15));
      
      //register the save file action to the button
     btn_SaveFile.setOnAction(e -> {

         
         //create a new file object
        String CollectionFile = "Collection_File.dat";

        
      
        //save the MusicCollection as a binary file
           MusicCollection.saveAsBinary(CollectionFile);

           
         
    });

     
     return btn_SaveFile;
    }
    

private Button LoadCollection(BorderPane mp)
{
    //create a new button
            Button btn_ViewCollection = new Button("Load Collection");
            
            //set the font
            btn_ViewCollection.setFont(new Font(15) );
            
            //register the action event to the button
            btn_ViewCollection.setOnAction(new EventHandler<ActionEvent>() {
           
                @Override
                public void handle (ActionEvent e)
                {
                    
                    //create a new file object
                String fileNameAndOutcomeMessage  =  "Collection_File.dat";
         
                //load the music collection from file
                MusicCollection.loadFromBinary(fileNameAndOutcomeMessage);
                }

            } );

            return btn_ViewCollection;
}

}