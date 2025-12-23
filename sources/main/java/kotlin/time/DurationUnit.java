package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
/* loaded from: D:\Downloads\app\classes8.dex */
public final class DurationUnit {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ DurationUnit[] $VALUES;

    @NotNull
    private final TimeUnit timeUnit;
    public static final DurationUnit NANOSECONDS = new DurationUnit("NANOSECONDS", 0, TimeUnit.NANOSECONDS);
    public static final DurationUnit MICROSECONDS = new DurationUnit("MICROSECONDS", 1, TimeUnit.MICROSECONDS);
    public static final DurationUnit MILLISECONDS = new DurationUnit("MILLISECONDS", 2, TimeUnit.MILLISECONDS);
    public static final DurationUnit SECONDS = new DurationUnit("SECONDS", 3, TimeUnit.SECONDS);
    public static final DurationUnit MINUTES = new DurationUnit("MINUTES", 4, TimeUnit.MINUTES);
    public static final DurationUnit HOURS = new DurationUnit("HOURS", 5, TimeUnit.HOURS);
    public static final DurationUnit DAYS = new DurationUnit("DAYS", 6, TimeUnit.DAYS);

    private static final /* synthetic */ DurationUnit[] $values() {
        return new DurationUnit[]{NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS};
    }

    static {
        DurationUnit[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    @NotNull
    public static kotlin.enums.a<DurationUnit> getEntries() {
        return $ENTRIES;
    }

    public static DurationUnit valueOf(String str) {
        return (DurationUnit) Enum.valueOf(DurationUnit.class, str);
    }

    public static DurationUnit[] values() {
        return (DurationUnit[]) $VALUES.clone();
    }

    @NotNull
    public final TimeUnit getTimeUnit$kotlin_stdlib() {
        return this.timeUnit;
    }

    private DurationUnit(String str, int i6, TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }
}
