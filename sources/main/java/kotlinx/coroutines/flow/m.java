package kotlinx.coroutines.flow;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class m {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", f = "Collection.kt", i = {0}, l = {26}, m = "toCollection", n = {RtspHeaders.Values.DESTINATION}, s = {"L$0"})
    static final class a<T, C extends Collection<? super T>> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f49061a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f49062b;

        /* renamed from: c, reason: collision with root package name */
        int f49063c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f49062b = obj;
            this.f49063c |= Integer.MIN_VALUE;
            return k.X1(null, null, this);
        }

        a(kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
        }
    }

    /* JADX WARN: Incorrect field signature: TC; */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Collection f49064a;

        /* JADX WARN: Incorrect types in method signature: (TC;)V */
        b(Collection collection) {
            this.f49064a = collection;
        }

        @Override // kotlinx.coroutines.flow.j
        @Nullable
        public final Object emit(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            this.f49064a.add(t5);
            return n1.f44123a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T, C extends java.util.Collection<? super T>> java.lang.Object a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? extends T> r4, @org.jetbrains.annotations.NotNull C r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super C> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.m.a
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.m$a r0 = (kotlinx.coroutines.flow.m.a) r0
            int r1 = r0.f49063c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49063c = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.m$a r0 = new kotlinx.coroutines.flow.m$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f49062b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f49063c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f49061a
            java.util.Collection r4 = (java.util.Collection) r4
            kotlin.g0.n(r6)
            return r4
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.g0.n(r6)
            kotlinx.coroutines.flow.m$b r6 = new kotlinx.coroutines.flow.m$b
            r6.<init>(r5)
            r0.f49061a = r5
            r0.f49063c = r3
            java.lang.Object r4 = r4.collect(r6, r0)
            if (r4 != r1) goto L48
            return r1
        L48:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.m.a(kotlinx.coroutines.flow.i, java.util.Collection, kotlin.coroutines.e):java.lang.Object");
    }

    @Nullable
    public static final <T> Object b(@NotNull i<? extends T> iVar, @NotNull List<T> list, @NotNull kotlin.coroutines.e<? super List<? extends T>> eVar) {
        return k.X1(iVar, list, eVar);
    }

    public static /* synthetic */ Object c(i iVar, List list, kotlin.coroutines.e eVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            list = new ArrayList();
        }
        return k.Y1(iVar, list, eVar);
    }

    public static /* synthetic */ Object e(i iVar, Set set, kotlin.coroutines.e eVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            set = new LinkedHashSet();
        }
        return k.a2(iVar, set, eVar);
    }

    @Nullable
    public static final <T> Object d(@NotNull i<? extends T> iVar, @NotNull Set<T> set, @NotNull kotlin.coroutines.e<? super Set<? extends T>> eVar) {
        return k.X1(iVar, set, eVar);
    }
}
