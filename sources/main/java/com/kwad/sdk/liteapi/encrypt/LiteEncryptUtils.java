package com.kwad.sdk.liteapi.encrypt;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.kwad.sdk.pngencrypt.o;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class LiteEncryptUtils {
    public static final String KEY_AES = "aes_key";
    public static final String KEY_PRIVATE = "rsa_private_key";
    public static final String KEY_PUBLISH = "rsa_public_key";
    public static final String TAG = "EncryptUtils";
    private static String sAESKey = "";
    private static String sRSEPrivateKey = "";
    private static String sRSEPublicKey = "";

    public static String getKey(Context context, int i6) {
        String str;
        String str2;
        InputStream inputStream;
        if (i6 == 0) {
            str = sAESKey;
            str2 = KEY_AES;
        } else if (i6 == 1) {
            str = sRSEPublicKey;
            str2 = KEY_PUBLISH;
        } else if (i6 != 2) {
            str = "";
            str2 = str;
        } else {
            str = sRSEPrivateKey;
            str2 = KEY_PRIVATE;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        TextUtils.isEmpty(str2);
        try {
            try {
                inputStream = context.getResources().getAssets().open("ksad_common_encrypt_image.png");
            } catch (Throwable th) {
                th.toString();
                inputStream = null;
            }
            if (inputStream == null) {
                inputStream = context.getAssets().open("ksad_common_encrypt_image.png");
            }
            String readKey = readKey(str2, inputStream);
            TextUtils.isEmpty(readKey);
            if (i6 == 0) {
                sAESKey = readKey;
            } else if (i6 == 1) {
                sRSEPublicKey = readKey;
            } else if (i6 == 2) {
                sRSEPrivateKey = readKey;
            }
            return readKey;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String readKey(String str, InputStream inputStream) {
        String gD;
        synchronized (LiteEncryptUtils.class) {
            o oVar = new o(inputStream, true);
            oVar.Ox();
            gD = oVar.Ow().gD(str);
            oVar.end();
        }
        return gD;
    }
}
