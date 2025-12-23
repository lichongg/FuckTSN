package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class pblc {

    static final class pgla<A, B> {

        /* renamed from: a, reason: collision with root package name */
        private final A f50320a;

        /* renamed from: b, reason: collision with root package name */
        private final B f50321b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || pgla.class != obj.getClass()) {
                return false;
            }
            pgla pglaVar = (pgla) obj;
            A a6 = this.f50320a;
            if (a6 == null) {
                if (pglaVar.f50320a != null) {
                    return false;
                }
            } else if (!a6.equals(pglaVar.f50320a)) {
                return false;
            }
            B b6 = this.f50321b;
            B b7 = pglaVar.f50321b;
            return b6 == null ? b7 == null : b6.equals(b7);
        }

        public static pgla b(ByteBuffer byteBuffer, Long l6) {
            return new pgla(byteBuffer, l6);
        }

        public final A a() {
            return this.f50320a;
        }

        public final int hashCode() {
            A a6 = this.f50320a;
            int hashCode = ((a6 == null ? 0 : a6.hashCode()) + 31) * 31;
            B b6 = this.f50321b;
            return hashCode + (b6 != null ? b6.hashCode() : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private pgla(ByteBuffer byteBuffer, Long l6) {
            this.f50320a = byteBuffer;
            this.f50321b = l6;
        }
    }

    public static class pblb extends Exception {
        public pblb(String str) {
            super(str);
        }
    }

    public static HashMap a(String str) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            try {
                randomAccessFile = new RandomAccessFile(str, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d3c673", new byte[]{103}));
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
        }
        try {
            for (Map.Entry entry : b(c(randomAccessFile.getChannel()).a()).entrySet()) {
                if (entry != null && entry.getKey() != null && ((Integer) entry.getKey()).intValue() != 1896449818) {
                    try {
                        ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
                        byte[] array = byteBuffer.array();
                        int arrayOffset = byteBuffer.arrayOffset();
                        hashMap.put((Integer) entry.getKey(), new String(Arrays.copyOfRange(array, byteBuffer.position() + arrayOffset, byteBuffer.limit() + arrayOffset)));
                    } catch (Throwable unused3) {
                    }
                }
            }
            randomAccessFile.close();
        } catch (Throwable unused4) {
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            return hashMap;
        }
        return hashMap;
    }

    public static LinkedHashMap b(ByteBuffer byteBuffer) throws pblb {
        if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
            int capacity = byteBuffer.capacity() - 24;
            if (capacity >= 8) {
                byteBuffer.capacity();
                if (capacity <= byteBuffer.capacity()) {
                    int limit = byteBuffer.limit();
                    int position = byteBuffer.position();
                    try {
                        byteBuffer.position(0);
                        byteBuffer.limit(capacity);
                        byteBuffer.position(8);
                        ByteBuffer slice = byteBuffer.slice();
                        slice.order(byteBuffer.order());
                        byteBuffer.position(0);
                        byteBuffer.limit(limit);
                        byteBuffer.position(position);
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        while (slice.hasRemaining()) {
                            if (slice.remaining() >= 8) {
                                long j6 = slice.getLong();
                                if (j6 >= 4 && j6 <= 2147483647L) {
                                    int i6 = (int) j6;
                                    int position2 = slice.position() + i6;
                                    if (i6 <= slice.remaining()) {
                                        Integer valueOf = Integer.valueOf(slice.getInt());
                                        int i7 = i6 - 4;
                                        if (i7 >= 0) {
                                            int limit2 = slice.limit();
                                            int position3 = slice.position();
                                            int i8 = i7 + position3;
                                            if (i8 >= position3 && i8 <= limit2) {
                                                slice.limit(i8);
                                                try {
                                                    ByteBuffer slice2 = slice.slice();
                                                    slice2.order(slice.order());
                                                    slice.position(i8);
                                                    slice.limit(limit2);
                                                    linkedHashMap.put(valueOf, slice2);
                                                    slice.position(position2);
                                                } catch (Throwable th) {
                                                    slice.limit(limit2);
                                                    throw th;
                                                }
                                            } else {
                                                throw new BufferUnderflowException();
                                            }
                                        } else {
                                            throw new IllegalArgumentException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5d8fdd", new byte[]{118}));
                                        }
                                    } else {
                                        throw new pblb((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8b381f", new byte[]{113}));
                                    }
                                } else {
                                    throw new pblb((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bb5779", new byte[]{BinaryMemcacheOpcodes.GATKQ}));
                                }
                            } else {
                                throw new pblb((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c86e94", new byte[]{BinaryMemcacheOpcodes.GATKQ}));
                            }
                        }
                        return linkedHashMap;
                    } catch (Throwable th2) {
                        byteBuffer.position(0);
                        byteBuffer.limit(limit);
                        byteBuffer.position(position);
                        throw th2;
                    }
                }
                throw new IllegalArgumentException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c6d97c", new byte[]{39}));
            }
            throw new IllegalArgumentException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "41f187", new byte[]{113}));
        }
        throw new IllegalArgumentException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a9f96c", new byte[]{BinaryMemcacheOpcodes.SASL_AUTH}));
    }

    public static pgla<ByteBuffer, Long> c(FileChannel fileChannel) throws IOException, pblb {
        long size = fileChannel.size();
        if (size >= 22) {
            long j6 = size - 22;
            long min = Math.min(j6, WebSocketProtocol.PAYLOAD_SHORT_MAX);
            int i6 = 0;
            while (true) {
                long j7 = i6;
                if (j7 <= min) {
                    long j8 = j6 - j7;
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    fileChannel.position(j8);
                    fileChannel.read(allocate);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    allocate.order(byteOrder);
                    if (allocate.getInt(0) == 101010256) {
                        ByteBuffer allocate2 = ByteBuffer.allocate(2);
                        fileChannel.position(j8 + 20);
                        fileChannel.read(allocate2);
                        allocate2.order(byteOrder);
                        short s5 = allocate2.getShort(0);
                        if (s5 == i6) {
                            ByteBuffer allocate3 = ByteBuffer.allocate(4);
                            allocate3.order(byteOrder);
                            fileChannel.position((fileChannel.size() - s5) - 6);
                            fileChannel.read(allocate3);
                            long j9 = allocate3.getInt(0);
                            if (j9 >= 32) {
                                fileChannel.position(j9 - 24);
                                ByteBuffer allocate4 = ByteBuffer.allocate(24);
                                fileChannel.read(allocate4);
                                allocate4.order(byteOrder);
                                if (allocate4.getLong(8) == 2334950737559900225L && allocate4.getLong(16) == 3617552046287187010L) {
                                    long j10 = allocate4.getLong(0);
                                    if (j10 >= allocate4.capacity() && j10 <= 2147483639) {
                                        int i7 = (int) (8 + j10);
                                        long j11 = j9 - i7;
                                        if (j11 >= 0) {
                                            fileChannel.position(j11);
                                            ByteBuffer allocate5 = ByteBuffer.allocate(i7);
                                            fileChannel.read(allocate5);
                                            allocate5.order(byteOrder);
                                            if (allocate5.getLong(0) == j10) {
                                                return pgla.b(allocate5, Long.valueOf(j11));
                                            }
                                            return null;
                                        }
                                        return null;
                                    }
                                    return null;
                                }
                                return null;
                            }
                            throw new pblb((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b9677d", new byte[]{42}));
                        }
                    }
                    i6++;
                } else {
                    throw new IOException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "071727", new byte[]{112, 101}));
                }
            }
        } else {
            throw new IOException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "99b892", new byte[]{121, 106}));
        }
    }
}
