package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.b;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Visibility {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ Visibility[] $VALUES;

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.km.internal.d flag;
    public static final Visibility INTERNAL = new Visibility("INTERNAL", 0, 0);
    public static final Visibility PRIVATE = new Visibility("PRIVATE", 1, 1);
    public static final Visibility PROTECTED = new Visibility("PROTECTED", 2, 2);
    public static final Visibility PUBLIC = new Visibility("PUBLIC", 3, 3);
    public static final Visibility PRIVATE_TO_THIS = new Visibility("PRIVATE_TO_THIS", 4, 4);
    public static final Visibility LOCAL = new Visibility("LOCAL", 5, 5);

    private static final /* synthetic */ Visibility[] $values() {
        return new Visibility[]{INTERNAL, PRIVATE, PROTECTED, PUBLIC, PRIVATE_TO_THIS, LOCAL};
    }

    static {
        Visibility[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    @NotNull
    public static kotlin.enums.a<Visibility> getEntries() {
        return $ENTRIES;
    }

    public static Visibility valueOf(String str) {
        return (Visibility) Enum.valueOf(Visibility.class, str);
    }

    public static Visibility[] values() {
        return (Visibility[]) $VALUES.clone();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.km.internal.d getFlag$kotlin_metadata() {
        return this.flag;
    }

    private Visibility(String str, int i6, int i7) {
        b.d<ProtoBuf.Visibility> VISIBILITY = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46209d;
        g0.o(VISIBILITY, "VISIBILITY");
        this.flag = new kotlin.reflect.jvm.internal.impl.km.internal.d(VISIBILITY, i7);
    }
}
