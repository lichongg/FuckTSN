package kotlin.reflect.jvm;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n;
import kotlin.reflect.i;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.j0;
import kotlin.reflect.jvm.internal.m1;
import kotlin.reflect.jvm.internal.o;
import kotlin.reflect.jvm.internal.p3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nreflectLambda.kt\nKotlin\n*S Kotlin\n*F\n+ 1 reflectLambda.kt\nkotlin/reflect/jvm/ReflectLambdaKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class a extends FunctionReferenceImpl implements Function2<j0, ProtoBuf.Function, d1> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f44234a = new a();

        a() {
            super(2, j0.class, "loadFunction", "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final d1 invoke(j0 p02, ProtoBuf.Function p12) {
            g0.p(p02, "p0");
            g0.p(p12, "p1");
            return p02.s(p12);
        }
    }

    @ExperimentalReflectionOnLambdas
    @Nullable
    public static final <R> i<R> a(@NotNull n<? extends R> nVar) {
        g0.p(nVar, "<this>");
        Metadata metadata = (Metadata) nVar.getClass().getAnnotation(Metadata.class);
        if (metadata == null) {
            return null;
        }
        String[] d12 = metadata.d1();
        if (d12.length == 0) {
            d12 = null;
        }
        if (d12 == null) {
            return null;
        }
        Pair<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e, ProtoBuf.Function> j6 = h.j(d12, metadata.d2());
        kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e component1 = j6.component1();
        ProtoBuf.Function component2 = j6.component2();
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.c(metadata.mv(), (metadata.xi() & 8) != 0);
        Class<?> cls = nVar.getClass();
        ProtoBuf.TypeTable typeTable = component2.getTypeTable();
        g0.o(typeTable, "getTypeTable(...)");
        return new m1(o.f47537d, (d1) p3.h(cls, component2, component1, new kotlin.reflect.jvm.internal.impl.metadata.deserialization.h(typeTable), cVar, a.f44234a));
    }
}
