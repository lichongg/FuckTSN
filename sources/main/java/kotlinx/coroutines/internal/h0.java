package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nOnDemandAllocatingPool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnDemandAllocatingPool.kt\nkotlinx/coroutines/internal/OnDemandAllocatingPool\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 OnDemandAllocatingPool.kt\nkotlinx/coroutines/internal/OnDemandAllocatingPoolKt\n*L\n1#1,107:1\n41#1:108\n41#1:109\n35#1,7:110\n41#1:127\n1549#2:117\n1620#2,2:118\n1622#2:122\n1549#2:123\n1620#2,3:124\n101#3,2:120\n*S KotlinDebug\n*F\n+ 1 OnDemandAllocatingPool.kt\nkotlinx/coroutines/internal/OnDemandAllocatingPool\n*L\n35#1:108\n54#1:109\n76#1:110,7\n92#1:127\n77#1:117\n77#1:118,2\n77#1:122\n91#1:123\n91#1:124,3\n79#1:120,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h0<T> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f49267d = AtomicIntegerFieldUpdater.newUpdater(h0.class, "controlState");

    /* renamed from: a, reason: collision with root package name */
    private final int f49268a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Function1<Integer, T> f49269b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final AtomicReferenceArray f49270c;

    @Volatile
    private volatile int controlState;

    private final boolean c(int i6) {
        return (i6 & Integer.MIN_VALUE) != 0;
    }

    private final int f() {
        int i6;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f49267d;
        do {
            i6 = atomicIntegerFieldUpdater.get(this);
            if ((i6 & Integer.MIN_VALUE) != 0) {
                return 0;
            }
        } while (!f49267d.compareAndSet(this, i6, Integer.MIN_VALUE | i6));
        return i6;
    }

    public final boolean a() {
        int i6;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f49267d;
        do {
            i6 = atomicIntegerFieldUpdater.get(this);
            if ((Integer.MIN_VALUE & i6) != 0) {
                return false;
            }
            if (i6 >= this.f49268a) {
                return true;
            }
        } while (!f49267d.compareAndSet(this, i6, i6 + 1));
        this.f49270c.set(i6, this.f49269b.invoke(Integer.valueOf(i6)));
        return true;
    }

    @NotNull
    public final List<T> b() {
        int i6;
        Object andSet;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f49267d;
        while (true) {
            i6 = atomicIntegerFieldUpdater.get(this);
            if ((i6 & Integer.MIN_VALUE) != 0) {
                i6 = 0;
                break;
            }
            if (f49267d.compareAndSet(this, i6, Integer.MIN_VALUE | i6)) {
                break;
            }
        }
        kotlin.ranges.m W1 = kotlin.ranges.t.W1(0, i6);
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(W1, 10));
        Iterator<Integer> it = W1.iterator();
        while (it.hasNext()) {
            int nextInt = ((kotlin.collections.d1) it).nextInt();
            do {
                andSet = this.f49270c.getAndSet(nextInt, null);
            } while (andSet == null);
            arrayList.add(andSet);
        }
        return arrayList;
    }

    @NotNull
    public final String e() {
        int i6 = f49267d.get(this);
        kotlin.ranges.m W1 = kotlin.ranges.t.W1(0, Integer.MAX_VALUE & i6);
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(W1, 10));
        Iterator<Integer> it = W1.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f49270c.get(((kotlin.collections.d1) it).nextInt()));
        }
        return arrayList.toString() + ((i6 & Integer.MIN_VALUE) != 0 ? "[closed]" : "");
    }

    @NotNull
    public String toString() {
        return "OnDemandAllocatingPool(" + e() + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h0(int i6, @NotNull Function1<? super Integer, ? extends T> function1) {
        this.f49268a = i6;
        this.f49269b = function1;
        this.f49270c = new AtomicReferenceArray(i6);
    }

    private final void d(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, n1> function1, Object obj) {
        while (true) {
            function1.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }
}
