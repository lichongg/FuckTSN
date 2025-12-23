package kotlin.reflect.jvm.internal.impl.km;

import java.util.List;
import kotlin.d1;
import kotlin.j1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.v0;
import kotlin.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class e {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends e {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final kotlin.reflect.jvm.internal.impl.km.d f45117a;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && g0.g(this.f45117a, ((a) obj).f45117a);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull kotlin.reflect.jvm.internal.impl.km.d annotation) {
            super(null);
            g0.p(annotation, "annotation");
            this.f45117a = annotation;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.km.d a() {
            return this.f45117a;
        }

        public int hashCode() {
            return this.f45117a.hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.e
        @NotNull
        public String toString() {
            return "AnnotationValue(" + this.f45117a + ')';
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nAnnotations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Annotations.kt\nkotlin/metadata/KmAnnotationArgument$ArrayKClassValue\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,202:1\n1#2:203\n*E\n"})
    public static final class b extends e {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f45118a;

        /* renamed from: b, reason: collision with root package name */
        private final int f45119b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        private final String f45120c;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return g0.g(this.f45118a, bVar.f45118a) && this.f45119b == bVar.f45119b;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull String className, int i6) {
            super(null);
            g0.p(className, "className");
            this.f45118a = className;
            this.f45119b = i6;
            if (i6 <= 0) {
                throw new IllegalArgumentException("ArrayKClassValue must have at least one dimension. For regular X::class argument, use KClassValue.");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ArrayKClassValue(");
            for (int i7 = 0; i7 < i6; i7++) {
                sb.append("kotlin/Array<");
            }
            sb.append(this.f45118a);
            int i8 = this.f45119b;
            for (int i9 = 0; i9 < i8; i9++) {
                sb.append(">");
            }
            sb.append(")");
            this.f45120c = sb.toString();
        }

        public final int a() {
            return this.f45119b;
        }

        @NotNull
        public final String b() {
            return this.f45118a;
        }

        public int hashCode() {
            return (this.f45118a.hashCode() * 31) + this.f45119b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.e
        @NotNull
        public String toString() {
            return this.f45120c;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends e {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final List<e> f45121a;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && g0.g(this.f45121a, ((c) obj).f45121a);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull List<? extends e> elements) {
            super(null);
            g0.p(elements, "elements");
            this.f45121a = elements;
        }

        @NotNull
        public final List<e> a() {
            return this.f45121a;
        }

        public int hashCode() {
            return this.f45121a.hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.e
        @NotNull
        public String toString() {
            return "ArrayValue(" + this.f45121a + ')';
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d extends l<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f45122a;

        public d(boolean z5) {
            super(null);
            this.f45122a = z5;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && this.f45122a == ((d) obj).f45122a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.e.l
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a() {
            return Boolean.valueOf(this.f45122a);
        }

        public int hashCode() {
            return kotlin.reflect.jvm.internal.impl.km.f.a(this.f45122a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.reflect.jvm.internal.impl.km.e$e, reason: collision with other inner class name */
    public static final class C0883e extends l<Byte> {

        /* renamed from: a, reason: collision with root package name */
        private final byte f45123a;

        public C0883e(byte b6) {
            super(null);
            this.f45123a = b6;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0883e) && this.f45123a == ((C0883e) obj).f45123a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.e.l
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Byte a() {
            return Byte.valueOf(this.f45123a);
        }

        public int hashCode() {
            return this.f45123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class f extends l<Character> {

        /* renamed from: a, reason: collision with root package name */
        private final char f45124a;

        public f(char c6) {
            super(null);
            this.f45124a = c6;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof f) && this.f45124a == ((f) obj).f45124a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.e.l
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Character a() {
            return Character.valueOf(this.f45124a);
        }

        public int hashCode() {
            return this.f45124a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class g extends l<Double> {

        /* renamed from: a, reason: collision with root package name */
        private final double f45125a;

        public g(double d6) {
            super(null);
            this.f45125a = d6;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof g) && Double.compare(this.f45125a, ((g) obj).f45125a) == 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.e.l
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double a() {
            return Double.valueOf(this.f45125a);
        }

        public int hashCode() {
            return kotlin.ranges.d.a(this.f45125a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class h extends e {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f45126a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final String f45127b;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return g0.g(this.f45126a, hVar.f45126a) && g0.g(this.f45127b, hVar.f45127b);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(@NotNull String enumClassName, @NotNull String enumEntryName) {
            super(null);
            g0.p(enumClassName, "enumClassName");
            g0.p(enumEntryName, "enumEntryName");
            this.f45126a = enumClassName;
            this.f45127b = enumEntryName;
        }

        @NotNull
        public final String a() {
            return this.f45126a;
        }

        @NotNull
        public final String b() {
            return this.f45127b;
        }

        public int hashCode() {
            return (this.f45126a.hashCode() * 31) + this.f45127b.hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.e
        @NotNull
        public String toString() {
            return "EnumValue(" + this.f45126a + '.' + this.f45127b + ')';
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class i extends l<Float> {

        /* renamed from: a, reason: collision with root package name */
        private final float f45128a;

        public i(float f6) {
            super(null);
            this.f45128a = f6;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof i) && Float.compare(this.f45128a, ((i) obj).f45128a) == 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.e.l
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Float a() {
            return Float.valueOf(this.f45128a);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f45128a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class j extends l<Integer> {

        /* renamed from: a, reason: collision with root package name */
        private final int f45129a;

        public j(int i6) {
            super(null);
            this.f45129a = i6;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof j) && this.f45129a == ((j) obj).f45129a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.e.l
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer a() {
            return Integer.valueOf(this.f45129a);
        }

        public int hashCode() {
            return this.f45129a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class k extends e {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f45130a;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof k) && g0.g(this.f45130a, ((k) obj).f45130a);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(@NotNull String className) {
            super(null);
            g0.p(className, "className");
            this.f45130a = className;
        }

        @NotNull
        public final String a() {
            return this.f45130a;
        }

        public int hashCode() {
            return this.f45130a.hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.e
        @NotNull
        public String toString() {
            return "KClassValue(" + this.f45130a + ')';
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class l<T> extends e {
        public /* synthetic */ l(kotlin.jvm.internal.v vVar) {
            this();
        }

        @NotNull
        public abstract T a();

        private l() {
            super(null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.e
        @NotNull
        public final String toString() {
            String obj;
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append('(');
            if (this instanceof o) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append('\"');
                sb2.append((Object) ((o) this).a());
                sb2.append('\"');
                obj = sb2.toString();
            } else {
                obj = a().toString();
            }
            sb.append(obj);
            sb.append(')');
            return sb.toString();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class m extends l<Long> {

        /* renamed from: a, reason: collision with root package name */
        private final long f45131a;

        public m(long j6) {
            super(null);
            this.f45131a = j6;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof m) && this.f45131a == ((m) obj).f45131a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.e.l
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long a() {
            return Long.valueOf(this.f45131a);
        }

        public int hashCode() {
            return androidx.camera.camera2.internal.compat.params.e.a(this.f45131a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class n extends l<Short> {

        /* renamed from: a, reason: collision with root package name */
        private final short f45132a;

        public n(short s5) {
            super(null);
            this.f45132a = s5;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof n) && this.f45132a == ((n) obj).f45132a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.e.l
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Short a() {
            return Short.valueOf(this.f45132a);
        }

        public int hashCode() {
            return this.f45132a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class o extends l<String> {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f45133a;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof o) && g0.g(this.f45133a, ((o) obj).f45133a);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(@NotNull String value) {
            super(null);
            g0.p(value, "value");
            this.f45133a = value;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.e.l
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a() {
            return this.f45133a;
        }

        public int hashCode() {
            return this.f45133a.hashCode();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class p extends l<v0> {

        /* renamed from: a, reason: collision with root package name */
        private final byte f45134a;

        public /* synthetic */ p(byte b6, kotlin.jvm.internal.v vVar) {
            this(b6);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof p) && this.f45134a == ((p) obj).f45134a;
        }

        private p(byte b6) {
            super(null);
            this.f45134a = b6;
        }

        public byte b() {
            return this.f45134a;
        }

        public int hashCode() {
            return v0.x(this.f45134a);
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.e.l
        public /* bridge */ /* synthetic */ v0 a() {
            return v0.b(b());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class q extends l<z0> {

        /* renamed from: a, reason: collision with root package name */
        private final int f45135a;

        public /* synthetic */ q(int i6, kotlin.jvm.internal.v vVar) {
            this(i6);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof q) && this.f45135a == ((q) obj).f45135a;
        }

        private q(int i6) {
            super(null);
            this.f45135a = i6;
        }

        public int b() {
            return this.f45135a;
        }

        public int hashCode() {
            return z0.x(this.f45135a);
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.e.l
        public /* bridge */ /* synthetic */ z0 a() {
            return z0.b(b());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class r extends l<d1> {

        /* renamed from: a, reason: collision with root package name */
        private final long f45136a;

        public /* synthetic */ r(long j6, kotlin.jvm.internal.v vVar) {
            this(j6);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof r) && this.f45136a == ((r) obj).f45136a;
        }

        private r(long j6) {
            super(null);
            this.f45136a = j6;
        }

        public long b() {
            return this.f45136a;
        }

        public int hashCode() {
            return d1.x(this.f45136a);
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.e.l
        public /* bridge */ /* synthetic */ d1 a() {
            return d1.b(b());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class s extends l<j1> {

        /* renamed from: a, reason: collision with root package name */
        private final short f45137a;

        public /* synthetic */ s(short s5, kotlin.jvm.internal.v vVar) {
            this(s5);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof s) && this.f45137a == ((s) obj).f45137a;
        }

        private s(short s5) {
            super(null);
            this.f45137a = s5;
        }

        public short b() {
            return this.f45137a;
        }

        public int hashCode() {
            return j1.x(this.f45137a);
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.e.l
        public /* bridge */ /* synthetic */ j1 a() {
            return j1.b(b());
        }
    }

    public /* synthetic */ e(kotlin.jvm.internal.v vVar) {
        this();
    }

    @NotNull
    public abstract String toString();

    private e() {
    }
}
