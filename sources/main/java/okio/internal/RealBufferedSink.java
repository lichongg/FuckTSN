package okio.internal;

import java.io.EOFException;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "-RealBufferedSink")
@SourceDebugExtension({"SMAP\nRealBufferedSink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealBufferedSink.kt\nokio/internal/-RealBufferedSink\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 RealBufferedSink.kt\nokio/RealBufferedSink\n*L\n1#1,219:1\n1#2:220\n51#3:221\n51#3:222\n51#3:223\n51#3:224\n51#3:225\n51#3:226\n51#3:227\n51#3:228\n51#3:229\n51#3:230\n51#3:231\n51#3:232\n51#3:233\n51#3:234\n51#3:235\n51#3:236\n51#3:237\n51#3:238\n51#3:239\n51#3:240\n51#3:241\n51#3:242\n51#3:243\n51#3:244\n51#3:245\n51#3:246\n51#3:247\n*S KotlinDebug\n*F\n+ 1 RealBufferedSink.kt\nokio/internal/-RealBufferedSink\n*L\n35#1:221\n41#1:222\n51#1:223\n57#1:224\n67#1:225\n73#1:226\n79#1:227\n89#1:228\n96#1:229\n107#1:230\n117#1:231\n123#1:232\n129#1:233\n135#1:234\n141#1:235\n147#1:236\n153#1:237\n159#1:238\n165#1:239\n171#1:240\n172#1:241\n178#1:242\n179#1:243\n185#1:244\n186#1:245\n198#1:246\n199#1:247\n*E\n"})
/* renamed from: okio.internal.-RealBufferedSink, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class RealBufferedSink {
    public static final void commonWrite(@NotNull okio.RealBufferedSink realBufferedSink, @NotNull Buffer source, long j6) {
        g0.p(realBufferedSink, "<this>");
        g0.p(source, "source");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink.bufferField.write(source, j6);
        realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8(@NotNull okio.RealBufferedSink realBufferedSink, @NotNull String string) {
        g0.p(realBufferedSink, "<this>");
        g0.p(string, "string");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink.bufferField.writeUtf8(string);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final void commonClose(@NotNull okio.RealBufferedSink realBufferedSink) {
        g0.p(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            return;
        }
        try {
            if (realBufferedSink.bufferField.size() > 0) {
                Sink sink = realBufferedSink.sink;
                Buffer buffer = realBufferedSink.bufferField;
                sink.write(buffer, buffer.size());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            realBufferedSink.sink.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        realBufferedSink.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @NotNull
    public static final BufferedSink commonEmit(@NotNull okio.RealBufferedSink realBufferedSink) {
        g0.p(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed");
        }
        long size = realBufferedSink.bufferField.size();
        if (size > 0) {
            realBufferedSink.sink.write(realBufferedSink.bufferField, size);
        }
        return realBufferedSink;
    }

    @NotNull
    public static final BufferedSink commonEmitCompleteSegments(@NotNull okio.RealBufferedSink realBufferedSink) {
        g0.p(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed");
        }
        long completeSegmentByteCount = realBufferedSink.bufferField.completeSegmentByteCount();
        if (completeSegmentByteCount > 0) {
            realBufferedSink.sink.write(realBufferedSink.bufferField, completeSegmentByteCount);
        }
        return realBufferedSink;
    }

    public static final void commonFlush(@NotNull okio.RealBufferedSink realBufferedSink) {
        g0.p(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed");
        }
        if (realBufferedSink.bufferField.size() > 0) {
            Sink sink = realBufferedSink.sink;
            Buffer buffer = realBufferedSink.bufferField;
            sink.write(buffer, buffer.size());
        }
        realBufferedSink.sink.flush();
    }

    @NotNull
    public static final Timeout commonTimeout(@NotNull okio.RealBufferedSink realBufferedSink) {
        g0.p(realBufferedSink, "<this>");
        return realBufferedSink.sink.timeout();
    }

    @NotNull
    public static final String commonToString(@NotNull okio.RealBufferedSink realBufferedSink) {
        g0.p(realBufferedSink, "<this>");
        return "buffer(" + realBufferedSink.sink + ')';
    }

    public static final long commonWriteAll(@NotNull okio.RealBufferedSink realBufferedSink, @NotNull Source source) {
        g0.p(realBufferedSink, "<this>");
        g0.p(source, "source");
        long j6 = 0;
        while (true) {
            long read = source.read(realBufferedSink.bufferField, 8192L);
            if (read == -1) {
                return j6;
            }
            j6 += read;
            realBufferedSink.emitCompleteSegments();
        }
    }

    @NotNull
    public static final BufferedSink commonWriteByte(@NotNull okio.RealBufferedSink realBufferedSink, int i6) {
        g0.p(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink.bufferField.writeByte(i6);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteDecimalLong(@NotNull okio.RealBufferedSink realBufferedSink, long j6) {
        g0.p(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink.bufferField.writeDecimalLong(j6);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteHexadecimalUnsignedLong(@NotNull okio.RealBufferedSink realBufferedSink, long j6) {
        g0.p(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink.bufferField.writeHexadecimalUnsignedLong(j6);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteInt(@NotNull okio.RealBufferedSink realBufferedSink, int i6) {
        g0.p(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink.bufferField.writeInt(i6);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteIntLe(@NotNull okio.RealBufferedSink realBufferedSink, int i6) {
        g0.p(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink.bufferField.writeIntLe(i6);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteLong(@NotNull okio.RealBufferedSink realBufferedSink, long j6) {
        g0.p(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink.bufferField.writeLong(j6);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteLongLe(@NotNull okio.RealBufferedSink realBufferedSink, long j6) {
        g0.p(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink.bufferField.writeLongLe(j6);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteShort(@NotNull okio.RealBufferedSink realBufferedSink, int i6) {
        g0.p(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink.bufferField.writeShort(i6);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteShortLe(@NotNull okio.RealBufferedSink realBufferedSink, int i6) {
        g0.p(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink.bufferField.writeShortLe(i6);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8CodePoint(@NotNull okio.RealBufferedSink realBufferedSink, int i6) {
        g0.p(realBufferedSink, "<this>");
        if (realBufferedSink.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink.bufferField.writeUtf8CodePoint(i6);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull okio.RealBufferedSink realBufferedSink, @NotNull ByteString byteString) {
        g0.p(realBufferedSink, "<this>");
        g0.p(byteString, "byteString");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(byteString);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8(@NotNull okio.RealBufferedSink realBufferedSink, @NotNull String string, int i6, int i7) {
        g0.p(realBufferedSink, "<this>");
        g0.p(string, "string");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8(string, i6, i7);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull okio.RealBufferedSink realBufferedSink, @NotNull ByteString byteString, int i6, int i7) {
        g0.p(realBufferedSink, "<this>");
        g0.p(byteString, "byteString");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(byteString, i6, i7);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull okio.RealBufferedSink realBufferedSink, @NotNull byte[] source) {
        g0.p(realBufferedSink, "<this>");
        g0.p(source, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(source);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull okio.RealBufferedSink realBufferedSink, @NotNull byte[] source, int i6, int i7) {
        g0.p(realBufferedSink, "<this>");
        g0.p(source, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(source, i6, i7);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull okio.RealBufferedSink realBufferedSink, @NotNull Source source, long j6) {
        g0.p(realBufferedSink, "<this>");
        g0.p(source, "source");
        while (j6 > 0) {
            long read = source.read(realBufferedSink.bufferField, j6);
            if (read != -1) {
                j6 -= read;
                realBufferedSink.emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return realBufferedSink;
    }
}
