package com.ss.android.socialbase.appdownloader.j;

import android.content.Context;
import android.content.Intent;

/* loaded from: D:\Downloads\app\classes6.dex */
public class l extends d {
    @Override // com.ss.android.socialbase.appdownloader.j.k
    public Intent xt() {
        String cw = this.f38465b.cw("s");
        String b6 = com.ss.android.socialbase.appdownloader.m.a.b(this.f38465b.cw("ag"), cw);
        String b7 = com.ss.android.socialbase.appdownloader.m.a.b(this.f38465b.cw("ah"), cw);
        String b8 = com.ss.android.socialbase.appdownloader.m.a.b(this.f38465b.cw("ai"), cw);
        String b9 = com.ss.android.socialbase.appdownloader.m.a.b(this.f38465b.cw("aj"), cw);
        Intent intent = new Intent();
        intent.putExtra(b6, this.f38466c);
        intent.putExtra(b7, "*/*");
        intent.putExtra(b8, true);
        intent.setAction(b9);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }

    public l(Context context, com.ss.android.socialbase.downloader.jy.j jVar, String str) {
        super(context, jVar, str);
    }
}
