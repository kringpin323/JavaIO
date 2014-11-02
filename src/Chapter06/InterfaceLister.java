package Chapter06;

import java.net.*;
import java.util.*;

public class InterfaceLister {

    public static void main(String[] args) throws Exception {
        // NetworkInterface 表示物理硬件和虚拟地址，
    	// 列出本地主机上所有网络接口
    	// 有 Virtual box wifi 的，也有微软的
      Enumeration interfaces = NetworkInterface.getNetworkInterfaces();
      while (interfaces.hasMoreElements()) {
        NetworkInterface ni = (NetworkInterface) interfaces.nextElement();
        System.out.println(ni);               
      }  
          
    }

}
