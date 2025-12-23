package com.qihoo.jiagu;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import com.baidu.mobads.sdk.internal.by;
import com.qihoo.bugreport.Protocol;
import com.qihoo.bugreport.javacrash.ReportField;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.EnumMap;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes10.dex */
public class c {
    public static JSONObject a(EnumMap<ReportField, String> enumMap, String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("mpv")) {
                try {
                    jSONObject.accumulate("mpv", 1);
                } catch (JSONException e6) {
                }
            }
            for (ReportField reportField : enumMap.keySet()) {
                try {
                    if (reportField.name().equals(ReportField.t.name()) || reportField.name().equals(ReportField.cpv.name()) || reportField.name().equals(ReportField.jc.name())) {
                        String str2 = enumMap.get(reportField);
                        jSONObject.accumulate(reportField.name(), Pattern.compile("[0-9]*").matcher(str2).matches() ? Integer.valueOf(Integer.parseInt(str2)) : "");
                    } else {
                        jSONObject.accumulate(reportField.name(), enumMap.get(reportField));
                    }
                } catch (JSONException e7) {
                }
            }
            JSONArray a6 = a();
            if (a6 != null) {
                try {
                    jSONObject.accumulate(ReportField.rt.name(), a6);
                } catch (JSONException e8) {
                }
            }
            return jSONObject;
        } catch (JSONException e9) {
            return null;
        }
    }

    static JSONArray a() {
        JSONArray jSONArray = new JSONArray();
        try {
            for (String str : (String[]) Class.forName("com.qihoo.jiagutracker.TrackDataManager").getDeclaredMethod("getTrackData", new Class[0]).invoke(null, new Object[0])) {
                String[] split = str.split("->");
                if (Protocol.TrackerDataField.values().length != split.length) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.accumulate(Protocol.TrackerDataField.cn.name(), split[0]);
                jSONObject.accumulate(Protocol.TrackerDataField.mn.name(), split[1]);
                jSONObject.accumulate(Protocol.TrackerDataField.vi.name(), split[2]);
                jSONObject.accumulate(Protocol.TrackerDataField.vt.name(), split[3]);
                jSONObject.accumulate(Protocol.TrackerDataField.st.name(), split[4]);
                jSONArray.put(jSONObject);
            }
        } catch (Throwable th) {
        }
        return jSONArray;
    }

    public static String a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b6 : digest) {
                if ((b6 & 255) < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b6 & 255));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e6) {
            return null;
        }
    }

    public static boolean a(Context context, String str) {
        if (context == null || str.isEmpty()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return b(context, str);
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        try {
            return packageManager.checkPermission(str, context.getPackageName()) == 0;
        } catch (RuntimeException e6) {
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        boolean z5;
        if (context == null || str.isEmpty()) {
            return false;
        }
        try {
            int i6 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
            if (i6 >= 23) {
                z5 = ContextCompat.checkSelfPermission(context, str) == 0;
                new StringBuilder("targetSdkVersion01:").append(i6);
            } else {
                z5 = PermissionChecker.checkSelfPermission(context, str) == 0;
                new StringBuilder("targetSdkVersion02:").append(i6);
            }
            return z5;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean c(Context context, String str) {
        try {
            ZipFile zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
            if (zipFile.getEntry("META-INF/" + str) != null) {
                zipFile.close();
                return true;
            }
            try {
                zipFile.close();
                return false;
            } catch (Exception e6) {
                return false;
            }
        } catch (Exception e7) {
            return false;
        }
    }
}
