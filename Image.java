public class Image { 

   private String imageUrl; 
   private String details; 
   
   public Image(String imageUrl, String details) { 
      this.imageUrl = imageUrl; 
      this.details = details;
   }
   
   public String getImageUrl(){ 
      return imageUrl; 
   } 
   
   public String getDetails(){ 
      return details; 
   } 
   
   public void shareImage(){ 
      System.out.println("Images shared!"); 
   } 
} 