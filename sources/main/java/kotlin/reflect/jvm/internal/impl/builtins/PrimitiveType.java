package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Set;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.u1;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class PrimitiveType {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ PrimitiveType[] $VALUES;
    public static final PrimitiveType BOOLEAN = new PrimitiveType("BOOLEAN", 0, "Boolean");
    public static final PrimitiveType BYTE;
    public static final PrimitiveType CHAR;

    @NotNull
    public static final a Companion;
    public static final PrimitiveType DOUBLE;
    public static final PrimitiveType FLOAT;
    public static final PrimitiveType INT;
    public static final PrimitiveType LONG;

    @JvmField
    @NotNull
    public static final Set<PrimitiveType> NUMBER_TYPES;
    public static final PrimitiveType SHORT;

    @NotNull
    private final s arrayTypeFqName$delegate;

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.f arrayTypeName;

    @NotNull
    private final s typeFqName$delegate;

    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.f typeName;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    private static final /* synthetic */ PrimitiveType[] $values() {
        return new PrimitiveType[]{BOOLEAN, CHAR, BYTE, SHORT, INT, FLOAT, LONG, DOUBLE};
    }

    static {
        PrimitiveType primitiveType = new PrimitiveType("CHAR", 1, "Char");
        CHAR = primitiveType;
        PrimitiveType primitiveType2 = new PrimitiveType("BYTE", 2, "Byte");
        BYTE = primitiveType2;
        PrimitiveType primitiveType3 = new PrimitiveType("SHORT", 3, "Short");
        SHORT = primitiveType3;
        PrimitiveType primitiveType4 = new PrimitiveType("INT", 4, "Int");
        INT = primitiveType4;
        PrimitiveType primitiveType5 = new PrimitiveType("FLOAT", 5, "Float");
        FLOAT = primitiveType5;
        PrimitiveType primitiveType6 = new PrimitiveType("LONG", 6, "Long");
        LONG = primitiveType6;
        PrimitiveType primitiveType7 = new PrimitiveType("DOUBLE", 7, "Double");
        DOUBLE = primitiveType7;
        PrimitiveType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
        Companion = new a(null);
        NUMBER_TYPES = u1.u(primitiveType, primitiveType2, primitiveType3, primitiveType4, primitiveType5, primitiveType6, primitiveType7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.c arrayTypeFqName_delegate$lambda$1(PrimitiveType primitiveType) {
        return o.B.b(primitiveType.arrayTypeName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.c typeFqName_delegate$lambda$0(PrimitiveType primitiveType) {
        return o.B.b(primitiveType.typeName);
    }

    public static PrimitiveType valueOf(String str) {
        return (PrimitiveType) Enum.valueOf(PrimitiveType.class, str);
    }

    public static PrimitiveType[] values() {
        return (PrimitiveType[]) $VALUES.clone();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.c getArrayTypeFqName() {
        return (kotlin.reflect.jvm.internal.impl.name.c) this.arrayTypeFqName$delegate.getValue();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.f getArrayTypeName() {
        return this.arrayTypeName;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.c getTypeFqName() {
        return (kotlin.reflect.jvm.internal.impl.name.c) this.typeFqName$delegate.getValue();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.f getTypeName() {
        return this.typeName;
    }

    private PrimitiveType(String str, int i6, String str2) {
        kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(str2);
        g0.o(h6, "identifier(...)");
        this.typeName = h6;
        kotlin.reflect.jvm.internal.impl.name.f h7 = kotlin.reflect.jvm.internal.impl.name.f.h(str2 + "Array");
        g0.o(h7, "identifier(...)");
        this.arrayTypeName = h7;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.typeFqName$delegate = t.b(lazyThreadSafetyMode, new k(this));
        this.arrayTypeFqName$delegate = t.b(lazyThreadSafetyMode, new l(this));
    }
}
