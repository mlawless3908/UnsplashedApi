import java.util.List; 

public class UnsplashAPI { 

   private String accessKey; 
   
   /**
   * Creates an UnsplashAPI instance with access key.
   * @param accessKey      the key to authenticate API 
   */
   public UnsplashAPI(String accessKey){ 
      this.accessKey = accessKey; 
   }
   
   /**
   * Search for images based on query
   * @return               List of images based on query
   */
   public List<Image> searchImages(String moodDescription) { 
      return null;
   } 
}
