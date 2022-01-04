package modelo;
import java.time.*;
public abstract class Mensaje {
protected int idMensaje;
protected LocalDate fechaEnvio;
protected LocalTime horaEnvio;
public Mensaje(int idMensaje, LocalDate fechaEnvio, LocalTime horaEnvio) {
	super();
	this.idMensaje = idMensaje;
	this.fechaEnvio = fechaEnvio;
	this.horaEnvio = horaEnvio;
}
public int getIdMensaje() {
	return idMensaje;
}
public void setIdMensaje(int idMensaje) {
	this.idMensaje = idMensaje;
}
public LocalDate getFechaEnvio() {
	return fechaEnvio;
}
public void setFechaEnvio(LocalDate fechaEnvio) {
	this.fechaEnvio = fechaEnvio;
}
public LocalTime getHoraEnvio() {
	return horaEnvio;
}
public void setHoraEnvio(LocalTime horaEnvio) {
	this.horaEnvio = horaEnvio;
}
@Override
public String toString() {
	return "Mensaje [idMensaje=" + idMensaje + ", fechaEnvio=" + fechaEnvio + ", horaEnvio=" + horaEnvio + "]";
}
public abstract boolean cambiarDeEstado(boolean estadoNuevo);
}
