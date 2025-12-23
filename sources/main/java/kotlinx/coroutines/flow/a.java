package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.n1;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ExperimentalCoroutinesApi
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class a<T> implements i<T>, c<T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", i = {0}, l = {230}, m = "collect", n = {"safeCollector"}, s = {"L$0"})
    /* renamed from: kotlinx.coroutines.flow.a$a, reason: collision with other inner class name */
    static final class C0935a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f48836a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48837b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ a<T> f48838c;

        /* renamed from: d, reason: collision with root package name */
        int f48839d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0935a(a<T> aVar, kotlin.coroutines.e<? super C0935a> eVar) {
            super(eVar);
            this.f48838c = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f48837b = obj;
            this.f48839d |= Integer.MIN_VALUE;
            return this.f48838c.collect(null, this);
        }
    }

    @Nullable
    public abstract Object f(@NotNull j<? super T> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar);

    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.i
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.j<? super T> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.a.C0935a
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.a$a r0 = (kotlinx.coroutines.flow.a.C0935a) r0
            int r1 = r0.f48839d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48839d = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.a$a r0 = new kotlinx.coroutines.flow.a$a
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f48837b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f48839d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r6 = r0.f48836a
            kotlinx.coroutines.flow.internal.SafeCollector r6 = (kotlinx.coroutines.flow.internal.SafeCollector) r6
            kotlin.g0.n(r7)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r7 = move-exception
            goto L59
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.g0.n(r7)
            kotlinx.coroutines.flow.internal.SafeCollector r7 = new kotlinx.coroutines.flow.internal.SafeCollector
            kotlin.coroutines.i r2 = r0.getContext()
            r7.<init>(r6, r2)
            r0.f48836a = r7     // Catch: java.lang.Throwable -> L55
            r0.f48839d = r3     // Catch: java.lang.Throwable -> L55
            java.lang.Object r6 = r5.f(r7, r0)     // Catch: java.lang.Throwable -> L55
            if (r6 != r1) goto L4e
            return r1
        L4e:
            r6 = r7
        L4f:
            r6.releaseIntercepted()
            kotlin.n1 r6 = kotlin.n1.f44123a
            return r6
        L55:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L59:
            r6.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.a.collect(kotlinx.coroutines.flow.j, kotlin.coroutines.e):java.lang.Object");
    }
}
