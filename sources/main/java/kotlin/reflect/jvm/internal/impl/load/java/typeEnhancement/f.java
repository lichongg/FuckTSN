package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class f implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.c f45769a;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean isEmpty() {
        return false;
    }

    public f(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqNameToMatch) {
        kotlin.jvm.internal.g0.p(fqNameToMatch, "fqNameToMatch");
        this.f45769a = fqNameToMatch;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    @Nullable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        if (kotlin.jvm.internal.g0.g(fqName, this.f45769a)) {
            return e.f45765a;
        }
        return null;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> iterator() {
        return kotlin.collections.f0.J().iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean l(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return g.b.b(this, cVar);
    }
}
