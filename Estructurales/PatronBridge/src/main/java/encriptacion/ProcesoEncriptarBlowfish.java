package encriptacion;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class ProcesoEncriptarBlowfish implements InterfaceEncriptar{
    @Override
    public String encryptar(String message, String password) throws Exception {
        Key key = new SecretKeySpec(password.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(message.getBytes());
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedString = encoder.encodeToString(encrypted);
        return encodedString;
    }
}
