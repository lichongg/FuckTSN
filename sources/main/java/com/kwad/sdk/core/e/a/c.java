package com.kwad.sdk.core.e.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.kwad.sdk.core.e.b.c;
import java.util.concurrent.CountDownLatch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    public C0685c aFR;
    public Context mContext;
    public final a aFS = new a();
    public final b aFT = new b();
    public final CountDownLatch mCountDownLatch = new CountDownLatch(2);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a extends c.a {
        public a() {
        }

        @Override // com.kwad.sdk.core.e.b.c.a
        public final void a(int i6, Bundle bundle) {
            com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "OAIDCallBack handleResult retCode = " + i6 + " retInfo = " + bundle);
            if (i6 == 0) {
                try {
                    C0685c c0685c = c.this.aFR;
                    if (c0685c != null) {
                        c0685c.aoB = bundle.getString("oa_id_flag");
                        com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "OAIDCallBack handleResult success");
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "OAIDCallBack handleResult error: " + th.getMessage());
                    return;
                }
            }
            c.a(c.this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b extends c.a {
        public b() {
        }

        @Override // com.kwad.sdk.core.e.b.c.a
        public final void a(int i6, Bundle bundle) {
            com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "OAIDLimitCallback handleResult retCode=" + i6 + " retInfo= " + bundle);
            if (i6 == 0) {
                try {
                    if (c.this.aFR != null) {
                        boolean z5 = bundle.getBoolean("oa_id_limit_state");
                        c.this.aFR.aFV = z5;
                        com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "OAIDLimitCallback handleResult success  isLimit=" + z5);
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "OAIDLimitCallback handleResult error:  " + th.getMessage());
                    return;
                }
            }
            c.a(c.this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.core.e.a.c$c, reason: collision with other inner class name */
    public static final class C0685c {
        public boolean aFV;
        public String aoB;
    }

    public static boolean isAdvertisingIdAvailable(Context context) {
        PackageManager packageManager;
        Intent intent;
        try {
            packageManager = context.getPackageManager();
            intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
        } catch (Exception unused) {
        }
        return !packageManager.queryIntentServices(intent, 0).isEmpty();
    }

    public static void a(c cVar) {
        try {
            cVar.mCountDownLatch.countDown();
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "doCountDown  error:  " + e6.getMessage());
        }
    }
}
