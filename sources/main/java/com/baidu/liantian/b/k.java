package com.baidu.liantian.b;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hms.common.util.Logger;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10357a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f10358b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f10359c;

    /* renamed from: d, reason: collision with root package name */
    private static a f10360d;

    /* renamed from: e, reason: collision with root package name */
    private Context f10361e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f10362a;

        /* renamed from: b, reason: collision with root package name */
        public String f10363b;

        private a() {
        }

        public static a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("deviceid");
                String string2 = jSONObject.getString("imei");
                if (!TextUtils.isEmpty(string) && string2 != null) {
                    a aVar = new a();
                    aVar.f10362a = string;
                    aVar.f10363b = string2;
                    return aVar;
                }
                return null;
            } catch (Throwable unused) {
                k.a();
                return null;
            }
        }

        /* synthetic */ a(byte b6) {
            this();
        }

        public final String a() {
            try {
                String str = this.f10363b;
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                return this.f10362a + Logger.f33116c + new StringBuffer(str).reverse().toString();
            } catch (Throwable unused) {
                k.a();
                return null;
            }
        }
    }

    static /* synthetic */ void a() {
    }

    private static a b(Context context) {
        if (f10360d == null) {
            synchronized (a.class) {
                try {
                    if (f10360d == null) {
                        f10360d = new k(context).b();
                    }
                } finally {
                }
            }
        }
        return f10360d;
    }

    private static a c() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if (!file.exists()) {
                return null;
            }
            String a6 = a(file);
            if (TextUtils.isEmpty(a6)) {
                return null;
            }
            String str = f10359c;
            return a.a(new String(com.baidu.liantian.b.a.a(str, str, c.a(a6.getBytes()))));
        } catch (Throwable unused) {
            return null;
        }
    }

    private a d() {
        try {
            String a6 = a("com.baidu.deviceid");
            String a7 = a("bd_setting_i");
            String str = "";
            if (TextUtils.isEmpty(a7)) {
                a7 = c("");
            }
            if (TextUtils.isEmpty(a6)) {
                String string = Settings.Secure.getString(this.f10361e.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
                if (!TextUtils.isEmpty(string)) {
                    str = string;
                }
                a6 = a(o.b(("com.baidu" + a7 + str).getBytes()));
            }
            if (TextUtils.isEmpty(a6)) {
                return null;
            }
            a aVar = new a((byte) 0);
            aVar.f10362a = a6;
            aVar.f10363b = a7;
            return aVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    static {
        String str = new String(c.a(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61}));
        f10357a = str;
        String str2 = new String(c.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61}));
        f10358b = str2;
        f10359c = str + str2;
    }

    private String a(String str) {
        try {
            return Settings.System.getString(this.f10361e.getContentResolver(), str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean e(String str) {
        return this.f10361e.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    private k(Context context) {
        this.f10361e = context;
    }

    private static String a(File file) {
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
            try {
                char[] cArr = new char[8192];
                CharArrayWriter charArrayWriter = new CharArrayWriter();
                while (true) {
                    int read = fileReader.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    charArrayWriter.write(cArr, 0, read);
                }
                String charArrayWriter2 = charArrayWriter.toString();
                try {
                    fileReader.close();
                } catch (Throwable unused) {
                }
                return charArrayWriter2;
            } catch (Throwable unused2) {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            fileReader = null;
        }
    }

    private a b() {
        try {
            a a6 = a.a(d(a("com.baidu.deviceid.v2")));
            if (a6 != null) {
                return a6;
            }
            try {
                boolean e6 = e(com.kuaishou.weapon.p0.g.f36049i);
                if (e6) {
                    a6 = c();
                }
                if (a6 != null) {
                    return a6;
                }
                a d6 = d();
                return (d6 == null && e6) ? b(c("")) : d6;
            } catch (Throwable unused) {
                return a6;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    private String c(String str) {
        String str2 = null;
        if (!e(com.kuaishou.weapon.p0.g.f36043c)) {
            return str;
        }
        TelephonyManager telephonyManager = (TelephonyManager) this.f10361e.getSystemService("phone");
        if (telephonyManager != null) {
            str2 = telephonyManager.getDeviceId();
        }
        if (str2 != null && str2.contains(":")) {
            str2 = "";
        }
        return TextUtils.isEmpty(str2) ? str : str2;
    }

    public static String a(Context context) {
        a b6 = b(context);
        if (b6 != null) {
            return b6.a();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a7, code lost:
    
        if (r6 != null) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.baidu.liantian.b.k.a b(java.lang.String r10) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            r2 = 0
            r3 = 1
            if (r0 >= r1) goto La
            r0 = 1
            goto Lb
        La:
            r0 = 0
        Lb:
            r1 = 0
            if (r0 == 0) goto L15
            boolean r4 = android.text.TextUtils.isEmpty(r10)
            if (r4 == 0) goto L15
            return r1
        L15:
            java.lang.String r4 = ""
            java.io.File r5 = new java.io.File
            java.io.File r6 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r7 = "baidu/.cuid"
            r5.<init>(r6, r7)
            boolean r6 = r5.exists()
            if (r6 != 0) goto L33
            java.io.File r5 = new java.io.File
            java.io.File r6 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r7 = "backups/.SystemConfig/.cuid"
            r5.<init>(r6, r7)
        L33:
            java.io.FileReader r6 = new java.io.FileReader     // Catch: java.lang.Throwable -> L9f
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L9f
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L9c
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L9c
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L91
            r7.<init>()     // Catch: java.lang.Throwable -> L91
        L42:
            java.lang.String r8 = r5.readLine()     // Catch: java.lang.Throwable -> L91
            if (r8 == 0) goto L51
            r7.append(r8)     // Catch: java.lang.Throwable -> L91
            java.lang.String r8 = "\r\n"
            r7.append(r8)     // Catch: java.lang.Throwable -> L91
            goto L42
        L51:
            r5.close()     // Catch: java.lang.Throwable -> L91
            java.lang.String r8 = new java.lang.String     // Catch: java.lang.Throwable -> L91
            java.lang.String r9 = com.baidu.liantian.b.k.f10359c     // Catch: java.lang.Throwable -> L91
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L91
            byte[] r7 = r7.getBytes()     // Catch: java.lang.Throwable -> L91
            byte[] r7 = com.baidu.liantian.b.c.a(r7)     // Catch: java.lang.Throwable -> L91
            byte[] r7 = com.baidu.liantian.b.a.a(r9, r9, r7)     // Catch: java.lang.Throwable -> L91
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L91
            java.lang.String r7 = "="
            java.lang.String[] r7 = r8.split(r7)     // Catch: java.lang.Throwable -> L91
            if (r7 == 0) goto L93
            int r8 = r7.length     // Catch: java.lang.Throwable -> L91
            r9 = 2
            if (r8 != r9) goto L93
            if (r0 == 0) goto L84
            r8 = r7[r2]     // Catch: java.lang.Throwable -> L91
            boolean r8 = r10.equals(r8)     // Catch: java.lang.Throwable -> L91
            if (r8 == 0) goto L84
            r4 = r7[r3]     // Catch: java.lang.Throwable -> L91
            goto L93
        L84:
            if (r0 != 0) goto L93
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> L91
            if (r0 == 0) goto L8e
            r10 = r7[r3]     // Catch: java.lang.Throwable -> L91
        L8e:
            r4 = r7[r3]     // Catch: java.lang.Throwable -> L91
            goto L93
        L91:
            goto La2
        L93:
            r5.close()     // Catch: java.lang.Throwable -> L9a
        L96:
            r6.close()     // Catch: java.lang.Throwable -> L9a
            goto Laa
        L9a:
            goto Laa
        L9c:
            r5 = r1
            goto La2
        L9f:
            r5 = r1
            r6 = r5
        La2:
            if (r5 == 0) goto La7
            r5.close()     // Catch: java.lang.Throwable -> L9a
        La7:
            if (r6 == 0) goto Laa
            goto L96
        Laa:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto Lba
            com.baidu.liantian.b.k$a r0 = new com.baidu.liantian.b.k$a
            r0.<init>(r2)
            r0.f10362a = r4
            r0.f10363b = r10
            return r0
        Lba:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.b.k.b(java.lang.String):com.baidu.liantian.b.k$a");
    }

    private static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str2 = f10359c;
            return new String(com.baidu.liantian.b.a.a(str2, str2, c.a(str.getBytes())));
        } catch (Throwable unused) {
            return "";
        }
    }
}
