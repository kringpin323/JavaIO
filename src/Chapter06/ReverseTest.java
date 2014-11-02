package Chapter06;

import java.net.*;

public class ReverseTest {

  public static void main (String[] args) {
  
    try {
    	// 这里找不到主机名
      InetAddress ia = InetAddress.getByName("208.201.239.37");
      System.out.println(ia.getHostName());
    }
    catch (Exception ex) {
      System.err.println(ex);
    }
   
  }

}
