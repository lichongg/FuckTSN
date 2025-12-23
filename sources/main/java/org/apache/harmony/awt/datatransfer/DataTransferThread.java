package org.apache.harmony.awt.datatransfer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DataTransferThread extends Thread {
    private final DTK dtk;

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        synchronized (this) {
            try {
                this.dtk.initDragAndDrop();
            } finally {
                notifyAll();
            }
        }
        this.dtk.runEventLoop();
    }

    @Override // java.lang.Thread
    public void start() {
        synchronized (this) {
            try {
                super.start();
                try {
                    wait();
                } catch (InterruptedException e6) {
                    throw new RuntimeException(e6);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public DataTransferThread(DTK dtk) {
        super("AWT-DataTransferThread");
        setDaemon(true);
        this.dtk = dtk;
    }
}
