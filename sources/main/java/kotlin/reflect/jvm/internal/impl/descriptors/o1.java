package kotlin.reflect.jvm.internal.impl.descriptors;

import e4.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nValueClassRepresentation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValueClassRepresentation.kt\norg/jetbrains/kotlin/descriptors/ValueClassRepresentation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,51:1\n1563#2:52\n1634#2,3:53\n*S KotlinDebug\n*F\n+ 1 ValueClassRepresentation.kt\norg/jetbrains/kotlin/descriptors/ValueClassRepresentation\n*L\n23#1:52\n23#1:53,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class o1<Type extends e4.h> {
    public /* synthetic */ o1(kotlin.jvm.internal.v vVar) {
        this();
    }

    public abstract boolean a(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);

    private o1() {
    }

    @NotNull
    public final <Other extends e4.i> o1<Other> b(@NotNull Function1<? super Type, ? extends Other> transform) {
        kotlin.jvm.internal.g0.p(transform, "transform");
        if (this instanceof z) {
            z zVar = (z) this;
            return new z(zVar.c(), transform.invoke(zVar.d()));
        }
        if (!(this instanceof g0)) {
            throw new NoWhenBranchMatchedException();
        }
        List<Pair<kotlin.reflect.jvm.internal.impl.name.f, Type>> c6 = ((g0) this).c();
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(c6, 10));
        Iterator<T> it = c6.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            arrayList.add(kotlin.o0.a((kotlin.reflect.jvm.internal.impl.name.f) pair.component1(), transform.invoke((e4.h) pair.component2())));
        }
        return new g0(arrayList);
    }
}
