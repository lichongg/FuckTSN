package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class b implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.g {

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f46835b = {kotlin.jvm.internal.o0.u(new PropertyReference1Impl(b.class, "annotations", "getAnnotations()Ljava/util/List;", 0))};

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f46836a;

    public b(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull Function0<? extends List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> compute) {
        kotlin.jvm.internal.g0.p(storageManager, "storageManager");
        kotlin.jvm.internal.g0.p(compute, "compute");
        this.f46836a = storageManager.e(compute);
    }

    private final List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> a() {
        return (List) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f46836a, this, f46835b[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.c b(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return g.b.a(this, cVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean isEmpty() {
        return a().isEmpty();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> iterator() {
        return a().iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean l(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return g.b.b(this, cVar);
    }
}
