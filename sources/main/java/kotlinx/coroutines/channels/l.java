package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface l<E> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelIterator$DefaultImpls", f = "Channel.kt", i = {0}, l = {589}, m = "next", n = {"$this"}, s = {"L$0"})
        /* renamed from: kotlinx.coroutines.channels.l$a$a, reason: collision with other inner class name */
        static final class C0930a<E> extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            Object f48238a;

            /* renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f48239b;

            /* renamed from: c, reason: collision with root package name */
            int f48240c;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f48239b = obj;
                this.f48240c |= Integer.MIN_VALUE;
                return a.a(null, this);
            }

            C0930a(kotlin.coroutines.e<? super C0930a> eVar) {
                super(eVar);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @kotlin.jvm.JvmName(name = "next")
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static /* synthetic */ java.lang.Object a(kotlinx.coroutines.channels.l r4, kotlin.coroutines.e r5) {
            /*
                boolean r0 = r5 instanceof kotlinx.coroutines.channels.l.a.C0930a
                if (r0 == 0) goto L13
                r0 = r5
                kotlinx.coroutines.channels.l$a$a r0 = (kotlinx.coroutines.channels.l.a.C0930a) r0
                int r1 = r0.f48240c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f48240c = r1
                goto L18
            L13:
                kotlinx.coroutines.channels.l$a$a r0 = new kotlinx.coroutines.channels.l$a$a
                r0.<init>(r5)
            L18:
                java.lang.Object r5 = r0.f48239b
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r0.f48240c
                r3 = 1
                if (r2 == 0) goto L35
                if (r2 != r3) goto L2d
                java.lang.Object r4 = r0.f48238a
                kotlinx.coroutines.channels.l r4 = (kotlinx.coroutines.channels.l) r4
                kotlin.g0.n(r5)
                goto L43
            L2d:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L35:
                kotlin.g0.n(r5)
                r0.f48238a = r4
                r0.f48240c = r3
                java.lang.Object r5 = r4.c(r0)
                if (r5 != r1) goto L43
                return r1
            L43:
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                if (r5 == 0) goto L50
                java.lang.Object r4 = r4.next()
                return r4
            L50:
                kotlinx.coroutines.channels.ClosedReceiveChannelException r4 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
                java.lang.String r5 = "Channel was closed"
                r4.<init>(r5)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.l.a.a(kotlinx.coroutines.channels.l, kotlin.coroutines.e):java.lang.Object");
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
    @JvmName(name = "next")
    /* synthetic */ Object a(kotlin.coroutines.e eVar);

    @Nullable
    Object c(@NotNull kotlin.coroutines.e<? super Boolean> eVar);

    E next();
}
