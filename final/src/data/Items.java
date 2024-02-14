package data;


public class Items {

	private String music;
	private String movie;
	
	
	public Items(String music, String movie){
		this.music=music;
		this.movie=movie;
	}
	public String getmusicType() {
	 	 return music; 
	}
	public void setmusicType(String music_Type) { 
		 this.music=music_Type;
	}
	public String getmovieType() {
	 	 return movie; 
	}
	public void setmovieType(String movieType) { 
		 this.movie=movieType;
	} 
}