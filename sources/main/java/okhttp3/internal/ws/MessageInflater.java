package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import okio.Buffer;
import okio.InflaterSource;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMessageInflater.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageInflater.kt\nokhttp3/internal/ws/MessageInflater\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class MessageInflater implements Closeable {

    @NotNull
    private final Buffer deflatedBytes = new Buffer();

    @Nullable
    private Inflater inflater;

    @Nullable
    private InflaterSource inflaterSource;
    private final boolean noContextTakeover;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InflaterSource inflaterSource = this.inflaterSource;
        if (inflaterSource != null) {
            inflaterSource.close();
        }
        this.inflaterSource = null;
        this.inflater = null;
    }

    public final void inflate(@NotNull Buffer buffer) throws IOException {
        g0.p(buffer, "buffer");
        if (this.deflatedBytes.size() != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        Inflater inflater = this.inflater;
        if (inflater == null) {
            inflater = new Inflater(true);
            this.inflater = inflater;
        }
        InflaterSource inflaterSource = this.inflaterSource;
        if (inflaterSource == null) {
            inflaterSource = new InflaterSource((Source) this.deflatedBytes, inflater);
            this.inflaterSource = inflaterSource;
        }
        if (this.noContextTakeover) {
            inflater.reset();
        }
        this.deflatedBytes.writeAll(buffer);
        this.deflatedBytes.writeInt(65535);
        long bytesRead = inflater.getBytesRead() + this.deflatedBytes.size();
        do {
            inflaterSource.readOrInflate(buffer, Long.MAX_VALUE);
            if (inflater.getBytesRead() >= bytesRead) {
                break;
            }
        } while (!inflater.finished());
        if (inflater.getBytesRead() < bytesRead) {
            this.deflatedBytes.clear();
            inflaterSource.close();
            this.inflaterSource = null;
            this.inflater = null;
        }
    }

    public MessageInflater(boolean z5) {
        this.noContextTakeover = z5;
    }
}
