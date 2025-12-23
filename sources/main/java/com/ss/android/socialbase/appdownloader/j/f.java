package com.ss.android.socialbase.appdownloader.j;

import android.content.Context;
import android.content.Intent;

/* loaded from: D:\Downloads\app\classes6.dex */
public class f extends d {
    public f(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.j.k
    public Intent xt() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        return intent;
    }
}
