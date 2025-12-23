package kotlinx.coroutines.selects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.selects.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@PublishedApi
@SourceDebugExtension({"SMAP\nSelectUnbiased.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectUnbiased.kt\nkotlinx/coroutines/selects/UnbiasedSelectImplementation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,68:1\n1855#2,2:69\n*S KotlinDebug\n*F\n+ 1 SelectUnbiased.kt\nkotlinx/coroutines/selects/UnbiasedSelectImplementation\n*L\n63#1:69,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class s<R> extends l<R> {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final List<l<R>.a> f49586g;

    private final void P() {
        try {
            Collections.shuffle(this.f49586g);
            Iterator<T> it = this.f49586g.iterator();
            while (it.hasNext()) {
                l.I(this, (l.a) it.next(), false, 1, null);
            }
        } finally {
            this.f49586g.clear();
        }
    }

    @Override // kotlinx.coroutines.selects.l, kotlinx.coroutines.selects.c
    public void a(@NotNull e eVar, @NotNull Function1<? super kotlin.coroutines.e<? super R>, ? extends Object> function1) {
        this.f49586g.add(new l.a(eVar.d(), eVar.c(), eVar.b(), o.l(), function1, eVar.a()));
    }

    @Override // kotlinx.coroutines.selects.l, kotlinx.coroutines.selects.c
    public <P, Q> void c(@NotNull i<? super P, ? extends Q> iVar, P p5, @NotNull Function2<? super Q, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2) {
        this.f49586g.add(new l.a(iVar.d(), iVar.c(), iVar.b(), p5, function2, iVar.a()));
    }

    @Override // kotlinx.coroutines.selects.l, kotlinx.coroutines.selects.c
    public <Q> void k(@NotNull g<? extends Q> gVar, @NotNull Function2<? super Q, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2) {
        this.f49586g.add(new l.a(gVar.d(), gVar.c(), gVar.b(), null, function2, gVar.a()));
    }

    public s(@NotNull kotlin.coroutines.i iVar) {
        super(iVar);
        this.f49586g = new ArrayList();
    }

    @PublishedApi
    static /* synthetic */ <R> Object O(s<R> sVar, kotlin.coroutines.e<? super R> eVar) {
        sVar.P();
        return super.y(eVar);
    }

    @Override // kotlinx.coroutines.selects.l
    @PublishedApi
    @Nullable
    public Object y(@NotNull kotlin.coroutines.e<? super R> eVar) {
        return O(this, eVar);
    }
}
