package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.flow.h0;
import kotlinx.coroutines.flow.internal.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAbstractSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,132:1\n28#2,4:133\n28#2,4:138\n28#2,4:144\n20#3:137\n20#3:142\n20#3:148\n1#4:143\n13579#5,2:149\n*S KotlinDebug\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n*L\n30#1:133,4\n45#1:138,4\n76#1:144,4\n30#1:137\n45#1:142\n76#1:148\n95#1:149,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class a<S extends c<?>> {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private S[] f48903a;

    /* renamed from: b, reason: collision with root package name */
    private int f48904b;

    /* renamed from: c, reason: collision with root package name */
    private int f48905c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private w f48906d;

    @NotNull
    public final h0<Integer> d() {
        w wVar;
        synchronized (this) {
            wVar = this.f48906d;
            if (wVar == null) {
                wVar = new w(this.f48904b);
                this.f48906d = wVar;
            }
        }
        return wVar;
    }

    @NotNull
    protected final S h() {
        S s5;
        w wVar;
        synchronized (this) {
            try {
                S[] sArr = this.f48903a;
                if (sArr == null) {
                    sArr = j(2);
                    this.f48903a = sArr;
                } else if (this.f48904b >= sArr.length) {
                    Object[] copyOf = Arrays.copyOf(sArr, sArr.length * 2);
                    g0.o(copyOf, "copyOf(this, newSize)");
                    this.f48903a = (S[]) ((c[]) copyOf);
                    sArr = (S[]) ((c[]) copyOf);
                }
                int i6 = this.f48905c;
                do {
                    s5 = sArr[i6];
                    if (s5 == null) {
                        s5 = i();
                        sArr[i6] = s5;
                    }
                    i6++;
                    if (i6 >= sArr.length) {
                        i6 = 0;
                    }
                    g0.n(s5, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!s5.a(this));
                this.f48905c = i6;
                this.f48904b++;
                wVar = this.f48906d;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (wVar != null) {
            wVar.d0(1);
        }
        return s5;
    }

    @NotNull
    protected abstract S i();

    @NotNull
    protected abstract S[] j(int i6);

    protected final void l(@NotNull S s5) {
        w wVar;
        int i6;
        kotlin.coroutines.e<n1>[] b6;
        synchronized (this) {
            try {
                int i7 = this.f48904b - 1;
                this.f48904b = i7;
                wVar = this.f48906d;
                if (i7 == 0) {
                    this.f48905c = 0;
                }
                g0.n(s5, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                b6 = s5.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (kotlin.coroutines.e<n1> eVar : b6) {
            if (eVar != null) {
                Result.a aVar = Result.Companion;
                eVar.resumeWith(Result.m130constructorimpl(n1.f44123a));
            }
        }
        if (wVar != null) {
            wVar.d0(-1);
        }
    }

    protected final int m() {
        return this.f48904b;
    }

    @Nullable
    protected final S[] n() {
        return this.f48903a;
    }

    protected final void k(@NotNull Function1<? super S, n1> function1) {
        c[] cVarArr;
        if (this.f48904b != 0 && (cVarArr = this.f48903a) != null) {
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    function1.invoke(cVar);
                }
            }
        }
    }
}
