package Chapter06;

import java.net.*;
import java.util.*;

public class InterfaceLister {

    public static void main(String[] args) throws Exception {
        // NetworkInterface ��ʾ����Ӳ���������ַ��
    	// �г�������������������ӿ�
    	// �� Virtual box wifi �ģ�Ҳ��΢���
      Enumeration interfaces = NetworkInterface.getNetworkInterfaces();
      while (interfaces.hasMoreElements()) {
        NetworkInterface ni = (NetworkInterface) interfaces.nextElement();
        System.out.println(ni);               
      }  
          
    }

}
