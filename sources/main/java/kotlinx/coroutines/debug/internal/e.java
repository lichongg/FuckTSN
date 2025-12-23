package kotlinx.coroutines.debug.internal;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.PublishedApi;
import kotlin.collections.f0;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.g0;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlin.sequences.o;
import kotlin.sequences.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@PublishedApi
@SourceDebugExtension({"SMAP\nDebugCoroutineInfoImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugCoroutineInfoImpl.kt\nkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,180:1\n1#2:181\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e {

    @JvmField
    @Nullable
    public volatile WeakReference<kotlin.coroutines.jvm.internal.c> _lastObservedFrame;

    @JvmField
    @NotNull
    public volatile String _state = f.f48547a;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final k f48533a;

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    public final long f48534b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final WeakReference<kotlin.coroutines.i> f48535c;

    /* renamed from: d, reason: collision with root package name */
    private int f48536d;

    @JvmField
    @Nullable
    public volatile Thread lastObservedThread;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$creationStackTrace$1", f = "DebugCoroutineInfoImpl.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends RestrictedSuspendLambda implements Function2<o<? super StackTraceElement>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48537a;

        /* renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f48538b;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ k f48540d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(k kVar, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f48540d = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            a aVar = e.this.new a(this.f48540d, eVar);
            aVar.f48538b = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull o<? super StackTraceElement> oVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(oVar, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f48537a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                o oVar = (o) this.f48538b;
                e eVar = e.this;
                kotlin.coroutines.jvm.internal.c callerFrame = this.f48540d.getCallerFrame();
                this.f48537a = 1;
                if (eVar.j(oVar, callerFrame, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl", f = "DebugCoroutineInfoImpl.kt", i = {0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE}, m = "yieldFrames", n = {"this", "$this$yieldFrames", "frame"}, s = {"L$0", "L$1", "L$2"})
    static final class b extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48541a;

        /* renamed from: b, reason: collision with root package name */
        Object f48542b;

        /* renamed from: c, reason: collision with root package name */
        Object f48543c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f48544d;

        /* renamed from: f, reason: collision with root package name */
        int f48546f;

        b(kotlin.coroutines.e<? super b> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48544d = obj;
            this.f48546f |= Integer.MIN_VALUE;
            return e.this.j(null, null, this);
        }
    }

    public final synchronized void i(@NotNull String str, @NotNull kotlin.coroutines.e<?> eVar, boolean z5) {
        try {
            if (kotlin.jvm.internal.g0.g(this._state, f.f48548b) && kotlin.jvm.internal.g0.g(str, f.f48548b) && z5) {
                this.f48536d++;
            } else if (this.f48536d > 0 && kotlin.jvm.internal.g0.g(str, f.f48549c)) {
                this.f48536d--;
                return;
            }
            if (kotlin.jvm.internal.g0.g(this._state, str) && kotlin.jvm.internal.g0.g(str, f.f48549c) && e() != null) {
                return;
            }
            this._state = str;
            h(eVar instanceof kotlin.coroutines.jvm.internal.c ? (kotlin.coroutines.jvm.internal.c) eVar : null);
            this.lastObservedThread = kotlin.jvm.internal.g0.g(str, f.f48548b) ? Thread.currentThread() : null;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final List<StackTraceElement> b() {
        k kVar = this.f48533a;
        return kVar == null ? f0.J() : p.I3(p.b(new a(kVar, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x004a -> B:11:0x0061). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005b -> B:10:0x005e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j(kotlin.sequences.o<? super java.lang.StackTraceElement> r6, kotlin.coroutines.jvm.internal.c r7, kotlin.coroutines.e<? super kotlin.n1> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.debug.internal.e.b
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.debug.internal.e$b r0 = (kotlinx.coroutines.debug.internal.e.b) r0
            int r1 = r0.f48546f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48546f = r1
            goto L18
        L13:
            kotlinx.coroutines.debug.internal.e$b r0 = new kotlinx.coroutines.debug.internal.e$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f48544d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48546f
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.f48543c
            kotlin.coroutines.jvm.internal.c r6 = (kotlin.coroutines.jvm.internal.c) r6
            java.lang.Object r7 = r0.f48542b
            kotlin.sequences.o r7 = (kotlin.sequences.o) r7
            java.lang.Object r2 = r0.f48541a
            kotlinx.coroutines.debug.internal.e r2 = (kotlinx.coroutines.debug.internal.e) r2
            kotlin.g0.n(r8)
            goto L5e
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            kotlin.g0.n(r8)
            r2 = r5
        L41:
            if (r7 != 0) goto L46
            kotlin.n1 r6 = kotlin.n1.f44123a
            return r6
        L46:
            java.lang.StackTraceElement r8 = r7.getStackTraceElement()
            if (r8 == 0) goto L61
            r0.f48541a = r2
            r0.f48542b = r6
            r0.f48543c = r7
            r0.f48546f = r3
            java.lang.Object r8 = r6.c(r8, r0)
            if (r8 != r1) goto L5b
            return r1
        L5b:
            r4 = r7
            r7 = r6
            r6 = r4
        L5e:
            r4 = r7
            r7 = r6
            r6 = r4
        L61:
            kotlin.coroutines.jvm.internal.c r7 = r7.getCallerFrame()
            if (r7 == 0) goto L68
            goto L41
        L68:
            kotlin.n1 r6 = kotlin.n1.f44123a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.e.j(kotlin.sequences.o, kotlin.coroutines.jvm.internal.c, kotlin.coroutines.e):java.lang.Object");
    }

    @Nullable
    public final k c() {
        return this.f48533a;
    }

    @Nullable
    public final kotlin.coroutines.jvm.internal.c e() {
        WeakReference<kotlin.coroutines.jvm.internal.c> weakReference = this._lastObservedFrame;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @NotNull
    public final String f() {
        return this._state;
    }

    @Nullable
    public final kotlin.coroutines.i getContext() {
        return this.f48535c.get();
    }

    public final void h(@Nullable kotlin.coroutines.jvm.internal.c cVar) {
        this._lastObservedFrame = cVar != null ? new WeakReference<>(cVar) : null;
    }

    @NotNull
    public String toString() {
        return "DebugCoroutineInfo(state=" + f() + ",context=" + getContext() + ')';
    }

    public e(@Nullable kotlin.coroutines.i iVar, @Nullable k kVar, long j6) {
        this.f48533a = kVar;
        this.f48534b = j6;
        this.f48535c = new WeakReference<>(iVar);
    }

    @NotNull
    public final List<StackTraceElement> d() {
        return b();
    }

    @NotNull
    public final List<StackTraceElement> g() {
        kotlin.coroutines.jvm.internal.c e6 = e();
        if (e6 == null) {
            return f0.J();
        }
        ArrayList arrayList = new ArrayList();
        while (e6 != null) {
            StackTraceElement stackTraceElement = e6.getStackTraceElement();
            if (stackTraceElement != null) {
                arrayList.add(stackTraceElement);
            }
            e6 = e6.getCallerFrame();
        }
        return arrayList;
    }
}
