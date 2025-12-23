package com.sun.mail.util;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class QEncoderStream extends QPEncoderStream {
    private static String TEXT_SPECIALS = "=_?";
    private static String WORD_SPECIALS = "=_?\"#$%&'(),.:;<>@[\\]^`{|}~";
    private String specials;

    public static int encodedLength(byte[] bArr, boolean z5) {
        String str = z5 ? WORD_SPECIALS : TEXT_SPECIALS;
        int i6 = 0;
        for (byte b6 : bArr) {
            int i7 = b6 & 255;
            i6 = (i7 < 32 || i7 >= 127 || str.indexOf(i7) >= 0) ? i6 + 3 : i6 + 1;
        }
        return i6;
    }

    @Override // com.sun.mail.util.QPEncoderStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i6) throws IOException {
        int i7 = i6 & 255;
        if (i7 == 32) {
            output(95, false);
        } else if (i7 < 32 || i7 >= 127 || this.specials.indexOf(i7) >= 0) {
            output(i7, true);
        } else {
            output(i7, false);
        }
    }

    public QEncoderStream(OutputStream outputStream, boolean z5) {
        super(outputStream, Integer.MAX_VALUE);
        String str;
        if (z5) {
            str = WORD_SPECIALS;
        } else {
            str = TEXT_SPECIALS;
        }
        this.specials = str;
    }
}
