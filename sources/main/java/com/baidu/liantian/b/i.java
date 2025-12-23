package com.baidu.liantian.b;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.liantian.core.ApkInfo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f10355a = {"java.lang.UnsatisfiedLinkError"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f10356b = {"space left"};

    public static String a(Context context, String str, String str2) {
        try {
            if (!str.contains(f10355a[0])) {
                return str.contains(f10356b[0]) ? a(context, str) : str;
            }
            ApkInfo d6 = com.baidu.liantian.core.g.a().d(str2);
            String str3 = d6.libPath;
            String str4 = str + "\r\n{libpath=" + d6.libPath + "}";
            for (String str5 : str3.split(":")) {
                if (str5.startsWith("/data/data/")) {
                    File file = new File(str5);
                    if (!file.exists()) {
                        str4 = str4 + "\r\nsubLibPathFile " + str5 + " not exists";
                    } else if (file.isDirectory()) {
                        for (File file2 : file.listFiles()) {
                            str4 = str4 + "\r\n{" + file2.getAbsolutePath() + ":" + o.a(file2) + "}\r\n";
                        }
                    } else {
                        str4 = str4 + "\r\nsubLibPathFile " + str5 + " not a dir";
                    }
                }
            }
            return str4;
        } catch (Throwable unused) {
            e.a();
            return str;
        }
    }

    @SuppressLint({"NewApi"})
    private static String a(Context context, String str) {
        try {
            File filesDir = context.getFilesDir();
            long freeSpace = filesDir.getFreeSpace();
            String str2 = ((str + "\r\nFreeSpace=" + freeSpace) + "  TotalSpace=" + filesDir.getTotalSpace()) + "  UsableSpace=" + filesDir.getUsableSpace();
            JSONArray jSONArray = new JSONArray();
            long j6 = 0;
            for (File file : filesDir.listFiles()) {
                if (file.isDirectory() && file.getName().startsWith(".")) {
                    j6 += a(file, jSONArray);
                }
            }
            return ((str2 + org.apache.commons.net.g.f50795q) + jSONArray.toString()) + "\r\nAllFileSize=" + j6;
        } catch (Throwable unused) {
            return str;
        }
    }

    private static long a(File file, JSONArray jSONArray) {
        long length;
        long j6 = 0;
        if (file != null && jSONArray != null && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    length = a(file2, jSONArray);
                } else if (file2.exists()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("path", file2.getAbsolutePath());
                    jSONObject.put("size", file2.length());
                    jSONArray.put(jSONObject);
                    length = file2.length();
                }
                j6 += length;
            }
        }
        return j6;
    }
}
