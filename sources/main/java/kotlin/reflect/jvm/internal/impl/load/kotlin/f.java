package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.load.kotlin.a0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f {
    @Nullable
    public static final a0 a(@NotNull ProtoBuf.Property proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h typeTable, boolean z5, boolean z6, boolean z7) {
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
        kotlin.jvm.internal.g0.p(typeTable, "typeTable");
        GeneratedMessageLite.f<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.f46262d;
        kotlin.jvm.internal.g0.o(propertySignature, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.a(proto, propertySignature);
        if (jvmPropertySignature == null) {
            return null;
        }
        if (z5) {
            d.a c6 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h.f46317a.c(proto, nameResolver, typeTable, z7);
            if (c6 == null) {
                return null;
            }
            return a0.f45861b.b(c6);
        }
        if (!z6 || !jvmPropertySignature.hasSyntheticMethod()) {
            return null;
        }
        a0.a aVar = a0.f45861b;
        JvmProtoBuf.JvmMethodSignature syntheticMethod = jvmPropertySignature.getSyntheticMethod();
        kotlin.jvm.internal.g0.o(syntheticMethod, "getSyntheticMethod(...)");
        return aVar.c(nameResolver, syntheticMethod);
    }

    public static /* synthetic */ a0 b(ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.metadata.deserialization.d dVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.h hVar, boolean z5, boolean z6, boolean z7, int i6, Object obj) {
        if ((i6 & 8) != 0) {
            z5 = false;
        }
        if ((i6 & 16) != 0) {
            z6 = false;
        }
        if ((i6 & 32) != 0) {
            z7 = true;
        }
        return a(property, dVar, hVar, z5, z6, z7);
    }
}
