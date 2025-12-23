package com.bytedance.sdk.component.cw.xt.j.tl;

import com.bytedance.sdk.component.cw.j.oq;
import com.bytedance.sdk.component.cw.j.vl;
import com.bytedance.sdk.component.cw.xt.j.ae.up;
import com.bytedance.sdk.component.cw.xt.j.cw;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class j {
    private byte[] ae;
    private byte[] tl;

    /* renamed from: j, reason: collision with root package name */
    private static final byte[] f26225j = {42};
    private static final String[] xt = new String[0];
    private static final String[] cw = {"*"};

    /* renamed from: r, reason: collision with root package name */
    private static final j f26226r = new j();
    private final AtomicBoolean up = new AtomicBoolean(false);

    /* renamed from: m, reason: collision with root package name */
    private final CountDownLatch f26227m = new CountDownLatch(1);

    public static j j() {
        return f26226r;
    }

    private void xt() {
        boolean z5 = false;
        while (true) {
            try {
                try {
                    cw();
                    break;
                } catch (InterruptedIOException unused) {
                    z5 = true;
                } catch (IOException e6) {
                    up.xt().j(5, "Failed to read public suffix list", e6);
                    if (!z5) {
                        return;
                    }
                }
            } catch (Throwable th) {
                if (z5) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (!z5) {
            return;
        }
        Thread.currentThread().interrupt();
    }

    private void cw() throws IOException {
        InputStream resourceAsStream = j.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        com.bytedance.sdk.component.cw.j.up j6 = vl.j(new oq(vl.j(resourceAsStream)));
        try {
            byte[] bArr = new byte[j6.oq()];
            j6.j(bArr);
            byte[] bArr2 = new byte[j6.oq()];
            j6.j(bArr2);
            synchronized (this) {
                this.ae = bArr;
                this.tl = bArr2;
            }
            this.f26227m.countDown();
        } finally {
            cw.j(j6);
        }
    }

    public String j(String str) {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] j6 = j(split);
        if (split.length == j6.length && j6[0].charAt(0) != '!') {
            return null;
        }
        if (j6[0].charAt(0) == '!') {
            length = split.length;
            length2 = j6.length;
        } else {
            length = split.length;
            length2 = j6.length + 1;
        }
        StringBuilder sb = new StringBuilder();
        String[] split2 = str.split("\\.");
        for (int i6 = length - length2; i6 < split2.length; i6++) {
            sb.append(split2[i6]);
            sb.append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String[] j(String[] strArr) {
        String str;
        String str2;
        String str3;
        int i6 = 0;
        if (!this.up.get() && this.up.compareAndSet(false, true)) {
            xt();
        } else {
            try {
                this.f26227m.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (this.ae == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i7 = 0; i7 < strArr.length; i7++) {
            bArr[i7] = strArr[i7].getBytes(cw.up);
        }
        int i8 = 0;
        while (true) {
            str = null;
            if (i8 >= length) {
                str2 = null;
                break;
            }
            str2 = j(this.ae, bArr, i8);
            if (str2 != null) {
                break;
            }
            i8++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i9 = 0; i9 < bArr2.length - 1; i9++) {
                bArr2[i9] = f26225j;
                str3 = j(this.ae, bArr2, i9);
                if (str3 != null) {
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            while (true) {
                if (i6 >= length - 1) {
                    break;
                }
                String j6 = j(this.tl, bArr, i6);
                if (j6 != null) {
                    str = j6;
                    break;
                }
                i6++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (str2 == null && str3 == null) {
            return cw;
        }
        String[] split = str2 != null ? str2.split("\\.") : xt;
        String[] split2 = str3 != null ? str3.split("\\.") : xt;
        return split.length > split2.length ? split : split2;
    }

    private static String j(byte[] bArr, byte[][] bArr2, int i6) {
        int i7;
        boolean z5;
        int i8;
        int i9;
        int length = bArr.length;
        int i10 = 0;
        while (i10 < length) {
            int i11 = (i10 + length) / 2;
            while (i11 >= 0 && bArr[i11] != 10) {
                i11--;
            }
            int i12 = i11 + 1;
            int i13 = 1;
            while (true) {
                i7 = i12 + i13;
                if (bArr[i7] == 10) {
                    break;
                }
                i13++;
            }
            int i14 = i7 - i12;
            int i15 = i6;
            boolean z6 = false;
            int i16 = 0;
            int i17 = 0;
            while (true) {
                if (z6) {
                    i8 = 46;
                    z5 = false;
                } else {
                    z5 = z6;
                    i8 = bArr2[i15][i16] & 255;
                }
                i9 = i8 - (bArr[i12 + i17] & 255);
                if (i9 != 0) {
                    break;
                }
                i17++;
                i16++;
                if (i17 == i14) {
                    break;
                }
                if (bArr2[i15].length != i16) {
                    z6 = z5;
                } else {
                    if (i15 == bArr2.length - 1) {
                        break;
                    }
                    i15++;
                    z6 = true;
                    i16 = -1;
                }
            }
            if (i9 >= 0) {
                if (i9 <= 0) {
                    int i18 = i14 - i17;
                    int length2 = bArr2[i15].length - i16;
                    while (true) {
                        i15++;
                        if (i15 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i15].length;
                    }
                    if (length2 >= i18) {
                        if (length2 <= i18) {
                            return new String(bArr, i12, i14, cw.up);
                        }
                    }
                }
                i10 = i7 + 1;
            }
            length = i11;
        }
        return null;
    }
}
