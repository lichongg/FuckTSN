package com.jg.ids.e;

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
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        return intent;
    }

    @Override // com.jg.ids.g
    protected final void a(IBinder iBinder) {
        b a6 = c.a(iBinder);
        if (a6 != null) {
            String a7 = a6.a();
            a("");
            b("");
            c(a7);
        }
    }
}
