package com.bytedance.pangle.flipped;

import android.util.Log;
import androidx.annotation.Keep;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.sdk.openadsdk.l.m;
import java.lang.reflect.Method;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public class FlippedV2Impl implements cw {
    private static final String TAG = "FlippedV2Impl";

    private native Method getDeclaredMethod(Object obj, String str, Class<?>[] clsArr);

    static {
        m.j("pangleflipped");
    }

    @Override // com.bytedance.pangle.flipped.cw
    public void invokeHiddenApiRestrictions() {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_FLIPPED, "v2");
        try {
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            Method declaredMethod = getDeclaredMethod(cls, "getRuntime", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            Method declaredMethod2 = getDeclaredMethod(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(invoke, new String[]{"L"});
        } catch (Exception e6) {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_FLIPPED, "V2 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e6));
            com.bytedance.sdk.openadsdk.api.m.up(TAG, "V2 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e6));
        }
    }
}
