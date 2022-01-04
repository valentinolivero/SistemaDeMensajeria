package test;
import modelo.*;
import java.time.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OperadorMovil personal= new OperadorMovil(1,"Personal");
		OperadorMovil claro= new OperadorMovil(2,"Claro");
		OperadorMovil movistar=new OperadorMovil(3, "Movistar");
		
		Sistema sistema= new Sistema();
		/*
		 * 1-1) Intentar agregar a la lista el objeto SMS: fechaEnvio=11/12/2020, horaEnvio=17:37,
                numeroOrigen=1523456780, numeroDestino=156543210, texto=”Voy a llegar más tarde”,
                operadorOrigen=[OperadorMovil: codigoMovil: 1, companiaMovil="Personal"],
                operadorDestino=[OperadorMovil: codigoMovil: 2, companiaMovil="Claro"]
                
                Intentar agregar a la lista el objeto Email: fechaEnvio=13/12/2020, horaEnvio=15:16,
                origen=”informacion@unla.gob.ar”, destino=”alumno.com” , asunto=”Información - UNLa”,
                cuerpo=”Estimado alumno, le enviamos el protocolo para rendir el examen final virtual”
		 */
		try {
			System.out.println(sistema.agregarSMS(LocalDate.of(2020, 12, 11), LocalTime.of(17, 37),1523456780 , 156543210, "voy a llegar más tarde", personal, claro));
		   
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(sistema.agregarEmail(LocalDate.of(2020, 12, 13), LocalTime.of(15, 16),"informacion@unla.gob.ar" , "alumno.com", "Información - UNLa", "Estimado alumno, le enviamos el protocolo para rendir el examen final virtual"));
		   
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(sistema.agregarSMS(LocalDate.of(2020, 12, 11), LocalTime.of(17, 37),1523456780 , 1565432109, "voy a llegar más tarde", personal, claro));
		   
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(sistema.agregarEmail(LocalDate.of(2020, 12, 13), LocalTime.of(15, 16),"informacion@unla.gob.ar" , "alumno@gmail.com", "Información - UNLa", "Estimado alumno, le enviamos el protocolo para rendir el examen final virtual"));
		   
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		/*
		 * 2-1) Traer e imprimir el SMS con IdMensaje = 1 y cambiar el estado a Visto=true
           2-2) Traer e imprimir el Email con IdMensaje = 2 y cambiar el estado a Recibido=true
		 */
		System.out.println(((SMS)sistema.traerMensaje(1)).cambiarDeEstado(true));
		System.out.println(((Email)sistema.traerMensaje(2)).cambiarDeEstado(true));
		System.out.println(((SMS)sistema.traerMensaje(1)).toString());
		System.out.println(((Email)sistema.traerMensaje(2)).toString());
		/*
		 * 3) Agregar los siguientes objetos a la lista, al finalizar la carga, imprimirla:
              SMS: fechaEnvio=15/11/2020, horaEnvio=12:03, numeroOrigen=1523456780,
              numeroDestino=1598760883, texto=”Recibido OK”,
              operadorOrigen=[OperadorMovil: codigoMovil: 3, companiaMovil="Movistar"],
              operadorDestino=[OperadorMovil: codigoMovil: 2, companiaMovil="Claro"]

              SMS: fechaEnvio=10/12/2020, horaEnvio=13:16, numeroOrigen=1523456780,
              numeroDestino=1598768250, texto=”Gracias”
              operadorOrigen=[OperadorMovil: codigoMovil: 1, companiaMovil="Personal"],
              operadorDestino=[OperadorMovil: codigoMovil: 3, companiaMovil="Movistar"]

              Email: fechaEnvio=08/11/2020, horaEnvio=17:15, origen=”oo1@unla.gob.ar”,
              destino=”alumno@gmail.com.ar” , asunto=”Orientación a Objetos 1 - UNLa”, cuerpo=”Se adjunta la grilla
              de inscripciones al final de Diciembre”
              
              Email: fechaEnvio=10/12/2020, horaEnvio=08:19, origen=”informacion@gmail.com.ar”,
              destino=”cliente@gmail.com.ar” , asunto=”Ofertas”, cuerpo=”Aproveche nuestras Ofertas”

		 */
		try {
			System.out.println(sistema.agregarSMS(LocalDate.of(2020, 12, 15), LocalTime.of(12, 03),1523456780 , 1598760883, "Recibido OK", movistar, claro));
		    System.out.println(sistema.agregarSMS(LocalDate.of(2020, 12, 10), LocalTime.of(13, 16), 1523456780, 1598768250, "Gracias", personal, movistar));
		    System.out.println(sistema.agregarEmail(LocalDate.of(2020, 12, 8), LocalTime.of(17, 15),"oo1@unla.com.ar", "alumno@gmail.com.ar", "Orientación a Objetos 1 - UNLa", "Se adjunta la grilla\r\n"
		    		+ "de inscripciones al final de Diciembre"));
		    System.out.println(sistema.agregarEmail(LocalDate.of(2020, 12, 10), LocalTime.of(8, 19), "informacion@gmail.com.ar", "cliente@gmail.com.ar", "Ofertas", "Aproveche nuestras Ofertas"));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		/*
		 * 4-1) Traer e imprimir los mensajes que tengan como operadorOrigen la compañía “Personal”
           4-2) Traer e imprimir los mensajes que se hayan enviado el día 10/12/2020 entre las 8 y las 14Hs.
           4-3) Traer e imprimir los mensajes que se hayan enviado el día 15/12/2020 entre las 12 y las 13Hs y
           que tengan como compañía origen “Movistar”
		 */
		
		System.out.println(sistema.traerMensajes("Personal").toString());
		System.out.println(sistema.traerMensajes(LocalDate.of(2020, 12, 10), LocalTime.of(8, 0), LocalTime.of(14, 0)).toString());
	    System.out.println(sistema.traerMensajes(LocalDate.of(2020, 12, 15), LocalTime.of(12, 0), LocalTime.of(13, 0), "3").toString());
	    
	}

}
