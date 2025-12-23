package com.jg.ids.j;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.jg.ids.g;

/* loaded from: D:\Downloads\app\classes10.dex */
public final class d extends g {
    public d(Context context) {
        super(context);
    }

    @Override // com.jg.ids.g
    protected final Intent a() {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }

    @Override // com.jg.ids.g
    protected final void a(IBinder iBinder) {
        try {
            a a6 = b.a(iBinder);
            if (a6 != null) {
                String b6 = a6.b(this.f35525a.getPackageName());
                String a7 = a6.a(this.f35525a.getPackageName());
                String a8 = a6.a();
                a(b6);
                b(a7);
                c(a8);
            }
            b();
        } catch (Throwable th) {
        }
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final boolean d() {
        if (this.f35525a == null) {
            return false;
        }
        try {
            return this.f35525a.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception e6) {
            return false;
        }
    }
}
