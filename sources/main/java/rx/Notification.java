package rx;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class Notification<T> {

    /* renamed from: d, reason: collision with root package name */
    private static final Notification<Void> f52231d = new Notification<>(Kind.OnCompleted, null, null);

    /* renamed from: a, reason: collision with root package name */
    private final Kind f52232a;

    /* renamed from: b, reason: collision with root package name */
    private final Throwable f52233b;

    /* renamed from: c, reason: collision with root package name */
    private final T f52234c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public boolean equals(Object obj) {
        T t5;
        T t6;
        Throwable th;
        Throwable th2;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != Notification.class) {
            return false;
        }
        Notification notification = (Notification) obj;
        return notification.f() == f() && ((t5 = this.f52234c) == (t6 = notification.f52234c) || (t5 != null && t5.equals(t6))) && ((th = this.f52233b) == (th2 = notification.f52233b) || (th != null && th.equals(th2)));
    }

    public static <T> Notification<T> b() {
        return (Notification<T>) f52231d;
    }

    @Deprecated
    public static <T> Notification<T> c(Class<T> cls) {
        return (Notification<T>) f52231d;
    }

    public static <T> Notification<T> d(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> e(T t5) {
        return new Notification<>(Kind.OnNext, t5, null);
    }

    public void a(f<? super T> fVar) {
        Kind kind = this.f52232a;
        if (kind == Kind.OnNext) {
            fVar.onNext(h());
        } else if (kind == Kind.OnCompleted) {
            fVar.onCompleted();
        } else {
            fVar.onError(g());
        }
    }

    public Kind f() {
        return this.f52232a;
    }

    public Throwable g() {
        return this.f52233b;
    }

    public T h() {
        return this.f52234c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append('[');
        sb.append(super.toString());
        sb.append(' ');
        sb.append(f());
        if (j()) {
            sb.append(' ');
            sb.append(h());
        }
        if (i()) {
            sb.append(' ');
            sb.append(g().getMessage());
        }
        sb.append(']');
        return sb.toString();
    }

    private Notification(Kind kind, T t5, Throwable th) {
        this.f52234c = t5;
        this.f52233b = th;
        this.f52232a = kind;
    }

    public int hashCode() {
        int hashCode = f().hashCode();
        if (j()) {
            hashCode = (hashCode * 31) + h().hashCode();
        }
        if (i()) {
            return (hashCode * 31) + g().hashCode();
        }
        return hashCode;
    }

    public boolean i() {
        if (l() && this.f52233b != null) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (m() && this.f52234c != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if (f() == Kind.OnCompleted) {
            return true;
        }
        return false;
    }

    public boolean l() {
        if (f() == Kind.OnError) {
            return true;
        }
        return false;
    }

    public boolean m() {
        if (f() == Kind.OnNext) {
            return true;
        }
        return false;
    }
}
