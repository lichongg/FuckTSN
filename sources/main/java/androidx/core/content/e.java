package androidx.core.content;

import androidx.core.util.Predicate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class e implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f822a;

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        return this.f822a.equals((String) obj);
    }

    @Override // androidx.core.util.Predicate
    public /* synthetic */ Predicate and(Predicate predicate) {
        return androidx.core.util.k.a(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public /* synthetic */ Predicate negate() {
        return androidx.core.util.k.b(this);
    }

    @Override // androidx.core.util.Predicate
    public /* synthetic */ Predicate or(Predicate predicate) {
        return androidx.core.util.k.c(this, predicate);
    }
}
