package com.jg.ids.g;

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
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }

    @Override // com.jg.ids.g
    protected final void a(IBinder iBinder) {
        try {
            a a6 = b.a(iBinder);
            if (a6 != null) {
                String a7 = a6.a(this.f35525a.getPackageName());
                String b6 = a6.b(this.f35525a.getPackageName());
                String a8 = a6.a();
                b(a7);
                a(b6);
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
            return this.f35525a.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception e6) {
            return false;
        }
    }
}
