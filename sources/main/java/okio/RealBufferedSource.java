package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.text.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRealBufferedSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealBufferedSource.kt\nokio/RealBufferedSource\n+ 2 RealBufferedSource.kt\nokio/internal/-RealBufferedSource\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 BufferedSource.kt\nokio/internal/-BufferedSource\n+ 5 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,207:1\n63#1:213\n63#1:224\n63#1:231\n63#1:237\n63#1:239\n63#1:243\n63#1:248\n63#1:266\n63#1:270\n63#1:277\n63#1:290\n63#1:299\n63#1:300\n63#1:301\n63#1:307\n63#1:315\n63#1:328\n63#1:332\n63#1:333\n63#1:334\n63#1:335\n63#1:340\n63#1:352\n63#1:368\n63#1:378\n63#1:381\n63#1:384\n63#1:387\n63#1:390\n63#1:393\n63#1:399\n63#1:416\n63#1:436\n63#1:451\n63#1:468\n63#1:495\n39#2:208\n40#2,3:210\n43#2,7:214\n53#2:221\n54#2:223\n58#2,2:225\n62#2:227\n63#2,2:229\n65#2,3:232\n71#2,2:235\n76#2:238\n77#2:240\n81#2,2:241\n86#2:244\n88#2,2:246\n90#2,13:249\n109#2:265\n110#2:267\n114#2,2:268\n119#2,6:271\n125#2,9:278\n136#2,3:287\n139#2,6:291\n145#2:298\n149#2,5:302\n154#2,5:308\n161#2,2:313\n163#2,11:316\n177#2:327\n178#2:329\n182#2,2:330\n187#2,4:336\n191#2,6:341\n201#2:347\n202#2,3:349\n205#2,8:353\n213#2,3:362\n220#2,3:365\n223#2,7:369\n233#2,2:376\n238#2,2:379\n243#2,2:382\n248#2,2:385\n253#2,2:388\n258#2,2:391\n263#2,5:394\n268#2,11:400\n282#2,5:411\n287#2,14:417\n304#2,2:431\n306#2,2:434\n308#2,7:437\n317#2,2:444\n319#2,4:447\n323#2,11:452\n421#2,2:463\n424#2,2:466\n426#2,7:469\n442#2:476\n444#2,12:478\n459#2:490\n463#2,4:491\n467#2:496\n469#2:497\n471#2:498\n1#3:209\n1#3:222\n1#3:228\n1#3:245\n1#3:348\n1#3:433\n1#3:446\n1#3:465\n1#3:477\n26#4,3:262\n88#5:297\n88#5:361\n*S KotlinDebug\n*F\n+ 1 RealBufferedSource.kt\nokio/RealBufferedSource\n*L\n67#1:213\n68#1:224\n70#1:231\n71#1:237\n72#1:239\n73#1:243\n74#1:248\n76#1:266\n77#1:270\n79#1:277\n81#1:290\n84#1:299\n85#1:300\n89#1:301\n93#1:307\n94#1:315\n95#1:328\n96#1:332\n99#1:333\n100#1:334\n105#1:335\n108#1:340\n110#1:352\n111#1:368\n112#1:378\n113#1:381\n114#1:384\n115#1:387\n116#1:390\n117#1:393\n118#1:399\n119#1:416\n120#1:436\n125#1:451\n135#1:468\n203#1:495\n67#1:208\n67#1:210,3\n67#1:214,7\n68#1:221\n68#1:223\n69#1:225,2\n70#1:227\n70#1:229,2\n70#1:232,3\n71#1:235,2\n72#1:238\n72#1:240\n73#1:241,2\n74#1:244\n74#1:246,2\n74#1:249,13\n76#1:265\n76#1:267\n77#1:268,2\n79#1:271,6\n79#1:278,9\n81#1:287,3\n81#1:291,6\n81#1:298\n93#1:302,5\n93#1:308,5\n94#1:313,2\n94#1:316,11\n95#1:327\n95#1:329\n96#1:330,2\n108#1:336,4\n108#1:341,6\n110#1:347\n110#1:349,3\n110#1:353,8\n110#1:362,3\n111#1:365,3\n111#1:369,7\n112#1:376,2\n113#1:379,2\n114#1:382,2\n115#1:385,2\n116#1:388,2\n117#1:391,2\n118#1:394,5\n118#1:400,11\n119#1:411,5\n119#1:417,14\n120#1:431,2\n120#1:434,2\n120#1:437,7\n125#1:444,2\n125#1:447,4\n125#1:452,11\n135#1:463,2\n135#1:466,2\n135#1:469,7\n149#1:476\n149#1:478,12\n151#1:490\n203#1:491,4\n203#1:496\n204#1:497\n205#1:498\n67#1:209\n68#1:222\n70#1:228\n74#1:245\n110#1:348\n120#1:433\n125#1:446\n135#1:465\n149#1:477\n75#1:262,3\n81#1:297\n110#1:361\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class RealBufferedSource implements BufferedSource {

    @JvmField
    @NotNull
    public final Buffer bufferField;

    @JvmField
    public boolean closed;

    @JvmField
    @NotNull
    public final Source source;

    @Override // okio.BufferedSource
    public long indexOf(byte b6) {
        return indexOf(b6, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString targetBytes) {
        g0.p(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0L);
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j6, @NotNull ByteString bytes) {
        g0.p(bytes, "bytes");
        return rangeEquals(j6, bytes, 0, bytes.size());
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] sink) {
        g0.p(sink, "sink");
        return read(sink, 0, sink.length);
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull byte[] sink) {
        g0.p(sink, "sink");
        try {
            require(sink.length);
            this.bufferField.readFully(sink);
        } catch (EOFException e6) {
            int i6 = 0;
            while (this.bufferField.size() > 0) {
                Buffer buffer = this.bufferField;
                int read = buffer.read(sink, i6, (int) buffer.size());
                if (read == -1) {
                    throw new AssertionError();
                }
                i6 += read;
            }
            throw e6;
        }
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(long j6, @NotNull Charset charset) {
        g0.p(charset, "charset");
        require(j6);
        return this.bufferField.readString(j6, charset);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public int select(@NotNull Options options) {
        g0.p(options, "options");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        do {
            int selectPrefix = okio.internal.Buffer.selectPrefix(this.bufferField, options, true);
            if (selectPrefix != -2) {
                if (selectPrefix == -1) {
                    return -1;
                }
                this.bufferField.skip(options.getByteStrings$okio()[selectPrefix].size());
                return selectPrefix;
            }
        } while (this.source.read(this.bufferField, 8192L) != -1);
        return -1;
    }

    public RealBufferedSource(@NotNull Source source) {
        g0.p(source, "source");
        this.source = source;
        this.bufferField = new Buffer();
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer buffer() {
        return this.bufferField;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.bufferField.clear();
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        return this.bufferField.exhausted() && this.source.read(this.bufferField, 8192L) == -1;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b6, long j6) {
        return indexOf(b6, j6, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString targetBytes, long j6) {
        g0.p(targetBytes, "targetBytes");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOfElement = this.bufferField.indexOfElement(targetBytes, j6);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            long size = this.bufferField.size();
            if (this.source.read(this.bufferField, 8192L) == -1) {
                return -1L;
            }
            j6 = Math.max(j6, size);
        }
    }

    @Override // okio.BufferedSource
    @NotNull
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.RealBufferedSource$inputStream$1
            @Override // java.io.InputStream
            public int read() {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (realBufferedSource.closed) {
                    throw new IOException("closed");
                }
                if (realBufferedSource.bufferField.size() == 0) {
                    RealBufferedSource realBufferedSource2 = RealBufferedSource.this;
                    if (realBufferedSource2.source.read(realBufferedSource2.bufferField, 8192L) == -1) {
                        return -1;
                    }
                }
                return RealBufferedSource.this.bufferField.readByte() & 255;
            }

            @Override // java.io.InputStream
            public int available() {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (realBufferedSource.closed) {
                    throw new IOException("closed");
                }
                return (int) Math.min(realBufferedSource.bufferField.size(), Integer.MAX_VALUE);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                RealBufferedSource.this.close();
            }

            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public long transferTo(OutputStream out) {
                g0.p(out, "out");
                if (RealBufferedSource.this.closed) {
                    throw new IOException("closed");
                }
                long j6 = 0;
                while (true) {
                    if (RealBufferedSource.this.bufferField.size() == 0) {
                        RealBufferedSource realBufferedSource = RealBufferedSource.this;
                        if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                            return j6;
                        }
                    }
                    j6 += RealBufferedSource.this.bufferField.size();
                    Buffer.writeTo$default(RealBufferedSource.this.bufferField, out, 0L, 2, null);
                }
            }

            @Override // java.io.InputStream
            public int read(byte[] data, int i6, int i7) {
                g0.p(data, "data");
                if (!RealBufferedSource.this.closed) {
                    SegmentedByteString.checkOffsetAndCount(data.length, i6, i7);
                    if (RealBufferedSource.this.bufferField.size() == 0) {
                        RealBufferedSource realBufferedSource = RealBufferedSource.this;
                        if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                            return -1;
                        }
                    }
                    return RealBufferedSource.this.bufferField.read(data, i6, i7);
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.BufferedSource
    @NotNull
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.Source
    public long read(@NotNull Buffer sink, long j6) {
        g0.p(sink, "sink");
        if (j6 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.bufferField.size() == 0) {
            if (j6 == 0) {
                return 0L;
            }
            if (this.source.read(this.bufferField, 8192L) == -1) {
                return -1L;
            }
        }
        return this.bufferField.read(sink, Math.min(j6, this.bufferField.size()));
    }

    @Override // okio.BufferedSource
    public long readAll(@NotNull Sink sink) {
        g0.p(sink, "sink");
        long j6 = 0;
        while (this.source.read(this.bufferField, 8192L) != -1) {
            long completeSegmentByteCount = this.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j6 += completeSegmentByteCount;
                sink.write(this.bufferField, completeSegmentByteCount);
            }
        }
        if (this.bufferField.size() <= 0) {
            return j6;
        }
        long size = j6 + this.bufferField.size();
        Buffer buffer = this.bufferField;
        sink.write(buffer, buffer.size());
        return size;
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        require(1L);
        return this.bufferField.readByte();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        if (r4 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        r1 = new java.lang.StringBuilder();
        r1.append("Expected a digit or '-' but was 0x");
        r2 = java.lang.Integer.toString(r8, kotlin.text.b.a(16));
        kotlin.jvm.internal.g0.o(r2, "toString(...)");
        r1.append(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
    
        throw new java.lang.NumberFormatException(r1.toString());
     */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readDecimalLong() {
        /*
            r10 = this;
            r0 = 1
            r10.require(r0)
            r2 = 0
            r4 = r2
        L8:
            long r6 = r4 + r0
            boolean r8 = r10.request(r6)
            if (r8 == 0) goto L52
            okio.Buffer r8 = r10.bufferField
            byte r8 = r8.getByte(r4)
            r9 = 48
            if (r8 < r9) goto L1e
            r9 = 57
            if (r8 <= r9) goto L27
        L1e:
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 != 0) goto L29
            r4 = 45
            if (r8 == r4) goto L27
            goto L29
        L27:
            r4 = r6
            goto L8
        L29:
            if (r9 == 0) goto L2c
            goto L52
        L2c:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected a digit or '-' but was 0x"
            r1.append(r2)
            r2 = 16
            int r2 = kotlin.text.b.a(r2)
            java.lang.String r2 = java.lang.Integer.toString(r8, r2)
            java.lang.String r3 = "toString(...)"
            kotlin.jvm.internal.g0.o(r2, r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L52:
            okio.Buffer r0 = r10.bufferField
            long r0 = r0.readDecimalLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.readDecimalLong():long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        if (r0 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        r1 = new java.lang.StringBuilder();
        r1.append("Expected leading [0-9a-fA-F] character but was 0x");
        r2 = java.lang.Integer.toString(r2, kotlin.text.b.a(16));
        kotlin.jvm.internal.g0.o(r2, "toString(...)");
        r1.append(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0059, code lost:
    
        throw new java.lang.NumberFormatException(r1.toString());
     */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readHexadecimalUnsignedLong() {
        /*
            r5 = this;
            r0 = 1
            r5.require(r0)
            r0 = 0
        L6:
            int r1 = r0 + 1
            long r2 = (long) r1
            boolean r2 = r5.request(r2)
            if (r2 == 0) goto L5a
            okio.Buffer r2 = r5.bufferField
            long r3 = (long) r0
            byte r2 = r2.getByte(r3)
            r3 = 48
            if (r2 < r3) goto L1e
            r3 = 57
            if (r2 <= r3) goto L2f
        L1e:
            r3 = 97
            if (r2 < r3) goto L26
            r3 = 102(0x66, float:1.43E-43)
            if (r2 <= r3) goto L2f
        L26:
            r3 = 65
            if (r2 < r3) goto L31
            r3 = 70
            if (r2 <= r3) goto L2f
            goto L31
        L2f:
            r0 = r1
            goto L6
        L31:
            if (r0 == 0) goto L34
            goto L5a
        L34:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r3)
            r3 = 16
            int r3 = kotlin.text.b.a(r3)
            java.lang.String r2 = java.lang.Integer.toString(r2, r3)
            java.lang.String r3 = "toString(...)"
            kotlin.jvm.internal.g0.o(r2, r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L5a:
            okio.Buffer r0 = r5.bufferField
            long r0 = r0.readHexadecimalUnsignedLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.readHexadecimalUnsignedLong():long");
    }

    @Override // okio.BufferedSource
    public int readInt() {
        require(4L);
        return this.bufferField.readInt();
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        require(4L);
        return this.bufferField.readIntLe();
    }

    @Override // okio.BufferedSource
    public long readLong() {
        require(8L);
        return this.bufferField.readLong();
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        require(8L);
        return this.bufferField.readLongLe();
    }

    @Override // okio.BufferedSource
    public short readShort() {
        require(2L);
        return this.bufferField.readShort();
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        require(2L);
        return this.bufferField.readShortLe();
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() {
        require(1L);
        byte b6 = this.bufferField.getByte(0L);
        if ((b6 & 224) == 192) {
            require(2L);
        } else if ((b6 & 240) == 224) {
            require(3L);
        } else if ((b6 & 248) == 240) {
            require(4L);
        }
        return this.bufferField.readUtf8CodePoint();
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return okio.internal.Buffer.readUtf8Line(this.bufferField, indexOf);
        }
        if (this.bufferField.size() != 0) {
            return readUtf8(this.bufferField.size());
        }
        return null;
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict(long j6) {
        if (j6 < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j6).toString());
        }
        long j7 = j6 == Long.MAX_VALUE ? Long.MAX_VALUE : j6 + 1;
        long indexOf = indexOf((byte) 10, 0L, j7);
        if (indexOf != -1) {
            return okio.internal.Buffer.readUtf8Line(this.bufferField, indexOf);
        }
        if (j7 < Long.MAX_VALUE && request(j7) && this.bufferField.getByte(j7 - 1) == 13 && request(1 + j7) && this.bufferField.getByte(j7) == 10) {
            return okio.internal.Buffer.readUtf8Line(this.bufferField, j7);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.bufferField;
        buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.size(), j6) + " content=" + buffer.readByteString().hex() + v0.F);
    }

    @Override // okio.BufferedSource
    public boolean request(long j6) {
        if (j6 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (this.bufferField.size() < j6) {
            if (this.source.read(this.bufferField, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public void skip(long j6) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (j6 > 0) {
            if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j6, this.bufferField.size());
            this.bufferField.skip(min);
            j6 -= min;
        }
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }

    @NotNull
    public String toString() {
        return "buffer(" + this.source + ')';
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString bytes) {
        g0.p(bytes, "bytes");
        return indexOf(bytes, 0L);
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j6, @NotNull ByteString bytes, int i6, int i7) {
        g0.p(bytes, "bytes");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        return i7 >= 0 && j6 >= 0 && i6 >= 0 && i6 + i7 <= bytes.size() && (i7 == 0 || okio.internal.RealBufferedSource.commonIndexOf(this, bytes, i6, i7, j6, j6 + 1) != -1);
    }

    @Override // okio.BufferedSource
    public void require(long j6) {
        if (request(j6)) {
        } else {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString bytes, long j6) {
        g0.p(bytes, "bytes");
        return indexOf(bytes, j6, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(@NotNull Charset charset) {
        g0.p(charset, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(charset);
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString bytes, long j6, long j7) {
        g0.p(bytes, "bytes");
        return okio.internal.RealBufferedSource.commonIndexOf$default(this, bytes, 0, 0, j6, j7, 6, null);
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray(long j6) {
        require(j6);
        return this.bufferField.readByteArray(j6);
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString(long j6) {
        require(j6);
        return this.bufferField.readByteString(j6);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8(long j6) {
        require(j6);
        return this.bufferField.readUtf8(j6);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b6, long j6, long j7) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (0 > j6 || j6 > j7) {
            throw new IllegalArgumentException(("fromIndex=" + j6 + " toIndex=" + j7).toString());
        }
        long j8 = j6;
        while (j8 < j7) {
            byte b7 = b6;
            long j9 = j7;
            long indexOf = this.bufferField.indexOf(b7, j8, j9);
            if (indexOf == -1) {
                long size = this.bufferField.size();
                if (size >= j9 || this.source.read(this.bufferField, 8192L) == -1) {
                    break;
                }
                j8 = Math.max(j8, size);
                b6 = b7;
                j7 = j9;
            } else {
                return indexOf;
            }
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull Buffer sink, long j6) {
        g0.p(sink, "sink");
        try {
            require(j6);
            this.bufferField.readFully(sink, j6);
        } catch (EOFException e6) {
            sink.writeAll(this.bufferField);
            throw e6;
        }
    }

    @Override // okio.BufferedSource
    @Nullable
    public <T> T select(@NotNull TypedOptions<T> options) {
        g0.p(options, "options");
        int select = select(options.getOptions$okio());
        if (select == -1) {
            return null;
        }
        return options.get(select);
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] sink, int i6, int i7) {
        g0.p(sink, "sink");
        long j6 = i7;
        SegmentedByteString.checkOffsetAndCount(sink.length, i6, j6);
        if (this.bufferField.size() == 0) {
            if (i7 == 0) {
                return 0;
            }
            if (this.source.read(this.bufferField, 8192L) == -1) {
                return -1;
            }
        }
        return this.bufferField.read(sink, i6, (int) Math.min(j6, this.bufferField.size()));
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@NotNull ByteBuffer sink) {
        g0.p(sink, "sink");
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192L) == -1) {
            return -1;
        }
        return this.bufferField.read(sink);
    }
}
