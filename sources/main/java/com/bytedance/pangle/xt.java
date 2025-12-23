package com.bytedance.pangle;

import android.os.Build;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bytedance.pangle.flipped.FlippedV2Impl;
import com.bytedance.pangle.log.IZeusReporter;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    private static boolean cw() {
        int i6;
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 30) {
            return true;
        }
        if (i7 != 29) {
            return false;
        }
        i6 = Build.VERSION.PREVIEW_SDK_INT;
        return i6 > 0;
    }

    private static boolean r() {
        int i6;
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 28) {
            return true;
        }
        if (i7 != 27) {
            return false;
        }
        i6 = Build.VERSION.PREVIEW_SDK_INT;
        return i6 > 0;
    }

    public static void j() {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_FLIPPED, "start");
        xt().invokeHiddenApiRestrictions();
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_FLIPPED, ConstantHelper.LOG_FINISH);
    }

    private static com.bytedance.pangle.flipped.cw xt() {
        if (cw()) {
            return new FlippedV2Impl();
        }
        if (r()) {
            return new com.bytedance.pangle.flipped.xt();
        }
        return new com.bytedance.pangle.flipped.j();
    }
}
