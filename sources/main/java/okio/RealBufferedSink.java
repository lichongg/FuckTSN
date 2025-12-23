package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRealBufferedSink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealBufferedSink.kt\nokio/RealBufferedSink\n+ 2 RealBufferedSink.kt\nokio/internal/-RealBufferedSink\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,142:1\n51#1:146\n51#1:152\n51#1:157\n51#1:162\n51#1:167\n51#1:172\n51#1:175\n51#1:176\n51#1:180\n51#1:185\n51#1:188\n51#1:192\n51#1:201\n51#1:210\n51#1:215\n51#1:220\n51#1:225\n51#1:230\n51#1:235\n51#1:240\n51#1:245\n51#1:250\n51#1:255\n51#1:261\n51#1:267\n51#1:279\n34#2:143\n35#2:145\n36#2,2:147\n40#2:149\n41#2:151\n42#2:153\n50#2:154\n51#2:156\n52#2:158\n56#2:159\n57#2:161\n58#2:163\n66#2:164\n67#2:166\n68#2:168\n72#2:169\n73#2:171\n74#2:173\n78#2:177\n79#2:179\n80#2:181\n88#2:182\n89#2:184\n90#2:186\n94#2,3:189\n97#2,5:193\n105#2,3:198\n108#2,5:202\n116#2:207\n117#2:209\n118#2:211\n122#2:212\n123#2:214\n124#2:216\n128#2:217\n129#2:219\n130#2:221\n134#2:222\n135#2:224\n136#2:226\n140#2:227\n141#2:229\n142#2:231\n146#2:232\n147#2:234\n148#2:236\n152#2:237\n153#2:239\n154#2:241\n158#2:242\n159#2:244\n160#2:246\n164#2:247\n165#2:249\n166#2:251\n170#2:252\n171#2:254\n172#2,2:256\n177#2:258\n178#2:260\n179#2,2:262\n184#2:264\n185#2:266\n186#2,4:268\n192#2,7:272\n199#2,16:280\n216#2:296\n218#2:297\n1#3:144\n1#3:150\n1#3:155\n1#3:160\n1#3:165\n1#3:170\n1#3:174\n1#3:178\n1#3:183\n1#3:187\n1#3:208\n1#3:213\n1#3:218\n1#3:223\n1#3:228\n1#3:233\n1#3:238\n1#3:243\n1#3:248\n1#3:253\n1#3:259\n1#3:265\n*S KotlinDebug\n*F\n+ 1 RealBufferedSink.kt\nokio/RealBufferedSink\n*L\n55#1:146\n56#1:152\n58#1:157\n59#1:162\n61#1:167\n63#1:172\n67#1:175\n78#1:176\n82#1:180\n84#1:185\n88#1:188\n93#1:192\n94#1:201\n95#1:210\n96#1:215\n97#1:220\n98#1:225\n99#1:230\n100#1:235\n101#1:240\n102#1:245\n103#1:250\n104#1:255\n105#1:261\n134#1:267\n138#1:279\n55#1:143\n55#1:145\n55#1:147,2\n56#1:149\n56#1:151\n56#1:153\n58#1:154\n58#1:156\n58#1:158\n59#1:159\n59#1:161\n59#1:163\n61#1:164\n61#1:166\n61#1:168\n63#1:169\n63#1:171\n63#1:173\n82#1:177\n82#1:179\n82#1:181\n84#1:182\n84#1:184\n84#1:186\n93#1:189,3\n93#1:193,5\n94#1:198,3\n94#1:202,5\n95#1:207\n95#1:209\n95#1:211\n96#1:212\n96#1:214\n96#1:216\n97#1:217\n97#1:219\n97#1:221\n98#1:222\n98#1:224\n98#1:226\n99#1:227\n99#1:229\n99#1:231\n100#1:232\n100#1:234\n100#1:236\n101#1:237\n101#1:239\n101#1:241\n102#1:242\n102#1:244\n102#1:246\n103#1:247\n103#1:249\n103#1:251\n104#1:252\n104#1:254\n104#1:256,2\n105#1:258\n105#1:260\n105#1:262,2\n134#1:264\n134#1:266\n134#1:268,4\n138#1:272,7\n138#1:280,16\n139#1:296\n140#1:297\n55#1:144\n56#1:150\n58#1:155\n59#1:160\n61#1:165\n63#1:170\n82#1:178\n84#1:183\n95#1:208\n96#1:213\n97#1:218\n98#1:223\n99#1:228\n100#1:233\n101#1:238\n102#1:243\n103#1:248\n104#1:253\n105#1:259\n134#1:265\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class RealBufferedSink implements BufferedSink {

    @JvmField
    @NotNull
    public final Buffer bufferField;

    @JvmField
    public boolean closed;

    @JvmField
    @NotNull
    public final Sink sink;

    @Override // java.nio.channels.WritableByteChannel
    public int write(@NotNull ByteBuffer source) {
        g0.p(source, "source");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        int write = this.bufferField.write(source);
        emitCompleteSegments();
        return write;
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeString(@NotNull String string, @NotNull Charset charset) {
        g0.p(string, "string");
        g0.p(charset, "charset");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeString(string, charset);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeUtf8(@NotNull String string) {
        g0.p(string, "string");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeUtf8(string);
        return emitCompleteSegments();
    }

    public RealBufferedSink(@NotNull Sink sink) {
        g0.p(sink, "sink");
        this.sink = sink;
        this.bufferField = new Buffer();
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer buffer() {
        return this.bufferField;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        try {
            if (this.bufferField.size() > 0) {
                Sink sink = this.sink;
                Buffer buffer = this.bufferField;
                sink.write(buffer, buffer.size());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.sink.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink emit() {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        long size = this.bufferField.size();
        if (size > 0) {
            this.sink.write(this.bufferField, size);
        }
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink emitCompleteSegments() {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        long completeSegmentByteCount = this.bufferField.completeSegmentByteCount();
        if (completeSegmentByteCount > 0) {
            this.sink.write(this.bufferField, completeSegmentByteCount);
        }
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.bufferField.size() > 0) {
            Sink sink = this.sink;
            Buffer buffer = this.bufferField;
            sink.write(buffer, buffer.size());
        }
        this.sink.flush();
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.BufferedSink
    @NotNull
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.RealBufferedSink$outputStream$1
            @Override // java.io.OutputStream
            public void write(int i6) {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    throw new IOException("closed");
                }
                realBufferedSink.bufferField.writeByte((int) ((byte) i6));
                RealBufferedSink.this.emitCompleteSegments();
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                RealBufferedSink.this.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    return;
                }
                realBufferedSink.flush();
            }

            public String toString() {
                return RealBufferedSink.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(byte[] data, int i6, int i7) {
                g0.p(data, "data");
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (!realBufferedSink.closed) {
                    realBufferedSink.bufferField.write(data, i6, i7);
                    RealBufferedSink.this.emitCompleteSegments();
                    return;
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @NotNull
    public String toString() {
        return "buffer(" + this.sink + ')';
    }

    @Override // okio.BufferedSink
    public long writeAll(@NotNull Source source) {
        g0.p(source, "source");
        long j6 = 0;
        while (true) {
            long read = source.read(this.bufferField, 8192L);
            if (read == -1) {
                return j6;
            }
            j6 += read;
            emitCompleteSegments();
        }
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeByte(int i6) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeByte(i6);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeDecimalLong(long j6) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeDecimalLong(j6);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeHexadecimalUnsignedLong(long j6) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeHexadecimalUnsignedLong(j6);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeInt(int i6) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeInt(i6);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeIntLe(int i6) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeIntLe(i6);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeLong(long j6) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeLong(j6);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeLongLe(long j6) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeLongLe(j6);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeShort(int i6) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeShort(i6);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeShortLe(int i6) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeShortLe(i6);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeUtf8CodePoint(int i6) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeUtf8CodePoint(i6);
        return emitCompleteSegments();
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer source, long j6) {
        g0.p(source, "source");
        if (!this.closed) {
            this.bufferField.write(source, j6);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeString(@NotNull String string, int i6, int i7, @NotNull Charset charset) {
        g0.p(string, "string");
        g0.p(charset, "charset");
        if (!this.closed) {
            this.bufferField.writeString(string, i6, i7, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeUtf8(@NotNull String string, int i6, int i7) {
        g0.p(string, "string");
        if (!this.closed) {
            this.bufferField.writeUtf8(string, i6, i7);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull ByteString byteString) {
        g0.p(byteString, "byteString");
        if (!this.closed) {
            this.bufferField.write(byteString);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull ByteString byteString, int i6, int i7) {
        g0.p(byteString, "byteString");
        if (!this.closed) {
            this.bufferField.write(byteString, i6, i7);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull byte[] source) {
        g0.p(source, "source");
        if (!this.closed) {
            this.bufferField.write(source);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull byte[] source, int i6, int i7) {
        g0.p(source, "source");
        if (!this.closed) {
            this.bufferField.write(source, i6, i7);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull Source source, long j6) {
        g0.p(source, "source");
        while (j6 > 0) {
            long read = source.read(this.bufferField, j6);
            if (read != -1) {
                j6 -= read;
                emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return this;
    }
}
