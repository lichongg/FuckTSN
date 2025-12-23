package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nConstantValueFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConstantValueFactory.kt\norg/jetbrains/kotlin/resolve/constants/ConstantValueFactory\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,103:1\n1617#2,9:104\n1869#2:113\n1870#2:115\n1626#2:116\n1#3:114\n*S KotlinDebug\n*F\n+ 1 ConstantValueFactory.kt\norg/jetbrains/kotlin/resolve/constants/ConstantValueFactory\n*L\n64#1:104,9\n64#1:113\n64#1:115\n64#1:116\n64#1:114\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f46667a = new i();

    private final b b(List<?> list, kotlin.reflect.jvm.internal.impl.descriptors.f0 f0Var, PrimitiveType primitiveType) {
        List a6 = kotlin.collections.f0.a6(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = a6.iterator();
        while (it.hasNext()) {
            g f6 = f(this, it.next(), null, 2, null);
            if (f6 != null) {
                arrayList.add(f6);
            }
        }
        if (f0Var == null) {
            return new b(arrayList, new h(primitiveType));
        }
        e1 P = f0Var.p().P(primitiveType);
        g0.o(P, "getPrimitiveArrayKotlinType(...)");
        return new a0(arrayList, P);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t0 d(PrimitiveType primitiveType, kotlin.reflect.jvm.internal.impl.descriptors.f0 it) {
        g0.p(it, "it");
        e1 P = it.p().P(primitiveType);
        g0.o(P, "getPrimitiveArrayKotlinType(...)");
        return P;
    }

    public static /* synthetic */ g f(i iVar, Object obj, kotlin.reflect.jvm.internal.impl.descriptors.f0 f0Var, int i6, Object obj2) {
        if ((i6 & 2) != 0) {
            f0Var = null;
        }
        return iVar.e(obj, f0Var);
    }

    @NotNull
    public final b c(@NotNull List<? extends g<?>> value, @NotNull t0 type) {
        g0.p(value, "value");
        g0.p(type, "type");
        return new a0(value, type);
    }

    @Nullable
    public final g<?> e(@Nullable Object obj, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.f0 f0Var) {
        if (obj instanceof Byte) {
            return new d(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new x(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new n(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new u(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new e(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new m(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new j(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new c(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new y((String) obj);
        }
        if (obj instanceof byte[]) {
            return b(kotlin.collections.n.Xy((byte[]) obj), f0Var, PrimitiveType.BYTE);
        }
        if (obj instanceof short[]) {
            return b(kotlin.collections.n.ez((short[]) obj), f0Var, PrimitiveType.SHORT);
        }
        if (obj instanceof int[]) {
            return b(kotlin.collections.n.bz((int[]) obj), f0Var, PrimitiveType.INT);
        }
        if (obj instanceof long[]) {
            return b(kotlin.collections.n.cz((long[]) obj), f0Var, PrimitiveType.LONG);
        }
        if (obj instanceof char[]) {
            return b(kotlin.collections.n.Yy((char[]) obj), f0Var, PrimitiveType.CHAR);
        }
        if (obj instanceof float[]) {
            return b(kotlin.collections.n.az((float[]) obj), f0Var, PrimitiveType.FLOAT);
        }
        if (obj instanceof double[]) {
            return b(kotlin.collections.n.Zy((double[]) obj), f0Var, PrimitiveType.DOUBLE);
        }
        if (obj instanceof boolean[]) {
            return b(kotlin.collections.n.fz((boolean[]) obj), f0Var, PrimitiveType.BOOLEAN);
        }
        if (obj == null) {
            return new v();
        }
        return null;
    }

    private i() {
    }
}
