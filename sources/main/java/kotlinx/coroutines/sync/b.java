package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.i;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.u0;
import kotlin.n1;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.p0;
import kotlinx.coroutines.internal.s0;
import kotlinx.coroutines.j1;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;
import kotlinx.coroutines.r3;
import kotlinx.coroutines.s;
import kotlinx.coroutines.selects.j;
import kotlinx.coroutines.selects.m;
import kotlinx.coroutines.selects.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n332#2,12:311\n1#3:323\n*S KotlinDebug\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl\n*L\n175#1:311,12\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class b extends kotlinx.coroutines.sync.e implements kotlinx.coroutines.sync.a {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f49598i = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "owner");

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final Function3<m<?>, Object, Object, Function1<Throwable, n1>> f49599h;

    @Volatile
    @Nullable
    private volatile Object owner;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n1#2:311\n*E\n"})
    private final class a implements p<n1>, r3 {

        /* renamed from: a, reason: collision with root package name */
        @JvmField
        @NotNull
        public final q<n1> f49600a;

        /* renamed from: b, reason: collision with root package name */
        @JvmField
        @Nullable
        public final Object f49601b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlinx.coroutines.sync.b$a$a, reason: collision with other inner class name */
        static final class C0958a extends Lambda implements Function1<Throwable, n1> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f49603a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f49604b;

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ n1 invoke(Throwable th) {
                invoke2(th);
                return n1.f44123a;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0958a(b bVar, a aVar) {
                super(1);
                this.f49603a = bVar;
                this.f49604b = aVar;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable th) {
                this.f49603a.unlock(this.f49604b.f49601b);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner$tryResume$token$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n1#2:311\n*E\n"})
        /* renamed from: kotlinx.coroutines.sync.b$a$b, reason: collision with other inner class name */
        static final class C0959b extends Lambda implements Function1<Throwable, n1> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f49605a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f49606b;

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ n1 invoke(Throwable th) {
                invoke2(th);
                return n1.f44123a;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0959b(b bVar, a aVar) {
                super(1);
                this.f49605a = bVar;
                this.f49606b = aVar;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable th) {
                b.f49598i.set(this.f49605a, this.f49606b.f49601b);
                this.f49605a.unlock(this.f49606b.f49601b);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull q<? super n1> qVar, @Nullable Object obj) {
            this.f49600a = qVar;
            this.f49601b = obj;
        }

        @Override // kotlinx.coroutines.p
        @InternalCoroutinesApi
        public void B(@NotNull Object obj) {
            this.f49600a.B(obj);
        }

        @Override // kotlinx.coroutines.p
        public void I(@NotNull Function1<? super Throwable, n1> function1) {
            this.f49600a.I(function1);
        }

        @Override // kotlinx.coroutines.p
        @InternalCoroutinesApi
        @Nullable
        public Object J(@NotNull Throwable th) {
            return this.f49600a.J(th);
        }

        @Override // kotlinx.coroutines.p
        @InternalCoroutinesApi
        public void Q() {
            this.f49600a.Q();
        }

        @Override // kotlinx.coroutines.p
        public boolean a(@Nullable Throwable th) {
            return this.f49600a.a(th);
        }

        @Override // kotlinx.coroutines.r3
        public void b(@NotNull p0<?> p0Var, int i6) {
            this.f49600a.b(p0Var, i6);
        }

        @Override // kotlinx.coroutines.p
        @ExperimentalCoroutinesApi
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void P(@NotNull m0 m0Var, @NotNull n1 n1Var) {
            this.f49600a.P(m0Var, n1Var);
        }

        @Override // kotlinx.coroutines.p
        @InternalCoroutinesApi
        @Nullable
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Object C(@NotNull n1 n1Var, @Nullable Object obj) {
            return this.f49600a.C(n1Var, obj);
        }

        @Override // kotlinx.coroutines.p
        @Nullable
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Object O(@NotNull n1 n1Var, @Nullable Object obj, @Nullable Function1<? super Throwable, n1> function1) {
            Object O = this.f49600a.O(n1Var, obj, new C0959b(b.this, this));
            if (O != null) {
                b.f49598i.set(b.this, this.f49601b);
            }
            return O;
        }

        @Override // kotlin.coroutines.e
        @NotNull
        public i getContext() {
            return this.f49600a.getContext();
        }

        @Override // kotlinx.coroutines.p
        @ExperimentalCoroutinesApi
        public void h(@NotNull m0 m0Var, @NotNull Throwable th) {
            this.f49600a.h(m0Var, th);
        }

        @Override // kotlinx.coroutines.p
        public boolean isActive() {
            return this.f49600a.isActive();
        }

        @Override // kotlinx.coroutines.p
        public boolean isCancelled() {
            return this.f49600a.isCancelled();
        }

        @Override // kotlinx.coroutines.p
        public boolean isCompleted() {
            return this.f49600a.isCompleted();
        }

        @Override // kotlin.coroutines.e
        public void resumeWith(@NotNull Object obj) {
            this.f49600a.resumeWith(obj);
        }

        @Override // kotlinx.coroutines.p
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void o(@NotNull n1 n1Var, @Nullable Function1<? super Throwable, n1> function1) {
            b.f49598i.set(b.this, this.f49601b);
            this.f49600a.o(n1Var, new C0958a(b.this, this));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl$SelectInstanceWithOwner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n1#2:311\n*E\n"})
    /* renamed from: kotlinx.coroutines.sync.b$b, reason: collision with other inner class name */
    private final class C0960b<Q> implements n<Q> {

        /* renamed from: a, reason: collision with root package name */
        @JvmField
        @NotNull
        public final n<Q> f49607a;

        /* renamed from: b, reason: collision with root package name */
        @JvmField
        @Nullable
        public final Object f49608b;

        public C0960b(@NotNull n<Q> nVar, @Nullable Object obj) {
            this.f49607a = nVar;
            this.f49608b = obj;
        }

        @Override // kotlinx.coroutines.r3
        public void b(@NotNull p0<?> p0Var, int i6) {
            this.f49607a.b(p0Var, i6);
        }

        @Override // kotlinx.coroutines.selects.m
        @NotNull
        public i getContext() {
            return this.f49607a.getContext();
        }

        @Override // kotlinx.coroutines.selects.m
        public void h(@NotNull j1 j1Var) {
            this.f49607a.h(j1Var);
        }

        @Override // kotlinx.coroutines.selects.m
        public boolean j(@NotNull Object obj, @Nullable Object obj2) {
            boolean j6 = this.f49607a.j(obj, obj2);
            b bVar = b.this;
            if (j6) {
                b.f49598i.set(bVar, this.f49608b);
            }
            return j6;
        }

        @Override // kotlinx.coroutines.selects.m
        public void f(@Nullable Object obj) {
            b.f49598i.set(b.this, this.f49608b);
            this.f49607a.f(obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* synthetic */ class c extends FunctionReferenceImpl implements Function3<b, m<?>, Object, n1> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f49610a = new c();

        c() {
            super(3, b.class, "onLockRegFunction", "onLockRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ n1 invoke(b bVar, m<?> mVar, Object obj) {
            c(bVar, mVar, obj);
            return n1.f44123a;
        }

        public final void c(@NotNull b bVar, @NotNull m<?> mVar, @Nullable Object obj) {
            bVar.w(mVar, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* synthetic */ class d extends FunctionReferenceImpl implements Function3<b, Object, Object, Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f49611a = new d();

        d() {
            super(3, b.class, "onLockProcessResult", "onLockProcessResult(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull b bVar, @Nullable Object obj, @Nullable Object obj2) {
            return bVar.v(obj, obj2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class e extends Lambda implements Function3<m<?>, Object, Object, Function1<? super Throwable, ? extends n1>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class a extends Lambda implements Function1<Throwable, n1> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f49613a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Object f49614b;

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ n1 invoke(Throwable th) {
                invoke2(th);
                return n1.f44123a;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(b bVar, Object obj) {
                super(1);
                this.f49613a = bVar;
                this.f49614b = obj;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable th) {
                this.f49613a.unlock(this.f49614b);
            }
        }

        e() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Function1<Throwable, n1> invoke(@NotNull m<?> mVar, @Nullable Object obj, @Nullable Object obj2) {
            return new a(b.this, obj);
        }
    }

    public b(boolean z5) {
        super(1, z5 ? 1 : 0);
        this.owner = z5 ? null : kotlinx.coroutines.sync.c.f49615a;
        this.f49599h = new e();
    }

    @Override // kotlinx.coroutines.sync.a
    @NotNull
    public kotlinx.coroutines.selects.i<Object, kotlinx.coroutines.sync.a> getOnLock() {
        c cVar = c.f49610a;
        g0.n(cVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) u0.q(cVar, 3);
        d dVar = d.f49611a;
        g0.n(dVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new j(this, function3, (Function3) u0.q(dVar, 3), this.f49599h);
    }

    @NotNull
    public String toString() {
        return "Mutex@" + kotlinx.coroutines.u0.b(this) + "[isLocked=" + isLocked() + ",owner=" + f49598i.get(this) + ']';
    }

    protected void w(@NotNull m<?> mVar, @Nullable Object obj) {
        s0 s0Var;
        if (obj == null || !holdsLock(obj)) {
            g0.n(mVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
            m(new C0960b((n) mVar, obj), obj);
        } else {
            s0Var = kotlinx.coroutines.sync.c.f49616b;
            mVar.f(s0Var);
        }
    }

    private final int s(Object obj) {
        s0 s0Var;
        while (isLocked()) {
            Object obj2 = f49598i.get(this);
            s0Var = kotlinx.coroutines.sync.c.f49615a;
            if (obj2 != s0Var) {
                if (obj2 == obj) {
                    return 1;
                }
                return 2;
            }
        }
        return 0;
    }

    static /* synthetic */ Object t(b bVar, Object obj, kotlin.coroutines.e<? super n1> eVar) {
        if (bVar.tryLock(obj)) {
            return n1.f44123a;
        }
        Object u5 = bVar.u(obj, eVar);
        if (u5 == kotlin.coroutines.intrinsics.a.l()) {
            return u5;
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object u(Object obj, kotlin.coroutines.e<? super n1> eVar) {
        q b6 = s.b(kotlin.coroutines.intrinsics.a.e(eVar));
        try {
            g(new a(b6, obj));
            Object x5 = b6.x();
            if (x5 == kotlin.coroutines.intrinsics.a.l()) {
                kotlin.coroutines.jvm.internal.e.c(eVar);
            }
            if (x5 == kotlin.coroutines.intrinsics.a.l()) {
                return x5;
            }
            return n1.f44123a;
        } catch (Throwable th) {
            b6.N();
            throw th;
        }
    }

    private final int x(Object obj) {
        while (!a()) {
            if (obj == null) {
                return 1;
            }
            int s5 = s(obj);
            if (s5 == 1) {
                return 2;
            }
            if (s5 == 2) {
                return 1;
            }
        }
        f49598i.set(this, obj);
        return 0;
    }

    @Override // kotlinx.coroutines.sync.a
    public boolean holdsLock(@NotNull Object obj) {
        if (s(obj) == 1) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.sync.a
    public boolean isLocked() {
        if (b() == 0) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.sync.a
    @Nullable
    public Object lock(@Nullable Object obj, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return t(this, obj, eVar);
    }

    @Override // kotlinx.coroutines.sync.a
    public boolean tryLock(@Nullable Object obj) {
        int x5 = x(obj);
        if (x5 == 0) {
            return true;
        }
        if (x5 != 1) {
            if (x5 != 2) {
                throw new IllegalStateException("unexpected");
            }
            throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
        }
        return false;
    }

    @Override // kotlinx.coroutines.sync.a
    public void unlock(@Nullable Object obj) {
        s0 s0Var;
        s0 s0Var2;
        while (isLocked()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49598i;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            s0Var = kotlinx.coroutines.sync.c.f49615a;
            if (obj2 != s0Var) {
                if (obj2 == obj || obj == null) {
                    s0Var2 = kotlinx.coroutines.sync.c.f49615a;
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj2, s0Var2)) {
                        release();
                        return;
                    }
                } else {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    @Nullable
    protected Object v(@Nullable Object obj, @Nullable Object obj2) {
        s0 s0Var;
        s0Var = kotlinx.coroutines.sync.c.f49616b;
        if (!g0.g(obj2, s0Var)) {
            return this;
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    public static /* synthetic */ void r() {
    }
}
