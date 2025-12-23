package com.beizi.fusion.sm.b.a;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class k implements com.beizi.fusion.sm.b.c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f13522a;

    @Override // com.beizi.fusion.sm.b.c
    @SuppressLint({"AnnotateVersionCheck"})
    public boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f13522a == null || bVar == null) {
            return;
        }
        if (!a()) {
            com.beizi.fusion.sm.b.e.a("Only supports Android 10.0 and above for Nubia");
            bVar.a(new com.beizi.fusion.sm.b.d("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient acquireContentProviderClient = this.f13522a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (acquireContentProviderClient == null) {
                return;
            }
            Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (Build.VERSION.SDK_INT >= 24) {
                androidx.core.provider.c.a(acquireContentProviderClient);
            } else {
                acquireContentProviderClient.release();
            }
            if (call == null) {
                throw new com.beizi.fusion.sm.b.d("OAID query failed: bundle is null");
            }
            String string = call.getInt("code", -1) == 0 ? call.getString("id") : null;
            if (string == null || string.length() == 0) {
                throw new com.beizi.fusion.sm.b.d("OAID query failed: " + call.getString(CrashHianalyticsData.MESSAGE));
            }
            com.beizi.fusion.sm.b.e.a("OAID query success: " + string);
            bVar.a(string);
        } catch (Exception e6) {
            com.beizi.fusion.sm.b.e.a(e6);
            bVar.a(e6);
        }
    }

    public k(Context context) {
        this.f13522a = context;
    }
}
