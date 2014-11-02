package Chapter05;

import java.io.*;
import java.util.*;

public class LogFile {

	private Writer out;

	public LogFile(File f) throws IOException {
		FileWriter fw = new FileWriter(f);
		this.out = new BufferedWriter(fw);
	}

	public void writeEntry(String message) throws IOException {
		// ÿ�� LogFile ��������Լ��� out �� ���̲߳������� ��� LogFile ����� writeEntry ���Ტ������out������race condition
		// �������1��ͬ�� out
		// �������2��ͬ�� this ����ʵ����һ�������Ƕ�����̶߳��Ե�Ψһ��
		// �������3�� ͬ����������ͬ��this��࣬ʹ��class��ʵ������Ķ��������������ܻ�Ƚϲ�
		// �Է���3�и����ʣ�ʹ�õ������class�Ķ���������ô��ͬһ�������������Ӧ��ֻ��һ���������������������������������ܲ������� ��� syn�������д���֤
		// ���������ʵĽ�𣺵� syn method ���� static ��ʱ�򣬻�ȡ���� ʵ������Ķ�����
		//             �� syn method �� static ��ʱ��    ��ȡ���� class �����Ķ�����
		// �����ձ�Ĺ۵��ǣ�ͬ��������Ч�ʱȽϵͣ������ͬ����
		Date d = new Date();
		out.write(d.toString());
		out.write('\t');
		out.write(message);
		out.write("\r\n");
	}

	public void close() throws IOException {
		out.flush();
		out.close();
	}

	protected void finalize() {
		try {
			this.close();
		}
		catch (IOException ex) {
		}
	}

}
