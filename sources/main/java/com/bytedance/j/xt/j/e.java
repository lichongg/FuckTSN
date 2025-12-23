package com.bytedance.j.xt.j;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.bytedance.j.xt.tl.o;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class e {
    static String a(Context context, int i6) {
        ActivityManager.ProcessErrorStateInfo d6 = com.bytedance.j.xt.tl.f.d(context, i6);
        if (d6 != null && Process.myPid() == d6.pid) {
            return f.a(d6);
        }
        return null;
    }

    public static JSONObject b(boolean z5) throws JSONException {
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("thread_number", 1);
        jSONObject.put("mainStackFromTrace", o.c(stackTrace));
        return jSONObject;
    }
}
