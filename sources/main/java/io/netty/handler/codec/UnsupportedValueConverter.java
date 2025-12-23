package io.netty.handler.codec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class UnsupportedValueConverter<V> implements ValueConverter<V> {
    private static final UnsupportedValueConverter INSTANCE = new UnsupportedValueConverter();

    public static <V> UnsupportedValueConverter<V> instance() {
        return INSTANCE;
    }

    @Override // io.netty.handler.codec.ValueConverter
    public V convertBoolean(boolean z5) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.ValueConverter
    public V convertByte(byte b6) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.ValueConverter
    public V convertChar(char c6) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.ValueConverter
    public V convertDouble(double d6) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.ValueConverter
    public V convertFloat(float f6) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.ValueConverter
    public V convertInt(int i6) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.ValueConverter
    public V convertLong(long j6) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.ValueConverter
    public V convertObject(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.ValueConverter
    public V convertShort(short s5) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.ValueConverter
    public V convertTimeMillis(long j6) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.ValueConverter
    public boolean convertToBoolean(V v5) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.ValueConverter
    public byte convertToByte(V v5) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.ValueConverter
    public char convertToChar(V v5) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.ValueConverter
    public double convertToDouble(V v5) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.ValueConverter
    public float convertToFloat(V v5) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.ValueConverter
    public int convertToInt(V v5) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.ValueConverter
    public long convertToLong(V v5) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.ValueConverter
    public short convertToShort(V v5) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.ValueConverter
    public long convertToTimeMillis(V v5) {
        throw new UnsupportedOperationException();
    }

    private UnsupportedValueConverter() {
    }
}
