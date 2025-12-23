package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class i0 extends h0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n*L\n1#1,70:1\n*E\n"})
    public static final class a<T> implements Iterable<T>, m3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Iterator<T>> f43649a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function0<? extends Iterator<? extends T>> function0) {
            this.f43649a = function0;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f43649a.invoke();
        }
    }

    @InlineOnly
    private static final <T> Iterable<T> c0(Function0<? extends Iterator<? extends T>> iterator) {
        kotlin.jvm.internal.g0.p(iterator, "iterator");
        return new a(iterator);
    }

    @PublishedApi
    public static <T> int d0(@NotNull Iterable<? extends T> iterable, int i6) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i6;
    }

    @PublishedApi
    @Nullable
    public static final <T> Integer e0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    @NotNull
    public static <T> List<T> f0(@NotNull Iterable<? extends Iterable<? extends T>> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Iterable<? extends T>> it = iterable.iterator();
        while (it.hasNext()) {
            m0.s0(arrayList, it.next());
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> g0(@NotNull Iterable<? extends Pair<? extends T, ? extends R>> iterable) {
        kotlin.jvm.internal.g0.p(iterable, "<this>");
        int d02 = d0(iterable, 10);
        ArrayList arrayList = new ArrayList(d02);
        ArrayList arrayList2 = new ArrayList(d02);
        for (Pair<? extends T, ? extends R> pair : iterable) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return kotlin.o0.a(arrayList, arrayList2);
    }
}
