package kotlinx.coroutines;

import kotlin.PublishedApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@PublishedApi
/* loaded from: D:\Downloads\app\classes8.dex */
public class g2 extends l2 implements b0 {

    /* renamed from: c, reason: collision with root package name */
    private final boolean f49209c;

    public g2(@Nullable e2 e2Var) {
        super(true);
        K0(e2Var);
        this.f49209c = v1();
    }

    @Override // kotlinx.coroutines.l2
    public boolean D0() {
        return true;
    }

    @Override // kotlinx.coroutines.l2
    public boolean A0() {
        return this.f49209c;
    }

    @Override // kotlinx.coroutines.b0
    public boolean c(@NotNull Throwable th) {
        return T0(new d0(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.b0
    public boolean complete() {
        return T0(kotlin.n1.f44123a);
    }

    private final boolean v1() {
        w wVar;
        l2 A;
        w wVar2;
        v G0 = G0();
        if (G0 instanceof w) {
            wVar = (w) G0;
        } else {
            wVar = null;
        }
        if (wVar != null && (A = wVar.A()) != null) {
            while (!A.A0()) {
                v G02 = A.G0();
                if (G02 instanceof w) {
                    wVar2 = (w) G02;
                } else {
                    wVar2 = null;
                }
                if (wVar2 != null && (A = wVar2.A()) != null) {
                }
            }
            return true;
        }
        return false;
    }
}
