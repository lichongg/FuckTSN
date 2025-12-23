package com.jg.ids.b;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.jg.ids.g;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes10.dex */
public final class a extends g {
    public a(Context context) {
        super(context);
        if (context instanceof Application) {
            this.f35525a = context;
        } else {
            this.f35525a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    @Override // com.jg.ids.g
    protected final Intent a() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return intent;
    }

    @Override // com.jg.ids.g
    protected final void a(IBinder iBinder) {
        try {
            b a6 = c.a(iBinder);
            if (a6 != null) {
                String d6 = a6.d(this.f35525a.getPackageName());
                String c6 = a6.c(this.f35525a.getPackageName());
                String b6 = a6.b(this.f35525a.getPackageName());
                a(d6);
                b(c6);
                c(b6);
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
            return this.f35525a.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception e6) {
            return false;
        }
    }
}
