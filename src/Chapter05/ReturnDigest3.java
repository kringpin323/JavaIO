package Chapter05;

import java.io.*;
import java.security.*;


public class ReturnDigest3 implements Runnable {

  private File input;
  private byte[] digest;

  public ReturnDigest3(File input) {
   this.input = input;
  }

  public void run() {
    try {
      FileInputStream in = new FileInputStream(input);
      MessageDigest sha = MessageDigest.getInstance("SHA");
      DigestInputStream din = new DigestInputStream(in, sha);
      int b;
      while ((b = din.read()) != -1) ;
      din.close();
      digest = sha.digest();
    }
    catch (IOException e) {
      System.err.println(e);
    }
    catch (NoSuchAlgorithmException e) {
      System.err.println(e);
    }
    
  }
  
  public byte[] getDigest() {
    return digest;
  }
  
  public static void main(String[] args) {
  
    ReturnDigest1[] digests = new ReturnDigest1[args.length];
  
    for (int i = 0; i < args.length; i++) {
    
      // Calculate the digest
      File f = new File(args[i]);
      digests[i] = new ReturnDigest1(f);
      Thread t = new Thread(digests[i]);
      t.start();
      
    }
    
    
    for (int i = 0; i < args.length; i++) {
      while (true) {
        // Now print the result
        byte[] digest = digests[i].getDigest();
        // 轮询，新手解决方案
        // 能起作用，以正确的顺序给出正确的答案，
        // 但是做了大量不需要做的工作
        // 这是通过无限循环来重复地轮询每个ReturnDigest对象，以查看是否结束
        // 可以通过回调来处理
        // 轮询是主线程不断问，是否结束了？
        // 回调是 当副线程结束的时候，告诉主线程，我结束了，你可以开始了
        // 线程在结束时要回头调用其创建者
        // 主线程可以在等待的时候休息，不会占用运行线程的时间
        if (digest != null) {
          StringBuffer result = new StringBuffer(args[i]);
          result.append(": ");
          for (int j = 0; j < digest.length; j++) {
            result.append(digest[j] + " ");
          }  
          System.out.println(result);
          break;
        }
      }      
    }  
    
  }

}
