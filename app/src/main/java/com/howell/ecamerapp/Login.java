package com.howell.ecamerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.EditText;

import com.howell.ecamap.R;

import java.io.File;

public class Login extends Activity{
	private Button login;
	private EditText username,password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.logo);

		createFile();
		
		new AsyncTask<Void, Integer, Void>() {

			@Override
			protected Void doInBackground(Void... arg0) {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
			@Override
			protected void onPostExecute(Void result) {
				// TODO Auto-generated method stub
				super.onPostExecute(result);
				Intent intent = new Intent(Login.this,CamTabActivity.class);
				startActivity(intent);
				finish();
			}
		}.execute();
		/*login = (Button)findViewById(R.id.btn_login);
		username = (EditText)findViewById(R.id.et_user_name);
		password = (EditText)findViewById(R.id.et_user_password);
		login.setOnClickListener(new OnClickListener() {
			//128.83
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
					Intent intent = new Intent(Login.this,CameraList.class);
					startActivity(intent);
					//finish();
				}else{
					
				}
			}
		});*/
	}
	
	private void createFile(){
		if(!existSDCard()){
			return;
		}
		File destDir = new File(Environment.getExternalStorageDirectory()+"/eCamera_AP");
		if (!destDir.exists()) {
			destDir.mkdirs();
		}
	}
	
	private boolean existSDCard() {  
    	if (Environment.getExternalStorageState().equals(
    		Environment.MEDIA_MOUNTED)) {
        	return true;  
        } else  
        	return false;  
    }  
	
	
//	@Override
//	protected void onStop() {
//		// TODO Auto-generated method stub
//		super.onStop();
//		finish();
//	}
}	
