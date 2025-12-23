package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.i1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCharDirectionality.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CharDirectionality.kt\nkotlin/text/CharDirectionality\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,124:1\n1208#2,2:125\n1236#2,4:127\n*S KotlinDebug\n*F\n+ 1 CharDirectionality.kt\nkotlin/text/CharDirectionality\n*L\n118#1:125,2\n118#1:127,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CharDirectionality {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ CharDirectionality[] $VALUES;

    @NotNull
    public static final a Companion;

    @NotNull
    private static final kotlin.s<Map<Integer, CharDirectionality>> directionalityMap$delegate;
    private final int value;
    public static final CharDirectionality UNDEFINED = new CharDirectionality("UNDEFINED", 0, -1);
    public static final CharDirectionality LEFT_TO_RIGHT = new CharDirectionality("LEFT_TO_RIGHT", 1, 0);
    public static final CharDirectionality RIGHT_TO_LEFT = new CharDirectionality("RIGHT_TO_LEFT", 2, 1);
    public static final CharDirectionality RIGHT_TO_LEFT_ARABIC = new CharDirectionality("RIGHT_TO_LEFT_ARABIC", 3, 2);
    public static final CharDirectionality EUROPEAN_NUMBER = new CharDirectionality("EUROPEAN_NUMBER", 4, 3);
    public static final CharDirectionality EUROPEAN_NUMBER_SEPARATOR = new CharDirectionality("EUROPEAN_NUMBER_SEPARATOR", 5, 4);
    public static final CharDirectionality EUROPEAN_NUMBER_TERMINATOR = new CharDirectionality("EUROPEAN_NUMBER_TERMINATOR", 6, 5);
    public static final CharDirectionality ARABIC_NUMBER = new CharDirectionality("ARABIC_NUMBER", 7, 6);
    public static final CharDirectionality COMMON_NUMBER_SEPARATOR = new CharDirectionality("COMMON_NUMBER_SEPARATOR", 8, 7);
    public static final CharDirectionality NONSPACING_MARK = new CharDirectionality("NONSPACING_MARK", 9, 8);
    public static final CharDirectionality BOUNDARY_NEUTRAL = new CharDirectionality("BOUNDARY_NEUTRAL", 10, 9);
    public static final CharDirectionality PARAGRAPH_SEPARATOR = new CharDirectionality("PARAGRAPH_SEPARATOR", 11, 10);
    public static final CharDirectionality SEGMENT_SEPARATOR = new CharDirectionality("SEGMENT_SEPARATOR", 12, 11);
    public static final CharDirectionality WHITESPACE = new CharDirectionality("WHITESPACE", 13, 12);
    public static final CharDirectionality OTHER_NEUTRALS = new CharDirectionality("OTHER_NEUTRALS", 14, 13);
    public static final CharDirectionality LEFT_TO_RIGHT_EMBEDDING = new CharDirectionality("LEFT_TO_RIGHT_EMBEDDING", 15, 14);
    public static final CharDirectionality LEFT_TO_RIGHT_OVERRIDE = new CharDirectionality("LEFT_TO_RIGHT_OVERRIDE", 16, 15);
    public static final CharDirectionality RIGHT_TO_LEFT_EMBEDDING = new CharDirectionality("RIGHT_TO_LEFT_EMBEDDING", 17, 16);
    public static final CharDirectionality RIGHT_TO_LEFT_OVERRIDE = new CharDirectionality("RIGHT_TO_LEFT_OVERRIDE", 18, 17);
    public static final CharDirectionality POP_DIRECTIONAL_FORMAT = new CharDirectionality("POP_DIRECTIONAL_FORMAT", 19, 18);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        private final Map<Integer, CharDirectionality> a() {
            return (Map) CharDirectionality.directionalityMap$delegate.getValue();
        }

        @NotNull
        public final CharDirectionality b(int i6) {
            CharDirectionality charDirectionality = a().get(Integer.valueOf(i6));
            if (charDirectionality != null) {
                return charDirectionality;
            }
            throw new IllegalArgumentException("Directionality #" + i6 + " is not defined.");
        }
    }

    private static final /* synthetic */ CharDirectionality[] $values() {
        return new CharDirectionality[]{UNDEFINED, LEFT_TO_RIGHT, RIGHT_TO_LEFT, RIGHT_TO_LEFT_ARABIC, EUROPEAN_NUMBER, EUROPEAN_NUMBER_SEPARATOR, EUROPEAN_NUMBER_TERMINATOR, ARABIC_NUMBER, COMMON_NUMBER_SEPARATOR, NONSPACING_MARK, BOUNDARY_NEUTRAL, PARAGRAPH_SEPARATOR, SEGMENT_SEPARATOR, WHITESPACE, OTHER_NEUTRALS, LEFT_TO_RIGHT_EMBEDDING, LEFT_TO_RIGHT_OVERRIDE, RIGHT_TO_LEFT_EMBEDDING, RIGHT_TO_LEFT_OVERRIDE, POP_DIRECTIONAL_FORMAT};
    }

    static {
        CharDirectionality[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
        Companion = new a(null);
        directionalityMap$delegate = kotlin.t.c(new Function0() { // from class: kotlin.text.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Map directionalityMap_delegate$lambda$0;
                directionalityMap_delegate$lambda$0 = CharDirectionality.directionalityMap_delegate$lambda$0();
                return directionalityMap_delegate$lambda$0;
            }
        });
    }

    @NotNull
    public static kotlin.enums.a<CharDirectionality> getEntries() {
        return $ENTRIES;
    }

    public static CharDirectionality valueOf(String str) {
        return (CharDirectionality) Enum.valueOf(CharDirectionality.class, str);
    }

    public static CharDirectionality[] values() {
        return (CharDirectionality[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private CharDirectionality(String str, int i6, int i7) {
        this.value = i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map directionalityMap_delegate$lambda$0() {
        kotlin.enums.a<CharDirectionality> entries = getEntries();
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(i1.j(kotlin.collections.f0.d0(entries, 10)), 16));
        for (Object obj : entries) {
            linkedHashMap.put(Integer.valueOf(((CharDirectionality) obj).value), obj);
        }
        return linkedHashMap;
    }
}
