import java.net.*;
import java.io.*;

public class HighPortScanner {

  public static void main(String[] args) {
    
    String host = "localhost";

    if (args.length > 0) {
      host = args[0];
    }

    try {
      InetAddress theAddress = InetAddress.getByName(host);
      for (int i = 1024; i < 65536; i++) {
        try {
        	// 据说这样效率会更高
        	// 测试后，觉得稍微快了一点
          Socket theSocket = new Socket(theAddress, i);
          System.out.println("There is a server on port " 
           + i + " of " + host);
        }
        catch (IOException ex) {
        	System.out.println(i);
          // must not be a server on this port
        }
      } // end for
    } // end try
    catch (UnknownHostException ex) {
      System.err.println(ex);
    }

  }  // end main
  
}  // end HighPortScanner
