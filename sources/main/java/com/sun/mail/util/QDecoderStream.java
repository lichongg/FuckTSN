package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class QDecoderStream extends QPDecoderStream {
    @Override // com.sun.mail.util.QPDecoderStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = ((FilterInputStream) this).in.read();
        if (read == 95) {
            return 32;
        }
        if (read != 61) {
            return read;
        }
        this.ba[0] = (byte) ((FilterInputStream) this).in.read();
        this.ba[1] = (byte) ((FilterInputStream) this).in.read();
        try {
            return ASCIIUtility.parseInt(this.ba, 0, 2, 16);
        } catch (NumberFormatException e6) {
            throw new IOException("Error in QP stream " + e6.getMessage());
        }
    }

    public QDecoderStream(InputStream inputStream) {
        super(inputStream);
    }
}
