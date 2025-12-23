package kotlinx.coroutines.selects;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.collections.f0;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.internal.p0;
import kotlinx.coroutines.internal.s0;
import kotlinx.coroutines.j1;
import kotlinx.coroutines.selects.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@PublishedApi
@SourceDebugExtension({"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 6 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,873:1\n1#2:874\n2624#3,3:875\n1855#3,2:888\n1855#3,2:896\n1855#3,2:898\n314#4,9:878\n323#4,2:890\n19#5:887\n153#6,4:892\n*S KotlinDebug\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n*L\n505#1:875,3\n569#1:888,2\n726#1:896,2\n751#1:898,2\n545#1:878,9\n545#1:890,2\n561#1:887\n711#1:892,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class l<R> extends kotlinx.coroutines.n implements kotlinx.coroutines.selects.c<R>, n<R> {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f49550f = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "state");

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.coroutines.i f49551a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private List<l<R>.a> f49552b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private Object f49553c;

    /* renamed from: d, reason: collision with root package name */
    private int f49554d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private Object f49555e;

    @Volatile
    @Nullable
    private volatile Object state;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation$ClauseData\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,873:1\n1#2:874\n*E\n"})
    public final class a {

        /* renamed from: a, reason: collision with root package name */
        @JvmField
        @NotNull
        public final Object f49556a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final Function3<Object, m<?>, Object, n1> f49557b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        private final Function3<Object, Object, Object, Object> f49558c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private final Object f49559d;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        private final Object f49560e;

        /* renamed from: f, reason: collision with root package name */
        @JvmField
        @Nullable
        public final Function3<m<?>, Object, Object, Function1<Throwable, n1>> f49561f;

        /* renamed from: g, reason: collision with root package name */
        @JvmField
        @Nullable
        public Object f49562g;

        /* renamed from: h, reason: collision with root package name */
        @JvmField
        public int f49563h = -1;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull Object obj, @NotNull Function3<Object, ? super m<?>, Object, n1> function3, @NotNull Function3<Object, Object, Object, ? extends Object> function32, @Nullable Object obj2, @NotNull Object obj3, @Nullable Function3<? super m<?>, Object, Object, ? extends Function1<? super Throwable, n1>> function33) {
            this.f49556a = obj;
            this.f49557b = function3;
            this.f49558c = function32;
            this.f49559d = obj2;
            this.f49560e = obj3;
            this.f49561f = function33;
        }

        @Nullable
        public final Function1<Throwable, n1> a(@NotNull m<?> mVar, @Nullable Object obj) {
            Function3<m<?>, Object, Object, Function1<Throwable, n1>> function3 = this.f49561f;
            if (function3 != null) {
                return function3.invoke(mVar, this.f49559d, obj);
            }
            return null;
        }

        public final void b() {
            Object obj = this.f49562g;
            l<R> lVar = l.this;
            if (obj instanceof p0) {
                ((p0) obj).q(this.f49563h, null, lVar.getContext());
                return;
            }
            j1 j1Var = obj instanceof j1 ? (j1) obj : null;
            if (j1Var != null) {
                j1Var.dispose();
            }
        }

        @Nullable
        public final Object c(@Nullable Object obj, @NotNull kotlin.coroutines.e<? super R> eVar) {
            Object obj2 = this.f49560e;
            if (this.f49559d == o.l()) {
                g0.n(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                return ((Function1) obj2).invoke(eVar);
            }
            g0.n(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((Function2) obj2).invoke(obj, eVar);
        }

        @Nullable
        public final Object d(@Nullable Object obj) {
            return this.f49558c.invoke(this.f49556a, this.f49559d, obj);
        }

        public final boolean e(@NotNull l<R> lVar) {
            s0 s0Var;
            this.f49557b.invoke(this.f49556a, lVar, this.f49559d);
            Object obj = ((l) lVar).f49555e;
            s0Var = o.f49580i;
            return obj == s0Var;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", i = {0}, l = {org.apache.commons.net.ftp.l.S, 434}, m = "doSelectSuspend", n = {"this"}, s = {"L$0"})
    static final class b extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f49565a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f49566b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ l<R> f49567c;

        /* renamed from: d, reason: collision with root package name */
        int f49568d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(l<R> lVar, kotlin.coroutines.e<? super b> eVar) {
            super(eVar);
            this.f49567c = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f49566b = obj;
            this.f49568d |= Integer.MIN_VALUE;
            return this.f49567c.A(this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_DOLBY_MIX_LEVEL}, m = "processResultAndInvokeBlockRecoveringException", n = {}, s = {})
    static final class c extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f49569a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ l<R> f49570b;

        /* renamed from: c, reason: collision with root package name */
        int f49571c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(l<R> lVar, kotlin.coroutines.e<? super c> eVar) {
            super(eVar);
            this.f49570b = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f49569a = obj;
            this.f49571c |= Integer.MIN_VALUE;
            return this.f49570b.G(null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object A(kotlin.coroutines.e<? super R> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.selects.l.b
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.selects.l$b r0 = (kotlinx.coroutines.selects.l.b) r0
            int r1 = r0.f49568d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49568d = r1
            goto L18
        L13:
            kotlinx.coroutines.selects.l$b r0 = new kotlinx.coroutines.selects.l$b
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f49566b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f49568d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.g0.n(r6)
            return r6
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            java.lang.Object r2 = r0.f49565a
            kotlinx.coroutines.selects.l r2 = (kotlinx.coroutines.selects.l) r2
            kotlin.g0.n(r6)
            goto L4b
        L3c:
            kotlin.g0.n(r6)
            r0.f49565a = r5
            r0.f49568d = r4
            java.lang.Object r6 = r5.N(r0)
            if (r6 != r1) goto L4a
            goto L56
        L4a:
            r2 = r5
        L4b:
            r6 = 0
            r0.f49565a = r6
            r0.f49568d = r3
            java.lang.Object r6 = r2.x(r0)
            if (r6 != r1) goto L57
        L56:
            return r1
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.l.A(kotlin.coroutines.e):java.lang.Object");
    }

    private final l<R>.a B(Object obj) {
        List<l<R>.a> list = this.f49552b;
        Object obj2 = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((a) next).f49556a == obj) {
                obj2 = next;
                break;
            }
        }
        l<R>.a aVar = (a) obj2;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean C() {
        s0 s0Var;
        Object obj = f49550f.get(this);
        s0Var = o.f49577f;
        return obj == s0Var || (obj instanceof List);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean D() {
        s0 s0Var;
        Object obj = f49550f.get(this);
        s0Var = o.f49579h;
        return obj == s0Var;
    }

    private final boolean E() {
        return f49550f.get(this) instanceof a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object G(kotlinx.coroutines.selects.l<R>.a r5, java.lang.Object r6, kotlin.coroutines.e<? super R> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.selects.l.c
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.selects.l$c r0 = (kotlinx.coroutines.selects.l.c) r0
            int r1 = r0.f49571c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49571c = r1
            goto L18
        L13:
            kotlinx.coroutines.selects.l$c r0 = new kotlinx.coroutines.selects.l$c
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f49569a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f49571c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.g0.n(r7)
            return r7
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.g0.n(r7)
            java.lang.Object r6 = r5.d(r6)
            r0.f49571c = r3
            java.lang.Object r5 = r5.c(r6, r0)
            if (r5 != r1) goto L41
            return r1
        L41:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.l.G(kotlinx.coroutines.selects.l$a, java.lang.Object, kotlin.coroutines.e):java.lang.Object");
    }

    public static /* synthetic */ void I(l lVar, a aVar, boolean z5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
        }
        if ((i6 & 1) != 0) {
            z5 = false;
        }
        lVar.H(aVar, z5);
    }

    private final int L(Object obj, Object obj2) {
        boolean o5;
        s0 s0Var;
        s0 s0Var2;
        s0 s0Var3;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49550f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof kotlinx.coroutines.p) {
                l<R>.a B = B(obj);
                if (B == null) {
                    continue;
                } else {
                    Function1<Throwable, n1> a6 = B.a(this, obj2);
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj3, B)) {
                        this.f49555e = obj2;
                        o5 = o.o((kotlinx.coroutines.p) obj3, a6);
                        if (o5) {
                            return 0;
                        }
                        this.f49555e = null;
                        return 2;
                    }
                }
            } else {
                s0Var = o.f49578g;
                if (g0.g(obj3, s0Var) ? true : obj3 instanceof a) {
                    return 3;
                }
                s0Var2 = o.f49579h;
                if (g0.g(obj3, s0Var2)) {
                    return 2;
                }
                s0Var3 = o.f49577f;
                if (g0.g(obj3, s0Var3)) {
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj3, f0.l(obj))) {
                        return 1;
                    }
                } else {
                    if (!(obj3 instanceof List)) {
                        throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj3, f0.J4((Collection) obj3, obj))) {
                        return 1;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0062, code lost:
    
        r0 = r0.x();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
    
        if (r0 != kotlin.coroutines.intrinsics.a.l()) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
    
        kotlin.coroutines.jvm.internal.e.c(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0073, code lost:
    
        if (r0 != kotlin.coroutines.intrinsics.a.l()) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0078, code lost:
    
        return kotlin.n1.f44123a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object N(kotlin.coroutines.e<? super kotlin.n1> r6) {
        /*
            r5 = this;
            kotlinx.coroutines.q r0 = new kotlinx.coroutines.q
            kotlin.coroutines.e r1 = kotlin.coroutines.intrinsics.a.e(r6)
            r2 = 1
            r0.<init>(r1, r2)
            r0.Q()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = q()
        L11:
            java.lang.Object r2 = r1.get(r5)
            kotlinx.coroutines.internal.s0 r3 = kotlinx.coroutines.selects.o.j()
            if (r2 != r3) goto L29
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = q()
            boolean r2 = androidx.concurrent.futures.a.a(r3, r5, r2, r0)
            if (r2 == 0) goto L11
            r0.I(r5)
            goto L62
        L29:
            boolean r3 = r2 instanceof java.util.List
            if (r3 == 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = q()
            kotlinx.coroutines.internal.s0 r4 = kotlinx.coroutines.selects.o.j()
            boolean r3 = androidx.concurrent.futures.a.a(r3, r5, r2, r4)
            if (r3 == 0) goto L11
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L41:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L11
            java.lang.Object r3 = r2.next()
            t(r5, r3)
            goto L41
        L4f:
            boolean r1 = r2 instanceof kotlinx.coroutines.selects.l.a
            if (r1 == 0) goto L79
            kotlin.n1 r1 = kotlin.n1.f44123a
            kotlinx.coroutines.selects.l$a r2 = (kotlinx.coroutines.selects.l.a) r2
            java.lang.Object r3 = p(r5)
            kotlin.jvm.functions.Function1 r2 = r2.a(r5, r3)
            r0.o(r1, r2)
        L62:
            java.lang.Object r0 = r0.x()
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            if (r0 != r1) goto L6f
            kotlin.coroutines.jvm.internal.e.c(r6)
        L6f:
            java.lang.Object r6 = kotlin.coroutines.intrinsics.a.l()
            if (r0 != r6) goto L76
            return r0
        L76:
            kotlin.n1 r6 = kotlin.n1.f44123a
            return r6
        L79:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "unexpected state: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.l.N(kotlin.coroutines.e):java.lang.Object");
    }

    private final void v(Object obj) {
        List<l<R>.a> list = this.f49552b;
        g0.m(list);
        List<l<R>.a> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return;
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).f49556a == obj) {
                throw new IllegalStateException(("Cannot use select clauses on the same object: " + obj).toString());
            }
        }
    }

    private final void w(l<R>.a aVar) {
        s0 s0Var;
        s0 s0Var2;
        List<l<R>.a> list = this.f49552b;
        if (list == null) {
            return;
        }
        for (l<R>.a aVar2 : list) {
            if (aVar2 != aVar) {
                aVar2.b();
            }
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49550f;
        s0Var = o.f49578g;
        atomicReferenceFieldUpdater.set(this, s0Var);
        s0Var2 = o.f49580i;
        this.f49555e = s0Var2;
        this.f49552b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object x(kotlin.coroutines.e<? super R> eVar) {
        Object obj = f49550f.get(this);
        g0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        l<R>.a aVar = (a) obj;
        Object obj2 = this.f49555e;
        w(aVar);
        return aVar.c(aVar.d(obj2), eVar);
    }

    @JvmName(name = "register")
    public final void H(@NotNull l<R>.a aVar, boolean z5) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49550f;
        if (atomicReferenceFieldUpdater.get(this) instanceof a) {
            return;
        }
        if (!z5) {
            v(aVar.f49556a);
        }
        if (!aVar.e(this)) {
            atomicReferenceFieldUpdater.set(this, aVar);
            return;
        }
        if (!z5) {
            List<l<R>.a> list = this.f49552b;
            g0.m(list);
            list.add(aVar);
        }
        aVar.f49562g = this.f49553c;
        aVar.f49563h = this.f49554d;
        this.f49553c = null;
        this.f49554d = -1;
    }

    @Override // kotlinx.coroutines.selects.c
    public void a(@NotNull e eVar, @NotNull Function1<? super kotlin.coroutines.e<? super R>, ? extends Object> function1) {
        I(this, new a(eVar.d(), eVar.c(), eVar.b(), o.l(), function1, eVar.a()), false, 1, null);
    }

    @Override // kotlinx.coroutines.r3
    public void b(@NotNull p0<?> p0Var, int i6) {
        this.f49553c = p0Var;
        this.f49554d = i6;
    }

    @Override // kotlinx.coroutines.selects.c
    public <P, Q> void c(@NotNull i<? super P, ? extends Q> iVar, P p5, @NotNull Function2<? super Q, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2) {
        I(this, new a(iVar.d(), iVar.c(), iVar.b(), p5, function2, iVar.a()), false, 1, null);
    }

    @Override // kotlinx.coroutines.selects.m
    public void f(@Nullable Object obj) {
        this.f49555e = obj;
    }

    @Override // kotlinx.coroutines.selects.m
    @NotNull
    public kotlin.coroutines.i getContext() {
        return this.f49551a;
    }

    @Override // kotlinx.coroutines.selects.m
    public void h(@NotNull j1 j1Var) {
        this.f49553c = j1Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ n1 invoke(Throwable th) {
        l(th);
        return n1.f44123a;
    }

    @Override // kotlinx.coroutines.selects.c
    public <Q> void k(@NotNull g<? extends Q> gVar, @NotNull Function2<? super Q, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2) {
        I(this, new a(gVar.d(), gVar.c(), gVar.b(), null, function2, gVar.a()), false, 1, null);
    }

    @Override // kotlinx.coroutines.o
    public void l(@Nullable Throwable th) {
        Object obj;
        s0 s0Var;
        s0 s0Var2;
        s0 s0Var3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49550f;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            s0Var = o.f49578g;
            if (obj == s0Var) {
                return;
            } else {
                s0Var2 = o.f49579h;
            }
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, s0Var2));
        List<l<R>.a> list = this.f49552b;
        if (list == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b();
        }
        s0Var3 = o.f49580i;
        this.f49555e = s0Var3;
        this.f49552b = null;
    }

    public l(@NotNull kotlin.coroutines.i iVar) {
        s0 s0Var;
        s0 s0Var2;
        this.f49551a = iVar;
        s0Var = o.f49577f;
        this.state = s0Var;
        this.f49552b = new ArrayList(2);
        this.f49554d = -1;
        s0Var2 = o.f49580i;
        this.f49555e = s0Var2;
    }

    private final void F(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, n1> function1, Object obj) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(Object obj) {
        l<R>.a B = B(obj);
        g0.m(B);
        B.f49562g = null;
        B.f49563h = -1;
        H(B, true);
    }

    private final void M(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function1, Object obj) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, obj, obj2, function1.invoke(obj2)));
    }

    @PublishedApi
    static /* synthetic */ <R> Object z(l<R> lVar, kotlin.coroutines.e<? super R> eVar) {
        if (lVar.E()) {
            return lVar.x(eVar);
        }
        return lVar.A(eVar);
    }

    @NotNull
    public final TrySelectDetailedResult K(@NotNull Object obj, @Nullable Object obj2) {
        TrySelectDetailedResult d6;
        d6 = o.d(L(obj, obj2));
        return d6;
    }

    @Override // kotlinx.coroutines.selects.c
    @Deprecated(level = DeprecationLevel.ERROR, message = "Replaced with the same extension function", replaceWith = @ReplaceWith(expression = "onTimeout", imports = {"kotlinx.coroutines.selects.onTimeout"}))
    @LowPriorityInOverloadResolution
    @ExperimentalCoroutinesApi
    public void d(long j6, @NotNull Function1<? super kotlin.coroutines.e<? super R>, ? extends Object> function1) {
        c.a.b(this, j6, function1);
    }

    @Override // kotlinx.coroutines.selects.c
    public <P, Q> void i(@NotNull i<? super P, ? extends Q> iVar, @NotNull Function2<? super Q, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2) {
        c.a.a(this, iVar, function2);
    }

    @Override // kotlinx.coroutines.selects.m
    public boolean j(@NotNull Object obj, @Nullable Object obj2) {
        if (L(obj, obj2) == 0) {
            return true;
        }
        return false;
    }

    @PublishedApi
    @Nullable
    public Object y(@NotNull kotlin.coroutines.e<? super R> eVar) {
        return z(this, eVar);
    }
}
