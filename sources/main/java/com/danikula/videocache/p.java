package com.danikula.videocache;

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
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private static final org.slf4j.c f32238a = org.slf4j.d.j("ProxyCacheUtils");

    /* renamed from: b, reason: collision with root package name */
    static final int f32239b = 8192;

    /* renamed from: c, reason: collision with root package name */
    static final int f32240c = 16;

    static String h(byte[] bArr, int i6) {
        int min = Math.min(16, Math.max(i6, 0));
        String arrays = Arrays.toString(Arrays.copyOfRange(bArr, 0, min));
        if (min >= i6) {
            return arrays;
        }
        return arrays.substring(0, arrays.length() - 1) + ", ...]";
    }

    static void a(byte[] bArr, long j6, int i6) {
        n.e(bArr, "Buffer must be not null!");
        boolean z5 = false;
        n.c(j6 >= 0, "Data offset must be positive!");
        if (i6 >= 0 && i6 <= bArr.length) {
            z5 = true;
        }
        n.c(z5, "Length must be in range [0..buffer.length]");
    }

    private static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b6 : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b6)));
        }
        return stringBuffer.toString();
    }

    static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e6) {
                f32238a.error("Error closing resource", (Throwable) e6);
            }
        }
    }

    public static String d(String str) {
        try {
            return b(MessageDigest.getInstance(by.f10823a).digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e6) {
            throw new IllegalStateException(e6);
        }
    }

    static String e(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e6) {
            throw new RuntimeException("Error decoding url", e6);
        }
    }

    static String f(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e6) {
            throw new RuntimeException("Error encoding url", e6);
        }
    }

    static String g(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }
}
