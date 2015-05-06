package com.dat.soslima;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.activity_main);
	}
	
	public void onClick_btnHospital(View v){
		Intent intent=new Intent(this,Hospitales.class);
		startActivity(intent);
	}
	
	public void onClick_btnClinica(View v){
		Intent intent=new Intent(this,Clinicas.class);
		startActivity(intent);
	}
	
	public void onClick_btnAmbulancia(View v){
		Intent intent=new Intent(this,Ambulancias.class);
		startActivity(intent);
	}
	
	public void onClick_btnBombero(View v){
		Intent intent=new Intent(this,Bomberos.class);
		startActivity(intent);
	}
	
	public void onClick_btnMapa(View v){
		Intent intent=new Intent(this,Mapa.class);
		startActivity(intent);
	}
	
	public void onClick_btnSerenazgo(View v){
		Intent intent=new Intent(this,Serenazgo.class);
		startActivity(intent);
	}

}
