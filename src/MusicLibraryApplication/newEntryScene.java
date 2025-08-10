/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MusicLibraryApplication;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 *
 * @author greenclover
 */
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class newEntryScene extends Stage{
    
    
    //create a  new song object
    Song SongObject;
    
    
    
        //textField  reference variables
   TextField TF_MusicId;

  TextField TF_SongName;
  
   TextField TF_Artist;
   
   TextField TF_album;
   
   TextField TF_DateReleased;
   
   TextField TF_SongDescription;
    
    
    public  Scene mainScene(SongCollection<EntryInterface> list )
    {
        
        //create a new song object
         SongObject = new Song();
        
         //create a new borderpane
        BorderPane MainPane = new BorderPane();
       
        //create a new gridpane
        GridPane elementsPane =  CreateGridPane();
        
        //set the gridpane to center
        elementsPane.setAlignment(Pos.CENTER);
        
        //set the center of the mainpane to gridpane
        MainPane.setCenter(elementsPane);
       
        //create a new button
        Button addEntry = new  Button("Add Song");
        
        addEntry.setFont(new Font(15));
       
        //set the button to the left
        addEntry.setAlignment(Pos.BOTTOM_LEFT) ;

        
        
 
            //title text and font
             Text TittleText = new Text("New Entry");
            TittleText.setFont(new Font(20));
  

            //set the title of the scene
           MainPane.setTop(TittleText);

        
        
        
        
        
        
        //register an event handler to add entry
        addEntry.setOnAction( (ActionEvent E) -> { 
    

            try
            {
                //resset the title text from the error
                MainPane.setTop(TittleText);
                
                //check if the textboxes are empty
          if( !(TF_MusicId.getText().equals("" )  )  )
            if(  !( TF_SongName.getText().equals("")  )   )
               if ( !(TF_Artist.getText().equals("" )  )  )
                    if(    !( TF_album .getText() .equals("")    )   )
                        if( !(TF_DateReleased .getText().equals("")  )  )
                            if(!(TF_SongDescription.getText().equals("" )   )  )
                            {
           
                                
                                
                                //set the song objects fields to the textfields
                
                                
                                  //set the user input to the song object
                                  SongObject.setMusicId( Integer.parseInt(TF_MusicId.getText() )   );
                                
                                      SongObject.setName(TF_SongName.getText() );

                                      SongObject.setArtist(TF_Artist.getText() );

                                  SongObject.setAlbum(TF_album .getText()   );

                                  
                                  //create a new date parser object
                                  DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

                                  //parse the date released
                                  SongObject.getDateReleased().setTime(  df.parse(TF_DateReleased.getText()  )   );
                             

                                  
                                SongObject.setDesctription( TF_SongDescription.getText() );
              
                                
                                
                                //check if the song isnt a duplicate
                                if(NotADuplicate(list) )
                                {
                                        //add song to the list
                                   list.add(SongObject);
                                
                                   //close the stage
                                   this.close();
                                
                                }
                                
                                else
                                {
                                    //create a new song object
                                      SongObject = new Song();
                            
                                      //display an error
                                      MainPane.setTop(new Text("Error, "+ "Duplicate, Try again" )  );
                                }
                         }
        
            }
          
            //catch any errors
             catch(NumberFormatException | ParseException ex)
            {
                        //create a new song object
                            SongObject = new Song();
                            
                            //display an error
                            MainPane.setTop(new Text("Error, try again")  );
            }
        
    
    }
);
        
        //set the bottom of the mainpane to the center
        MainPane.setBottom(addEntry);
        
        //create a new scene
        Scene scene  = new Scene(MainPane, 550,  300);
        
        
        
        //return the scene
        return scene;
    }
    
    


    
    
//method that creates a gridpane
    public  GridPane CreateGridPane(){
  
        //create objects for the referece variable TextFields
        TF_MusicId = new TextField("0");
  TF_SongName = new TextField("name ");  
  TF_Artist = new TextField("artist ");   
  TF_album = new TextField("album");   
  TF_DateReleased = new TextField(" Date's in MM/dd/yyyy");
  TF_SongDescription = new TextField("desc");
  
  
  
  
  
  
  
  //register the TextFields with event handlers
  
  Fields("Id"); 
  
  Fields("Artist");
  
  Fields("Album" );
  
  Fields("DateReleased");
  
  Fields("SongDescription");
  
  
    
  
        //create a new gridpane
        GridPane gp = new GridPane();
        
        //add the labels
        gp.add(createLabel("Music Id :") , 0, 0);
        
        gp.add(createLabel("Song Name :"), 0, 1);
        gp.add(createLabel("Artist:") , 0,  2);
        gp.add(  createLabel(" Album: "), 0,  3);
        gp.add(  createLabel( "Date Released : " ) , 0,  4);
        gp.add( createLabel(" Song Description : "), 0,  5);
        
       //create a new textfields for the labels
        gp.add( TF_MusicId ,  1, 0);     
        
        
        gp.add( TF_SongName ,  1, 1);        
        gp.add( TF_Artist , 1,  2);        
        gp.add( TF_album,  1,  3);        
        gp.add(  TF_DateReleased,  1,  4);        
        gp.add(  TF_SongDescription ,  1,  5);
        
        /// set the gridlines to true
        gp.setGridLinesVisible(true);
        
        //return the group pane
        return gp;
    }
    
    
    //method that creates labels
    private static Label createLabel(String name) {
        //create a tmp label
        Label tmp = new Label(name);
        
        //set the font
        tmp.setFont(  new Font(15)  );
        
        //return tmp
        return tmp;
        
    }
    
    
   //method that registers event handlers to fields
   private void Fields( String TypeOfFeild)
   {
       //check what type of textfield was passed to it
       switch(TypeOfFeild)
       {
          //if ID           
           case "Id":
              
               //create an event handler on musicI IDs TextField and set the Song Object to the music id               
               TF_MusicId.setOnAction(e ->    SongObject.setMusicId( Integer.parseInt(TF_MusicId.getText())  ) );
               
               
               break;
           
           //if artist
           case "Artist":
               
               //regester event handler to artist TextField
                 TF_Artist.setOnAction(e ->  SongObject.setArtist(TF_Artist.getText() ) );
       
               break;
       
               
           case "Album":
               
               TF_album.setOnAction(e ->  SongObject.setAlbum(TF_album.getText() )  );
               
               break;
               
               
           case "DateReleased":
               
           
               TF_DateReleased.setOnAction(  e -> {
           
                   //create a new date format
                    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

                    
           try {
               
                //set the date of the song object to the date in the text field
               SongObject.getDateReleased().setTime(  df.parse(TF_DateReleased.getText()  )   );
          
           } catch (ParseException ex) {  
           
               //create a new ErrorBox object
               ErrorBox Error = new ErrorBox("Incorrect Date");
               
               //set the Errror sccene
               Error.setScene(Error.ErrorSecene() );
               
               //Display The error
               Error.show();
             
                           
           }
               
           });


               break;
               
            case"SongDescription":
                
               TF_SongDescription.setOnAction( e -> SongObject.setDesctription( TF_SongDescription.getText() )  );
                break;
               
       }
   }
    
    
    private  boolean NotADuplicate(SongCollection<EntryInterface> list)
    {
        
        //create var to hold the other element
        Song OtherElement;
        
        
        //go through the array
        for(int index = 0; index < list.size(); index++ )
        {
            //assign an element of the array to other element
            OtherElement = (Song) list.get(index);
            
            //if the song object equals to the other elemnt
                  if(SongObject.equals( OtherElement )  )
                  {
                      //return false
                         return false;

                   }
          
        }
        
        
        //return true if there is no duplicates
       return true;
        
    }
}
