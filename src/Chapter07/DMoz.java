import com.macfaq.net.*;

import java.net.*;
import java.io.*;

// 开放目录搜索
public class DMoz {

  public static void main(String[] args) {
  
    String target = "";
    
//    for (int i = 0; i < args.length; i++) {
//      target += args[i] + " ";
//    }
    
    target = "google facebook baidu ";
    
    target = target.trim();
    QueryString query = new QueryString("search", target);
    try {
    // 与 URL 与服务器通信，通过流和Reader获取源代码页面（浏览器中元代买页面交给浏览器解析）
      URL u = new URL("http://search.dmoz.org/cgi-bin/search?" + query);
      InputStream in = new BufferedInputStream(u.openStream());
      InputStreamReader theHTML = new InputStreamReader(in);
      int c;
      while ((c = theHTML.read()) != -1) {
        System.out.print((char) c);
      } 
    }
    catch (MalformedURLException ex) {
      System.err.println(ex);
    }
    catch (IOException ex) {
      System.err.println(ex);
    }
    
  }

}
