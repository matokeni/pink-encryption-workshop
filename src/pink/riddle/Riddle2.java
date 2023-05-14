package pink.riddle;

import pink.workshop.FileUtils;

/**
 * You're having a chill night at home, munching on a slice of pizza, when you're mom calls you in
 * pure panic: she downloaded a virus and now her files are encrypted!
 *
 * You Google the virus immediately, and find out that it uses a simple XOR to encrypt files.
 *
 * But you need to find the encryption key...
 *
 * Your mom realizes that she has a copy of one of her files that got encrypted: now you have an
 * original file, example.jpg, and it's encrypted version, example-encrypted.jpg!
 *
 * Your mom loved the picture Riddle2.png so much, that she asked you to decrypt that first. And
 * lucky for her, now you know exactly what to do... :)
 */
public class Riddle2 {

  public static void main(String[] args) {
    byte[] file = FileUtils.readFileAsBytes("Riddle2/Riddle2.jpg");

  }
}
