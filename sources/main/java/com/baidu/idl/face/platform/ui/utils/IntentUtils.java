package com.baidu.idl.face.platform.ui.utils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class IntentUtils {
    private static IntentUtils instance;
    private String mBitmap;

    public static IntentUtils getInstance() {
        if (instance == null) {
            synchronized (IntentUtils.class) {
                try {
                    if (instance == null) {
                        instance = new IntentUtils();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public String getBitmap() {
        return this.mBitmap;
    }

    public void release() {
        if (instance != null) {
            instance = null;
        }
    }

    public void setBitmap(String str) {
        this.mBitmap = str;
    }
}
