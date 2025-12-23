package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.d f46972a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final ProtoBuf.Class f46973b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.a f46974c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final e1 f46975d;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return kotlin.jvm.internal.g0.g(this.f46972a, hVar.f46972a) && kotlin.jvm.internal.g0.g(this.f46973b, hVar.f46973b) && kotlin.jvm.internal.g0.g(this.f46974c, hVar.f46974c) && kotlin.jvm.internal.g0.g(this.f46975d, hVar.f46975d);
    }

    public h(@NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.d nameResolver, @NotNull ProtoBuf.Class classProto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.a metadataVersion, @NotNull e1 sourceElement) {
        kotlin.jvm.internal.g0.p(nameResolver, "nameResolver");
        kotlin.jvm.internal.g0.p(classProto, "classProto");
        kotlin.jvm.internal.g0.p(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.g0.p(sourceElement, "sourceElement");
        this.f46972a = nameResolver;
        this.f46973b = classProto;
        this.f46974c = metadataVersion;
        this.f46975d = sourceElement;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.d a() {
        return this.f46972a;
    }

    @NotNull
    public final ProtoBuf.Class b() {
        return this.f46973b;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.a c() {
        return this.f46974c;
    }

    @NotNull
    public final e1 d() {
        return this.f46975d;
    }

    public int hashCode() {
        return (((((this.f46972a.hashCode() * 31) + this.f46973b.hashCode()) * 31) + this.f46974c.hashCode()) * 31) + this.f46975d.hashCode();
    }

    @NotNull
    public String toString() {
        return "ClassData(nameResolver=" + this.f46972a + ", classProto=" + this.f46973b + ", metadataVersion=" + this.f46974c + ", sourceElement=" + this.f46975d + ')';
    }
}
