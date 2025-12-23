package cn.jiguang.ba;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bz.v;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1945a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f1946b;

    /* renamed from: c, reason: collision with root package name */
    private static String f1947c;

    /* renamed from: d, reason: collision with root package name */
    private static Integer f1948d;

    /* renamed from: e, reason: collision with root package name */
    private static final LinkedList<String> f1949e;

    public static int b() {
        c();
        Integer num = f1948d;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    static {
        String b6 = cn.jiguang.bz.l.b(new byte[]{72, 109, 124, 102, 98, 10, 15, 54, 123, 101, 125, 83, 69, 107, 124, 56, 123, SignedBytes.MAX_POWER_OF_TWO, 85, 106, 96, 56, 114, 94});
        f1945a = b6;
        String b7 = cn.jiguang.bz.l.b(new byte[]{88, 84, 109, 120, 101, 43, Ascii.US, 15, 106, 123, 122, 114, 85, 82, 109, 37, Byte.MAX_VALUE, 97, 70, 22, 55, 98, 102, 100, 67, 72, 55, 107, 120});
        f1946b = b7;
        LinkedList<String> linkedList = new LinkedList<>();
        f1949e = linkedList;
        linkedList.add(b6);
        linkedList.add(b7);
    }

    public static String a() {
        c();
        return !TextUtils.isEmpty(f1947c) ? f1947c : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(Context context) {
        String a6;
        try {
            a6 = a.a(context);
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JSslCertUpdateManager", "request crt failed, " + th.getMessage());
        }
        if (TextUtils.isEmpty(a6)) {
            cn.jiguang.bb.f.i("JSslCertUpdateManager", "appKey is empty, return");
            return null;
        }
        Iterator<String> it = f1949e.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (TextUtils.isEmpty(next)) {
                cn.jiguang.bb.f.i("JSslCertUpdateManager", "url is empty, return it");
            } else {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appkey", a6);
                jSONObject.put("sdkver", cn.jiguang.a.a.f1444b);
                jSONObject.put("platform", 0);
                Context context2 = context;
                cn.jiguang.bd.g a7 = cn.jiguang.bd.b.a(next, jSONObject.toString(), context2, true, 3, 2);
                cn.jiguang.bb.f.c("JSslCertUpdateManager", "update cert code[" + a7.a() + "] from url=" + next + "\n body=" + a7.b());
                if (a7.a() == 0) {
                    String b6 = a7.b();
                    if (!TextUtils.isEmpty(b6)) {
                        if (new JSONObject(b6).optInt("code") != 200) {
                            return null;
                        }
                        return b6;
                    }
                }
                context = context2;
            }
        }
        return null;
    }

    private static void c() {
        if (f1948d == null && TextUtils.isEmpty(f1947c)) {
            synchronized (j.class) {
                cn.jiguang.bz.d.a(null);
                JSONObject a6 = cn.jiguang.bz.j.a("ccp.catch.");
                if (a6 != null && !"{}".equals(a6.toString())) {
                    String optString = a6.optString("cert", "");
                    if (TextUtils.isEmpty(optString)) {
                        return;
                    }
                    f1947c = v.b(optString, cn.jiguang.a.a.f1451i);
                    f1948d = Integer.valueOf(a6.optInt("ver", 0));
                }
            }
        }
    }

    private static boolean b(Context context, int i6) {
        if (!((Boolean) cn.jiguang.e.b.a(context, cn.jiguang.e.a.j())).booleanValue()) {
            cn.jiguang.bb.f.c("JSslCertUpdateManager", "not use tcp ssl, so need not update cert.");
            return false;
        }
        int b6 = b();
        if (b6 < i6) {
            cn.jiguang.bg.c.a(false);
            synchronized (j.class) {
                f1947c = null;
                cn.jiguang.bz.j.d("ccp.catch.");
                cn.jiguang.bb.f.c("JSslCertUpdateManager", "should update, clear cert");
            }
            return true;
        }
        cn.jiguang.bb.f.c("JSslCertUpdateManager", "it need not update cert, l_cert_ver: " + b6 + ", new_cert_ver: " + i6);
        return false;
    }

    public static void a(final Context context, int i6) {
        if (b(context, i6)) {
            cn.jiguang.by.d.a("FUTURE_TASK", new cn.jiguang.by.b("JSslCertUpdateManager") { // from class: cn.jiguang.ba.j.1
                @Override // cn.jiguang.by.b
                public void a() {
                    try {
                        String b6 = j.b(context);
                        if (TextUtils.isEmpty(b6)) {
                            cn.jiguang.bw.a.a().a(15);
                            return;
                        }
                        synchronized (j.class) {
                            try {
                                JSONObject jSONObject = new JSONObject(b6);
                                int optInt = jSONObject.optInt("ver", 0);
                                String optString = jSONObject.optString("cert", "");
                                if (TextUtils.isEmpty(optString)) {
                                    cn.jiguang.bw.a.a().a(19);
                                } else {
                                    String b7 = v.b(optString, cn.jiguang.a.a.f1451i);
                                    if (TextUtils.isEmpty(b7) || optInt <= 0) {
                                        cn.jiguang.bw.a.a().a(17);
                                    } else {
                                        String unused = j.f1947c = b7;
                                        Integer unused2 = j.f1948d = Integer.valueOf(optInt);
                                        boolean a6 = cn.jiguang.bz.j.a("ccp.catch.", jSONObject);
                                        cn.jiguang.bw.a.a().a(a6 ? 18 : 17);
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("update cert status: ");
                                        sb.append(a6 ? "succeed" : "failed");
                                        cn.jiguang.bb.f.c("JSslCertUpdateManager", sb.toString());
                                    }
                                }
                            } finally {
                            }
                        }
                    } catch (Throwable th) {
                        cn.jiguang.bw.a.a().a(16);
                        cn.jiguang.bb.f.i("JSslCertUpdateManager", "checkCrtUpdate failed, " + th.getMessage());
                    }
                }
            });
        }
    }
}
