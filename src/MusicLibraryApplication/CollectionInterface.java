/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MusicLibraryApplication;

/**
 *
 * @author greenclover
 */
public interface CollectionInterface  {
    
    //prints the index of each element in an arraylist
    public void printIndex(boolean sortOrderAsc);
    
    //displays all the elements in an arraylist
    public void printAll(boolean stortOrderAsc);
    
    //saves the elements in an arraylist as text
    public void saveAsText(String file, boolean sorted);
    
    //saves the elements in an arraylist as binary
    public void saveAsBinary(String file);
    
    //loads the elements from a file to an arraylist
    public void loadFromBinary(String file);
}
