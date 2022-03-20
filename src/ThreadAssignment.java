public class ThreadAssignment {

    public static void show() {
        System.out.println(Thread.currentThread().getName());

        for (var i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadFileTask());
            thread.start();
        }
    }
}
