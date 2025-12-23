package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.MessageToByteEncoder;
import java.util.zip.Adler32;
import java.util.zip.Checksum;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class FastLzFrameEncoder extends MessageToByteEncoder<ByteBuf> {
    private final Checksum checksum;
    private final int level;

    public FastLzFrameEncoder() {
        this(0, null);
    }

    public FastLzFrameEncoder(int i6) {
        this(i6, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d4  */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void encode(io.netty.channel.ChannelHandlerContext r17, io.netty.buffer.ByteBuf r18, io.netty.buffer.ByteBuf r19) throws java.lang.Exception {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            r2 = r19
            java.util.zip.Checksum r3 = r0.checksum
        L8:
            boolean r4 = r1.isReadable()
            if (r4 != 0) goto Lf
            return
        Lf:
            int r4 = r1.readerIndex()
            int r5 = r1.readableBytes()
            r6 = 65535(0xffff, float:9.1834E-41)
            int r9 = java.lang.Math.min(r5, r6)
            int r5 = r2.writerIndex()
            r6 = 4607066(0x464c5a, float:6.455875E-39)
            r2.setMedium(r5, r6)
            int r6 = r5 + 4
            if (r3 == 0) goto L2e
            r7 = 4
            goto L2f
        L2e:
            r7 = 0
        L2f:
            int r14 = r6 + r7
            r7 = 32
            if (r9 >= r7) goto L79
            int r7 = r14 + 2
            int r7 = r7 + r9
            r2.ensureWritable(r7)
            byte[] r7 = r2.array()
            int r8 = r2.arrayOffset()
            int r8 = r8 + r14
            int r8 = r8 + 2
            if (r3 == 0) goto L71
            boolean r10 = r1.hasArray()
            if (r10 == 0) goto L58
            byte[] r10 = r1.array()
            int r11 = r1.arrayOffset()
            int r11 = r11 + r4
            goto L5e
        L58:
            byte[] r10 = new byte[r9]
            r1.getBytes(r4, r10)
            r11 = 0
        L5e:
            r3.reset()
            r3.update(r10, r11, r9)
            r15 = r14
            long r13 = r3.getValue()
            int r4 = (int) r13
            r2.setInt(r6, r4)
            java.lang.System.arraycopy(r10, r11, r7, r8, r9)
            goto L75
        L71:
            r15 = r14
            r1.getBytes(r4, r7, r8, r9)
        L75:
            r6 = r9
            r14 = r15
            r4 = 0
            goto Lca
        L79:
            r15 = r14
            boolean r7 = r1.hasArray()
            if (r7 == 0) goto L8a
            byte[] r7 = r1.array()
            int r8 = r1.arrayOffset()
            int r8 = r8 + r4
            goto L90
        L8a:
            byte[] r7 = new byte[r9]
            r1.getBytes(r4, r7)
            r8 = 0
        L90:
            if (r3 == 0) goto La0
            r3.reset()
            r3.update(r7, r8, r9)
            long r10 = r3.getValue()
            int r4 = (int) r10
            r2.setInt(r6, r4)
        La0:
            int r4 = io.netty.handler.codec.compression.FastLz.calculateOutputBufferLength(r9)
            int r14 = r15 + 4
            int r14 = r14 + r4
            r2.ensureWritable(r14)
            byte[] r10 = r2.array()
            int r4 = r2.arrayOffset()
            int r4 = r4 + r15
            int r11 = r4 + 4
            int r12 = r0.level
            int r6 = io.netty.handler.codec.compression.FastLz.compress(r7, r8, r9, r10, r11, r12)
            if (r6 >= r9) goto Lc4
            r2.setShort(r15, r6)
            int r14 = r15 + 2
            r4 = 1
            goto Lca
        Lc4:
            int r4 = r4 + 2
            java.lang.System.arraycopy(r7, r8, r10, r4, r9)
            goto L75
        Lca:
            r2.setShort(r14, r9)
            int r5 = r5 + 3
            if (r3 == 0) goto Ld4
            r13 = 16
            goto Ld5
        Ld4:
            r13 = 0
        Ld5:
            r4 = r4 | r13
            r2.setByte(r5, r4)
            int r14 = r14 + 2
            int r14 = r14 + r6
            r2.writerIndex(r14)
            r1.skipBytes(r9)
            goto L8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.FastLzFrameEncoder.encode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf):void");
    }

    public FastLzFrameEncoder(boolean z5) {
        this(0, z5 ? new Adler32() : null);
    }

    public FastLzFrameEncoder(int i6, Checksum checksum) {
        super(false);
        if (i6 != 0 && i6 != 1 && i6 != 2) {
            throw new IllegalArgumentException(String.format("level: %d (expected: %d or %d or %d)", Integer.valueOf(i6), 0, 1, 2));
        }
        this.level = i6;
        this.checksum = checksum;
    }
}
