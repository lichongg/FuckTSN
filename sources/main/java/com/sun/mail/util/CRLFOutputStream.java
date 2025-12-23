package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class CRLFOutputStream extends FilterOutputStream {
    private static final byte[] newline = {13, 10};
    protected boolean atBOL;
    protected int lastb;

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i6) throws IOException {
        if (i6 == 13) {
            writeln();
        } else if (i6 != 10) {
            ((FilterOutputStream) this).out.write(i6);
            this.atBOL = false;
        } else if (this.lastb != 13) {
            writeln();
        }
        this.lastb = i6;
    }

    public void writeln() throws IOException {
        ((FilterOutputStream) this).out.write(newline);
        this.atBOL = true;
    }

    public CRLFOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.lastb = -1;
        this.atBOL = true;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i6, int i7) throws IOException {
        int i8 = i7 + i6;
        int i9 = i6;
        while (i6 < i8) {
            byte b6 = bArr[i6];
            if (b6 == 13) {
                ((FilterOutputStream) this).out.write(bArr, i9, i6 - i9);
                writeln();
            } else if (b6 == 10) {
                if (this.lastb != 13) {
                    ((FilterOutputStream) this).out.write(bArr, i9, i6 - i9);
                    writeln();
                }
            } else {
                this.lastb = bArr[i6];
                i6++;
            }
            i9 = i6 + 1;
            this.lastb = bArr[i6];
            i6++;
        }
        int i10 = i8 - i9;
        if (i10 > 0) {
            ((FilterOutputStream) this).out.write(bArr, i9, i10);
            this.atBOL = false;
        }
    }
}
