package Chapter06;

import java.net.*;

class AllAddressesOfApple {

  public static void main (String[] args) {

    try {
    	// �ж�� ��ַ��������������������ŷǳ�����������web�������������������Ѷ��Ƶ��v.qq.com
    	// �ٶ�����������IP��ַ
    	// ��è���ĸ���www.tmall.com����Ѷ��������Ǯ������ô�ţ���
    	// ���������� vip �� www.vip.com�����ĸ�������èһ��ˮƽ
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
