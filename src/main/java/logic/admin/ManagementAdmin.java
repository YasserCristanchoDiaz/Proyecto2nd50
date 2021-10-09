package logic.admin;

import persistence.FilePlain;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.Security;
import java.util.Arrays;
import java.util.Base64;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ManagementAdmin {
    private Admin admin;
    private static String KEY;
    private FilePlain file;

    public ManagementAdmin() {
        admin = new Admin();
        KEY = "SpeedFood";
        file = new FilePlain("Resources/files/", "admin.json");
        file.openFile();
    }

    //private void admin(){
    //    admin.setUser("Admin");
    //    String pw = "digaQueNoYVera";
    //    String password = encrypt(pw);
    //    admin.setPassword(password);
    //}

    /**
     * createPassword: Permite generar un SecretKeySpec para los metodos encrypt y decrypt.
     * @param key Toma la cadena key de referencia que pasa por parametro.
     * @return Retorna un SecretKeySpec.
     */
    private static SecretKeySpec createPassword(String key) {
        try {
            byte[] string = key.getBytes(StandardCharsets.UTF_8);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            string = messageDigest.digest(string);
            string = Arrays.copyOf(string, 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(string, "AES");
            return secretKeySpec;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * encrypt: Permite encriptar una cadena de entrada.
     * @param encrypt Recibe por parametro la cadena que se va a encriptar.
     * @return Devuelve la cadena encriptada.
     */
    private static String encrypt(String encrypt) {
        try {
            SecretKeySpec secretKeySpec = createPassword(KEY);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] string = encrypt.getBytes(StandardCharsets.UTF_8);
            byte[] encrypted = cipher.doFinal(string);
            String encryptedString = Base64.getEncoder().encodeToString(encrypted);

            return encryptedString;

        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * decrypt: Permite desenciptar una cadena de entrada
     * @param decrypt Recibe por parametro la cadena que se desea desencriptar.
     * @return Devuelve la cadena original desencriptada.
     */
    private static String decrypt(String decrypt) {
        try {
            SecretKeySpec secretKeySpec = createPassword(KEY);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

            byte[] string = Base64.getDecoder().decode(decrypt);
            byte[] decrypted = cipher.doFinal(string);
            String decryptedString = new String(decrypted);

            return decryptedString;
        } catch (Exception ex) {
            return "";
        }
    }

    public boolean checkUser(String user) {
        return admin.getUser().equals(user);
    }

    public boolean checkPassword(String password) {
        return decrypt(admin.getPassword()).equals(password);
    }

    public void load() throws IOException {
        String strAdmin = file.readFile();
        //System.out.println( strAdmin );
        admin = new Gson().fromJson(strAdmin, Admin.class);
    }

}
