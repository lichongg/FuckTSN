package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.VisibleForTesting;
import com.tencent.connect.common.Constants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Result;
import kotlin.g0;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nHandlerDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerDispatcherKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 Runnable.kt\nkotlinx/coroutines/RunnableKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,217:1\n314#2,11:218\n314#2,9:229\n323#2,2:239\n17#3:238\n1#4:241\n*S KotlinDebug\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerDispatcherKt\n*L\n189#1:218,11\n197#1:229,9\n197#1:239,2\n201#1:238\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static final long f48100a = 4611686018427387903L;

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @Nullable
    public static final e f48101b;

    @Nullable
    private static volatile Choreographer choreographer;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerDispatcherKt\n*L\n1#1,18:1\n202#2,2:19\n*E\n"})
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f48102a;

        public a(p pVar) {
            this.f48102a = pVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            g.n(this.f48102a);
        }
    }

    static {
        Object m130constructorimpl;
        byte b6 = 0;
        byte b7 = 0;
        try {
            Result.a aVar = Result.Companion;
            m130constructorimpl = Result.m130constructorimpl(new d(e(Looper.getMainLooper(), true), b7 == true ? 1 : 0, 2, b6 == true ? 1 : 0));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m130constructorimpl = Result.m130constructorimpl(g0.a(th));
        }
        f48101b = (e) (Result.m136isFailureimpl(m130constructorimpl) ? null : m130constructorimpl);
    }

    @JvmOverloads
    @JvmName(name = Constants.FROM)
    @NotNull
    public static final e h(@NotNull Handler handler) {
        return j(handler, null, 1, null);
    }

    @VisibleForTesting
    @NotNull
    public static final Handler e(@NotNull Looper looper, boolean z5) {
        if (!z5) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        kotlin.jvm.internal.g0.n(invoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) invoke;
    }

    @Nullable
    public static final Object f(@NotNull kotlin.coroutines.e<? super Long> eVar) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            return g(eVar);
        }
        q qVar = new q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
        qVar.Q();
        l(choreographer2, qVar);
        Object x5 = qVar.x();
        if (x5 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return x5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object g(kotlin.coroutines.e<? super Long> eVar) {
        q qVar = new q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
        qVar.Q();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            n(qVar);
        } else {
            g1.e().dispatch(qVar.getContext(), new a(qVar));
        }
        Object x5 = qVar.x();
        if (x5 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return x5;
    }

    @JvmOverloads
    @JvmName(name = Constants.FROM)
    @NotNull
    public static final e i(@NotNull Handler handler, @Nullable String str) {
        return new d(handler, str);
    }

    public static /* synthetic */ e j(Handler handler, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = null;
        }
        return i(handler, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Choreographer choreographer2, final p<? super Long> pVar) {
        choreographer2.postFrameCallback(new Choreographer.FrameCallback() { // from class: kotlinx.coroutines.android.f
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j6) {
                g.m(p.this, j6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(p<? super Long> pVar) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            choreographer2 = Choreographer.getInstance();
            kotlin.jvm.internal.g0.m(choreographer2);
            choreographer = choreographer2;
        }
        l(choreographer2, pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(p pVar, long j6) {
        pVar.P(g1.e(), Long.valueOf(j6));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use Dispatchers.Main instead")
    public static /* synthetic */ void k() {
    }
}
