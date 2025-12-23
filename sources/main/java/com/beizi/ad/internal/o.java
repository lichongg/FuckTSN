package com.beizi.ad.internal;

import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class o extends com.beizi.ad.internal.h.d {

    /* renamed from: a, reason: collision with root package name */
    private String f12282a;

    public o(String str) {
        super(false, false);
        this.f12282a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.beizi.ad.internal.h.d, android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.beizi.ad.internal.h.e eVar) {
        if (eVar == null || !eVar.a()) {
            return;
        }
        int f6 = eVar.f();
        String g6 = eVar.g();
        if (f6 != 302 || TextUtils.isEmpty(g6)) {
            return;
        }
        new o(g6).b();
    }

    public void b() {
        com.beizi.ad.internal.f.d a6 = com.beizi.ad.internal.f.d.a(h.a().e());
        if (a6.b(h.a().e())) {
            executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
        } else {
            a6.a(this.f12282a, h.a().e());
        }
    }

    @Override // com.beizi.ad.internal.h.d
    protected String a() {
        return this.f12282a;
    }
}
