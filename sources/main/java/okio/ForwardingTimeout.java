package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class ForwardingTimeout extends Timeout {

    @NotNull
    private Timeout delegate;

    @Override // okio.Timeout
    public long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }

    /* renamed from: setDelegate, reason: collision with other method in class */
    public final /* synthetic */ void m313setDelegate(Timeout timeout) {
        g0.p(timeout, "<set-?>");
        this.delegate = timeout;
    }

    public ForwardingTimeout(@NotNull Timeout delegate) {
        g0.p(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // okio.Timeout
    public void awaitSignal(@NotNull Condition condition) {
        g0.p(condition, "condition");
        this.delegate.awaitSignal(condition);
    }

    @Override // okio.Timeout
    public void cancel() {
        this.delegate.cancel();
    }

    @Override // okio.Timeout
    @NotNull
    public Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }

    @Override // okio.Timeout
    @NotNull
    public Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }

    @Override // okio.Timeout
    @NotNull
    public Timeout deadlineNanoTime(long j6) {
        return this.delegate.deadlineNanoTime(j6);
    }

    @JvmName(name = "delegate")
    @NotNull
    public final Timeout delegate() {
        return this.delegate;
    }

    @Override // okio.Timeout
    public boolean hasDeadline() {
        return this.delegate.hasDeadline();
    }

    @NotNull
    public final ForwardingTimeout setDelegate(@NotNull Timeout delegate) {
        g0.p(delegate, "delegate");
        this.delegate = delegate;
        return this;
    }

    @Override // okio.Timeout
    public void throwIfReached() throws IOException {
        this.delegate.throwIfReached();
    }

    @Override // okio.Timeout
    @NotNull
    public Timeout timeout(long j6, @NotNull TimeUnit unit) {
        g0.p(unit, "unit");
        return this.delegate.timeout(j6, unit);
    }

    @Override // okio.Timeout
    public long timeoutNanos() {
        return this.delegate.timeoutNanos();
    }

    @Override // okio.Timeout
    public void waitUntilNotified(@NotNull Object monitor) {
        g0.p(monitor, "monitor");
        this.delegate.waitUntilNotified(monitor);
    }
}
