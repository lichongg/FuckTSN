package com.umeng.socialize.net.dplus.cache1;

import android.text.TextUtils;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DplueCache {
    private static JSONObject a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        return (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("content")) == null) ? new JSONObject() : optJSONObject.optJSONObject("share");
    }

    public static String getFileName() {
        return "dpluscache";
    }

    public static boolean deleteFile(File file) {
        return file.delete();
    }

    public static File getFilePath(String str) {
        if (ContextUtil.getContext() == null) {
            return null;
        }
        String packageName = ContextUtil.getContext().getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str2 = File.separator;
        sb.append(str2);
        sb.append("data");
        sb.append(str2);
        sb.append("data");
        sb.append(str2);
        sb.append(packageName);
        sb.append(str2);
        sb.append("files");
        sb.append(str2);
        sb.append(str);
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return null;
        }
        File file = new File(sb2);
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String readFile(java.io.File r5) {
        /*
            boolean r0 = r5.exists()
            java.lang.String r1 = ""
            if (r0 != 0) goto L9
            return r1
        L9:
            r0 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L47
            r2.<init>()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L47
            android.content.Context r3 = com.umeng.socialize.utils.ContextUtil.getContext()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L47
            java.lang.String r5 = r5.getName()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L47
            java.io.FileInputStream r5 = r3.openFileInput(r5)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L47
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L47
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L47
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L47
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L47
        L25:
            java.lang.String r0 = r5.readLine()     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            if (r0 == 0) goto L33
            r2.append(r0)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            goto L25
        L2f:
            r0 = move-exception
            goto L5d
        L31:
            r0 = move-exception
            goto L4b
        L33:
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r5.close()     // Catch: java.lang.Exception -> L3b
            return r0
        L3b:
            r5 = move-exception
            java.lang.String r1 = com.umeng.socialize.utils.UmengText.CACHE.CACHEFILE
            com.umeng.socialize.utils.SLog.error(r1, r5)
            return r0
        L42:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L5d
        L47:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
        L4b:
            java.lang.String r2 = com.umeng.socialize.utils.UmengText.CACHE.CACHEFILE     // Catch: java.lang.Throwable -> L2f
            com.umeng.socialize.utils.SLog.error(r2, r0)     // Catch: java.lang.Throwable -> L2f
            if (r5 == 0) goto L5c
            r5.close()     // Catch: java.lang.Exception -> L56
            goto L5c
        L56:
            r5 = move-exception
            java.lang.String r0 = com.umeng.socialize.utils.UmengText.CACHE.CACHEFILE
            com.umeng.socialize.utils.SLog.error(r0, r5)
        L5c:
            return r1
        L5d:
            if (r5 == 0) goto L69
            r5.close()     // Catch: java.lang.Exception -> L63
            goto L69
        L63:
            r5 = move-exception
            java.lang.String r1 = com.umeng.socialize.utils.UmengText.CACHE.CACHEFILE
            com.umeng.socialize.utils.SLog.error(r1, r5)
        L69:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.cache1.DplueCache.readFile(java.io.File):java.lang.String");
    }

    public static boolean save(JSONObject jSONObject, File file) throws JSONException, IOException {
        if (file.exists()) {
            return a(readFile(file) + "," + jSONObject, file);
        }
        file.createNewFile();
        return a(jSONObject.toString(), file);
    }

    private static boolean a(String str, File file) {
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(ContextUtil.getContext().openFileOutput(file.getName(), 0)));
                try {
                    bufferedWriter2.write(str);
                    try {
                        bufferedWriter2.close();
                        return true;
                    } catch (Exception e6) {
                        SLog.error(UmengText.CACHE.CLOSE, e6);
                        return true;
                    }
                } catch (Exception e7) {
                    e = e7;
                    bufferedWriter = bufferedWriter2;
                    SLog.error(UmengText.CACHE.CACHEFILE, e);
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (Exception e8) {
                            SLog.error(UmengText.CACHE.CLOSE, e8);
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (Exception e9) {
                            SLog.error(UmengText.CACHE.CLOSE, e9);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e10) {
            e = e10;
        }
    }
}
