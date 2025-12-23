package io.netty.handler.codec.compression;

import com.huawei.hms.ml.scan.HmsScanBase;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class FastLz {
    static final byte BLOCK_TYPE_COMPRESSED = 1;
    static final byte BLOCK_TYPE_NON_COMPRESSED = 0;
    static final byte BLOCK_WITHOUT_CHECKSUM = 0;
    static final byte BLOCK_WITH_CHECKSUM = 16;
    static final int CHECKSUM_OFFSET = 4;
    private static final int HASH_LOG = 13;
    private static final int HASH_MASK = 8191;
    private static final int HASH_SIZE = 8192;
    static final int LEVEL_1 = 1;
    static final int LEVEL_2 = 2;
    static final int LEVEL_AUTO = 0;
    static final int MAGIC_NUMBER = 4607066;
    static final int MAX_CHUNK_LENGTH = 65535;
    private static final int MAX_COPY = 32;
    private static final int MAX_DISTANCE = 8191;
    private static final int MAX_FARDISTANCE = 73725;
    private static final int MAX_LEN = 264;
    static final int MIN_LENGTH_TO_COMPRESSION = 32;
    private static final int MIN_RECOMENDED_LENGTH_FOR_LEVEL_2 = 65536;
    static final int OPTIONS_OFFSET = 3;

    static int calculateOutputBufferLength(int i6) {
        return Math.max((int) (i6 * 1.06d), 66);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0121 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0140 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x012e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0147 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int compress(byte[] r27, int r28, int r29, byte[] r30, int r31, int r32) {
        /*
            Method dump skipped, instructions count: 943
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.FastLz.compress(byte[], int, int, byte[], int, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int decompress(byte[] r28, int r29, int r30, byte[] r31, int r32, int r33) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.FastLz.decompress(byte[], int, int, byte[], int, int):int");
    }

    private static int readU16(byte[] bArr, int i6) {
        int i7 = i6 + 1;
        if (i7 >= bArr.length) {
            return bArr[i6] & 255;
        }
        return (bArr[i6] & 255) | ((bArr[i7] & 255) << 8);
    }

    private FastLz() {
    }

    private static int hashFunction(byte[] bArr, int i6) {
        int readU16 = readU16(bArr, i6);
        return ((readU16(bArr, i6 + 1) ^ (readU16 >> 3)) ^ readU16) & HmsScanBase.ALL_SCAN_TYPE;
    }
}
