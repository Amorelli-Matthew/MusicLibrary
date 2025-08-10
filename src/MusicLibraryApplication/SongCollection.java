/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MusicLibraryApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.control.ListView;



/**
 *
 * @author greenclover
 */

public class  SongCollection<T extends EntryInterface> extends ArrayList<EntryInterface> implements Serializable, CollectionInterface
{
    
    //keyword is this mean 
    
private ListView<String> CurrentView;

//default constructor
public SongCollection(){
    
}

//overloaded constructor
public SongCollection(ListView<String> cv)
{
    this.CurrentView = cv;
    
}    

      //method that prints the index of an element 
    @Override
    public void printIndex(boolean sortOrderAsc) {
   
        //create local variable for this
        SongCollection<T> list = this;
        
        //if the sortOrderAsc is true
        if(sortOrderAsc)
        {
            //sort the array
            sort(list);
        
        }
        
        //if the current listbox has no object
       if(CurrentView != null)
       {
           //go through the array
           for(EntryInterface  item :list)
           {               
           
               //add the index of the item to the listbox
               CurrentView.getItems().add( list.indexOf(item) + "" );
           
           }
           
           
       }
       
       else{
           
           //gothrough the array
           for(EntryInterface item : list)
           {
              //display the listbox index
               System.out.println( list.indexOf(item ));
               
           }
           
       }
    
    
    }

    
    //method that prints all the elements in an array
    @Override
    public void printAll(boolean sortOrderAsc) {

                //create local variable for this
        SongCollection<T> list = this;
        
        //if the sort orderAsc flag is on
        if(sortOrderAsc)
        {
            //sort the array
            sort(list);
            
        }
        

            //create local variable to hold the string format
        String ItemInFormat = "Id   Song   Artist    Album    Released   Description" ;
       
        //temp variable for song object
        Song temp ;
        
        //if current view has object
        if(CurrentView != null)
        {
             
            //clear the listbox
            CurrentView.getItems().clear();
        
            //add the item
              CurrentView.getItems().add(ItemInFormat);
        
              //go through array
           for(EntryInterface Item : list)
            {
                //if item is instance of song
                if(Item instanceof Song)
                {
                    //cast the item into song
                    temp = (Song) Item ;

                    //format the text on the listview
                 ItemInFormat =  temp.getMusicId() + "     " + temp.getName()                
                        + "    "  + temp.getArtist() + "     " + temp.getAlbum() + "    "  
                        +  temp.FormatDate()     +  "    " + temp.getDesecription();
            
                        //add the item to the listbox
                   CurrentView.getItems().add(ItemInFormat);
            
                }
                
            }

            
            
            
        }
        else
        {
            //go through the array
                for(EntryInterface item : list)
                    {
                        //display the item to string                   
                        System.out.println(item.toString() );
        
                     }   
          }

    }


        //method that saves each element in the array in at text file
    @Override
    public void saveAsText(String file, boolean sorted) {
   
        //create local variable for this
        SongCollection<T> list = this;
        
        //if sorted is checked
        if(sorted)
        {
            //sort the array
            sort(list);
            
        }
        
        try{
            
            //create a new file object
            File fileObject = new File(file);
        
            //create a new printwriter
            PrintWriter pw = new PrintWriter(fileObject);
            
            //create temp variable to hold songobject
           Song SongTemp;
           
           //go through list
           for(EntryInterface item : list)
           {

               
               //if item is an instance of song 
               if(item instanceof Song)
               {
                   //cast the item into songtemp
                   SongTemp = (Song) item;
             
                   //write song object fields to file
                   pw.print(SongTemp.getMusicId() );
                   
                   pw.print(SongTemp.getArtist() );
                   
                   pw.print(SongTemp.getAlbum());
                   
                   pw.print(SongTemp.getDateReleased() );
                   
                   pw.print(SongTemp.getDesecription() );
                   
               }
               
               else{
                   
                   //write the items name and desecription to file
                 pw.print(item.getName() );
                 
                 pw.print(item.getDesecription());
               }
               
           }
           
           //close the printwriter
           pw.close();
        }
        
        //catch any IoExceptions and display them
        catch(IOException ex)
        {
                            //if the current view has an object
                if(CurrentView != null)
                {
                    //create ErrorBox object
                    ErrorBox ErrorBox = new ErrorBox("Save File Not Found");
                   
                    //set the stage to the scene
                    ErrorBox.setScene(ErrorBox.ErrorSecene());
                    
                    //display the stage
                    ErrorBox.show();
                }
                
                 //display error in console
                 System.out.println("Save or Write File Error");
            
        }
        
    }

    
    //method that saves the elements in the array to a binary file
    @Override
    public void saveAsBinary(String file) {
      
         //create local variable for this
        SongCollection<T> list = this;
        
        try {

            //create a new File output stream
            FileOutputStream FOS = new FileOutputStream(file);
            
            //create a new object output stream
            ObjectOutputStream oits = new ObjectOutputStream(FOS);
            
            
            //go through array
            for(EntryInterface item : list)
              {
                  //write object to file
                  oits.writeObject( item);
            }
       
        
            //close file outputstream
            oits.close();
            
            //close objectoutput stram 
            FOS.close();
        
        }
        
        
        //catch any error
        catch(IOException ex)
        {
                //if the current view has an object
                if(CurrentView != null)
                {
                    //create ErrorBox object
                    ErrorBox ErrorBox = new ErrorBox("Save File Not Found");
                   
                    //set the stage to the scene
                    ErrorBox.setScene(ErrorBox.ErrorSecene());
                    
                    //display the stage
                    ErrorBox.show();
                }
                
                 //display error in console
                 System.out.println("Save or Write File Error");
        }
        
        
   
        
    }

    
    //method that loads the elements into an array from a binary file
    @Override
    public void loadFromBinary(String file) {

      //create local variable for this
        SongCollection<T> list = this;

        //clear the list
        list.clear();   
        
        //if the currentview has a object
        if(CurrentView != null)
        {
            //clear the items
            CurrentView.getItems().clear();
            
        }
        
        
            try{
            //create a new file object
            File fileObject = new  File(file);
            
            //create a new file input stream
           FileInputStream Fis = new FileInputStream(fileObject);
       
           //create a new object input stream
           ObjectInputStream Otis = new ObjectInputStream(Fis);
       
          //create  a temp variable
           EntryInterface temp;
          
          
           //while file has data
          while(Fis.available() != 0)
           {
               //read the object into temp
               temp = (EntryInterface) Otis.readObject();
               
               //add temp into the list
                 list.add(temp );
               
           }
           
           //close the object input stream
           Otis.close();
           //close the file input stream
           Fis.close();
           
           //Display output in console
           System.out.println("File Loaded from binary");
           
           
           
            }
            
            catch(FileNotFoundException ex)
            {
                //if the current view has an object
                if(CurrentView != null)
                {
                    //create ErrorBox object
                    ErrorBox ErrorBox = new ErrorBox("Save File Not Found");
                   
                    //set the stage to the scene
                    ErrorBox.setScene(ErrorBox.ErrorSecene());
                    
                    //display the stage
                    ErrorBox.show();
                }
                
                 //display error in console
                 System.out.println("Save File Not Found");
            }
            
            
            catch(IOException ex)
            {
               //create ErrorBox object
                if(CurrentView != null)
                {

                   //create ErrorBox object
                    ErrorBox ErrorBox = new ErrorBox("Save or Write File Error");

                     //set the stage to the scene
                    ErrorBox.setScene(ErrorBox.ErrorSecene() );
                    
                 //display the stage
                    ErrorBox.show();
                    
                     //display error in console
                     System.out.println("Save or Write File Error");
                }
            }
            catch (ClassNotFoundException ex)
            {
            
                 //create ErrorBox object
                if(CurrentView != null)
                {

                   //create ErrorBox object
                    ErrorBox ErrorBox = new ErrorBox(ex.getMessage());

                     //set the stage to the scene
                    ErrorBox.setScene(ErrorBox.ErrorSecene() );
                    
                 //display the stage
                    ErrorBox.show();
                }

                 //display error in console
                 System.out.println("Other Error");
            
            } 
            
            

            
            
                

    }
   
    
     //method that sorts an arraylist
private  void sort(ArrayList<EntryInterface> list)
      {
       //store the current min
       EntryInterface currentMin;
       
       //store the current min index
       int currentMinIndex;
       
       //go through the array
       for(int i = 0; i < list.size(); i++)
       {
           
           //get the current min
           currentMin = list.get(i);
           
           //store the currrent min index
           currentMinIndex = i;
           
           //go through other elemnts of the array
           for(int j = i +1; j < list.size() ; j++)
           {
               //compare the current min with the other elements
               if(currentMin.compareTo(list.get(j) )  > 0 )
               {
                   //store the new current min
                   currentMin = list.get( j );
                   
                   //store the current min index
                   currentMinIndex = j;
                   
               }
          
           }
           
           //if current min index isnt i
           if(currentMinIndex != i)
           {
               //store the current min index with i object
               list.set(currentMinIndex,  list.get(i) );
               
               //store i with the current min object 
               list.set(i,  currentMin);
               
           }
           
           
           
           
           
       }
       
       
       
       
   }
 
        
}
