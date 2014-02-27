import java.io.IOException;
import java.io.Serializable;


public class Test implements Serializable{
	
	String name;
	int age;

	public Test(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String toString(){
		
		return name + ", " + age;
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Test t = new Test("test", 1);
		String ts = OString.getObjectString(t);
		Test st = (Test) OString.getStringObject(ts);
		System.out.println(st);
		
	}
	
}
