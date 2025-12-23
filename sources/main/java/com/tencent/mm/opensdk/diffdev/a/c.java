package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class c extends AsyncTask<Void, Void, a> {

    /* renamed from: a, reason: collision with root package name */
    private String f40426a;

    /* renamed from: b, reason: collision with root package name */
    private String f40427b;

    /* renamed from: c, reason: collision with root package name */
    private OAuthListener f40428c;

    /* renamed from: d, reason: collision with root package name */
    private int f40429d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        public OAuthErrCode f40430a;

        /* renamed from: b, reason: collision with root package name */
        public String f40431b;

        /* renamed from: c, reason: collision with root package name */
        public int f40432c;

        a() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016c A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.tencent.mm.opensdk.diffdev.a.c.a doInBackground(java.lang.Void[] r14) {
        /*
            Method dump skipped, instructions count: 432
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.diffdev.a.c.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.f40428c.onAuthFinish(aVar2.f40430a, aVar2.f40431b);
    }

    public c(String str, OAuthListener oAuthListener) {
        this.f40426a = str;
        this.f40428c = oAuthListener;
        this.f40427b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }
}
