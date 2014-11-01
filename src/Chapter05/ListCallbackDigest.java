package Chapter05;

import java.io.*;
import java.security.*;
import java.util.*;

public class ListCallbackDigest implements Runnable {

  private File input;
  List listenerList = new Vector(); // 当前线程私有变量

  public ListCallbackDigest(File input) {
   this.input = input;
  }
 
  // 并发的意义在于：当前的线程可能只有一个，但是多个对象并发调用 addDigestListener
  // 为了阻止 race condition ，使用 synchronized ，但是不明白的是这样还有必要使用 vector 同步吗？
  // 这是一个疑问：这里做一个猜想：这里的 syn 获取的本线程class对象的对象锁
  // vector 里面 的同步，获取的是 vector 这个类class对象的对象锁，因此不一样
  // 至于这个 syn 控制是否重复了，暂时还不知道
  public synchronized void addDigestListener(DigestListener l) {
    listenerList.add(l);
  }
  
  public synchronized void removeDigestListener(DigestListener l) {
    listenerList.remove(l);
  } 
    
  
  private synchronized  void sendDigest(byte[] digest) {

    ListIterator iterator = listenerList.listIterator();
    // 把结果发送给所有的关注者
    while (iterator.hasNext()) {
      DigestListener dl = (DigestListener) iterator.next();
      dl.digestCalculated(digest);
    }

  }  

  // run不知道也不关注谁在监听，这个类只负责生成结果，不关心用户接口的事情
  public void run() {

    try {
      FileInputStream in = new FileInputStream(input);
      MessageDigest sha = MessageDigest.getInstance("SHA");
      DigestInputStream din = new DigestInputStream(in, sha);
      int b;
      while ((b = din.read()) != -1) ;
      din.close();
      byte[] digest = sha.digest();
      this.sendDigest(digest);
    }
    catch (IOException ex) {
      System.err.println(ex);
    }
    catch (NoSuchAlgorithmException ex) {
      System.err.println(ex);
    }
    
  }

}
