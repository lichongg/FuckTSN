package kotlinx.coroutines;

import kotlin.Pair;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCoroutineContext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContext.kt\nkotlinx/coroutines/UndispatchedCoroutine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,314:1\n1#2:315\n107#3,13:316\n*S KotlinDebug\n*F\n+ 1 CoroutineContext.kt\nkotlinx/coroutines/UndispatchedCoroutine\n*L\n269#1:316,13\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p3<T> extends kotlinx.coroutines.internal.o0<T> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final ThreadLocal<Pair<kotlin.coroutines.i, Object>> f49419e;
    private volatile boolean threadLocalIsSet;

    public final void B1(@NotNull kotlin.coroutines.i iVar, @Nullable Object obj) {
        this.threadLocalIsSet = true;
        this.f49419e.set(kotlin.o0.a(iVar, obj));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p3(@org.jetbrains.annotations.NotNull kotlin.coroutines.i r3, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super T> r4) {
        /*
            r2 = this;
            kotlinx.coroutines.q3 r0 = kotlinx.coroutines.q3.f49427a
            kotlin.coroutines.i$b r1 = r3.get(r0)
            if (r1 != 0) goto Ld
            kotlin.coroutines.i r0 = r3.plus(r0)
            goto Le
        Ld:
            r0 = r3
        Le:
            r2.<init>(r0, r4)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f49419e = r0
            kotlin.coroutines.i r4 = r4.getContext()
            kotlin.coroutines.f$b r0 = kotlin.coroutines.f.f43765o0
            kotlin.coroutines.i$b r4 = r4.get(r0)
            boolean r4 = r4 instanceof kotlinx.coroutines.m0
            if (r4 != 0) goto L31
            r4 = 0
            java.lang.Object r4 = kotlinx.coroutines.internal.y0.c(r3, r4)
            kotlinx.coroutines.internal.y0.a(r3, r4)
            r2.B1(r3, r4)
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.p3.<init>(kotlin.coroutines.i, kotlin.coroutines.e):void");
    }

    public final boolean A1() {
        boolean z5 = this.threadLocalIsSet && this.f49419e.get() == null;
        this.f49419e.remove();
        return !z5;
    }

    @Override // kotlinx.coroutines.internal.o0, kotlinx.coroutines.a
    protected void v1(@Nullable Object obj) {
        if (this.threadLocalIsSet) {
            Pair<kotlin.coroutines.i, Object> pair = this.f49419e.get();
            if (pair != null) {
                kotlinx.coroutines.internal.y0.a(pair.component1(), pair.component2());
            }
            this.f49419e.remove();
        }
        Object a6 = i0.a(obj, this.f49294d);
        kotlin.coroutines.e<T> eVar = this.f49294d;
        kotlin.coroutines.i context = eVar.getContext();
        Object c6 = kotlinx.coroutines.internal.y0.c(context, null);
        p3<?> g6 = c6 != kotlinx.coroutines.internal.y0.f49325a ? l0.g(eVar, context, c6) : null;
        try {
            this.f49294d.resumeWith(a6);
            kotlin.n1 n1Var = kotlin.n1.f44123a;
            if (g6 == null || g6.A1()) {
                kotlinx.coroutines.internal.y0.a(context, c6);
            }
        } catch (Throwable th) {
            if (g6 == null || g6.A1()) {
                kotlinx.coroutines.internal.y0.a(context, c6);
            }
            throw th;
        }
    }
}
