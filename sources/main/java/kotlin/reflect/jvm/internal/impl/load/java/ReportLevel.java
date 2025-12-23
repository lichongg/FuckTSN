package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ReportLevel {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ ReportLevel[] $VALUES;

    @NotNull
    public static final a Companion;

    @NotNull
    private final String description;
    public static final ReportLevel IGNORE = new ReportLevel("IGNORE", 0, "ignore");
    public static final ReportLevel WARN = new ReportLevel("WARN", 1, "warn");
    public static final ReportLevel STRICT = new ReportLevel("STRICT", 2, "strict");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nReportLevel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReportLevel.kt\norg/jetbrains/kotlin/load/java/ReportLevel$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,20:1\n1310#2,2:21\n*S KotlinDebug\n*F\n+ 1 ReportLevel.kt\norg/jetbrains/kotlin/load/java/ReportLevel$Companion\n*L\n15#1:21,2\n*E\n"})
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    private static final /* synthetic */ ReportLevel[] $values() {
        return new ReportLevel[]{IGNORE, WARN, STRICT};
    }

    static {
        ReportLevel[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
        Companion = new a(null);
    }

    public static ReportLevel valueOf(String str) {
        return (ReportLevel) Enum.valueOf(ReportLevel.class, str);
    }

    public static ReportLevel[] values() {
        return (ReportLevel[]) $VALUES.clone();
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final boolean isIgnore() {
        return this == IGNORE;
    }

    public final boolean isWarning() {
        return this == WARN;
    }

    private ReportLevel(String str, int i6, String str2) {
        this.description = str2;
    }
}
