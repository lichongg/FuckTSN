package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ByteBufferReadWriteBuf implements ReadWriteBuf {
    private final ByteBuffer buffer;

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte[] bArr, int i6, int i7) {
        this.buffer.put(bArr, i6, i7);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i6, byte b6) {
        requestCapacity(i6 + 1);
        this.buffer.put(i6, b6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte[] data() {
        return this.buffer.array();
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte get(int i6) {
        return this.buffer.get(i6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public double getDouble(int i6) {
        return this.buffer.getDouble(i6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public float getFloat(int i6) {
        return this.buffer.getFloat(i6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public int getInt(int i6) {
        return this.buffer.getInt(i6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public long getLong(int i6) {
        return this.buffer.getLong(i6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public short getShort(int i6) {
        return this.buffer.getShort(i6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public String getString(int i6, int i7) {
        return Utf8Safe.decodeUtf8Buffer(this.buffer, i6, i7);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf, androidx.emoji2.text.flatbuffer.ReadBuf
    public int limit() {
        return this.buffer.limit();
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte b6) {
        this.buffer.put(b6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putBoolean(boolean z5) {
        this.buffer.put(z5 ? (byte) 1 : (byte) 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putDouble(double d6) {
        this.buffer.putDouble(d6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putFloat(float f6) {
        this.buffer.putFloat(f6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putInt(int i6) {
        this.buffer.putInt(i6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putLong(long j6) {
        this.buffer.putLong(j6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putShort(short s5) {
        this.buffer.putShort(s5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public boolean requestCapacity(int i6) {
        return i6 <= this.buffer.limit();
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setDouble(int i6, double d6) {
        requestCapacity(i6 + 8);
        this.buffer.putDouble(i6, d6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setFloat(int i6, float f6) {
        requestCapacity(i6 + 4);
        this.buffer.putFloat(i6, f6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setInt(int i6, int i7) {
        requestCapacity(i6 + 4);
        this.buffer.putInt(i6, i7);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setLong(int i6, long j6) {
        requestCapacity(i6 + 8);
        this.buffer.putLong(i6, j6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setShort(int i6, short s5) {
        requestCapacity(i6 + 2);
        this.buffer.putShort(i6, s5);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int writePosition() {
        return this.buffer.position();
    }

    public ByteBufferReadWriteBuf(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public boolean getBoolean(int i6) {
        if (get(i6) != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i6, byte[] bArr, int i7, int i8) {
        requestCapacity((i8 - i7) + i6);
        int position = this.buffer.position();
        this.buffer.position(i6);
        this.buffer.put(bArr, i7, i8);
        this.buffer.position(position);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setBoolean(int i6, boolean z5) {
        set(i6, z5 ? (byte) 1 : (byte) 0);
    }
}
