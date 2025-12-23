package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.name.b;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class UnsignedType {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ UnsignedType[] $VALUES;
    public static final UnsignedType UBYTE;
    public static final UnsignedType UINT;
    public static final UnsignedType ULONG;
    public static final UnsignedType USHORT;

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.b arrayClassId;

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.b classId;

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.f typeName;

    private static final /* synthetic */ UnsignedType[] $values() {
        return new UnsignedType[]{UBYTE, USHORT, UINT, ULONG};
    }

    static {
        b.a aVar = kotlin.reflect.jvm.internal.impl.name.b.f46334d;
        UBYTE = new UnsignedType("UBYTE", 0, b.a.b(aVar, "kotlin/UByte", false, 2, null));
        USHORT = new UnsignedType("USHORT", 1, b.a.b(aVar, "kotlin/UShort", false, 2, null));
        UINT = new UnsignedType("UINT", 2, b.a.b(aVar, "kotlin/UInt", false, 2, null));
        ULONG = new UnsignedType("ULONG", 3, b.a.b(aVar, "kotlin/ULong", false, 2, null));
        UnsignedType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
    }

    public static UnsignedType valueOf(String str) {
        return (UnsignedType) Enum.valueOf(UnsignedType.class, str);
    }

    public static UnsignedType[] values() {
        return (UnsignedType[]) $VALUES.clone();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.b getArrayClassId() {
        return this.arrayClassId;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.b getClassId() {
        return this.classId;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.f getTypeName() {
        return this.typeName;
    }

    private UnsignedType(String str, int i6, kotlin.reflect.jvm.internal.impl.name.b bVar) {
        this.classId = bVar;
        kotlin.reflect.jvm.internal.impl.name.f h6 = bVar.h();
        this.typeName = h6;
        kotlin.reflect.jvm.internal.impl.name.c f6 = bVar.f();
        kotlin.reflect.jvm.internal.impl.name.f h7 = kotlin.reflect.jvm.internal.impl.name.f.h(h6.b() + "Array");
        g0.o(h7, "identifier(...)");
        this.arrayClassId = new kotlin.reflect.jvm.internal.impl.name.b(f6, h7);
    }
}
