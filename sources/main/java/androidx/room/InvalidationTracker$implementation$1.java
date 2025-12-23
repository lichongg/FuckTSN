package androidx.room;

import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.g0;
import kotlin.n1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
/* synthetic */ class InvalidationTracker$implementation$1 extends FunctionReferenceImpl implements Function1<Set<? extends Integer>, n1> {
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ n1 invoke(Set<? extends Integer> set) {
        invoke2((Set<Integer>) set);
        return n1.f44123a;
    }

    InvalidationTracker$implementation$1(Object obj) {
        super(1, obj, InvalidationTracker.class, "notifyInvalidatedObservers", "notifyInvalidatedObservers(Ljava/util/Set;)V", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Set<Integer> p02) {
        g0.p(p02, "p0");
        ((InvalidationTracker) this.receiver).notifyInvalidatedObservers(p02);
    }
}
