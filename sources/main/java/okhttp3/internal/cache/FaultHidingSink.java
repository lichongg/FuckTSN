package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class FaultHidingSink extends ForwardingSink {
    private boolean hasErrors;

    @NotNull
    private final Function1<IOException, n1> onException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FaultHidingSink(@NotNull Sink delegate, @NotNull Function1<? super IOException, n1> onException) {
        super(delegate);
        g0.p(delegate, "delegate");
        g0.p(onException, "onException");
        this.onException = onException;
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public void flush() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e6) {
            this.hasErrors = true;
            this.onException.invoke(e6);
        }
    }

    @NotNull
    public final Function1<IOException, n1> getOnException() {
        return this.onException;
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(@NotNull Buffer source, long j6) {
        g0.p(source, "source");
        if (this.hasErrors) {
            source.skip(j6);
            return;
        }
        try {
            super.write(source, j6);
        } catch (IOException e6) {
            this.hasErrors = true;
            this.onException.invoke(e6);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } catch (IOException e6) {
            this.hasErrors = true;
            this.onException.invoke(e6);
        }
    }
}
