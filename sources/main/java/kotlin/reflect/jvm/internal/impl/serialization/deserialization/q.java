package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class q extends kotlin.reflect.jvm.internal.impl.descriptors.impl.h0 {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.n f47054g;

    @NotNull
    public abstract i E0();

    public abstract void G0(@NotNull m mVar);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.f0 module) {
        super(module, fqName);
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        kotlin.jvm.internal.g0.p(storageManager, "storageManager");
        kotlin.jvm.internal.g0.p(module, "module");
        this.f47054g = storageManager;
    }

    public boolean F0(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k r5 = r();
        return (r5 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w) && ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.w) r5).u().contains(name);
    }
}
