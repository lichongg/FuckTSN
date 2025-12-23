package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.b;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ClassKind {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ ClassKind[] $VALUES;

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.km.internal.d flag;
    public static final ClassKind CLASS = new ClassKind("CLASS", 0, 0);
    public static final ClassKind INTERFACE = new ClassKind("INTERFACE", 1, 1);
    public static final ClassKind ENUM_CLASS = new ClassKind("ENUM_CLASS", 2, 2);
    public static final ClassKind ENUM_ENTRY = new ClassKind("ENUM_ENTRY", 3, 3);
    public static final ClassKind ANNOTATION_CLASS = new ClassKind("ANNOTATION_CLASS", 4, 4);
    public static final ClassKind OBJECT = new ClassKind("OBJECT", 5, 5);
    public static final ClassKind COMPANION_OBJECT = new ClassKind("COMPANION_OBJECT", 6, 6);

    private static final /* synthetic */ ClassKind[] $values() {
        return new ClassKind[]{CLASS, INTERFACE, ENUM_CLASS, ENUM_ENTRY, ANNOTATION_CLASS, OBJECT, COMPANION_OBJECT};
    }

    static {
        ClassKind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    @NotNull
    public static kotlin.enums.a<ClassKind> getEntries() {
        return $ENTRIES;
    }

    public static ClassKind valueOf(String str) {
        return (ClassKind) Enum.valueOf(ClassKind.class, str);
    }

    public static ClassKind[] values() {
        return (ClassKind[]) $VALUES.clone();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.km.internal.d getFlag$kotlin_metadata() {
        return this.flag;
    }

    private ClassKind(String str, int i6, int i7) {
        b.d<ProtoBuf.Class.Kind> CLASS_KIND = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46211f;
        g0.o(CLASS_KIND, "CLASS_KIND");
        this.flag = new kotlin.reflect.jvm.internal.impl.km.internal.d(CLASS_KIND, i7);
    }
}
