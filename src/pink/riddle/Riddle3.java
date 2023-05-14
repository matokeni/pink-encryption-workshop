package pink.riddle;

import pink.workshop.FileUtils;

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

  public static void main(String[] args) {
    byte[] file = FileUtils.readFileAsBytes("Riddle3/encr.ypt");

  }
}
