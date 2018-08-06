package com.nt.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.nt.singleton.PrinterUtil;

public class DeserializationSingletonTest {
	
	
	public static  void  doSerialization(Object obj)throws IOException{
		ObjectOutputStream oos=null;
		FileOutputStream fos=null;
		fos=new FileOutputStream("e:\\singleton.ser");
		oos=new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.flush();
		fos.close();
		oos.close();
		System.out.println("Serailization completed");
	}
	
	public static  Object  doDeSerialization()throws IOException, ClassNotFoundException{
		ObjectInputStream ois=null;
		FileInputStream fis=null;
		Object obj=null;
		fis=new FileInputStream("e:\\singleton.ser");
		ois=new ObjectInputStream(fis);
		obj=ois.readObject();
		fis.close();
		ois.close();
		System.out.println("DeSerailization completed");
		return obj;
	}


	public static void main(String[] args) {
		PrinterUtil pu1=null,pu2=null;
		
		pu1=PrinterUtil.getInstance();
		//Perform Serialization
	/*	try{
			DeserializationSingletonTest.doSerialization(pu1);
		}
		catch(IOException ioe){
			ioe.printStackTrace();
			System.out.println("Problem Serialisation");
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Problem Serialisation");
		}*/
		
		try{
			pu2=(PrinterUtil)DeserializationSingletonTest.doDeSerialization();
			System.out.println(pu1.hashCode()+"   "+pu2.hashCode());
			System.out.println("pu1==pu2?"+(pu1==pu2));
		}
		catch(IOException ioe){
			ioe.printStackTrace();
			System.out.println("Problem DeSerialisation");
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Problem DeSerialisation");
		}
		

	}

}
