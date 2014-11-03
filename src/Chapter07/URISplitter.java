import java.net.*;

public class URISplitter {

  public static void main(String args[]) {

    for (int i = 0; i < 1; i++) {
      try {
//        URI u = new URI(args[i]);
    	  URI u = new URI("http://stackoverflow.com/questions/26707148/why-does-backgroundtask-runs-ok-in-debugger-but-not-when-without-debugger-attach");
        System.out.println("The URI is " + u);
        // 非传导性 URI
        if (u.isOpaque()) {
          System.out.println("This is an opaque URI."); 
          System.out.println("The scheme is " + u.getScheme());        
          System.out.println("The scheme specific part is " 
           + u.getSchemeSpecificPart());        
          System.out.println("The fragment ID is " + u.getFragment());        
        }
        else {
          System.out.println("This is a hierarchical URI."); 
          System.out.println("The scheme is " + u.getScheme()); // http       
          try {       
            u = u.parseServerAuthority();
            System.out.println("The host is " + u.getUserInfo());        
            System.out.println("The user info is " + u.getUserInfo());        
            System.out.println("The port is " + u.getPort());        
          }
          catch (URISyntaxException ex) {
            // Must be a registry based authority
            System.out.println("The authority is " + u.getAuthority());        
          }
          System.out.println("The path is " + u.getPath());        
          System.out.println("The query string is " + u.getQuery());        
          System.out.println("The fragment ID is " + u.getFragment()); // 片段标示符也没有
        } // end else       
      }  // end try
      catch (URISyntaxException ex) {
        System.err.println(args[i] + " does not seem to be a URI.");
      }
      System.out.println();
    }  // end for

  }  // end main

}  // end URISplitter
