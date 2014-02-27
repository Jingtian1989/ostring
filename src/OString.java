import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.commons.codec.binary.Base64;


public class OString {

	public static String getObjectString(Serializable o) throws IOException{
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(o);
		oos.close();
		byte[] encodebase64 = Base64.encodeBase64(baos.toByteArray());
		return new String(encodebase64);
	}
	
	
	public static Object getStringObject(String s) throws IOException, ClassNotFoundException {
		
		byte[] data = Base64.decodeBase64(s);
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		ObjectInputStream ois = new ObjectInputStream(bais);
		Object o = ois.readObject();
		return o;	
	}
}
