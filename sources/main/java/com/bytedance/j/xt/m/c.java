package com.bytedance.j.xt.m;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.j.xt.e;
import com.bytedance.j.xt.tl.i;

/* loaded from: D:\Downloads\app\classes3.dex */
public class c extends b {
    c(Handler handler, long j6, long j7) {
        super(handler, j6, j7);
    }

    @Override // java.lang.Runnable
    public void run() {
        String e6 = e.d().e();
        if (!TextUtils.isEmpty(e6) && !"0".equals(e6)) {
            e.b().b(e6);
            i.a("[DeviceIdTask] did is ".concat(String.valueOf(e6)));
        } else {
            c(a());
            i.a("[DeviceIdTask] did is null, continue check.");
        }
    }
}
