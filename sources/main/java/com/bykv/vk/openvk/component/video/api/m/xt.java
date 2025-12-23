package com.bykv.vk.openvk.component.video.api.m;

import android.text.TextUtils;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static final MessageDigest f22969j = j();
    private static final char[] xt = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static MessageDigest j() {
        try {
            return MessageDigest.getInstance(TKDownloadReason.KSAD_TK_MD5);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String j(String str) {
        byte[] digest;
        MessageDigest messageDigest = f22969j;
        if (messageDigest == null || TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        synchronized (xt.class) {
            digest = messageDigest.digest(bytes);
        }
        return j(digest);
    }

    private xt() {
    }

    public static String j(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i6 = 0;
        for (byte b6 : bArr) {
            int i7 = i6 + 1;
            char[] cArr2 = xt;
            cArr[i6] = cArr2[(b6 & 240) >> 4];
            i6 += 2;
            cArr[i7] = cArr2[b6 & 15];
        }
        return new String(cArr);
    }
}
