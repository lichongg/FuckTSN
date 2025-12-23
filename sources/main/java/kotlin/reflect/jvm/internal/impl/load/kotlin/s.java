package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f45991a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final d f45992b = new d(JvmPrimitiveType.BOOLEAN);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final d f45993c = new d(JvmPrimitiveType.CHAR);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final d f45994d = new d(JvmPrimitiveType.BYTE);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final d f45995e = new d(JvmPrimitiveType.SHORT);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final d f45996f = new d(JvmPrimitiveType.INT);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final d f45997g = new d(JvmPrimitiveType.FLOAT);

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final d f45998h = new d(JvmPrimitiveType.LONG);

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final d f45999i = new d(JvmPrimitiveType.DOUBLE);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends s {

        /* renamed from: j, reason: collision with root package name */
        @NotNull
        private final s f46000j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull s elementType) {
            super(null);
            kotlin.jvm.internal.g0.p(elementType, "elementType");
            this.f46000j = elementType;
        }

        @NotNull
        public final s i() {
            return this.f46000j;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.v vVar) {
            this();
        }

        private b() {
        }

        @NotNull
        public final d a() {
            return s.f45992b;
        }

        @NotNull
        public final d b() {
            return s.f45994d;
        }

        @NotNull
        public final d c() {
            return s.f45993c;
        }

        @NotNull
        public final d d() {
            return s.f45999i;
        }

        @NotNull
        public final d e() {
            return s.f45997g;
        }

        @NotNull
        public final d f() {
            return s.f45996f;
        }

        @NotNull
        public final d g() {
            return s.f45998h;
        }

        @NotNull
        public final d h() {
            return s.f45995e;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends s {

        /* renamed from: j, reason: collision with root package name */
        @NotNull
        private final String f46001j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull String internalName) {
            super(null);
            kotlin.jvm.internal.g0.p(internalName, "internalName");
            this.f46001j = internalName;
        }

        @NotNull
        public final String i() {
            return this.f46001j;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d extends s {

        /* renamed from: j, reason: collision with root package name */
        @Nullable
        private final JvmPrimitiveType f46002j;

        public d(@Nullable JvmPrimitiveType jvmPrimitiveType) {
            super(null);
            this.f46002j = jvmPrimitiveType;
        }

        @Nullable
        public final JvmPrimitiveType i() {
            return this.f46002j;
        }
    }

    public /* synthetic */ s(kotlin.jvm.internal.v vVar) {
        this();
    }

    private s() {
    }

    @NotNull
    public String toString() {
        return u.f46003a.e(this);
    }
}
