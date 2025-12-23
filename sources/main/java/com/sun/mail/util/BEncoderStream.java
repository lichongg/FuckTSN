package com.sun.mail.util;

import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class BEncoderStream extends BASE64EncoderStream {
    public static int encodedLength(byte[] bArr) {
        return ((bArr.length + 2) / 3) * 4;
    }

    public BEncoderStream(OutputStream outputStream) {
        super(outputStream, Integer.MAX_VALUE);
    }
}
