package com.dat.soslima;

public class Titulo {

	private String titulo,subtitulo;
	
	public Titulo(String titulo,String subtitulo){
		this.titulo=titulo;
		this.subtitulo=subtitulo;
	}
	
	public void setTitulo(String titulo){
		this.titulo=titulo;
	}
	
	public String getTitulo(){
		return titulo;
	}
	
	public void setSubtitulo(String subtitulo){
		this.subtitulo=subtitulo;
	}
	
	public String getSubtitulo(){
		return subtitulo;
	}

	@Override
	public String toString(){
		return this.titulo;
	}
	
}
