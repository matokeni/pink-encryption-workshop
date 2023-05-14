package pink.workshop;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CBC {

  public static byte[] encrypt(byte[] initVector, byte[] key, byte[] data) throws Exception {
    return doCBC(initVector, key, Cipher.ENCRYPT_MODE, data);
  }

  public static byte[] decrypt(byte[] initVector, byte[] key, byte[] encrypted)
          throws Exception {
    return doCBC(initVector, key, Cipher.DECRYPT_MODE, encrypted);
  }

  private static byte[] doCBC(byte[] initVector, byte[] key, int decryptMode, byte[] cipherText)
          throws Exception {
    IvParameterSpec iv = new IvParameterSpec(initVector);
    SecretKeySpec keySpec = new SecretKeySpec(key, "AES");

    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
    cipher.init(decryptMode, keySpec, iv);

    return cipher.doFinal(cipherText);
  }
}
