package Chapter05;

import java.io.*;

// 实例与静态相比，好处
public class InstanceCallbackDigestUserInterface {
  
  private File input; // 好处1：每个主类的实例只映射至一个文件，可以自然轻松记住此文件的信息
  private byte[] digest; // 好处2：在必要的时候可以很容易地重新计算某个文件的摘要
  
  public InstanceCallbackDigestUserInterface(File input) {
    this.input = input;
  }
  
  public void calculateDigest() {
	  // 在构造函数中启动线程很危险，可能会有race condition
	  // 避免在构造函数中启动线程
    InstanceCallbackDigest cb = new InstanceCallbackDigest(input, this);
    Thread t = new Thread(cb);
    t.start(); 
  }
  
  void receiveDigest(byte[] digest) {  
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
      InstanceCallbackDigestUserInterface d
       = new InstanceCallbackDigestUserInterface(f);
      d.calculateDigest();
    } 
    
  }

}
