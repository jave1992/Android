package com.dat.soslima;

//import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
//import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

public class Mapa extends FragmentActivity implements LocationListener{

	Intent intent;
	GoogleMap mapa;
	private final LatLng LIMA=new LatLng(-12.044021,-77.062595);
	
	private final LatLng HOSPITAL_ALBERTO_SABOGAL=new LatLng(-12.06425,-77.122276);
	private final LatLng HOSPITAL_ARZOBISPO_LOAYZA=new LatLng(-12.049477,-77.044567);
	private final LatLng HOSPITAL_CASIMIRO_ULLOA=new LatLng(-12.127981,-77.017928);
	private final LatLng HOSPITAL_CAYETANO_HEREDIA=new LatLng(-12.021975,-77.055382);
	private final LatLng HOSPITAL_CENTRAL_FAP=new LatLng(-12.103818,-77.029991);
	private final LatLng HOSPITAL_DANIEL_ALCIDES_CARRION=new LatLng(-12.063642,-77.124422);
	private final LatLng HOSPITAL_SAN_JOSE_DEL_CALLAO=new LatLng(-12.042736,-77.098661);
	private final LatLng HOSPITAL_DE_EMERGENCIAS_PEDIATRICAS=new LatLng(-12.058343,-77.021586);
	private final LatLng HOSPITAL_PUENTE_PIEDRA=new LatLng(-11.861933,-77.07933);
	private final LatLng HOSPITAL_DE_VITARTE=new LatLng(-12.026267,-76.919943);
	private final LatLng HOSPITAL_DE_HUAYCAN=new LatLng(-12.015564,-76.820272);
	private final LatLng HOSPITAL_DOS_DE_MAYO=new LatLng(-12.055773,-77.015793);
	private final LatLng HOSPITAL_EDGARDO_REBAGLIATI=new LatLng(-12.078571,-77.040265);
	private final LatLng HOSPITAL_GUILLERMO_ALMENARA=new LatLng(-12.05955,-77.022251);
	private final LatLng HOSPITAL_HERMILIO_VALDIZAN=new LatLng(-12.045427,-76.945907);
	private final LatLng HOSPITAL_HIPOLITO_UNANUE=new LatLng(-12.04102,-76.992404);
	private final LatLng HOGAR_CLINICA_SAN_JUAN_DE_DIOS=new LatLng(-12.065698,-76.989916);
	private final LatLng HOSPITAL_SAN_JUAN_DE_LURIGANCHO=new LatLng(-11.966154,-77.003563);
	private final LatLng HOSPITAL_MARIA_AUXILIADORA=new LatLng(-12.013685,-76.825881);
	private final LatLng HOSPITAL_MILITAR_CENTRAL=new LatLng(-12.08624,-77.061327);
	private final LatLng HOSPITAL_CENTRO_MEDICO_NAVAL=new LatLng(-12.059623,-77.090261);
	private final LatLng HOSPITAL_DE_LA_POLICIA=new LatLng(-12.084457,-77.060383);
	private final LatLng HOSPITAL_SANTA_ROSA=new LatLng(-12.072402,-77.06094);
	private final LatLng HOSPITAL_SERGIO_BERNALES=new LatLng(-11.914553,-77.038454);
	private final LatLng HOSPITAL_VICTOR_LARCO_HERRERA=new LatLng(-12.09756,-77.064362);
	private final LatLng INSTITUTO_ESPECIALIZADO_MATERNO_PERINATAL=new LatLng(-12.052379,-77.02173);
	private final LatLng INSTITUO_NACIONAL_DE_SALUD_DEL_NIÑO=new LatLng(-12.085412,-76.992028);
	private final LatLng INSTITUTO_NACIONAL_DE_CIENCIAS_NEUROLOGICAS=new LatLng(-12.042046,-77.115173);
	private final LatLng INSTITUTO_NACIONAL_DE_OFTALMOLOGIA=new LatLng(-12.051513,-77.055554);
	//
	private final LatLng CLINICA_ANGLO_AMERICANA=new LatLng(-12.109057,-77.039106);
	private final LatLng CLINICA_EL_GOLF=new LatLng(-12.098536,-77.05195);
	private final LatLng CLINICA_GONZALES=new LatLng(-12.082962,-77.03291);
	private final LatLng CLINICA_GOOD_HOPE=new LatLng(-12.125469,-77.034422);
	private final LatLng CLINICA_JAVIER_PRADO=new LatLng(-12.091297,-77.028366);
	private final LatLng CLINICA_JESUS_DEL_NORTE=new LatLng(-11.989811,-77.058772);
	private final LatLng CLINICA_LIMATAMBO=new LatLng(-12.100613,-77.019482);
	private final LatLng CLINICA_LOS_ANDES=new LatLng(-12.104762,-77.032126);
	private final LatLng CLINICA_MAISON_DE_SANTE_DEL_ESTE=new LatLng(-12.13047,-76.981145);
	private final LatLng CLINICA_MAISON_DE_SANTE_DEL_SUR=new LatLng(-12.157035,-77.022455);
	private final LatLng CLINICA_MAISON_DE_SANTE_LIMA=new LatLng(-12.057389,-77.033871);
	private final LatLng CLINICA_DENTAL_CAYETANO_HEREDIA=new LatLng(-12.02325,-77.055995);
	private final LatLng CLINICA_MONTESUR=new LatLng(-12.103332,-76.97297);
	private final LatLng CLINICA_RICARDO_PALMA=new LatLng(-12.090678,-77.018125);
	private final LatLng CLINICA_RICARDO_PALMA_2=new LatLng(-12.09078,-77.018393);
	private final LatLng CLINICA_SAN_CAMILO=new LatLng(-12.047159,-77.022401);
	private final LatLng CLINICA_SAN_GABRIEL=new LatLng(-12.076741,-77.095566);
	private final LatLng CLINICA_SAN_FELIPE=new LatLng(-12.085936,-77.054309);
	private final LatLng CLINICA_SAN_JOSE_REAÑO_RIOS_S_A=new LatLng(-12.085936,-77.054309);
	private final LatLng CLINICA_SAN_JUDAS_TADEO=new LatLng(-12.079988,-77.080081);
	private final LatLng CLINICA_SAN_PABLO=new LatLng(-12.100109,-76.971611);
	private final LatLng CLINICA_SAN_PABLO_ASIA=new LatLng(-12.759487,-76.602584);
	private final LatLng CLINICA_SANTA_ISABEL=new LatLng(-12.089398,-77.007102);
	private final LatLng CLINICA_STELLA_MARIS=new LatLng(-12.071133,-77.059684);
	private final LatLng CLINICA_TEZZA=new LatLng(-12.103335,-76.97204);
	private final LatLng CLINICA_VESALIO=new LatLng(-12.106341,-77.007369);
	private final LatLng CENTRO_MEDICO_CORPAC=new LatLng(-12.097481,-77.024091);
	private final LatLng MULTIDENT_LOS_OLIVOS=new LatLng(-11.994743,-77.073883);
	private final LatLng MULTIDENT_SAN_MIGUEL=new LatLng(-12.07939,-77.080353);
	private final LatLng MULTIDENT_LINCE=new LatLng(-12.088032,-77.047742);
	private final LatLng MULTIDENT_MIRAFLORES=new LatLng(-12.106763,-77.030865);
	private final LatLng MULTIDENT_SAN_BORJA=new LatLng(-12.100629,-76.99538);
	private final LatLng MULTIDENT_CHORRILLOS=new LatLng(-12.170895,-77.022628);
	private final LatLng MULTIDENT_SAN_ISIDRO=new LatLng(-12.09905,-77.052736);
	private final LatLng MULTIDENT_LIMA_LAS_CAOBAS=new LatLng(-12.090647,-76.949729);
	private final LatLng MULTIDENT_LIMA_LA_MERCED=new LatLng(-12.128618,-77.009435);
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mapa_layout);

		conexionInternet();
		
		mapa=((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		
		pintarMapa();
		
		/*CameraPosition campos=new CameraPosition.Builder().target(LIMA).zoom(11).build();
		CameraUpdate cu=CameraUpdateFactory.newCameraPosition(campos);
		mapa.animateCamera(cu);*/
		mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(LIMA, 11));
		
		mapa.setOnInfoWindowClickListener(new OnInfoWindowClickListener(){
			
			@Override
			public void onInfoWindowClick(Marker marker) {
				
				if(marker.getTitle().equals("Estamos por acá")){
				}else{
					String snippet=marker.getSnippet();
					String tel=snippet.substring(4);
					try{
						intent=new Intent(Intent.ACTION_CALL);
						intent.setData(Uri.parse("tel:01"+tel));
						startActivity(intent);
					}catch(ActivityNotFoundException activityException){
					}
				}
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		LocationManager locationManager=(LocationManager)getSystemService(LOCATION_SERVICE);
		Criteria criteria=new Criteria();
		String provider=locationManager.getBestProvider(criteria, true);
		locationManager.requestLocationUpdates(provider,1000*10,1,this);
	}
	
	@Override
	public void onLocationChanged(Location location) {
		
		mapa.clear();
		pintarMapa();
		
		MarkerOptions opcion = new MarkerOptions();
		opcion.position(new LatLng(location.getLatitude(),
				   				   location.getLongitude()));
		
		opcion.title("estoy aquí");
		
		opcion.icon(BitmapDescriptorFactory.fromResource
				(R.drawable.aquiestoy));
		
		mapa.addMarker(opcion);
	}

	@Override
	protected void onPause() {
		super.onPause();
		LocationManager locationManager =(LocationManager)getSystemService(LOCATION_SERVICE);
		locationManager.removeUpdates(this);
	}
	
	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	public void setMarker(GoogleMap map,LatLng position,String titulo,String tel){
		map.addMarker(new MarkerOptions()
		.position(position)
		.title(titulo)
		.snippet(tel)
		.icon(BitmapDescriptorFactory.fromResource(R.drawable.localizacion_hospital)));
	}
	
	public void setMarker2(GoogleMap map,LatLng position,String titulo,String tel){
		map.addMarker(new MarkerOptions()
		.position(position)
		.title(titulo)
		.snippet(tel)
		.icon(BitmapDescriptorFactory.fromResource(R.drawable.localizacion_clinica)));
	}
	
	private void conexionInternet(){
		
		ConnectivityManager cm=(ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo=cm.getActiveNetworkInfo();
		if(netInfo !=null && netInfo.isConnectedOrConnecting()){
		}else{
			AlertDialog.Builder dialog=new AlertDialog.Builder(Mapa.this);
			dialog.setMessage("La conexion a Internet parece estar desactivada.").
			setPositiveButton("OK", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			});
			AlertDialog alert=dialog.create();
			alert.show();
		}
	}
	
	private void pintarMapa(){
		setMarker(mapa,HOSPITAL_ALBERTO_SABOGAL, "Hospital Alberto Sabogal", "Tel:429-7744");
		setMarker(mapa,HOSPITAL_ARZOBISPO_LOAYZA, "Hospital Arzobispo Loayza", "Tel:431-3799");
		setMarker(mapa,HOSPITAL_CASIMIRO_ULLOA, "Hospital Casimiro Ulloa", "Tel:204-0900");
		setMarker(mapa,HOSPITAL_CAYETANO_HEREDIA, "Hospital Cayetano Heredia", "Tel:482-0402");
		setMarker(mapa,HOSPITAL_CENTRAL_FAP, "Hospital Central FAP", "Tel:513-5300");
		setMarker(mapa,HOSPITAL_DANIEL_ALCIDES_CARRION, "Hospital Daniel Alcides Carrion", "Tel:614-7474");
		setMarker(mapa,HOSPITAL_SAN_JOSE_DEL_CALLAO, "Hospital San Jose del Callao", "Tel:319-7830");
		setMarker(mapa,HOSPITAL_DE_EMERGENCIAS_PEDIATRICAS, "Hospital de Emergencias Pediatricas", "Tel:474-9790");
		setMarker(mapa,HOSPITAL_PUENTE_PIEDRA, "Hospital Puente Piedra", "Tel:548-2010");
		setMarker(mapa,HOSPITAL_DE_VITARTE, "Hospital de Vitarte", "Tel:351-4484");
		setMarker(mapa,HOSPITAL_DE_HUAYCAN, "Hospital de Huaycan", "Tel:371-6049");
		setMarker(mapa,HOSPITAL_DOS_DE_MAYO, "Hospital Dos de Mayo", "Tel:328-0028");
		setMarker(mapa,HOSPITAL_EDGARDO_REBAGLIATI, "Hospital Edgardo Rebagliati", "Tel:265-4901");
		setMarker(mapa,HOSPITAL_GUILLERMO_ALMENARA, "Hospital Guillermo Almenara Irigoyen", "Tel:324-2983");
		setMarker(mapa,HOSPITAL_HERMILIO_VALDIZAN,"Hospital Hermilio Valdizan","Tel:494-2429");
		setMarker(mapa,HOSPITAL_HIPOLITO_UNANUE,"Hospital Hipolito Unanue","Tel:362-7777");
		setMarker(mapa,HOGAR_CLINICA_SAN_JUAN_DE_DIOS,"Hogar Clinica San Juan de Dios","Tel:326-0945");
		setMarker(mapa,HOSPITAL_SAN_JUAN_DE_LURIGANCHO,"Hospital San Juan de Lurigancho","Tel:387-2300");
		setMarker(mapa,HOSPITAL_MARIA_AUXILIADORA,"Hospital Maria Auxiliadora","Tel:217-1818");
		setMarker(mapa,HOSPITAL_MILITAR_CENTRAL,"Hospital Militar Central","Tel:219-3500");
		setMarker(mapa,HOSPITAL_CENTRO_MEDICO_NAVAL,"Hospital Naval (Centro Medico Naval)","Tel:613-7800");
		setMarker(mapa,HOSPITAL_DE_LA_POLICIA,"Hospital de la Policia (San Luis N. Saenz)","Tel:463-0011");
		setMarker(mapa,HOSPITAL_SANTA_ROSA,"Hospital Santa Rosa","Tel:615-8200");
		setMarker(mapa,HOSPITAL_SERGIO_BERNALES,"Hospital Sergio Bernales","Tel:558-0187");
		setMarker(mapa,HOSPITAL_VICTOR_LARCO_HERRERA,"Hospital Victor Larco Herrera","Tel:261-5516");
		setMarker(mapa,INSTITUTO_ESPECIALIZADO_MATERNO_PERINATAL,"Instituto Especializado Materno Perinatal","Tel:328-0988");
		setMarker(mapa,INSTITUO_NACIONAL_DE_SALUD_DEL_NIÑO,"Instituto Especializado de Salud del Niño","Tel:330-0066");
		setMarker(mapa,INSTITUTO_NACIONAL_DE_CIENCIAS_NEUROLOGICAS,"Instituto Nacional de Ciencias Neurologicas","Tel:411-7700");
		setMarker(mapa,INSTITUTO_NACIONAL_DE_OFTALMOLOGIA,"Instituto Nacional de Oftalmologia","Tel:202-9060");
		
		setMarker2(mapa,CLINICA_ANGLO_AMERICANA,"Clínica Anglo Americana","Tel:616-8900");
		setMarker2(mapa,CLINICA_EL_GOLF,"Clínica El Golf","Tel:631-0000");
		setMarker2(mapa,CLINICA_GONZALES,"Clínica Gonzales","Tel:471-1579");
		setMarker2(mapa,CLINICA_GOOD_HOPE,"Clínica Good Hope","Tel:610-7317");
		setMarker2(mapa,CLINICA_JAVIER_PRADO,"Clínica Javier Prado","Tel:440-2000");
		setMarker2(mapa,CLINICA_JESUS_DEL_NORTE,"Clínica Jesus del Norte","Tel:613-4444");
		setMarker2(mapa,CLINICA_LIMATAMBO,"Clínica Limatambo","Tel:617-1111");
		setMarker2(mapa,CLINICA_LOS_ANDES,"Clínica Los Andes","Tel:221-0468");
		setMarker2(mapa,CLINICA_MAISON_DE_SANTE_DEL_ESTE,"Clínica Maison de Santé (este)","Tel:610-5520");
		setMarker2(mapa,CLINICA_MAISON_DE_SANTE_DEL_SUR,"Clínica Maison de Santé (sur)","Tel:467-5999");
		setMarker2(mapa,CLINICA_MAISON_DE_SANTE_LIMA,"Clínica Maison de Santé (Lima)","Tel:616-8900");
		setMarker2(mapa,CLINICA_DENTAL_CAYETANO_HEREDIA,"Clínica Dental Cayetano Heredia","Tel:207-6200");
		setMarker2(mapa,CLINICA_MONTESUR,"Clínica Montesur","Tel:317-4000");
		setMarker2(mapa,CLINICA_RICARDO_PALMA,"Clínica Ricardo Palma","Tel:224-2224");
		setMarker2(mapa,CLINICA_RICARDO_PALMA_2,"Clínica Ricardo Palma","Tel:224-2224");
		setMarker2(mapa,CLINICA_SAN_CAMILO,"Clínica San Camilo","Tel:427-0219");
		setMarker2(mapa,CLINICA_SAN_GABRIEL,"Clínica San Gabriel","Tel:614-2222");
		setMarker2(mapa,CLINICA_SAN_FELIPE,"Clínica San Felipe","Tel:219-0000");
		setMarker2(mapa,CLINICA_SAN_JOSE_REAÑO_RIOS_S_A,"Clínica San Jose Reaño Rios S.A.","Tel:451-3454");
		setMarker2(mapa,CLINICA_SAN_JUDAS_TADEO,"Clínica San Judas Tadeo","Tel:219-1100");
		setMarker2(mapa,CLINICA_SAN_PABLO,"Clínica San Pablo","Tel:610-3222");
		setMarker2(mapa,CLINICA_SAN_PABLO_ASIA,"Clínica San Pablo Asia","Tel:5307887");
		setMarker2(mapa,CLINICA_SANTA_ISABEL,"Clínica Santa Isabel","Tel:475-7777");
		setMarker2(mapa,CLINICA_STELLA_MARIS,"Clínica Stella Maris","Tel:463-6666");
		setMarker2(mapa,CLINICA_TEZZA,"Clínica Tezza","Tel:610-5050");
		setMarker2(mapa,CLINICA_VESALIO,"Clínica Vesalio","Tel:618-9999");
		setMarker2(mapa,CENTRO_MEDICO_CORPAC,"Centro Médico Córpac","Tel:442-7551");
		setMarker2(mapa,MULTIDENT_LOS_OLIVOS,"Multident Los Olivos","Tel:523-9763");
		setMarker2(mapa,MULTIDENT_SAN_MIGUEL,"Multident San Miguel","Tel:263-7878");
		setMarker2(mapa,MULTIDENT_LINCE,"Multident Lince","Tel:470-0585");
		setMarker2(mapa,MULTIDENT_MIRAFLORES,"Multident Miraflores","Tel:222-2599");
		setMarker2(mapa,MULTIDENT_SAN_BORJA,"Multident San Borja","Tel:225-4465");
		setMarker2(mapa,MULTIDENT_CHORRILLOS,"Multident Chorrillos","Tel:467-4942");
		setMarker2(mapa,MULTIDENT_SAN_ISIDRO,"Multident San Isidro","Tel:264-1201");
		setMarker2(mapa,MULTIDENT_LIMA_LAS_CAOBAS,"Multident Lima,Las Caobas 146","Tel:365-3676");
		setMarker2(mapa,MULTIDENT_LIMA_LA_MERCED,"Multident Lima,La Merced 227","Tel:273-3333");
	}
}
