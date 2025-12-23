package com.hp.hpl.sparta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class EncodingMismatchException extends ParseException {
    private String declaredEncoding_;

    String getDeclaredEncoding() {
        return this.declaredEncoding_;
    }

    EncodingMismatchException(String str, String str2, String str3) {
        super(str, 0, str2.charAt(str2.length() - 1), str2, "encoding '" + str2 + "' declared instead of of " + str3 + " as expected");
        this.declaredEncoding_ = str2;
    }
}
