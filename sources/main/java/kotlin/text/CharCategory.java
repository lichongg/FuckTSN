package kotlin.text;

import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CharCategory {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ CharCategory[] $VALUES;

    @NotNull
    public static final a Companion;

    @NotNull
    private final String code;
    private final int value;
    public static final CharCategory UNASSIGNED = new CharCategory("UNASSIGNED", 0, 0, "Cn");
    public static final CharCategory UPPERCASE_LETTER = new CharCategory("UPPERCASE_LETTER", 1, 1, "Lu");
    public static final CharCategory LOWERCASE_LETTER = new CharCategory("LOWERCASE_LETTER", 2, 2, "Ll");
    public static final CharCategory TITLECASE_LETTER = new CharCategory("TITLECASE_LETTER", 3, 3, "Lt");
    public static final CharCategory MODIFIER_LETTER = new CharCategory("MODIFIER_LETTER", 4, 4, "Lm");
    public static final CharCategory OTHER_LETTER = new CharCategory("OTHER_LETTER", 5, 5, "Lo");
    public static final CharCategory NON_SPACING_MARK = new CharCategory("NON_SPACING_MARK", 6, 6, "Mn");
    public static final CharCategory ENCLOSING_MARK = new CharCategory("ENCLOSING_MARK", 7, 7, "Me");
    public static final CharCategory COMBINING_SPACING_MARK = new CharCategory("COMBINING_SPACING_MARK", 8, 8, "Mc");
    public static final CharCategory DECIMAL_DIGIT_NUMBER = new CharCategory("DECIMAL_DIGIT_NUMBER", 9, 9, "Nd");
    public static final CharCategory LETTER_NUMBER = new CharCategory("LETTER_NUMBER", 10, 10, "Nl");
    public static final CharCategory OTHER_NUMBER = new CharCategory("OTHER_NUMBER", 11, 11, "No");
    public static final CharCategory SPACE_SEPARATOR = new CharCategory("SPACE_SEPARATOR", 12, 12, "Zs");
    public static final CharCategory LINE_SEPARATOR = new CharCategory("LINE_SEPARATOR", 13, 13, "Zl");
    public static final CharCategory PARAGRAPH_SEPARATOR = new CharCategory("PARAGRAPH_SEPARATOR", 14, 14, "Zp");
    public static final CharCategory CONTROL = new CharCategory("CONTROL", 15, 15, "Cc");
    public static final CharCategory FORMAT = new CharCategory("FORMAT", 16, 16, "Cf");
    public static final CharCategory PRIVATE_USE = new CharCategory("PRIVATE_USE", 17, 18, "Co");
    public static final CharCategory SURROGATE = new CharCategory("SURROGATE", 18, 19, "Cs");
    public static final CharCategory DASH_PUNCTUATION = new CharCategory("DASH_PUNCTUATION", 19, 20, "Pd");
    public static final CharCategory START_PUNCTUATION = new CharCategory("START_PUNCTUATION", 20, 21, "Ps");
    public static final CharCategory END_PUNCTUATION = new CharCategory("END_PUNCTUATION", 21, 22, "Pe");
    public static final CharCategory CONNECTOR_PUNCTUATION = new CharCategory("CONNECTOR_PUNCTUATION", 22, 23, "Pc");
    public static final CharCategory OTHER_PUNCTUATION = new CharCategory("OTHER_PUNCTUATION", 23, 24, "Po");
    public static final CharCategory MATH_SYMBOL = new CharCategory("MATH_SYMBOL", 24, 25, "Sm");
    public static final CharCategory CURRENCY_SYMBOL = new CharCategory("CURRENCY_SYMBOL", 25, 26, "Sc");
    public static final CharCategory MODIFIER_SYMBOL = new CharCategory("MODIFIER_SYMBOL", 26, 27, "Sk");
    public static final CharCategory OTHER_SYMBOL = new CharCategory("OTHER_SYMBOL", 27, 28, "So");
    public static final CharCategory INITIAL_QUOTE_PUNCTUATION = new CharCategory("INITIAL_QUOTE_PUNCTUATION", 28, 29, "Pi");
    public static final CharCategory FINAL_QUOTE_PUNCTUATION = new CharCategory("FINAL_QUOTE_PUNCTUATION", 29, 30, "Pf");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final CharCategory a(int i6) {
            if (i6 >= 0 && i6 < 17) {
                return (CharCategory) CharCategory.getEntries().get(i6);
            }
            if (18 <= i6 && i6 < 31) {
                return (CharCategory) CharCategory.getEntries().get(i6 - 1);
            }
            throw new IllegalArgumentException("Category #" + i6 + " is not defined.");
        }
    }

    private static final /* synthetic */ CharCategory[] $values() {
        return new CharCategory[]{UNASSIGNED, UPPERCASE_LETTER, LOWERCASE_LETTER, TITLECASE_LETTER, MODIFIER_LETTER, OTHER_LETTER, NON_SPACING_MARK, ENCLOSING_MARK, COMBINING_SPACING_MARK, DECIMAL_DIGIT_NUMBER, LETTER_NUMBER, OTHER_NUMBER, SPACE_SEPARATOR, LINE_SEPARATOR, PARAGRAPH_SEPARATOR, CONTROL, FORMAT, PRIVATE_USE, SURROGATE, DASH_PUNCTUATION, START_PUNCTUATION, END_PUNCTUATION, CONNECTOR_PUNCTUATION, OTHER_PUNCTUATION, MATH_SYMBOL, CURRENCY_SYMBOL, MODIFIER_SYMBOL, OTHER_SYMBOL, INITIAL_QUOTE_PUNCTUATION, FINAL_QUOTE_PUNCTUATION};
    }

    static {
        CharCategory[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
        Companion = new a(null);
    }

    @NotNull
    public static kotlin.enums.a<CharCategory> getEntries() {
        return $ENTRIES;
    }

    public static CharCategory valueOf(String str) {
        return (CharCategory) Enum.valueOf(CharCategory.class, str);
    }

    public static CharCategory[] values() {
        return (CharCategory[]) $VALUES.clone();
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    public final int getValue() {
        return this.value;
    }

    private CharCategory(String str, int i6, int i7, String str2) {
        this.value = i7;
        this.code = str2;
    }

    public final boolean contains(char c6) {
        if (Character.getType(c6) == this.value) {
            return true;
        }
        return false;
    }
}
