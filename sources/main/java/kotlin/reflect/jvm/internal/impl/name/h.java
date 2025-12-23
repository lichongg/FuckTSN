package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.name.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSpecialNames.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpecialNames.kt\norg/jetbrains/kotlin/name/SpecialNames\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,120:1\n1#2:121\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f46355a = new h();

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final f f46356b;

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final f f46357c;

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final f f46358d;

    /* renamed from: e, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final f f46359e;

    /* renamed from: f, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final f f46360f;

    /* renamed from: g, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final c f46361g;

    /* renamed from: h, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final f f46362h;

    /* renamed from: i, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final f f46363i;

    /* renamed from: j, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final f f46364j;

    /* renamed from: k, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final f f46365k;

    /* renamed from: l, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final f f46366l;

    /* renamed from: m, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final f f46367m;

    /* renamed from: n, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final f f46368n;

    /* renamed from: o, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final f f46369o;

    /* renamed from: p, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final f f46370p;

    /* renamed from: q, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final f f46371q;

    /* renamed from: r, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final f f46372r;

    /* renamed from: s, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final f f46373s;

    static {
        f k6 = f.k("<no name provided>");
        g0.o(k6, "special(...)");
        f46356b = k6;
        f k7 = f.k("<root package>");
        g0.o(k7, "special(...)");
        f46357c = k7;
        f h6 = f.h("Companion");
        g0.o(h6, "identifier(...)");
        f46358d = h6;
        f h7 = f.h("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        g0.o(h7, "identifier(...)");
        f46359e = h7;
        f k8 = f.k("<anonymous>");
        g0.o(k8, "special(...)");
        f46360f = k8;
        c.a aVar = c.f46338c;
        f k9 = f.k("<anonymous>");
        g0.o(k9, "special(...)");
        f46361g = aVar.a(k9);
        f k10 = f.k("<unary>");
        g0.o(k10, "special(...)");
        f46362h = k10;
        f k11 = f.k("<this>");
        g0.o(k11, "special(...)");
        f46363i = k11;
        f k12 = f.k("<init>");
        g0.o(k12, "special(...)");
        f46364j = k12;
        f k13 = f.k("<when-subject>");
        g0.o(k13, "special(...)");
        f46365k = k13;
        f k14 = f.k("<iterator>");
        g0.o(k14, "special(...)");
        f46366l = k14;
        f k15 = f.k("<destruct>");
        g0.o(k15, "special(...)");
        f46367m = k15;
        f k16 = f.k("<local>");
        g0.o(k16, "special(...)");
        f46368n = k16;
        f k17 = f.k("<unused var>");
        g0.o(k17, "special(...)");
        f46369o = k17;
        f k18 = f.k("<set-?>");
        g0.o(k18, "special(...)");
        f46370p = k18;
        f k19 = f.k("<array>");
        g0.o(k19, "special(...)");
        f46371q = k19;
        f k20 = f.k("<receiver>");
        g0.o(k20, "special(...)");
        f46372r = k20;
        f k21 = f.k("<get-entries>");
        g0.o(k21, "special(...)");
        f46373s = k21;
    }

    @JvmStatic
    @NotNull
    public static final f b(@Nullable f fVar) {
        return (fVar == null || fVar.i()) ? f46359e : fVar;
    }

    public final boolean a(@NotNull f name) {
        g0.p(name, "name");
        String b6 = name.b();
        g0.o(b6, "asString(...)");
        return b6.length() > 0 && !name.i();
    }

    private h() {
    }
}
