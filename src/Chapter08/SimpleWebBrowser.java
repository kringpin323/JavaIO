import javax.swing.text.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.awt.*;

// 还真能运行！
// 一个简单的，无后退，定位栏，书签，或者任何装饰的浏览器
// 加载不了样式，但是能解析基本的HTML
public class SimpleWebBrowser {

  public static void main(String[] args) {
        
    // get the first URL
//    String initialPage = "http://www.cafeaulait.org/";
    
    String initialPage = "http://www.baidu.com/";
    
    if (args.length > 0) initialPage = args[0];       
    
    // set up the editor pane
    JEditorPane jep = new JEditorPane();
    jep.setEditable(false);   
    jep.addHyperlinkListener(new LinkFollower(jep));
    
    try {
      jep.setPage(initialPage);      
    }
    catch (IOException ex) {
      System.err.println("Usage: java SimpleWebBrowser url"); 
      System.err.println(ex);
      System.exit(-1);
    }
      
    // set up the window
    JScrollPane scrollPane = new JScrollPane(jep);     
    JFrame f = new JFrame("Simple Web Browser");
    f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    f.setContentPane(scrollPane);
    f.setSize(512, 342);
    EventQueue.invokeLater(new FrameShower(f));
    
  }
  
  // Helps avoid a really obscure deadlock condition.
  // See http://java.sun.com/developer/JDCTechTips/2003/tt1208.html#1
  private static class FrameShower implements Runnable {
  
    private final Frame frame;
    
    FrameShower(Frame frame) {
      this.frame = frame;
    }
    
    public void run() {
     frame.setVisible(true);
    }
    
  }

}
