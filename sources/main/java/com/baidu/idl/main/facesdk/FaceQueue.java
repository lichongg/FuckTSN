package com.baidu.idl.main.facesdk;

import java.util.LinkedList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FaceQueue {
    private int nThreads;
    private LinkedList queue;
    private PoolWorker[] threads;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.baidu.idl.main.facesdk.FaceQueue$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class HolderClass {
        private static final FaceQueue instance = new FaceQueue(1);

        private HolderClass() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class PoolWorker extends Thread {
        private PoolWorker() {
        }

        /* synthetic */ PoolWorker(FaceQueue faceQueue, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Runnable runnable;
            while (true) {
                synchronized (FaceQueue.this.queue) {
                    while (FaceQueue.this.queue.isEmpty()) {
                        try {
                            FaceQueue.this.queue.wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                    runnable = (Runnable) FaceQueue.this.queue.removeFirst();
                }
                try {
                    runnable.run();
                } catch (RuntimeException e6) {
                    e6.printStackTrace();
                }
            }
        }
    }

    public void execute(Runnable runnable) {
        synchronized (this.queue) {
            this.queue.addLast(runnable);
            this.queue.notify();
        }
    }

    public FaceQueue(int i6) {
        AnonymousClass1 anonymousClass1 = null;
        this.queue = null;
        this.nThreads = i6;
        this.queue = new LinkedList();
        this.threads = new PoolWorker[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            this.threads[i7] = new PoolWorker(this, anonymousClass1);
            this.threads[i7].start();
        }
    }

    public static FaceQueue getInstance() {
        return HolderClass.instance;
    }
}
