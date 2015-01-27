package bg.develop.taxiplease;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class MapActivity extends Activity {

	private GoogleMap map;
	static LatLng Location = null;
	static LatLng Test = null;
	double latitude, longitude;
	float latitudeFromIntent, longitudeFromIntent;
	private String value;

	Marker taxi;
	
	Handler locationHandler;
	final static long REFRESH = 10 * 1000;
	final static int SUBJECT = 0;
	private GoogleMap mMap;
	private Marker myMarker = null;
	ArrayList<TaxiDriver> TaxiDriverArray;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);

		initializeElements();

		findLocation();
	}

	private void initializeElements() {
		TaxiDriverArray = new ArrayList<TaxiDriver>();
		addTaxiMarkers(GetTaxiDrivers());
		Intent in = getIntent();
		value = in.getStringExtra("location");
		latitudeFromIntent = in.getFloatExtra("latitude", 0);
		longitudeFromIntent = in.getFloatExtra("longitude", 0);

	}

	private void findLocation(){
		Geocoder geoc = new Geocoder(getApplicationContext());
		try {
			if (latitudeFromIntent != 0 && longitudeFromIntent != 0){
				Location = new LatLng(latitudeFromIntent, longitudeFromIntent);
			} else {
				List<Address> ls = geoc.getFromLocationName(value, 1);
				Address a = ls.get(0);
				latitude = a.getLatitude();
				longitude = a.getLongitude();
				Location = new LatLng(latitude, longitude);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			Location = new LatLng(-33.773557, 151.118431);
			
		}
		
		try {
			 MapFragment myMapFragment 
	         = (MapFragment)getFragmentManager().findFragmentById(R.id.map);
	        map = myMapFragment.getMap();
//			map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
			if(Location!=null){
				
//				map.addMarker(new MarkerOptions().position(Location).title(value));
				Log.d("LOCATION", " " + Location.latitude + " " + Location.longitude);
				Marker taxi1 = map.addMarker(new MarkerOptions()
		          .position(Location)
		          .title("Vladimir")
		          .snippet("this looks cool")
		          .icon(BitmapDescriptorFactory
		          .fromResource(R.drawable.taxi_small)));
				
				map.setInfoWindowAdapter(new CustomInfoWindow(getLayoutInflater()));
				map.setMyLocationEnabled(true);
				map.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
					
					@Override
					public void onInfoWindowClick(Marker marker) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(), "This is " + marker.getTitle(), Toast.LENGTH_LONG).show();
					}
				});
//				locationHandler = new Handler() {
//				        public void handleMessage(Message msg) {
//				            if (msg.what == SUBJECT) {
//
//				            	taxi1.setPosition(Location);
//				                this.sendEmptyMessageDelayed(SUBJECT, REFRESH);
//				            }
//				        }
//				    };
				    
//				 Move the camera instantly to hamburg with a zoom of 15.
			    map.moveCamera(CameraUpdateFactory.newLatLngZoom(Location, 15));
//			    test();
			}
		} catch (NullPointerException e){
			e.printStackTrace();
		}
	}
	
	private ArrayList<TaxiDriver> GetTaxiDrivers(){
		TaxiDriverArray.clear();
		
		
		
		return TaxiDriverArray;
	}
	
	private void addTaxiMarkers(ArrayList<TaxiDriver> list){

		for (TaxiDriver Driver : list) {
			//Get Driver details
			String name = Driver.getName();
			String car_model = Driver.getCarModel();
			int rating = Driver.getRating();
			int seats = Driver.getSeats();
			int trunk_volume = Driver.getTrunkVolume();
			
			
		}
	}

}
