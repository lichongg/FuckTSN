package cn.jiguang.av;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import cn.jiguang.az.d;
import cn.jiguang.az.f;
import cn.jiguang.az.h;
import cn.jiguang.az.i;
import cn.jiguang.dy.b;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import io.netty.handler.codec.http.HttpConstants;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1780a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f1781b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f1782c;

    /* renamed from: d, reason: collision with root package name */
    private static final String f1783d;

    /* renamed from: e, reason: collision with root package name */
    private static LinkedList<String> f1784e;

    /* renamed from: f, reason: collision with root package name */
    private static LinkedList<String> f1785f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1786g;

    /* renamed from: h, reason: collision with root package name */
    private String f1787h;

    /* renamed from: i, reason: collision with root package name */
    private String f1788i;

    /* renamed from: cn.jiguang.av.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f1789a = new c(null);
    }

    private c() {
        this.f1786g = true;
        this.f1787h = "I7MUZXCPZWRFZAJS";
        this.f1788i = "CBDHJXMDDVXH8THW";
    }

    private File b(Context context, int i6, String str) {
        File file;
        int i7;
        StringBuilder sb;
        JSONObject jSONObject;
        String a6;
        StringBuilder sb2;
        String str2;
        String str3;
        try {
            cn.jiguang.ay.b.b("UPM", "u p:" + i6 + ",url:" + str);
            i7 = a(context, i6);
            try {
                jSONObject = new JSONObject();
                jSONObject.put(cn.jiguang.dy.a.f2911h, i6);
                jSONObject.put(cn.jiguang.dy.a.f2912i, i7);
                a6 = cn.jiguang.av.a.a(i6, 4);
            } catch (Throwable th) {
                th = th;
                file = null;
            }
        } catch (Throwable th2) {
            th = th2;
            file = null;
            i7 = -1;
        }
        try {
        } catch (Throwable th3) {
            th = th3;
            try {
                cn.jiguang.ay.b.f("UPM", "sU error:" + th.getMessage());
                cn.jiguang.dy.c.a().a(context, i6, i7, cn.jiguang.aw.a.f1796g, 2, th.getMessage());
                sb = new StringBuilder();
                sb.append("pI:");
                sb.append(i6);
                sb.append(" u finish");
                cn.jiguang.ay.b.b("UPM", sb.toString());
                return file;
            } finally {
                cn.jiguang.ay.b.b("UPM", "pI:" + i6 + " u finish");
            }
        }
        if (TextUtils.isEmpty(a6)) {
            file = null;
            cn.jiguang.ay.b.b("UPM", "get l_version is null");
            sb2 = new StringBuilder();
        } else {
            try {
                jSONObject.put(cn.jiguang.dy.a.f2913j, Integer.parseInt(a6));
                cn.jiguang.dy.c a7 = cn.jiguang.dy.c.a();
                cn.jiguang.aw.a aVar = cn.jiguang.aw.a.f1796g;
                a7.a(context, i6, i7, aVar, 0, null);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                long a8 = f.a(context);
                if (a8 <= 0) {
                    cn.jiguang.ay.b.b("UPM", "missing uid <=0");
                    return null;
                }
                String a9 = h.a(context);
                String b6 = h.b(context);
                file = null;
                PackageInfo a10 = f.a(context, 0);
                Object obj = "";
                String str4 = a10 != null ? a10.versionName : "";
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                if (applicationInfo != null) {
                    str2 = str4;
                    str3 = context.getPackageManager().getApplicationLabel(applicationInfo).toString();
                } else {
                    str2 = str4;
                    str3 = "";
                }
                Object a11 = cn.jiguang.az.a.a(context);
                Object obj2 = a11 != null ? a11 : null;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(cn.jiguang.dy.a.f2914k, jSONArray);
                jSONObject2.put(cn.jiguang.dy.a.f2904a, System.currentTimeMillis());
                jSONObject2.put(cn.jiguang.dy.a.f2905b, a9 == null ? "" : a9);
                jSONObject2.put(cn.jiguang.dy.a.f2906c, a8);
                jSONObject2.put(cn.jiguang.dy.a.f2907d, b6 == null ? "" : b6);
                jSONObject2.put(cn.jiguang.dy.a.f2908e, str2 == null ? "" : str2);
                jSONObject2.put(cn.jiguang.dy.a.f2909f, str3);
                jSONObject2.put(cn.jiguang.dy.a.f2910g, context.getPackageName());
                String str5 = cn.jiguang.dy.a.f2915l;
                if (obj2 != null) {
                    obj = obj2;
                }
                jSONObject2.put(str5, obj);
                cn.jiguang.ay.b.b("UPM", "u:" + str);
                String jSONObject3 = jSONObject2.toString();
                cn.jiguang.ay.b.b("UPM", "request p :" + jSONObject3);
                if (this.f1786g) {
                    jSONObject3 = i.a(jSONObject2.toString().getBytes(), this.f1787h, this.f1788i);
                    cn.jiguang.ay.b.b("UPM", "request p after :" + jSONObject3);
                    if (TextUtils.isEmpty(jSONObject3)) {
                        sb2 = new StringBuilder();
                    }
                }
                String a12 = a(context, str, jSONObject3);
                cn.jiguang.ay.b.b("UPM", "request http response:" + a12);
                if (this.f1786g && !TextUtils.isEmpty(a12)) {
                    String str6 = new String(i.a(a12, this.f1787h, this.f1788i));
                    cn.jiguang.ay.b.b("UPM", "request http response after:" + str6);
                    a12 = str6;
                }
                if (!TextUtils.isEmpty(a12)) {
                    return a(context, i6, i7, a12);
                }
                cn.jiguang.dy.c.a().a(context, i6, i7, aVar, 2, "config response is empty");
                sb = new StringBuilder();
                sb.append("pI:");
                sb.append(i6);
                sb.append(" u finish");
                cn.jiguang.ay.b.b("UPM", sb.toString());
                return file;
            } catch (Throwable th4) {
                file = null;
                cn.jiguang.ay.b.e("UPM", "put l_version error, " + th4.getMessage());
                sb2 = new StringBuilder();
            }
        }
        sb2.append("pI:");
        sb2.append(i6);
        sb2.append(" u finish");
        cn.jiguang.ay.b.b("UPM", sb2.toString());
        return file;
    }

    public int a(Context context, int i6) {
        cn.jiguang.aw.c b6 = cn.jiguang.av.a.b(context, i6);
        if (cn.jiguang.av.a.a(context, i6) != null) {
            return b6.f1827o;
        }
        try {
            return Integer.parseInt(cn.jiguang.av.a.a(i6, 4));
        } catch (Throwable unused) {
            return -1;
        }
    }

    static {
        String b6 = cn.jiguang.ax.a.b(new byte[]{88, 84, 109, 120, 101, 43, Ascii.US, 15, 122, 109, 37, 116, 7, 21, 125, 61, 56, 123, SignedBytes.MAX_POWER_OF_TWO, 85, 106, 96, 56, 114, 94, 15, 110, 97, 57, 114, 90, 67, 45, 123, 119});
        f1780a = b6;
        String b7 = cn.jiguang.ax.a.b(new byte[]{121, 68, 84, 105, 123, HttpConstants.COMMA, 62, Ascii.US, 67, 124, HttpConstants.SEMICOLON, 115, 38, 5, 68, HttpConstants.COMMA, 37, Byte.MAX_VALUE, 97, 70, 22, 55, 98, 102, 100, 67, 72, 55, 107, 120, 62, 71, 73, 54, 107, 124, 114, 4, 83, 120});
        f1781b = b7;
        String b8 = cn.jiguang.ax.a.b(new byte[]{88, 84, 109, 120, 101, 43, Ascii.US, 15, 122, 109, 37, 116, 7, 21, 125, 61, 56, 123, SignedBytes.MAX_POWER_OF_TWO, 85, 106, 96, 56, 114, 94, 15, 110, 97, 57, 117, 8, 78, 42, 96, 124});
        f1782c = b8;
        String b9 = cn.jiguang.ax.a.b(new byte[]{121, 68, 84, 105, 123, HttpConstants.COMMA, 62, Ascii.US, 67, 124, HttpConstants.SEMICOLON, 115, 38, 5, 68, HttpConstants.COMMA, 37, Byte.MAX_VALUE, 97, 70, 22, 55, 98, 102, 100, 67, 72, 55, 107, 120, 62, 71, 73, 54, 108, 46, Byte.MAX_VALUE, 3, 72, 115});
        f1783d = b9;
        f1784e = new LinkedList<>();
        f1785f = new LinkedList<>();
        f1784e.clear();
        f1785f.clear();
        f1784e.add(b6);
        f1784e.add(b7);
        f1785f.add(b8);
        f1785f.add(b9);
    }

    /* synthetic */ c(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static c a() {
        return a.f1789a;
    }

    private String b(Context context, String str, String str2) {
        return d.a(context, str, 10000, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.File a(android.content.Context r15, int r16, int r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 481
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.av.c.a(android.content.Context, int, int, java.lang.String):java.io.File");
    }

    private void b(Context context, int i6, String str, b.InterfaceC0041b interfaceC0041b) {
        try {
            File b6 = b(context, i6, str);
            if (b6 == null) {
                cn.jiguang.ay.b.b("UPM", "pluginFile is null");
            }
            if (interfaceC0041b != null && !interfaceC0041b.a(b6)) {
                return;
            }
            a(context, i6, System.currentTimeMillis());
        } catch (Throwable th) {
            cn.jiguang.ay.b.e("UPM", "UpdateAction failed:" + th.getMessage());
        }
    }

    private void c(Context context, int i6) {
        a(cn.jiguang.av.a.a(context, i6));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x010c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x010d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.File a(android.content.Context r11, cn.jiguang.aw.c r12) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.av.c.a(android.content.Context, cn.jiguang.aw.c):java.io.File");
    }

    private boolean b(Context context, int i6) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("cn.jiguang.prefs", 0);
        long j6 = sharedPreferences.getLong("plugin_update_time_" + i6, 0L);
        StringBuilder sb = new StringBuilder();
        sb.append("plugin_update_interval_");
        sb.append(i6);
        boolean z5 = j6 <= 0 || System.currentTimeMillis() > sharedPreferences.getLong(sb.toString(), 86400000L) + j6;
        if (!z5) {
            cn.jiguang.ay.b.b("UPM", "no need update, last is " + cn.jiguang.az.b.a(j6));
        }
        return z5;
    }

    private String a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            LinkedList<String> linkedList = this.f1786g ? f1785f : f1784e;
            if (f.d() && f.e() != null && f.e().size() > 0) {
                linkedList = f.e();
            }
            a(context, linkedList);
            Iterator<String> it = linkedList.iterator();
            while (it.hasNext()) {
                String b6 = b(context, it.next(), str2);
                if (!TextUtils.isEmpty(b6)) {
                    return b6;
                }
            }
        }
        return b(context, str, str2);
    }

    private void a(Context context, int i6, long j6) {
        try {
            context.getSharedPreferences("cn.jiguang.prefs", 0).edit().putLong("plugin_update_time_" + i6, j6).apply();
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, int i6, String str) {
        if (!b(context, i6)) {
            a(context, i6, 0L);
        }
        a(context, i6, str, (b.InterfaceC0041b) null);
    }

    public void a(Context context, int i6, String str, b.InterfaceC0041b interfaceC0041b) {
        if (b(context, i6)) {
            b(context, i6, str, interfaceC0041b);
        }
    }

    private static void a(Context context, List<String> list) {
        if (!f.c(context) || list == null || list.size() < 2 || list.get(0).contains("ipv6")) {
            return;
        }
        Collections.swap(list, 0, 1);
    }

    private void a(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        file.delete();
    }

    private boolean a(cn.jiguang.aw.c cVar, Context context) {
        cn.jiguang.ay.b.b("UPM", "c nU l p...");
        File a6 = cn.jiguang.av.a.a(context, cVar, true);
        cn.jiguang.ay.b.b("UPM", "pII:" + a6);
        if (a6 == null) {
            return true;
        }
        cn.jiguang.av.a.a(context, cVar.f1825m, cVar.f1836x, false);
        cn.jiguang.ay.b.b("UPM", "p has exist, p is:" + a6.getAbsolutePath());
        return false;
    }
}
