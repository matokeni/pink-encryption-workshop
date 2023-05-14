package pink.workshop;

public class XOR {

  public static byte[] xor(byte[] data, byte[] key) {
    var result = new byte[data.length];

    for (int dataIndex = 0; dataIndex < data.length; dataIndex += key.length) {
      for (int xorKeyIndex = 0; xorKeyIndex < key.length; xorKeyIndex++) {
        if (dataIndex + xorKeyIndex < data.length)
          result[dataIndex + xorKeyIndex] =
                  (byte) (data[dataIndex + xorKeyIndex] ^ key[xorKeyIndex]);
      }
    }

    return result;
  }
}
