package androidx.room;

import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class FtsOptions {

    @NotNull
    public static final FtsOptions INSTANCE = new FtsOptions();

    @NotNull
    public static final String TOKENIZER_ICU = "icu";

    @NotNull
    public static final String TOKENIZER_PORTER = "porter";

    @NotNull
    public static final String TOKENIZER_SIMPLE = "simple";

    @RequiresApi(21)
    @NotNull
    public static final String TOKENIZER_UNICODE61 = "unicode61";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class MatchInfo {
        private static final /* synthetic */ kotlin.enums.a $ENTRIES;
        private static final /* synthetic */ MatchInfo[] $VALUES;
        public static final MatchInfo FTS3 = new MatchInfo("FTS3", 0);
        public static final MatchInfo FTS4 = new MatchInfo("FTS4", 1);

        private static final /* synthetic */ MatchInfo[] $values() {
            return new MatchInfo[]{FTS3, FTS4};
        }

        static {
            MatchInfo[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.c.c($values);
        }

        @NotNull
        public static kotlin.enums.a<MatchInfo> getEntries() {
            return $ENTRIES;
        }

        public static MatchInfo valueOf(String str) {
            return (MatchInfo) Enum.valueOf(MatchInfo.class, str);
        }

        public static MatchInfo[] values() {
            return (MatchInfo[]) $VALUES.clone();
        }

        private MatchInfo(String str, int i6) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Order {
        private static final /* synthetic */ kotlin.enums.a $ENTRIES;
        private static final /* synthetic */ Order[] $VALUES;
        public static final Order ASC = new Order("ASC", 0);
        public static final Order DESC = new Order("DESC", 1);

        private static final /* synthetic */ Order[] $values() {
            return new Order[]{ASC, DESC};
        }

        static {
            Order[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.c.c($values);
        }

        @NotNull
        public static kotlin.enums.a<Order> getEntries() {
            return $ENTRIES;
        }

        public static Order valueOf(String str) {
            return (Order) Enum.valueOf(Order.class, str);
        }

        public static Order[] values() {
            return (Order[]) $VALUES.clone();
        }

        private Order(String str, int i6) {
        }
    }

    private FtsOptions() {
    }
}
