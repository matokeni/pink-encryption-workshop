package pink.riddle;

import pink.workshop.CBC;
import pink.workshop.FileUtils;

import java.nio.ByteBuffer;
import java.util.HexFormat;

/**
 * You´re code cracker business gets an urgent call, the client says that the hacker is in their house,
 * sitting at their computer and encrypting their files at this very moment!
 *
 * You waste no time, and get to their house ASAP. But oh no, the hacker must have heard you coming, and
 * disappeared into the night. You take a look at the client's computer, and you notice that the hacker's
 * malicious encryption virus is still running. You see the following window on the screen:
 *
 *              _________________________________________________________________
 *             /                                                                 \
 *            |    __________________________________________________________     |
 *            |   |                                                          |    |
 *            |   |  C:\> my-hacker-virus.exe_                               |    |
 *            |   |                                                          |    |
 *            |   |  1.File name changed: "Riddle3.png" -> "encr.ypt"        |    |
 *            |   |  2.ENCRYPTING with CBC                                   |    |
 *            |   |    Using first 16 bytes of "Riddle3.png" as KEY          |    |
 *            |   |    WARNING: IV and KEY are the same, not recommended!    |    |
 *            |   |                                                          |    |
 *            |   |                                                          |    |
 *            |   |    PROGRESS:                                             |    |
 *            |   |    [====>           16 byte/19.3kb                  ]    |    |
 *            |   |                                                          |    |
 *            |   |                                                          |    |
 *            |   |__________________________________________________________|    |
 *            |                                                                   |
 *             \_________________________________________________________________/
 *                          \___________________________________/
 *                       ___________________________________________
 *
 * You stop the program immediately, but now you have to decrypt the client's damaged file...
 * You're so glad that you saw this window, it gave you some great hints about fixing
 * the issue! :)
 *
 * Extra hint: if you need to manipulate byte arrays: https://mkyong.com/java/java-how-to-join-and-split-byte-arrays-byte/
 * Extra hint 2: if you want to do magic with HEX <-> byte conversions: https://www.baeldung.com/java-hexformat
 */
public class Riddle3 {

  public static void main(String[] args) throws Exception {
    byte[] file = FileUtils.readFileAsBytes("Riddle3/encr.ypt");

    // The encryption key and IV is the same according to the task
    // Both are taken from the first 16 bytes of the file - and a PNG has always the following 16 bytes:
    byte[] keyAndIV = HexFormat.of().parseHex("89504E470D0A1A0A0000000D49484452");

    // Using ByteBuffer as the hint suggests. ByteBuffer makes it easy to split then join the two
    // arrays.
    ByteBuffer fileBytes = ByteBuffer.wrap(file);

    // Create an array for the bytes that need to be decrypted. The task says only 16 bytes were
    // encrypted.
    byte[] encryptedData = new byte[16];
    fileBytes.get(encryptedData, 0, encryptedData.length);
    // Decrypt using the key/IV
    byte[] decryptedData = CBC.decrypt(keyAndIV, keyAndIV, encryptedData);

    // Create a byte array with those bytes that were NOT encrypted
    byte[] original = new byte[file.length - 16];
    fileBytes.get(original, 0, original.length);

    // Concatenate the two arrays, then write to file as .png
    FileUtils.writeFile(
            ByteBuffer.allocate(decryptedData.length + original.length)
                    .put(decryptedData)
                    .put(original)
                    .array(),
            "Riddle3/solvedit.png");
  }
}
