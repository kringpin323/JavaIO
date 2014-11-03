import java.net.*;
import java.io.*;

public class ContentGetter {

  public static void main (String[] args) {

    if  (true) {

      //Open the URL for reading
      try {
//        URL u = new URL(args[0]);
    	  // 资源时网址或者是图片的时候会有所不同
    	  URL u = new URL("http://img003.21cnimg.com/photos/album/20141009/m600/3791956F3FDA7D13076BE4BE6BCFCF56.jpeg");
        try {
          Object o = u.getContent();
          System.out.println("I got a " + o.getClass().getName());
        } // end try
        catch (IOException ex) {
          System.err.println(ex);
        }
      } // end try
      catch (MalformedURLException ex) {
        System.err.println(args[0] + " is not a parseable URL");
      }
    } //  end if

  } // end main

}  // end ContentGetter
