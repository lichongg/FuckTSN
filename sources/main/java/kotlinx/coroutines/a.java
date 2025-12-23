package kotlinx.coroutines;

import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@InternalCoroutinesApi
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class a<T> extends l2 implements e2, kotlin.coroutines.e<T>, r0 {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.coroutines.i f48079c;

    @Override // kotlin.coroutines.e
    public final void resumeWith(@NotNull Object obj) {
        Object U0 = U0(i0.d(obj, null, 1, null));
        if (U0 == m2.f49384b) {
            return;
        }
        v1(U0);
    }

    @Override // kotlinx.coroutines.l2
    public final void J0(@NotNull Throwable th) {
        o0.b(this.f48079c, th);
    }

    @Override // kotlinx.coroutines.l2
    @NotNull
    public String W0() {
        String b6 = l0.b(this.f48079c);
        if (b6 == null) {
            return super.W0();
        }
        return '\"' + b6 + "\":" + super.W0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.l2
    protected final void e1(@Nullable Object obj) {
        if (!(obj instanceof d0)) {
            y1(obj);
        } else {
            d0 d0Var = (d0) obj;
            x1(d0Var.f48476a, d0Var.a());
        }
    }

    @Override // kotlin.coroutines.e
    @NotNull
    public final kotlin.coroutines.i getContext() {
        return this.f48079c;
    }

    @Override // kotlinx.coroutines.r0
    @NotNull
    public kotlin.coroutines.i getCoroutineContext() {
        return this.f48079c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.l2
    @NotNull
    public String m0() {
        return u0.a(this) + " was cancelled";
    }

    public a(@NotNull kotlin.coroutines.i iVar, boolean z5, boolean z6) {
        super(z6);
        if (z5) {
            K0((e2) iVar.get(e2.f48569s0));
        }
        this.f48079c = iVar.plus(this);
    }

    @Override // kotlinx.coroutines.l2, kotlinx.coroutines.e2
    public boolean isActive() {
        return super.isActive();
    }

    protected void v1(@Nullable Object obj) {
        e0(obj);
    }

    public final <R> void z1(@NotNull CoroutineStart coroutineStart, R r5, @NotNull Function2<? super R, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2) {
        coroutineStart.invoke(function2, r5, this);
    }

    public static /* synthetic */ void w1() {
    }

    protected void y1(T t5) {
    }

    protected void x1(@NotNull Throwable th, boolean z5) {
    }
}
