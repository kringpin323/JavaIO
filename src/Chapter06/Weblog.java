package Chapter06;

import java.net.*;
import java.io.*;
import java.util.*;
import com.macfaq.io.SafeBufferedReader; 

public class Weblog {

	// 读取web服务器日志文件，在每一行中显示，将IP地址转换为主机名，较少对DNS的访问
	// 大多数web浏览器会对每个网页生成多个日志文件项，因为日志项不单单是 网页本身，还有图片等，每个都进行DNS查找的代价很大
	// InetAddress 会建立缓存
  public static void main(String[] args) {

    Date start = new Date();
    try {
      FileInputStream fin =  new FileInputStream(args[0]);
      Reader in = new InputStreamReader(fin);
      SafeBufferedReader bin = new SafeBufferedReader(in);
      
      String entry = null;
      while ((entry = bin.readLine()) != null) {
        
        // separate out the IP address
        int index = entry.indexOf(' ', 0);
        String ip = entry.substring(0, index);
        String theRest = entry.substring(index, entry.length());
        
        // find the hostname and print it out
        try {
          InetAddress address = InetAddress.getByName(ip);
          System.out.println(address.getHostName() + theRest);
        }
        catch (UnknownHostException ex) {
          System.out.println(entry);
        }
        
      } // end while
    }
    catch (IOException ex) {
      System.out.println("Exception: " + ex);
    }
    
    Date end = new Date();
    long elapsedTime = (end.getTime()-start.getTime())/1000;
    System.out.println("Elapsed time: " + elapsedTime + " seconds");

  }  // end main

}
