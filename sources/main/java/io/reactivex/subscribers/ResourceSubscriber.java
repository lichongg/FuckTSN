package io.reactivex.subscribers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class ResourceSubscriber<T> implements Subscriber<T>, Disposable {

    /* renamed from: s, reason: collision with root package name */
    private final AtomicReference<Subscription> f43432s = new AtomicReference<>();
    private final ListCompositeDisposable resources = new ListCompositeDisposable();
    private final AtomicLong missedRequested = new AtomicLong();

    public final void add(Disposable disposable) {
        ObjectHelper.requireNonNull(disposable, "resource is null");
        this.resources.add(disposable);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (SubscriptionHelper.cancel(this.f43432s)) {
            this.resources.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return SubscriptionHelper.isCancelled(this.f43432s.get());
    }

    @Override // org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.deferredSetOnce(this.f43432s, this.missedRequested, subscription)) {
            onStart();
        }
    }

    protected final void request(long j6) {
        SubscriptionHelper.deferredRequest(this.f43432s, this.missedRequested, j6);
    }

    protected void onStart() {
        request(Long.MAX_VALUE);
    }
}
