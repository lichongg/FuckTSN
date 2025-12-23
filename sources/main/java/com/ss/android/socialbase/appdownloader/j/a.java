package com.ss.android.socialbase.appdownloader.j;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.xt.up;

/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends d {
    @Override // com.ss.android.socialbase.appdownloader.j.k
    public Intent xt() {
        Intent intent = new Intent(up.cw + ".filemanager.intent.action.BROWSER_FILE");
        intent.putExtra("CurrentDir", this.f38466c);
        intent.putExtra("CurrentMode", 1);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }

    public a(Context context, com.ss.android.socialbase.downloader.jy.j jVar, String str) {
        super(context, jVar, str);
    }
}
