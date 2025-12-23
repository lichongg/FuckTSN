package javax.mail.internet;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class AsciiOutputStream extends OutputStream {
    private boolean breakOnNonAscii;
    private boolean checkEOL;
    private int ascii = 0;
    private int non_ascii = 0;
    private int linelen = 0;
    private boolean longLine = false;
    private boolean badEOL = false;
    private int lastb = 0;
    private int ret = 0;

    @Override // java.io.OutputStream
    public void write(int i6) throws IOException {
        check(i6);
    }

    private final void check(int i6) throws IOException {
        int i7;
        int i8 = i6 & 255;
        if (this.checkEOL && (((i7 = this.lastb) == 13 && i8 != 10) || (i7 != 13 && i8 == 10))) {
            this.badEOL = true;
        }
        if (i8 == 13 || i8 == 10) {
            this.linelen = 0;
        } else {
            int i9 = this.linelen + 1;
            this.linelen = i9;
            if (i9 > 998) {
                this.longLine = true;
            }
        }
        if (MimeUtility.nonascii(i8)) {
            this.non_ascii++;
            if (this.breakOnNonAscii) {
                this.ret = 3;
                throw new EOFException();
            }
        } else {
            this.ascii++;
        }
        this.lastb = i8;
    }

    public int getAscii() {
        int i6 = this.ret;
        if (i6 != 0) {
            return i6;
        }
        if (this.badEOL) {
            return 3;
        }
        int i7 = this.non_ascii;
        return i7 == 0 ? this.longLine ? 2 : 1 : this.ascii > i7 ? 2 : 3;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public AsciiOutputStream(boolean z5, boolean z6) {
        boolean z7 = false;
        this.checkEOL = false;
        this.breakOnNonAscii = z5;
        if (z6 && z5) {
            z7 = true;
        }
        this.checkEOL = z7;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i6, int i7) throws IOException {
        int i8 = i7 + i6;
        while (i6 < i8) {
            check(bArr[i6]);
            i6++;
        }
    }
}
