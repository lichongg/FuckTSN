package androidx.emoji2.text.flatbuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
interface ReadBuf {
    byte[] data();

    byte get(int i6);

    boolean getBoolean(int i6);

    double getDouble(int i6);

    float getFloat(int i6);

    int getInt(int i6);

    long getLong(int i6);

    short getShort(int i6);

    String getString(int i6, int i7);

    int limit();
}
