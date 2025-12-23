package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class SecurityRandomHelper {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile SecurityRandomHelper instance;

    public static SecurityRandomHelper getInstance() {
        if (instance == null) {
            synchronized (SecurityRandomHelper.class) {
                try {
                    if (instance == null) {
                        d2.b.i(true);
                        instance = new SecurityRandomHelper();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private SecurityRandomHelper() {
    }

    public byte[] generateSecureRandom(int i6) {
        return d2.b.d(i6);
    }

    public String generateSecureRandomStr(int i6) {
        return d2.b.e(i6);
    }
}
