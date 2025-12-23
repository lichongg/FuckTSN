package kotlinx.coroutines.channels;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.o0;
import kotlin.n1;
import kotlinx.coroutines.channels.n;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.j0;
import kotlinx.coroutines.r3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nConflatedBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConflatedBufferedChannel.kt\nkotlinx/coroutines/channels/ConflatedBufferedChannel\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 4 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannelKt\n+ 5 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n*L\n1#1,119:1\n548#2,5:120\n514#2,6:125\n514#2,6:212\n548#2,5:218\n244#3:131\n269#3,10:132\n280#3,68:143\n3038#4:142\n269#5:211\n*S KotlinDebug\n*F\n+ 1 ConflatedBufferedChannel.kt\nkotlinx/coroutines/channels/ConflatedBufferedChannel\n*L\n41#1:120,5\n53#1:125,6\n106#1:212,6\n109#1:218,5\n80#1:131\n80#1:132,10\n80#1:143,68\n80#1:142\n80#1:211\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class u<E> extends BufferedChannel<E> {

    /* renamed from: m, reason: collision with root package name */
    private final int f48463m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private final BufferOverflow f48464n;

    public /* synthetic */ u(int i6, BufferOverflow bufferOverflow, Function1 function1, int i7, kotlin.jvm.internal.v vVar) {
        this(i6, bufferOverflow, (i7 & 4) != 0 ? null : function1);
    }

    static /* synthetic */ <E> Object H1(u<E> uVar, E e6, kotlin.coroutines.e<? super n1> eVar) {
        UndeliveredElementException d6;
        Object L1 = uVar.L1(e6, true);
        if (!(L1 instanceof n.a)) {
            return n1.f44123a;
        }
        n.f(L1);
        Function1<E, n1> function1 = uVar.f48123b;
        if (function1 == null || (d6 = j0.d(function1, e6, null, 2, null)) == null) {
            throw uVar.n0();
        }
        kotlin.l.a(d6, uVar.n0());
        throw d6;
    }

    static /* synthetic */ <E> Object I1(u<E> uVar, E e6, kotlin.coroutines.e<? super Boolean> eVar) {
        Object L1 = uVar.L1(e6, true);
        if (L1 instanceof n.c) {
            return kotlin.coroutines.jvm.internal.a.a(false);
        }
        return kotlin.coroutines.jvm.internal.a.a(true);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.c0
    @NotNull
    public Object r(E e6) {
        return L1(e6, false);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean t1() {
        return false;
    }

    public u(int i6, @NotNull BufferOverflow bufferOverflow, @Nullable Function1<? super E, n1> function1) {
        super(i6, function1);
        this.f48463m = i6;
        this.f48464n = bufferOverflow;
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + o0.d(BufferedChannel.class).D() + " instead").toString());
        }
        if (i6 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i6 + " was specified").toString());
    }

    private final Object K1(E e6) {
        o oVar;
        int i6;
        u<E> uVar;
        Object obj = i.f48200f;
        o oVar2 = (o) BufferedChannel.f48117h.get(this);
        while (true) {
            long andIncrement = BufferedChannel.f48113d.getAndIncrement(this);
            long j6 = 1152921504606846975L & andIncrement;
            boolean y02 = y0(andIncrement);
            int i7 = i.f48196b;
            long j7 = j6 / i7;
            int i8 = (int) (j6 % i7);
            if (oVar2.f49297c != j7) {
                oVar = c0(j7, oVar2);
                if (oVar != null) {
                    uVar = this;
                    i6 = i8;
                } else if (y02) {
                    return n.f48241b.a(n0());
                }
            } else {
                oVar = oVar2;
                i6 = i8;
                uVar = this;
            }
            E e7 = e6;
            int C1 = uVar.C1(oVar, i6, e7, j6, obj, y02);
            oVar2 = oVar;
            if (C1 == 0) {
                oVar2.b();
                return n.f48241b.c(n1.f44123a);
            }
            if (C1 == 1) {
                return n.f48241b.c(n1.f44123a);
            }
            if (C1 == 2) {
                if (y02) {
                    oVar2.r();
                    return n.f48241b.a(n0());
                }
                r3 r3Var = obj instanceof r3 ? (r3) obj : null;
                if (r3Var != null) {
                    T0(r3Var, oVar2, i6);
                }
                Y((oVar2.f49297c * i7) + i6);
                return n.f48241b.c(n1.f44123a);
            }
            if (C1 == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (C1 == 4) {
                if (j6 < m0()) {
                    oVar2.b();
                }
                return n.f48241b.a(n0());
            }
            if (C1 == 5) {
                oVar2.b();
            }
            e6 = e7;
        }
    }

    private final Object L1(E e6, boolean z5) {
        return this.f48464n == BufferOverflow.DROP_LATEST ? J1(e6, z5) : K1(e6);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected boolean z0() {
        return this.f48464n == BufferOverflow.DROP_OLDEST;
    }

    private final Object J1(E e6, boolean z5) {
        Function1<E, n1> function1;
        UndeliveredElementException d6;
        Object r5 = super.r(e6);
        if (!n.m(r5) && !n.k(r5)) {
            if (z5 && (function1 = this.f48123b) != null && (d6 = j0.d(function1, e6, null, 2, null)) != null) {
                throw d6;
            }
            return n.f48241b.c(n1.f44123a);
        }
        return r5;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.c0
    @Nullable
    public Object T(E e6, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return H1(this, e6, eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected void g1(@NotNull kotlinx.coroutines.selects.m<?> mVar, @Nullable Object obj) {
        Object r5 = r(obj);
        if (!(r5 instanceof n.c)) {
            mVar.f(n1.f44123a);
        } else {
            if (r5 instanceof n.a) {
                n.f(r5);
                mVar.f(i.z());
                return;
            }
            throw new IllegalStateException("unreachable");
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    @Nullable
    public Object m1(E e6, @NotNull kotlin.coroutines.e<? super Boolean> eVar) {
        return I1(this, e6, eVar);
    }
}
