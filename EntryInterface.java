/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MusicLibraryApplication;

/**
 *
 * @author matt
 */
 interface EntryInterface extends Comparable{
    
   //method that returns a key
   Object getKey();
    
   
   //method that sets a name variable
   void setName(String Name);
    
   //method that returns a name
   String getName();
    
    
    //method that sets a description
   void setDesctription(String desc);
    
   //method that returns a description
   String getDesecription();
    
    //displays something
   void print();
    
  
   //overrides the compare to class to compare an object with another object
   //took me 2 weeks to figure this out
   @Override
   int compareTo(Object o);   
   
    
}
