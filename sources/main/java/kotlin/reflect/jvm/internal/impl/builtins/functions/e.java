package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.c f44419a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f44420b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f44421c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final kotlin.reflect.jvm.internal.impl.name.b f44422d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f44423e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends e {

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        public static final a f44424f = new a();

        private a() {
            super(o.B, "Function", false, null, true);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends e {

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        public static final b f44425f = new b();

        private b() {
            super(o.f44581y, "KFunction", true, null, false);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends e {

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        public static final c f44426f = new c();

        private c() {
            super(o.f44581y, "KSuspendFunction", true, null, false);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d extends e {

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        public static final d f44427f = new d();

        private d() {
            super(o.f44575s, "SuspendFunction", false, null, true);
        }
    }

    public e(@NotNull kotlin.reflect.jvm.internal.impl.name.c packageFqName, @NotNull String classNamePrefix, boolean z5, @Nullable kotlin.reflect.jvm.internal.impl.name.b bVar, boolean z6) {
        g0.p(packageFqName, "packageFqName");
        g0.p(classNamePrefix, "classNamePrefix");
        this.f44419a = packageFqName;
        this.f44420b = classNamePrefix;
        this.f44421c = z5;
        this.f44422d = bVar;
        this.f44423e = z6;
    }

    @NotNull
    public final String a() {
        return this.f44420b;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.c b() {
        return this.f44419a;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.f c(int i6) {
        kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(this.f44420b + i6);
        g0.o(h6, "identifier(...)");
        return h6;
    }

    @NotNull
    public String toString() {
        return this.f44419a + '.' + this.f44420b + 'N';
    }
}
