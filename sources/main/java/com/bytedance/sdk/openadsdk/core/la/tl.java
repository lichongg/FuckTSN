package com.bytedance.sdk.openadsdk.core.la;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.acse.ottn.l3;
import com.bytedance.sdk.component.utils.vl;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl {

    /* renamed from: j, reason: collision with root package name */
    private final Context f29437j;
    private final com.bytedance.sdk.openadsdk.core.la.xt xt;
    private boolean cw = false;

    /* renamed from: r, reason: collision with root package name */
    private int f29438r = 0;

    private static class xt {
        private static volatile xt up;
        private final Runnable ae = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.la.tl.xt.2
            @Override // java.lang.Runnable
            public void run() {
                xt.this.j();
            }
        };
        private ConnectivityManager.NetworkCallback cw;

        /* renamed from: j, reason: collision with root package name */
        private ConnectivityManager f29442j;

        /* renamed from: m, reason: collision with root package name */
        private Handler f29443m;

        /* renamed from: r, reason: collision with root package name */
        private boolean f29444r;
        private Network xt;

        private xt(Context context) {
            try {
                this.f29442j = (ConnectivityManager) context.getSystemService("connectivity");
                this.f29443m = new Handler(Looper.getMainLooper());
            } catch (Exception e6) {
                vl.j(e6);
            }
        }

        public static xt j(Context context) {
            if (up == null) {
                synchronized (xt.class) {
                    try {
                        if (up == null) {
                            up = new xt(context);
                        }
                    } finally {
                    }
                }
            }
            return up;
        }

        @TargetApi(21)
        public void j(final ConnectivityManager.NetworkCallback networkCallback) {
            NetworkInfo networkInfo;
            this.f29443m.removeCallbacks(this.ae);
            ConnectivityManager connectivityManager = this.f29442j;
            if (connectivityManager == null) {
                vl.j("transmit_business", "forceNet mConnectivityManager is null");
                return;
            }
            Network network = this.xt;
            if (network != null && !this.f29444r && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
                vl.j("transmit_business", "forceNet reuse network");
                networkCallback.onAvailable(this.xt);
                return;
            }
            ConnectivityManager.NetworkCallback networkCallback2 = this.cw;
            if (networkCallback2 != null) {
                try {
                    this.f29442j.unregisterNetworkCallback(networkCallback2);
                } catch (Exception e6) {
                    vl.j(e6);
                    this.cw = null;
                }
                vl.j("transmit_business", "forceNet clear");
            }
            NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
            ConnectivityManager.NetworkCallback networkCallback3 = new ConnectivityManager.NetworkCallback() { // from class: com.bytedance.sdk.openadsdk.core.la.tl.xt.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network2) {
                    try {
                        if (xt.this.f29442j.getNetworkCapabilities(network2).hasTransport(0)) {
                            xt.this.xt = network2;
                            networkCallback.onAvailable(network2);
                            xt.this.f29444r = false;
                        } else {
                            vl.j("transmit_business", "forceNet check fail...");
                            xt.this.xt = null;
                            networkCallback.onAvailable(null);
                            xt.this.f29444r = true;
                        }
                    } catch (Exception e7) {
                        vl.j(e7);
                        networkCallback.onAvailable(null);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network2) {
                    xt.this.f29444r = true;
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onUnavailable() {
                    super.onUnavailable();
                    if (Build.VERSION.SDK_INT >= 26) {
                        networkCallback.onUnavailable();
                    }
                }
            };
            this.cw = networkCallback3;
            if (Build.VERSION.SDK_INT >= 26) {
                this.f29442j.requestNetwork(build, networkCallback3, 5000);
            } else {
                this.f29442j.requestNetwork(build, networkCallback3);
            }
        }

        public void j(long j6) {
            this.f29443m.postDelayed(this.ae, j6);
        }

        public void j() {
            if (this.f29442j == null) {
                return;
            }
            try {
                if (this.cw == null) {
                    return;
                }
                vl.j("transmit_business", "unregisterNetwork");
                this.f29442j.unregisterNetworkCallback(this.cw);
                this.cw = null;
                this.xt = null;
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
    }

    public static final class j {
        public static String j(int i6) {
            switch (i6) {
                case 200:
                    return "200_但取号失败";
                case 102101:
                    return "无网络状态";
                case 102102:
                    return "网络异常";
                case 102103:
                    return "预取号只开WiFi";
                case 102203:
                    return "输入参数错误";
                case 102204:
                    return "崩溃错误";
                case 102508:
                    return "数据网络切换失败";
                case 200010:
                    return "imsi获取失败或者没有sim卡，预取号失败";
                case 200050:
                    return "EOF异常";
                default:
                    return "wifi取号失败....";
            }
        }
    }

    public tl(Context context, com.bytedance.sdk.openadsdk.core.la.xt xtVar) {
        this.f29437j = context;
        this.xt = xtVar;
    }

    public void j(String str, r rVar) {
        if (rVar == null) {
            return;
        }
        boolean j6 = m.j(this.f29437j);
        this.f29438r = m.j(this.f29437j, j6);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("headers");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("params");
            Map<String, List<String>> j7 = j(optJSONObject);
            String upperCase = jSONObject.optString("method").toUpperCase();
            String optString = jSONObject.optString("url");
            this.xt.j("method", upperCase);
            this.xt.j("url", optString);
            try {
                if (j(j6, this.xt, rVar)) {
                    if (this.cw) {
                        j(j7, optJSONObject2, rVar);
                    } else {
                        j(null, j7, optJSONObject2, rVar);
                    }
                }
            } catch (Throwable th) {
                vl.j(th);
                rVar.j(false, this.f29438r, 102204, j.j(102204), null, null);
            }
        } catch (JSONException e6) {
            vl.j(e6);
            rVar.j(false, this.f29438r, 102203, j.j(102203), null, null);
        }
    }

    private Map<String, List<String>> j(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                List list = (List) hashMap.get(next);
                if (list == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(optString);
                    hashMap.put(next, arrayList);
                } else {
                    list.add(optString);
                }
            }
            return hashMap;
        } catch (Exception e6) {
            vl.j(e6);
            return hashMap;
        }
    }

    private boolean j(boolean z5, com.bytedance.sdk.openadsdk.core.la.xt xtVar, r rVar) {
        xtVar.j("networktype", this.f29438r);
        vl.j("transmit_business", "preCheck networkType:" + this.f29438r);
        String packageName = this.f29437j.getPackageName();
        String j6 = cw.j(up.j(this.f29437j, packageName));
        xtVar.j("apppackage", packageName);
        xtVar.j("appsign", j6);
        int i6 = this.f29438r;
        if (i6 == 3) {
            this.cw = true;
        }
        if (!z5) {
            rVar.j(false, i6, 200010, j.j(200010), null, null);
            return false;
        }
        if (i6 == 0) {
            rVar.j(false, i6, 102101, j.j(102101), null, null);
            return false;
        }
        if (i6 != 2) {
            return true;
        }
        rVar.j(false, i6, 102103, j.j(102103), null, null);
        return false;
    }

    @TargetApi(21)
    private void j(final Map<String, List<String>> map, final JSONObject jSONObject, final r rVar) {
        vl.j("transmit_business", "wifiSwitchAndDoRequest");
        final xt j6 = xt.j(this.f29437j);
        xt.j(this.f29437j).j(new ConnectivityManager.NetworkCallback() { // from class: com.bytedance.sdk.openadsdk.core.la.tl.1

            /* renamed from: m, reason: collision with root package name */
            private final AtomicBoolean f29440m = new AtomicBoolean(false);

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                vl.j("transmit_business", "wifiSwitchAndDoRequest onAvailable:".concat(String.valueOf(network)));
                if (this.f29440m.getAndSet(true) || network == null) {
                    return;
                }
                tl.this.j(network, map, jSONObject, rVar);
                j6.j(1000L);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                vl.j("transmit_business", "wifiSwitchAndDoRequest onUnavailable");
                rVar.j(false, tl.this.f29438r, 102508, j.j(102508), null, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Network network, Map<String, List<String>> map, JSONObject jSONObject, r rVar) {
        String j6 = this.xt.j("url");
        String j7 = this.xt.j("method");
        g gVar = new g(j6, j7, map, jSONObject);
        gVar.j(this.xt.j("apppackage"));
        gVar.xt(this.xt.j("appsign"));
        if (l3.f4736f.equalsIgnoreCase(j7)) {
            gVar.j("Content-Type", "application/x-www-form-urlencoded");
        }
        try {
            com.bytedance.sdk.openadsdk.core.la.j.j.j(gVar, this.xt.xt("networktype"), this.xt.j("apppackage"));
            j(network, gVar, rVar);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01b6  */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.lang.CharSequence, java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.CharSequence, java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r24v0, types: [com.bytedance.sdk.openadsdk.core.la.tl] */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v20, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v23, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.Closeable] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j(android.net.Network r25, com.bytedance.sdk.openadsdk.core.la.g r26, com.bytedance.sdk.openadsdk.core.la.r r27) {
        /*
            Method dump skipped, instructions count: 536
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.la.tl.j(android.net.Network, com.bytedance.sdk.openadsdk.core.la.g, com.bytedance.sdk.openadsdk.core.la.r):void");
    }

    private void j(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e6) {
                vl.j(e6);
            }
        }
    }
}
