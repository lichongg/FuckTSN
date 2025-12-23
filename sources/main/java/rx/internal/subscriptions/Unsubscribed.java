package rx.internal.subscriptions;

import rx.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public enum Unsubscribed implements m {
    INSTANCE;

    @Override // rx.m
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // rx.m
    public void unsubscribe() {
    }
}
