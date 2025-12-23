package rx.internal.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.a;
import rx.functions.n;
import rx.m;
import rx.plugins.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CancellableSubscription extends AtomicReference<n> implements m {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(n nVar) {
        super(nVar);
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // rx.m
    public void unsubscribe() {
        n andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e6) {
                a.e(e6);
                c.I(e6);
            }
        }
    }
}
