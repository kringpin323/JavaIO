package Chapter06;

import java.net.*;

class AllAddressesOfApple {

  public static void main (String[] args) {

    try {
    	// 有多个 地址的主机名大多数都是有着非常高吞吐量的web服务器，比如下面的腾讯视频：v.qq.com
    	// 百度搜索有两个IP地址
    	// 天猫有四个：www.tmall.com（腾讯到底是有钱还是怎么着？）
    	// 我们来看看 vip ： www.vip.com，有四个，和天猫一个水平
      InetAddress[] addresses = InetAddress.getAllByName("www.vip.com");
      for (int i = 0; i < addresses.length; i++) {
        System.out.println(addresses[i]);
      }
    }
    catch (UnknownHostException e) {
      System.out.println("Could not find www.apple.com");
    }

  }

}
