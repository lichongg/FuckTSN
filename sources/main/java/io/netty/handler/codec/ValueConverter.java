package io.netty.handler.codec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface ValueConverter<T> {
    T convertBoolean(boolean z5);

    T convertByte(byte b6);

    T convertChar(char c6);

    T convertDouble(double d6);

    T convertFloat(float f6);

    T convertInt(int i6);

    T convertLong(long j6);

    T convertObject(Object obj);

    T convertShort(short s5);

    T convertTimeMillis(long j6);

    boolean convertToBoolean(T t5);

    byte convertToByte(T t5);

    char convertToChar(T t5);

    double convertToDouble(T t5);

    float convertToFloat(T t5);

    int convertToInt(T t5);

    long convertToLong(T t5);

    short convertToShort(T t5);

    long convertToTimeMillis(T t5);
}
