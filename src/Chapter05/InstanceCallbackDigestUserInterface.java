package Chapter05;

import java.io.*;

// ʵ���뾲̬��ȣ��ô�
public class InstanceCallbackDigestUserInterface {
  
  private File input; // �ô�1��ÿ�������ʵ��ֻӳ����һ���ļ���������Ȼ���ɼ�ס���ļ�����Ϣ
  private byte[] digest; // �ô�2���ڱ�Ҫ��ʱ����Ժ����׵����¼���ĳ���ļ���ժҪ
  
  public InstanceCallbackDigestUserInterface(File input) {
    this.input = input;
  }
  
  public void calculateDigest() {
	  // �ڹ��캯���������̺߳�Σ�գ����ܻ���race condition
	  // �����ڹ��캯���������߳�
    InstanceCallbackDigest cb = new InstanceCallbackDigest(input, this);
    Thread t = new Thread(cb);
    t.start(); 
  }
  
  void receiveDigest(byte[] digest) {  
    this.digest = digest;
    System.out.println(this);
  }
  
  public String toString() {
    String result = input.getName() + ": ";
    if (digest != null) {
      for (int i = 0; i < digest.length; i++) {
        result += digest[i] + " ";
      }  
    }
    else {
      result += "digest not available";
    }
    return result;
  }
  
  public static void main(String[] args) {
  
    for (int i = 0; i < args.length; i++) {    
      // Calculate the digest
      File f = new File(args[i]);
      InstanceCallbackDigestUserInterface d
       = new InstanceCallbackDigestUserInterface(f);
      d.calculateDigest();
    } 
    
  }

}
