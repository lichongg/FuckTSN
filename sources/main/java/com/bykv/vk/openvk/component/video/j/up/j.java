package com.bykv.vk.openvk.component.video.j.up;

import android.os.Build;
import android.view.View;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static final int f23038j = Build.VERSION.SDK_INT;

    public static int j(long j6, long j7) {
        return Math.min(Math.max(0, j7 > 0 ? (int) (((j6 * 1.0d) / j7) * 100.0d) : 0), 100);
    }

    public static String j(long j6) {
        StringBuilder sb = new StringBuilder();
        long j7 = j6 / 60000;
        long j8 = ((j6 % 3600000) % 60000) / 1000;
        if (j7 >= 10) {
            sb.append(j7);
        } else if (j7 > 0) {
            sb.append(0);
            sb.append(j7);
        } else {
            sb.append(0);
            sb.append(0);
        }
        sb.append(":");
        if (j8 >= 10) {
            sb.append(j8);
        } else if (j8 > 0) {
            sb.append(0);
            sb.append(j8);
        } else {
            sb.append(0);
            sb.append(0);
        }
        return sb.toString();
    }

    public static void j(View view, boolean z5) {
        if (view == null) {
            return;
        }
        if (z5) {
            view.setSystemUiVisibility(0);
            return;
        }
        int i6 = f23038j;
        if (i6 >= 19) {
            view.setSystemUiVisibility(3846);
        } else if (i6 >= 16) {
            view.setSystemUiVisibility(5);
        } else {
            view.setSystemUiVisibility(1);
        }
    }
}
