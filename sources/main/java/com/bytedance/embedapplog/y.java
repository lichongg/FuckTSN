package com.bytedance.embedapplog;

import android.os.SystemProperties;
import com.acse.ottn.l3;

/* loaded from: D:\Downloads\app\classes3.dex */
public class y {

    /* renamed from: j, reason: collision with root package name */
    private static volatile Object f24103j;

    private Object j() {
        if (f24103j == null) {
            synchronized (y.class) {
                try {
                    if (f24103j == null) {
                        f24103j = Class.forName("android.os.SystemProperties").newInstance();
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.vl.j(th);
                } finally {
                }
            }
        }
        return f24103j;
    }

    public String j(String str) {
        try {
            return SystemProperties.get(str);
        } catch (Throwable th) {
            uc.j(th);
            try {
                Object j6 = j();
                return (String) j6.getClass().getMethod(l3.f4736f, String.class).invoke(j6, str);
            } catch (Throwable th2) {
                uc.j(th2);
                return "";
            }
        }
    }
}
