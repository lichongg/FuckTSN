package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.x;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f implements x {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f44967c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Class<?> f44968a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final KotlinClassHeader f44969b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }

        @Nullable
        public final f a(@NotNull Class<?> klass) {
            g0.p(klass, "klass");
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.a aVar = new kotlin.reflect.jvm.internal.impl.load.kotlin.header.a();
            c.f44965a.b(klass, aVar);
            KotlinClassHeader m6 = aVar.m();
            v vVar = null;
            if (m6 == null) {
                return null;
            }
            return new f(klass, m6, vVar);
        }
    }

    public /* synthetic */ f(Class cls, KotlinClassHeader kotlinClassHeader, v vVar) {
        this(cls, kotlinClassHeader);
    }

    private f(Class<?> cls, KotlinClassHeader kotlinClassHeader) {
        this.f44968a = cls;
        this.f44969b = kotlinClassHeader;
    }

    @NotNull
    public final Class<?> a() {
        return this.f44968a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.b c() {
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.f.e(this.f44968a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x
    public void d(@NotNull x.d visitor, @Nullable byte[] bArr) {
        g0.p(visitor, "visitor");
        c.f44965a.i(this.f44968a, visitor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x
    @NotNull
    public KotlinClassHeader e() {
        return this.f44969b;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof f) && g0.g(this.f44968a, ((f) obj).f44968a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x
    public void f(@NotNull x.c visitor, @Nullable byte[] bArr) {
        g0.p(visitor, "visitor");
        c.f44965a.b(this.f44968a, visitor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x
    @NotNull
    public String getLocation() {
        StringBuilder sb = new StringBuilder();
        String name = this.f44968a.getName();
        g0.o(name, "getName(...)");
        sb.append(u.w2(name, '.', '/', false, 4, null));
        sb.append(".class");
        return sb.toString();
    }

    public int hashCode() {
        return this.f44968a.hashCode();
    }

    @NotNull
    public String toString() {
        return f.class.getName() + ": " + this.f44968a;
    }
}
