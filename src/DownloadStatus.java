public class DownloadStatus {
    private volatile boolean isDone;
    private int totalBytes;
    private int totalFiles;
    private Object totalBytesLock = new Object();

    public void incrementTotalBytes() {
        synchronized (totalBytesLock) {
            totalBytes++;
        }
    }

    public synchronized void incrementTotalFiles() {
        totalFiles++;
    }

    public int getTotalBytes() {
        return totalBytes;
    }

    public boolean isDone() {
        return isDone;
    }

    public void done() {
        isDone = true;
    }
}
