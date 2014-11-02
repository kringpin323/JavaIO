package Chapter06;

import java.net.*;

public class IPCharacteristics {

  public static void main(String[] args) {
  
    try {
      InetAddress address = InetAddress.getByName("join.qq.com");
      
      if (address.isAnyLocalAddress()) {
        System.out.println(address + " is a wildcard address.");
      }
      if (address.isLoopbackAddress()) {
        System.out.println(address + " is loopback address.");
      }
      
      if (address.isLinkLocalAddress()) {
        System.out.println(address + " is a link-local address.");
      }
      else if (address.isSiteLocalAddress()) {
        System.out.println(address + " is a site-local address.");
      }
      else {
    	// 输出
        System.out.println(address + " is a global address.");
      }
      
      if (address.isMulticastAddress()) {
        if (address.isMCGlobal()) {
          System.out.println(address + " is a global multicast address.");
        }          
        else if (address.isMCOrgLocal()) {
          System.out.println(address 
           + " is an organization wide multicast address.");
        }  
        else if (address.isMCSiteLocal()) {
          System.out.println(address + " is a site wide multicast address.");
        }  
        else if (address.isMCLinkLocal()) {
          System.out.println(address + " is a subnet wide multicast address.");
        }  
        else if (address.isMCNodeLocal()) {
          System.out.println(address 
           + " is an interface-local multicast address.");
        }  
        else {
          System.out.println(address + " is an unknown multicast address type.");
        }
          
      }
      else {
    	  // 输出，一般输出的都是 global， unicast
        System.out.println(address + " is a unicast address.");          
      }
      
    }
    catch (UnknownHostException ex) {
      System.err.println("Could not resolve " + args[0]);
    }   

  }

}
