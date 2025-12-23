package com.bytedance.adsdk.j.j.xt;

import android.text.TextUtils;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends up {
    private static ThreadLocal<byte[]> xt = new ThreadLocal<>();

    protected static byte[] j() {
        byte[] bArr = xt.get();
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[4];
        xt.set(bArr2);
        return bArr2;
    }

    public j(m mVar) {
        super(mVar);
    }

    public short a_() throws IOException {
        byte[] j6 = j();
        j(j6, 0, 2);
        return (short) (((j6[0] & 255) << 8) | (j6[1] & 255));
    }

    public int b_() throws IOException {
        byte[] j6 = j();
        j(j6, 0, 4);
        return ((j6[3] & 255) << 24) | (j6[0] & 255) | ((j6[1] & 255) << 8) | ((j6[2] & 255) << 16);
    }

    public int xt() throws IOException {
        byte[] j6 = j();
        j(j6, 0, 4);
        return ((j6[0] & 255) << 24) | (j6[3] & 255) | ((j6[2] & 255) << 8) | ((j6[1] & 255) << 16);
    }

    public boolean j(String str) throws IOException {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return false;
        }
        int b_ = b_();
        for (int i6 = 0; i6 < 4; i6++) {
            if (((b_ >> (i6 * 8)) & 255) != str.charAt(i6)) {
                return false;
            }
        }
        return true;
    }
}
