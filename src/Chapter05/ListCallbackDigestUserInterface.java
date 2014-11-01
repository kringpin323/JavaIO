package Chapter05;

import java.io.*;

public class ListCallbackDigestUserInterface implements DigestListener {
  
  private File input;
  private byte[] digest;
  
  public ListCallbackDigestUserInterface(File input) {
    this.input = input;
  }
  
  public void calculateDigest() {
    ListCallbackDigest cb = new ListCallbackDigest(input);
    cb.addDigestListener(this);
    Thread t = new Thread(cb);
    t.start(); 
  }
  
  // 自定义的处理 副线程生成结果的 回调 method
  public void digestCalculated(byte[] digest) {  
    this.digest = digest;
    System.out.println(this);
  }
  
  public String toString() {
    String result = input.getName() + ": ";
    if (digest != null) {
      for (int i = 0; i < digest.length; i++) {
        result += digest[i] + " ";
      }  
    }
    else {
      result += "digest not available";
    }
    return result;
  }
  
  public static void main(String[] args) {
  
    for (int i = 0; i < args.length; i++) {    
      // Calculate the digest
      File f = new File(args[i]);
      ListCallbackDigestUserInterface d
       = new ListCallbackDigestUserInterface(f);
      d.calculateDigest();
    } 
    
  }

}
