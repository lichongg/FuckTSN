package kotlinx.coroutines.channels;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.internal.g0;
import kotlinx.coroutines.DelicateCoroutinesApi;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.internal.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface b0<E> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.channels.ReceiveChannel$DefaultImpls", f = "Channel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_MULTI_SEI}, m = "receiveOrNull", n = {}, s = {})
        /* renamed from: kotlinx.coroutines.channels.b0$a$a, reason: collision with other inner class name */
        static final class C0929a<E> extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f48153a;

            /* renamed from: b, reason: collision with root package name */
            int f48154b;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f48153a = obj;
                this.f48154b |= Integer.MIN_VALUE;
                return a.i(null, this);
            }

            C0929a(kotlin.coroutines.e<? super C0929a> eVar) {
                super(eVar);
            }
        }

        public static /* synthetic */ void b(b0 b0Var, CancellationException cancellationException, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i6 & 1) != 0) {
                cancellationException = null;
            }
            b0Var.b(cancellationException);
        }

        public static /* synthetic */ boolean c(b0 b0Var, Throwable th, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i6 & 1) != 0) {
                th = null;
            }
            return b0Var.a(th);
        }

        @NotNull
        public static <E> kotlinx.coroutines.selects.g<E> d(@NotNull b0<? extends E> b0Var) {
            g0.n(b0Var, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel<E of kotlinx.coroutines.channels.ReceiveChannel>");
            return ((BufferedChannel) b0Var).u();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @kotlin.ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
        @kotlin.internal.LowPriorityInOverloadResolution
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static <E> java.lang.Object i(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.b0<? extends E> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super E> r5) {
            /*
                boolean r0 = r5 instanceof kotlinx.coroutines.channels.b0.a.C0929a
                if (r0 == 0) goto L13
                r0 = r5
                kotlinx.coroutines.channels.b0$a$a r0 = (kotlinx.coroutines.channels.b0.a.C0929a) r0
                int r1 = r0.f48154b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f48154b = r1
                goto L18
            L13:
                kotlinx.coroutines.channels.b0$a$a r0 = new kotlinx.coroutines.channels.b0$a$a
                r0.<init>(r5)
            L18:
                java.lang.Object r5 = r0.f48153a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r0.f48154b
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                kotlin.g0.n(r5)
                kotlinx.coroutines.channels.n r5 = (kotlinx.coroutines.channels.n) r5
                java.lang.Object r4 = r5.o()
                goto L43
            L2f:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L37:
                kotlin.g0.n(r5)
                r0.f48154b = r3
                java.lang.Object r4 = r4.x(r0)
                if (r4 != r1) goto L43
                return r1
            L43:
                java.lang.Object r4 = kotlinx.coroutines.channels.n.h(r4)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.b0.a.i(kotlinx.coroutines.channels.b0, kotlin.coroutines.e):java.lang.Object");
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
        @Nullable
        public static <E> E h(@NotNull b0<? extends E> b0Var) {
            Object v5 = b0Var.v();
            if (n.m(v5)) {
                return (E) n.i(v5);
            }
            Throwable f6 = n.f(v5);
            if (f6 == null) {
                return null;
            }
            throw r0.o(f6);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of onReceiveCatching extension", replaceWith = @ReplaceWith(expression = "onReceiveCatching", imports = {}))
        public static /* synthetic */ void e() {
        }

        @DelicateCoroutinesApi
        public static /* synthetic */ void f() {
        }

        @ExperimentalCoroutinesApi
        public static /* synthetic */ void g() {
        }
    }

    boolean D();

    @NotNull
    kotlinx.coroutines.selects.g<E> N();

    @Nullable
    Object R(@NotNull kotlin.coroutines.e<? super E> eVar);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean a(Throwable th);

    void b(@Nullable CancellationException cancellationException);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    boolean isEmpty();

    @NotNull
    l<E> iterator();

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    @Nullable
    E poll();

    @NotNull
    kotlinx.coroutines.selects.g<n<E>> t();

    @NotNull
    kotlinx.coroutines.selects.g<E> u();

    @NotNull
    Object v();

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @LowPriorityInOverloadResolution
    @Nullable
    Object w(@NotNull kotlin.coroutines.e<? super E> eVar);

    @Nullable
    Object x(@NotNull kotlin.coroutines.e<? super n<? extends E>> eVar);
}
