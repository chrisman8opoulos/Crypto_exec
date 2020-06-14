package yao;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import gates.Gates;
import gates.Not;

public class Crypto_tools {
	public static void swap(byte[] a,byte[] b)
	{
		byte[] h;
		h=a;
		a=b;
		b=h;
	}
	
	//παίρνουμε τιμή από το πίνακα αλήθειας που δημιουργούμε για τις πύλες που κληρονομούν τα χαρακτηριστικά 
	//της κλάσης Gates δηλαδή τις And,Or,Xor
	public static void printLut(Gates gate,String title)
	{
		System.out.println(title);
		for(int i=0;i<4;i++)
		{
			System.out.println(getHex(gate.getLutEntry(i)));
		}
		System.out.println();
	}
	//παίρνουμε τιμή από το πίνακα αλήθειας της Not
	public static void printLut1(Not gate,String title)
	{
		System.out.println(title);
		for(int i=0;i<2;i++)
		{
			System.out.println(getHex(gate.getLutEntry(i)));
		}
		System.out.println();
	}
	
	public static String getHex(byte[] b)
	{
		String result="";
		for(int j=0;j<b.length;j++)
		{
			String hex="0"+Integer.toHexString(b[j]&255);
			result+=hex.substring(hex.length()-2);
		}
		return result;
	}

	public static boolean arraysAreEqual(byte[] a,byte[] b)
	{
		if(a.length!=b.length)
			return false;
		
		for(int i=0;i<a.length;i++)
			if(a[i]!=b[i])
				return false;
		
		return true;
	}
	
	//δημιουργία κλειδιού για τον AES
	public static byte[] genAESkey(int size) throws Exception
	{
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(size); 
		
		SecretKey skey = kgen.generateKey();
		byte[] raw = skey.getEncoded();
		
		return raw;
	}
	
	//decrypt του AES
	public static byte[] AESdecrypt(byte[] encrypted,byte[] key) throws Exception
	{
		SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] plain=cipher.doFinal(encrypted);
		return plain;
	}
	
	//encrypt του AES
	public static byte[] AESencrypt(byte[] plain,byte[] key) throws Exception
	{
		SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted =cipher.doFinal(plain);
		return encrypted;
	}
	
	public static KeyPair genRSAkeypair() throws Exception
	{
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		
                kpg.initialize(512);
		KeyPair kp = kpg.genKeyPair();
		
		return kp;
	}

}
