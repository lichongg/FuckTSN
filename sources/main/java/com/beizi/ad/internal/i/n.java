package com.beizi.ad.internal.i;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.mobads.sdk.internal.by;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class n {
    static String a(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    static String b(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e6) {
            throw new RuntimeException("Error encoding url", e6);
        }
    }

    static String c(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e6) {
            throw new RuntimeException("Error decoding url", e6);
        }
    }

    public static String d(String str) {
        try {
            return a(MessageDigest.getInstance(by.f10823a).digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e6) {
            throw new IllegalStateException(e6);
        }
    }

    static void a(byte[] bArr, long j6, int i6) {
        k.a(bArr, "Buffer must be not null!");
        boolean z5 = false;
        k.a(j6 >= 0, "Data offset must be positive!");
        if (i6 >= 0 && i6 <= bArr.length) {
            z5 = true;
        }
        k.a(z5, "Length must be in range [0..buffer.length]");
    }

    static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b6 : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b6)));
        }
        return stringBuffer.toString();
    }
}
