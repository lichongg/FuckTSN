package kotlin.reflect.jvm.internal.impl.descriptors;

import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class u1 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final u1 f45044a = new u1();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Map<v1, Integer> f45045b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final h f45046c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends v1 {

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final a f45047c = new a();

        private a() {
            super("inherited", false);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends v1 {

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final b f45048c = new b();

        private b() {
            super(UMModuleRegister.INNER, false);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends v1 {

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final c f45049c = new c();

        private c() {
            super("invisible_fake", false);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d extends v1 {

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final d f45050c = new d();

        private d() {
            super("local", false);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class e extends v1 {

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final e f45051c = new e();

        private e() {
            super("private", false);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class f extends v1 {

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final f f45052c = new f();

        private f() {
            super("private_to_this", false);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.v1
        @NotNull
        public String b() {
            return "private/*private to this*/";
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class g extends v1 {

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final g f45053c = new g();

        private g() {
            super("protected", true);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class h extends v1 {

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final h f45054c = new h();

        private h() {
            super("public", true);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class i extends v1 {

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final i f45055c = new i();

        private i() {
            super("unknown", false);
        }
    }

    static {
        Map g6 = kotlin.collections.i1.g();
        g6.put(f.f45052c, 0);
        g6.put(e.f45051c, 0);
        g6.put(b.f45048c, 1);
        g6.put(g.f45053c, 1);
        h hVar = h.f45054c;
        g6.put(hVar, 2);
        f45045b = kotlin.collections.i1.d(g6);
        f45046c = hVar;
    }

    @Nullable
    public final Integer a(@NotNull v1 first, @NotNull v1 second) {
        kotlin.jvm.internal.g0.p(first, "first");
        kotlin.jvm.internal.g0.p(second, "second");
        if (first == second) {
            return 0;
        }
        Map<v1, Integer> map = f45045b;
        Integer num = map.get(first);
        Integer num2 = map.get(second);
        if (num == null || num2 == null || kotlin.jvm.internal.g0.g(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean b(@NotNull v1 visibility) {
        kotlin.jvm.internal.g0.p(visibility, "visibility");
        return visibility == e.f45051c || visibility == f.f45052c;
    }

    private u1() {
    }
}
