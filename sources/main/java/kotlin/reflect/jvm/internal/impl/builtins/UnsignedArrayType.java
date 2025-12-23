package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.reflect.jvm.internal.impl.name.b;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class UnsignedArrayType {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ UnsignedArrayType[] $VALUES;
    public static final UnsignedArrayType UBYTEARRAY;
    public static final UnsignedArrayType UINTARRAY;
    public static final UnsignedArrayType ULONGARRAY;
    public static final UnsignedArrayType USHORTARRAY;

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.b classId;

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.f typeName;

    private static final /* synthetic */ UnsignedArrayType[] $values() {
        return new UnsignedArrayType[]{UBYTEARRAY, USHORTARRAY, UINTARRAY, ULONGARRAY};
    }

    static {
        b.a aVar = kotlin.reflect.jvm.internal.impl.name.b.f46334d;
        UBYTEARRAY = new UnsignedArrayType("UBYTEARRAY", 0, b.a.b(aVar, "kotlin/UByteArray", false, 2, null));
        USHORTARRAY = new UnsignedArrayType("USHORTARRAY", 1, b.a.b(aVar, "kotlin/UShortArray", false, 2, null));
        UINTARRAY = new UnsignedArrayType("UINTARRAY", 2, b.a.b(aVar, "kotlin/UIntArray", false, 2, null));
        ULONGARRAY = new UnsignedArrayType("ULONGARRAY", 3, b.a.b(aVar, "kotlin/ULongArray", false, 2, null));
        UnsignedArrayType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    public static UnsignedArrayType valueOf(String str) {
        return (UnsignedArrayType) Enum.valueOf(UnsignedArrayType.class, str);
    }

    public static UnsignedArrayType[] values() {
        return (UnsignedArrayType[]) $VALUES.clone();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.f getTypeName() {
        return this.typeName;
    }

    private UnsignedArrayType(String str, int i6, kotlin.reflect.jvm.internal.impl.name.b bVar) {
        this.classId = bVar;
        this.typeName = bVar.h();
    }
}
