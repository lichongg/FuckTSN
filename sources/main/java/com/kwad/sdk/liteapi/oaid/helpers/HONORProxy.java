package com.kwad.sdk.liteapi.oaid.helpers;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface;
import java.util.concurrent.CountDownLatch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class HONORProxy {
    public c info;
    public Context mContext;
    public final a mBinderOne = new a();
    public final b mBinderTwo = new b();
    public final CountDownLatch mCountDownLatch = new CountDownLatch(2);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a extends HONORProxyInterface.a {
        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface.a, com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface
        public final void a(int i6, long j6, boolean z5, float f6, double d6, String str) {
        }

        public a() {
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface.a, com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface
        public final void a(int i6, Bundle bundle) {
            LiteApiLogger.d("HONORDeviceIDHelper", "OAIDCallBack handleResult retCode = " + i6 + " retInfo = " + bundle);
            if (i6 == 0) {
                try {
                    c cVar = HONORProxy.this.info;
                    if (cVar != null) {
                        cVar.aoB = bundle.getString("oa_id_flag");
                        LiteApiLogger.d("HONORDeviceIDHelper", "OAIDCallBack handleResult success");
                    }
                } catch (Throwable th) {
                    LiteApiLogger.d("HONORDeviceIDHelper", "OAIDCallBack handleResult error: " + th.getMessage());
                    return;
                }
            }
            HONORProxy.countDown(HONORProxy.this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b extends HONORProxyInterface.a {
        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface.a, com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface
        public final void a(int i6, long j6, boolean z5, float f6, double d6, String str) {
        }

        public b() {
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface.a, com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface
        public final void a(int i6, Bundle bundle) {
            LiteApiLogger.d("HONORDeviceIDHelper", "OAIDLimitCallback handleResult retCode=" + i6 + " retInfo= " + bundle);
            if (i6 == 0) {
                try {
                    if (HONORProxy.this.info != null) {
                        boolean z5 = bundle.getBoolean("oa_id_limit_state");
                        HONORProxy.this.info.aFV = z5;
                        LiteApiLogger.d("HONORDeviceIDHelper", "OAIDLimitCallback handleResult success  isLimit=" + z5);
                    }
                } catch (Throwable th) {
                    LiteApiLogger.d("HONORDeviceIDHelper", "OAIDLimitCallback handleResult error:  " + th.getMessage());
                    return;
                }
            }
            HONORProxy.countDown(HONORProxy.this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c {
        public boolean aFV;
        public String aoB;
    }

    public boolean isAdvertisingIdAvailable(Context context) {
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

    public static void countDown(HONORProxy hONORProxy) {
        try {
            hONORProxy.mCountDownLatch.countDown();
        } catch (Exception e6) {
            LiteApiLogger.d("HONORDeviceIDHelper", "doCountDown  error:  " + e6.getMessage());
        }
    }
}
