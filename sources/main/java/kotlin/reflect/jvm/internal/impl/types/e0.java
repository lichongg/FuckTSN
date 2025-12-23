package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e0 extends f2 {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f47206e = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final f2 f47207c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final f2 f47208d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @JvmStatic
        @NotNull
        public final f2 a(@NotNull f2 first, @NotNull f2 second) {
            kotlin.jvm.internal.g0.p(first, "first");
            kotlin.jvm.internal.g0.p(second, "second");
            return first.f() ? second : second.f() ? first : new e0(first, second, null);
        }
    }

    public /* synthetic */ e0(f2 f2Var, f2 f2Var2, kotlin.jvm.internal.v vVar) {
        this(f2Var, f2Var2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.f2
    public boolean f() {
        return false;
    }

    private e0(f2 f2Var, f2 f2Var2) {
        this.f47207c = f2Var;
        this.f47208d = f2Var2;
    }

    @JvmStatic
    @NotNull
    public static final f2 i(@NotNull f2 f2Var, @NotNull f2 f2Var2) {
        return f47206e.a(f2Var, f2Var2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.f2
    public boolean a() {
        return this.f47207c.a() || this.f47208d.a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.f2
    public boolean b() {
        return this.f47207c.b() || this.f47208d.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.f2
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations) {
        kotlin.jvm.internal.g0.p(annotations, "annotations");
        return this.f47208d.d(this.f47207c.d(annotations));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.f2
    @Nullable
    public c2 e(@NotNull t0 key) {
        kotlin.jvm.internal.g0.p(key, "key");
        c2 e6 = this.f47207c.e(key);
        return e6 == null ? this.f47208d.e(key) : e6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.f2
    @NotNull
    public t0 g(@NotNull t0 topLevelType, @NotNull Variance position) {
        kotlin.jvm.internal.g0.p(topLevelType, "topLevelType");
        kotlin.jvm.internal.g0.p(position, "position");
        return this.f47208d.g(this.f47207c.g(topLevelType, position), position);
    }
}
