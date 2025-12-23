package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class NewThreadScheduler extends Scheduler {
    private static final NewThreadScheduler INSTANCE = new NewThreadScheduler();
    private static final String THREAD_NAME_PREFIX = "RxNewThreadScheduler";
    private static final String KEY_NEWTHREAD_PRIORITY = "rx2.newthread-priority";
    private static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX, Math.max(1, Math.min(10, Integer.getInteger(KEY_NEWTHREAD_PRIORITY, 5).intValue())));

    public static NewThreadScheduler instance() {
        return INSTANCE;
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return new NewThreadWorker(THREAD_FACTORY);
    }

    private NewThreadScheduler() {
    }
}
