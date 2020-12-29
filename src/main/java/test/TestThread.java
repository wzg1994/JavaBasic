package test;

public class TestThread {
    private int a = 1;

    public synchronized void add(){
        a++;
        System.out.println(Thread.currentThread().getName() + "current a is " + a);
    }

    public int get(){
        System.out.println("current a is " + a);
        return a;
    }

    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        Thread t1 = new Thread(() -> {
            testThread.add();
            //make sure the second thread to be executed at this moment
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int i = testThread.get();
        }
        );

        Thread t2 = new Thread(() -> {
            //make sure the first thread to be started firstly at beginning
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            testThread.add();
            int i = testThread.get();
        }
        );

        t1.start();
        t2.start();
    }
}
