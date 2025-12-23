package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class r2 extends kotlin.coroutines.a implements e2 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final r2 f49443a = new r2();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f49444b = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited";

    @Override // kotlinx.coroutines.e2, kotlinx.coroutines.channels.d
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean a(Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.e2
    @Nullable
    public e2 getParent() {
        return null;
    }

    @Override // kotlinx.coroutines.e2
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.e2
    public boolean isCancelled() {
        return false;
    }

    @Override // kotlinx.coroutines.e2
    public boolean isCompleted() {
        return false;
    }

    @Override // kotlinx.coroutines.e2
    @Deprecated(level = DeprecationLevel.WARNING, message = f49444b)
    public boolean start() {
        return false;
    }

    private r2() {
        super(e2.f48569s0);
    }

    @Override // kotlinx.coroutines.e2
    @Deprecated(level = DeprecationLevel.WARNING, message = f49444b)
    @NotNull
    public v A(@NotNull x xVar) {
        return s2.f49445a;
    }

    @Override // kotlinx.coroutines.e2
    @Deprecated(level = DeprecationLevel.WARNING, message = f49444b)
    @NotNull
    public j1 G(boolean z5, boolean z6, @NotNull Function1<? super Throwable, kotlin.n1> function1) {
        return s2.f49445a;
    }

    @Override // kotlinx.coroutines.e2
    @Deprecated(level = DeprecationLevel.WARNING, message = f49444b)
    @NotNull
    public CancellationException H() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.e2
    @Deprecated(level = DeprecationLevel.WARNING, message = f49444b)
    @Nullable
    public Object M(@NotNull kotlin.coroutines.e<? super kotlin.n1> eVar) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.e2
    @Deprecated(level = DeprecationLevel.WARNING, message = f49444b)
    @NotNull
    public j1 k(@NotNull Function1<? super Throwable, kotlin.n1> function1) {
        return s2.f49445a;
    }

    @NotNull
    public String toString() {
        return "NonCancellable";
    }

    @Override // kotlinx.coroutines.e2
    @NotNull
    public kotlinx.coroutines.selects.e y() {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.e2
    @NotNull
    public kotlin.sequences.m<e2> E() {
        return kotlin.sequences.p.l();
    }

    @Override // kotlinx.coroutines.e2, kotlinx.coroutines.channels.b0
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        b(null);
    }

    @Override // kotlinx.coroutines.e2
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @NotNull
    public e2 j(@NotNull e2 e2Var) {
        return e2.a.j(this, e2Var);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = f49444b)
    public static /* synthetic */ void t() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = f49444b)
    public static /* synthetic */ void u() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = f49444b)
    public static /* synthetic */ void v() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = f49444b)
    public static /* synthetic */ void w() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = f49444b)
    public static /* synthetic */ void x() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = f49444b)
    public static /* synthetic */ void z() {
    }

    @Override // kotlinx.coroutines.e2, kotlinx.coroutines.channels.d
    @Deprecated(level = DeprecationLevel.WARNING, message = f49444b)
    public void b(@Nullable CancellationException cancellationException) {
    }
}
