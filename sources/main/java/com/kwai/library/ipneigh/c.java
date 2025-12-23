package com.kwai.library.ipneigh;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private static d A(Context context, boolean z5) {
        return b(context, false, false);
    }

    public static d es(Context context) {
        return A(context, false);
    }

    private static d b(Context context, boolean z5, boolean z6) {
        String str;
        try {
            if (!b.isWifiConnected(context)) {
                return new d("", false, "");
            }
            String fl = b.fl(((WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi")).getDhcpInfo().gateway);
            if (z5) {
                str = "";
            } else {
                str = a.hR("timeout 5 ip neigh show " + fl);
            }
            if (z5 || TextUtils.isEmpty(str)) {
                str = KwaiIpNeigh.i(fl, false);
            }
            return new d(b.hT(str), !TextUtils.isEmpty(r3), str);
        } catch (Throwable th) {
            return new d("", false, th.getMessage());
        }
    }
}
