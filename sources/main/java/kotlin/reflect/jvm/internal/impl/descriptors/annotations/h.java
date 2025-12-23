package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h implements g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<c> f44658a;

    /* JADX WARN: Multi-variable type inference failed */
    public h(@NotNull List<? extends c> annotations) {
        g0.p(annotations, "annotations");
        this.f44658a = annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean isEmpty() {
        return this.f44658a.isEmpty();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<c> iterator() {
        return this.f44658a.iterator();
    }

    @NotNull
    public String toString() {
        return this.f44658a.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    @Nullable
    public c b(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return g.b.a(this, cVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean l(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return g.b.b(this, cVar);
    }
}
