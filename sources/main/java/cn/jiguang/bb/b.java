package cn.jiguang.bb;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.bz.j;
import cn.jiguang.bz.l;
import cn.jiguang.bz.w;
import cn.jiguang.bz.y;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.google.common.base.Ascii;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f1964a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f1965b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f1966c;

    /* renamed from: d, reason: collision with root package name */
    private static LinkedList<String> f1967d;

    private static long a(String str) {
        if (str != null) {
            try {
                if (str.length() > 23) {
                    Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH).parse(str.substring(0, 23));
                    if (parse != null) {
                        return parse.getTime();
                    }
                    return 0L;
                }
            } catch (Throwable th) {
                f.i("LogFileHelper", "Error parsing timestamp from log: " + th.getMessage());
            }
        }
        return 0L;
    }

    static {
        String b6 = l.b(new byte[]{121, 68, 84, 105, 123, HttpConstants.COMMA, 62, Ascii.US, 67, 124, HttpConstants.SEMICOLON, 115, 38, 5, 68, HttpConstants.COMMA, 38, 124, 97, 69, 83, 113, 38, 117, Byte.MAX_VALUE, Ascii.US, 87, 112, 39, 122, 124, 95, 80, 106});
        f1965b = b6;
        String b7 = l.b(new byte[]{126, 101, 68, 80, 106, 50, 57, 62, 83, 69, 42, 109, BinaryMemcacheOpcodes.SASL_AUTH, BinaryMemcacheOpcodes.GATKQ, 84, 21, 52, 97, 102, 103, 6, 14, 115, 120, 99, 98, 88, 14, 122, 102, 57, 102, 89, 15, 117, 101, 121, 97, 67});
        f1966c = b7;
        f1964a = "";
        LinkedList<String> linkedList = new LinkedList<>();
        f1967d = linkedList;
        linkedList.clear();
        f1967d.add(b6);
        f1967d.add(b7);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r12, long r13) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r1 = r12.getFilesDir()
            r0.append(r1)
            java.lang.String r1 = java.io.File.separator
            r0.append(r1)
            java.lang.String r2 = cn.jiguang.bb.e.f1970a
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            boolean r2 = r1.exists()
            java.lang.String r3 = "LogFileHelper"
            if (r2 == 0) goto Lcf
            boolean r2 = r1.isDirectory()
            if (r2 != 0) goto L32
            goto Lcf
        L32:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            cn.jiguang.bb.b$3 r2 = new cn.jiguang.bb.b$3     // Catch: java.lang.Throwable -> La5
            r2.<init>()     // Catch: java.lang.Throwable -> La5
            java.io.File[] r1 = r1.listFiles(r2)     // Catch: java.lang.Throwable -> La5
            if (r1 == 0) goto Lc1
            int r2 = r1.length     // Catch: java.lang.Throwable -> La5
            if (r2 <= 0) goto Lc1
            cn.jiguang.bb.b$4 r2 = new cn.jiguang.bb.b$4     // Catch: java.lang.Throwable -> La5
            r2.<init>()     // Catch: java.lang.Throwable -> La5
            java.util.Arrays.sort(r1, r2)     // Catch: java.lang.Throwable -> La5
            int r2 = r1.length     // Catch: java.lang.Throwable -> La5
            r4 = 0
            r5 = r13
        L50:
            if (r4 >= r2) goto Lc0
            r7 = r1[r4]     // Catch: java.lang.Throwable -> L7d
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L7d java.io.IOException -> L7f
            java.io.FileReader r9 = new java.io.FileReader     // Catch: java.lang.Throwable -> L7d java.io.IOException -> L7f
            r9.<init>(r7)     // Catch: java.lang.Throwable -> L7d java.io.IOException -> L7f
            r8.<init>(r9)     // Catch: java.lang.Throwable -> L7d java.io.IOException -> L7f
        L5e:
            java.lang.String r7 = r8.readLine()     // Catch: java.lang.Throwable -> L75
            if (r7 == 0) goto L79
            long r9 = a(r7)     // Catch: java.lang.Throwable -> L75
            int r11 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r11 <= 0) goto L77
            r0.append(r7)     // Catch: java.lang.Throwable -> L75
            java.lang.String r7 = "\n"
            r0.append(r7)     // Catch: java.lang.Throwable -> L75
            goto L77
        L75:
            r7 = move-exception
            goto L81
        L77:
            r5 = r9
            goto L5e
        L79:
            r8.close()     // Catch: java.lang.Throwable -> L7d java.io.IOException -> L7f
            goto La2
        L7d:
            r13 = move-exception
            goto La8
        L7f:
            r7 = move-exception
            goto L8a
        L81:
            r8.close()     // Catch: java.lang.Throwable -> L85
            goto L89
        L85:
            r8 = move-exception
            r7.addSuppressed(r8)     // Catch: java.lang.Throwable -> L7d java.io.IOException -> L7f
        L89:
            throw r7     // Catch: java.lang.Throwable -> L7d java.io.IOException -> L7f
        L8a:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7d
            r8.<init>()     // Catch: java.lang.Throwable -> L7d
            java.lang.String r9 = "Error reading log file: "
            r8.append(r9)     // Catch: java.lang.Throwable -> L7d
            java.lang.String r7 = r7.getMessage()     // Catch: java.lang.Throwable -> L7d
            r8.append(r7)     // Catch: java.lang.Throwable -> L7d
            java.lang.String r7 = r8.toString()     // Catch: java.lang.Throwable -> L7d
            cn.jiguang.bb.f.i(r3, r7)     // Catch: java.lang.Throwable -> L7d
        La2:
            int r4 = r4 + 1
            goto L50
        La5:
            r1 = move-exception
            r5 = r13
            r13 = r1
        La8:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r1 = "Error merging logs: "
            r14.append(r1)
            java.lang.String r13 = r13.getMessage()
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            cn.jiguang.bb.f.i(r3, r13)
        Lc0:
            r13 = r5
        Lc1:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto Lca
            cn.jiguang.e.c.a(r12, r13)
        Lca:
            java.lang.String r12 = r0.toString()
            return r12
        Lcf:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Log directory does not exist or is not a directory: "
            r12.append(r13)
            r12.append(r0)
            java.lang.String r12 = r12.toString()
            cn.jiguang.bb.f.i(r3, r12)
            java.lang.String r12 = ""
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bb.b.a(android.content.Context, long):java.lang.String");
    }

    public static void b(final Context context) {
        if (context == null) {
            return;
        }
        int intValue = ((Integer) cn.jiguang.e.b.a(context, cn.jiguang.e.a.aD())).intValue();
        int e6 = cn.jiguang.e.c.e(context);
        boolean d6 = cn.jiguang.e.c.d(context);
        int max = Math.max(intValue, 10);
        f.c("LogFileHelper", "startUpload delay is " + max + ", uploadLog is " + d6 + ", serverUploadState is " + e6);
        if (e6 == 0) {
            f.c("LogFileHelper", "serverUploadState is 0, not uploadLog");
        } else if (e6 < 2 || d6) {
            cn.jiguang.by.d.a("DELAY_TASK", new cn.jiguang.by.b() { // from class: cn.jiguang.bb.b.2
                @Override // cn.jiguang.by.b
                public void a() {
                    String str;
                    StringBuilder sb;
                    String str2;
                    try {
                        long f6 = cn.jiguang.d.a.f(context);
                        if (f6 == 0) {
                            return;
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(context.getFilesDir());
                        String str3 = File.separator;
                        sb2.append(str3);
                        sb2.append(e.f1970a);
                        sb2.append(str3);
                        String sb3 = sb2.toString();
                        File file = new File(sb3 + e.f1971b);
                        if (file.getParentFile().exists()) {
                            if (file.exists() && file.length() != 0) {
                                String j6 = cn.jiguang.bz.a.j(context);
                                String str4 = "android-" + j6 + "-" + f6 + ".aes";
                                File file2 = new File(sb3 + str4);
                                if (file2.exists()) {
                                    file2.delete();
                                    file2.createNewFile();
                                    sb = new StringBuilder();
                                    sb.append(" repeat Create aesFile : ");
                                    sb.append(file2.getName());
                                } else {
                                    file2.createNewFile();
                                    sb = new StringBuilder();
                                    sb.append("Create aesFile : ");
                                    sb.append(file2.getName());
                                }
                                f.a("LogFileHelper", sb.toString());
                                cn.jiguang.bc.a.a(cn.jiguang.ba.a.a(context), file, file2);
                                if (file2.length() == 0) {
                                    str2 = "aesFile encrypt fail";
                                } else {
                                    String a6 = b.a(context, str4);
                                    if (!TextUtils.isEmpty(a6)) {
                                        boolean a7 = cn.jiguang.bc.b.a(context, a6, file2);
                                        if (a7) {
                                            if (d.c(context)) {
                                                file.delete();
                                            }
                                            b.a(context, a7, j6, "");
                                        }
                                        file2.delete();
                                        return;
                                    }
                                    str2 = "getUploadToken url is empty";
                                }
                                f.c("LogFileHelper", str2);
                                file2.delete();
                                return;
                            }
                            str = "there is no log file to upload!";
                        } else {
                            str = "there is no log file dir!";
                        }
                        f.c("LogFileHelper", str);
                    } catch (Throwable th) {
                        f.i("LogFileHelper", "startUpload error is " + th.getMessage());
                    }
                }
            }, max * 1000);
        } else {
            f.c("LogFileHelper", "serverUploadState is 2 and local_upload is false, not uploadLog");
        }
    }

    public static String a(Context context, String str) {
        try {
            String a6 = cn.jiguang.ba.a.a(context);
            if (TextUtils.isEmpty(a6)) {
                f.i("LogFileHelper", "request upload token failed because can't get appKey");
                return "";
            }
            w.a(context, f1967d);
            Iterator<String> it = f1967d.iterator();
            while (it.hasNext()) {
                String next = it.next();
                long f6 = cn.jiguang.d.a.f(context);
                if (f6 == 0) {
                    f.i("LogFileHelper", "request l config failed because can't get uid");
                    return null;
                }
                String j6 = cn.jiguang.d.a.j(context);
                if (TextUtils.isEmpty(j6)) {
                    f.i("LogFileHelper", "request l config failed because need register first");
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appkey", a6);
                jSONObject.put("uid", f6);
                jSONObject.put("platform", "a");
                jSONObject.put("key", str);
                String upperCase = w.e(f6 + w.e(j6).toUpperCase()).toUpperCase();
                if (TextUtils.isEmpty(upperCase)) {
                    return null;
                }
                String encodeToString = Base64.encodeToString((f6 + ":" + upperCase).getBytes(), 10);
                if (TextUtils.isEmpty(encodeToString)) {
                    return null;
                }
                f.c("LogFileHelper", "url:" + next + ", param json:" + jSONObject.toString());
                HttpRequest httpRequest = new HttpRequest(next);
                httpRequest.setRequestProperty("Content-Type", "application/json");
                httpRequest.setRequestProperty("Accept", "application/json");
                httpRequest.setRequestProperty("X-Http-Platform", FaceEnvironment.OS);
                httpRequest.setRequestProperty("X-Http-Appkey", a6);
                httpRequest.setRequestProperty("Authorization", "Basic " + encodeToString);
                httpRequest.setRequestProperty("Charset", "UTF-8");
                httpRequest.setBody(jSONObject.toString());
                HttpResponse httpPost = HttpUtils.httpPost(context, httpRequest);
                int responseCode = httpPost.getResponseCode();
                f.c("LogFileHelper", "responseCode:" + responseCode);
                if (200 == responseCode) {
                    String responseBody = httpPost.getResponseBody();
                    f.c("LogFileHelper", "responseBody:" + responseBody);
                    if (TextUtils.isEmpty(responseBody)) {
                        continue;
                    } else {
                        f.c("LogFileHelper", "request upload token success,response body:" + responseBody);
                        JSONObject jSONObject2 = new JSONObject(responseBody);
                        if (jSONObject2.optInt("code") == 2000) {
                            return jSONObject2.optJSONObject("data") != null ? jSONObject2.optJSONObject("data").optString("uploadPreSignedURL") : "";
                        }
                        f.i("LogFileHelper", "start to open log ");
                        a(context, false, "", jSONObject2.optString("content"));
                    }
                }
            }
            return "";
        } catch (Throwable th) {
            f.i("LogFileHelper", "getUploadToken error is " + th.getMessage());
            return "";
        }
    }

    public static void a(final Context context) {
        if (context == null) {
            return;
        }
        int intValue = ((Integer) cn.jiguang.e.b.a(context, cn.jiguang.e.a.aD())).intValue();
        if (intValue <= 10) {
            intValue = 10;
        }
        cn.jiguang.by.d.a("DELAY_TASK", new cn.jiguang.by.b() { // from class: cn.jiguang.bb.b.1
            @Override // cn.jiguang.by.b
            public void a() {
                String str;
                try {
                    long f6 = cn.jiguang.d.a.f(context);
                    if (f6 == 0) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(context.getFilesDir());
                    String str2 = File.separator;
                    sb.append(str2);
                    sb.append("nes");
                    String sb2 = sb.toString();
                    String str3 = "android-" + cn.jiguang.bz.a.j(context) + "-" + f6 + ".zip";
                    String str4 = context.getFilesDir() + str2 + str3;
                    y.a(sb2, str4);
                    File file = new File(str4);
                    if (file.getParentFile().exists()) {
                        if (file.exists() && file.length() != 0) {
                            String a6 = b.a(context, str3);
                            if (TextUtils.isEmpty(a6)) {
                                f.c("LogFileHelper", "getUploadToken url is empty");
                            } else if (cn.jiguang.bc.b.a(context, a6, file)) {
                                j.b(new File(sb2));
                            }
                            file.delete();
                            return;
                        }
                        str = "there is no log file to upload!";
                    } else {
                        str = "there is no log file dir!";
                    }
                    f.c("LogFileHelper", str);
                } catch (Throwable th) {
                    f.i("LogFileHelper", "startUpload error is " + th.getMessage());
                }
            }
        }, intValue * 1000);
    }

    public static void a(Context context, boolean z5, String str, String str2) {
        if (((Boolean) cn.jiguang.e.b.a(context, cn.jiguang.e.a.an())).booleanValue()) {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.jiguang.openlog");
            launchIntentForPackage.putExtra("uid", cn.jiguang.d.a.f(context));
            launchIntentForPackage.putExtra("appKey", cn.jiguang.ba.a.a(context));
            launchIntentForPackage.putExtra("appName", str);
            launchIntentForPackage.putExtra("content", str2);
            launchIntentForPackage.putExtra("result", z5);
            context.startActivity(launchIntentForPackage);
        }
    }
}
