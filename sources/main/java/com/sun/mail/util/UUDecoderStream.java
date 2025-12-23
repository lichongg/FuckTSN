package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import okio.Utf8;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UUDecoderStream extends FilterInputStream {
    private byte[] buffer;
    private int bufsize;
    private boolean gotEnd;
    private boolean gotPrefix;
    private int index;
    private LineInputStream lin;
    private int mode;
    private String name;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.index >= this.bufsize) {
            readPrefix();
            if (!decode()) {
                return -1;
            }
            this.index = 0;
        }
        byte[] bArr = this.buffer;
        int i6 = this.index;
        this.index = i6 + 1;
        return bArr[i6] & 255;
    }

    private boolean decode() throws IOException {
        String readLine;
        if (this.gotEnd) {
            return false;
        }
        this.bufsize = 0;
        do {
            readLine = this.lin.readLine();
            if (readLine == null) {
                throw new IOException("Missing End");
            }
            if (readLine.regionMatches(true, 0, "end", 0, 3)) {
                this.gotEnd = true;
                return false;
            }
        } while (readLine.length() == 0);
        char charAt = readLine.charAt(0);
        if (charAt < ' ') {
            throw new IOException("Buffer format error");
        }
        int i6 = (charAt - ' ') & 63;
        if (i6 == 0) {
            String readLine2 = this.lin.readLine();
            if (readLine2 == null || !readLine2.regionMatches(true, 0, "end", 0, 3)) {
                throw new IOException("Missing End");
            }
            this.gotEnd = true;
            return false;
        }
        if (readLine.length() < (((i6 * 8) + 5) / 6) + 1) {
            throw new IOException("Short buffer error");
        }
        int i7 = 1;
        while (this.bufsize < i6) {
            byte charAt2 = (byte) ((readLine.charAt(i7) - ' ') & 63);
            int i8 = i7 + 2;
            byte charAt3 = (byte) ((readLine.charAt(i7 + 1) - ' ') & 63);
            byte[] bArr = this.buffer;
            int i9 = this.bufsize;
            int i10 = i9 + 1;
            this.bufsize = i10;
            bArr[i9] = (byte) (((charAt2 << 2) & 252) | ((charAt3 >>> 4) & 3));
            if (i10 < i6) {
                i7 += 3;
                byte charAt4 = (byte) ((readLine.charAt(i8) - ' ') & 63);
                byte[] bArr2 = this.buffer;
                int i11 = this.bufsize;
                this.bufsize = i11 + 1;
                bArr2[i11] = (byte) (((charAt3 << 4) & 240) | ((charAt4 >>> 2) & 15));
                charAt3 = charAt4;
            } else {
                i7 = i8;
            }
            if (this.bufsize < i6) {
                int i12 = i7 + 1;
                byte charAt5 = (byte) ((readLine.charAt(i7) - ' ') & 63);
                byte[] bArr3 = this.buffer;
                int i13 = this.bufsize;
                this.bufsize = i13 + 1;
                bArr3[i13] = (byte) ((charAt5 & Utf8.REPLACEMENT_BYTE) | ((charAt3 << 6) & 192));
                i7 = i12;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004a, code lost:
    
        throw new java.io.IOException("UUDecoder error: " + r0.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void readPrefix() throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r7.gotPrefix
            if (r0 == 0) goto L5
            return
        L5:
            com.sun.mail.util.LineInputStream r0 = r7.lin
            java.lang.String r1 = r0.readLine()
            if (r1 == 0) goto L4b
            r5 = 0
            r6 = 5
            r2 = 1
            r3 = 0
            java.lang.String r4 = "begin"
            boolean r0 = r1.regionMatches(r2, r3, r4, r5, r6)
            if (r0 == 0) goto L5
            r0 = 6
            r2 = 9
            java.lang.String r0 = r1.substring(r0, r2)     // Catch: java.lang.NumberFormatException -> L32
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L32
            r7.mode = r0     // Catch: java.lang.NumberFormatException -> L32
            r0 = 10
            java.lang.String r0 = r1.substring(r0)
            r7.name = r0
            r0 = 1
            r7.gotPrefix = r0
            return
        L32:
            r0 = move-exception
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "UUDecoder error: "
            r2.<init>(r3)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L4b:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "UUDecoder error: No Begin"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.UUDecoderStream.readPrefix():void");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return ((((FilterInputStream) this).in.available() * 3) / 4) + (this.bufsize - this.index);
    }

    public UUDecoderStream(InputStream inputStream) {
        super(inputStream);
        this.bufsize = 0;
        this.index = 0;
        this.gotPrefix = false;
        this.gotEnd = false;
        this.lin = new LineInputStream(inputStream);
        this.buffer = new byte[45];
    }

    public int getMode() throws IOException {
        readPrefix();
        return this.mode;
    }

    public String getName() throws IOException {
        readPrefix();
        return this.name;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i6, int i7) throws IOException {
        int i8 = 0;
        while (true) {
            if (i8 >= i7) {
                break;
            }
            int read = read();
            if (read != -1) {
                bArr[i6 + i8] = (byte) read;
                i8++;
            } else if (i8 == 0) {
                return -1;
            }
        }
        return i8;
    }
}
