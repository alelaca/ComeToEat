package utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.apache.commons.codec.*;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {

	private static SecretKeySpec secretKey ;
    private static byte[] key ;

	public AES(String myKey) {
		MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            //System.out.println(key.length);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); // use only first 128 bit
            //System.out.println(key.length);
            //System.out.println(new String(key,"UTF-8"));
            this.secretKey = new SecretKeySpec(key, "AES");
            
            
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	public static String encrypt(String strToEncrypt){
        
		String result = "";
		try{
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");        
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
       
            result = (Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes("UTF-8"))));
        
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return result;
    }
	
	public String decrypt(String strToDecrypt){
		
		String result = "";
		try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            result = new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt)));            
        } catch (Exception e){         
            e.printStackTrace();
        }
		
		return result;
	}
}
