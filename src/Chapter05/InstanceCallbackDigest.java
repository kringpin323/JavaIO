package Chapter05;

import java.io.*;
import java.security.*;

// 实例回调，好处在哪里呢？
public class InstanceCallbackDigest implements Runnable {

  private File input;
  private InstanceCallbackDigestUserInterface callback;

  public InstanceCallbackDigest(File input, 
   InstanceCallbackDigestUserInterface callback) {
    this.input = input;
    this.callback = callback;
  }

  public void run() {

    try {
      FileInputStream in = new FileInputStream(input);
      MessageDigest sha = MessageDigest.getInstance("SHA");
      DigestInputStream din = new DigestInputStream(in, sha);
      int b;
      while ((b = din.read()) != -1) ;
      din.close();
      byte[] digest = sha.digest();
      callback.receiveDigest(digest);
    }
    catch (IOException ex) {
      System.err.println(ex);
    }
    catch (NoSuchAlgorithmException ex) {
      System.err.println(ex);
    }
    
  }

}
