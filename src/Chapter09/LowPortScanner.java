import java.net.*;
import java.io.*;

public class LowPortScanner {

	// �鿴ָ��������ǰ1024���˿�����Щ�����ṩTCP����	
	// ���˲��Ի����ǣ�21 80 135 ��
  public static void main(String[] args) {
    
    String host = "localhost";

    if (args.length > 0) {
      host = args[0];
    }
    for (int i = 1; i < 1024; i++) {
      try {
    	  // ���� socket �Ŀ����ܴ������������к�����ֻ�м����˿ڿ��Լ��� socket
        Socket s = new Socket(host, i);
        System.out.println("There is a server on port " + i + " of " 
         + host);
      }
      catch (UnknownHostException ex) {
        System.err.println(ex);
        break;
      }
      catch (IOException ex) {
    	  System.out.println("һЩԭ���޷���socket������ܿ����Ƿ���ǽ���߶˿ڹر�  : "+i);
        // must not be a server on this port
      }
    } // end for
  
  }  // end main
  
}  // end PortScanner
