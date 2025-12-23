package io.netty.handler.codec.http;

import io.netty.util.AsciiString;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum HttpStatusClass {
    INFORMATIONAL(100, 200, "Informational"),
    SUCCESS(200, 300, "Success"),
    REDIRECTION(300, 400, "Redirection"),
    CLIENT_ERROR(400, 500, "Client Error"),
    SERVER_ERROR(500, 600, "Server Error"),
    UNKNOWN(0, 0, "Unknown Status") { // from class: io.netty.handler.codec.http.HttpStatusClass.1
        @Override // io.netty.handler.codec.http.HttpStatusClass
        public boolean contains(int i6) {
            return i6 < 100 || i6 >= 600;
        }
    };

    private final AsciiString defaultReasonPhrase;
    private final int max;
    private final int min;

    HttpStatusClass(int i6, int i7, String str) {
        this.min = i6;
        this.max = i7;
        this.defaultReasonPhrase = AsciiString.cached(str);
    }

    private static int digit(char c6) {
        return c6 - '0';
    }

    private static boolean isDigit(char c6) {
        return c6 >= '0' && c6 <= '9';
    }

    public static HttpStatusClass valueOf(int i6) {
        HttpStatusClass httpStatusClass = INFORMATIONAL;
        if (httpStatusClass.contains(i6)) {
            return httpStatusClass;
        }
        HttpStatusClass httpStatusClass2 = SUCCESS;
        if (httpStatusClass2.contains(i6)) {
            return httpStatusClass2;
        }
        HttpStatusClass httpStatusClass3 = REDIRECTION;
        if (httpStatusClass3.contains(i6)) {
            return httpStatusClass3;
        }
        HttpStatusClass httpStatusClass4 = CLIENT_ERROR;
        if (httpStatusClass4.contains(i6)) {
            return httpStatusClass4;
        }
        HttpStatusClass httpStatusClass5 = SERVER_ERROR;
        return httpStatusClass5.contains(i6) ? httpStatusClass5 : UNKNOWN;
    }

    public boolean contains(int i6) {
        return i6 >= this.min && i6 < this.max;
    }

    AsciiString defaultReasonPhrase() {
        return this.defaultReasonPhrase;
    }

    public static HttpStatusClass valueOf(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() == 3) {
            char charAt = charSequence.charAt(0);
            return (isDigit(charAt) && isDigit(charSequence.charAt(1)) && isDigit(charSequence.charAt(2))) ? valueOf(digit(charAt) * 100) : UNKNOWN;
        }
        return UNKNOWN;
    }
}
