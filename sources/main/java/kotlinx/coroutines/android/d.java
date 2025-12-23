package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.i;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import kotlin.ranges.t;
import kotlin.time.j;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.h2;
import kotlinx.coroutines.j1;
import kotlinx.coroutines.p;
import kotlinx.coroutines.s2;
import kotlinx.coroutines.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nHandlerDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerContext\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Runnable.kt\nkotlinx/coroutines/RunnableKt\n*L\n1#1,217:1\n1#2:218\n17#3:219\n*S KotlinDebug\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerContext\n*L\n147#1:219\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d extends e implements z0 {

    @Nullable
    private volatile d _immediate;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Handler f48091a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f48092b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f48093c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final d f48094d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerContext\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,18:1\n148#2:19\n149#2:21\n1#3:20\n*E\n"})
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f48095a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f48096b;

        public a(p pVar, d dVar) {
            this.f48095a = pVar;
            this.f48096b = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f48095a.P(this.f48096b, n1.f44123a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b extends Lambda implements Function1<Throwable, n1> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f48098b;

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ n1 invoke(Throwable th) {
            invoke2(th);
            return n1.f44123a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Runnable runnable) {
            super(1);
            this.f48098b = runnable;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            d.this.f48091a.removeCallbacks(this.f48098b);
        }
    }

    private d(Handler handler, String str, boolean z5) {
        super(null);
        this.f48091a = handler;
        this.f48092b = str;
        this.f48093c = z5;
        this._immediate = z5 ? this : null;
        d dVar = this._immediate;
        if (dVar == null) {
            dVar = new d(handler, str, true);
            this._immediate = dVar;
        }
        this.f48094d = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(d dVar, Runnable runnable) {
        dVar.f48091a.removeCallbacks(runnable);
    }

    private final void z(i iVar, Runnable runnable) {
        h2.f(iVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        g1.c().dispatch(iVar, runnable);
    }

    @Override // kotlinx.coroutines.android.e
    @NotNull
    /* renamed from: B, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public d v() {
        return this.f48094d;
    }

    @Override // kotlinx.coroutines.m0
    public void dispatch(@NotNull i iVar, @NotNull Runnable runnable) {
        if (this.f48091a.post(runnable)) {
            return;
        }
        z(iVar, runnable);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof d) && ((d) obj).f48091a == this.f48091a;
    }

    public int hashCode() {
        return System.identityHashCode(this.f48091a);
    }

    @Override // kotlinx.coroutines.z0
    public void i(long j6, @NotNull p<? super n1> pVar) {
        a aVar = new a(pVar, this);
        if (this.f48091a.postDelayed(aVar, t.C(j6, j.f48028c))) {
            pVar.I(new b(aVar));
        } else {
            z(pVar.getContext(), aVar);
        }
    }

    @Override // kotlinx.coroutines.m0
    public boolean isDispatchNeeded(@NotNull i iVar) {
        return (this.f48093c && g0.g(Looper.myLooper(), this.f48091a.getLooper())) ? false : true;
    }

    @Override // kotlinx.coroutines.android.e, kotlinx.coroutines.z0
    @NotNull
    public j1 m(long j6, @NotNull final Runnable runnable, @NotNull i iVar) {
        if (this.f48091a.postDelayed(runnable, t.C(j6, j.f48028c))) {
            return new j1() { // from class: kotlinx.coroutines.android.c
                @Override // kotlinx.coroutines.j1
                public final void dispose() {
                    d.C(d.this, runnable);
                }
            };
        }
        z(iVar, runnable);
        return s2.f49445a;
    }

    @Override // kotlinx.coroutines.p2, kotlinx.coroutines.m0
    @NotNull
    public String toString() {
        String u5 = u();
        if (u5 == null) {
            String str = this.f48092b;
            if (str == null) {
                str = this.f48091a.toString();
            }
            if (this.f48093c) {
                return str + ".immediate";
            }
            return str;
        }
        return u5;
    }

    public /* synthetic */ d(Handler handler, String str, int i6, v vVar) {
        this(handler, (i6 & 2) != 0 ? null : str);
    }

    public d(@NotNull Handler handler, @Nullable String str) {
        this(handler, str, false);
    }
}
