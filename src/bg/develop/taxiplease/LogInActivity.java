package bg.develop.taxiplease;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import bg.develop.taxiplease.config.AppController;
import bg.develop.taxiplease.config.TaxiPleaseConfig;
import bg.develop.taxiplease.helpers.GPSTracker;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class LogInActivity extends Activity implements OnClickListener {

	private EditText etEmail, etPassword, etRegisterFirstName, etRegisterLastName, etRegisterEmail, etRegisterPassword, etRegisterRePassword;
	
	private Button btLogin, btRegisterForm, btRegister;
	
	private RelativeLayout rlRegisterForm;
	
	GPSTracker gpsTracker;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		initializeElements();

		loginFunctionality();
	}

	private void initializeElements() {
		/**
		 * Login Form elements
		 * */
		etEmail = (EditText) findViewById(R.id.etEmail);
		etPassword = (EditText) findViewById(R.id.etPassword);
		btLogin = (Button) findViewById(R.id.btnLogin);
		btRegisterForm = (Button) findViewById(R.id.btRegisterForm);
		/**
		 * Register Form elements
		 * */
		rlRegisterForm = (RelativeLayout) findViewById(R.id.rlRegistrationForm);
		etRegisterFirstName = (EditText) findViewById(R.id.etRegisterFirstName);
		etRegisterLastName = (EditText) findViewById(R.id.etRegisterLastName);
		etRegisterEmail = (EditText) findViewById(R.id.etRegisterEmail);
		etRegisterPassword = (EditText) findViewById(R.id.etRegisterPassword);
		etRegisterRePassword = (EditText) findViewById(R.id.etRegisterRePassword);
		btRegister = (Button) findViewById(R.id.btRegister);
		
		gpsTracker = new GPSTracker(this);
	}

	private void loginFunctionality() {
		btLogin.setOnClickListener(this);
		btRegisterForm.setOnClickListener(this);
	}
	
	private void toggleRegisterForm(){
		if (rlRegisterForm.isShown()) {
			rlRegisterForm.setVisibility(View.GONE);
		} else {
			rlRegisterForm.setVisibility(View.VISIBLE);
		}
	}

	public void loginRequest() {

//		String URL = TaxiPleaseConfig.BASE_URL + TaxiPleaseConfig.LOGIN_TAXI_USER;
//	 	
//		Log.d("TEST", "CASE 0 " + URL);
//
//		StringRequest loginRequest = new StringRequest(Request.Method.POST, URL,
//		           new Response.Listener<String>() {
//		               @Override
//		               public void onResponse(String response) {
//		                   // handle response
//		            	   Log.d("TEST", "CASE 1 " + response);

		            	   float lat = (float)43.117024;
		            	   float lon = (float)27.308578;
		            	   
		            	   if (gpsTracker.canGetLocation()) {
							lat = (float)gpsTracker.getLatitude();
							lon = (float)gpsTracker.getLongitude();
		            	   }
		            	   
		            	 Intent map = new Intent(getApplicationContext(), MapActivity.class);
		           		 map.putExtra("latitude", lat);
		           		 map.putExtra("longitude", lon);
		           		 startActivity(map);
		            	   
//		               }
//		           }, new Response.ErrorListener() {
//		               @Override
//		               public void onErrorResponse(VolleyError error) {
//		                   // handle error  
//		            	   Log.d("TEST", "CASE 2 " + error);
//		               }
//		           }) {
//
//			@Override
//		    public Map<String, String> getParams() {
//				Map<String, String> mParams = new HashMap<String, String>();
//				mParams.put("email", etEmail.getText().toString());
//				mParams.put("password", etPassword.getText().toString());
//		        return mParams;
//		    }
////		       @Override
////		       public Map<String, String> get{
////		           HashMap<String, String> headers = new HashMap<String, String>();
////		           headers.put("email", etEmail.getText().toString());
////		           headers.put("password", etPassword.getText().toString());
////		           return headers;
////		       }
//		   };
//
//		AppController.getInstance().addToRequestQueue(loginRequest);

		// Intent map = new Intent(getApplicationContext(), Map.class);
		// map.putExtra("latitude", (float)43.117024);
		// map.putExtra("longitude", (float)27.308578);
		// startActivity(map);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.btnLogin:
			loginRequest();
			break;
		case R.id.btRegisterForm:
			toggleRegisterForm();
			break;
		default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		if (!rlRegisterForm.isShown()) {
			super.onBackPressed();
		} else {
			toggleRegisterForm();
		}
		
	}

}
