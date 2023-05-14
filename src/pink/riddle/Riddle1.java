package pink.riddle;

import pink.workshop.FileUtils;
import pink.workshop.RSA;

import java.security.PrivateKey;

/**
 * You started your own (ethical) code cracker business, and the first assignment is just in!
 *
 * The client says they arrested an amateur hacker, known as PinkHacker, who's been in contact
 * with other wanted cyber criminals, such as BlueHacker. The client is looking for the symmetric
 * encryption key that encrypted the connection between the hackers. From PinkHacker's computer
 * they recovered the folder Riddle1 and a piece of code:
 *
 *   private void savingMyKeys() throws NoSuchAlgorithmException {
 *       KeyPair pair = RSA.generateKeys();
 *       PrivateKey privateKey = pair.getPrivate();
 *       PublicKey publicKey = pair.getPublic();
 *
 *       FileUtils.writeFile(publicKey.getEncoded(), "Riddle1/public.key");
 *       FileUtils.writeFile(privateKey.getEncoded(), "Riddle1/private.key");
 *   }
 *
 * After reading the chat-messages.txt you start to realize, that these are indeed amateurs.
 * What's the symmetric encryption key that your client is looking for? :)
 */
public class Riddle1 {

  public static void main(String[] args) throws Exception {
    byte[] file = FileUtils.readFileAsBytes("Riddle1/secret.txt");

    // Realizing that the secret is encrypted with our own public key, we know that we can decrypt it
    // with our own private key too.
    // Read the private key file
    PrivateKey privateKey = RSA.readPrivateKey("Riddle1/private.key");

    // Decrypt with RSA
    byte[] decryptedKey = RSA.decrypt(privateKey, file);
    FileUtils.writeFile(decryptedKey, "Riddle1/solvedit.txt");
  }

}
