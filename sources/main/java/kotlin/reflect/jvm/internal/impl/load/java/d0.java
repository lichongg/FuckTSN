package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d0 {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f45413d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final g0 f45414a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Function1<kotlin.reflect.jvm.internal.impl.name.c, ReportLevel> f45415b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f45416c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ReportLevel c(kotlin.p pVar, kotlin.reflect.jvm.internal.impl.name.c it) {
            kotlin.jvm.internal.g0.p(it, "it");
            return a0.c(it, pVar);
        }

        @NotNull
        public final d0 b(@NotNull kotlin.p kotlinVersion) {
            kotlin.jvm.internal.g0.p(kotlinVersion, "kotlinVersion");
            return new d0(a0.a(kotlinVersion), new c0(kotlinVersion));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d0(@NotNull g0 jsr305, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.c, ? extends ReportLevel> getReportLevelForAnnotation) {
        kotlin.jvm.internal.g0.p(jsr305, "jsr305");
        kotlin.jvm.internal.g0.p(getReportLevelForAnnotation, "getReportLevelForAnnotation");
        this.f45414a = jsr305;
        this.f45415b = getReportLevelForAnnotation;
        this.f45416c = jsr305.f() || getReportLevelForAnnotation.invoke(a0.d()) == ReportLevel.IGNORE;
    }

    public final boolean a() {
        return this.f45416c;
    }

    @NotNull
    public final Function1<kotlin.reflect.jvm.internal.impl.name.c, ReportLevel> b() {
        return this.f45415b;
    }

    @NotNull
    public final g0 c() {
        return this.f45414a;
    }

    @NotNull
    public String toString() {
        return "JavaTypeEnhancementState(jsr305=" + this.f45414a + ", getReportLevelForAnnotation=" + this.f45415b + ')';
    }
}
