package kotlinx.coroutines;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class m3<U, T extends U> extends kotlinx.coroutines.internal.o0<T> implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    @JvmField
    public final long f49393e;

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.l2
    @NotNull
    public String W0() {
        return super.W0() + "(timeMillis=" + this.f49393e + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        h0(n3.a(this.f49393e, a1.d(getContext()), this));
    }

    public m3(long j6, @NotNull kotlin.coroutines.e<? super U> eVar) {
        super(eVar.getContext(), eVar);
        this.f49393e = j6;
    }
}
