/* Which protocols does a virtual machine support? */
import java.net.*;

public class ProtocolTester {

  public static void main(String[] args) {
    
    // hypertext transfer protocol
    testProtocol("http://www.adc.org");  
    
    // secure http
    testProtocol("https://www.amazon.com/exec/obidos/order2/"); 
    
    // file transfer protocol
    testProtocol("ftp://metalab.unc.edu/pub/languages/java/javafaq/");
  
    // Simple Mail Transfer Protocol 
    // 简单邮件传输协议
    testProtocol("mailto:elharo@metalab.unc.edu");

    // telnet 
    testProtocol("telnet://dibner.poly.edu/");
  
    // local file access
    testProtocol("file:///etc/passwd");

    // gopher 
    testProtocol("gopher://gopher.anc.org.za/");
  
    // Lightweight Directory Access Protocol
    // 轻量级目录访问协议
    testProtocol(
     "ldap://ldap.itd.umich.edu/o=University%20of%20Michigan,c=US?postalAddress");

    // JAR
    testProtocol(
     "jar:http://cafeaulait.org/books/javaio/ioexamples/javaio.jar!"
         +"/com/macfaq/io/StreamCopier.class");
  
    // NFS, Network File System
    // NFS 网络文件系统
    testProtocol("nfs://utopia.poly.edu/usr/tmp/");
  
    // a custom protocol for JDBC
    // JDBC 定制协议
    testProtocol("jdbc:mysql://luna.metalab.unc.edu:3306/NEWS");
  
    // rmi, a custom protocol for remote method invocation
    // 远程方法调用定制协议
    testProtocol("rmi://metalab.unc.edu/RenderEngine");
  
    // custom protocols for HotJava
    // HotJava定制协议
    testProtocol("doc:/UsersGuide/release.html");
    testProtocol("netdoc:/UsersGuide/release.html");
    testProtocol("systemresource://www.adc.org/+/index.html");
    testProtocol("verbatim:http://www.adc.org/");
    
  }
  
  // 运行结果取决于使用的 JVM
  // jdk 支持 rmi 和 JDBC ，只是无法和其他协议一样，通过URL来访问
  private static void testProtocol(String url) {
    
    try {  
      URL u = new URL(url);
      System.out.println(u.getProtocol() + " is supported");
    }
    catch (MalformedURLException ex) {
      String protocol = url.substring(0, url.indexOf(':'));
      System.out.println(protocol + " is not supported");
    }
    
  } 

}
