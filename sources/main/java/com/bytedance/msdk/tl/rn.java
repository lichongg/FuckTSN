package com.bytedance.msdk.tl;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class rn {
    private static String cw = null;

    /* renamed from: j, reason: collision with root package name */
    private static String f25233j = null;

    /* renamed from: r, reason: collision with root package name */
    private static String f25234r = "ToolUtils";
    private static String xt;

    public static synchronized String cw() {
        String str;
        synchronized (rn.class) {
            try {
                if (TextUtils.isEmpty(cw) && com.bytedance.msdk.core.xt.getContext() != null) {
                    try {
                        PackageInfo packageInfo = com.bytedance.msdk.core.xt.getContext().getPackageManager().getPackageInfo(j(), 0);
                        xt = String.valueOf(packageInfo.versionCode);
                        cw = packageInfo.versionName;
                    } catch (Throwable th) {
                        com.bytedance.msdk.j.up.cw.r(f25234r, "ToolUtils getVersionName throws exception :" + th);
                    }
                }
                str = cw;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return str;
    }

    public static synchronized String j() {
        String str;
        synchronized (rn.class) {
            try {
                if (TextUtils.isEmpty(f25233j) && com.bytedance.msdk.core.xt.getContext() != null) {
                    try {
                        f25233j = com.bytedance.msdk.core.xt.getContext().getPackageName();
                    } catch (Throwable th) {
                        com.bytedance.msdk.j.up.cw.r(f25234r, "ToolUtils getPackageName throws exception :" + th);
                    }
                }
                str = f25233j;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return str;
    }

    public static String r() {
        String str;
        try {
            str = System.getProperty("http.agent");
        } catch (Exception unused) {
            str = "unKnow";
        }
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(";");
        if (lastIndexOf != -1 && str.length() > lastIndexOf) {
            int i6 = lastIndexOf + 1;
            String substring = str.substring(0, i6);
            str = substring.concat(" " + Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry() + ";").concat(str.substring(i6));
        }
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            char charAt = str.charAt(i7);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static synchronized String xt() {
        String str;
        synchronized (rn.class) {
            try {
                if (TextUtils.isEmpty(xt) && com.bytedance.msdk.core.xt.getContext() != null) {
                    try {
                        PackageInfo packageInfo = com.bytedance.msdk.core.xt.getContext().getPackageManager().getPackageInfo(j(), 0);
                        xt = String.valueOf(packageInfo.versionCode);
                        cw = packageInfo.versionName;
                    } catch (Throwable th) {
                        com.bytedance.msdk.j.up.cw.r(f25234r, "ToolUtils getVersionCode throws exception :" + th);
                    }
                }
                str = xt;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return str;
    }

    public static String up() {
        try {
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            return jy.j(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String j(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 17) {
            return str;
        }
        return j.xt(str.substring(17), cw(str.substring(1, 17)));
    }

    public static boolean j(com.bytedance.sdk.component.g.xt xtVar) {
        if (xtVar == null || !com.bytedance.sdk.component.g.r.j.j(xtVar.cw())) {
            return (xtVar == null || xtVar.r() == null || xtVar.r().startsWith("{") || xtVar.r().endsWith("}")) ? false : true;
        }
        return true;
    }

    private static String cw(String str) {
        String j6 = j.j(str);
        if (str != null) {
            return j6;
        }
        String j7 = xt.j();
        return j7.concat(j7).substring(8, 24);
    }

    public static byte[] xt(String str) {
        return com.bytedance.sdk.component.panglearmor.g.j().j(r(str));
    }

    public static String j(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    String xt2 = com.bytedance.sdk.openadsdk.core.rn.vl.xt(com.bytedance.sdk.component.panglearmor.g.j().xt(bArr));
                    if (TextUtils.isEmpty(xt2)) {
                        return null;
                    }
                    return xt2;
                }
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
        }
        return null;
    }

    public static JSONObject j(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                try {
                    String j6 = j.j();
                    String str = "2" + j6 + j.j(jSONObject.toString(), j.j(j6));
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject2.put(CrashHianalyticsData.MESSAGE, str);
                        jSONObject2.put("cypher", 2);
                        return jSONObject2;
                    }
                    jSONObject2.put(CrashHianalyticsData.MESSAGE, jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                    return jSONObject2;
                } catch (Throwable unused) {
                    jSONObject2.put(CrashHianalyticsData.MESSAGE, jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused2) {
            }
        }
        return jSONObject2;
    }

    private static byte[] r(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                try {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream2.write(str.getBytes());
                        gZIPOutputStream2.close();
                    } catch (Exception e6) {
                        e = e6;
                        gZIPOutputStream = gZIPOutputStream2;
                        com.bytedance.sdk.component.utils.vl.j(e);
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream = gZIPOutputStream2;
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (IOException e7) {
                                com.bytedance.sdk.component.utils.vl.j(e7);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e8) {
                    e = e8;
                }
            } catch (IOException e9) {
                com.bytedance.sdk.component.utils.vl.j(e9);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
