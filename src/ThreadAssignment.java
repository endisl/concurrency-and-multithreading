import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ThreadAssignment {

    public static void show() {

        List<Thread> threads = new ArrayList<>();
        List<DownloadFileTask> tasks = new ArrayList<>();

        for (var i = 0; i < 10; i++) {
            var task = new DownloadFileTask();
            tasks.add(task);

            var thread = new Thread(task);
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        var totalBytes = tasks.stream().map(t -> t.getStatus().getTotalBytes()).reduce(Integer::sum);

        System.out.println(totalBytes);
    }
}
