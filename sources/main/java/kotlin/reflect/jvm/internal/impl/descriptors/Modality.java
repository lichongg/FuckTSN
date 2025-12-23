package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Modality {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ Modality[] $VALUES;

    @NotNull
    public static final a Companion;
    public static final Modality FINAL = new Modality("FINAL", 0);
    public static final Modality SEALED = new Modality("SEALED", 1);
    public static final Modality OPEN = new Modality("OPEN", 2);
    public static final Modality ABSTRACT = new Modality("ABSTRACT", 3);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final Modality a(boolean z5, boolean z6, boolean z7) {
            return z5 ? Modality.SEALED : z6 ? Modality.ABSTRACT : z7 ? Modality.OPEN : Modality.FINAL;
        }
    }

    private static final /* synthetic */ Modality[] $values() {
        return new Modality[]{FINAL, SEALED, OPEN, ABSTRACT};
    }

    static {
        Modality[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
        Companion = new a(null);
    }

    public static Modality valueOf(String str) {
        return (Modality) Enum.valueOf(Modality.class, str);
    }

    public static Modality[] values() {
        return (Modality[]) $VALUES.clone();
    }

    private Modality(String str, int i6) {
    }
}
