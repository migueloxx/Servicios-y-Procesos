package ejemplo_1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo_1 {
	public static void main (String[] args){
		Runtime r = Runtime.getRuntime();
		String comando = "CMD /C DIR";
		Process p=null;	

		try{
 p = r.exec(comando);
	InputStream is = p.getInputStream();
	BufferedReader br = new BufferedReader(new InputStreamReader(is));
	String linea;
	while ((linea = br.readLine()) != null)
	
		System.out.println(linea);
	br.close();
}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		//control de mensajes de error
		try{
 p = r.exec(comando);
	InputStream er = p.getErrorStream();
	BufferedReader brer = new BufferedReader(new InputStreamReader(er));
	String liner = null;
	while ((liner = brer.readLine()) != null)
	
		System.out.println(liner);
	brer.close();
}
		catch (Exception e)
		{
			e.printStackTrace();
		}
}
}
