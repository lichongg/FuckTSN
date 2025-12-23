package com.bytedance.pangle.res;

import android.view.LayoutInflater;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    public static void j(LayoutInflater layoutInflater) {
        try {
            FieldUtils.writeField(layoutInflater, "mFactory", (Object) null);
        } catch (Throwable unused) {
            ZeusLogger.w(ZeusLogger.TAG_RESOURCES, "clearFactory failed.");
        }
        try {
            FieldUtils.writeField(layoutInflater, "mFactory2", (Object) null);
        } catch (Throwable unused2) {
            ZeusLogger.w(ZeusLogger.TAG_RESOURCES, "clearFactory failed.");
        }
    }
}
