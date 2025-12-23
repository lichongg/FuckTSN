package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.collections.i1;
import kotlin.collections.u1;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f45469a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f45470b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f45471c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f45472d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f45473e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f45474f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f45475g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f45476h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f45477i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f45478j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f45479k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f45480l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f45481m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f45482n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f45483o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f45484p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private static final Set<kotlin.reflect.jvm.internal.impl.name.c> f45485q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    private static final Set<kotlin.reflect.jvm.internal.impl.name.c> f45486r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    private static final Set<kotlin.reflect.jvm.internal.impl.name.c> f45487s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    private static final Set<kotlin.reflect.jvm.internal.impl.name.c> f45488t;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    private static final Set<kotlin.reflect.jvm.internal.impl.name.c> f45489u;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    private static final Set<kotlin.reflect.jvm.internal.impl.name.c> f45490v;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    private static final Set<kotlin.reflect.jvm.internal.impl.name.c> f45491w;

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    private static final Map<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.name.c> f45492x;

    /* renamed from: y, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f45493y;

    static {
        kotlin.reflect.jvm.internal.impl.name.c cVar = new kotlin.reflect.jvm.internal.impl.name.c("org.jspecify.nullness.Nullable");
        f45469a = cVar;
        kotlin.reflect.jvm.internal.impl.name.c cVar2 = new kotlin.reflect.jvm.internal.impl.name.c("org.jspecify.nullness.NullMarked");
        f45470b = cVar2;
        kotlin.reflect.jvm.internal.impl.name.c cVar3 = new kotlin.reflect.jvm.internal.impl.name.c("org.jspecify.nullness.NullnessUnspecified");
        f45471c = cVar3;
        kotlin.reflect.jvm.internal.impl.name.c cVar4 = new kotlin.reflect.jvm.internal.impl.name.c("org.jspecify.annotations.NonNull");
        f45472d = cVar4;
        kotlin.reflect.jvm.internal.impl.name.c cVar5 = new kotlin.reflect.jvm.internal.impl.name.c("org.jspecify.annotations.Nullable");
        f45473e = cVar5;
        kotlin.reflect.jvm.internal.impl.name.c cVar6 = new kotlin.reflect.jvm.internal.impl.name.c("org.jspecify.annotations.NullMarked");
        f45474f = cVar6;
        kotlin.reflect.jvm.internal.impl.name.c cVar7 = new kotlin.reflect.jvm.internal.impl.name.c("org.jspecify.annotations.NullnessUnspecified");
        f45475g = cVar7;
        kotlin.reflect.jvm.internal.impl.name.c cVar8 = new kotlin.reflect.jvm.internal.impl.name.c("org.jspecify.annotations.NullUnmarked");
        f45476h = cVar8;
        f45477i = new kotlin.reflect.jvm.internal.impl.name.c("javax.annotation.meta.TypeQualifier");
        f45478j = new kotlin.reflect.jvm.internal.impl.name.c("javax.annotation.meta.TypeQualifierNickname");
        f45479k = new kotlin.reflect.jvm.internal.impl.name.c("javax.annotation.meta.TypeQualifierDefault");
        kotlin.reflect.jvm.internal.impl.name.c cVar9 = new kotlin.reflect.jvm.internal.impl.name.c("javax.annotation.Nonnull");
        f45480l = cVar9;
        kotlin.reflect.jvm.internal.impl.name.c cVar10 = new kotlin.reflect.jvm.internal.impl.name.c("javax.annotation.Nullable");
        f45481m = cVar10;
        kotlin.reflect.jvm.internal.impl.name.c cVar11 = new kotlin.reflect.jvm.internal.impl.name.c("javax.annotation.CheckForNull");
        f45482n = cVar11;
        f45483o = new kotlin.reflect.jvm.internal.impl.name.c("javax.annotation.ParametersAreNonnullByDefault");
        f45484p = new kotlin.reflect.jvm.internal.impl.name.c("javax.annotation.ParametersAreNullableByDefault");
        f45485q = u1.u(cVar9, cVar11);
        Set<kotlin.reflect.jvm.internal.impl.name.c> u5 = u1.u(i0.f45457l, cVar4, new kotlin.reflect.jvm.internal.impl.name.c("android.annotation.NonNull"), new kotlin.reflect.jvm.internal.impl.name.c("androidx.annotation.NonNull"), new kotlin.reflect.jvm.internal.impl.name.c("androidx.annotation.RecentlyNonNull"), new kotlin.reflect.jvm.internal.impl.name.c("androidx.annotation.NonNull"), new kotlin.reflect.jvm.internal.impl.name.c("com.android.annotations.NonNull"), new kotlin.reflect.jvm.internal.impl.name.c("org.checkerframework.checker.nullness.compatqual.NonNullDecl"), new kotlin.reflect.jvm.internal.impl.name.c("org.checkerframework.checker.nullness.qual.NonNull"), new kotlin.reflect.jvm.internal.impl.name.c("edu.umd.cs.findbugs.annotations.NonNull"), new kotlin.reflect.jvm.internal.impl.name.c("io.reactivex.annotations.NonNull"), new kotlin.reflect.jvm.internal.impl.name.c("io.reactivex.rxjava3.annotations.NonNull"), new kotlin.reflect.jvm.internal.impl.name.c("org.eclipse.jdt.annotation.NonNull"), new kotlin.reflect.jvm.internal.impl.name.c("lombok.NonNull"), new kotlin.reflect.jvm.internal.impl.name.c("jakarta.annotation.Nonnull"));
        f45486r = u5;
        Set<kotlin.reflect.jvm.internal.impl.name.c> u6 = u1.u(i0.f45458m, cVar, cVar5, cVar10, cVar11, new kotlin.reflect.jvm.internal.impl.name.c("android.annotation.Nullable"), new kotlin.reflect.jvm.internal.impl.name.c("androidx.annotation.Nullable"), new kotlin.reflect.jvm.internal.impl.name.c("androidx.annotation.RecentlyNullable"), new kotlin.reflect.jvm.internal.impl.name.c("androidx.annotation.Nullable"), new kotlin.reflect.jvm.internal.impl.name.c("com.android.annotations.Nullable"), new kotlin.reflect.jvm.internal.impl.name.c("org.checkerframework.checker.nullness.compatqual.NullableDecl"), new kotlin.reflect.jvm.internal.impl.name.c("org.checkerframework.checker.nullness.qual.Nullable"), new kotlin.reflect.jvm.internal.impl.name.c("edu.umd.cs.findbugs.annotations.Nullable"), new kotlin.reflect.jvm.internal.impl.name.c("edu.umd.cs.findbugs.annotations.PossiblyNull"), new kotlin.reflect.jvm.internal.impl.name.c("edu.umd.cs.findbugs.annotations.CheckForNull"), new kotlin.reflect.jvm.internal.impl.name.c("io.reactivex.annotations.Nullable"), new kotlin.reflect.jvm.internal.impl.name.c("io.reactivex.rxjava3.annotations.Nullable"), new kotlin.reflect.jvm.internal.impl.name.c("org.eclipse.jdt.annotation.Nullable"), new kotlin.reflect.jvm.internal.impl.name.c("jakarta.annotation.Nullable"));
        f45487s = u6;
        f45488t = u1.u(cVar3, cVar7);
        f45489u = u1.D(u1.D(u1.D(u1.D(u1.C(u1.C(new LinkedHashSet(), u5), u6), cVar9), cVar2), cVar6), cVar8);
        f45490v = u1.u(i0.f45460o, i0.f45461p);
        f45491w = u1.u(i0.f45459n, i0.f45462q);
        f45492x = i1.W(kotlin.o0.a(i0.f45449d, o.a.H), kotlin.o0.a(i0.f45451f, o.a.L), kotlin.o0.a(i0.f45453h, o.a.f44631y), kotlin.o0.a(i0.f45454i, o.a.P));
        f45493y = new kotlin.reflect.jvm.internal.impl.name.c("kotlin.annotations.jvm.UnderMigration");
    }

    @NotNull
    public static final Set<kotlin.reflect.jvm.internal.impl.name.c> a() {
        return f45485q;
    }

    @NotNull
    public static final Set<kotlin.reflect.jvm.internal.impl.name.c> b() {
        return f45488t;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c c() {
        return f45480l;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c d() {
        return f45483o;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c e() {
        return f45484p;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c f() {
        return f45477i;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c g() {
        return f45479k;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c h() {
        return f45478j;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c i() {
        return f45474f;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c j() {
        return f45476h;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c k() {
        return f45470b;
    }

    @NotNull
    public static final Set<kotlin.reflect.jvm.internal.impl.name.c> l() {
        return f45491w;
    }

    @NotNull
    public static final Set<kotlin.reflect.jvm.internal.impl.name.c> m() {
        return f45486r;
    }

    @NotNull
    public static final Set<kotlin.reflect.jvm.internal.impl.name.c> n() {
        return f45487s;
    }

    @NotNull
    public static final Set<kotlin.reflect.jvm.internal.impl.name.c> o() {
        return f45490v;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c p() {
        return f45493y;
    }
}
