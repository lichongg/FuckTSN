package com.kwad.sdk.core.config;

import android.text.TextUtils;
import java.net.URI;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private static final String[] ayz = {"gifshow.com", "kuaishou.com", "static.yximgs.com"};

    public static boolean cg(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URI(str).getHost();
            if (!dw(host)) {
                if (!dx(host)) {
                    return false;
                }
                return true;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean dw(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : ayz) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dx(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = e.EZ().iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }
}
