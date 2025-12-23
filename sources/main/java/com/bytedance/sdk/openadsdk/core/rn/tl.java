package com.bytedance.sdk.openadsdk.core.rn;

import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl {
    public static boolean j() {
        if (com.bytedance.sdk.openadsdk.core.oq.i().hl()) {
            return true;
        }
        Context context = com.bytedance.sdk.openadsdk.core.v.getContext();
        if (context.getApplicationInfo() != null) {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    public static void j(com.bytedance.sdk.openadsdk.i.cw.cw.j jVar) {
        try {
            if (!jVar.tl() || com.bytedance.sdk.component.utils.vl.j()) {
                return;
            }
            System.currentTimeMillis();
            if (Boolean.parseBoolean(new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop debug.ttcsj.debugmode").getInputStream())).readLine())) {
                com.bytedance.sdk.component.utils.vl.xt();
                com.bykv.vk.openvk.component.video.api.m.cw.j();
                com.bytedance.sdk.component.g.j.j();
                com.bytedance.sdk.openadsdk.tools.xt.xt();
                com.bytedance.sdk.component.vl.xt.j.j(true);
            }
        } catch (Exception unused) {
        }
    }
}
