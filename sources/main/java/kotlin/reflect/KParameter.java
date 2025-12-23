package kotlin.reflect;

import kotlin.ExperimentalContextParameters;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.adscope.common.network.cookie.db.Field;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface KParameter extends b {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Kind {
        private static final /* synthetic */ kotlin.enums.a $ENTRIES;
        private static final /* synthetic */ Kind[] $VALUES;
        public static final Kind INSTANCE = new Kind("INSTANCE", 0);

        @ExperimentalContextParameters
        public static final Kind CONTEXT = new Kind("CONTEXT", 1);
        public static final Kind EXTENSION_RECEIVER = new Kind("EXTENSION_RECEIVER", 2);
        public static final Kind VALUE = new Kind(Field.VALUE, 3);

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{INSTANCE, CONTEXT, EXTENSION_RECEIVER, VALUE};
        }

        static {
            Kind[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.c.c($values);
        }

        @NotNull
        public static kotlin.enums.a<Kind> getEntries() {
            return $ENTRIES;
        }

        public static Kind valueOf(String str) {
            return (Kind) Enum.valueOf(Kind.class, str);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }

        private Kind(String str, int i6) {
        }
    }

    boolean a();

    int getIndex();

    @Nullable
    String getName();

    @NotNull
    r getType();

    @NotNull
    Kind h();

    boolean p();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void a() {
        }
    }
}
