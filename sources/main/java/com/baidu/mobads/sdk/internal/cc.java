package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.sdk.internal.ca;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class cc extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ca f10863a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    cc(ca caVar, Looper looper) {
        super(looper);
        this.f10863a = caVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        bu buVar;
        boolean z5;
        Context context;
        bu buVar2;
        boolean z6;
        boolean p5;
        String string = message.getData().getString(ca.f10848n);
        by byVar = (by) message.getData().getParcelable(ca.f10847m);
        if (!ca.f10845k.equals(string)) {
            buVar = this.f10863a.f10860z;
            buVar.a(ca.f10835a, "mOnApkDownloadCompleted: download failed, code: " + string);
            this.f10863a.a(false);
            z5 = this.f10863a.A;
            if (z5) {
                this.f10863a.A = false;
                this.f10863a.a(false, "Refused to download remote for version...");
                return;
            }
            return;
        }
        String e6 = byVar.e();
        context = this.f10863a.f10859y;
        bt btVar = new bt(e6, context, byVar);
        try {
            try {
                ca caVar = this.f10863a;
                if (caVar.f10856u != ca.f10854t) {
                    caVar.a(btVar);
                    btVar.a(ca.f());
                    this.f10863a.a(true);
                } else {
                    btVar.a();
                    btVar.a(ca.f());
                    if (ca.f10850p != null) {
                        ca.f10850p.f10769b = byVar.b();
                    }
                    this.f10863a.l();
                    z6 = this.f10863a.A;
                    if (z6) {
                        this.f10863a.A = false;
                        ca caVar2 = this.f10863a;
                        p5 = caVar2.p();
                        caVar2.a(p5, "load remote file just downloaded");
                    }
                }
            } catch (ca.a e7) {
                String str = "download apk file failed: " + e7.toString();
                this.f10863a.a(false);
                buVar2 = this.f10863a.f10860z;
                buVar2.a(ca.f10835a, str);
            }
            btVar.delete();
        } catch (Throwable th) {
            btVar.delete();
            throw th;
        }
    }
}
