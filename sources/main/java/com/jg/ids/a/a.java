package com.jg.ids.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.jg.ids.g;

/* loaded from: D:\Downloads\app\classes10.dex */
public final class a extends g {
    public a(Context context) {
        super(context);
    }

    @Override // com.jg.ids.g
    protected final Intent a() {
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }

    @Override // com.jg.ids.g
    protected final void a(IBinder iBinder) {
        try {
            b a6 = c.a(iBinder);
            if (a6 != null) {
                String e6 = a6.e();
                String d6 = a6.d();
                String c6 = a6.c();
                a(e6);
                b(d6);
                c(c6);
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
            return this.f35525a.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Exception e6) {
            return false;
        }
    }
}
