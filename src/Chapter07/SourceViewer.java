import java.net.*;
import java.io.*;

public class SourceViewer {

  public static void main (String[] args) {

    if  (true) {
      try {
        //Open the URL for reading
//        URL u = new URL(args[0]);
    	  // 获取了源代码
    	  URL u = new URL("http://finance.21cn.com/stock/ssbd/a/2014/1009/10/28345554.shtml");
        InputStream in = u.openStream();
        // buffer the input to increase performance 
        // 缓冲提高性能
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

    } //  end if

  } // end main

}  // end SourceViewer
