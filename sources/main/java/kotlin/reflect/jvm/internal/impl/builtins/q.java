package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.types.j2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nUnsignedType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnsignedType.kt\norg/jetbrains/kotlin/builtins/UnsignedTypes\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,122:1\n11228#2:123\n11563#2,3:124\n11228#2:127\n11563#2,3:128\n11563#2,3:131\n*S KotlinDebug\n*F\n+ 1 UnsignedType.kt\norg/jetbrains/kotlin/builtins/UnsignedTypes\n*L\n36#1:123\n36#1:124,3\n37#1:127\n37#1:128,3\n47#1:131,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final q f44636a = new q();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Set<kotlin.reflect.jvm.internal.impl.name.f> f44637b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Set<kotlin.reflect.jvm.internal.impl.name.f> f44638c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final HashMap<kotlin.reflect.jvm.internal.impl.name.b, kotlin.reflect.jvm.internal.impl.name.b> f44639d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final HashMap<kotlin.reflect.jvm.internal.impl.name.b, kotlin.reflect.jvm.internal.impl.name.b> f44640e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final HashMap<UnsignedArrayType, kotlin.reflect.jvm.internal.impl.name.f> f44641f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Set<kotlin.reflect.jvm.internal.impl.name.f> f44642g;

    static {
        UnsignedType[] values = UnsignedType.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (UnsignedType unsignedType : values) {
            arrayList.add(unsignedType.getTypeName());
        }
        f44637b = f0.f6(arrayList);
        UnsignedArrayType[] values2 = UnsignedArrayType.values();
        ArrayList arrayList2 = new ArrayList(values2.length);
        for (UnsignedArrayType unsignedArrayType : values2) {
            arrayList2.add(unsignedArrayType.getTypeName());
        }
        f44638c = f0.f6(arrayList2);
        f44639d = new HashMap<>();
        f44640e = new HashMap<>();
        f44641f = i1.M(o0.a(UnsignedArrayType.UBYTEARRAY, kotlin.reflect.jvm.internal.impl.name.f.h("ubyteArrayOf")), o0.a(UnsignedArrayType.USHORTARRAY, kotlin.reflect.jvm.internal.impl.name.f.h("ushortArrayOf")), o0.a(UnsignedArrayType.UINTARRAY, kotlin.reflect.jvm.internal.impl.name.f.h("uintArrayOf")), o0.a(UnsignedArrayType.ULONGARRAY, kotlin.reflect.jvm.internal.impl.name.f.h("ulongArrayOf")));
        UnsignedType[] values3 = UnsignedType.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (UnsignedType unsignedType2 : values3) {
            linkedHashSet.add(unsignedType2.getArrayClassId().h());
        }
        f44642g = linkedHashSet;
        for (UnsignedType unsignedType3 : UnsignedType.values()) {
            f44639d.put(unsignedType3.getArrayClassId(), unsignedType3.getClassId());
            f44640e.put(unsignedType3.getClassId(), unsignedType3.getArrayClassId());
        }
    }

    @JvmStatic
    public static final boolean d(@NotNull t0 type) {
        kotlin.reflect.jvm.internal.impl.descriptors.f c6;
        g0.p(type, "type");
        if (j2.w(type) || (c6 = type.I0().c()) == null) {
            return false;
        }
        return f44636a.c(c6);
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.name.b a(@NotNull kotlin.reflect.jvm.internal.impl.name.b arrayClassId) {
        g0.p(arrayClassId, "arrayClassId");
        return f44639d.get(arrayClassId);
    }

    public final boolean b(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        g0.p(name, "name");
        return f44642g.contains(name);
    }

    public final boolean c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k descriptor) {
        g0.p(descriptor, "descriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = descriptor.b();
        return (b6 instanceof l0) && g0.g(((l0) b6).d(), o.B) && f44637b.contains(descriptor.getName());
    }

    private q() {
    }
}
