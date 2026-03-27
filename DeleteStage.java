/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MusicLibraryApplication;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author greenclover
 */
public class DeleteStage extends Stage {
    
  
    //private fields
   private ListView CurrentView;
   
   private SongCollection<EntryInterface> SongCollection;
   
    
     
    //defualt constructor
    public DeleteStage(){
      
        //create a new song collection
        SongCollection =  new SongCollection<EntryInterface>(){};
        
        //create a new list view 
        CurrentView = new ListView();
        
    }
    
    
    //overloaded constructor
    protected DeleteStage( SongCollection<EntryInterface> list, ListView  listView   ){
        
        //create a new song collection
        SongCollection = list;
        
        //create a new list view
        CurrentView = listView;
                
    }
    
    
    
    
    
    //getters     
    public ListView getCurrentView() {
        return CurrentView;
    }
    public SongCollection<EntryInterface> getSongCollection() {
        return SongCollection;
    }
  
    
    
    //method that creates a secene
   public Scene MainScene(){
       
       //new borderpane for the main user
       BorderPane mp = new BorderPane();
       
       //message for user
      Text txt = new Text("Are you sure you want to Delete Song From List?");
      
      txt.setFont(new Font( 18) );
      
      mp.setCenter(txt);
      
      //create a  new  buttons for yes and no
      Button BtnConform = BtnConform("Yes", txt);
      
      
      //set the font
      BtnConform.setFont(new Font(20) );
      
      Button btnDeny =  buttonDeny("No");
      
      //set the font
      btnDeny.setFont(new Font(20) );
      
      //create a new hbox
      HBox buttonhb = new HBox(BtnConform, btnDeny);
      
      //set the gap and spacing for hbox
      buttonhb.setAlignment(Pos.CENTER);
      buttonhb.setSpacing(10);
      
      //set the botttom of mp to the hbox
      mp.setBottom(buttonhb);
      
      
      //create a  new scene
      Scene sc = new Scene(mp,  500, 150); 
      
      
         //make the stage not resizeable
         this.setResizable(false);
      
      return sc;
   }
    
   //method for button conform
  private Button BtnConform(String name, Text message){
      
      //create a new button
      Button bt = new Button(name);
      
      
      bt.setOnAction(e ->{
          
                              //hold the songs removed
                  ObservableList  songsRemoved  =   CurrentView.getSelectionModel().getSelectedItems();
                     
                  
                  //create temp var to hold temp
                  int temp;
                  
                  //go through the songs remove observable list
                  for(Object index : songsRemoved)
                  {
                  
                      //store the index of the song
                     temp  =  songsRemoved.indexOf(index);
                      
                     //remove the song                     
                      SongCollection.remove(temp);
                 
                    }
               
                  
                  //reload the listbox
                   SongCollection.printAll( true);
               
              
                 //close the stage
                 this.close();
                 
            }
      
);
      
      
      
      
     return bt;
  }
   
  //method for button deny
  private Button buttonDeny(String name){
      
      //create a new button
      Button bt = new Button(name);
      
      //create event handler
      bt.setOnAction(e -> {
      
      
                 //close the stage
          this.close();
          
          
          
      } );
      
      return bt;
      
      
  }
   
}
