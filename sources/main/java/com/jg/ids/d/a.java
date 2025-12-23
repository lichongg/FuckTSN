package com.jg.ids.d;

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
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        return intent;
    }

    @Override // com.jg.ids.g
    protected final void a(IBinder iBinder) {
        try {
            b a6 = c.a(iBinder);
            if (a6 != null) {
                c(a6.b());
                b();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final boolean d() {
        if (this.f35525a == null) {
            return false;
        }
        try {
            return this.f35525a.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e6) {
            return false;
        }
    }
}
