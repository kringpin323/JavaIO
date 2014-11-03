import java.net.*;
import java.io.*;

public class SecureSourceViewer {

// 还是获取页面，但是多了一个安全认证
  public static void main (String args[]) {

    Authenticator.setDefault(new DialogAuthenticator());

    
    for (int i = 0; i < 1; i++) {
      
      try {
        //Open the URL for reading
        URL u = new URL("http://stackoverflow.com/search?q=opaque+URI");
        InputStream in = u.openStream();
        // buffer the input to increase performance 
        in = new BufferedInputStream(in);       
        // chain the InputStream to a Reader
        Reader r = new InputStreamReader(in);
        int c;
        while ((c = r.read()) != -1) {
          System.out.print((char) c);
        } 
      }
      catch (MalformedURLException ex) {
        System.err.println(args[0] + " is not a parseable URL");
      }
      catch (IOException ex) {
        System.err.println(ex);
      }
      
      // print a blank line to separate pages
      System.out.println();
      
    } //  end for
  
    // Since we used the AWT, we have to explicitly exit.
    System.exit(0);

  } // end main

}  // end SecureSourceViewer
