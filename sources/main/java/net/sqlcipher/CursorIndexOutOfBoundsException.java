package net.sqlcipher;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class CursorIndexOutOfBoundsException extends IndexOutOfBoundsException {
    public CursorIndexOutOfBoundsException(int i6, int i7) {
        super("Index " + i6 + " requested, with a size of " + i7);
    }

    public CursorIndexOutOfBoundsException(String str) {
        super(str);
    }
}
