package bg.develop.taxiplease;

import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.model.Marker;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

class CustomInfoWindow implements InfoWindowAdapter {
	  LayoutInflater inflater=null;

	  CustomInfoWindow(LayoutInflater inflater) {
	    this.inflater=inflater;
	  }

	  @Override
	  public View getInfoWindow(Marker marker) {
		  View InfoWindowView = inflater.inflate(R.layout.custom_info_window, null);
		    
		    String raw_snippet = marker.getSnippet();
		    
		    TextView id = (TextView) InfoWindowView.findViewById(R.id.tvDriverId);
	    	TextView seats = (TextView) InfoWindowView.findViewById(R.id.tvDriverSeats);
	    	TextView trunk_volume = (TextView) InfoWindowView.findViewById(R.id.tvDriverTrunkVolume);
	    	RatingBar rating = (RatingBar) InfoWindowView.findViewById(R.id.rbRating);
	    	id.setText(marker.getTitle());
	    	rating.setMax(100);
	    	rating.setProgress(65);
	    	
//	    	if( !(ratingstr.equals("null")) ){
//	            rating.setRating(Float.parseFloat(ratingstr));
//	        }

		return(InfoWindowView);
//	    return null;
	  }

	  @Override
	  public View getInfoContents(Marker marker) {
		  
//	    View InfoWindowView = inflater.inflate(R.layout.custom_info_window, null);
//	    
//	    String raw_snippet = marker.getSnippet();
//	    
//	    TextView id = (TextView) InfoWindowView.findViewById(R.id.tvDriverId);
//    	TextView seats = (TextView) InfoWindowView.findViewById(R.id.tvDriverSeats);
//    	TextView trunk_volume = (TextView) InfoWindowView.findViewById(R.id.tvDriverTrunkVolume);
//    	RatingBar rating = (RatingBar) InfoWindowView.findViewById(R.id.rbRating);
//    	id.setText(marker.getTitle());
//    	rating.setMax(100);
//    	rating.setProgress(65);
    	
//    	if( !(ratingstr.equals("null")) ){
//            rating.setRating(Float.parseFloat(ratingstr));
//        }

	    return null;
	  }
	  
//    private void render(Marker marker, View view) {
//    // Add the code to set the required values 
//    // for each element in your custom info window layout file
// 	
// 	TextView name = (TextView) MarkerView.findViewById(R.id.tvDriverName);
// 	TextView seats = (TextView) MarkerView.findViewById(R.id.tvDriverSeats);
// 	TextView trunk_volume = (TextView) MarkerView.findViewById(R.id.tvDriverTrunkVolume);
// 	RatingBar rating = (RatingBar) MarkerView.findViewById(R.id.rbRating);
// 	name.setText(marker.getTitle());
// 	rating.setProgress(65);
// 	
// }
	  
	}
