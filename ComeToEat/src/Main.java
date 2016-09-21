import java.sql.Connection;

import sqlutils.ConnectionManager;
import utils.AES;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println ( System.getProperty("user.dir"));
		
//		ConnectionManager manager =  new ConnectionManager();
//		Connection con = manager.connect();
		
		
		final String strToEncrypt = "cometoeat_desa";
        
        AES aes = new AES("FO3A5COMECL3T6");
        
        System.out.println("String to Encrypt: " + strToEncrypt); 
        System.out.println("Encrypted: " + aes.encrypt(strToEncrypt));
        
//        System.out.println("String to Decrypt: IrhQkZpXGhDe3ziZzVR39A=="); 
//        System.out.println("Decrypted: " + aes.decrypt("IrhQkZpXGhDe3ziZzVR39A=="));

	}

}
