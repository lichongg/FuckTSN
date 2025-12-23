package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.kwad.sdk.utils.ax;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class l {
    static void b(byte[] bArr, long j6, int i6) {
        ax.g(bArr, "Buffer must be not null!");
        boolean z5 = false;
        ax.checkArgument(j6 >= 0, "Data offset must be positive!");
        if (i6 >= 0 && i6 <= bArr.length) {
            z5 = true;
        }
        ax.checkArgument(z5, "Length must be in range [0..buffer.length]");
    }

    static String decode(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e6) {
            throw new RuntimeException("Error decoding url", e6);
        }
    }

    static String encode(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e6) {
            throw new RuntimeException("Error encoding url", e6);
        }
    }

    static String eQ(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }
}
