package rx.observers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.CompositeException;
import rx.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class j<T> extends l<T> {

    /* renamed from: h, reason: collision with root package name */
    private static final rx.f<Object> f54428h = new a();

    /* renamed from: a, reason: collision with root package name */
    private final rx.f<T> f54429a;

    /* renamed from: b, reason: collision with root package name */
    private final List<T> f54430b;

    /* renamed from: c, reason: collision with root package name */
    private final List<Throwable> f54431c;

    /* renamed from: d, reason: collision with root package name */
    private int f54432d;

    /* renamed from: e, reason: collision with root package name */
    private final CountDownLatch f54433e;

    /* renamed from: f, reason: collision with root package name */
    private volatile int f54434f;

    /* renamed from: g, reason: collision with root package name */
    private volatile Thread f54435g;

    public j(long j6) {
        this(f54428h, j6);
    }

    public final void V(T t5, T... tArr) {
        T(tArr.length + 1);
        A(t5, 0);
        int i6 = 0;
        while (i6 < tArr.length) {
            T t6 = tArr[i6];
            i6++;
            A(t6, i6);
        }
        this.f54430b.clear();
        this.f54434f = 0;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements rx.f<Object> {
        a() {
        }

        @Override // rx.f
        public void onCompleted() {
        }

        @Override // rx.f
        public void onError(Throwable th) {
        }

        @Override // rx.f
        public void onNext(Object obj) {
        }
    }

    public j(rx.f<T> fVar, long j6) {
        this.f54433e = new CountDownLatch(1);
        fVar.getClass();
        this.f54429a = fVar;
        if (j6 >= 0) {
            request(j6);
        }
        this.f54430b = new ArrayList();
        this.f54431c = new ArrayList();
    }

    private void A(T t5, int i6) {
        T t6 = this.f54430b.get(i6);
        if (t5 == null) {
            if (t6 != null) {
                W("Value at index: " + i6 + " expected: [null] but was: [" + t6 + "]\n");
                return;
            }
            return;
        }
        if (t5.equals(t6)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Value at index: ");
        sb.append(i6);
        sb.append(" expected: [");
        sb.append(t5);
        sb.append("] (");
        sb.append(t5.getClass().getSimpleName());
        sb.append(") but was: [");
        sb.append(t6);
        sb.append("] (");
        sb.append(t6 != null ? t6.getClass().getSimpleName() : "null");
        sb.append(")\n");
        W(sb.toString());
    }

    public static <T> j<T> b0() {
        return new j<>();
    }

    public static <T> j<T> c0(long j6) {
        return new j<>(j6);
    }

    public static <T> j<T> d0(rx.f<T> fVar) {
        return new j<>(fVar);
    }

    public static <T> j<T> e0(rx.f<T> fVar, long j6) {
        return new j<>(fVar, j6);
    }

    public static <T> j<T> f0(l<T> lVar) {
        return new j<>((l) lVar);
    }

    public final int E() {
        return this.f54434f;
    }

    public void G() {
        List<Throwable> list = this.f54431c;
        int i6 = this.f54432d;
        if (!list.isEmpty() || i6 > 0) {
            if (list.isEmpty()) {
                W("Found " + list.size() + " errors and " + i6 + " completion events instead of none");
                return;
            }
            if (list.size() == 1) {
                W("Found " + list.size() + " errors and " + i6 + " completion events instead of none");
                return;
            }
            W("Found " + list.size() + " errors and " + i6 + " completion events instead of none");
        }
    }

    public void H() {
        int size = this.f54430b.size();
        if (size != 0) {
            W("No onNext events expected yet some received: " + size);
        }
    }

    public List<T> J() {
        return this.f54430b;
    }

    public void N() {
        int i6 = this.f54432d;
        if (i6 == 1) {
            W("Completed!");
        } else if (i6 > 1) {
            W("Completed multiple times: " + i6);
        }
    }

    public void P(List<T> list) {
        if (this.f54430b.size() != list.size()) {
            W("Number of items does not match. Provided: " + list.size() + "  Actual: " + this.f54430b.size() + ".\nProvided values: " + list + "\nActual values: " + this.f54430b + com.snail.antifake.deviceid.e.f37542d);
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            A(list.get(i6), i6);
        }
    }

    public void Q() {
        if (this.f54431c.size() > 1) {
            W("Too many onError events: " + this.f54431c.size());
        }
        if (this.f54432d > 1) {
            W("Too many onCompleted events: " + this.f54432d);
        }
        if (this.f54432d == 1 && this.f54431c.size() == 1) {
            W("Received both an onError and onCompleted. Should be one or the other.");
        }
        if (this.f54432d == 0 && this.f54431c.isEmpty()) {
            W("No terminal events received.");
        }
    }

    public void T(int i6) {
        int size = this.f54430b.size();
        if (size != i6) {
            W("Number of onNext events differ; expected: " + i6 + ", actual: " + size);
        }
    }

    final void W(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 32);
        sb.append(str);
        sb.append(" (");
        int i6 = this.f54432d;
        sb.append(i6);
        sb.append(" completion");
        if (i6 != 1) {
            sb.append('s');
        }
        sb.append(')');
        if (!this.f54431c.isEmpty()) {
            int size = this.f54431c.size();
            sb.append(" (+");
            sb.append(size);
            sb.append(" error");
            if (size != 1) {
                sb.append('s');
            }
            sb.append(')');
        }
        AssertionError assertionError = new AssertionError(sb.toString());
        if (this.f54431c.isEmpty()) {
            throw assertionError;
        }
        if (this.f54431c.size() == 1) {
            assertionError.initCause(this.f54431c.get(0));
            throw assertionError;
        }
        assertionError.initCause(new CompositeException(this.f54431c));
        throw assertionError;
    }

    public void X() {
        try {
            this.f54433e.await();
        } catch (InterruptedException e6) {
            throw new IllegalStateException("Interrupted", e6);
        }
    }

    public void Y(long j6, TimeUnit timeUnit) {
        try {
            this.f54433e.await(j6, timeUnit);
        } catch (InterruptedException e6) {
            throw new IllegalStateException("Interrupted", e6);
        }
    }

    public void Z(long j6, TimeUnit timeUnit) {
        try {
            if (this.f54433e.await(j6, timeUnit)) {
                return;
            }
            unsubscribe();
        } catch (InterruptedException unused) {
            unsubscribe();
        }
    }

    public final boolean a0(int i6, long j6, TimeUnit timeUnit) {
        while (j6 != 0 && this.f54434f < i6) {
            try {
                timeUnit.sleep(1L);
                j6--;
            } catch (InterruptedException e6) {
                throw new IllegalStateException("Interrupted", e6);
            }
        }
        return this.f54434f >= i6;
    }

    public void g() {
        int i6 = this.f54432d;
        if (i6 == 0) {
            W("Not completed!");
        } else if (i6 > 1) {
            W("Completed multiple times: " + i6);
        }
    }

    @Deprecated
    public List<Notification<T>> g0() {
        int i6 = this.f54432d;
        ArrayList arrayList = new ArrayList(i6 != 0 ? i6 : 1);
        for (int i7 = 0; i7 < i6; i7++) {
            arrayList.add(Notification.b());
        }
        return arrayList;
    }

    public void j(Class<? extends Throwable> cls) {
        List<Throwable> list = this.f54431c;
        if (list.isEmpty()) {
            W("No errors");
            return;
        }
        if (list.size() > 1) {
            AssertionError assertionError = new AssertionError("Multiple errors: " + list.size());
            assertionError.initCause(new CompositeException(list));
            throw assertionError;
        }
        if (cls.isInstance(list.get(0))) {
            return;
        }
        AssertionError assertionError2 = new AssertionError("Exceptions differ; expected: " + cls + ", actual: " + list.get(0));
        assertionError2.initCause(list.get(0));
        throw assertionError2;
    }

    public List<Throwable> m() {
        return this.f54431c;
    }

    @Override // rx.f
    public void onCompleted() {
        try {
            this.f54432d++;
            this.f54435g = Thread.currentThread();
            this.f54429a.onCompleted();
        } finally {
            this.f54433e.countDown();
        }
    }

    public void s(Throwable th) {
        List<Throwable> list = this.f54431c;
        if (list.isEmpty()) {
            W("No errors");
            return;
        }
        if (list.size() > 1) {
            W("Multiple errors");
            return;
        }
        if (th.equals(list.get(0))) {
            return;
        }
        W("Exceptions differ; expected: " + th + ", actual: " + list.get(0));
    }

    public final int w() {
        return this.f54432d;
    }

    public Thread z() {
        return this.f54435g;
    }

    public void B() {
        if (!m().isEmpty()) {
            W("Unexpected onError events");
        }
    }

    public void R() {
        if (!isUnsubscribed()) {
            W("Not unsubscribed.");
        }
    }

    public void S(T t5) {
        P(Collections.singletonList(t5));
    }

    public void U(T... tArr) {
        P(Arrays.asList(tArr));
    }

    public void h0(long j6) {
        request(j6);
    }

    @Override // rx.f
    public void onError(Throwable th) {
        try {
            this.f54435g = Thread.currentThread();
            this.f54431c.add(th);
            this.f54429a.onError(th);
        } finally {
            this.f54433e.countDown();
        }
    }

    @Override // rx.f
    public void onNext(T t5) {
        this.f54435g = Thread.currentThread();
        this.f54430b.add(t5);
        this.f54434f = this.f54430b.size();
        this.f54429a.onNext(t5);
    }

    public j(l<T> lVar) {
        this(lVar, -1L);
    }

    public j(rx.f<T> fVar) {
        this(fVar, -1L);
    }

    public j() {
        this(-1L);
    }
}
