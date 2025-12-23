package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import java.util.Map;
import kotlin.collections.i1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJsr305Settings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Jsr305Settings.kt\norg/jetbrains/kotlin/load/java/Jsr305Settings\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,26:1\n1#2:27\n216#3,2:28\n37#4:30\n36#4,3:31\n*S KotlinDebug\n*F\n+ 1 Jsr305Settings.kt\norg/jetbrains/kotlin/load/java/Jsr305Settings\n*L\n19#1:28,2\n20#1:30\n20#1:31,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final ReportLevel f45429a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final ReportLevel f45430b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Map<kotlin.reflect.jvm.internal.impl.name.c, ReportLevel> f45431c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.s f45432d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f45433e;

    /* JADX WARN: Multi-variable type inference failed */
    public g0(@NotNull ReportLevel globalLevel, @Nullable ReportLevel reportLevel, @NotNull Map<kotlin.reflect.jvm.internal.impl.name.c, ? extends ReportLevel> userDefinedLevelForSpecificAnnotation) {
        kotlin.jvm.internal.g0.p(globalLevel, "globalLevel");
        kotlin.jvm.internal.g0.p(userDefinedLevelForSpecificAnnotation, "userDefinedLevelForSpecificAnnotation");
        this.f45429a = globalLevel;
        this.f45430b = reportLevel;
        this.f45431c = userDefinedLevelForSpecificAnnotation;
        this.f45432d = kotlin.t.c(new f0(this));
        ReportLevel reportLevel2 = ReportLevel.IGNORE;
        this.f45433e = globalLevel == reportLevel2 && reportLevel == reportLevel2 && userDefinedLevelForSpecificAnnotation.isEmpty();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.f45429a == g0Var.f45429a && this.f45430b == g0Var.f45430b && kotlin.jvm.internal.g0.g(this.f45431c, g0Var.f45431c);
    }

    @NotNull
    public final ReportLevel c() {
        return this.f45429a;
    }

    @Nullable
    public final ReportLevel d() {
        return this.f45430b;
    }

    @NotNull
    public final Map<kotlin.reflect.jvm.internal.impl.name.c, ReportLevel> e() {
        return this.f45431c;
    }

    public final boolean f() {
        return this.f45433e;
    }

    public int hashCode() {
        int hashCode = this.f45429a.hashCode() * 31;
        ReportLevel reportLevel = this.f45430b;
        return ((hashCode + (reportLevel == null ? 0 : reportLevel.hashCode())) * 31) + this.f45431c.hashCode();
    }

    @NotNull
    public String toString() {
        return "Jsr305Settings(globalLevel=" + this.f45429a + ", migrationLevel=" + this.f45430b + ", userDefinedLevelForSpecificAnnotation=" + this.f45431c + ')';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String[] b(g0 g0Var) {
        List j6 = kotlin.collections.f0.j();
        j6.add(g0Var.f45429a.getDescription());
        ReportLevel reportLevel = g0Var.f45430b;
        if (reportLevel != null) {
            j6.add("under-migration:" + reportLevel.getDescription());
        }
        for (Map.Entry<kotlin.reflect.jvm.internal.impl.name.c, ReportLevel> entry : g0Var.f45431c.entrySet()) {
            j6.add('@' + entry.getKey() + ':' + entry.getValue().getDescription());
        }
        return (String[]) kotlin.collections.f0.b(j6).toArray(new String[0]);
    }

    public /* synthetic */ g0(ReportLevel reportLevel, ReportLevel reportLevel2, Map map, int i6, kotlin.jvm.internal.v vVar) {
        this(reportLevel, (i6 & 2) != 0 ? null : reportLevel2, (i6 & 4) != 0 ? i1.z() : map);
    }
}
