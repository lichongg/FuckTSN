package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlinx.coroutines.internal.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/ChannelSegment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3055:1\n1#2:3056\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o<E> extends p0<o<E>> {

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final BufferedChannel<E> f48245e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final AtomicReferenceArray f48246f;

    public final void u(int i6) {
        B(i6, null);
    }

    private final void B(int i6, Object obj) {
        this.f48246f.lazySet(i6 * 2, obj);
    }

    public final void C(int i6, @Nullable Object obj) {
        this.f48246f.set((i6 * 2) + 1, obj);
    }

    @Override // kotlinx.coroutines.internal.p0
    public int p() {
        return i.f48196b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0062, code lost:
    
        u(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0065, code lost:
    
        if (r0 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0067, code lost:
    
        r4 = w().f48123b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x006d, code lost:
    
        if (r4 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x006f, code lost:
    
        kotlinx.coroutines.internal.j0.b(r4, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0072, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
    
        return;
     */
    @Override // kotlinx.coroutines.internal.p0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void q(int r4, @org.jetbrains.annotations.Nullable java.lang.Throwable r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.i r6) {
        /*
            r3 = this;
            int r5 = kotlinx.coroutines.channels.i.f48196b
            if (r4 < r5) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r4 = r4 - r5
        La:
            java.lang.Object r5 = r3.x(r4)
        Le:
            java.lang.Object r1 = r3.y(r4)
            boolean r2 = r1 instanceof kotlinx.coroutines.r3
            if (r2 != 0) goto L73
            boolean r2 = r1 instanceof kotlinx.coroutines.channels.e0
            if (r2 == 0) goto L1b
            goto L73
        L1b:
            kotlinx.coroutines.internal.s0 r2 = kotlinx.coroutines.channels.i.j()
            if (r1 == r2) goto L62
            kotlinx.coroutines.internal.s0 r2 = kotlinx.coroutines.channels.i.i()
            if (r1 != r2) goto L28
            goto L62
        L28:
            kotlinx.coroutines.internal.s0 r2 = kotlinx.coroutines.channels.i.p()
            if (r1 == r2) goto Le
            kotlinx.coroutines.internal.s0 r2 = kotlinx.coroutines.channels.i.q()
            if (r1 != r2) goto L35
            goto Le
        L35:
            kotlinx.coroutines.internal.s0 r4 = kotlinx.coroutines.channels.i.f()
            if (r1 == r4) goto L99
            kotlinx.coroutines.internal.s0 r4 = kotlinx.coroutines.channels.i.f48200f
            if (r1 != r4) goto L40
            goto L99
        L40:
            kotlinx.coroutines.internal.s0 r4 = kotlinx.coroutines.channels.i.z()
            if (r1 != r4) goto L47
            goto L99
        L47:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "unexpected state: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L62:
            r3.u(r4)
            if (r0 == 0) goto L99
            kotlinx.coroutines.channels.BufferedChannel r4 = r3.w()
            kotlin.jvm.functions.Function1<E, kotlin.n1> r4 = r4.f48123b
            if (r4 == 0) goto L99
            kotlinx.coroutines.internal.j0.b(r4, r5, r6)
            return
        L73:
            if (r0 == 0) goto L7a
            kotlinx.coroutines.internal.s0 r2 = kotlinx.coroutines.channels.i.j()
            goto L7e
        L7a:
            kotlinx.coroutines.internal.s0 r2 = kotlinx.coroutines.channels.i.i()
        L7e:
            boolean r1 = r3.t(r4, r1, r2)
            if (r1 == 0) goto Le
            r3.u(r4)
            r1 = r0 ^ 1
            r3.z(r4, r1)
            if (r0 == 0) goto L99
            kotlinx.coroutines.channels.BufferedChannel r4 = r3.w()
            kotlin.jvm.functions.Function1<E, kotlin.n1> r4 = r4.f48123b
            if (r4 == 0) goto L99
            kotlinx.coroutines.internal.j0.b(r4, r5, r6)
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.o.q(int, java.lang.Throwable, kotlin.coroutines.i):void");
    }

    public final boolean t(int i6, @Nullable Object obj, @Nullable Object obj2) {
        return com.google.common.util.concurrent.b.a(this.f48246f, (i6 * 2) + 1, obj, obj2);
    }

    @Nullable
    public final Object v(int i6, @Nullable Object obj) {
        return this.f48246f.getAndSet((i6 * 2) + 1, obj);
    }

    @NotNull
    public final BufferedChannel<E> w() {
        BufferedChannel<E> bufferedChannel = this.f48245e;
        g0.m(bufferedChannel);
        return bufferedChannel;
    }

    public final E x(int i6) {
        return (E) this.f48246f.get(i6 * 2);
    }

    @Nullable
    public final Object y(int i6) {
        return this.f48246f.get((i6 * 2) + 1);
    }

    public final void z(int i6, boolean z5) {
        if (z5) {
            w().G1((this.f49297c * i.f48196b) + i6);
        }
        r();
    }

    public o(long j6, @Nullable o<E> oVar, @Nullable BufferedChannel<E> bufferedChannel, int i6) {
        super(j6, oVar, i6);
        this.f48245e = bufferedChannel;
        this.f48246f = new AtomicReferenceArray(i.f48196b * 2);
    }

    public final E A(int i6) {
        E x5 = x(i6);
        u(i6);
        return x5;
    }

    public final void D(int i6, E e6) {
        B(i6, e6);
    }
}
