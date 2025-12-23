package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.i1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nProtoBasedClassDataFinder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProtoBasedClassDataFinder.kt\norg/jetbrains/kotlin/serialization/deserialization/ProtoBasedClassDataFinder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,43:1\n1208#2,2:44\n1236#2,4:46\n*S KotlinDebug\n*F\n+ 1 ProtoBasedClassDataFinder.kt\norg/jetbrains/kotlin/serialization/deserialization/ProtoBasedClassDataFinder\n*L\n32#1:44,2\n32#1:46,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l0 implements i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.d f46994a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.a f46995b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Function1<kotlin.reflect.jvm.internal.impl.name.b, e1> f46996c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final Map<kotlin.reflect.jvm.internal.impl.name.b, ProtoBuf.Class> f46997d;

    /* JADX WARN: Multi-variable type inference failed */
    public l0(@NotNull ProtoBuf.PackageFragment proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.a metadataVersion, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.b, ? extends e1> classSource) {
        kotlin.jvm.internal.g0.p(proto, "proto");
        kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
        kotlin.jvm.internal.g0.p(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.g0.p(classSource, "classSource");
        this.f46994a = nameResolver;
        this.f46995b = metadataVersion;
        this.f46996c = classSource;
        List<ProtoBuf.Class> class_List = proto.getClass_List();
        kotlin.jvm.internal.g0.o(class_List, "getClass_List(...)");
        List<ProtoBuf.Class> list = class_List;
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(i1.j(kotlin.collections.f0.d0(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(k0.a(this.f46994a, ((ProtoBuf.Class) obj).getFqName()), obj);
        }
        this.f46997d = linkedHashMap;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.i
    @Nullable
    public h a(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
        kotlin.jvm.internal.g0.p(classId, "classId");
        ProtoBuf.Class r02 = this.f46997d.get(classId);
        if (r02 == null) {
            return null;
        }
        return new h(this.f46994a, r02, this.f46995b, this.f46996c.invoke(classId));
    }

    @NotNull
    public final Collection<kotlin.reflect.jvm.internal.impl.name.b> b() {
        return this.f46997d.keySet();
    }
}
