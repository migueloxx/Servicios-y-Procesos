package tarea_3_Procesos_En_Java;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Tarea_3 {
	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		String comando = "CMD /C DIR C:\\";
		String comando2 = "CMD /C FIND \"Windows\"";
		Process p = null;
		Process p2 = null;
		try {
			p = r.exec(comando);
			p2 = r.exec(comando2);

			// Apertura de puerta para que entren los datos de p en p2
			OutputStream os = p2.getOutputStream();
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String linea;
			while ((linea = br.readLine()) != null)

			// Envio de datos que se leen de p a p2 hasta qe se acabe
			os.write((linea + "\n").getBytes());
			os.close();

			
			OutputStream os2 = p.getOutputStream();
			InputStream is2 = p2.getInputStream();
			BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
			String linea2;
			while ((linea2 = br2.readLine()) != null){
				
				System.out.println(linea2);
			}
			// Envio de datos que se leen de p a p2 hasta qe se acabe			
			br2.close();
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		} 

		// COMPROBACION DE ERROR - 0 bien 1 - mal
		int exitVal;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
