package okio.internal;

import java.io.EOFException;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.text.v0;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "-RealBufferedSource")
@SourceDebugExtension({"SMAP\nRealBufferedSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealBufferedSource.kt\nokio/internal/-RealBufferedSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 RealBufferedSource.kt\nokio/RealBufferedSource\n+ 4 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,472:1\n1#2:473\n63#3:474\n63#3:475\n63#3:476\n63#3:477\n63#3:478\n63#3:479\n63#3:480\n63#3:481\n63#3:482\n63#3:483\n63#3:484\n63#3:485\n63#3:486\n63#3:487\n63#3:488\n63#3:489\n63#3:490\n63#3:491\n63#3:492\n63#3:493\n63#3:494\n63#3:495\n63#3:496\n63#3:498\n63#3:499\n63#3:500\n63#3:501\n63#3:502\n63#3:503\n63#3:504\n63#3:505\n63#3:506\n63#3:507\n63#3:508\n63#3:509\n63#3:510\n63#3:511\n63#3:512\n63#3:513\n63#3:514\n63#3:515\n63#3:516\n63#3:517\n63#3:519\n63#3:520\n63#3:521\n63#3:522\n63#3:523\n63#3:524\n63#3:525\n63#3:526\n63#3:527\n63#3:528\n63#3:529\n63#3:530\n63#3:531\n63#3:532\n63#3:533\n63#3:534\n63#3:535\n63#3:536\n63#3:537\n63#3:538\n63#3:539\n63#3:540\n63#3:541\n63#3:543\n63#3:544\n63#3:545\n63#3:546\n88#4:497\n88#4:518\n88#4:542\n*S KotlinDebug\n*F\n+ 1 RealBufferedSource.kt\nokio/internal/-RealBufferedSource\n*L\n42#1:474\n44#1:475\n48#1:476\n49#1:477\n54#1:478\n64#1:479\n65#1:480\n72#1:481\n76#1:482\n77#1:483\n82#1:484\n89#1:485\n96#1:486\n101#1:487\n109#1:488\n110#1:489\n115#1:490\n124#1:491\n125#1:492\n132#1:493\n138#1:494\n140#1:495\n144#1:496\n145#1:498\n153#1:499\n157#1:500\n162#1:501\n163#1:502\n166#1:503\n169#1:504\n170#1:505\n171#1:506\n177#1:507\n178#1:508\n183#1:509\n190#1:510\n191#1:511\n196#1:512\n204#1:513\n206#1:514\n207#1:515\n209#1:516\n212#1:517\n214#1:519\n222#1:520\n229#1:521\n234#1:522\n239#1:523\n244#1:524\n249#1:525\n254#1:526\n259#1:527\n267#1:528\n278#1:529\n286#1:530\n300#1:531\n307#1:532\n310#1:533\n311#1:534\n322#1:535\n327#1:536\n328#1:537\n349#1:538\n358#1:539\n362#1:540\n372#1:541\n425#1:543\n428#1:544\n429#1:545\n466#1:546\n144#1:497\n212#1:518\n406#1:542\n*E\n"})
/* renamed from: okio.internal.-RealBufferedSource, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class RealBufferedSource {
    public static final long commonIndexOf(@NotNull okio.RealBufferedSource realBufferedSource, byte b6, long j6, long j7) {
        g0.p(realBufferedSource, "<this>");
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed");
        }
        if (0 > j6 || j6 > j7) {
            throw new IllegalArgumentException(("fromIndex=" + j6 + " toIndex=" + j7).toString());
        }
        long j8 = j6;
        while (j8 < j7) {
            byte b7 = b6;
            long j9 = j7;
            long indexOf = realBufferedSource.bufferField.indexOf(b7, j8, j9);
            if (indexOf == -1) {
                long size = realBufferedSource.bufferField.size();
                if (size >= j9 || realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
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

    public static final long commonRead(@NotNull okio.RealBufferedSource realBufferedSource, @NotNull Buffer sink, long j6) {
        g0.p(realBufferedSource, "<this>");
        g0.p(sink, "sink");
        if (j6 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        }
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed");
        }
        if (realBufferedSource.bufferField.size() == 0) {
            if (j6 == 0) {
                return 0L;
            }
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                return -1L;
            }
        }
        return realBufferedSource.bufferField.read(sink, Math.min(j6, realBufferedSource.bufferField.size()));
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull okio.RealBufferedSource realBufferedSource, long j6) {
        g0.p(realBufferedSource, "<this>");
        realBufferedSource.require(j6);
        return realBufferedSource.bufferField.readByteArray(j6);
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull okio.RealBufferedSource realBufferedSource, long j6) {
        g0.p(realBufferedSource, "<this>");
        realBufferedSource.require(j6);
        return realBufferedSource.bufferField.readByteString(j6);
    }

    public static final void commonReadFully(@NotNull okio.RealBufferedSource realBufferedSource, @NotNull byte[] sink) {
        g0.p(realBufferedSource, "<this>");
        g0.p(sink, "sink");
        try {
            realBufferedSource.require(sink.length);
            realBufferedSource.bufferField.readFully(sink);
        } catch (EOFException e6) {
            int i6 = 0;
            while (realBufferedSource.bufferField.size() > 0) {
                Buffer buffer = realBufferedSource.bufferField;
                int read = buffer.read(sink, i6, (int) buffer.size());
                if (read == -1) {
                    throw new AssertionError();
                }
                i6 += read;
            }
            throw e6;
        }
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull okio.RealBufferedSource realBufferedSource, long j6) {
        g0.p(realBufferedSource, "<this>");
        realBufferedSource.require(j6);
        return realBufferedSource.bufferField.readUtf8(j6);
    }

    public static final void commonClose(@NotNull okio.RealBufferedSource realBufferedSource) {
        g0.p(realBufferedSource, "<this>");
        if (realBufferedSource.closed) {
            return;
        }
        realBufferedSource.closed = true;
        realBufferedSource.source.close();
        realBufferedSource.bufferField.clear();
    }

    public static final boolean commonExhausted(@NotNull okio.RealBufferedSource realBufferedSource) {
        g0.p(realBufferedSource, "<this>");
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed");
        }
        return realBufferedSource.bufferField.exhausted() && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1;
    }

    public static /* synthetic */ long commonIndexOf$default(okio.RealBufferedSource realBufferedSource, ByteString byteString, int i6, int i7, long j6, long j7, int i8, Object obj) {
        int i9 = (i8 & 2) != 0 ? 0 : i6;
        if ((i8 & 4) != 0) {
            i7 = byteString.size();
        }
        return commonIndexOf(realBufferedSource, byteString, i9, i7, j6, (i8 & 16) != 0 ? Long.MAX_VALUE : j7);
    }

    public static final long commonIndexOfElement(@NotNull okio.RealBufferedSource realBufferedSource, @NotNull ByteString targetBytes, long j6) {
        g0.p(realBufferedSource, "<this>");
        g0.p(targetBytes, "targetBytes");
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long indexOfElement = realBufferedSource.bufferField.indexOfElement(targetBytes, j6);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            long size = realBufferedSource.bufferField.size();
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                return -1L;
            }
            j6 = Math.max(j6, size);
        }
    }

    @NotNull
    public static final BufferedSource commonPeek(@NotNull okio.RealBufferedSource realBufferedSource) {
        g0.p(realBufferedSource, "<this>");
        return Okio.buffer(new PeekSource(realBufferedSource));
    }

    public static final boolean commonRangeEquals(@NotNull okio.RealBufferedSource realBufferedSource, long j6, @NotNull ByteString bytes, int i6, int i7) {
        g0.p(realBufferedSource, "<this>");
        g0.p(bytes, "bytes");
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed");
        }
        return i7 >= 0 && j6 >= 0 && i6 >= 0 && i6 + i7 <= bytes.size() && (i7 == 0 || commonIndexOf(realBufferedSource, bytes, i6, i7, j6, j6 + 1) != -1);
    }

    public static final long commonReadAll(@NotNull okio.RealBufferedSource realBufferedSource, @NotNull Sink sink) {
        g0.p(realBufferedSource, "<this>");
        g0.p(sink, "sink");
        long j6 = 0;
        while (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) != -1) {
            long completeSegmentByteCount = realBufferedSource.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j6 += completeSegmentByteCount;
                sink.write(realBufferedSource.bufferField, completeSegmentByteCount);
            }
        }
        if (realBufferedSource.bufferField.size() <= 0) {
            return j6;
        }
        long size = j6 + realBufferedSource.bufferField.size();
        Buffer buffer = realBufferedSource.bufferField;
        sink.write(buffer, buffer.size());
        return size;
    }

    public static final byte commonReadByte(@NotNull okio.RealBufferedSource realBufferedSource) {
        g0.p(realBufferedSource, "<this>");
        realBufferedSource.require(1L);
        return realBufferedSource.bufferField.readByte();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
    
        if (r4 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append("Expected a digit or '-' but was 0x");
        r1 = java.lang.Integer.toString(r8, kotlin.text.b.a(16));
        kotlin.jvm.internal.g0.o(r1, "toString(...)");
        r0.append(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
    
        throw new java.lang.NumberFormatException(r0.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadDecimalLong(@org.jetbrains.annotations.NotNull okio.RealBufferedSource r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.g0.p(r10, r0)
            r0 = 1
            r10.require(r0)
            r2 = 0
            r4 = r2
        Ld:
            long r6 = r4 + r0
            boolean r8 = r10.request(r6)
            if (r8 == 0) goto L57
            okio.Buffer r8 = r10.bufferField
            byte r8 = r8.getByte(r4)
            r9 = 48
            if (r8 < r9) goto L23
            r9 = 57
            if (r8 <= r9) goto L2c
        L23:
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 != 0) goto L2e
            r4 = 45
            if (r8 == r4) goto L2c
            goto L2e
        L2c:
            r4 = r6
            goto Ld
        L2e:
            if (r9 == 0) goto L31
            goto L57
        L31:
            java.lang.NumberFormatException r10 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected a digit or '-' but was 0x"
            r0.append(r1)
            r1 = 16
            int r1 = kotlin.text.b.a(r1)
            java.lang.String r1 = java.lang.Integer.toString(r8, r1)
            java.lang.String r2 = "toString(...)"
            kotlin.jvm.internal.g0.o(r1, r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        L57:
            okio.Buffer r10 = r10.bufferField
            long r0 = r10.readDecimalLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.RealBufferedSource.commonReadDecimalLong(okio.RealBufferedSource):long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
    
        if (r0 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append("Expected leading [0-9a-fA-F] character but was 0x");
        r1 = java.lang.Integer.toString(r2, kotlin.text.b.a(16));
        kotlin.jvm.internal.g0.o(r1, "toString(...)");
        r0.append(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
    
        throw new java.lang.NumberFormatException(r0.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadHexadecimalUnsignedLong(@org.jetbrains.annotations.NotNull okio.RealBufferedSource r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.g0.p(r5, r0)
            r0 = 1
            r5.require(r0)
            r0 = 0
        Lb:
            int r1 = r0 + 1
            long r2 = (long) r1
            boolean r2 = r5.request(r2)
            if (r2 == 0) goto L5f
            okio.Buffer r2 = r5.bufferField
            long r3 = (long) r0
            byte r2 = r2.getByte(r3)
            r3 = 48
            if (r2 < r3) goto L23
            r3 = 57
            if (r2 <= r3) goto L34
        L23:
            r3 = 97
            if (r2 < r3) goto L2b
            r3 = 102(0x66, float:1.43E-43)
            if (r2 <= r3) goto L34
        L2b:
            r3 = 65
            if (r2 < r3) goto L36
            r3 = 70
            if (r2 <= r3) goto L34
            goto L36
        L34:
            r0 = r1
            goto Lb
        L36:
            if (r0 == 0) goto L39
            goto L5f
        L39:
            java.lang.NumberFormatException r5 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            r0.append(r1)
            r1 = 16
            int r1 = kotlin.text.b.a(r1)
            java.lang.String r1 = java.lang.Integer.toString(r2, r1)
            java.lang.String r2 = "toString(...)"
            kotlin.jvm.internal.g0.o(r1, r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L5f:
            okio.Buffer r5 = r5.bufferField
            long r0 = r5.readHexadecimalUnsignedLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.RealBufferedSource.commonReadHexadecimalUnsignedLong(okio.RealBufferedSource):long");
    }

    public static final int commonReadInt(@NotNull okio.RealBufferedSource realBufferedSource) {
        g0.p(realBufferedSource, "<this>");
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readInt();
    }

    public static final int commonReadIntLe(@NotNull okio.RealBufferedSource realBufferedSource) {
        g0.p(realBufferedSource, "<this>");
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readIntLe();
    }

    public static final long commonReadLong(@NotNull okio.RealBufferedSource realBufferedSource) {
        g0.p(realBufferedSource, "<this>");
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLong();
    }

    public static final long commonReadLongLe(@NotNull okio.RealBufferedSource realBufferedSource) {
        g0.p(realBufferedSource, "<this>");
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLongLe();
    }

    public static final short commonReadShort(@NotNull okio.RealBufferedSource realBufferedSource) {
        g0.p(realBufferedSource, "<this>");
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShort();
    }

    public static final short commonReadShortLe(@NotNull okio.RealBufferedSource realBufferedSource) {
        g0.p(realBufferedSource, "<this>");
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShortLe();
    }

    public static final int commonReadUtf8CodePoint(@NotNull okio.RealBufferedSource realBufferedSource) {
        g0.p(realBufferedSource, "<this>");
        realBufferedSource.require(1L);
        byte b6 = realBufferedSource.bufferField.getByte(0L);
        if ((b6 & 224) == 192) {
            realBufferedSource.require(2L);
        } else if ((b6 & 240) == 224) {
            realBufferedSource.require(3L);
        } else if ((b6 & 248) == 240) {
            realBufferedSource.require(4L);
        }
        return realBufferedSource.bufferField.readUtf8CodePoint();
    }

    @Nullable
    public static final String commonReadUtf8Line(@NotNull okio.RealBufferedSource realBufferedSource) {
        g0.p(realBufferedSource, "<this>");
        long indexOf = realBufferedSource.indexOf((byte) 10);
        if (indexOf != -1) {
            return Buffer.readUtf8Line(realBufferedSource.bufferField, indexOf);
        }
        if (realBufferedSource.bufferField.size() != 0) {
            return realBufferedSource.readUtf8(realBufferedSource.bufferField.size());
        }
        return null;
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull okio.RealBufferedSource realBufferedSource, long j6) {
        g0.p(realBufferedSource, "<this>");
        if (j6 < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j6).toString());
        }
        long j7 = j6 == Long.MAX_VALUE ? Long.MAX_VALUE : j6 + 1;
        long indexOf = realBufferedSource.indexOf((byte) 10, 0L, j7);
        if (indexOf != -1) {
            return Buffer.readUtf8Line(realBufferedSource.bufferField, indexOf);
        }
        if (j7 < Long.MAX_VALUE && realBufferedSource.request(j7) && realBufferedSource.bufferField.getByte(j7 - 1) == 13 && realBufferedSource.request(1 + j7) && realBufferedSource.bufferField.getByte(j7) == 10) {
            return Buffer.readUtf8Line(realBufferedSource.bufferField, j7);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = realBufferedSource.bufferField;
        buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(realBufferedSource.bufferField.size(), j6) + " content=" + buffer.readByteString().hex() + v0.F);
    }

    public static final boolean commonRequest(@NotNull okio.RealBufferedSource realBufferedSource, long j6) {
        g0.p(realBufferedSource, "<this>");
        if (j6 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
        }
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed");
        }
        while (realBufferedSource.bufferField.size() < j6) {
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    public static final void commonRequire(@NotNull okio.RealBufferedSource realBufferedSource, long j6) {
        g0.p(realBufferedSource, "<this>");
        if (!realBufferedSource.request(j6)) {
            throw new EOFException();
        }
    }

    public static final int commonSelect(@NotNull okio.RealBufferedSource realBufferedSource, @NotNull Options options) {
        g0.p(realBufferedSource, "<this>");
        g0.p(options, "options");
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed");
        }
        do {
            int selectPrefix = Buffer.selectPrefix(realBufferedSource.bufferField, options, true);
            if (selectPrefix != -2) {
                if (selectPrefix == -1) {
                    return -1;
                }
                realBufferedSource.bufferField.skip(options.getByteStrings$okio()[selectPrefix].size());
                return selectPrefix;
            }
        } while (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) != -1);
        return -1;
    }

    public static final void commonSkip(@NotNull okio.RealBufferedSource realBufferedSource, long j6) {
        g0.p(realBufferedSource, "<this>");
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed");
        }
        while (j6 > 0) {
            if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j6, realBufferedSource.bufferField.size());
            realBufferedSource.bufferField.skip(min);
            j6 -= min;
        }
    }

    @NotNull
    public static final Timeout commonTimeout(@NotNull okio.RealBufferedSource realBufferedSource) {
        g0.p(realBufferedSource, "<this>");
        return realBufferedSource.source.timeout();
    }

    @NotNull
    public static final String commonToString(@NotNull okio.RealBufferedSource realBufferedSource) {
        g0.p(realBufferedSource, "<this>");
        return "buffer(" + realBufferedSource.source + ')';
    }

    private static final boolean isMatchPossibleByExpandingBuffer(Buffer buffer, ByteString byteString, int i6, int i7, long j6, long j7) {
        if (buffer.size() < j7) {
            return true;
        }
        int max = (int) Math.max(1L, (buffer.size() - j7) + 1);
        int min = ((int) Math.min(i7, (buffer.size() - j6) + 1)) - 1;
        if (max <= min) {
            for (int i8 = min; !buffer.rangeEquals(buffer.size() - i8, byteString, i6, i8); i8--) {
                if (i8 == max) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull okio.RealBufferedSource realBufferedSource) {
        g0.p(realBufferedSource, "<this>");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteArray();
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull okio.RealBufferedSource realBufferedSource) {
        g0.p(realBufferedSource, "<this>");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteString();
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull okio.RealBufferedSource realBufferedSource) {
        g0.p(realBufferedSource, "<this>");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readUtf8();
    }

    public static final void commonReadFully(@NotNull okio.RealBufferedSource realBufferedSource, @NotNull Buffer sink, long j6) {
        g0.p(realBufferedSource, "<this>");
        g0.p(sink, "sink");
        try {
            realBufferedSource.require(j6);
            realBufferedSource.bufferField.readFully(sink, j6);
        } catch (EOFException e6) {
            sink.writeAll(realBufferedSource.bufferField);
            throw e6;
        }
    }

    public static final long commonIndexOf(@NotNull okio.RealBufferedSource realBufferedSource, @NotNull ByteString byteString, int i6, int i7, long j6, long j7) {
        g0.p(realBufferedSource, "<this>");
        ByteString bytes = byteString;
        g0.p(bytes, "bytes");
        int i8 = i6;
        long j8 = i7;
        SegmentedByteString.checkOffsetAndCount(bytes.size(), i8, j8);
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed");
        }
        long j9 = j6;
        while (true) {
            long commonIndexOf = Buffer.commonIndexOf(realBufferedSource.bufferField, bytes, j9, j7, i8, i7);
            if (commonIndexOf != -1) {
                return commonIndexOf;
            }
            long size = (realBufferedSource.bufferField.size() - j8) + 1;
            if (size >= j7) {
                return -1L;
            }
            long j10 = j9;
            if (!isMatchPossibleByExpandingBuffer(realBufferedSource.bufferField, byteString, i6, i7, j10, j7) || realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                return -1L;
            }
            j9 = Math.max(j10, size);
            bytes = byteString;
            i8 = i6;
        }
    }

    public static final int commonRead(@NotNull okio.RealBufferedSource realBufferedSource, @NotNull byte[] sink, int i6, int i7) {
        g0.p(realBufferedSource, "<this>");
        g0.p(sink, "sink");
        long j6 = i7;
        SegmentedByteString.checkOffsetAndCount(sink.length, i6, j6);
        if (realBufferedSource.bufferField.size() == 0) {
            if (i7 == 0) {
                return 0;
            }
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                return -1;
            }
        }
        return realBufferedSource.bufferField.read(sink, i6, (int) Math.min(j6, realBufferedSource.bufferField.size()));
    }
}
