package com.bytedance.j.xt.tl;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.vl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class k {
    public static String c(File file, String str, String str2, JSONObject jSONObject, boolean z5) {
        return b(file, str, str2, jSONObject, null, z5);
    }

    public static String i(String str) throws IOException {
        return d(str, null);
    }

    public static void e(Context context, String str, String str2) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            sb.append(" ");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            sb.append(" ");
            if (str2 == null) {
                str2 = "null";
            }
            sb.append(str2);
            sb.append(com.snail.antifake.deviceid.e.f37542d);
            f(l.d(context), sb.toString(), true);
        } catch (IOException e6) {
            vl.j(e6);
        }
    }

    public static com.bytedance.j.xt.cw.a a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(i(str));
            com.bytedance.j.xt.cw.a aVar = new com.bytedance.j.xt.cw.a();
            aVar.c(jSONObject.optString("url"));
            aVar.d(jSONObject.optJSONObject("body"));
            aVar.g(jSONObject.optString("dump_file"));
            aVar.e(jSONObject.optBoolean("encrypt", false));
            return aVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(File file, String str, String str2, JSONObject jSONObject, String str3, boolean z5) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("url", str2);
            jSONObject2.put("body", jSONObject);
            if (str3 == null) {
                str3 = "";
            }
            jSONObject2.put("dump_file", str3);
            jSONObject2.put("encrypt", z5);
            f(file2, jSONObject2.toString(), false);
        } catch (IOException e6) {
            vl.j(e6);
        } catch (JSONException e7) {
            vl.j(e7);
        }
        return file2.getAbsolutePath();
    }

    public static String d(String str, String str2) throws IOException {
        BufferedReader bufferedReader = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        if (str2 != null) {
                            sb.append(str2);
                        }
                    } else {
                        h.a(bufferedReader2);
                        return sb.toString();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    h.a(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void f(@NonNull File file, @NonNull String str, boolean z5) throws IOException {
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file, z5);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            h.a(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            h.a(fileOutputStream2);
            throw th;
        }
    }

    public static boolean g(File file) {
        if (file.exists() && file.delete()) {
            return true;
        }
        return false;
    }

    public static boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !file.delete()) {
            return false;
        }
        return true;
    }
}
