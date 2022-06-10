package Services;

import javax.crypto.Cipher;
import java.io.BufferedReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class SecurityRSA {
    //class Encrpytion using RSA using base64
    //SecurityKeyPairGenerator is used to generate public and private key
   
     
    //read public key from file foder "Config"
    public static String readPublicKey() {
        String publicKey = "";
        try {
            java.io.FileReader fr = new java.io.FileReader("Config/publicKey.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                publicKey = line;
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publicKey;
    }
   
    //Encrypt data using public key and base64
    public static String encrypt(String data) {
        String encryptedData = "";
        try {
            //read public key
            String publicKey = readPublicKey();
            //convert public key to public key object
            byte[] publicKeyBytes = Base64.getDecoder().decode(publicKey);
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKeyObj = keyFactory.generatePublic(x509EncodedKeySpec);
            //create cipher object
            Cipher cipher = Cipher.getInstance("RSA");
            //encrypt data
            cipher.init(Cipher.ENCRYPT_MODE, publicKeyObj);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            //convert encrypted data to string
            encryptedData = Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return encryptedData;
    }
   
    
}


