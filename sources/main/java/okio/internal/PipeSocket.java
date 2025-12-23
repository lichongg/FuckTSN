package okio.internal;

import kotlin.jvm.internal.g0;
import okio.Pipe;
import okio.Sink;
import okio.Socket;
import okio.Source;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class PipeSocket implements Socket {

    @NotNull
    private final Pipe sinkPipe;

    @NotNull
    private final Pipe sourcePipe;

    public PipeSocket(@NotNull Pipe sinkPipe, @NotNull Pipe sourcePipe) {
        g0.p(sinkPipe, "sinkPipe");
        g0.p(sourcePipe, "sourcePipe");
        this.sinkPipe = sinkPipe;
        this.sourcePipe = sourcePipe;
    }

    @Override // okio.Socket
    public void cancel() {
        this.sourcePipe.cancel();
        this.sinkPipe.cancel();
    }

    @Override // okio.Socket
    @NotNull
    public Sink getSink() {
        return this.sinkPipe.sink();
    }

    @NotNull
    public final Pipe getSinkPipe() {
        return this.sinkPipe;
    }

    @Override // okio.Socket
    @NotNull
    public Source getSource() {
        return this.sourcePipe.source();
    }

    @NotNull
    public final Pipe getSourcePipe() {
        return this.sourcePipe;
    }
}
