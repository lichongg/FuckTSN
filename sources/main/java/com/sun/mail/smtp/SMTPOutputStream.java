package com.sun.mail.smtp;

import com.sun.mail.util.CRLFOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SMTPOutputStream extends CRLFOutputStream {
    @Override // com.sun.mail.util.CRLFOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i6) throws IOException {
        int i7 = this.lastb;
        if ((i7 == 10 || i7 == 13 || i7 == -1) && i6 == 46) {
            ((FilterOutputStream) this).out.write(46);
        }
        super.write(i6);
    }

    public void ensureAtBOL() throws IOException {
        if (this.atBOL) {
            return;
        }
        super.writeln();
    }

    public SMTPOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // com.sun.mail.util.CRLFOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i6, int i7) throws IOException {
        int i8 = this.lastb;
        int i9 = i8;
        if (i8 == -1) {
            i9 = 10;
        }
        int i10 = i7 + i6;
        int i11 = i9;
        int i12 = i6;
        while (i6 < i10) {
            if ((i11 == 10 || i11 == 13) && bArr[i6] == 46) {
                super.write(bArr, i12, i6 - i12);
                ((FilterOutputStream) this).out.write(46);
                i12 = i6;
            }
            i11 = bArr[i6];
            i6++;
        }
        int i13 = i10 - i12;
        if (i13 > 0) {
            super.write(bArr, i12, i13);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
    }
}
