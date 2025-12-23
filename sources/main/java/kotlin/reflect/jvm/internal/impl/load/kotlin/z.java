package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class z implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final x f46009b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.x<kotlin.reflect.jvm.internal.impl.metadata.deserialization.c> f46010c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final t0 f46011d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final DeserializedContainerAbiStability f46012e;

    public z(@NotNull x binaryClass, @Nullable kotlin.reflect.jvm.internal.impl.serialization.deserialization.x<kotlin.reflect.jvm.internal.impl.metadata.deserialization.c> xVar, @NotNull t0 preReleaseInfo, @NotNull DeserializedContainerAbiStability abiStability) {
        kotlin.jvm.internal.g0.p(binaryClass, "binaryClass");
        kotlin.jvm.internal.g0.p(preReleaseInfo, "preReleaseInfo");
        kotlin.jvm.internal.g0.p(abiStability, "abiStability");
        this.f46009b = binaryClass;
        this.f46010c = xVar;
        this.f46011d = preReleaseInfo;
        this.f46012e = abiStability;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.s
    @NotNull
    public String a() {
        return "Class '" + this.f46009b.c().a().a() + '\'';
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1
    @NotNull
    public f1 b() {
        f1 NO_SOURCE_FILE = f1.f44684a;
        kotlin.jvm.internal.g0.o(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    @NotNull
    public final x d() {
        return this.f46009b;
    }

    @NotNull
    public String toString() {
        return z.class.getSimpleName() + ": " + this.f46009b;
    }
}
