package kotlinx.coroutines.channels;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.f0;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.internal.s0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,414:1\n15#2:415\n15#2:416\n15#2:420\n15#2:423\n15#2:429\n15#2:430\n15#2:436\n15#2:439\n15#2:440\n15#2:441\n766#3:417\n857#3,2:418\n1855#3,2:421\n1747#3,3:424\n1855#3,2:427\n1855#3,2:431\n766#3:433\n857#3,2:434\n1855#3,2:437\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl\n*L\n166#1:415\n188#1:416\n213#1:420\n237#1:423\n279#1:429\n331#1:430\n343#1:436\n355#1:439\n382#1:440\n394#1:441\n189#1:417\n189#1:418,2\n226#1:421,2\n242#1:424,3\n251#1:427,2\n333#1:431,2\n338#1:433\n338#1:434,2\n346#1:437,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e<E> extends BufferedChannel<E> implements kotlinx.coroutines.channels.d<E> {

    /* renamed from: m, reason: collision with root package name */
    private final int f48170m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private final ReentrantLock f48171n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private List<? extends BufferedChannel<E>> f48172o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    private Object f48173p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private final HashMap<kotlinx.coroutines.selects.m<?>, Object> f48174q;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n*L\n1#1,414:1\n15#2:415\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered\n*L\n362#1:415\n*E\n"})
    private final class a extends BufferedChannel<E> {
        public a() {
            super(e.this.K1(), null, 2, 0 == true ? 1 : 0);
        }

        @Override // kotlinx.coroutines.channels.BufferedChannel
        /* renamed from: H1, reason: merged with bridge method [inline-methods] */
        public boolean M(@Nullable Throwable th) {
            ReentrantLock reentrantLock = ((e) e.this).f48171n;
            e<E> eVar = e.this;
            reentrantLock.lock();
            try {
                eVar.P1(this);
                return super.M(th);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class b extends u<E> {
        public b() {
            super(1, BufferOverflow.DROP_OLDEST, null, 4, null);
        }

        @Override // kotlinx.coroutines.channels.BufferedChannel
        /* renamed from: M1, reason: merged with bridge method [inline-methods] */
        public boolean M(@Nullable Throwable th) {
            e.this.P1(this);
            return super.M(th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2", f = "BroadcastChannel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPEN_TIMEOUT}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$registerSelectForSend$2\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,414:1\n15#2:415\n1#3:416\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$registerSelectForSend$2\n*L\n304#1:415\n*E\n"})
    static final class c extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48177a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e<E> f48178b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f48179c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.selects.m<?> f48180d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(e<E> eVar, Object obj, kotlinx.coroutines.selects.m<?> mVar, kotlin.coroutines.e<? super c> eVar2) {
            super(2, eVar2);
            this.f48178b = eVar;
            this.f48179c = obj;
            this.f48180d = mVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            return new c(this.f48178b, this.f48179c, this.f48180d, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull r0 r0Var, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((c) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object z5;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f48177a;
            boolean z6 = true;
            try {
                if (i6 != 0) {
                    if (i6 == 1) {
                        g0.n(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    g0.n(obj);
                    e<E> eVar = this.f48178b;
                    Object obj2 = this.f48179c;
                    this.f48177a = 1;
                    if (eVar.T(obj2, this) == l6) {
                        return l6;
                    }
                }
            } catch (Throwable th) {
                if (this.f48178b.z() && ((th instanceof ClosedSendChannelException) || this.f48178b.n0() == th)) {
                    z6 = false;
                } else {
                    throw th;
                }
            }
            ReentrantLock reentrantLock = ((e) this.f48178b).f48171n;
            e<E> eVar2 = this.f48178b;
            kotlinx.coroutines.selects.m<?> mVar = this.f48180d;
            reentrantLock.lock();
            try {
                HashMap hashMap = ((e) eVar2).f48174q;
                if (z6) {
                    z5 = n1.f44123a;
                } else {
                    z5 = i.z();
                }
                hashMap.put(mVar, z5);
                kotlin.jvm.internal.g0.n(mVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
                n1 n1Var = n1.f44123a;
                if (((kotlinx.coroutines.selects.l) mVar).K(eVar2, n1Var) != TrySelectDetailedResult.REREGISTER) {
                    ((e) eVar2).f48174q.remove(mVar);
                }
                reentrantLock.unlock();
                return n1Var;
            } catch (Throwable th2) {
                reentrantLock.unlock();
                throw th2;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastChannelImpl", f = "BroadcastChannel.kt", i = {0, 0}, l = {230}, m = "send", n = {"this", "element"}, s = {"L$0", "L$1"})
    static final class d extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48181a;

        /* renamed from: b, reason: collision with root package name */
        Object f48182b;

        /* renamed from: c, reason: collision with root package name */
        Object f48183c;

        /* renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f48184d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ e<E> f48185e;

        /* renamed from: f, reason: collision with root package name */
        int f48186f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(e<E> eVar, kotlin.coroutines.e<? super d> eVar2) {
            super(eVar2);
            this.f48185e = eVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48184d = obj;
            this.f48186f |= Integer.MIN_VALUE;
            return this.f48185e.T(null, this);
        }
    }

    public e(int i6) {
        super(0, null);
        s0 s0Var;
        this.f48170m = i6;
        if (i6 < 1 && i6 != -1) {
            throw new IllegalArgumentException(("BroadcastChannel capacity must be positive or Channel.CONFLATED, but " + i6 + " was specified").toString());
        }
        this.f48171n = new ReentrantLock();
        this.f48172o = f0.J();
        s0Var = f.f48188a;
        this.f48173p = s0Var;
        this.f48174q = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void P1(b0<? extends E> b0Var) {
        ReentrantLock reentrantLock = this.f48171n;
        reentrantLock.lock();
        try {
            List<? extends BufferedChannel<E>> list = this.f48172o;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((BufferedChannel) obj) != b0Var) {
                    arrayList.add(obj);
                }
            }
            this.f48172o = arrayList;
            n1 n1Var = n1.f44123a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final int K1() {
        return this.f48170m;
    }

    public final E L1() {
        s0 s0Var;
        ReentrantLock reentrantLock = this.f48171n;
        reentrantLock.lock();
        try {
            if (z()) {
                Throwable f02 = f0();
                if (f02 == null) {
                    throw new IllegalStateException("This broadcast channel is closed");
                }
                throw f02;
            }
            Object obj = this.f48173p;
            s0Var = f.f48188a;
            if (obj == s0Var) {
                throw new IllegalStateException("No value");
            }
            E e6 = (E) this.f48173p;
            reentrantLock.unlock();
            return e6;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean M(@Nullable Throwable th) {
        s0 s0Var;
        ReentrantLock reentrantLock = this.f48171n;
        reentrantLock.lock();
        try {
            Iterator<T> it = this.f48172o.iterator();
            while (it.hasNext()) {
                ((BufferedChannel) it.next()).M(th);
            }
            s0Var = f.f48188a;
            this.f48173p = s0Var;
            boolean M = super.M(th);
            reentrantLock.unlock();
            return M;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    @Nullable
    public final E N1() {
        s0 s0Var;
        ReentrantLock reentrantLock = this.f48171n;
        reentrantLock.lock();
        try {
            E e6 = null;
            if (!D()) {
                Object obj = this.f48173p;
                s0Var = f.f48188a;
                if (obj != s0Var) {
                    e6 = (E) this.f48173p;
                }
            }
            return e6;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.c0
    public boolean S(@Nullable Throwable th) {
        ReentrantLock reentrantLock = this.f48171n;
        reentrantLock.lock();
        try {
            Iterator<T> it = this.f48172o.iterator();
            while (it.hasNext()) {
                ((BufferedChannel) it.next()).S(th);
            }
            List<? extends BufferedChannel<E>> list = this.f48172o;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((BufferedChannel) obj).p0()) {
                    arrayList.add(obj);
                }
            }
            this.f48172o = arrayList;
            boolean S = super.S(th);
            reentrantLock.unlock();
            return S;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007d -> B:10:0x0080). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.c0
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object T(E r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.e.d
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.e$d r0 = (kotlinx.coroutines.channels.e.d) r0
            int r1 = r0.f48186f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48186f = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.e$d r0 = new kotlinx.coroutines.channels.e$d
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f48184d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48186f
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r7 = r0.f48183c
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.f48182b
            java.lang.Object r4 = r0.f48181a
            kotlinx.coroutines.channels.e r4 = (kotlinx.coroutines.channels.e) r4
            kotlin.g0.n(r8)
            goto L80
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            kotlin.g0.n(r8)
            java.util.concurrent.locks.ReentrantLock r8 = r6.f48171n
            r8.lock()
            boolean r2 = r6.z()     // Catch: java.lang.Throwable -> L51
            if (r2 != 0) goto L99
            int r2 = r6.f48170m     // Catch: java.lang.Throwable -> L51
            r4 = -1
            if (r2 != r4) goto L53
            r6.f48173p = r7     // Catch: java.lang.Throwable -> L51
            goto L53
        L51:
            r7 = move-exception
            goto L9e
        L53:
            java.util.List<? extends kotlinx.coroutines.channels.BufferedChannel<E>> r2 = r6.f48172o     // Catch: java.lang.Throwable -> L51
            r8.unlock()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r8 = r2.iterator()
            r4 = r8
            r8 = r7
            r7 = r4
            r4 = r6
        L62:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L96
            java.lang.Object r2 = r7.next()
            kotlinx.coroutines.channels.BufferedChannel r2 = (kotlinx.coroutines.channels.BufferedChannel) r2
            r0.f48181a = r4
            r0.f48182b = r8
            r0.f48183c = r7
            r0.f48186f = r3
            java.lang.Object r2 = r2.m1(r8, r0)
            if (r2 != r1) goto L7d
            return r1
        L7d:
            r5 = r2
            r2 = r8
            r8 = r5
        L80:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L94
            boolean r8 = r4.z()
            if (r8 != 0) goto L8f
            goto L94
        L8f:
            java.lang.Throwable r7 = r4.n0()
            throw r7
        L94:
            r8 = r2
            goto L62
        L96:
            kotlin.n1 r7 = kotlin.n1.f44123a
            return r7
        L99:
            java.lang.Throwable r7 = r6.n0()     // Catch: java.lang.Throwable -> L51
            throw r7     // Catch: java.lang.Throwable -> L51
        L9e:
            r8.unlock()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.e.T(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected void g1(@NotNull kotlinx.coroutines.selects.m<?> mVar, @Nullable Object obj) {
        ReentrantLock reentrantLock = this.f48171n;
        reentrantLock.lock();
        try {
            Object remove = this.f48174q.remove(mVar);
            if (remove != null) {
                mVar.f(remove);
                reentrantLock.unlock();
            } else {
                n1 n1Var = n1.f44123a;
                reentrantLock.unlock();
                kotlinx.coroutines.k.f(kotlinx.coroutines.s0.a(mVar.getContext()), null, CoroutineStart.UNDISPATCHED, new c(this, obj, mVar, null), 1, null);
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.d
    @NotNull
    public b0<E> m() {
        s0 s0Var;
        s0 s0Var2;
        ReentrantLock reentrantLock = this.f48171n;
        reentrantLock.lock();
        try {
            a bVar = this.f48170m == -1 ? new b() : new a();
            if (z()) {
                Object obj = this.f48173p;
                s0Var2 = f.f48188a;
                if (obj == s0Var2) {
                    ((BufferedChannel) bVar).S(f0());
                    reentrantLock.unlock();
                    return bVar;
                }
            }
            Object obj2 = this.f48173p;
            s0Var = f.f48188a;
            if (obj2 != s0Var) {
                ((BufferedChannel) bVar).r(L1());
            }
            this.f48172o = f0.J4(this.f48172o, bVar);
            reentrantLock.unlock();
            return bVar;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.c0
    @NotNull
    public Object r(E e6) {
        ReentrantLock reentrantLock = this.f48171n;
        reentrantLock.lock();
        try {
            if (z()) {
                return super.r(e6);
            }
            List<? extends BufferedChannel<E>> list = this.f48172o;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (((BufferedChannel) it.next()).t1()) {
                        return n.f48241b.b();
                    }
                }
            }
            if (this.f48170m == -1) {
                this.f48173p = e6;
            }
            Iterator<T> it2 = this.f48172o.iterator();
            while (it2.hasNext()) {
                ((BufferedChannel) it2.next()).r(e6);
            }
            return n.f48241b.c(n1.f44123a);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    @NotNull
    public String toString() {
        s0 s0Var;
        String str;
        StringBuilder sb = new StringBuilder();
        Object obj = this.f48173p;
        s0Var = f.f48188a;
        if (obj != s0Var) {
            str = "CONFLATED_ELEMENT=" + this.f48173p + "; ";
        } else {
            str = "";
        }
        sb.append(str);
        sb.append("BROADCAST=<");
        sb.append(super.toString());
        sb.append(">; SUBSCRIBERS=");
        sb.append(f0.r3(this.f48172o, ";", "<", ">", 0, null, null, 56, null));
        return sb.toString();
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.c0
    public boolean z() {
        ReentrantLock reentrantLock = this.f48171n;
        reentrantLock.lock();
        try {
            return super.z();
        } finally {
            reentrantLock.unlock();
        }
    }

    public static /* synthetic */ void M1() {
    }

    public static /* synthetic */ void O1() {
    }
}
