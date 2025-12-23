package rx;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class l<T> implements f<T>, m {
    private static final long NOT_SET = Long.MIN_VALUE;
    private g producer;
    private long requested;
    private final l<?> subscriber;
    private final rx.internal.util.m subscriptions;

    protected l() {
        this(null, false);
    }

    public void setProducer(g gVar) {
        long j6;
        l<?> lVar;
        boolean z5;
        synchronized (this) {
            j6 = this.requested;
            this.producer = gVar;
            lVar = this.subscriber;
            z5 = lVar != null && j6 == Long.MIN_VALUE;
        }
        if (z5) {
            lVar.setProducer(gVar);
        } else if (j6 == Long.MIN_VALUE) {
            gVar.request(Long.MAX_VALUE);
        } else {
            gVar.request(j6);
        }
    }

    protected l(l<?> lVar) {
        this(lVar, true);
    }

    private void f(long j6) {
        long j7 = this.requested;
        if (j7 == Long.MIN_VALUE) {
            this.requested = j6;
            return;
        }
        long j8 = j7 + j6;
        if (j8 < 0) {
            this.requested = Long.MAX_VALUE;
        } else {
            this.requested = j8;
        }
    }

    public final void add(m mVar) {
        this.subscriptions.a(mVar);
    }

    @Override // rx.m
    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    protected final void request(long j6) {
        if (j6 < 0) {
            throw new IllegalArgumentException("number requested cannot be negative: " + j6);
        }
        synchronized (this) {
            g gVar = this.producer;
            if (gVar != null) {
                gVar.request(j6);
            } else {
                f(j6);
            }
        }
    }

    @Override // rx.m
    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    protected l(l<?> lVar, boolean z5) {
        this.requested = Long.MIN_VALUE;
        this.subscriber = lVar;
        this.subscriptions = (!z5 || lVar == null) ? new rx.internal.util.m() : lVar.subscriptions;
    }

    public void onStart() {
    }
}
