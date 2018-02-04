import java.util.ArrayList;
import java.util.List;
public class ThreadNotifyAndWait {

  private List<Integer> queue = new ArrayList<>();
  public static void main(String[] args) {
    ThreadNotifyAndWait t = new ThreadNotifyAndWait();
    try {
      t.doThread();
    }catch (Exception e) {
      e.printStackTrace();
    }

  }


  private void doThread() throws Exception {

    Runnable t1 = () -> {
        try {
          while(true) {
            produce();
          }
        }catch (Exception e) {
          e.printStackTrace();
        }

    };
    new Thread(t1).start();
    t1.run();
    while(true) {
        consume();
    }

  }

  public synchronized void produce() throws Exception {
      while(queue.size() == 10) {
        queue.wait();
      }
      queue.add((int)(Math.random() * 10 % 10));
      queue.notify();

  }

  public synchronized void consume()  throws Exception{
      while(queue.isEmpty()) {
        queue.wait();
      }
      System.out.println(queue);
      queue.clear();
      queue.notify();

  }
}
