package rx.internal.util;

import java.io.PrintStream;
import java.util.Queue;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.v;
import rx.internal.util.unsafe.n0;
import rx.internal.util.unsafe.r;
import rx.internal.util.unsafe.z;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class j implements rx.m {

    /* renamed from: d, reason: collision with root package name */
    public static final int f54163d;

    /* renamed from: a, reason: collision with root package name */
    private Queue<Object> f54164a;

    /* renamed from: b, reason: collision with root package name */
    private final int f54165b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Object f54166c;

    private j(Queue<Object> queue, int i6) {
        this.f54164a = queue;
        this.f54165b = i6;
    }

    public void P(Object obj) throws MissingBackpressureException {
        boolean z5;
        boolean z6;
        synchronized (this) {
            try {
                Queue<Object> queue = this.f54164a;
                z5 = true;
                z6 = false;
                if (queue != null) {
                    z6 = !queue.offer(v.j(obj));
                    z5 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z5) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        }
        if (z6) {
            throw new MissingBackpressureException();
        }
    }

    public Object Q() {
        synchronized (this) {
            try {
                Queue<Object> queue = this.f54164a;
                if (queue == null) {
                    return null;
                }
                Object peek = queue.peek();
                Object obj = this.f54166c;
                if (peek == null && obj != null && queue.peek() == null) {
                    peek = obj;
                }
                return peek;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Object R() {
        synchronized (this) {
            try {
                Queue<Object> queue = this.f54164a;
                if (queue == null) {
                    return null;
                }
                Object poll = queue.poll();
                Object obj = this.f54166c;
                if (poll == null && obj != null && queue.peek() == null) {
                    this.f54166c = null;
                    poll = obj;
                }
                return poll;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void S() {
    }

    public boolean B() {
        Queue<Object> queue = this.f54164a;
        return queue == null || queue.isEmpty();
    }

    public void H() {
        if (this.f54166c == null) {
            this.f54166c = v.b();
        }
    }

    public void N(Throwable th) {
        if (this.f54166c == null) {
            this.f54166c = v.c(th);
        }
    }

    public int d() {
        return this.f54165b - f();
    }

    public int e() {
        return this.f54165b;
    }

    public int f() {
        Queue<Object> queue = this.f54164a;
        if (queue == null) {
            return 0;
        }
        return queue.size();
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f54164a == null;
    }

    static {
        int i6;
        if (i.b()) {
            i6 = 16;
        } else {
            i6 = 128;
        }
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                i6 = Integer.parseInt(property);
            } catch (NumberFormatException e6) {
                PrintStream printStream = System.err;
                e6.getMessage();
                printStream.getClass();
            }
        }
        f54163d = i6;
    }

    public static j g() {
        if (n0.f()) {
            return new j(true, f54163d);
        }
        return new j();
    }

    public static j j() {
        if (n0.f()) {
            return new j(false, f54163d);
        }
        return new j();
    }

    public boolean A(Object obj) {
        return v.f(obj);
    }

    public boolean G(Object obj) {
        return v.g(obj);
    }

    public boolean a(Object obj, rx.f fVar) {
        return v.a(fVar, obj);
    }

    public Throwable b(Object obj) {
        return v.d(obj);
    }

    public Object s(Object obj) {
        return v.e(obj);
    }

    @Override // rx.m
    public void unsubscribe() {
        S();
    }

    private j(boolean z5, int i6) {
        this.f54164a = z5 ? new r<>(i6) : new z<>(i6);
        this.f54165b = i6;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    j() {
        /*
            r2 = this;
            rx.internal.util.atomic.d r0 = new rx.internal.util.atomic.d
            int r1 = rx.internal.util.j.f54163d
            r0.<init>(r1)
            r2.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.j.<init>():void");
    }
}
