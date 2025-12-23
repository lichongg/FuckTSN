package com.bytedance.msdk.core.vl;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static final Map<String, InterfaceC0362j> f24765j = Collections.synchronizedMap(new HashMap());

    /* renamed from: com.bytedance.msdk.core.vl.j$j, reason: collision with other inner class name */
    public interface InterfaceC0362j {
    }

    public static void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        xt(str);
    }

    public static void j(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        xt(str);
    }

    private static InterfaceC0362j xt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f24765j.remove(str);
    }
}
