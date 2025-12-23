package com.bytedance.msdk.tl;

import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class f {
    private static final MessageDigest xt = j();

    /* renamed from: j, reason: collision with root package name */
    public static final Charset f25212j = Charset.forName("UTF-8");
    private static final char[] cw = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static MessageDigest j() {
        try {
            return MessageDigest.getInstance(TKDownloadReason.KSAD_TK_MD5);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String j(String str) {
        byte[] digest;
        MessageDigest messageDigest = xt;
        if (str == null) {
            return "";
        }
        byte[] bytes = str.getBytes(f25212j);
        synchronized (f.class) {
            digest = messageDigest.digest(bytes);
        }
        return j(digest);
    }

    private f() {
    }

    public static String j(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i6 = 0;
        for (byte b6 : bArr) {
            int i7 = i6 + 1;
            char[] cArr2 = cw;
            cArr[i6] = cArr2[(b6 & 240) >> 4];
            i6 += 2;
            cArr[i7] = cArr2[b6 & 15];
        }
        return new String(cArr);
    }
}
