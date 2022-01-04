package modelo;
import java.util.*;
import java.time.*;
public class Sistema {
private List<Mensaje> lstMensajes= new ArrayList<Mensaje>();

public List<Mensaje> getLstMensajes() {
	return lstMensajes;
}

public void setLstMensajes(List<Mensaje> lstMensajes) {
	this.lstMensajes = lstMensajes;
}

@Override
public String toString() {
	return "Sistema [lstMensajes=" + lstMensajes + "]";
}

public boolean agregarEmail(LocalDate fechaEnvio, LocalTime horaEnvio, String origen, String destino , String asunto, String cuerpo) throws Exception {
	int id;
	if(lstMensajes.size()==0) {
		id=1;
	}else {
		id=lstMensajes.get(lstMensajes.size()-1).getIdMensaje()+1;
	}
	Mensaje aux= new Email(id, fechaEnvio, horaEnvio, origen, destino, asunto, cuerpo, false);
	return lstMensajes.add(aux);
	
}
public boolean agregarSMS(LocalDate fechaEnvio, LocalTime horaEnvio, int numeroOrigen, int numeroDestino, String texto, OperadorMovil operadorOrigen, OperadorMovil operadorDestino) throws Exception {
	int id;
	if(lstMensajes.size()==0) {
		id=1;
	}else {
		id=lstMensajes.get(lstMensajes.size()-1).getIdMensaje()+1;
	}
	
	Mensaje aux= new SMS(id, fechaEnvio, horaEnvio, numeroOrigen, numeroDestino, texto,false,  operadorOrigen, operadorDestino);
	return lstMensajes.add(aux);
}
public Mensaje traerMensaje(int id) {
	Mensaje aux=null;
	boolean flag=false;
	int i=0;
	while(i<lstMensajes.size() && flag==false) {
		if(lstMensajes.get(i).getIdMensaje()==id) {
			aux=lstMensajes.get(i);
		}i++;
	}
    return aux;
}
public List<Mensaje> traerMensajes(String nombreCompañia){
	List<Mensaje> aux= new ArrayList<Mensaje>();
	for (int i=0;i<lstMensajes.size();i++) {
		if(lstMensajes.get(i) instanceof SMS) {
			if (((SMS) lstMensajes.get(i)).getOperadorOrigen().equalsNombreCompania(nombreCompañia)) {
				aux.add(lstMensajes.get(i));
			}
		}
	}
return aux;
}
/*
+ traerMensaje(LocalDate fecha, LocalTime horaDesde, LocalTime horaHasta) : Mensaje //retorna
una lista del tipo Mensaje con aquellos que tengan fecha y hora dentro de los parámetros
ingresados.
+ traerMensaje(LocalDate fecha, LocalTime horaDesde, LocalTime horaHasta, String
codigoCompania) : Mensaje //retorna una lista del tipo Mensaje con aquellos que tengan fecha y
hora dentro de los parámetros ingresados y además contentan operador origen de código
compañía con la compañía que ingresa como parámetro

*/
public List<Mensaje> traerMensajes(LocalDate fecha, LocalTime horaDesde, LocalTime horaHasta){
	List<Mensaje> aux= new ArrayList<Mensaje>();
	for (int i=0;i<lstMensajes.size();i++) {
		if (lstMensajes.get(i).getFechaEnvio().isEqual(fecha) && lstMensajes.get(i).getHoraEnvio().isBefore(horaHasta) && lstMensajes.get(i).getHoraEnvio().isAfter(horaDesde)) {
			aux.add(lstMensajes.get(i));
		}
	}
    return aux;
}
public List<Mensaje> traerMensajes(LocalDate fecha, LocalTime horaDesde, LocalTime horaHasta, String codigoCompania){
	List<Mensaje> aux= new ArrayList<Mensaje>();
	for (int i=0;i<lstMensajes.size();i++) {
		if (lstMensajes.get(i).getFechaEnvio().isEqual(fecha) && lstMensajes.get(i).getHoraEnvio().isBefore(horaHasta) && lstMensajes.get(i).getHoraEnvio().isAfter(horaDesde) && ((SMS) lstMensajes.get(i)).getOperadorOrigen().equalCodigo(codigoCompania)){
			
			aux.add(lstMensajes.get(i));
		}
	}
   return aux;
}
}
