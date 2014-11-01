package Chapter05;

import java.io.*;

public class CallbackDigestUserInterface {
  
	// 本来main方法的作用是 创建线程，读取和显示计算结果，因此需要从子线程中得到结果，就需要子线程返回一些值
	// 现在main只负责创建线程，读取和显示结算结果有下面这个receiverDigest来负责
	// 它不由main（）或者main（）的控制流达到，它有每个线程自己亲自调用
	// 所以，main已经不需要再从线程中得到返回值，因为线程自己会在可以输出的时候，调用这个 显示结算结果功能的 method
	// 回调函数，将返回值转化为函数调用
  public static void receiveDigest(byte[] digest, String name) {
  
    StringBuffer result = new StringBuffer(name);
    result.append(": ");
    for (int j = 0; j < digest.length; j++) {
      result.append(digest[j] + " ");
    }  
    System.out.println(result);
      
  }
  
  public static void main(String[] args) {
  
    for (int i = 0; i < args.length; i++) {    
      // Calculate the digest
      File f = new File(args[i]);
      CallbackDigest cb = new CallbackDigest(f);
      Thread t = new Thread(cb);
      t.start();
    } 
    
  }

}
