package Chapter05;

import java.io.*;


public class ReturnDigest1UserInterface {
  
  public static void main(String[] args) {
  
    for (int i = 0; i < args.length; i++) {
    
      // Calculate the digest
      File f = new File(args[i]);
      ReturnDigest1 dr = new ReturnDigest1(f);
      Thread t = new Thread(dr);
      t.start();
      
      // Now print the result
      StringBuffer result = new StringBuffer(f.toString());
      result.append(": ");
      // 由于两线程并行，主线程运行到这里未必会计算完毕，很可能返回null，直观的方法这样使用有错误
      byte[] digest = dr.getDigest();
      for (int j = 0; j < digest.length; j++) {
        result.append(digest[j] + " ");
      }  
      System.out.println(result);
      
    }
  
  }

}
