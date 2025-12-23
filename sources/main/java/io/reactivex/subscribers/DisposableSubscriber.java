package io.reactivex.subscribers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class DisposableSubscriber<T> implements Subscriber<T>, Disposable {

    /* renamed from: s, reason: collision with root package name */
    final AtomicReference<Subscription> f43431s = new AtomicReference<>();

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        SubscriptionHelper.cancel(this.f43431s);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f43431s.get() == SubscriptionHelper.CANCELLED;
    }

    protected void onStart() {
        this.f43431s.get().request(Long.MAX_VALUE);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.f43431s, subscription)) {
            onStart();
        }
    }

    protected final void request(long j6) {
        this.f43431s.get().request(j6);
    }

    protected final void cancel() {
        dispose();
    }
}
