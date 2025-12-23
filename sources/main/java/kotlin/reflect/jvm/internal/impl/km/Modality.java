package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.b;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Modality {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ Modality[] $VALUES;

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.km.internal.d flag;
    public static final Modality FINAL = new Modality("FINAL", 0, 0);
    public static final Modality OPEN = new Modality("OPEN", 1, 1);
    public static final Modality ABSTRACT = new Modality("ABSTRACT", 2, 2);
    public static final Modality SEALED = new Modality("SEALED", 3, 3);

    private static final /* synthetic */ Modality[] $values() {
        return new Modality[]{FINAL, OPEN, ABSTRACT, SEALED};
    }

    static {
        Modality[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    @NotNull
    public static kotlin.enums.a<Modality> getEntries() {
        return $ENTRIES;
    }

    public static Modality valueOf(String str) {
        return (Modality) Enum.valueOf(Modality.class, str);
    }

    public static Modality[] values() {
        return (Modality[]) $VALUES.clone();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.km.internal.d getFlag$kotlin_metadata() {
        return this.flag;
    }

    private Modality(String str, int i6, int i7) {
        b.d<ProtoBuf.Modality> MODALITY = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46210e;
        g0.o(MODALITY, "MODALITY");
        this.flag = new kotlin.reflect.jvm.internal.impl.km.internal.d(MODALITY, i7);
    }
}
