import java.net.*;
import java.io.*;

public class LowPortScanner {

	// 查看指定主机上前1024个端口中哪些可以提供TCP服务	
	// 个人测试机上是：21 80 135 等
  public static void main(String[] args) {
    
    String host = "localhost";

    if (args.length > 0) {
      host = args[0];
    }
    for (int i = 1; i < 1024; i++) {
      try {
    	  // 建立 socket 的开销很大，整个程序运行很慢，只有几个端口可以简历 socket
        Socket s = new Socket(host, i);
        System.out.println("There is a server on port " + i + " of " 
         + host);
      }
      catch (UnknownHostException ex) {
        System.err.println(ex);
        break;
      }
      catch (IOException ex) {
    	  System.out.println("一些原因无法打开socket，这里很可能是防火墙或者端口关闭  : "+i);
        // must not be a server on this port
      }
    } // end for
  
  }  // end main
  
}  // end PortScanner
