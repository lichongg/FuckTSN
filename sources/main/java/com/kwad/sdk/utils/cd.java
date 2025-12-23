package com.kwad.sdk.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class cd {
    private static boolean bbN;
    private static final List<a> bbO = new CopyOnWriteArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements com.kwad.sdk.core.b {
        public String bbP;
        public String bbQ;
        public int level;

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "level", this.level);
            aa.putValue(jSONObject, "ssid", this.bbP);
            aa.putValue(jSONObject, "bssid", this.bbQ);
            return jSONObject;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }
    }

    public static List<a> o(Context context, int i6) {
        WifiManager wifiManager;
        if (bc.useNetworkStateDisable()) {
            return new ArrayList();
        }
        if (!bbN && ServiceProvider.getSDKConfig().canReadNearbyWifiList()) {
            List<a> list = bbO;
            if (list.isEmpty() && context != null) {
                if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(32L)) {
                    try {
                    } catch (Exception e6) {
                        bbN = true;
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
                    }
                    if (!ef(context) && (wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi")) != null) {
                        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                        List<ScanResult> scanResults = wifiManager.getScanResults();
                        if (scanResults != null) {
                            for (ScanResult scanResult : scanResults) {
                                a aVar = new a();
                                aVar.bbP = scanResult.SSID;
                                aVar.bbQ = scanResult.BSSID;
                                aVar.level = scanResult.level;
                                if (connectionInfo.getBSSID() == null || scanResult.BSSID == null || !TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) || connectionInfo.getSSID() == null || scanResult.SSID == null || !TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                                    bbO.add(aVar);
                                } else {
                                    bbO.add(0, aVar);
                                }
                                List<a> list2 = bbO;
                                if (list2.size() >= i6) {
                                    return list2;
                                }
                            }
                        }
                        return bbO;
                    }
                }
                return list;
            }
        }
        return bbO;
    }

    public static boolean ef(Context context) {
        if (context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36047g) != -1) {
                return false;
            }
            return true;
        }
        if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36047g) != -1 || ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36048h) != -1) {
            return false;
        }
        return true;
    }
}
