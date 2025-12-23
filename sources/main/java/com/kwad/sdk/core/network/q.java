package com.kwad.sdk.core.network;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class q {
    private static volatile q aFl;
    private final Map<String, String> aDS = new ConcurrentHashMap();

    public static q HB() {
        if (aFl == null) {
            synchronized (q.class) {
                try {
                    if (aFl == null) {
                        aFl = new q();
                    }
                } finally {
                }
            }
        }
        return aFl;
    }

    public final String ea(String str) {
        return this.aDS.get(str);
    }

    private q() {
    }

    public final void U(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.aDS.put(str, str2);
        }
    }
}
