package com.ss.android.socialbase.appdownloader.j;

import android.content.Context;
import android.content.Intent;

/* loaded from: D:\Downloads\app\classes6.dex */
public class h extends d {
    @Override // com.ss.android.socialbase.appdownloader.j.k
    public Intent xt() {
        Intent intent = new Intent("com.android.filemanager.OPEN_FOLDER");
        intent.putExtra("com.android.filemanager.OPEN_FOLDER", this.f38466c);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }

    public h(Context context, com.ss.android.socialbase.downloader.jy.j jVar, String str) {
        super(context, jVar, str);
    }
}
