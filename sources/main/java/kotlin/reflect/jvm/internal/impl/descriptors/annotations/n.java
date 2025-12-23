package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.sequences.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAnnotations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Annotations.kt\norg/jetbrains/kotlin/descriptors/annotations/CompositeAnnotations\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,123:1\n1740#2,3:124\n1374#2:129\n1460#2,5:130\n1255#3,2:127\n*S KotlinDebug\n*F\n+ 1 Annotations.kt\norg/jetbrains/kotlin/descriptors/annotations/CompositeAnnotations\n*L\n105#1:124,3\n112#1:129\n112#1:130,5\n107#1:127,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n implements g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<g> f44667a;

    /* JADX WARN: Multi-variable type inference failed */
    public n(@NotNull List<? extends g> delegates) {
        g0.p(delegates, "delegates");
        this.f44667a = delegates;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c e(kotlin.reflect.jvm.internal.impl.name.c cVar, g it) {
        g0.p(it, "it");
        return it.b(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.sequences.m f(g it) {
        g0.p(it, "it");
        return f0.E1(it);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    @Nullable
    public c b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        g0.p(fqName, "fqName");
        return (c) p.i1(p.S1(f0.E1(this.f44667a), new l(fqName)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean isEmpty() {
        List<g> list = this.f44667a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((g) it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<c> iterator() {
        return p.k1(f0.E1(this.f44667a), m.f44666a).iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean l(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        g0.p(fqName, "fqName");
        Iterator it = f0.E1(this.f44667a).iterator();
        while (it.hasNext()) {
            if (((g) it.next()).l(fqName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n(@NotNull g... delegates) {
        this((List<? extends g>) kotlin.collections.n.dz(delegates));
        g0.p(delegates, "delegates");
    }
}
