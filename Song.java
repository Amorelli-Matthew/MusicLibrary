/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MusicLibraryApplication;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author matt

* 


*/

public class Song implements  EntryInterface , Serializable, Comparable {
    
    //variables to store song information
  private  int MusicId;

  private String Name;

 private String Artist;
   
 private  String Album;
   
  private GregorianCalendar  DateReleased;
   
  private String Description;

  
  
  
    //defualt constructor
   public Song(){
       
       MusicId = -1;
       
       Name = "Please input a song  name";
    
       Artist =  "Please input a Artist"; 
       
       Album = "Please input a Album";
       
      DateReleased = new GregorianCalendar();
      
      Description = "Please input a Song Description";
       
   }
   
   //overloaded constructor that adds items to the fields
   public Song(int id, String name, String artist, String album,  GregorianCalendar date,  String SongDes)
   {
       this.MusicId = id;
       
       this.Name = name;
       this.Artist = artist;
       
      this.Album = album;
       
      this.DateReleased = date;
      
      this.Description = SongDes;
       
   }
  
  
   
   //getter and setters for ther variables 
    public int getMusicId() {
        return MusicId;
    }

    public void setMusicId(int MusicId) {
        this.MusicId = MusicId;
    }

    
    
    public String getArtist() {
        return Artist;
    }

    public void setArtist(String Artist) {
        this.Artist = Artist;
    }

    
    
    public String getAlbum() {
        return Album;
    }

    public void setAlbum(String Album) {
        this.Album = Album;
    }

    
    
    public GregorianCalendar getDateReleased() {
        return DateReleased;
    }

    public void setDateReleased(GregorianCalendar DateReleased) {
        this.DateReleased = DateReleased;
    }

      
  
    
    
   
   
   
   
    
   //implement all  abstract methods from the entry interface
   
    @Override
    public Object getKey() {
            return this;
    }
    
    //name getter and setter
    @Override
    public void setName(String Name) {

            this.Name = Name;
    }

    @Override
    public String getName() {
        
        return this.Name;
    
    }
    
//desctription getter and setter
    @Override
    public void setDesctription(String desc) {
           this.Description = desc;
    }

    
    @Override
    public String getDesecription() {
    
        return this.Description;
    }

    
    //override the print method
    @Override
    public void print() {
        
           System.out.println( this.toString() );

    }

    
    
    //override the object toString method
    @Override
    public String toString()
    {
        return  this.getMusicId() + "\n" + this.getName()
                
                + "\n"  + this.getArtist() + "\n" + this.getAlbum() + "\n" 
 
                +  FormatDate()       +  "\n" + this.getDesecription();
    }


    
    
    //method that formats the date to the correct format
    public String  FormatDate(){
        
        //returns month day and year format
       return (this.DateReleased.get(DateReleased.MONTH) + 1 ) + "-" +  this.DateReleased.get( DateReleased.DATE ) + "-" + this.DateReleased.get( DateReleased.YEAR);       
    }
    
    
    
    @Override
    public int compareTo(Object o) {

        //if the object is an instance of Song
        if(  o instanceof Song  )
        {
            //create a reference variable and cast object o to Song
            Song So2 = (Song) o;
            
            //test if both objects are equal
        if(this.equals(So2) )
        {          
                   //return 0 because they are the same
                  return 0;
       }
                
        
        
         //test if this Song is greater than the other
        if (this.MusicId > So2.MusicId && this.Name.compareToIgnoreCase(So2.Name) > 0 )
           {
               if(this.Artist.compareToIgnoreCase(So2.Artist) > 0 && this.Album.compareToIgnoreCase(So2.Album) > 0 )
               {
                   //if the date is newer than the other date
                   if(this.DateReleased.compareTo(So2.DateReleased ) > 0 )
                   {
                         if(this.Description.compareToIgnoreCase(So2.Description) > 0 )
                         {
                             return 1;
                         }
                   }
                   
               }
               
           }      

               //if the song is not equal or if the song is less then the other song
          return -1;
        
        
        }
        

       //if the song is not equal or if the song is less then the other song
          return -1;
        
    }
          
    
    //override the equals interface
   @Override
    public boolean equals(Object o)
    {
        //if object o is an song object
        if(o instanceof Song)
        {
            //convert the object to a song and then assign it to a reference variable
            Song So2 = (Song) o;
                
            //compare the song objects to see if the are the same
          if(this.MusicId == So2.MusicId && this.Name.equals(So2.Name) )
           {
               if(this.Artist.equals(So2.Artist) && this.Album.equals(So2.Album) )
               {
                   if(this.DateReleased.compareTo(So2.DateReleased ) == 0 )
                   {
                       if(this.Description.equalsIgnoreCase(So2.Description) )
                       {
                           //return true because they are the same
                           return true;
                       }
                
                   }
               }
   
           }
   
        }
        
        //return false if the objects are different
                  return false;
    }

    
}


   
  
    
    

    