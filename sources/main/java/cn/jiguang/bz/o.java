package cn.jiguang.bz;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.net.Inet6Address;
import java.util.Iterator;

/* loaded from: D:\Downloads\app\classes2.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public static String f2773a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f2774b = "";

    private static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if ("wifi".equalsIgnoreCase(str)) {
            return 1;
        }
        if ("2g".equals(str)) {
            return 2;
        }
        if ("3g".equals(str)) {
            return 3;
        }
        if ("4g".equals(str)) {
            return 4;
        }
        return "5g".equals(str) ? 5 : 0;
    }

    public static int b(Context context) {
        return a(a(context));
    }

    private static String c(int i6) {
        cn.jiguang.bb.f.a("NetworkUtils", "getNetworkClass networkType:" + i6);
        switch (i6) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2g";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3g";
            case 13:
                return "4g";
            default:
                switch (i6) {
                    case 16:
                        return "2g";
                    case 17:
                        return "3g";
                    case 18:
                    case 19:
                        return "4g";
                    case 20:
                        return "5g";
                    default:
                        return "unknown";
                }
        }
    }

    public static boolean e() {
        Network activeNetwork;
        try {
            ConnectivityManager d6 = d();
            if (d6 == null || Build.VERSION.SDK_INT < 23) {
                return false;
            }
            activeNetwork = d6.getActiveNetwork();
            LinkProperties linkProperties = d6.getLinkProperties(activeNetwork);
            if (linkProperties == null) {
                return false;
            }
            Iterator<LinkAddress> it = linkProperties.getLinkAddresses().iterator();
            while (it.hasNext()) {
                if (it.next().getAddress() instanceof Inet6Address) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:12|13|(8:15|(1:17)(2:31|(1:33))|18|19|20|(1:26)|24|25)|35|18|19|20|(1:22)|26|24|25) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
    
        r3 = r1;
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005a, code lost:
    
        cn.jiguang.bb.f.i("NetworkUtils", "getCurrentNetType failed, " + r1.getMessage());
        r1 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r7) {
        /*
            java.lang.String r0 = "NetworkUtils"
            boolean r1 = g()
            java.lang.String r2 = "unknown"
            if (r1 != 0) goto Lb
            return r2
        Lb:
            android.net.ConnectivityManager r1 = d()
            if (r1 != 0) goto L12
            return r2
        L12:
            java.lang.String r3 = "getCurrentNetType"
            boolean r3 = cn.jiguang.bz.k.a(r3)
            if (r3 == 0) goto L1d
            java.lang.String r7 = cn.jiguang.bz.o.f2773a
            return r7
        L1d:
            android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L40
            int r3 = r1.getType()     // Catch: java.lang.Throwable -> L2e
            r4 = 1
            if (r3 != r4) goto L31
            java.lang.String r1 = "wifi"
            goto L41
        L2e:
            r1 = move-exception
            r3 = r2
            goto L5a
        L31:
            int r3 = r1.getType()     // Catch: java.lang.Throwable -> L2e
            if (r3 != 0) goto L40
            int r1 = r1.getSubtype()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r1 = c(r1)     // Catch: java.lang.Throwable -> L2e
            goto L41
        L40:
            r1 = r2
        L41:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L56
            r3.<init>()     // Catch: java.lang.Throwable -> L56
            java.lang.String r4 = "getCurrentNetType by api type="
            r3.append(r4)     // Catch: java.lang.Throwable -> L56
            r3.append(r1)     // Catch: java.lang.Throwable -> L56
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L56
            cn.jiguang.bb.f.c(r0, r3)     // Catch: java.lang.Throwable -> L56
            goto L73
        L56:
            r3 = move-exception
            r6 = r3
            r3 = r1
            r1 = r6
        L5a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "getCurrentNetType failed, "
            r4.append(r5)
            java.lang.String r1 = r1.getMessage()
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            cn.jiguang.bb.f.i(r0, r1)
            r1 = r3
        L73:
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L7f
            boolean r0 = android.text.TextUtils.equals(r1, r2)
            if (r0 == 0) goto L83
        L7f:
            java.lang.String r1 = cn.jiguang.bz.x.b(r7)
        L83:
            cn.jiguang.bz.o.f2773a = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bz.o.a(android.content.Context):java.lang.String");
    }

    public static boolean b() {
        return a(0);
    }

    public static String c(Context context) {
        ConnectivityManager d6;
        if (!g() || (d6 = d()) == null) {
            return "";
        }
        if (k.a("getNetworkType", TTAdConstant.AD_MAX_EVENT_TIME)) {
            return f2774b;
        }
        try {
            NetworkInfo activeNetworkInfo = d6.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "unknown";
            }
            String typeName = activeNetworkInfo.getTypeName();
            String subtypeName = activeNetworkInfo.getSubtypeName();
            if (typeName == null) {
                typeName = "unknown";
            } else if (!w.a(subtypeName)) {
                typeName = typeName + "," + subtypeName;
            }
            f2774b = typeName.toLowerCase();
            cn.jiguang.bb.f.c("NetworkUtils", "getNetworkType final networkType: " + f2774b);
            return f2774b;
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("NetworkUtils", "getNetworkType failed, " + th.getMessage());
            return "unknown";
        }
    }

    public static boolean a() {
        return a(1);
    }

    private static boolean b(int i6) {
        return i6 == 0 || i6 == 4 || i6 == 5 || i6 == 2 || i6 == 6 || i6 == 3;
    }

    public static boolean c() {
        return a(10000);
    }

    public static ConnectivityManager d() {
        Context a6 = d.a();
        if (a6 == null || !q.a(a6, com.kuaishou.weapon.p0.g.f36042b)) {
            return null;
        }
        return (ConnectivityManager) a6.getSystemService("connectivity");
    }

    public static String f() {
        boolean z5;
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        ConnectivityManager d6 = d();
        if (d6 == null) {
            return null;
        }
        boolean z6 = false;
        boolean z7 = true;
        if (Build.VERSION.SDK_INT >= 23) {
            activeNetwork = d6.getActiveNetwork();
            if (activeNetwork == null || (networkCapabilities = d6.getNetworkCapabilities(activeNetwork)) == null) {
                return null;
            }
            boolean hasTransport = networkCapabilities.hasTransport(3);
            z5 = networkCapabilities.hasTransport(1);
            z7 = networkCapabilities.hasTransport(0);
            z6 = hasTransport;
        } else {
            NetworkInfo activeNetworkInfo = d6.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            int type = activeNetworkInfo.getType();
            if (type != 0) {
                if (type != 1) {
                    z5 = false;
                    if (type == 9) {
                        z6 = true;
                    }
                } else {
                    z5 = true;
                }
                z7 = false;
            } else {
                z5 = false;
            }
        }
        if (z6) {
            return "ethernet";
        }
        if (z5) {
            return "wifi";
        }
        if (!z7) {
            return null;
        }
        return "cellular";
    }

    private static boolean g() {
        return cn.jiguang.g.a.a().e(AVMDLDataLoader.KeyIsIsChecksumLevel);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
    
        r1 = r0.getActiveNetwork();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(int r5) {
        /*
            android.net.ConnectivityManager r0 = d()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r1 < r2) goto L4f
            android.net.Network r1 = androidx.work.impl.constraints.trackers.a.a(r0)
            if (r1 != 0) goto L15
            boolean r5 = a(r0, r5)
            return r5
        L15:
            android.net.NetworkCapabilities r1 = r0.getNetworkCapabilities(r1)
            if (r1 != 0) goto L20
            boolean r5 = a(r0, r5)
            return r5
        L20:
            r2 = 12
            boolean r2 = r1.hasCapability(r2)
            r3 = 16
            boolean r3 = r1.hasCapability(r3)
            if (r2 == 0) goto L4a
            if (r3 != 0) goto L31
            goto L4a
        L31:
            r2 = 0
            r3 = 1
            if (r5 == 0) goto L3a
            if (r5 == r3) goto L38
            return r3
        L38:
            r4 = 1
            goto L3b
        L3a:
            r4 = 0
        L3b:
            boolean r1 = r1.hasTransport(r4)
            if (r1 != 0) goto L49
            boolean r5 = a(r0, r5)
            if (r5 == 0) goto L48
            goto L49
        L48:
            return r2
        L49:
            return r3
        L4a:
            boolean r5 = a(r0, r5)
            return r5
        L4f:
            boolean r5 = a(r0, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bz.o.a(int):boolean");
    }

    private static boolean a(ConnectivityManager connectivityManager, int i6) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (10000 == i6) {
                return true;
            }
            int type = activeNetworkInfo.getType();
            if (i6 == 0) {
                return b(type);
            }
            if (type == i6) {
                return true;
            }
        }
        return false;
    }
}
