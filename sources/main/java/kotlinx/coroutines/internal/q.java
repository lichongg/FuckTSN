package kotlinx.coroutines.internal;

import java.util.ArrayList;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmInline
@SourceDebugExtension({"SMAP\nInlineList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InlineList.kt\nkotlinx/coroutines/internal/InlineList\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,49:1\n1#2:50\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q<E> {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final Object f49298a;

    public static final /* synthetic */ q a(Object obj) {
        return new q(obj);
    }

    public static /* synthetic */ Object c(Object obj, int i6, kotlin.jvm.internal.v vVar) {
        if ((i6 & 1) != 0) {
            obj = null;
        }
        return b(obj);
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof q) && kotlin.jvm.internal.g0.g(obj, ((q) obj2).j());
    }

    public static final void f(Object obj, @NotNull Function1<? super E, n1> function1) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            function1.invoke(obj);
            return;
        }
        kotlin.jvm.internal.g0.n(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList arrayList = (ArrayList) obj;
        int size = arrayList.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            } else {
                function1.invoke((Object) arrayList.get(size));
            }
        }
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @NotNull
    public static final Object h(Object obj, E e6) {
        if (obj == null) {
            return b(e6);
        }
        if (obj instanceof ArrayList) {
            kotlin.jvm.internal.g0.n(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ((ArrayList) obj).add(e6);
            return b(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e6);
        return b(arrayList);
    }

    public static String i(Object obj) {
        return "InlineList(holder=" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f49298a, obj);
    }

    public int hashCode() {
        return g(this.f49298a);
    }

    public final /* synthetic */ Object j() {
        return this.f49298a;
    }

    public String toString() {
        return i(this.f49298a);
    }

    private /* synthetic */ q(Object obj) {
        this.f49298a = obj;
    }

    public static final boolean e(Object obj, Object obj2) {
        return kotlin.jvm.internal.g0.g(obj, obj2);
    }

    @NotNull
    public static <E> Object b(@Nullable Object obj) {
        return obj;
    }
}
