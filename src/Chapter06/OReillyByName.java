package Chapter06;

import java.net.*;

public class OReillyByName {

  public static void main (String[] args) {

    try {
    	// ͨ���������� ip��ַ
      InetAddress address = InetAddress.getByName("www.baidu.com");
      System.out.println(address);
    }
    catch (UnknownHostException ex) {
      System.out.println("Could not find www.oreilly.com");
    }

  }

}
