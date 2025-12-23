package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@InternalCoroutinesApi
@SourceDebugExtension({"SMAP\nLockFreeLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,367:1\n73#1,3:369\n1#2:368\n*S KotlinDebug\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode\n*L\n134#1:369,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f49319a = AtomicReferenceFieldUpdater.newUpdater(y.class, Object.class, "_next");

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f49320b = AtomicReferenceFieldUpdater.newUpdater(y.class, Object.class, "_prev");

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f49321c = AtomicReferenceFieldUpdater.newUpdater(y.class, Object.class, "_removedRef");

    @Volatile
    @Nullable
    private volatile Object _next = this;

    @Volatile
    @Nullable
    private volatile Object _prev = this;

    @Volatile
    @Nullable
    private volatile Object _removedRef;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @PublishedApi
    public static abstract class a extends kotlinx.coroutines.internal.b<y> {

        /* renamed from: b, reason: collision with root package name */
        @JvmField
        @NotNull
        public final y f49322b;

        /* renamed from: c, reason: collision with root package name */
        @JvmField
        @Nullable
        public y f49323c;

        @Override // kotlinx.coroutines.internal.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void c(@NotNull y yVar, @Nullable Object obj) {
            boolean z5 = obj == null;
            y yVar2 = z5 ? this.f49322b : this.f49323c;
            if (yVar2 != null && androidx.concurrent.futures.a.a(y.f49319a, yVar, this, yVar2) && z5) {
                y yVar3 = this.f49322b;
                y yVar4 = this.f49323c;
                kotlin.jvm.internal.g0.m(yVar4);
                yVar3.m(yVar4);
            }
        }

        public a(@NotNull y yVar) {
            this.f49322b = yVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nLockFreeLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1\n*L\n1#1,367:1\n*E\n"})
    public static final class b extends a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Boolean> f49324d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(y yVar, Function0<Boolean> function0) {
            super(yVar);
            this.f49324d = function0;
        }

        @Override // kotlinx.coroutines.internal.b
        @Nullable
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Object e(@NotNull y yVar) {
            if (this.f49324d.invoke().booleanValue()) {
                return null;
            }
            return x.a();
        }
    }

    @NotNull
    public final y p() {
        y k6 = k(null);
        return k6 == null ? l((y) f49320b.get(this)) : k6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0041, code lost:
    
        if (androidx.concurrent.futures.a.a(r4, r3, r2, ((kotlinx.coroutines.internal.m0) r5).f49283a) != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final kotlinx.coroutines.internal.y k(kotlinx.coroutines.internal.k0 r9) {
        /*
            r8 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.internal.y.f49320b
            java.lang.Object r0 = r0.get(r8)
            kotlinx.coroutines.internal.y r0 = (kotlinx.coroutines.internal.y) r0
            r1 = 0
            r2 = r0
        La:
            r3 = r1
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.internal.y.f49319a
            java.lang.Object r5 = r4.get(r2)
            if (r5 != r8) goto L1f
            if (r0 != r2) goto L16
            goto L28
        L16:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.y.f49320b
            boolean r0 = androidx.concurrent.futures.a.a(r1, r8, r0, r2)
            if (r0 != 0) goto L28
            goto L0
        L1f:
            boolean r6 = r8.q()
            if (r6 == 0) goto L26
            return r1
        L26:
            if (r5 != r9) goto L29
        L28:
            return r2
        L29:
            boolean r6 = r5 instanceof kotlinx.coroutines.internal.k0
            if (r6 == 0) goto L33
            kotlinx.coroutines.internal.k0 r5 = (kotlinx.coroutines.internal.k0) r5
            r5.b(r2)
            goto L0
        L33:
            boolean r6 = r5 instanceof kotlinx.coroutines.internal.m0
            if (r6 == 0) goto L4f
            if (r3 == 0) goto L46
            kotlinx.coroutines.internal.m0 r5 = (kotlinx.coroutines.internal.m0) r5
            kotlinx.coroutines.internal.y r5 = r5.f49283a
            boolean r2 = androidx.concurrent.futures.a.a(r4, r3, r2, r5)
            if (r2 != 0) goto L44
            goto L0
        L44:
            r2 = r3
            goto La
        L46:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.internal.y.f49320b
            java.lang.Object r2 = r4.get(r2)
            kotlinx.coroutines.internal.y r2 = (kotlinx.coroutines.internal.y) r2
            goto Lb
        L4f:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            kotlin.jvm.internal.g0.n(r5, r3)
            r3 = r5
            kotlinx.coroutines.internal.y r3 = (kotlinx.coroutines.internal.y) r3
            r7 = r3
            r3 = r2
            r2 = r7
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.y.k(kotlinx.coroutines.internal.k0):kotlinx.coroutines.internal.y");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(y yVar) {
        y yVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49320b;
        do {
            yVar2 = (y) atomicReferenceFieldUpdater.get(yVar);
            if (n() != yVar) {
                return;
            }
        } while (!androidx.concurrent.futures.a.a(f49320b, yVar, yVar2, this));
        if (q()) {
            yVar.k(null);
        }
    }

    private final m0 w() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49321c;
        m0 m0Var = (m0) atomicReferenceFieldUpdater.get(this);
        if (m0Var != null) {
            return m0Var;
        }
        m0 m0Var2 = new m0(this);
        atomicReferenceFieldUpdater.lazySet(this, m0Var2);
        return m0Var2;
    }

    public final boolean h(@NotNull y yVar, @NotNull Function0<Boolean> function0) {
        int x5;
        b bVar = new b(yVar, function0);
        do {
            x5 = p().x(yVar, this, bVar);
            if (x5 == 1) {
                return true;
            }
        } while (x5 != 2);
        return false;
    }

    @PublishedApi
    public final boolean i(@NotNull y yVar, @NotNull y yVar2) {
        f49320b.lazySet(yVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49319a;
        atomicReferenceFieldUpdater.lazySet(yVar, yVar2);
        if (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, yVar2, yVar)) {
            return false;
        }
        yVar.m(yVar2);
        return true;
    }

    public final boolean j(@NotNull y yVar) {
        f49320b.lazySet(yVar, this);
        f49319a.lazySet(yVar, this);
        while (n() == this) {
            if (androidx.concurrent.futures.a.a(f49319a, this, this, yVar)) {
                yVar.m(this);
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final Object n() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49319a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof k0)) {
                return obj;
            }
            ((k0) obj).b(this);
        }
    }

    @PublishedApi
    @NotNull
    public final a s(@NotNull y yVar, @NotNull Function0<Boolean> function0) {
        return new b(yVar, function0);
    }

    @NotNull
    public String toString() {
        return new PropertyReference0Impl(this) { // from class: kotlinx.coroutines.internal.y.c
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.o
            @Nullable
            public Object get() {
                return kotlinx.coroutines.u0.a(this.receiver);
            }
        } + '@' + kotlinx.coroutines.u0.b(this);
    }

    @PublishedApi
    public final int x(@NotNull y yVar, @NotNull y yVar2, @NotNull a aVar) {
        f49320b.lazySet(yVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49319a;
        atomicReferenceFieldUpdater.lazySet(yVar, yVar2);
        aVar.f49323c = yVar2;
        if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, yVar2, aVar)) {
            return aVar.b(this) == null ? 1 : 2;
        }
        return 0;
    }

    private final y l(y yVar) {
        while (yVar.q()) {
            yVar = (y) f49320b.get(yVar);
        }
        return yVar;
    }

    private final void r(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, n1> function1, Object obj) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    public final void f(@NotNull y yVar) {
        while (!p().i(yVar, this)) {
        }
    }

    @NotNull
    public final y o() {
        return x.f(n());
    }

    public boolean q() {
        return n() instanceof m0;
    }

    @Nullable
    protected y t() {
        m0 m0Var;
        Object n6 = n();
        if (n6 instanceof m0) {
            m0Var = (m0) n6;
        } else {
            m0Var = null;
        }
        if (m0Var == null) {
            return null;
        }
        return m0Var.f49283a;
    }

    public boolean u() {
        if (v() == null) {
            return true;
        }
        return false;
    }

    @PublishedApi
    @Nullable
    public final y v() {
        Object n6;
        y yVar;
        do {
            n6 = n();
            if (n6 instanceof m0) {
                return ((m0) n6).f49283a;
            }
            if (n6 == this) {
                return (y) n6;
            }
            kotlin.jvm.internal.g0.n(n6, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            yVar = (y) n6;
        } while (!androidx.concurrent.futures.a.a(f49319a, this, n6, yVar.w()));
        yVar.k(null);
        return null;
    }

    public final void y(@NotNull y yVar, @NotNull y yVar2) {
    }
}
