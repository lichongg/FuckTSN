package com.tencent.open.b;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.tencent.open.log.SLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected static final Uri f40512a = Uri.parse("content://telephony/carriers/preferapn");

    static NetworkInfo e(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(Context context) {
        return "";
    }

    public static int d(Context context) {
        NetworkInfo e6;
        try {
            e6 = e(context);
        } catch (Exception e7) {
            SLog.e("openSDK_LOG.APNUtil", "getMProxyType has exception: " + e7.getMessage());
        }
        if (e6 == null) {
            return 128;
        }
        if (e6.getTypeName().toUpperCase().equals("WIFI")) {
            return 2;
        }
        String lowerCase = e6.getExtraInfo().toLowerCase();
        if (lowerCase.startsWith("cmwap")) {
            return 1;
        }
        if (!lowerCase.startsWith("cmnet") && !lowerCase.startsWith("epc.tmobile.com")) {
            if (lowerCase.startsWith("uniwap")) {
                return 16;
            }
            if (lowerCase.startsWith("uninet")) {
                return 8;
            }
            if (lowerCase.startsWith("wap")) {
                return 64;
            }
            if (lowerCase.startsWith(TKDownloadReason.KSAD_TK_NET)) {
                return 32;
            }
            if (lowerCase.startsWith("ctwap")) {
                return 512;
            }
            if (lowerCase.startsWith("ctnet")) {
                return 256;
            }
            if (lowerCase.startsWith("3gwap")) {
                return 1024;
            }
            if (lowerCase.startsWith("3gnet")) {
                return 2048;
            }
            if (lowerCase.startsWith("#777")) {
                String c6 = c(context);
                if (c6 != null) {
                    if (c6.length() > 0) {
                        return 512;
                    }
                }
                return 256;
            }
            return 128;
        }
        return 4;
    }

    public static String a(Context context) {
        int d6 = d(context);
        if (d6 == 2) {
            return "wifi";
        }
        if (d6 == 1) {
            return "cmwap";
        }
        if (d6 == 4) {
            return "cmnet";
        }
        if (d6 == 16) {
            return "uniwap";
        }
        if (d6 == 8) {
            return "uninet";
        }
        if (d6 == 64) {
            return "wap";
        }
        if (d6 == 32) {
            return TKDownloadReason.KSAD_TK_NET;
        }
        if (d6 == 512) {
            return "ctwap";
        }
        if (d6 == 256) {
            return "ctnet";
        }
        if (d6 == 2048) {
            return "3gnet";
        }
        if (d6 == 1024) {
            return "3gwap";
        }
        String b6 = b(context);
        if (b6 != null && b6.length() != 0) {
            return b6;
        }
        return "none";
    }

    public static String c(Context context) {
        try {
            Cursor query = context.getContentResolver().query(f40512a, null, null, null, null);
            if (query == null) {
                return null;
            }
            query.moveToFirst();
            if (query.isAfterLast()) {
                query.close();
                return null;
            }
            String string = query.getString(query.getColumnIndex("proxy"));
            query.close();
            return string;
        } catch (SecurityException e6) {
            SLog.e("openSDK_LOG.APNUtil", "getApnProxy has exception: " + e6.getMessage());
            return "";
        }
    }
}
