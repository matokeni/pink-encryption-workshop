package pink.workshop;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSA {

  public static KeyPair generateKeys() throws NoSuchAlgorithmException {
    KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
    generator.initialize(1024);
    return generator.generateKeyPair();
  }

  public static byte[] encrypt(PublicKey publicKey, byte[] data) throws Exception {
    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(Cipher.ENCRYPT_MODE, publicKey);
    return cipher.doFinal(data);
  }

  public static byte[] decrypt(PrivateKey privateKey, byte[] data) throws Exception {
    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(Cipher.DECRYPT_MODE, privateKey);
    return cipher.doFinal(data);
  }

  /**
   * Reads in a file that contains an RSA Public Key
   *
   * @param filePath - path of the public key file
   * @return PublicKey for RSA
   * @throws NoSuchAlgorithmException
   * @throws InvalidKeySpecException
   */
  public static PublicKey readPublicKey(String filePath) throws Exception {
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    EncodedKeySpec publicKey = new X509EncodedKeySpec(FileUtils.readFileAsBytes(filePath));
    return keyFactory.generatePublic(publicKey);
  }

  /**
   * Reads in a file that contains an RSA Private Key
   *
   * @param filePath - path of the private key file
   * @return
   * @throws NoSuchAlgorithmException
   * @throws InvalidKeySpecException
   */
  public static PrivateKey readPrivateKey(String filePath) throws Exception {
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    EncodedKeySpec privateKey = new PKCS8EncodedKeySpec(FileUtils.readFileAsBytes(filePath));
    return keyFactory.generatePrivate(privateKey);
  }
}
