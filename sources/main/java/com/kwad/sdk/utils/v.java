package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.liteapi.encrypt.LiteEncryptUtils;
import com.kwad.sdk.service.ServiceProvider;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class v {
    private static String sAESKey = "";
    private static String sRSEPrivateKey = "";
    private static String sRSEPublicKey = "";

    public static String eO(int i6) {
        InputStream inputStream;
        Context Pp = ServiceProvider.Pp();
        String str = sAESKey;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        TextUtils.isEmpty(LiteEncryptUtils.KEY_AES);
        try {
            try {
                inputStream = Pp.getResources().getAssets().open("ksad_common_encrypt_image.png");
            } catch (Throwable th) {
                th.toString();
                inputStream = null;
            }
            if (inputStream == null) {
                inputStream = Pp.getAssets().open("ksad_common_encrypt_image.png");
            }
            String readKey = readKey(LiteEncryptUtils.KEY_AES, inputStream);
            TextUtils.isEmpty(readKey);
            sAESKey = readKey;
            return readKey;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String readKey(String str, InputStream inputStream) {
        String gD;
        synchronized (v.class) {
            com.kwad.sdk.pngencrypt.o oVar = new com.kwad.sdk.pngencrypt.o(inputStream, true);
            oVar.Ox();
            gD = oVar.Ow().gD(str);
            oVar.end();
        }
        return gD;
    }
}
