package Chapter06;

import java.net.*;

public class IBiblioAliases {

  public static void main (String args[]) {

    try {
      InetAddress ibiblio = InetAddress.getByName("www.ibiblio.org");
      InetAddress helios = InetAddress.getByName("helios.metalab.unc.edu");
      System.out.println(ibiblio);
      System.out.println(helios);
      // 是 InetAddress 的实例，而且 IP地址相同，返回 true
      // InetAddress 的 hashcode 以 IP地址作为计算依据
      if (ibiblio.equals(helios)) {
        System.out.println
         ("www.ibiblio.org is the same as helios.metalab.unc.edu");
      }
      else {
        System.out.println
         ("www.ibiblio.org is not the same as helios.metalab.unc.edu");
      }
    }
    catch (UnknownHostException ex) {
      System.out.println("Host lookup failed.");
    }

  }

}
