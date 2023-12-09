import java.util.List;
import java.util.ArrayList;  
import java.util.Scanner;

public class Moodboard implements MoodboardObserver { 

   private String query; 
   private List<Image> images;
   private UnsplashAPI unsplashAPI; 
   private List<MoodboardObserver> observers;   
   
   /**
   * Creates Moodboard instance with the specified Unsplash API
   * @param       unsplash API for images
   */
   public Moodboard(UnsplashAPI unsplashAPI){ 
      this.unsplashAPI = unsplashAPI; 
      this.observers = new ArrayList<>(); 
   } 
   
   /**
   * Creates observer for the list of observers
   * @param       observer to add to list
   */
   public void addObserver(MoodboardObserver observer) { 
      observers.add(observer); 
   } 
   
   /**
   * Gets the search query
   * @return      the current query
   */
   public String getQuery(){ 
      return query; 
   } 
   
   /**
   * Sets the query
   * @param       the new query
   */
   public void setQuery(String query){ 
      this.query = query;
   }  
   
   /**
   * Uses current query to fetch images from Unsplash API
   * notifies the observers
   */
   public void getPhoto() { 
      images = unsplashAPI.searchImages(query); 
      notifyObservers(); 
   }
   
   public void postPhoto() { 
      //Post images
   }    
   
   /**
   * Refreshes the moodboard with new images with the current query
   * notifies the observers
   */
   public void refreshPhoto() { 
      if (query != null && !query.isEmpty()) { 
         images = unsplashAPI.searchImages(query); 
         notifyObservers();
         } else { 
            System.out.println("Please enter a Mood"); 
            } 
   } 
   
   /**
   * Clears the current photo & search query
   * notifies the observers
   */
   public void clearPhoto() { 
      query = null; 
      images.clear();  
      notifyObservers(); 
   } 
   
   /**
   * Shares the photo
   * notifiies the observers
   */
   public void sharePhoto() { 
      if (images != null && !images.isEmpty()) { 
         for (Image image : images) { 
            image.shareImage(); 
         } 
         System.out.println("Mood Shared");
        } else { 
            System.out.println("No moods to share"); 
         }
      notifyObservers();  
      }
      
   private void notifyObservers() { 
      for (MoodboardObserver observer : observers) { 
         observer.update(this); 
      } 
   }

   @Override
   public void update(Moodboard moodboard){ 
   }  
}
   

