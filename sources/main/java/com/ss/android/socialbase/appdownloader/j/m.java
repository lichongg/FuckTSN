package com.ss.android.socialbase.appdownloader.j;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.RequiresApi;

@RequiresApi(api = 26)
/* loaded from: D:\Downloads\app\classes6.dex */
public class m extends d {
    public m(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.j.k
    public Intent xt() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.f38464a.getPackageName()));
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        intent.addFlags(268435456);
        return intent;
    }
}
