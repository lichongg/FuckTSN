package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.exifinterface.media.ExifInterface;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.s;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nmethodSignatureMapping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 methodSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/JvmTypeFactoryImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,200:1\n1#2:201\n1310#3,2:202\n*S KotlinDebug\n*F\n+ 1 methodSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/JvmTypeFactoryImpl\n*L\n144#1:202,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class u implements t<s> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final u f46003a = new u();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f46004a;

        static {
            int[] iArr = new int[PrimitiveType.values().length];
            try {
                iArr[PrimitiveType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrimitiveType.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PrimitiveType.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PrimitiveType.SHORT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PrimitiveType.INT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PrimitiveType.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PrimitiveType.LONG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PrimitiveType.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f46004a = iArr;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.t
    @NotNull
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public s c(@NotNull s possiblyPrimitiveType) {
        kotlin.jvm.internal.g0.p(possiblyPrimitiveType, "possiblyPrimitiveType");
        if (!(possiblyPrimitiveType instanceof s.d)) {
            return possiblyPrimitiveType;
        }
        s.d dVar = (s.d) possiblyPrimitiveType;
        if (dVar.i() == null) {
            return possiblyPrimitiveType;
        }
        String f6 = kotlin.reflect.jvm.internal.impl.resolve.jvm.d.c(dVar.i().getWrapperFqName()).f();
        kotlin.jvm.internal.g0.o(f6, "getInternalName(...)");
        return f(f6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.t
    @NotNull
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public s a(@NotNull String representation) {
        JvmPrimitiveType jvmPrimitiveType;
        kotlin.jvm.internal.g0.p(representation, "representation");
        representation.length();
        char charAt = representation.charAt(0);
        JvmPrimitiveType[] values = JvmPrimitiveType.values();
        int length = values.length;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                jvmPrimitiveType = null;
                break;
            }
            jvmPrimitiveType = values[i6];
            if (jvmPrimitiveType.getDesc().charAt(0) == charAt) {
                break;
            }
            i6++;
        }
        if (jvmPrimitiveType != null) {
            return new s.d(jvmPrimitiveType);
        }
        if (charAt == 'V') {
            return new s.d(null);
        }
        if (charAt == '[') {
            String substring = representation.substring(1);
            kotlin.jvm.internal.g0.o(substring, "substring(...)");
            return new s.a(a(substring));
        }
        if (charAt == 'L') {
            kotlin.text.u.q3(representation, ';', false, 2, null);
        }
        String substring2 = representation.substring(1, representation.length() - 1);
        kotlin.jvm.internal.g0.o(substring2, "substring(...)");
        return new s.c(substring2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.t
    @NotNull
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public s.c f(@NotNull String internalName) {
        kotlin.jvm.internal.g0.p(internalName, "internalName");
        return new s.c(internalName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.t
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public s d(@NotNull PrimitiveType primitiveType) {
        kotlin.jvm.internal.g0.p(primitiveType, "primitiveType");
        switch (a.f46004a[primitiveType.ordinal()]) {
            case 1:
                return s.f45991a.a();
            case 2:
                return s.f45991a.c();
            case 3:
                return s.f45991a.b();
            case 4:
                return s.f45991a.h();
            case 5:
                return s.f45991a.f();
            case 6:
                return s.f45991a.e();
            case 7:
                return s.f45991a.g();
            case 8:
                return s.f45991a.d();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.t
    @NotNull
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public s b() {
        return f("java/lang/Class");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.t
    @NotNull
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public String e(@NotNull s type) {
        String desc;
        kotlin.jvm.internal.g0.p(type, "type");
        if (type instanceof s.a) {
            return '[' + e(((s.a) type).i());
        }
        if (type instanceof s.d) {
            JvmPrimitiveType i6 = ((s.d) type).i();
            return (i6 == null || (desc = i6.getDesc()) == null) ? ExifInterface.GPS_MEASUREMENT_INTERRUPTED : desc;
        }
        if (!(type instanceof s.c)) {
            throw new NoWhenBranchMatchedException();
        }
        return 'L' + ((s.c) type).i() + ';';
    }

    private u() {
    }
}
