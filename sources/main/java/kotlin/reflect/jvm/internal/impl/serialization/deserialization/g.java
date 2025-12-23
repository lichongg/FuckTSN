package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface g<A> {
    @NotNull
    List<A> a(@NotNull m0 m0Var, @NotNull kotlin.reflect.jvm.internal.impl.protobuf.n nVar, @NotNull AnnotatedCallableKind annotatedCallableKind, int i6, @NotNull ProtoBuf.ValueParameter valueParameter);

    @NotNull
    List<A> b(@NotNull m0.a aVar);

    @NotNull
    List<A> c(@NotNull m0 m0Var, @NotNull ProtoBuf.EnumEntry enumEntry);

    @NotNull
    List<A> d(@NotNull ProtoBuf.TypeParameter typeParameter, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d dVar);

    @NotNull
    List<A> f(@NotNull m0 m0Var, @NotNull ProtoBuf.Property property);

    @NotNull
    List<A> g(@NotNull m0 m0Var, @NotNull kotlin.reflect.jvm.internal.impl.protobuf.n nVar, @NotNull AnnotatedCallableKind annotatedCallableKind);

    @NotNull
    List<A> h(@NotNull ProtoBuf.Type type, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d dVar);

    @NotNull
    List<A> i(@NotNull m0 m0Var, @NotNull kotlin.reflect.jvm.internal.impl.protobuf.n nVar, @NotNull AnnotatedCallableKind annotatedCallableKind);

    @NotNull
    A k(@NotNull ProtoBuf.Annotation annotation, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d dVar);

    @NotNull
    List<A> l(@NotNull m0 m0Var, @NotNull ProtoBuf.Property property);
}
