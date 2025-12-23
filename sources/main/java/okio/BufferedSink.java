package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    @Deprecated(level = DeprecationLevel.WARNING, message = "moved to val: use getBuffer() instead", replaceWith = @ReplaceWith(expression = "buffer", imports = {}))
    @NotNull
    Buffer buffer();

    @NotNull
    BufferedSink emit() throws IOException;

    @NotNull
    BufferedSink emitCompleteSegments() throws IOException;

    @Override // okio.Sink, java.io.Flushable
    void flush() throws IOException;

    @NotNull
    Buffer getBuffer();

    @NotNull
    OutputStream outputStream();

    @NotNull
    BufferedSink write(@NotNull ByteString byteString) throws IOException;

    @NotNull
    BufferedSink write(@NotNull ByteString byteString, int i6, int i7) throws IOException;

    @NotNull
    BufferedSink write(@NotNull Source source, long j6) throws IOException;

    @NotNull
    BufferedSink write(@NotNull byte[] bArr) throws IOException;

    @NotNull
    BufferedSink write(@NotNull byte[] bArr, int i6, int i7) throws IOException;

    long writeAll(@NotNull Source source) throws IOException;

    @NotNull
    BufferedSink writeByte(int i6) throws IOException;

    @NotNull
    BufferedSink writeDecimalLong(long j6) throws IOException;

    @NotNull
    BufferedSink writeHexadecimalUnsignedLong(long j6) throws IOException;

    @NotNull
    BufferedSink writeInt(int i6) throws IOException;

    @NotNull
    BufferedSink writeIntLe(int i6) throws IOException;

    @NotNull
    BufferedSink writeLong(long j6) throws IOException;

    @NotNull
    BufferedSink writeLongLe(long j6) throws IOException;

    @NotNull
    BufferedSink writeShort(int i6) throws IOException;

    @NotNull
    BufferedSink writeShortLe(int i6) throws IOException;

    @NotNull
    BufferedSink writeString(@NotNull String str, int i6, int i7, @NotNull Charset charset) throws IOException;

    @NotNull
    BufferedSink writeString(@NotNull String str, @NotNull Charset charset) throws IOException;

    @NotNull
    BufferedSink writeUtf8(@NotNull String str) throws IOException;

    @NotNull
    BufferedSink writeUtf8(@NotNull String str, int i6, int i7) throws IOException;

    @NotNull
    BufferedSink writeUtf8CodePoint(int i6) throws IOException;
}
