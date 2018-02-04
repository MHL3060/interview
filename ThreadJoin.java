public class ThreadJoin {


  public static void main(String[] args) {
    ThreadJoin tj = new ThreadJoin();
    tj.executeThreads();
  }

  private void executeThreads() {
    try {
      Thread t1 = new Thread(new UselessEvent("one", 1));
      t1.start();
      Thread t2 = new Thread(new UselessEvent("two", 2));
      t1.join();
      t2.start();

      //t1.join();
      t2.join();

      System.out.print("done");
    }catch (Exception e) {
    }

  }

  private class UselessEvent implements Runnable {

    private String id;
    private int second;
    public UselessEvent(String id, int second) {
      this.id = id;
      this.second = second;
    }
    public void run() {
      for (int i = 0; i < 50; i++) {
        System.out.println(" " + id + " = " + i);
        try {
          Thread.sleep(second * 1000);
        }catch (Exception e){}
      }
    }
  }
}
