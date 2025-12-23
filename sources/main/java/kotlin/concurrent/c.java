package kotlin.concurrent;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.PublishedApi;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "TimersKt")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nTimer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timer.kt\nkotlin/concurrent/TimersKt$timerTask$1\n*L\n1#1,148:1\n*E\n"})
    public static final class a extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<TimerTask, n1> f43758a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super TimerTask, n1> function1) {
            this.f43758a = function1;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f43758a.invoke(this);
        }
    }

    @InlineOnly
    private static final Timer a(String str, boolean z5, long j6, long j7, Function1<? super TimerTask, n1> action) {
        g0.p(action, "action");
        Timer k6 = k(str, z5);
        k6.scheduleAtFixedRate(new a(action), j6, j7);
        return k6;
    }

    @InlineOnly
    private static final Timer b(String str, boolean z5, Date startAt, long j6, Function1<? super TimerTask, n1> action) {
        g0.p(startAt, "startAt");
        g0.p(action, "action");
        Timer k6 = k(str, z5);
        k6.scheduleAtFixedRate(new a(action), startAt, j6);
        return k6;
    }

    static /* synthetic */ Timer c(String str, boolean z5, long j6, long j7, Function1 action, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = null;
        }
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        if ((i6 & 4) != 0) {
            j6 = 0;
        }
        g0.p(action, "action");
        Timer k6 = k(str, z5);
        k6.scheduleAtFixedRate(new a(action), j6, j7);
        return k6;
    }

    static /* synthetic */ Timer d(String str, boolean z5, Date startAt, long j6, Function1 action, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = null;
        }
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        g0.p(startAt, "startAt");
        g0.p(action, "action");
        Timer k6 = k(str, z5);
        k6.scheduleAtFixedRate(new a(action), startAt, j6);
        return k6;
    }

    @InlineOnly
    private static final TimerTask e(Timer timer, long j6, long j7, Function1<? super TimerTask, n1> action) {
        g0.p(timer, "<this>");
        g0.p(action, "action");
        a aVar = new a(action);
        timer.schedule(aVar, j6, j7);
        return aVar;
    }

    @InlineOnly
    private static final TimerTask f(Timer timer, long j6, Function1<? super TimerTask, n1> action) {
        g0.p(timer, "<this>");
        g0.p(action, "action");
        a aVar = new a(action);
        timer.schedule(aVar, j6);
        return aVar;
    }

    @InlineOnly
    private static final TimerTask g(Timer timer, Date time, long j6, Function1<? super TimerTask, n1> action) {
        g0.p(timer, "<this>");
        g0.p(time, "time");
        g0.p(action, "action");
        a aVar = new a(action);
        timer.schedule(aVar, time, j6);
        return aVar;
    }

    @InlineOnly
    private static final TimerTask h(Timer timer, Date time, Function1<? super TimerTask, n1> action) {
        g0.p(timer, "<this>");
        g0.p(time, "time");
        g0.p(action, "action");
        a aVar = new a(action);
        timer.schedule(aVar, time);
        return aVar;
    }

    @InlineOnly
    private static final TimerTask i(Timer timer, long j6, long j7, Function1<? super TimerTask, n1> action) {
        g0.p(timer, "<this>");
        g0.p(action, "action");
        a aVar = new a(action);
        timer.scheduleAtFixedRate(aVar, j6, j7);
        return aVar;
    }

    @InlineOnly
    private static final TimerTask j(Timer timer, Date time, long j6, Function1<? super TimerTask, n1> action) {
        g0.p(timer, "<this>");
        g0.p(time, "time");
        g0.p(action, "action");
        a aVar = new a(action);
        timer.scheduleAtFixedRate(aVar, time, j6);
        return aVar;
    }

    @PublishedApi
    @NotNull
    public static final Timer k(@Nullable String str, boolean z5) {
        return str == null ? new Timer(z5) : new Timer(str, z5);
    }

    @InlineOnly
    private static final Timer l(String str, boolean z5, long j6, long j7, Function1<? super TimerTask, n1> action) {
        g0.p(action, "action");
        Timer k6 = k(str, z5);
        k6.schedule(new a(action), j6, j7);
        return k6;
    }

    @InlineOnly
    private static final Timer m(String str, boolean z5, Date startAt, long j6, Function1<? super TimerTask, n1> action) {
        g0.p(startAt, "startAt");
        g0.p(action, "action");
        Timer k6 = k(str, z5);
        k6.schedule(new a(action), startAt, j6);
        return k6;
    }

    static /* synthetic */ Timer n(String str, boolean z5, long j6, long j7, Function1 action, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = null;
        }
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        if ((i6 & 4) != 0) {
            j6 = 0;
        }
        g0.p(action, "action");
        Timer k6 = k(str, z5);
        k6.schedule(new a(action), j6, j7);
        return k6;
    }

    static /* synthetic */ Timer o(String str, boolean z5, Date startAt, long j6, Function1 action, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = null;
        }
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        g0.p(startAt, "startAt");
        g0.p(action, "action");
        Timer k6 = k(str, z5);
        k6.schedule(new a(action), startAt, j6);
        return k6;
    }

    @InlineOnly
    private static final TimerTask p(Function1<? super TimerTask, n1> action) {
        g0.p(action, "action");
        return new a(action);
    }
}
