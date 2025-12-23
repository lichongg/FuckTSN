package com.sun.mail.iap;

import com.sun.mail.util.ASCIIUtility;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class i {

    /* renamed from: b, reason: collision with root package name */
    private static final int f39213b = 256;

    /* renamed from: c, reason: collision with root package name */
    private static final int f39214c = 262144;

    /* renamed from: d, reason: collision with root package name */
    private static final int f39215d = 16;

    /* renamed from: a, reason: collision with root package name */
    private BufferedInputStream f39216a;

    public d a() throws IOException {
        return b(null);
    }

    public d b(d dVar) throws IOException {
        if (dVar == null) {
            dVar = new d(new byte[128], 0, 128);
        }
        byte[] a6 = dVar.a();
        int i6 = 0;
        while (true) {
            boolean z5 = false;
            int i7 = 0;
            while (!z5 && (i7 = this.f39216a.read()) != -1) {
                if (i7 == 10 && i6 > 0 && a6[i6 - 1] == 13) {
                    z5 = true;
                }
                if (i6 >= a6.length) {
                    int length = a6.length;
                    if (length > 262144) {
                        length = 262144;
                    }
                    dVar.e(length);
                    a6 = dVar.a();
                }
                a6[i6] = (byte) i7;
                i6++;
            }
            if (i7 == -1) {
                throw new IOException();
            }
            if (i6 < 5) {
                break;
            }
            int i8 = i6 - 3;
            if (a6[i8] != 125) {
                break;
            }
            int i9 = i6 - 4;
            while (i9 >= 0 && a6[i9] != 123) {
                i9--;
            }
            if (i9 < 0) {
                break;
            }
            try {
                int parseInt = ASCIIUtility.parseInt(a6, i9 + 1, i8);
                if (parseInt > 0) {
                    int length2 = a6.length - i6;
                    int i10 = parseInt + 16;
                    if (i10 > length2) {
                        int i11 = i10 - length2;
                        if (256 > i11) {
                            i11 = 256;
                        }
                        dVar.e(i11);
                        a6 = dVar.a();
                    }
                    while (parseInt > 0) {
                        int read = this.f39216a.read(a6, i6, parseInt);
                        parseInt -= read;
                        i6 += read;
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        dVar.f(i6);
        return dVar;
    }

    public i(InputStream inputStream) {
        this.f39216a = new BufferedInputStream(inputStream, 2048);
    }
}
