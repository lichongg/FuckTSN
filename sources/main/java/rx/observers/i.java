package rx.observers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Notification;
import rx.exceptions.CompositeException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes9.dex */
public class i<T> implements rx.f<T> {

    /* renamed from: e, reason: collision with root package name */
    private static final rx.f<Object> f54423e = new a();

    /* renamed from: a, reason: collision with root package name */
    private final rx.f<T> f54424a;

    /* renamed from: b, reason: collision with root package name */
    private final List<T> f54425b;

    /* renamed from: c, reason: collision with root package name */
    private final List<Throwable> f54426c;

    /* renamed from: d, reason: collision with root package name */
    private final List<Notification<T>> f54427d;

    public i(rx.f<T> fVar) {
        this.f54425b = new ArrayList();
        this.f54426c = new ArrayList();
        this.f54427d = new ArrayList();
        this.f54424a = fVar;
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

    public List<T> J() {
        return Collections.unmodifiableList(this.f54425b);
    }

    public void d(List<T> list) {
        if (this.f54425b.size() != list.size()) {
            f("Number of items does not match. Provided: " + list.size() + "  Actual: " + this.f54425b.size() + ".\nProvided values: " + list + "\nActual values: " + this.f54425b + com.snail.antifake.deviceid.e.f37542d);
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            T t5 = list.get(i6);
            T t6 = this.f54425b.get(i6);
            if (t5 == null) {
                if (t6 != null) {
                    f("Value at index: " + i6 + " expected to be [null] but was: [" + t6 + "]\n");
                }
            } else if (!t5.equals(t6)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Value at index: ");
                sb.append(i6);
                sb.append(" expected to be [");
                sb.append(t5);
                sb.append("] (");
                sb.append(t5.getClass().getSimpleName());
                sb.append(") but was: [");
                sb.append(t6);
                sb.append("] (");
                sb.append(t6 != null ? t6.getClass().getSimpleName() : "null");
                sb.append(")\n");
                f(sb.toString());
            }
        }
    }

    public void e() {
        if (this.f54426c.size() > 1) {
            f("Too many onError events: " + this.f54426c.size());
        }
        if (this.f54427d.size() > 1) {
            f("Too many onCompleted events: " + this.f54427d.size());
        }
        if (this.f54427d.size() == 1 && this.f54426c.size() == 1) {
            f("Received both an onError and onCompleted. Should be one or the other.");
        }
        if (this.f54427d.isEmpty() && this.f54426c.isEmpty()) {
            f("No terminal events received.");
        }
    }

    final void f(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 32);
        sb.append(str);
        sb.append(" (");
        int size = this.f54427d.size();
        sb.append(size);
        sb.append(" completion");
        if (size != 1) {
            sb.append('s');
        }
        sb.append(')');
        if (!this.f54426c.isEmpty()) {
            int size2 = this.f54426c.size();
            sb.append(" (+");
            sb.append(size2);
            sb.append(" error");
            if (size2 != 1) {
                sb.append('s');
            }
            sb.append(')');
        }
        AssertionError assertionError = new AssertionError(sb.toString());
        if (this.f54426c.isEmpty()) {
            throw assertionError;
        }
        if (this.f54426c.size() == 1) {
            assertionError.initCause(this.f54426c.get(0));
            throw assertionError;
        }
        assertionError.initCause(new CompositeException(this.f54426c));
        throw assertionError;
    }

    public List<Object> g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f54425b);
        arrayList.add(this.f54426c);
        arrayList.add(this.f54427d);
        return Collections.unmodifiableList(arrayList);
    }

    public List<Notification<T>> j() {
        return Collections.unmodifiableList(this.f54427d);
    }

    public List<Throwable> m() {
        return Collections.unmodifiableList(this.f54426c);
    }

    @Override // rx.f
    public void onCompleted() {
        this.f54427d.add(Notification.b());
        this.f54424a.onCompleted();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f54426c.add(th);
        this.f54424a.onError(th);
    }

    @Override // rx.f
    public void onNext(T t5) {
        this.f54425b.add(t5);
        this.f54424a.onNext(t5);
    }

    public i() {
        this.f54425b = new ArrayList();
        this.f54426c = new ArrayList();
        this.f54427d = new ArrayList();
        this.f54424a = (rx.f<T>) f54423e;
    }
}
