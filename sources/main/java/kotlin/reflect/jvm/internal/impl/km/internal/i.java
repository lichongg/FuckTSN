package kotlin.reflect.jvm.internal.impl.km.internal;

import java.util.Iterator;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.km.e;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import okhttp3.internal.ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i {
    public static final int a(@NotNull kotlin.reflect.jvm.internal.impl.metadata.serialization.d dVar, @NotNull String name) {
        g0.p(dVar, "<this>");
        g0.p(name, "name");
        if (!kotlin.reflect.jvm.internal.impl.km.b.a(name)) {
            return dVar.b(name, false);
        }
        String substring = name.substring(1);
        g0.o(substring, "substring(...)");
        return dVar.b(substring, true);
    }

    @NotNull
    public static final ProtoBuf.Annotation.b b(@NotNull kotlin.reflect.jvm.internal.impl.km.d dVar, @NotNull kotlin.reflect.jvm.internal.impl.metadata.serialization.d strings) {
        g0.p(dVar, "<this>");
        g0.p(strings, "strings");
        ProtoBuf.Annotation.b newBuilder = ProtoBuf.Annotation.newBuilder();
        newBuilder.B(a(strings, dVar.c()));
        for (Map.Entry<String, kotlin.reflect.jvm.internal.impl.km.e> entry : dVar.b().entrySet()) {
            String key = entry.getKey();
            kotlin.reflect.jvm.internal.impl.km.e value = entry.getValue();
            ProtoBuf.Annotation.Argument.b newBuilder2 = ProtoBuf.Annotation.Argument.newBuilder();
            newBuilder2.A(strings.a(key));
            newBuilder2.B(c(value, strings).build());
            newBuilder.n(newBuilder2);
        }
        g0.o(newBuilder, "apply(...)");
        return newBuilder;
    }

    @NotNull
    public static final ProtoBuf.Annotation.Argument.Value.b c(@NotNull kotlin.reflect.jvm.internal.impl.km.e eVar, @NotNull kotlin.reflect.jvm.internal.impl.metadata.serialization.d strings) {
        g0.p(eVar, "<this>");
        g0.p(strings, "strings");
        ProtoBuf.Annotation.Argument.Value.b newBuilder = ProtoBuf.Annotation.Argument.Value.newBuilder();
        if (eVar instanceof e.C0883e) {
            newBuilder.M(ProtoBuf.Annotation.Argument.Value.Type.BYTE);
            newBuilder.K(((e.C0883e) eVar).a().byteValue());
        } else if (eVar instanceof e.f) {
            newBuilder.M(ProtoBuf.Annotation.Argument.Value.Type.CHAR);
            newBuilder.K(((e.f) eVar).a().charValue());
        } else if (eVar instanceof e.n) {
            newBuilder.M(ProtoBuf.Annotation.Argument.Value.Type.SHORT);
            newBuilder.K(((e.n) eVar).a().shortValue());
        } else if (eVar instanceof e.j) {
            newBuilder.M(ProtoBuf.Annotation.Argument.Value.Type.INT);
            newBuilder.K(((e.j) eVar).a().intValue());
        } else if (eVar instanceof e.m) {
            newBuilder.M(ProtoBuf.Annotation.Argument.Value.Type.LONG);
            newBuilder.K(((e.m) eVar).a().longValue());
        } else if (eVar instanceof e.i) {
            newBuilder.M(ProtoBuf.Annotation.Argument.Value.Type.FLOAT);
            newBuilder.J(((e.i) eVar).a().floatValue());
        } else if (eVar instanceof e.g) {
            newBuilder.M(ProtoBuf.Annotation.Argument.Value.Type.DOUBLE);
            newBuilder.G(((e.g) eVar).a().doubleValue());
        } else if (eVar instanceof e.d) {
            newBuilder.M(ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN);
            newBuilder.K(((e.d) eVar).a().booleanValue() ? 1L : 0L);
        } else if (eVar instanceof e.p) {
            newBuilder.M(ProtoBuf.Annotation.Argument.Value.Type.BYTE);
            newBuilder.K(((e.p) eVar).b() & 255);
            newBuilder.I(kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.P.e(Boolean.TRUE));
        } else if (eVar instanceof e.s) {
            newBuilder.M(ProtoBuf.Annotation.Argument.Value.Type.SHORT);
            newBuilder.K(((e.s) eVar).b() & WebSocketProtocol.PAYLOAD_SHORT_MAX);
            newBuilder.I(kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.P.e(Boolean.TRUE));
        } else if (eVar instanceof e.q) {
            newBuilder.M(ProtoBuf.Annotation.Argument.Value.Type.INT);
            newBuilder.K(((e.q) eVar).b() & 4294967295L);
            newBuilder.I(kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.P.e(Boolean.TRUE));
        } else if (eVar instanceof e.r) {
            newBuilder.M(ProtoBuf.Annotation.Argument.Value.Type.LONG);
            newBuilder.K(((e.r) eVar).b());
            newBuilder.I(kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.P.e(Boolean.TRUE));
        } else if (eVar instanceof e.o) {
            newBuilder.M(ProtoBuf.Annotation.Argument.Value.Type.STRING);
            newBuilder.L(strings.a(((e.o) eVar).a()));
        } else if (eVar instanceof e.k) {
            newBuilder.M(ProtoBuf.Annotation.Argument.Value.Type.CLASS);
            newBuilder.F(a(strings, ((e.k) eVar).a()));
        } else if (eVar instanceof e.b) {
            newBuilder.M(ProtoBuf.Annotation.Argument.Value.Type.CLASS);
            e.b bVar = (e.b) eVar;
            newBuilder.F(a(strings, bVar.b()));
            newBuilder.E(bVar.a());
        } else if (eVar instanceof e.h) {
            newBuilder.M(ProtoBuf.Annotation.Argument.Value.Type.ENUM);
            e.h hVar = (e.h) eVar;
            newBuilder.F(a(strings, hVar.a()));
            newBuilder.H(strings.a(hVar.b()));
        } else if (eVar instanceof e.a) {
            newBuilder.M(ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION);
            newBuilder.D(b(((e.a) eVar).a(), strings).build());
        } else {
            if (!(eVar instanceof e.c)) {
                throw new NoWhenBranchMatchedException();
            }
            newBuilder.M(ProtoBuf.Annotation.Argument.Value.Type.ARRAY);
            Iterator<kotlin.reflect.jvm.internal.impl.km.e> it = ((e.c) eVar).a().iterator();
            while (it.hasNext()) {
                newBuilder.n(c(it.next(), strings));
            }
        }
        g0.o(newBuilder, "apply(...)");
        return newBuilder;
    }
}
