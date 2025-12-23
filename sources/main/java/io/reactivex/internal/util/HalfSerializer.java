package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class HalfSerializer {
    public static void onComplete(Subscriber<?> subscriber, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable terminate = atomicThrowable.terminate();
            if (terminate != null) {
                subscriber.onError(terminate);
            } else {
                subscriber.onComplete();
            }
        }
    }

    public static void onError(Subscriber<?> subscriber, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.addThrowable(th)) {
            RxJavaPlugins.onError(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            subscriber.onError(atomicThrowable.terminate());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void onNext(Subscriber<? super T> subscriber, T t5, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            subscriber.onNext(t5);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable terminate = atomicThrowable.terminate();
                if (terminate != null) {
                    subscriber.onError(terminate);
                } else {
                    subscriber.onComplete();
                }
            }
        }
    }

    private HalfSerializer() {
        throw new IllegalStateException("No instances!");
    }

    public static void onComplete(Observer<?> observer, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable terminate = atomicThrowable.terminate();
            if (terminate != null) {
                observer.onError(terminate);
            } else {
                observer.onComplete();
            }
        }
    }

    public static void onError(Observer<?> observer, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.addThrowable(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                observer.onError(atomicThrowable.terminate());
                return;
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void onNext(Observer<? super T> observer, T t5, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            observer.onNext(t5);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable terminate = atomicThrowable.terminate();
                if (terminate != null) {
                    observer.onError(terminate);
                } else {
                    observer.onComplete();
                }
            }
        }
    }
}
