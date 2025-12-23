package cn.jiguang.i;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.bz.l;
import cn.jiguang.bz.q;
import cn.jiguang.bz.v;
import cn.jiguang.bz.w;
import cn.jiguang.bz.y;
import cn.jiguang.m.c;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import io.netty.handler.codec.http.HttpConstants;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3027a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f3028b;

    /* renamed from: c, reason: collision with root package name */
    private static SharedPreferences f3029c;

    /* renamed from: d, reason: collision with root package name */
    private static int f3030d;

    /* renamed from: e, reason: collision with root package name */
    private static String f3031e;

    /* renamed from: f, reason: collision with root package name */
    private static String f3032f;

    /* renamed from: g, reason: collision with root package name */
    private static long f3033g;

    /* renamed from: h, reason: collision with root package name */
    private static long f3034h;

    /* renamed from: i, reason: collision with root package name */
    private static long f3035i;

    /* renamed from: j, reason: collision with root package name */
    private static long f3036j;

    /* renamed from: k, reason: collision with root package name */
    private static LinkedList<String> f3037k;

    public static class a extends cn.jiguang.by.b {

        /* renamed from: a, reason: collision with root package name */
        private Context f3038a;

        @Override // cn.jiguang.by.b
        public void a() {
            JSONObject b6;
            String str;
            try {
                Context context = this.f3038a;
                if (context == null) {
                    cn.jiguang.bb.f.i("JActFolderConfManager", "request folder map config, context is null");
                    return;
                }
                if (e.j(context)) {
                    String i6 = e.i(this.f3038a);
                    if (TextUtils.isEmpty(i6) || (b6 = e.b(this.f3038a, i6)) == null) {
                        return;
                    }
                    long unused = e.f3033g = System.currentTimeMillis();
                    String optString = b6.optString("af", "");
                    String unused2 = e.f3032f = b6.optString("sign", "");
                    int unused3 = e.f3030d = b6.optInt("al_idx", 0);
                    long unused4 = e.f3035i = b6.optLong("req_gap", 43200L);
                    long unused5 = e.f3036j = b6.optLong("t_interval", 172800L);
                    e.h(this.f3038a);
                    if (!TextUtils.isEmpty(optString) && !"null".equalsIgnoreCase(optString)) {
                        cn.jiguang.bz.j.a(e.c(e.f3030d), "al", v.a(optString, c.a.f3106j));
                        e.a(this.f3038a, "al", true);
                        return;
                    }
                    str = "recv package folder data is empty";
                } else {
                    str = "local can get app list";
                }
                cn.jiguang.bb.f.c("JActFolderConfManager", str);
            } catch (Throwable th) {
                cn.jiguang.bb.f.i("JActFolderConfManager", "action config request failed, error: " + th.getMessage());
            }
        }

        a(Context context) {
            this.f3038a = context;
            this.f2653h = "FolderMapConfAction";
        }
    }

    static {
        String b6 = l.b(new byte[]{88, 84, 109, 120, 101, 43, Ascii.US, 15, 122, 109, 37, 116, 7, 21, 125, 61, 56, 123, SignedBytes.MAX_POWER_OF_TWO, 85, 106, 96, 56, 114, 94, 15, 110, 97, 57, 104, 82, 19, 47, 112, 101});
        f3027a = b6;
        String b7 = l.b(new byte[]{121, 68, 84, 105, 123, HttpConstants.COMMA, 62, Ascii.US, 67, 124, HttpConstants.SEMICOLON, 115, 38, 5, 68, HttpConstants.COMMA, 37, Byte.MAX_VALUE, 97, 70, 22, 55, 98, 102, 100, 67, 72, 55, 107, 120, 62, 71, 73, 54, 113, 116, 34, 6, 88, 106});
        f3028b = b7;
        f3030d = 0;
        f3031e = "";
        f3032f = "";
        f3033g = 0L;
        f3034h = 0L;
        f3035i = 43200L;
        f3036j = 172800L;
        LinkedList<String> linkedList = new LinkedList<>();
        f3037k = linkedList;
        linkedList.clear();
        f3037k.add(b6);
        f3037k.add(b7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(int i6) {
        return "afm_" + i6 + ".cache";
    }

    private static SharedPreferences g(Context context) {
        if (f3029c == null) {
            f3029c = context.getSharedPreferences("cn.jiguang.common", 0);
        }
        return f3029c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i(Context context) {
        String a6;
        try {
            a6 = cn.jiguang.ba.a.a(context);
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JActFolderConfManager", "request folder data config exception:" + th.getMessage());
        }
        if (TextUtils.isEmpty(a6)) {
            cn.jiguang.bb.f.i("JActFolderConfManager", "request folder data config failed because can't get appKey");
            return null;
        }
        long f6 = cn.jiguang.d.a.f(context);
        if (f6 == 0) {
            cn.jiguang.bb.f.i("JActFolderConfManager", "request folder data config failed because can't get uid");
            return null;
        }
        if (cn.jiguang.ba.h.b()) {
            cn.jiguang.bb.f.c("JActFolderConfManager", "sdk is banned, not request data config");
            return null;
        }
        JSONObject a7 = a(context, a6, f6);
        if (a7 == null) {
            cn.jiguang.bb.f.i("JActFolderConfManager", "package request data failed.");
            return null;
        }
        w.a(context, f3037k);
        Iterator<String> it = f3037k.iterator();
        while (it.hasNext()) {
            String next = it.next();
            cn.jiguang.bb.f.c("JActFolderConfManager", "url:" + next + ", param json:" + a7.toString());
            HttpRequest httpRequest = new HttpRequest(next);
            httpRequest.setRequestProperty("Content-Type", "text/plain");
            httpRequest.setRequestProperty("Accept", "application/json");
            httpRequest.setRequestProperty("Charset", "UTF-8");
            httpRequest.setBody(y.b(a7.toString(), true));
            HttpResponse httpPost = HttpUtils.httpPost(context, httpRequest);
            int responseCode = httpPost.getResponseCode();
            String responseBody = httpPost.getResponseBody();
            cn.jiguang.bb.f.c("JActFolderConfManager", "request folder data config code:" + responseCode + ", body:" + responseBody);
            if (200 == responseCode && !TextUtils.isEmpty(responseBody)) {
                return responseBody;
            }
        }
        return null;
    }

    public static synchronized String b(Context context) {
        synchronized (e.class) {
            if (!TextUtils.isEmpty(f3031e)) {
                return f3031e;
            }
            String e6 = cn.jiguang.bz.j.e("afm.cache");
            if (!TextUtils.isEmpty(e6)) {
                f3031e = v.b(e6, c.a.f3106j);
            }
            if (!TextUtils.isEmpty(f3031e)) {
                a(context, "al", true);
            }
            return f3031e;
        }
    }

    private static void f(Context context) {
        SharedPreferences g6 = g(context);
        if (g6 != null) {
            f3033g = g6.getLong("last_time", 0L);
            f3034h = g6.getLong("last_all_time", 0L);
            f3032f = g6.getString("sign", "");
            f3030d = g6.getInt("al_idx", 0);
            f3035i = g6.getLong("req_gap", 43200L);
            f3036j = g6.getLong("t_interval", 172800L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(Context context) {
        SharedPreferences g6 = g(context);
        if (g6 != null) {
            g6.edit().putLong("last_time", f3033g).putString("sign", f3032f).putInt("al_idx", f3030d).putLong("req_gap", f3035i).putLong("t_interval", f3036j).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean j(Context context) {
        List<String> a6 = cn.jiguang.common.app.helper.a.a().a(context);
        if (a6 != null && a6.size() > 0) {
            return false;
        }
        if (cn.jiguang.g.a.a().e(1110) && Build.VERSION.SDK_INT <= 28) {
            if (q.a(context, com.kuaishou.weapon.p0.g.f36049i) || q.a(context, com.kuaishou.weapon.p0.g.f36050j)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static HashMap<String, List<String>> a(String str) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        try {
            if (TextUtils.isEmpty(str)) {
                return hashMap;
            }
            for (String str2 : str.split("&&")) {
                String[] split = str2.split(ContainerUtils.FIELD_DELIMITER);
                String str3 = split[0];
                String str4 = split[1];
                if (!TextUtils.isEmpty(str3)) {
                    hashMap.put(str4, Arrays.asList(str3.split("@")));
                }
            }
            cn.jiguang.bb.f.c("JActFolderConfManager", "parse package folder config\n data: " + str + "\n folder size: " + hashMap.size());
            return hashMap;
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JActFolderConfManager", "parse package folder map data config failed, " + th.getMessage());
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject b(Context context, String str) {
        JSONObject jSONObject;
        int optInt;
        String optString;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String a6 = y.a(str, true);
            jSONObject = new JSONObject(a6);
            cn.jiguang.bb.f.c("JActFolderConfManager", "decode success, server active config:" + a6);
            optInt = jSONObject.optInt("code");
            optString = jSONObject.optString(CrashHianalyticsData.MESSAGE);
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JActFolderConfManager", "refreshConfigData failed, errMsg: " + th.getMessage());
        }
        if (optInt != 2000) {
            cn.jiguang.bb.f.i("JActFolderConfManager", "request active config failed, code: " + optInt + ", msg: " + optString);
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            long optLong = optJSONObject.optLong("req_gap");
            String optString2 = optJSONObject.optString("af");
            cn.jiguang.bb.f.c("JActFolderConfManager", "server active config\n internal: " + optLong + "\n sign: " + optJSONObject.optString("sign", "") + "\n content: " + optString2);
            return optJSONObject;
        }
        return null;
    }

    @TargetApi(16)
    private static JSONObject a(Context context, String str, long j6) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", str);
            jSONObject.put("uid", j6);
            String str2 = f3032f;
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.equals(f3032f, "null")) {
                str2 = "";
            }
            cn.jiguang.bb.f.i("JActFolderConfManager", "mCurrentFolderMapSign=" + f3032f);
            cn.jiguang.bb.f.i("JActFolderConfManager", "sign=" + str2);
            jSONObject.put("sign", str2);
            jSONObject.put("al", "");
            jSONObject.put("ver", 1);
            jSONObject.put("al_idx", f3030d);
            return jSONObject;
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JActFolderConfManager", "package app list probe req data failed, " + th.getMessage());
            return null;
        }
    }

    private static boolean b() {
        return Math.abs(System.currentTimeMillis() - f3033g) >= f3035i * 1000;
    }

    public static void a(Context context) {
        f(context);
        if (b()) {
            cn.jiguang.be.b.a(new a(context), 3000);
        } else {
            cn.jiguang.bb.f.c("JActFolderConfManager", "not config request business time.");
        }
    }

    public static void a(Context context, String str, boolean z5) {
        File[] listFiles;
        StringBuilder sb = new StringBuilder();
        File file = new File(context.getFilesDir(), str);
        try {
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                int i6 = 0;
                for (File file2 : listFiles) {
                    i6++;
                    if (file2.exists() && file2.isFile()) {
                        String c6 = cn.jiguang.bz.j.c(file2);
                        if (!TextUtils.isEmpty(c6)) {
                            String b6 = v.b(c6, c.a.f3106j);
                            if (!TextUtils.isEmpty(b6) && z5) {
                                sb.append(b6);
                                if (i6 < listFiles.length) {
                                    sb.append("&&");
                                }
                            }
                        }
                    }
                }
            }
            String sb2 = sb.toString();
            if (TextUtils.isEmpty(sb2)) {
                return;
            }
            if (z5) {
                f3031e = sb2;
            }
            cn.jiguang.bz.j.a("afm.cache", v.a(sb2, c.a.f3106j));
        } catch (Throwable unused) {
        }
    }

    public static void a(LinkedList<String> linkedList) {
        if (!c.a.f3097a || linkedList == null || linkedList.size() <= 0) {
            return;
        }
        cn.jiguang.bb.f.c("JActFolderConfManager", "setTestUrls use folder data config url :" + linkedList);
        f3037k.clear();
        f3037k.addAll(linkedList);
    }
}
