package Chapter05;

// 可能有很多对象关心 线程的计算结果，定义一个接口，关心这个线程计算结果的所有类都要实现这个接口
// 这个接口里面的method表示回调函数，关心线程计算结果的对象通过自定义回调函数来拥有自己的独特的对结果的调用方式
public interface DigestListener {

  public void digestCalculated(byte[] digest);

}
