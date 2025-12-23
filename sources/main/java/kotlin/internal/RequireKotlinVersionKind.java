package kotlin.internal;

import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.2")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class RequireKotlinVersionKind {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ RequireKotlinVersionKind[] $VALUES;
    public static final RequireKotlinVersionKind LANGUAGE_VERSION = new RequireKotlinVersionKind("LANGUAGE_VERSION", 0);
    public static final RequireKotlinVersionKind COMPILER_VERSION = new RequireKotlinVersionKind("COMPILER_VERSION", 1);
    public static final RequireKotlinVersionKind API_VERSION = new RequireKotlinVersionKind("API_VERSION", 2);

    private static final /* synthetic */ RequireKotlinVersionKind[] $values() {
        return new RequireKotlinVersionKind[]{LANGUAGE_VERSION, COMPILER_VERSION, API_VERSION};
    }

    static {
        RequireKotlinVersionKind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    @NotNull
    public static kotlin.enums.a<RequireKotlinVersionKind> getEntries() {
        return $ENTRIES;
    }

    public static RequireKotlinVersionKind valueOf(String str) {
        return (RequireKotlinVersionKind) Enum.valueOf(RequireKotlinVersionKind.class, str);
    }

    public static RequireKotlinVersionKind[] values() {
        return (RequireKotlinVersionKind[]) $VALUES.clone();
    }

    private RequireKotlinVersionKind(String str, int i6) {
    }
}
