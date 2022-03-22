import java.util.concurrent.atomic.AtomicInteger;

public class DownloadStatus {
    private volatile boolean isDone;
    private AtomicInteger totalBytes = new AtomicInteger();
    private int totalFiles;

    public void incrementTotalBytes() {
        //compare and swap technique supported by most CPUs
        totalBytes.incrementAndGet();
    }

    public int getTotalBytes() {
        return totalBytes.get();
    }

    public boolean isDone() {
        return isDone;
    }

    public void done() {
        isDone = true;
    }
}
