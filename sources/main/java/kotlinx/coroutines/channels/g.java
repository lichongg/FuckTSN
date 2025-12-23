package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.channels.c0;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBroadcast.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastCoroutine\n+ 2 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n1#1,202:1\n706#2,2:203\n706#2,2:205\n*S KotlinDebug\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastCoroutine\n*L\n152#1:203,2\n157#1:205,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
class g<E> extends kotlinx.coroutines.a<n1> implements z<E>, d<E> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final d<E> f48189d;

    public g(@NotNull kotlin.coroutines.i iVar, @NotNull d<E> dVar, boolean z5) {
        super(iVar, false, z5);
        this.f48189d = dVar;
        K0((e2) iVar.get(e2.f48569s0));
    }

    @Override // kotlinx.coroutines.l2
    public void j0(@NotNull Throwable th) {
        CancellationException o12 = l2.o1(this, th, null, 1, null);
        this.f48189d.b(o12);
        h0(o12);
    }

    @NotNull
    protected final d<E> A1() {
        return this.f48189d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.a
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void y1(@NotNull n1 n1Var) {
        c0.a.a(this.f48189d, null, 1, null);
    }

    @Override // kotlinx.coroutines.channels.c0
    public boolean S(@Nullable Throwable th) {
        boolean S = this.f48189d.S(th);
        start();
        return S;
    }

    @Override // kotlinx.coroutines.channels.c0
    @Nullable
    public Object T(E e6, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return this.f48189d.T(e6, eVar);
    }

    @Override // kotlinx.coroutines.l2, kotlinx.coroutines.e2, kotlinx.coroutines.channels.d
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean a(Throwable th) {
        if (th == null) {
            th = new JobCancellationException(m0(), null, this);
        }
        j0(th);
        return true;
    }

    @Override // kotlinx.coroutines.l2, kotlinx.coroutines.e2, kotlinx.coroutines.channels.d
    public final void b(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(m0(), null, this);
        }
        j0(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.c0
    @NotNull
    public kotlinx.coroutines.selects.i<E, c0<E>> i() {
        return this.f48189d.i();
    }

    @Override // kotlinx.coroutines.channels.d
    @NotNull
    public b0<E> m() {
        return this.f48189d.m();
    }

    @Override // kotlinx.coroutines.channels.c0
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e6) {
        return this.f48189d.offer(e6);
    }

    @Override // kotlinx.coroutines.channels.c0
    public void q(@NotNull Function1<? super Throwable, n1> function1) {
        this.f48189d.q(function1);
    }

    @Override // kotlinx.coroutines.channels.c0
    @NotNull
    public Object r(E e6) {
        return this.f48189d.r(e6);
    }

    @Override // kotlinx.coroutines.a
    protected void x1(@NotNull Throwable th, boolean z5) {
        if (this.f48189d.S(th) || z5) {
            return;
        }
        o0.b(getContext(), th);
    }

    @Override // kotlinx.coroutines.channels.c0
    public boolean z() {
        return this.f48189d.z();
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.l2, kotlinx.coroutines.e2
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.channels.z
    @NotNull
    public c0<E> getChannel() {
        return this;
    }
}
