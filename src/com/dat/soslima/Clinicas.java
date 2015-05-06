package com.dat.soslima;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;

public class Clinicas extends Activity {
	
	Titulo beans;
	ArrayList<Titulo> lista=new ArrayList<Titulo>();
	ArrayList<Titulo> lista2=new ArrayList<Titulo>();
	ListView lv;
	EditText editText;
	boolean estado;
	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clinicas_layout);
		
		ActionBar actionBar=getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		lv=(ListView)findViewById(R.id.listViewClinicas);
		editText=(EditText)findViewById(R.id.edClinica);
	
		UtilDB db = UtilDB.GetUtilDb(this);
		db.openDataBase();
		Cursor c=db.getDataBase().rawQuery("SELECT * FROM clinica",null);
		
		if(c.moveToFirst()){
			do{
				beans=new Titulo(c.getString(0),c.getString(1));
				lista.add(beans);
			}while(c.moveToNext());
			db.close();
			c.close();
			AdapterTitulo adapter=new AdapterTitulo(this,lista);
			lv.setAdapter(adapter);
			estado=false;
			
			lv.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int position, long arg3) {
					try{
						intent=new Intent(Intent.ACTION_CALL);
						if(estado){
							intent.setData(Uri.parse("tel:01"+lista2.get(position).getSubtitulo()));
						}else{
							intent.setData(Uri.parse("tel:01"+lista.get(position).getSubtitulo()));
						}
						startActivity(intent);
					}catch(ActivityNotFoundException activityException){
					}
				}
			});
			
			editText.addTextChangedListener(new TextWatcher(){

				@Override
				public void afterTextChanged(Editable s) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void beforeTextChanged(CharSequence s, int start,
						int count, int after) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onTextChanged(CharSequence s, int start,
						int before, int count) {
					String filterString=s.toString().toLowerCase();
					int textlenght=editText.getText().length();
					lista2.clear();
					for(int i=0;i<lista.size();i++){
						String texto=lista.get(i).getTitulo().toString();
						if(textlenght<=texto.length()){
							if(texto.toLowerCase().contains(filterString)){
								lista2.add(lista.get(i));
							}
						}
					}
					estado=true;
					lv.setAdapter(new AdapterTitulo(Clinicas.this,lista2));
				}	
			});
		}
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case android.R.id.home: super.onBackPressed();
								return true;
		}
		return (super.onOptionsItemSelected(item));
	}
}
