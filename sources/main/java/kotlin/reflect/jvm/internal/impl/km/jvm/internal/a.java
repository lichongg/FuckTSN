package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.v;
import kotlin.reflect.jvm.internal.impl.km.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a implements kotlin.reflect.jvm.internal.impl.km.internal.extensions.b {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final C0885a f45214e = new C0885a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.km.internal.extensions.f f45215f = new kotlin.reflect.jvm.internal.impl.km.internal.extensions.f(o0.d(a.class));

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<s> f45216a = new ArrayList(0);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private String f45217b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private String f45218c;

    /* renamed from: d, reason: collision with root package name */
    private int f45219d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.reflect.jvm.internal.impl.km.jvm.internal.a$a, reason: collision with other inner class name */
    public static final class C0885a {
        public /* synthetic */ C0885a(v vVar) {
            this();
        }

        private C0885a() {
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.km.internal.extensions.f a() {
            return a.f45215f;
        }
    }

    @Nullable
    public final String b() {
        return this.f45218c;
    }

    public final int c() {
        return this.f45219d;
    }

    @NotNull
    public final List<s> d() {
        return this.f45216a;
    }

    @Nullable
    public final String e() {
        return this.f45217b;
    }

    public final void f(@Nullable String str) {
        this.f45218c = str;
    }

    public final void g(int i6) {
        this.f45219d = i6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.e
    @NotNull
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.f getType() {
        return f45215f;
    }

    public final void h(@Nullable String str) {
        this.f45217b = str;
    }
}
