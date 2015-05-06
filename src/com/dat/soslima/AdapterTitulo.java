package com.dat.soslima;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterTitulo extends ArrayAdapter<Titulo>{

	ArrayList<Titulo> lista;
	Activity context;
	
	public AdapterTitulo(Activity context,ArrayList<Titulo> lista) {
		super(context,R.layout.titulo_listas_2,lista);
		this.lista=lista;
		this.context=context;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view=null;
		if(convertView==null){
			LayoutInflater inflator=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view=inflator.inflate(R.layout.titulo_listas_2,null);
			
			//crea un objeto de la clase ViewHolder
			final ViewHolder holder=new ViewHolder();
			
			//capturamos los view del layout titulo_listas
			holder.txttitulo=(TextView)view.findViewById(R.id.txtTitulo);
			holder.txtsubtitulo=(TextView)view.findViewById(R.id.txtSubtitulo);
			holder.imageview1=(ImageView)view.findViewById(R.id.imageView1);
			holder.txttitulo.setTag(this.lista.get(position));
			
			view.setTag(holder);
		}else{
			view=convertView;
			 ((ViewHolder)view.getTag()).txttitulo.setTag(this.lista.get(position));
		}
		
		final ViewHolder holder=(ViewHolder)view.getTag();
		Titulo t2=lista.get(position);
		
		holder.txttitulo.setText(t2.getTitulo());
		holder.txtsubtitulo.setText(t2.getSubtitulo());
		holder.imageview1.setImageResource(R.drawable.icono_h);
		
		return view;
	}
	
	static class ViewHolder{
		TextView txttitulo;
		TextView txtsubtitulo;
		ImageView imageview1;
	}
}
