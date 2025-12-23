package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.v;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h implements l {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f45240c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.km.internal.extensions.f f45241d = new kotlin.reflect.jvm.internal.impl.km.internal.extensions.f(o0.d(h.class));

    /* renamed from: a, reason: collision with root package name */
    private boolean f45242a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<kotlin.reflect.jvm.internal.impl.km.d> f45243b = new ArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!g0.g(h.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        g0.n(obj, "null cannot be cast to non-null type kotlin.metadata.jvm.internal.JvmTypeExtension");
        h hVar = (h) obj;
        return this.f45242a == hVar.f45242a && g0.g(this.f45243b, hVar.f45243b);
    }

    @NotNull
    public final List<kotlin.reflect.jvm.internal.impl.km.d> a() {
        return this.f45243b;
    }

    public final boolean b() {
        return this.f45242a;
    }

    public final void c(boolean z5) {
        this.f45242a = z5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.e
    @NotNull
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.f getType() {
        return f45241d;
    }

    public int hashCode() {
        return (kotlin.reflect.jvm.internal.impl.km.f.a(this.f45242a) * 31) + this.f45243b.hashCode();
    }
}
