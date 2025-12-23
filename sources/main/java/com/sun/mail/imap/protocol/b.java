package com.sun.mail.imap.protocol;

import io.netty.util.internal.StringUtil;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Writer;
import okio.Utf8;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    private static final char[] f39391e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', StringUtil.COMMA};

    /* renamed from: a, reason: collision with root package name */
    protected byte[] f39392a = new byte[4];

    /* renamed from: b, reason: collision with root package name */
    protected int f39393b = 0;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f39394c = false;

    /* renamed from: d, reason: collision with root package name */
    protected Writer f39395d;

    protected void b() throws IOException {
        int i6 = this.f39393b;
        if (i6 == 1) {
            byte b6 = this.f39392a[0];
            Writer writer = this.f39395d;
            char[] cArr = f39391e;
            writer.write(cArr[(b6 >>> 2) & 63]);
            this.f39395d.write(cArr[(b6 << 4) & 48]);
            return;
        }
        if (i6 == 2) {
            byte[] bArr = this.f39392a;
            byte b7 = bArr[0];
            byte b8 = bArr[1];
            Writer writer2 = this.f39395d;
            char[] cArr2 = f39391e;
            writer2.write(cArr2[(b7 >>> 2) & 63]);
            this.f39395d.write(cArr2[((b7 << 4) & 48) + ((b8 >>> 4) & 15)]);
            this.f39395d.write(cArr2[(b8 << 2) & 60]);
            return;
        }
        byte[] bArr2 = this.f39392a;
        byte b9 = bArr2[0];
        byte b10 = bArr2[1];
        byte b11 = bArr2[2];
        Writer writer3 = this.f39395d;
        char[] cArr3 = f39391e;
        writer3.write(cArr3[(b9 >>> 2) & 63]);
        this.f39395d.write(cArr3[((b9 << 4) & 48) + ((b10 >>> 4) & 15)]);
        this.f39395d.write(cArr3[((b10 << 2) & 60) + ((b11 >>> 6) & 3)]);
        this.f39395d.write(cArr3[b11 & Utf8.REPLACEMENT_BYTE]);
        if (this.f39393b == 4) {
            byte[] bArr3 = this.f39392a;
            bArr3[0] = bArr3[3];
        }
    }

    public void c() {
        try {
            if (this.f39393b > 0) {
                b();
                this.f39393b = 0;
            }
            if (this.f39394c) {
                this.f39395d.write(45);
                this.f39394c = false;
            }
        } catch (IOException unused) {
        }
    }

    public void d(int i6) {
        try {
            if (!this.f39394c) {
                this.f39394c = true;
                this.f39395d.write(38);
            }
            byte[] bArr = this.f39392a;
            int i7 = this.f39393b;
            int i8 = i7 + 1;
            this.f39393b = i8;
            bArr[i7] = (byte) (i6 >> 8);
            int i9 = i7 + 2;
            this.f39393b = i9;
            bArr[i8] = (byte) (i6 & 255);
            if (i9 >= 3) {
                b();
                this.f39393b -= 3;
            }
        } catch (IOException unused) {
        }
    }

    public b(Writer writer) {
        this.f39395d = writer;
    }

    public static String a(String str) {
        char[] charArray = str.toCharArray();
        CharArrayWriter charArrayWriter = new CharArrayWriter(charArray.length);
        b bVar = null;
        boolean z5 = false;
        for (char c6 : charArray) {
            if (c6 >= ' ' && c6 <= '~') {
                if (bVar != null) {
                    bVar.c();
                }
                if (c6 == '&') {
                    charArrayWriter.write(38);
                    charArrayWriter.write(45);
                    z5 = true;
                } else {
                    charArrayWriter.write(c6);
                }
            } else {
                if (bVar == null) {
                    bVar = new b(charArrayWriter);
                    z5 = true;
                }
                bVar.d(c6);
            }
        }
        if (bVar != null) {
            bVar.c();
        }
        if (z5) {
            return charArrayWriter.toString();
        }
        return str;
    }
}
