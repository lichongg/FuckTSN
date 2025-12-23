package kotlinx.coroutines.flow;

import cn.jpush.android.api.InAppSlotParams;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.internal.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowImpl\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 6 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,428:1\n18#2:429\n18#2:443\n28#3,4:430\n28#3,4:437\n20#4:434\n20#4:441\n13579#5,2:435\n329#6:442\n*S KotlinDebug\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowImpl\n*L\n315#1:429\n396#1:443\n324#1:430,4\n352#1:437,4\n324#1:434\n352#1:441\n348#1:435,2\n385#1:442\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class i0<T> extends kotlinx.coroutines.flow.internal.a<k0> implements t<T>, c<T>, kotlinx.coroutines.flow.internal.p<T> {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f48890f = AtomicReferenceFieldUpdater.newUpdater(i0.class, Object.class, "_state");

    @Volatile
    @Nullable
    private volatile Object _state;

    /* renamed from: e, reason: collision with root package name */
    private int f48891e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_500, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_UNRELIABLE, 401}, m = "collect", n = {"this", "collector", InAppSlotParams.SLOT_KEY.SLOT, "this", "collector", InAppSlotParams.SLOT_KEY.SLOT, "collectorJob", "newState", "this", "collector", InAppSlotParams.SLOT_KEY.SLOT, "collectorJob", "oldState"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48892a;

        /* renamed from: b, reason: collision with root package name */
        Object f48893b;

        /* renamed from: c, reason: collision with root package name */
        Object f48894c;

        /* renamed from: d, reason: collision with root package name */
        Object f48895d;

        /* renamed from: e, reason: collision with root package name */
        Object f48896e;

        /* renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f48897f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ i0<T> f48898g;

        /* renamed from: h, reason: collision with root package name */
        int f48899h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(i0<T> i0Var, kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
            this.f48898g = i0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48897f = obj;
            this.f48899h |= Integer.MIN_VALUE;
            return this.f48898g.collect(null, this);
        }
    }

    private final boolean r(Object obj, Object obj2) {
        int i6;
        k0[] n6;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f48890f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !kotlin.jvm.internal.g0.g(obj3, obj)) {
                return false;
            }
            if (kotlin.jvm.internal.g0.g(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i7 = this.f48891e;
            if ((i7 & 1) != 0) {
                this.f48891e = i7 + 2;
                return true;
            }
            int i8 = i7 + 1;
            this.f48891e = i8;
            k0[] n7 = n();
            n1 n1Var = n1.f44123a;
            while (true) {
                k0[] k0VarArr = n7;
                if (k0VarArr != null) {
                    for (k0 k0Var : k0VarArr) {
                        if (k0Var != null) {
                            k0Var.h();
                        }
                    }
                }
                synchronized (this) {
                    i6 = this.f48891e;
                    if (i6 == i8) {
                        this.f48891e = i8 + 1;
                        return true;
                    }
                    n6 = n();
                    n1 n1Var2 = n1.f44123a;
                }
                n7 = n6;
                i8 = i6;
            }
        }
    }

    @Override // kotlinx.coroutines.flow.s
    public void b() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00bc, code lost:
    
        if (kotlin.jvm.internal.g0.g(r11, r12) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ef, code lost:
    
        if (r12 == r1) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0093, code lost:
    
        if (((kotlinx.coroutines.flow.l0) r11).a(r0) == r1) goto L54;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00b3 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:13:0x003e, B:14:0x00ab, B:16:0x00b3, B:18:0x00b8, B:20:0x00d9, B:22:0x00df, B:26:0x00be, B:29:0x00c5, B:38:0x0060, B:40:0x0073, B:41:0x009c), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b8 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:13:0x003e, B:14:0x00ab, B:16:0x00b3, B:18:0x00b8, B:20:0x00d9, B:22:0x00df, B:26:0x00be, B:29:0x00c5, B:38:0x0060, B:40:0x0073, B:41:0x009c), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00df A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {all -> 0x0043, blocks: (B:13:0x003e, B:14:0x00ab, B:16:0x00b3, B:18:0x00b8, B:20:0x00d9, B:22:0x00df, B:26:0x00be, B:29:0x00c5, B:38:0x0060, B:40:0x0073, B:41:0x009c), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2, types: [kotlinx.coroutines.flow.internal.c] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00dd -> B:14:0x00ab). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00ef -> B:14:0x00ab). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.x, kotlinx.coroutines.flow.i
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.j<? super T> r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<?> r12) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.i0.collect(kotlinx.coroutines.flow.j, kotlin.coroutines.e):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.t
    public boolean compareAndSet(T t5, T t6) {
        if (t5 == null) {
            t5 = (T) kotlinx.coroutines.flow.internal.s.f49029a;
        }
        if (t6 == null) {
            t6 = (T) kotlinx.coroutines.flow.internal.s.f49029a;
        }
        return r(t5, t6);
    }

    @Override // kotlinx.coroutines.flow.t, kotlinx.coroutines.flow.h0
    public T getValue() {
        s0 s0Var = kotlinx.coroutines.flow.internal.s.f49029a;
        T t5 = (T) f48890f.get(this);
        if (t5 == s0Var) {
            return null;
        }
        return t5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.a
    @NotNull
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public k0 i() {
        return new k0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.a
    @NotNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public k0[] j(int i6) {
        return new k0[i6];
    }

    @Override // kotlinx.coroutines.flow.t
    public void setValue(T t5) {
        if (t5 == null) {
            t5 = (T) kotlinx.coroutines.flow.internal.s.f49029a;
        }
        r(null, t5);
    }

    public i0(@NotNull Object obj) {
        this._state = obj;
    }

    @Override // kotlinx.coroutines.flow.x
    @NotNull
    public List<T> a() {
        return kotlin.collections.f0.l(getValue());
    }

    @Override // kotlinx.coroutines.flow.s
    public boolean c(T t5) {
        setValue(t5);
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.p
    @NotNull
    public i<T> e(@NotNull kotlin.coroutines.i iVar, int i6, @NotNull BufferOverflow bufferOverflow) {
        return j0.d(this, iVar, i6, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.s, kotlinx.coroutines.flow.j
    @Nullable
    public Object emit(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        setValue(t5);
        return n1.f44123a;
    }

    public static /* synthetic */ void q() {
    }
}
