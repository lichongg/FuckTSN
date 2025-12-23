package com.huawei.hms.hatool;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import com.umeng.analytics.pro.au;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class z0 {

    /* renamed from: c, reason: collision with root package name */
    private static z0 f33683c = new z0();

    /* renamed from: a, reason: collision with root package name */
    private boolean f33684a = false;

    /* renamed from: b, reason: collision with root package name */
    private Context f33685b = y0.q();

    public static z0 b() {
        return f33683c;
    }

    @TargetApi(24)
    public boolean a() {
        boolean z5;
        if (!this.f33684a) {
            Context context = this.f33685b;
            if (context == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                UserManager userManager = (UserManager) context.getSystemService(au.f40908m);
                if (userManager != null) {
                    z5 = userManager.isUserUnlocked();
                } else {
                    this.f33684a = false;
                }
            } else {
                z5 = true;
            }
            this.f33684a = z5;
        }
        return this.f33684a;
    }

    private z0() {
    }
}
