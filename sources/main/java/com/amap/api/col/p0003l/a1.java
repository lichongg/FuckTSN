package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a1 {
    public static boolean l(File file) throws IOException, Exception {
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i6 = 0; i6 < listFiles.length; i6++) {
                if (listFiles[i6].isFile()) {
                    if (!listFiles[i6].delete()) {
                        return false;
                    }
                } else if (!l(listFiles[i6])) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    private static OfflineMapProvince c(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        OfflineMapProvince offlineMapProvince = new OfflineMapProvince();
        offlineMapProvince.setUrl(e(jSONObject, "url"));
        offlineMapProvince.setProvinceName(e(jSONObject, CommonNetImpl.NAME));
        offlineMapProvince.setJianpin(e(jSONObject, "jianpin"));
        offlineMapProvince.setPinyin(e(jSONObject, "pinyin"));
        offlineMapProvince.setProvinceCode(o(e(jSONObject, "adcode")));
        offlineMapProvince.setVersion(e(jSONObject, "version"));
        offlineMapProvince.setSize(Long.parseLong(e(jSONObject, "size")));
        offlineMapProvince.setCityList(j(jSONObject));
        return offlineMapProvince;
    }

    private static String e(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject == null || !jSONObject.has(str) || "[]".equals(jSONObject.getString(str))) ? "" : jSONObject.optString(str).trim();
    }

    public static List<OfflineMapProvince> f(String str, Context context) throws JSONException {
        return (str == null || "".equals(str)) ? new ArrayList() : g(new JSONObject(str), context);
    }

    public static List<OfflineMapProvince> g(JSONObject jSONObject, Context context) throws JSONException {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("result")) {
            optJSONObject = jSONObject.optJSONObject("result");
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", new JSONObject().put("offlinemap_with_province_vfour", jSONObject));
                p(jSONObject2.toString(), context);
                optJSONObject = jSONObject2.optJSONObject("result");
            } catch (JSONException e6) {
                JSONObject optJSONObject3 = jSONObject.optJSONObject("result");
                v5.p(e6, "Utility", "parseJson");
                e6.printStackTrace();
                optJSONObject = optJSONObject3;
            }
        }
        if (optJSONObject != null) {
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("offlinemap_with_province_vfour");
            if (optJSONObject4 != null) {
                optJSONObject2 = optJSONObject4.optJSONObject("offlinemapinfo_with_province");
            }
            return arrayList;
        }
        optJSONObject2 = jSONObject.optJSONObject("offlinemapinfo_with_province");
        if (optJSONObject2 != null) {
            if (optJSONObject2.has("version")) {
                c0.f5774r = e(optJSONObject2, "version");
            }
            JSONArray optJSONArray = optJSONObject2.optJSONArray("provinces");
            if (optJSONArray != null) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    JSONObject optJSONObject5 = optJSONArray.optJSONObject(i6);
                    if (optJSONObject5 != null) {
                        arrayList.add(c(optJSONObject5));
                    }
                }
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("others");
                JSONObject jSONObject3 = (optJSONArray2 == null || optJSONArray2.length() <= 0) ? null : optJSONArray2.getJSONObject(0);
                if (jSONObject3 != null) {
                    arrayList.add(c(jSONObject3));
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public static void h(String str) {
        File[] listFiles;
        File file = new File(str);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.exists() && file2.isDirectory()) {
                    String[] list = file2.list();
                    if (list == null) {
                        file2.delete();
                    } else if (list.length == 0) {
                        file2.delete();
                    }
                }
            }
        }
    }

    private static ArrayList<OfflineMapCity> j(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("cities");
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        if (optJSONArray != null) {
            if (optJSONArray.length() == 0) {
                arrayList.add(m(jSONObject));
            }
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    arrayList.add(m(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    public static void k(String str, Context context) throws IOException, Exception {
        File[] listFiles = new File(b3.f0(context)).listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.exists() && file.getName().contains(str)) {
                l(file);
            }
        }
        h(b3.f0(context));
    }

    private static OfflineMapCity m(JSONObject jSONObject) throws JSONException {
        OfflineMapCity offlineMapCity = new OfflineMapCity();
        offlineMapCity.setAdcode(o(e(jSONObject, "adcode")));
        offlineMapCity.setUrl(e(jSONObject, "url"));
        offlineMapCity.setCity(e(jSONObject, CommonNetImpl.NAME));
        offlineMapCity.setCode(e(jSONObject, "citycode"));
        offlineMapCity.setPinyin(e(jSONObject, "pinyin"));
        offlineMapCity.setJianpin(e(jSONObject, "jianpin"));
        offlineMapCity.setVersion(e(jSONObject, "version"));
        offlineMapCity.setSize(Long.parseLong(e(jSONObject, "size")));
        return offlineMapCity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0082, code lost:
    
        if (r3 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006b, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006c, code lost:
    
        r6.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0065, code lost:
    
        if (r3 == null) goto L55;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String n(java.io.File r6) {
        /*
            java.lang.String r0 = "MapDownloadManager"
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4b java.io.FileNotFoundException -> L4f
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4b java.io.FileNotFoundException -> L4f
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 java.io.FileNotFoundException -> L45
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 java.io.FileNotFoundException -> L45
            java.lang.String r5 = "utf-8"
            r4.<init>(r3, r5)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 java.io.FileNotFoundException -> L45
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42 java.io.FileNotFoundException -> L45
        L19:
            java.lang.String r4 = r6.readLine()     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L27 java.io.FileNotFoundException -> L29
            if (r4 == 0) goto L2b
            r1.append(r4)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L27 java.io.FileNotFoundException -> L29
            goto L19
        L23:
            r0 = move-exception
            r2 = r6
            goto L86
        L27:
            r1 = move-exception
            goto L53
        L29:
            r1 = move-exception
            goto L70
        L2b:
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L27 java.io.FileNotFoundException -> L29
            r6.close()     // Catch: java.io.IOException -> L33
            goto L37
        L33:
            r6 = move-exception
            r6.printStackTrace()
        L37:
            r3.close()     // Catch: java.io.IOException -> L3b
            goto L3f
        L3b:
            r6 = move-exception
            r6.printStackTrace()
        L3f:
            return r0
        L40:
            r0 = move-exception
            goto L86
        L42:
            r1 = move-exception
            r6 = r2
            goto L53
        L45:
            r1 = move-exception
            r6 = r2
            goto L70
        L48:
            r0 = move-exception
            r3 = r2
            goto L86
        L4b:
            r1 = move-exception
            r6 = r2
            r3 = r6
            goto L53
        L4f:
            r1 = move-exception
            r6 = r2
            r3 = r6
            goto L70
        L53:
            java.lang.String r4 = "readOfflineSD io"
            com.amap.api.col.p0003l.v5.p(r1, r0, r4)     // Catch: java.lang.Throwable -> L23
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L23
            if (r6 == 0) goto L65
            r6.close()     // Catch: java.io.IOException -> L61
            goto L65
        L61:
            r6 = move-exception
            r6.printStackTrace()
        L65:
            if (r3 == 0) goto L85
        L67:
            r3.close()     // Catch: java.io.IOException -> L6b
            goto L85
        L6b:
            r6 = move-exception
            r6.printStackTrace()
            goto L85
        L70:
            java.lang.String r4 = "readOfflineSD filenotfound"
            com.amap.api.col.p0003l.v5.p(r1, r0, r4)     // Catch: java.lang.Throwable -> L23
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L23
            if (r6 == 0) goto L82
            r6.close()     // Catch: java.io.IOException -> L7e
            goto L82
        L7e:
            r6 = move-exception
            r6.printStackTrace()
        L82:
            if (r3 == 0) goto L85
            goto L67
        L85:
            return r2
        L86:
            if (r2 == 0) goto L90
            r2.close()     // Catch: java.io.IOException -> L8c
            goto L90
        L8c:
            r6 = move-exception
            r6.printStackTrace()
        L90:
            if (r3 == 0) goto L9a
            r3.close()     // Catch: java.io.IOException -> L96
            goto L9a
        L96:
            r6 = move-exception
            r6.printStackTrace()
        L9a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.a1.n(java.io.File):java.lang.String");
    }

    private static String o(String str) {
        return "000001".equals(str) ? "100000" : str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0085, code lost:
    
        if (r7 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
    
        r7.close();
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0077, code lost:
    
        if (r7 == null) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v18, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void p(java.lang.String r6, android.content.Context r7) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = com.amap.api.col.p0003l.b3.f0(r7)
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Le
            goto L93
        Le:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r7 = com.amap.api.col.p0003l.b3.f0(r7)
            r1.append(r7)
            java.lang.String r7 = "offlinemapv4.png"
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            boolean r7 = r0.exists()
            java.lang.String r1 = "OfflineUpdateCityHandlerAbstract"
            if (r7 != 0) goto L3d
            r0.createNewFile()     // Catch: java.io.IOException -> L34
            goto L3d
        L34:
            r7 = move-exception
            java.lang.String r2 = "writeSD dirCreate"
            com.amap.api.col.p0003l.v5.p(r7, r1, r2)
            r7.printStackTrace()
        L3d:
            long r2 = a()
            r4 = 1048576(0x100000, double:5.180654E-318)
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 <= 0) goto L93
            r7 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L6b java.io.FileNotFoundException -> L6d
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L6b java.io.FileNotFoundException -> L6d
            java.lang.String r7 = "utf-8"
            byte[] r6 = r6.getBytes(r7)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L63 java.io.FileNotFoundException -> L66
            r2.write(r6)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L63 java.io.FileNotFoundException -> L66
            r2.close()     // Catch: java.io.IOException -> L5b
            goto L93
        L5b:
            r6 = move-exception
            r6.printStackTrace()
            return
        L60:
            r6 = move-exception
            r7 = r2
            goto L88
        L63:
            r6 = move-exception
            r7 = r2
            goto L6f
        L66:
            r6 = move-exception
            r7 = r2
            goto L7d
        L69:
            r6 = move-exception
            goto L88
        L6b:
            r6 = move-exception
            goto L6f
        L6d:
            r6 = move-exception
            goto L7d
        L6f:
            java.lang.String r0 = "writeSD io"
            com.amap.api.col.p0003l.v5.p(r6, r1, r0)     // Catch: java.lang.Throwable -> L69
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L69
            if (r7 == 0) goto L93
        L79:
            r7.close()     // Catch: java.io.IOException -> L5b
            goto L93
        L7d:
            java.lang.String r0 = "writeSD filenotfound"
            com.amap.api.col.p0003l.v5.p(r6, r1, r0)     // Catch: java.lang.Throwable -> L69
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L69
            if (r7 == 0) goto L93
            goto L79
        L88:
            if (r7 == 0) goto L92
            r7.close()     // Catch: java.io.IOException -> L8e
            goto L92
        L8e:
            r7 = move-exception
            r7.printStackTrace()
        L92:
            throw r6
        L93:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.a1.p(java.lang.String, android.content.Context):void");
    }

    public static long a() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getFreeBlocks() * statFs.getBlockSize();
        }
        return 0L;
    }

    public static long b(File file) {
        long length;
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j6 = 0;
        if (listFiles == null) {
            return 0L;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                length = b(file2);
            } else {
                length = file2.length();
            }
            j6 += length;
        }
        return j6;
    }

    public static String d(Context context, String str) {
        try {
            return b3.x(new GZIPInputStream(v2.b(context).open(str)));
        } catch (Throwable th) {
            v5.p(th, "MapDownloadManager", "readOfflineAsset");
            th.printStackTrace();
            return null;
        }
    }

    public static String i(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return str.substring(str.lastIndexOf("/") + 1, str.indexOf(".zip"));
            }
            return null;
        } catch (Throwable th) {
            v5.p(th, "Utility", "getZipFileNameFromUrl");
            return null;
        }
    }
}
