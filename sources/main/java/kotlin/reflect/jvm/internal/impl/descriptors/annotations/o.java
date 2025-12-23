package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAnnotations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Annotations.kt\norg/jetbrains/kotlin/descriptors/annotations/FilteredAnnotations\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,123:1\n774#2:124\n865#2,2:125\n1761#2,3:127\n*S KotlinDebug\n*F\n+ 1 Annotations.kt\norg/jetbrains/kotlin/descriptors/annotations/FilteredAnnotations\n*L\n69#1:124\n69#1:125,2\n72#1:127,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o implements g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final g f44668a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f44669b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Function1<kotlin.reflect.jvm.internal.impl.name.c, Boolean> f44670c;

    /* JADX WARN: Multi-variable type inference failed */
    public o(@NotNull g delegate, boolean z5, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.c, Boolean> fqNameFilter) {
        g0.p(delegate, "delegate");
        g0.p(fqNameFilter, "fqNameFilter");
        this.f44668a = delegate;
        this.f44669b = z5;
        this.f44670c = fqNameFilter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    @Nullable
    public c b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        g0.p(fqName, "fqName");
        if (this.f44670c.invoke(fqName).booleanValue()) {
            return this.f44668a.b(fqName);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean isEmpty() {
        boolean z5;
        g gVar = this.f44668a;
        if (!(gVar instanceof Collection) || !((Collection) gVar).isEmpty()) {
            Iterator<c> it = gVar.iterator();
            while (it.hasNext()) {
                if (a(it.next())) {
                    z5 = true;
                    break;
                }
            }
        }
        z5 = false;
        return this.f44669b ? !z5 : z5;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<c> iterator() {
        g gVar = this.f44668a;
        ArrayList arrayList = new ArrayList();
        for (c cVar : gVar) {
            if (a(cVar)) {
                arrayList.add(cVar);
            }
        }
        return arrayList.iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean l(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        g0.p(fqName, "fqName");
        if (this.f44670c.invoke(fqName).booleanValue()) {
            return this.f44668a.l(fqName);
        }
        return false;
    }

    private final boolean a(c cVar) {
        kotlin.reflect.jvm.internal.impl.name.c d6 = cVar.d();
        if (d6 != null && this.f44670c.invoke(d6).booleanValue()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(@NotNull g delegate, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.c, Boolean> fqNameFilter) {
        this(delegate, false, fqNameFilter);
        g0.p(delegate, "delegate");
        g0.p(fqNameFilter, "fqNameFilter");
    }
}
