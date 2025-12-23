package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class LineInputStream extends FilterInputStream {
    private char[] lineBuffer;

    public String readLine() throws IOException {
        int read;
        InputStream inputStream = ((FilterInputStream) this).in;
        char[] cArr = this.lineBuffer;
        if (cArr == null) {
            cArr = new char[128];
            this.lineBuffer = cArr;
        }
        int length = cArr.length;
        int i6 = 0;
        while (true) {
            read = inputStream.read();
            if (read == -1 || read == 10) {
                break;
            }
            if (read == 13) {
                int read2 = inputStream.read();
                if (read2 == 13) {
                    read2 = inputStream.read();
                }
                if (read2 != 10) {
                    if (!(inputStream instanceof PushbackInputStream)) {
                        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
                        ((FilterInputStream) this).in = pushbackInputStream;
                        inputStream = pushbackInputStream;
                    }
                    ((PushbackInputStream) inputStream).unread(read2);
                }
            } else {
                length--;
                if (length < 0) {
                    int i7 = i6 + 128;
                    char[] cArr2 = new char[i7];
                    System.arraycopy(this.lineBuffer, 0, cArr2, 0, i6);
                    this.lineBuffer = cArr2;
                    length = (i7 - i6) - 1;
                    cArr = cArr2;
                }
                cArr[i6] = (char) read;
                i6++;
            }
        }
        if (read == -1 && i6 == 0) {
            return null;
        }
        return String.copyValueOf(cArr, 0, i6);
    }

    public LineInputStream(InputStream inputStream) {
        super(inputStream);
        this.lineBuffer = null;
    }
}
