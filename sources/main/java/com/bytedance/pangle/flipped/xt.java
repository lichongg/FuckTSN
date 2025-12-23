package com.bytedance.pangle.flipped;

import android.annotation.SuppressLint;
import android.util.Log;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.sdk.openadsdk.api.m;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt implements cw {
    @Override // com.bytedance.pangle.flipped.cw
    @SuppressLint({"DiscouragedPrivateApi"})
    public void invokeHiddenApiRestrictions() {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_FLIPPED, "v1");
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            Method method = (Method) declaredMethod.invoke(cls, "getRuntime", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(null, null);
            Method method2 = (Method) declaredMethod.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            method2.setAccessible(true);
            method2.invoke(invoke, new String[]{"L"});
        } catch (Exception e6) {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_FLIPPED, "V1 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e6));
            m.up("FlippedV1Impl", "V1 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e6));
        }
    }
}
