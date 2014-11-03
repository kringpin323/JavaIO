import java.net.*;

public class URLEquality {

  public static void main (String[] args) {

    try {
      URL ibiblio = new URL ("http://www.ibiblio.org/");
      URL metalab = new URL("http://metalab.unc.edu/");
      // equals 和 sameFile 有相同的限制 指向同一文件，有相同的片段标识符
      if (ibiblio.equals(metalab)) {
        System.out.println(ibiblio + " is the same as " + metalab); // 输出
      }
      else {
        System.out.println(ibiblio + " is not the same as " + metalab);
      }
    }
    catch (MalformedURLException ex) {
      System.err.println(ex);
    }

  }

}
