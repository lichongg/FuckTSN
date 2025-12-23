package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.Pair;
import kotlin.collections.i1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.java.b0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJavaNullabilityAnnotationSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaNullabilityAnnotationSettings.kt\norg/jetbrains/kotlin/load/java/JavaNullabilityAnnotationSettingsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,124:1\n1#2:125\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f45355a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f45356b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f45357c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c f45358d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String f45359e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.c[] f45360f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final k0<b0> f45361g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final b0 f45362h;

    static {
        kotlin.reflect.jvm.internal.impl.name.c cVar = new kotlin.reflect.jvm.internal.impl.name.c("org.jspecify.nullness");
        f45355a = cVar;
        kotlin.reflect.jvm.internal.impl.name.c cVar2 = new kotlin.reflect.jvm.internal.impl.name.c("org.jspecify.annotations");
        f45356b = cVar2;
        kotlin.reflect.jvm.internal.impl.name.c cVar3 = new kotlin.reflect.jvm.internal.impl.name.c("io.reactivex.rxjava3.annotations");
        f45357c = cVar3;
        kotlin.reflect.jvm.internal.impl.name.c cVar4 = new kotlin.reflect.jvm.internal.impl.name.c("org.checkerframework.checker.nullness.compatqual");
        f45358d = cVar4;
        String a6 = cVar3.a();
        f45359e = a6;
        f45360f = new kotlin.reflect.jvm.internal.impl.name.c[]{new kotlin.reflect.jvm.internal.impl.name.c(a6 + ".Nullable"), new kotlin.reflect.jvm.internal.impl.name.c(a6 + ".NonNull")};
        kotlin.reflect.jvm.internal.impl.name.c cVar5 = new kotlin.reflect.jvm.internal.impl.name.c("org.jetbrains.annotations");
        b0.a aVar = b0.f45367d;
        Pair a7 = kotlin.o0.a(cVar5, aVar.a());
        Pair a8 = kotlin.o0.a(new kotlin.reflect.jvm.internal.impl.name.c("androidx.annotation"), aVar.a());
        Pair a9 = kotlin.o0.a(new kotlin.reflect.jvm.internal.impl.name.c("android.support.annotation"), aVar.a());
        Pair a10 = kotlin.o0.a(new kotlin.reflect.jvm.internal.impl.name.c("android.annotation"), aVar.a());
        Pair a11 = kotlin.o0.a(new kotlin.reflect.jvm.internal.impl.name.c("com.android.annotations"), aVar.a());
        Pair a12 = kotlin.o0.a(new kotlin.reflect.jvm.internal.impl.name.c("org.eclipse.jdt.annotation"), aVar.a());
        Pair a13 = kotlin.o0.a(new kotlin.reflect.jvm.internal.impl.name.c("org.checkerframework.checker.nullness.qual"), aVar.a());
        Pair a14 = kotlin.o0.a(cVar4, aVar.a());
        Pair a15 = kotlin.o0.a(new kotlin.reflect.jvm.internal.impl.name.c("javax.annotation"), aVar.a());
        Pair a16 = kotlin.o0.a(new kotlin.reflect.jvm.internal.impl.name.c("edu.umd.cs.findbugs.annotations"), aVar.a());
        Pair a17 = kotlin.o0.a(new kotlin.reflect.jvm.internal.impl.name.c("io.reactivex.annotations"), aVar.a());
        kotlin.reflect.jvm.internal.impl.name.c cVar6 = new kotlin.reflect.jvm.internal.impl.name.c("androidx.annotation.RecentlyNullable");
        ReportLevel reportLevel = ReportLevel.WARN;
        Pair a18 = kotlin.o0.a(cVar6, new b0(reportLevel, null, null, 4, null));
        Pair a19 = kotlin.o0.a(new kotlin.reflect.jvm.internal.impl.name.c("androidx.annotation.RecentlyNonNull"), new b0(reportLevel, null, null, 4, null));
        Pair a20 = kotlin.o0.a(new kotlin.reflect.jvm.internal.impl.name.c("lombok"), aVar.a());
        kotlin.p pVar = new kotlin.p(2, 1);
        ReportLevel reportLevel2 = ReportLevel.STRICT;
        f45361g = new m0(i1.W(a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, kotlin.o0.a(cVar, new b0(reportLevel, pVar, reportLevel2)), kotlin.o0.a(cVar2, new b0(reportLevel, new kotlin.p(2, 1), reportLevel2)), kotlin.o0.a(cVar3, new b0(reportLevel, new kotlin.p(1, 8), reportLevel2)), kotlin.o0.a(new kotlin.reflect.jvm.internal.impl.name.c("jakarta.annotation"), new b0(reportLevel, new kotlin.p(2, 4), reportLevel2))));
        f45362h = new b0(reportLevel, null, null, 4, null);
    }

    @NotNull
    public static final g0 a(@NotNull kotlin.p configuredKotlinVersion) {
        kotlin.jvm.internal.g0.p(configuredKotlinVersion, "configuredKotlinVersion");
        b0 b0Var = f45362h;
        ReportLevel c6 = (b0Var.d() == null || b0Var.d().compareTo(configuredKotlinVersion) > 0) ? b0Var.c() : b0Var.b();
        return new g0(c6, b(c6), null, 4, null);
    }

    @Nullable
    public static final ReportLevel b(@NotNull ReportLevel globalReportLevel) {
        kotlin.jvm.internal.g0.p(globalReportLevel, "globalReportLevel");
        if (globalReportLevel == ReportLevel.WARN) {
            return null;
        }
        return globalReportLevel;
    }

    @NotNull
    public static final ReportLevel c(@NotNull kotlin.reflect.jvm.internal.impl.name.c annotationFqName, @NotNull kotlin.p configuredKotlinVersion) {
        kotlin.jvm.internal.g0.p(annotationFqName, "annotationFqName");
        kotlin.jvm.internal.g0.p(configuredKotlinVersion, "configuredKotlinVersion");
        return f(annotationFqName, k0.f45495a.a(), configuredKotlinVersion);
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c d() {
        return f45356b;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c[] e() {
        return f45360f;
    }

    @NotNull
    public static final ReportLevel f(@NotNull kotlin.reflect.jvm.internal.impl.name.c annotation, @NotNull k0<? extends ReportLevel> configuredReportLevels, @NotNull kotlin.p configuredKotlinVersion) {
        kotlin.jvm.internal.g0.p(annotation, "annotation");
        kotlin.jvm.internal.g0.p(configuredReportLevels, "configuredReportLevels");
        kotlin.jvm.internal.g0.p(configuredKotlinVersion, "configuredKotlinVersion");
        ReportLevel a6 = configuredReportLevels.a(annotation);
        if (a6 != null) {
            return a6;
        }
        b0 a7 = f45361g.a(annotation);
        return a7 == null ? ReportLevel.IGNORE : (a7.d() == null || a7.d().compareTo(configuredKotlinVersion) > 0) ? a7.c() : a7.b();
    }
}
