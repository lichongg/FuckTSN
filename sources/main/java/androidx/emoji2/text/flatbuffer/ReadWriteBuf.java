package androidx.emoji2.text.flatbuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
interface ReadWriteBuf extends ReadBuf {
    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    int limit();

    void put(byte b6);

    void put(byte[] bArr, int i6, int i7);

    void putBoolean(boolean z5);

    void putDouble(double d6);

    void putFloat(float f6);

    void putInt(int i6);

    void putLong(long j6);

    void putShort(short s5);

    boolean requestCapacity(int i6);

    void set(int i6, byte b6);

    void set(int i6, byte[] bArr, int i7, int i8);

    void setBoolean(int i6, boolean z5);

    void setDouble(int i6, double d6);

    void setFloat(int i6, float f6);

    void setInt(int i6, int i7);

    void setLong(int i6, long j6);

    void setShort(int i6, short s5);

    int writePosition();
}
