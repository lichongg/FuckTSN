package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated(level = DeprecationLevel.WARNING, message = "ConflatedBroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
@ObsoleteCoroutinesApi
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t<E> implements d<E> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final e<E> f48462a;

    private t(e<E> eVar) {
        this.f48462a = eVar;
    }

    @Override // kotlinx.coroutines.channels.c0
    public boolean S(@Nullable Throwable th) {
        return this.f48462a.S(th);
    }

    @Override // kotlinx.coroutines.channels.c0
    @Nullable
    public Object T(E e6, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return this.f48462a.T(e6, eVar);
    }

    @Override // kotlinx.coroutines.channels.d
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility only")
    public /* synthetic */ boolean a(Throwable th) {
        return this.f48462a.a(th);
    }

    @Override // kotlinx.coroutines.channels.d
    public void b(@Nullable CancellationException cancellationException) {
        this.f48462a.b(cancellationException);
    }

    public final E c() {
        return this.f48462a.L1();
    }

    @Nullable
    public final E d() {
        return this.f48462a.N1();
    }

    @Override // kotlinx.coroutines.channels.c0
    @NotNull
    public kotlinx.coroutines.selects.i<E, c0<E>> i() {
        return this.f48462a.i();
    }

    @Override // kotlinx.coroutines.channels.d
    @NotNull
    public b0<E> m() {
        return this.f48462a.m();
    }

    @Override // kotlinx.coroutines.channels.c0
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e6) {
        return this.f48462a.offer(e6);
    }

    @Override // kotlinx.coroutines.channels.c0
    public void q(@NotNull Function1<? super Throwable, n1> function1) {
        this.f48462a.q(function1);
    }

    @Override // kotlinx.coroutines.channels.c0
    @NotNull
    public Object r(E e6) {
        return this.f48462a.r(e6);
    }

    @Override // kotlinx.coroutines.channels.c0
    public boolean z() {
        return this.f48462a.z();
    }

    public t() {
        this(new e(-1));
    }

    public t(E e6) {
        this();
        r(e6);
    }
}
