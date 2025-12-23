package com.hp.hpl.sparta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class DOMException extends Exception {
    public static final short DOMSTRING_SIZE_ERR = 2;
    public static final short HIERARCHY_REQUEST_ERR = 3;
    public static final short NOT_FOUND_ERR = 8;
    public short code;

    public DOMException(short s5, String str) {
        super(str);
        this.code = s5;
    }
}
