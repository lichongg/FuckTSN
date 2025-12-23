package com.baidu.idl.main.facesdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FaceSec {
    public static final String TAG = "FaceSec";
    public byte[] value;

    private native String decrypt(String str);

    private native String encrypt(String str);

    private native int init(AssetManager assetManager);

    private native String sec(byte[] bArr);

    public String e(byte[] bArr) {
        return sec(bArr);
    }

    public String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return encrypt(str);
    }

    public int i(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            int init = init(context.getAssets());
            if (init == 0) {
                return init;
            }
            throw new RuntimeException("face sdk init sec error");
        } catch (Exception e6) {
            e6.printStackTrace();
            return -1;
        }
    }

    public String d(String str) {
        if (!TextUtils.isEmpty(str)) {
            return decrypt(str);
        }
        return null;
    }
}
