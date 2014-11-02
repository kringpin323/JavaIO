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
		// 每个 LogFile 对象持有自己的 out 流 多线程并发调用 这个 LogFile 对象的 writeEntry ，会并发调用out，触发race condition
		// 解决方案1：同步 out
		// 解决方案2：同步 this ，其实意义一样，都是对这个线程而言的唯一锁
		// 解决方案3： 同步方法，和同步this差不多，使用class的实例对象的对象锁，但是性能会比较差
		// 对方案3有个疑问：使用的如果是class的对象锁，那么对同一个类这个对象锁应该只有一个，如果这个类有两个对象，这两个对象能并发访问 这个 syn方法吗？有待查证
		// 对上述疑问的解答：当 syn method 不是 static 的时候，获取的是 实例对象的对象锁
		//             当 syn method 是 static 的时候，    获取的是 class 类对象的对象锁
		// 但是普遍的观点是：同步方法的效率比较低，不如块同步好
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
