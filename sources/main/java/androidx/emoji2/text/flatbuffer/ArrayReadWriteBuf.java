package androidx.emoji2.text.flatbuffer;

import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ArrayReadWriteBuf implements ReadWriteBuf {
    private byte[] buffer;
    private int writePos;

    public ArrayReadWriteBuf() {
        this(10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte[] bArr, int i6, int i7) {
        set(this.writePos, bArr, i6, i7);
        this.writePos += i7;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i6, byte b6) {
        requestCapacity(i6 + 1);
        this.buffer[i6] = b6;
    }

    public ArrayReadWriteBuf(int i6) {
        this(new byte[i6]);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte[] data() {
        return this.buffer;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte get(int i6) {
        return this.buffer[i6];
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public boolean getBoolean(int i6) {
        return this.buffer[i6] != 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public int getInt(int i6) {
        byte[] bArr = this.buffer;
        return (bArr[i6] & 255) | (bArr[i6 + 3] << 24) | ((bArr[i6 + 2] & 255) << 16) | ((bArr[i6 + 1] & 255) << 8);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public long getLong(int i6) {
        byte[] bArr = this.buffer;
        return (bArr[i6 + 7] << 56) | (bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6 + 2] & 255) << 16) | ((bArr[i6 + 3] & 255) << 24) | ((bArr[i6 + 4] & 255) << 32) | ((bArr[i6 + 5] & 255) << 40) | ((255 & bArr[i6 + 6]) << 48);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public short getShort(int i6) {
        byte[] bArr = this.buffer;
        return (short) ((bArr[i6] & 255) | (bArr[i6 + 1] << 8));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public String getString(int i6, int i7) {
        return Utf8Safe.decodeUtf8Array(this.buffer, i6, i7);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf, androidx.emoji2.text.flatbuffer.ReadBuf
    public int limit() {
        return this.writePos;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putBoolean(boolean z5) {
        setBoolean(this.writePos, z5);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putDouble(double d6) {
        setDouble(this.writePos, d6);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putFloat(float f6) {
        setFloat(this.writePos, f6);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putInt(int i6) {
        setInt(this.writePos, i6);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putLong(long j6) {
        setLong(this.writePos, j6);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putShort(short s5) {
        setShort(this.writePos, s5);
        this.writePos += 2;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public boolean requestCapacity(int i6) {
        byte[] bArr = this.buffer;
        if (bArr.length > i6) {
            return true;
        }
        int length = bArr.length;
        this.buffer = Arrays.copyOf(bArr, length + (length >> 1));
        return true;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setDouble(int i6, double d6) {
        requestCapacity(i6 + 8);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d6);
        int i7 = (int) doubleToRawLongBits;
        byte[] bArr = this.buffer;
        bArr[i6] = (byte) (i7 & 255);
        bArr[i6 + 1] = (byte) ((i7 >> 8) & 255);
        bArr[i6 + 2] = (byte) ((i7 >> 16) & 255);
        bArr[i6 + 3] = (byte) ((i7 >> 24) & 255);
        int i8 = (int) (doubleToRawLongBits >> 32);
        bArr[i6 + 4] = (byte) (i8 & 255);
        bArr[i6 + 5] = (byte) ((i8 >> 8) & 255);
        bArr[i6 + 6] = (byte) ((i8 >> 16) & 255);
        bArr[i6 + 7] = (byte) ((i8 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setFloat(int i6, float f6) {
        requestCapacity(i6 + 4);
        int floatToRawIntBits = Float.floatToRawIntBits(f6);
        byte[] bArr = this.buffer;
        bArr[i6] = (byte) (floatToRawIntBits & 255);
        bArr[i6 + 1] = (byte) ((floatToRawIntBits >> 8) & 255);
        bArr[i6 + 2] = (byte) ((floatToRawIntBits >> 16) & 255);
        bArr[i6 + 3] = (byte) ((floatToRawIntBits >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setInt(int i6, int i7) {
        requestCapacity(i6 + 4);
        byte[] bArr = this.buffer;
        bArr[i6] = (byte) (i7 & 255);
        bArr[i6 + 1] = (byte) ((i7 >> 8) & 255);
        bArr[i6 + 2] = (byte) ((i7 >> 16) & 255);
        bArr[i6 + 3] = (byte) ((i7 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setLong(int i6, long j6) {
        requestCapacity(i6 + 8);
        int i7 = (int) j6;
        byte[] bArr = this.buffer;
        bArr[i6] = (byte) (i7 & 255);
        bArr[i6 + 1] = (byte) ((i7 >> 8) & 255);
        bArr[i6 + 2] = (byte) ((i7 >> 16) & 255);
        bArr[i6 + 3] = (byte) ((i7 >> 24) & 255);
        int i8 = (int) (j6 >> 32);
        bArr[i6 + 4] = (byte) (i8 & 255);
        bArr[i6 + 5] = (byte) ((i8 >> 8) & 255);
        bArr[i6 + 6] = (byte) ((i8 >> 16) & 255);
        bArr[i6 + 7] = (byte) ((i8 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setShort(int i6, short s5) {
        requestCapacity(i6 + 2);
        byte[] bArr = this.buffer;
        bArr[i6] = (byte) (s5 & 255);
        bArr[i6 + 1] = (byte) ((s5 >> 8) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int writePosition() {
        return this.writePos;
    }

    public ArrayReadWriteBuf(byte[] bArr) {
        this.buffer = bArr;
        this.writePos = 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public double getDouble(int i6) {
        return Double.longBitsToDouble(getLong(i6));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public float getFloat(int i6) {
        return Float.intBitsToFloat(getInt(i6));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte b6) {
        set(this.writePos, b6);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i6, byte[] bArr, int i7, int i8) {
        requestCapacity((i8 - i7) + i6);
        System.arraycopy(bArr, i7, this.buffer, i6, i8);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setBoolean(int i6, boolean z5) {
        set(i6, z5 ? (byte) 1 : (byte) 0);
    }

    public ArrayReadWriteBuf(byte[] bArr, int i6) {
        this.buffer = bArr;
        this.writePos = i6;
    }
}
