package androidx.room;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.n1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
/* synthetic */ class RoomDatabase$closeBarrier$1 extends FunctionReferenceImpl implements Function0<n1> {
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ n1 invoke() {
        invoke2();
        return n1.f44123a;
    }

    RoomDatabase$closeBarrier$1(Object obj) {
        super(0, obj, RoomDatabase.class, "onClosed", "onClosed()V", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((RoomDatabase) this.receiver).onClosed();
    }
}
