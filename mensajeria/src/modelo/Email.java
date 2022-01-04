package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Email extends Mensaje {
private String origen;
private String destino;
private String asunto;
private String cuerpo;
private boolean recibido;
public Email(int idMensaje, LocalDate fechaEnvio, LocalTime horaEnvio, String origen, String destino, String asunto,
		String cuerpo, boolean recibido)throws Exception {
	super(idMensaje, fechaEnvio, horaEnvio);
	if (destino.indexOf("@")==-1) {
		throw new Exception ("Error, falta el @");
	}
	this.origen = origen;
	this.destino = destino;
	this.asunto = asunto;
	this.cuerpo = cuerpo;
	this.recibido = recibido;
}
public String getOrigen() {
	return origen;
}
public void setOrigen(String origen) {
	this.origen = origen;
}
public String getDestino() {
	return destino;
}
public void setDestino(String destino) {
	this.destino = destino;
}
public String getAsunto() {
	return asunto;
}
public void setAsunto(String asunto) {
	this.asunto = asunto;
}
public String getCuerpo() {
	return cuerpo;
}
public void setCuerpo(String cuerpo) {
	this.cuerpo = cuerpo;
}
public boolean isRecibido() {
	return recibido;
}
public void setRecibido(boolean recibido) {
	this.recibido = recibido;
}
@Override
public String toString() {
	return "Email [origen=" + origen + ", destino=" + destino + ", asunto=" + asunto + ", cuerpo=" + cuerpo
			+ ", recibido=" + recibido + "]";
}
@Override
public boolean cambiarDeEstado(boolean estadoNuevo) {
	// TODO Auto-generated method stub
	return recibido=estadoNuevo;
}




}
