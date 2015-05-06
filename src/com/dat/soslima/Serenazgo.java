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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Serenazgo extends Activity {

	ListView lv;
	Titulo beans;
	ArrayList<Titulo> lista=new ArrayList<Titulo>();
	ArrayList<Titulo> lista2=new ArrayList<Titulo>();
	Intent intent;
	boolean estado;
	EditText editText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.serenazgo_layout);
		
		ActionBar actionBar=getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		lv=(ListView)findViewById(R.id.listViewSerenazgos);
		editText=(EditText)findViewById(R.id.edSerenazgo);
	
		UtilDB db = UtilDB.GetUtilDb(this);
		db.openDataBase();
		Cursor c=db.getDataBase().rawQuery("SELECT * FROM serenazgo",null);
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
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
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
					//el caracter introducido lo convertimos a String y luego lo convertimos a minuscula
					String filterString=s.toString().toLowerCase();
					//del 'editText' sacamos la cantidad de caracteres
					int textlenght=editText.getText().length();
					lista2.clear();
					//recorremos de toda la 'lista'
					for(int i=0;i<lista.size();i++){
						//extraemos el titulo de la 'lista' de la posicion 'i' 
						String texto=lista.get(i).getTitulo().toString();
						//comparamos si 'textlenght' es menor o igual a la cantidad de 'texto'
						if(textlenght<=texto.length()){
							//el 'texto' a minuscula y luego comparamos el filtro
							if(texto.toLowerCase().contains(filterString)){
								//a 'lista2' agregamos de la 'lista' de posicion 'i'
								lista2.add(lista.get(i));
							}
						}
					}
					estado=true;
					//el listview 'lv' le pasamos el adaptador 'AdapterTitulo2'
					lv.setAdapter(new AdapterTitulo(Serenazgo.this,lista2));
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
