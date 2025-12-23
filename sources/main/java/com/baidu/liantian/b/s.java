package com.baidu.liantian.b;

import android.annotation.SuppressLint;
import android.net.TrafficStats;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class s {
    @SuppressLint({"NewApi"})
    public static void a() {
        try {
            TrafficStats.setThreadStatsTag(155648);
        } catch (Throwable unused) {
            e.a();
        }
    }

    @SuppressLint({"NewApi"})
    public static void b() {
        try {
            TrafficStats.clearThreadStatsTag();
        } catch (Throwable unused) {
            e.a();
        }
    }
}
