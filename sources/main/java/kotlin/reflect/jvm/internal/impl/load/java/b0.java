package kotlin.reflect.jvm.internal.impl.load.java;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b0 {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f45367d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final b0 f45368e = new b0(ReportLevel.STRICT, null, null, 6, null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final ReportLevel f45369a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final kotlin.p f45370b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final ReportLevel f45371c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final b0 a() {
            return b0.f45368e;
        }
    }

    public b0(@NotNull ReportLevel reportLevelBefore, @Nullable kotlin.p pVar, @NotNull ReportLevel reportLevelAfter) {
        kotlin.jvm.internal.g0.p(reportLevelBefore, "reportLevelBefore");
        kotlin.jvm.internal.g0.p(reportLevelAfter, "reportLevelAfter");
        this.f45369a = reportLevelBefore;
        this.f45370b = pVar;
        this.f45371c = reportLevelAfter;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.f45369a == b0Var.f45369a && kotlin.jvm.internal.g0.g(this.f45370b, b0Var.f45370b) && this.f45371c == b0Var.f45371c;
    }

    @NotNull
    public final ReportLevel b() {
        return this.f45371c;
    }

    @NotNull
    public final ReportLevel c() {
        return this.f45369a;
    }

    @Nullable
    public final kotlin.p d() {
        return this.f45370b;
    }

    public int hashCode() {
        int hashCode = this.f45369a.hashCode() * 31;
        kotlin.p pVar = this.f45370b;
        return ((hashCode + (pVar == null ? 0 : pVar.hashCode())) * 31) + this.f45371c.hashCode();
    }

    @NotNull
    public String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.f45369a + ", sinceVersion=" + this.f45370b + ", reportLevelAfter=" + this.f45371c + ')';
    }

    public /* synthetic */ b0(ReportLevel reportLevel, kotlin.p pVar, ReportLevel reportLevel2, int i6, kotlin.jvm.internal.v vVar) {
        this(reportLevel, (i6 & 2) != 0 ? new kotlin.p(1, 0) : pVar, (i6 & 4) != 0 ? reportLevel : reportLevel2);
    }
}
