package com.bytedance.j.xt.j;

import android.app.ActivityManager;

/* loaded from: D:\Downloads\app\classes3.dex */
public class f {
    static String a(ActivityManager.ProcessErrorStateInfo processErrorStateInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("|------------- processErrorStateInfo--------------|\n");
        sb.append("condition: " + processErrorStateInfo.condition + com.snail.antifake.deviceid.e.f37542d);
        sb.append("processName: " + processErrorStateInfo.processName + com.snail.antifake.deviceid.e.f37542d);
        sb.append("pid: " + processErrorStateInfo.pid + com.snail.antifake.deviceid.e.f37542d);
        sb.append("uid: " + processErrorStateInfo.uid + com.snail.antifake.deviceid.e.f37542d);
        sb.append("tag: " + processErrorStateInfo.tag + com.snail.antifake.deviceid.e.f37542d);
        sb.append("shortMsg : " + processErrorStateInfo.shortMsg + com.snail.antifake.deviceid.e.f37542d);
        sb.append("longMsg : " + processErrorStateInfo.longMsg + com.snail.antifake.deviceid.e.f37542d);
        sb.append("-----------------------end----------------------------");
        return sb.toString();
    }
}
