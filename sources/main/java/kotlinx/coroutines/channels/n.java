package kotlinx.coroutines.channels;

import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.g0;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmInline
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n<T> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b f48241b = new b(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final c f48242c = new c();

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final Object f48243a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends c {

        /* renamed from: a, reason: collision with root package name */
        @JvmField
        @Nullable
        public final Throwable f48244a;

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof a) && g0.g(this.f48244a, ((a) obj).f48244a);
        }

        public int hashCode() {
            Throwable th = this.f48244a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.n.c
        @NotNull
        public String toString() {
            return "Closed(" + this.f48244a + ')';
        }

        public a(@Nullable Throwable th) {
            this.f48244a = th;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @InternalCoroutinesApi
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.v vVar) {
            this();
        }

        private b() {
        }

        @InternalCoroutinesApi
        @NotNull
        public final <E> Object a(@Nullable Throwable th) {
            return n.c(new a(th));
        }

        @InternalCoroutinesApi
        @NotNull
        public final <E> Object b() {
            return n.c(n.f48242c);
        }

        @InternalCoroutinesApi
        @NotNull
        public final <E> Object c(E e6) {
            return n.c(e6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c {
        @NotNull
        public String toString() {
            return "Failed";
        }
    }

    public static final /* synthetic */ n b(Object obj) {
        return new n(obj);
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof n) && g0.g(obj, ((n) obj2).o());
    }

    @Nullable
    public static final Throwable f(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar != null) {
            return aVar.f48244a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final T h(Object obj) {
        if (obj instanceof c) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T i(Object obj) {
        Throwable th;
        if (!(obj instanceof c)) {
            return obj;
        }
        if ((obj instanceof a) && (th = ((a) obj).f48244a) != null) {
            throw th;
        }
        throw new IllegalStateException(("Trying to call 'getOrThrow' on a failed channel result: " + obj).toString());
    }

    public static int j(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean k(Object obj) {
        return obj instanceof a;
    }

    public static final boolean l(Object obj) {
        return obj instanceof c;
    }

    public static final boolean m(Object obj) {
        return !(obj instanceof c);
    }

    @NotNull
    public static String n(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f48243a, obj);
    }

    public int hashCode() {
        return j(this.f48243a);
    }

    public final /* synthetic */ Object o() {
        return this.f48243a;
    }

    @NotNull
    public String toString() {
        return n(this.f48243a);
    }

    @PublishedApi
    private /* synthetic */ n(Object obj) {
        this.f48243a = obj;
    }

    public static final boolean e(Object obj, Object obj2) {
        return g0.g(obj, obj2);
    }

    @PublishedApi
    public static /* synthetic */ void g() {
    }

    @PublishedApi
    @NotNull
    public static <T> Object c(@Nullable Object obj) {
        return obj;
    }
}
