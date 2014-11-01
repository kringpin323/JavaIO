package Chapter05;

import java.io.*;

public class CallbackDigestUserInterface {
  
	// ����main������������ �����̣߳���ȡ����ʾ�������������Ҫ�����߳��еõ����������Ҫ���̷߳���һЩֵ
	// ����mainֻ���𴴽��̣߳���ȡ����ʾ���������������receiverDigest������
	// ������main��������main�����Ŀ������ﵽ������ÿ���߳��Լ����Ե���
	// ���ԣ�main�Ѿ�����Ҫ�ٴ��߳��еõ�����ֵ����Ϊ�߳��Լ����ڿ��������ʱ�򣬵������ ��ʾ���������ܵ� method
	// �ص�������������ֵת��Ϊ��������
  public static void receiveDigest(byte[] digest, String name) {
  
    StringBuffer result = new StringBuffer(name);
    result.append(": ");
    for (int j = 0; j < digest.length; j++) {
      result.append(digest[j] + " ");
    }  
    System.out.println(result);
      
  }
  
  public static void main(String[] args) {
  
    for (int i = 0; i < args.length; i++) {    
      // Calculate the digest
      File f = new File(args[i]);
      CallbackDigest cb = new CallbackDigest(f);
      Thread t = new Thread(cb);
      t.start();
    } 
    
  }

}
