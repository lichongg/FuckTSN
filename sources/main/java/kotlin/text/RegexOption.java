package kotlin.text;

import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class RegexOption implements h {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ RegexOption[] $VALUES;
    private final int mask;
    private final int value;
    public static final RegexOption IGNORE_CASE = new RegexOption("IGNORE_CASE", 0, 2, 0, 2, null);
    public static final RegexOption MULTILINE = new RegexOption("MULTILINE", 1, 8, 0, 2, null);
    public static final RegexOption LITERAL = new RegexOption("LITERAL", 2, 16, 0, 2, null);
    public static final RegexOption UNIX_LINES = new RegexOption("UNIX_LINES", 3, 1, 0, 2, null);
    public static final RegexOption COMMENTS = new RegexOption("COMMENTS", 4, 4, 0, 2, null);
    public static final RegexOption DOT_MATCHES_ALL = new RegexOption("DOT_MATCHES_ALL", 5, 32, 0, 2, null);
    public static final RegexOption CANON_EQ = new RegexOption("CANON_EQ", 6, 128, 0, 2, null);

    private static final /* synthetic */ RegexOption[] $values() {
        return new RegexOption[]{IGNORE_CASE, MULTILINE, LITERAL, UNIX_LINES, COMMENTS, DOT_MATCHES_ALL, CANON_EQ};
    }

    private RegexOption(String str, int i6, int i7, int i8) {
        this.value = i7;
        this.mask = i8;
    }

    static {
        RegexOption[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    /* synthetic */ RegexOption(String str, int i6, int i7, int i8, int i9, kotlin.jvm.internal.v vVar) {
        this(str, i6, i7, (i9 & 2) != 0 ? i7 : i8);
    }

    @NotNull
    public static kotlin.enums.a<RegexOption> getEntries() {
        return $ENTRIES;
    }

    public static RegexOption valueOf(String str) {
        return (RegexOption) Enum.valueOf(RegexOption.class, str);
    }

    public static RegexOption[] values() {
        return (RegexOption[]) $VALUES.clone();
    }

    @Override // kotlin.text.h
    public int getMask() {
        return this.mask;
    }

    @Override // kotlin.text.h
    public int getValue() {
        return this.value;
    }
}
