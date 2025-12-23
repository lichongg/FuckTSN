package com.uyumao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.CellIdentity;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.jiguang.bz.b1;
import cn.jiguang.bz.g0;
import cn.jiguang.bz.h0;
import cn.jiguang.bz.o0;
import cn.jiguang.bz.y0;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.stub.StubApp;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static Context f42582a;

    /* renamed from: b, reason: collision with root package name */
    public static WeakReference<Future<?>> f42583b;

    /* renamed from: c, reason: collision with root package name */
    public static WeakReference<Future<?>> f42584c;

    public static Context a() {
        return f42582a;
    }

    public static Boolean b() {
        Boolean bool = Boolean.FALSE;
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.UMConfigure");
            Method declaredMethod = cls.getDeclaredMethod("isInForeground", null);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return (Boolean) declaredMethod.invoke(cls, null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return bool;
    }

    public static String[] c(Context context) {
        String[] strArr = {"", ""};
        if (context != null) {
            try {
                if (!a(context, com.kuaishou.weapon.p0.g.f36042b)) {
                    strArr[0] = "";
                    return strArr;
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    strArr[0] = "";
                    return strArr;
                }
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    strArr[0] = "Wi-Fi";
                    return strArr;
                }
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
                    strArr[0] = "mobile_network";
                    strArr[1] = networkInfo2.getSubtypeName();
                }
            } catch (Throwable unused) {
            }
        }
        return strArr;
    }

    public static JSONArray e(Context context) {
        WifiManager wifiManager;
        if (context == null || !h(context)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            WifiInfo connectionInfo = (!a(context, com.kuaishou.weapon.p0.g.f36044d) || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null) ? null : wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return null;
            }
            String bssid = connectionInfo.getBSSID();
            String replace = connectionInfo.getSSID().replace("\"", "");
            long currentTimeMillis = System.currentTimeMillis();
            jSONObject.put("bssid", bssid);
            jSONObject.put("ssid", replace);
            jSONObject.put("ts", currentTimeMillis);
            jSONArray.put(jSONObject);
            return jSONArray;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String[] g(Context context) {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        String[] strArr = {"", ""};
        try {
            if (a(context, com.kuaishou.weapon.p0.g.f36044d) && a(context, com.kuaishou.weapon.p0.g.f36048h) && a(context, com.kuaishou.weapon.p0.g.f36047g) && (wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi")) != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                String ssid = connectionInfo.getSSID();
                String bssid = connectionInfo.getBSSID();
                if (ssid.length() > 2 && ssid.charAt(0) == '\"' && ssid.charAt(ssid.length() - 1) == '\"') {
                    strArr[0] = ssid.substring(1, ssid.length() - 1);
                }
                if (bssid != null) {
                    strArr[1] = bssid;
                }
            }
            return strArr;
        } catch (Throwable th) {
            th.printStackTrace();
            return strArr;
        }
    }

    public static boolean h(Context context) {
        WifiManager wifiManager;
        if (context == null) {
            return false;
        }
        return 3 == ((!a(context, com.kuaishou.weapon.p0.g.f36044d) || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null) ? -1 : wifiManager.getWifiState());
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i6 = 0; i6 < bArr.length; i6++) {
                bArr[i6] = (byte) ((bArr[i6] ^ bArr2[i6 % bArr2.length]) ^ (i6 & 255));
            }
        }
        return bArr;
    }

    public static String d(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? telephonyManager.getNetworkOperatorName() : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    @SuppressLint({"MissingPermission"})
    public static JSONArray f(Context context) {
        List<ScanResult> scanResults;
        if (!h(context)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null && a(context, com.kuaishou.weapon.p0.g.f36044d) && a(context, com.kuaishou.weapon.p0.g.f36047g) && (scanResults = wifiManager.getScanResults()) != null) {
                int size = scanResults.size();
                if (size > 100) {
                    size = 100;
                }
                for (int i6 = 0; i6 < size; i6++) {
                    ScanResult scanResult = scanResults.get(i6);
                    if (scanResult != null) {
                        String str = scanResult.BSSID;
                        String str2 = scanResult.SSID;
                        String valueOf = String.valueOf(scanResult.level);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("bssid", str);
                        jSONObject.put("ssid", str2);
                        jSONObject.put("rssi", valueOf);
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static JSONObject a(JSONObject jSONObject, String str, String str2, boolean z5) throws Exception {
        SystemClock.elapsedRealtime();
        return new JSONObject(a(jSONObject.toString(), (HttpURLConnection) new URL(str).openConnection(), str2));
    }

    public static String b(File file) {
        FileInputStream fileInputStream;
        String str = "";
        if (!file.exists()) {
            return "";
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read));
                }
                str = sb.toString();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            fileInputStream = null;
        }
        a(fileInputStream);
        return str;
    }

    public static void a(byte[] bArr, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream;
        try {
            gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = gZIPInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    } else {
                        outputStream.write(bArr2, 0, read);
                    }
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            gZIPInputStream = null;
        }
        n.a(gZIPInputStream);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0039, code lost:
    
        if (r4.contains("network") != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject b(android.content.Context r13) {
        /*
            java.lang.String r0 = "network"
            java.lang.String r1 = "gps"
            r2 = 0
            if (r13 != 0) goto L8
            return r2
        L8:
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r4 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r4 = a(r13, r4)     // Catch: java.lang.Throwable -> L86
            if (r4 == 0) goto L86
            java.lang.String r4 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r4 = a(r13, r4)     // Catch: java.lang.Throwable -> L86
            if (r4 == 0) goto L86
            java.lang.String r4 = "location"
            java.lang.Object r13 = r13.getSystemService(r4)     // Catch: java.lang.Throwable -> L86
            android.location.LocationManager r13 = (android.location.LocationManager) r13     // Catch: java.lang.Throwable -> L86
            if (r13 != 0) goto L28
            return r2
        L28:
            r4 = 1
            java.util.List r4 = r13.getProviders(r4)     // Catch: java.lang.Throwable -> L86
            boolean r5 = r4.contains(r1)     // Catch: java.lang.Throwable -> L86
            if (r5 == 0) goto L35
            r0 = r1
            goto L3b
        L35:
            boolean r1 = r4.contains(r0)     // Catch: java.lang.Throwable -> L86
            if (r1 == 0) goto L86
        L3b:
            android.location.Location r13 = r13.getLastKnownLocation(r0)     // Catch: java.lang.Throwable -> L86
            if (r13 == 0) goto L86
            r13.getLatitude()     // Catch: java.lang.Throwable -> L86
            r13.getLongitude()     // Catch: java.lang.Throwable -> L86
            double r0 = r13.getLatitude()     // Catch: java.lang.Throwable -> L86
            double r4 = r13.getLongitude()     // Catch: java.lang.Throwable -> L86
            boolean r6 = r13.hasAltitude()     // Catch: java.lang.Throwable -> L86
            r7 = 0
            if (r6 == 0) goto L5c
            double r9 = r13.getAltitude()     // Catch: java.lang.Throwable -> L86
            goto L5d
        L5c:
            r9 = r7
        L5d:
            boolean r6 = r13.hasSpeed()     // Catch: java.lang.Throwable -> L86
            if (r6 == 0) goto L68
            float r6 = r13.getSpeed()     // Catch: java.lang.Throwable -> L86
            double r7 = (double) r6     // Catch: java.lang.Throwable -> L86
        L68:
            long r11 = r13.getTime()     // Catch: java.lang.Throwable -> L86
            java.lang.String r13 = "c_lat"
            r3.put(r13, r0)     // Catch: java.lang.Throwable -> L86
            java.lang.String r13 = "c_lng"
            r3.put(r13, r4)     // Catch: java.lang.Throwable -> L86
            java.lang.String r13 = "c_alt"
            r3.put(r13, r9)     // Catch: java.lang.Throwable -> L86
            java.lang.String r13 = "c_acc"
            r3.put(r13, r7)     // Catch: java.lang.Throwable -> L86
            java.lang.String r13 = "c_lts"
            r3.put(r13, r11)     // Catch: java.lang.Throwable -> L86
            return r3
        L86:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.e.b(android.content.Context):org.json.JSONObject");
    }

    public static boolean a(File file, byte[] bArr, boolean z5) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file, z5);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                a(fileOutputStream);
                return true;
            } catch (Throwable unused) {
                try {
                    file.getName();
                    a(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    a(fileOutputStream);
                    throw th;
                }
            }
        } catch (Throwable unused2) {
            fileOutputStream = null;
        }
    }

    public static String a(String str, HttpURLConnection httpURLConnection, String str2) throws Exception {
        GZIPOutputStream gZIPOutputStream;
        InputStream inputStream;
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes2 = str.getBytes();
        OutputStream outputStream = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bytes2);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            gZIPOutputStream = null;
        }
        n.a(gZIPOutputStream);
        byte[] a6 = a(byteArrayOutputStream.toByteArray(), bytes);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setReadTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
        httpURLConnection.setConnectTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
        httpURLConnection.addRequestProperty("Content-Type", "application/octet-stream");
        httpURLConnection.addRequestProperty("Content-Encoding", "xgzip");
        httpURLConnection.addRequestProperty("appkey", str2);
        httpURLConnection.setFixedLengthStreamingMode(a6.length);
        httpURLConnection.setDoOutput(true);
        try {
            outputStream = httpURLConnection.getOutputStream();
            outputStream.write(a6);
            n.a(outputStream);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 400) {
                inputStream = httpURLConnection.getInputStream();
            } else {
                inputStream = httpURLConnection.getErrorStream();
            }
            byteArrayOutputStream.reset();
            if (inputStream != null) {
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } finally {
                    }
                }
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused3) {
            }
            if (responseCode == 200 && TextUtils.equals("xgzip", httpURLConnection.getHeaderField("Content-Encoding"))) {
                byte[] a7 = a(byteArrayOutputStream.toByteArray(), bytes);
                byteArrayOutputStream.reset();
                a(a7, byteArrayOutputStream);
            }
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            if (responseCode == 200) {
                return byteArrayOutputStream2;
            }
            throw new IOException("code:" + responseCode + " msg:" + byteArrayOutputStream2);
        } finally {
        }
    }

    public static JSONArray a(Context context) {
        JSONArray jSONArray;
        String substring;
        String valueOf;
        String substring2;
        String valueOf2;
        String substring3;
        String valueOf3;
        CellIdentityTdscdma cellIdentity;
        int cid;
        int lac;
        String mncString;
        String mccString;
        CellIdentity cellIdentity2;
        int pci;
        long nci;
        int tac;
        String mncString2;
        String mccString2;
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = null;
        if (context == null) {
            return null;
        }
        try {
            if (a(context, com.kuaishou.weapon.p0.g.f36047g)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                String networkOperator = telephonyManager.getNetworkOperator();
                if (!TextUtils.isEmpty(networkOperator)) {
                    try {
                        networkOperator.substring(0, 3);
                        networkOperator.substring(3);
                    } catch (Throwable unused) {
                    }
                }
                List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                if (allCellInfo != null) {
                    for (CellInfo cellInfo : allCellInfo) {
                        if (cellInfo.isRegistered()) {
                            int i6 = Build.VERSION.SDK_INT;
                            if (i6 >= 29) {
                                if (o0.a(cellInfo)) {
                                    JSONObject jSONObject = new JSONObject();
                                    cellIdentity2 = y0.a(cellInfo).getCellIdentity();
                                    CellIdentityNr a6 = b1.a(cellIdentity2);
                                    pci = a6.getPci();
                                    nci = a6.getNci();
                                    tac = a6.getTac();
                                    mncString2 = a6.getMncString();
                                    mccString2 = a6.getMccString();
                                    jSONArray = jSONArray3;
                                    try {
                                        jSONObject.put("nt", "Nr");
                                        jSONObject.put("pci", pci);
                                        jSONObject.put("nci", nci);
                                        jSONObject.put("tac", tac);
                                        jSONObject.put("mnc", mncString2);
                                        jSONObject.put("mcc", mccString2);
                                        jSONObject.put("ts", System.currentTimeMillis());
                                        jSONArray2.put(jSONObject);
                                    } catch (Throwable unused2) {
                                        return jSONArray;
                                    }
                                } else {
                                    jSONArray = jSONArray3;
                                    if (g0.a(cellInfo)) {
                                        JSONObject jSONObject2 = new JSONObject();
                                        cellIdentity = h0.a(cellInfo).getCellIdentity();
                                        cid = cellIdentity.getCid();
                                        lac = cellIdentity.getLac();
                                        mncString = cellIdentity.getMncString();
                                        mccString = cellIdentity.getMccString();
                                        jSONObject2.put("nt", "Tdscdma");
                                        jSONObject2.put("cid", cid);
                                        jSONObject2.put("lac", lac);
                                        jSONObject2.put("mnc", mncString);
                                        jSONObject2.put("mcc", mccString);
                                        jSONObject2.put("ts", System.currentTimeMillis());
                                        jSONArray2.put(jSONObject2);
                                    }
                                }
                                jSONArray3 = jSONArray;
                            } else {
                                jSONArray = jSONArray3;
                            }
                            if (cellInfo instanceof CellInfoLte) {
                                JSONObject jSONObject3 = new JSONObject();
                                CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
                                int pci2 = cellIdentity3.getPci();
                                int tac2 = cellIdentity3.getTac();
                                if (i6 >= 28) {
                                    substring3 = cellIdentity3.getMncString();
                                    valueOf3 = cellIdentity3.getMccString();
                                } else {
                                    substring3 = ("00" + String.valueOf(cellIdentity3.getMnc())).substring(r4.length() - 2);
                                    valueOf3 = String.valueOf(cellIdentity3.getMcc());
                                }
                                jSONObject3.put("nt", "Lte");
                                jSONObject3.put("pci", pci2);
                                jSONObject3.put("tac", tac2);
                                jSONObject3.put("mnc", substring3);
                                jSONObject3.put("mcc", valueOf3);
                                jSONObject3.put("ts", System.currentTimeMillis());
                                jSONArray2.put(jSONObject3);
                            } else if (cellInfo instanceof CellInfoWcdma) {
                                JSONObject jSONObject4 = new JSONObject();
                                CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                                int cid2 = cellIdentity4.getCid();
                                int lac2 = cellIdentity4.getLac();
                                if (i6 >= 28) {
                                    substring2 = cellIdentity4.getMncString();
                                    valueOf2 = cellIdentity4.getMccString();
                                } else {
                                    substring2 = ("00" + String.valueOf(cellIdentity4.getMnc())).substring(r4.length() - 2);
                                    valueOf2 = String.valueOf(cellIdentity4.getMcc());
                                }
                                jSONObject4.put("nt", "Wcdma");
                                jSONObject4.put("cid", cid2);
                                jSONObject4.put("lac", lac2);
                                jSONObject4.put("mnc", substring2);
                                jSONObject4.put("mcc", valueOf2);
                                jSONObject4.put("ts", System.currentTimeMillis());
                                jSONArray2.put(jSONObject4);
                            } else if (cellInfo instanceof CellInfoCdma) {
                                JSONObject jSONObject5 = new JSONObject();
                                CellIdentityCdma cellIdentity5 = ((CellInfoCdma) cellInfo).getCellIdentity();
                                int basestationId = cellIdentity5.getBasestationId();
                                int networkId = cellIdentity5.getNetworkId();
                                int systemId = cellIdentity5.getSystemId();
                                jSONObject5.put("nt", "Cdma");
                                jSONObject5.put("bid", basestationId);
                                jSONObject5.put("nid", networkId);
                                jSONObject5.put(SocializeProtocolConstants.PROTOCOL_KEY_SID, systemId);
                                jSONObject5.put("mnc", "03");
                                jSONObject5.put("mcc", "460");
                                jSONObject5.put("ts", System.currentTimeMillis());
                                jSONArray2.put(jSONObject5);
                            } else if (cellInfo instanceof CellInfoGsm) {
                                JSONObject jSONObject6 = new JSONObject();
                                CellIdentityGsm cellIdentity6 = ((CellInfoGsm) cellInfo).getCellIdentity();
                                int cid3 = cellIdentity6.getCid();
                                int lac3 = cellIdentity6.getLac();
                                if (i6 >= 28) {
                                    substring = cellIdentity6.getMncString();
                                    valueOf = cellIdentity6.getMccString();
                                } else {
                                    substring = ("00" + String.valueOf(cellIdentity6.getMnc())).substring(r4.length() - 2);
                                    valueOf = String.valueOf(cellIdentity6.getMcc());
                                }
                                jSONObject6.put("nt", "Gsm");
                                jSONObject6.put("cid", cid3);
                                jSONObject6.put("lac", lac3);
                                jSONObject6.put("mnc", substring);
                                jSONObject6.put("mcc", valueOf);
                                jSONObject6.put("ts", System.currentTimeMillis());
                                jSONArray2.put(jSONObject6);
                            }
                            jSONArray3 = jSONArray;
                        }
                    }
                }
            }
            return jSONArray2;
        } catch (Throwable unused3) {
            return jSONArray3;
        }
    }

    public static void a(JSONObject jSONObject, String str, String str2) throws Exception {
        GZIPOutputStream gZIPOutputStream;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        boolean z5;
        String jSONObject2 = jSONObject.toString();
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes2 = jSONObject2.getBytes();
        InputStream inputStream = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bytes2);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            gZIPOutputStream = null;
        }
        n.a(gZIPOutputStream);
        byte[] a6 = a(byteArrayOutputStream.toByteArray(), bytes);
        SystemClock.elapsedRealtime();
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setConnectTimeout(60000);
                httpURLConnection.addRequestProperty("Content-Type", "application/octet-stream");
                httpURLConnection.addRequestProperty("appkey", str2);
                if (TextUtils.isEmpty(jSONObject.optString("uuid"))) {
                    z5 = true;
                } else {
                    httpURLConnection.addRequestProperty("Rich-Resp-Code", "1");
                    z5 = false;
                }
                httpURLConnection.setFixedLengthStreamingMode(a6.length);
                httpURLConnection.setDoOutput(true);
                outputStream = httpURLConnection.getOutputStream();
                try {
                    outputStream.write(a6);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode < 400) {
                        inputStream = httpURLConnection.getInputStream();
                    } else {
                        inputStream = httpURLConnection.getErrorStream();
                    }
                    byteArrayOutputStream.reset();
                    if (inputStream != null) {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                        }
                    }
                    n.a(outputStream);
                    n.a(inputStream);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused3) {
                    }
                    if (responseCode == 200) {
                        byte[] a7 = a(byteArrayOutputStream.toByteArray(), bytes);
                        byteArrayOutputStream.reset();
                        if (z5) {
                            a(a7, byteArrayOutputStream);
                            byteArrayOutputStream.toString();
                        } else {
                            new String(a7);
                        }
                    }
                    if (responseCode == 200) {
                        return;
                    }
                    throw new Exception("response code " + responseCode);
                } catch (Throwable th) {
                    th = th;
                    n.a(outputStream);
                    n.a(inputStream);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            outputStream = null;
        }
    }

    public static void a(File file) {
        File[] listFiles;
        if (file != null) {
            try {
                if (file.exists()) {
                    if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                        for (File file2 : listFiles) {
                            a(file2);
                        }
                    }
                    file.delete();
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    public static String a(NetworkInfo networkInfo) {
        int subtype;
        try {
            subtype = networkInfo.getSubtype();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
        if (subtype != 20) {
            switch (subtype) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3G";
                case 13:
                    return "4G";
                default:
                    String subtypeName = networkInfo.getSubtypeName();
                    if (TextUtils.isEmpty(subtypeName)) {
                        return "";
                    }
                    if (!"TD-SCDMA".equalsIgnoreCase(subtypeName) && !"WCDMA".equalsIgnoreCase(subtypeName)) {
                        if (!"CDMA2000".equalsIgnoreCase(subtypeName)) {
                            return subtypeName;
                        }
                    }
                    return "3G";
            }
            th.printStackTrace();
            return "";
        }
        return "5G";
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(Context context, String str) {
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static JSONArray a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            try {
                if (jSONObject == 0 || jSONObject2 == null) {
                    if (jSONObject != 0) {
                        JSONArray jSONArray = new JSONArray();
                        try {
                            jSONArray.put(jSONObject);
                            return jSONArray;
                        } catch (Throwable unused) {
                            return jSONArray;
                        }
                    }
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(jSONObject2);
                    return jSONArray2;
                }
                JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
                if (jSONObject2.length() > 0) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject3.put(next, jSONObject2.get(next));
                    }
                }
                JSONArray jSONArray3 = new JSONArray();
                jSONArray3.put(jSONObject3);
                return jSONArray3;
            } catch (Throwable unused2) {
                return null;
            }
        } catch (Throwable unused3) {
            return jSONObject;
        }
    }
}
