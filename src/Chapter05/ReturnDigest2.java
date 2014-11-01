package Chapter05;

import java.io.*;
import java.security.*;


public class ReturnDigest2 implements Runnable {

  private File input;
  private byte[] digest;

  public ReturnDigest2(File input) {
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
      
      // Now print the result
      StringBuffer result = new StringBuffer(args[i]);
      result.append(": ");
      byte[] digest = digests[i].getDigest();
      for (int j = 0; j < digest.length; j++) {
        result.append(digest[j] + " ");
      }  
      System.out.println(result);
      
    }

    /*
     * 到底会得到正确的结果还是这个异常，取决于很多因素，包括程序生成了多少线程
     * 系统的CPU和磁盘的相对速度，以及Java虚拟机为不同线程分配时间所用的算法
     * 所有的这一切导致了数据不一致性的发生
     * 这些称为竞争条件（race condition）
     * 能否得到正确的结果，取决于一些我们无法控制的因素
     * */
  
  }

}
