import java.net.*;

public class URLSplitter {

	// URL 的各部分
  public static void main(String args[]) {

	  
    for (int i = 0; i < 1; i++) {
      try {
//        URL u = new URL(args[i]);
    	 URL u = new URL("http://finance.21cn.com/stock/ssbd/a/2014/1009/10/28345554.shtml");
        System.out.println("The URL is " + u);
        System.out.println("The scheme is " + u.getProtocol());        
        System.out.println("The user info is " + u.getUserInfo());
        
        String host = u.getHost();
        if (host != null) {
          int atSign = host.indexOf('@');  
          if (atSign != -1) host = host.substring(atSign+1);
          System.out.println("The host is " + host);   
        }
        else {          
          System.out.println("The host is null.");   
        }

        System.out.println("The port is " + u.getPort());
        System.out.println("The path is " + u.getPath());
        System.out.println("The ref is " + u.getRef());
        System.out.println("The query string is " + u.getQuery());
      }  // end try
      catch (MalformedURLException ex) {
        System.err.println(args[i] + " is not a URL I understand.");
      }
      System.out.println();
    }  // end for

  }  // end main

}  // end URLSplitter
