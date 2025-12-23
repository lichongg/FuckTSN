package com.baidu.liantian.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.mobads.sdk.internal.by;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.framework.common.ContainerUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class g {
    public static String a(Context context) {
        try {
            com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
            String string = eVar.f10458b.getString("xyus", "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            String n6 = n(context);
            String e6 = e(context);
            if (TextUtils.isEmpty(e6)) {
                e6 = "0";
            }
            String str = n6 + Logger.f33116c + new StringBuffer(e6).reverse().toString();
            eVar.f10460d.putString("xyus", str);
            eVar.f10460d.commit();
            return str;
        } catch (Throwable unused) {
            e.a();
            return "";
        }
    }

    public static String b(Context context) {
        try {
            com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
            String string = eVar.f10458b.getString("sgud", "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            if (Build.VERSION.SDK_INT > 25) {
                return "";
            }
            String e6 = e(context);
            String f6 = f(context);
            if (TextUtils.isEmpty(e6) && TextUtils.isEmpty(f6)) {
                return "";
            }
            byte[] bytes = (e6 + ":" + f6).getBytes();
            for (int i6 = 0; i6 < bytes.length; i6++) {
                bytes[i6] = (byte) (bytes[i6] ^ 246);
            }
            String a6 = o.a(bytes);
            if (TextUtils.isEmpty(a6)) {
                return "";
            }
            eVar.f10460d.putString("sgud", a6);
            eVar.f10460d.commit();
            return a6;
        } catch (Throwable unused) {
            e.a();
            return "";
        }
    }

    public static String c(Context context) {
        try {
            return "4|" + p.a(context);
        } catch (Throwable unused) {
            e.a();
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:3:0x0002, B:12:0x001f, B:14:0x002f, B:18:0x0053, B:21:0x005f, B:25:0x001c), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0053 A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:3:0x0002, B:12:0x001f, B:14:0x002f, B:18:0x0053, B:21:0x005f, B:25:0x001c), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d(android.content.Context r5) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = f(r5)     // Catch: java.lang.Throwable -> L81
            android.content.ContentResolver r2 = r5.getContentResolver()     // Catch: java.lang.Throwable -> L1b
            java.lang.String r3 = "bd_setting_i"
            java.lang.String r2 = android.provider.Settings.System.getString(r2, r3)     // Catch: java.lang.Throwable -> L1b
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L1c
            if (r3 == 0) goto L1f
            java.lang.String r2 = e(r5)     // Catch: java.lang.Throwable -> L1c
            goto L1f
        L1b:
            r2 = r0
        L1c:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> L81
        L1f:
            android.content.ContentResolver r3 = r5.getContentResolver()     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = "com.baidu.deviceid"
            java.lang.String r3 = android.provider.Settings.System.getString(r3, r4)     // Catch: java.lang.Throwable -> L81
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L81
            if (r4 == 0) goto L50
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = "com.baidu"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L81
            r3.append(r2)     // Catch: java.lang.Throwable -> L81
            r3.append(r1)     // Catch: java.lang.Throwable -> L81
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L81
            byte[] r1 = r1.getBytes()     // Catch: java.lang.Throwable -> L81
            java.lang.String r1 = a(r1)     // Catch: java.lang.Throwable -> L81
            android.content.ContentResolver r2 = r5.getContentResolver()     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = android.provider.Settings.System.getString(r2, r1)     // Catch: java.lang.Throwable -> L81
        L50:
            if (r3 != 0) goto L53
            return r0
        L53:
            java.lang.String r5 = e(r5)     // Catch: java.lang.Throwable -> L81
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto L5f
            java.lang.String r5 = "0"
        L5f:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L81
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuffer r5 = r1.reverse()     // Catch: java.lang.Throwable -> L81
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            r1.<init>()     // Catch: java.lang.Throwable -> L81
            r1.append(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = "|"
            r1.append(r2)     // Catch: java.lang.Throwable -> L81
            r1.append(r5)     // Catch: java.lang.Throwable -> L81
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L81
            return r5
        L81:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.b.g.d(android.content.Context):java.lang.String");
    }

    public static String g(Context context) {
        try {
            try {
                String string = Settings.System.getString(context.getContentResolver(), "bd_setting_i");
                if (TextUtils.isEmpty(string)) {
                    string = e(context);
                }
                String e6 = e(context);
                if (TextUtils.isEmpty(e6)) {
                    e6 = "0";
                }
                String stringBuffer = new StringBuffer(e6).reverse().toString();
                String a6 = a(string);
                if (TextUtils.isEmpty(a6)) {
                    return "";
                }
                return a6 + Logger.f33116c + stringBuffer;
            } catch (Throwable unused) {
                e.a();
                return "";
            }
        } catch (Exception unused2) {
            return "";
        }
    }

    public static String h(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
                return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
            }
            return displayMetrics.heightPixels + "*" + displayMetrics.widthPixels;
        } catch (Exception unused) {
            e.a();
            return "";
        }
    }

    public static String i(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? telephonyManager.getSubscriberId() : "";
        } catch (Throwable unused) {
            e.a();
            return "";
        }
    }

    public static String j(Context context) {
        String str = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "";
            }
            String simSerialNumber = telephonyManager.getSimSerialNumber();
            try {
                return TextUtils.isEmpty(simSerialNumber) ? "" : simSerialNumber;
            } catch (Throwable unused) {
                str = simSerialNumber;
                e.a();
                return str;
            }
        } catch (Throwable unused2) {
        }
    }

    public static String k(Context context) {
        String str = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "";
            }
            String simOperatorName = telephonyManager.getSimOperatorName();
            try {
                return TextUtils.isEmpty(simOperatorName) ? "" : simOperatorName;
            } catch (Throwable unused) {
                str = simOperatorName;
                e.a();
                return str;
            }
        } catch (Throwable unused2) {
        }
    }

    public static String l(Context context) {
        String str = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "";
            }
            String networkOperator = telephonyManager.getNetworkOperator();
            try {
                return TextUtils.isEmpty(networkOperator) ? "" : networkOperator;
            } catch (Throwable unused) {
                str = networkOperator;
                e.a();
                return str;
            }
        } catch (Throwable unused2) {
        }
    }

    public static String m(Context context) {
        String bssid;
        String str = "";
        try {
            bssid = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getBSSID();
        } catch (Throwable unused) {
        }
        try {
            return TextUtils.isEmpty(bssid) ? "" : bssid;
        } catch (Throwable unused2) {
            str = bssid;
            e.a();
            return str;
        }
    }

    private static String n(Context context) {
        String str;
        String str2 = "";
        try {
            str = e(context);
            try {
                str2 = f(context);
            } catch (Throwable unused) {
                e.a();
                return a((str + str2 + UUID.randomUUID().toString()).getBytes());
            }
        } catch (Throwable unused2) {
            str = "";
        }
        return a((str + str2 + UUID.randomUUID().toString()).getBytes());
    }

    public static String e(Context context) {
        TelephonyManager telephonyManager;
        if (!q.a(context) || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
            return "";
        }
        String deviceId = telephonyManager.getDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            return "";
        }
        return deviceId;
    }

    public static String f(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        return string;
    }

    private static String c() {
        FileReader fileReader;
        try {
            fileReader = new FileReader("/sys/class/net/eth0/address");
            try {
                String a6 = a(fileReader);
                try {
                    fileReader.close();
                    return a6;
                } catch (Throwable unused) {
                    e.a();
                    return a6;
                }
            } catch (Throwable unused2) {
                try {
                    e.a();
                    return "";
                } finally {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused3) {
                            e.a();
                        }
                    }
                }
            }
        } catch (Throwable unused4) {
            fileReader = null;
        }
    }

    private static String a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b6 : digest) {
                String upperCase = Integer.toHexString(b6 & 255).toUpperCase();
                if (upperCase.length() == 1) {
                    sb.append("0");
                }
                sb.append(upperCase);
                sb.append("");
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            e.a();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        if (r2 == null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String b() {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = "cat /sys/class/net/wlan0/address"
            java.lang.Process r2 = r2.exec(r3)     // Catch: java.lang.Throwable -> L3c
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3c
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L3c
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L3c
            java.io.LineNumberReader r2 = new java.io.LineNumberReader     // Catch: java.lang.Throwable -> L3a
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L3a
            r1 = r0
        L1c:
            if (r1 == 0) goto L2b
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L29
            if (r1 == 0) goto L1c
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L29
            goto L2b
        L29:
            r1 = r3
            goto L3d
        L2b:
            r3.close()     // Catch: java.lang.Throwable -> L2f
            goto L32
        L2f:
            com.baidu.liantian.b.e.a()
        L32:
            r2.close()     // Catch: java.io.IOException -> L36
            goto L4c
        L36:
            com.baidu.liantian.b.e.a()
            goto L4c
        L3a:
            r2 = r1
            goto L29
        L3c:
            r2 = r1
        L3d:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L49
            r1.close()     // Catch: java.lang.Throwable -> L46
            goto L49
        L46:
            com.baidu.liantian.b.e.a()
        L49:
            if (r2 == 0) goto L4c
            goto L32
        L4c:
            return r0
        L4d:
            r0 = move-exception
            if (r1 == 0) goto L57
            r1.close()     // Catch: java.lang.Throwable -> L54
            goto L57
        L54:
            com.baidu.liantian.b.e.a()
        L57:
            if (r2 == 0) goto L60
            r2.close()     // Catch: java.io.IOException -> L5d
            goto L60
        L5d:
            com.baidu.liantian.b.e.a()
        L60:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.b.g.b():java.lang.String");
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Environment.getExternalStorageDirectory(), "baidu/.cuid")));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append(org.apache.commons.net.g.f50795q);
            }
            bufferedReader.close();
            String[] split = new String(a.a("30212102dicudiab", "30212102dicudiab", Base64.decode(sb.toString().getBytes(), 0))).split(ContainerUtils.KEY_VALUE_DELIMITER);
            return (split != null && split.length == 2 && str.equals(split[0])) ? split[1] : "";
        } catch (Exception unused) {
            e.a();
            return "";
        }
    }

    public static String a() {
        String b6 = b();
        if (TextUtils.isEmpty(b6)) {
            try {
                return c().toUpperCase().substring(0, 17);
            } catch (Throwable unused) {
                e.a();
            }
        }
        return b6;
    }

    private static String a(Reader reader) {
        try {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[4096];
            int read = reader.read(cArr);
            while (read >= 0) {
                sb.append(cArr, 0, read);
                read = reader.read(cArr);
            }
            return sb.toString();
        } catch (Throwable unused) {
            e.a();
            return null;
        }
    }
}
