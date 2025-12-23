package io.reactivex.disposables;

import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Future;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Disposables {
    public static Disposable fromFuture(Future<?> future) {
        ObjectHelper.requireNonNull(future, "future is null");
        return fromFuture(future, true);
    }

    public static Disposable disposed() {
        return EmptyDisposable.INSTANCE;
    }

    public static Disposable empty() {
        return fromRunnable(Functions.EMPTY_RUNNABLE);
    }

    public static Disposable fromAction(Action action) {
        ObjectHelper.requireNonNull(action, "run is null");
        return new ActionDisposable(action);
    }

    public static Disposable fromRunnable(Runnable runnable) {
        ObjectHelper.requireNonNull(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    public static Disposable fromSubscription(Subscription subscription) {
        ObjectHelper.requireNonNull(subscription, "subscription is null");
        return new SubscriptionDisposable(subscription);
    }

    private Disposables() {
        throw new IllegalStateException("No instances!");
    }

    public static Disposable fromFuture(Future<?> future, boolean z5) {
        ObjectHelper.requireNonNull(future, "future is null");
        return new FutureDisposable(future, z5);
    }
}
