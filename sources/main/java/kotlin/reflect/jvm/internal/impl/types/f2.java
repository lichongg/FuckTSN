package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class f2 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f47249a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final f2 f47250b = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends f2 {
        @Override // kotlin.reflect.jvm.internal.impl.types.f2
        public boolean f() {
            return true;
        }

        public Void i(t0 key) {
            kotlin.jvm.internal.g0.p(key, "key");
            return null;
        }

        public String toString() {
            return "Empty TypeSubstitution";
        }

        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.f2
        public /* bridge */ /* synthetic */ c2 e(t0 t0Var) {
            return (c2) i(t0Var);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.v vVar) {
            this();
        }

        private b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends f2 {
        @Override // kotlin.reflect.jvm.internal.impl.types.f2
        public boolean a() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.f2
        public boolean b() {
            return false;
        }

        c() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.f2
        public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g d(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations) {
            kotlin.jvm.internal.g0.p(annotations, "annotations");
            return f2.this.d(annotations);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.f2
        public c2 e(t0 key) {
            kotlin.jvm.internal.g0.p(key, "key");
            return f2.this.e(key);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.f2
        public boolean f() {
            return f2.this.f();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.f2
        public t0 g(t0 topLevelType, Variance position) {
            kotlin.jvm.internal.g0.p(topLevelType, "topLevelType");
            kotlin.jvm.internal.g0.p(position, "position");
            return f2.this.g(topLevelType, position);
        }
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    @Nullable
    public abstract c2 e(@NotNull t0 t0Var);

    public boolean f() {
        return false;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations) {
        kotlin.jvm.internal.g0.p(annotations, "annotations");
        return annotations;
    }

    @NotNull
    public t0 g(@NotNull t0 topLevelType, @NotNull Variance position) {
        kotlin.jvm.internal.g0.p(topLevelType, "topLevelType");
        kotlin.jvm.internal.g0.p(position, "position");
        return topLevelType;
    }

    @NotNull
    public final f2 h() {
        return new c();
    }

    @NotNull
    public final h2 c() {
        h2 g6 = h2.g(this);
        kotlin.jvm.internal.g0.o(g6, "create(...)");
        return g6;
    }
}
