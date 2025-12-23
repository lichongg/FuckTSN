package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b0 extends f0<Byte> {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public t0 getType(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 module) {
        e1 s5;
        g0.p(module, "module");
        kotlin.reflect.jvm.internal.impl.descriptors.d b6 = kotlin.reflect.jvm.internal.impl.descriptors.x.b(module, o.a.D0);
        return (b6 == null || (s5 = b6.s()) == null) ? kotlin.reflect.jvm.internal.impl.types.error.i.d(ErrorTypeKind.NOT_FOUND_UNSIGNED_TYPE, "UByte") : s5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public String toString() {
        return a().intValue() + ".toUByte()";
    }

    public b0(byte b6) {
        super(Byte.valueOf(b6));
    }
}
