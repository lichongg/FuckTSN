package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.l2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nChannelCoroutine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelCoroutine.kt\nkotlinx/coroutines/channels/ChannelCoroutine\n+ 2 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n1#1,41:1\n706#2,2:42\n706#2,2:44\n706#2,2:46\n*S KotlinDebug\n*F\n+ 1 ChannelCoroutine.kt\nkotlinx/coroutines/channels/ChannelCoroutine\n*L\n21#1:42,2\n26#1:44,2\n32#1:46,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class k<E> extends kotlinx.coroutines.a<n1> implements j<E> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final j<E> f48237d;

    @Override // kotlinx.coroutines.l2
    public void j0(@NotNull Throwable th) {
        CancellationException o12 = l2.o1(this, th, null, 1, null);
        this.f48237d.b(o12);
        h0(o12);
    }

    @NotNull
    protected final j<E> A1() {
        return this.f48237d;
    }

    @Override // kotlinx.coroutines.channels.b0
    public boolean D() {
        return this.f48237d.D();
    }

    @Override // kotlinx.coroutines.channels.b0
    @NotNull
    public kotlinx.coroutines.selects.g<E> N() {
        return this.f48237d.N();
    }

    @Override // kotlinx.coroutines.channels.b0
    @Nullable
    public Object R(@NotNull kotlin.coroutines.e<? super E> eVar) {
        return this.f48237d.R(eVar);
    }

    @Override // kotlinx.coroutines.channels.c0
    public boolean S(@Nullable Throwable th) {
        return this.f48237d.S(th);
    }

    @Override // kotlinx.coroutines.channels.c0
    @Nullable
    public Object T(E e6, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return this.f48237d.T(e6, eVar);
    }

    @Override // kotlinx.coroutines.l2, kotlinx.coroutines.e2, kotlinx.coroutines.channels.d
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean a(Throwable th) {
        j0(new JobCancellationException(m0(), null, this));
        return true;
    }

    @Override // kotlinx.coroutines.l2, kotlinx.coroutines.e2, kotlinx.coroutines.channels.b0
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        j0(new JobCancellationException(m0(), null, this));
    }

    @Override // kotlinx.coroutines.channels.c0
    @NotNull
    public kotlinx.coroutines.selects.i<E, c0<E>> i() {
        return this.f48237d.i();
    }

    @Override // kotlinx.coroutines.channels.b0
    public boolean isEmpty() {
        return this.f48237d.isEmpty();
    }

    @Override // kotlinx.coroutines.channels.b0
    @NotNull
    public l<E> iterator() {
        return this.f48237d.iterator();
    }

    @Override // kotlinx.coroutines.channels.c0
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e6) {
        return this.f48237d.offer(e6);
    }

    @Override // kotlinx.coroutines.channels.b0
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    @Nullable
    public E poll() {
        return this.f48237d.poll();
    }

    @Override // kotlinx.coroutines.channels.c0
    public void q(@NotNull Function1<? super Throwable, n1> function1) {
        this.f48237d.q(function1);
    }

    @Override // kotlinx.coroutines.channels.c0
    @NotNull
    public Object r(E e6) {
        return this.f48237d.r(e6);
    }

    @Override // kotlinx.coroutines.channels.b0
    @NotNull
    public kotlinx.coroutines.selects.g<n<E>> t() {
        return this.f48237d.t();
    }

    @Override // kotlinx.coroutines.channels.b0
    @NotNull
    public kotlinx.coroutines.selects.g<E> u() {
        return this.f48237d.u();
    }

    @Override // kotlinx.coroutines.channels.b0
    @NotNull
    public Object v() {
        return this.f48237d.v();
    }

    @Override // kotlinx.coroutines.channels.b0
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @LowPriorityInOverloadResolution
    @Nullable
    public Object w(@NotNull kotlin.coroutines.e<? super E> eVar) {
        return this.f48237d.w(eVar);
    }

    @Override // kotlinx.coroutines.channels.b0
    @Nullable
    public Object x(@NotNull kotlin.coroutines.e<? super n<? extends E>> eVar) {
        Object x5 = this.f48237d.x(eVar);
        kotlin.coroutines.intrinsics.a.l();
        return x5;
    }

    @Override // kotlinx.coroutines.channels.c0
    public boolean z() {
        return this.f48237d.z();
    }

    public k(@NotNull kotlin.coroutines.i iVar, @NotNull j<E> jVar, boolean z5, boolean z6) {
        super(iVar, z5, z6);
        this.f48237d = jVar;
    }

    @Override // kotlinx.coroutines.l2, kotlinx.coroutines.e2, kotlinx.coroutines.channels.d
    public final void b(@Nullable CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(m0(), null, this);
        }
        j0(cancellationException);
    }

    @NotNull
    public final j<E> getChannel() {
        return this;
    }
}
