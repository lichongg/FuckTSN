package cn.jiguang.bi;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JDispatchAction;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private Map<Long, String> f2293a;

    /* renamed from: cn.jiguang.bi.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final j f2294a = new j(null);
    }

    private j() {
        this.f2293a = new HashMap();
    }

    public static j a() {
        return a.f2294a;
    }

    public void b(Context context, long j6) {
        cn.jiguang.bb.f.c("UserCtrlHelper", "onUserCtrlTimeout rid:" + j6);
        this.f2293a.remove(Long.valueOf(j6));
    }

    /* synthetic */ j(AnonymousClass1 anonymousClass1) {
        this();
    }

    private String a(Context context, String str, String str2) {
        String str3 = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.a(str));
        if (!TextUtils.isEmpty(str2) && !str2.equals(str3)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("need not ");
        sb.append(str);
        sb.append(" userctrl,newest version:");
        if (TextUtils.isEmpty(str2)) {
            str2 = "null";
        }
        sb.append(str2);
        cn.jiguang.bb.f.a("UserCtrlHelper", sb.toString());
        return "";
    }

    public boolean b(Context context) {
        if (context == null) {
            cn.jiguang.bb.f.j("UserCtrlHelper", "get isNeedUserCtrl failed,context is null");
            return false;
        }
        HashMap<String, JDispatchAction> hashMap = b.f2219a;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<String, JDispatchAction> entry : hashMap.entrySet()) {
                JDispatchAction value = entry.getValue();
                if (value != null && !TextUtils.isEmpty(a(context, entry.getKey(), value.getSdkVersion(entry.getKey())))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void a(Context context) {
        if (context == null) {
            cn.jiguang.bb.f.i("UserCtrlHelper", "handleUserCtrl failed,context is null");
            return;
        }
        HashMap<String, JDispatchAction> hashMap = b.f2219a;
        if (hashMap == null || hashMap.isEmpty()) {
            return;
        }
        for (Map.Entry<String, JDispatchAction> entry : hashMap.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                String a6 = a(context, entry.getKey(), value.getSdkVersion(entry.getKey()));
                if (!TextUtils.isEmpty(a6)) {
                    a(context, value.getUserCtrlProperty(entry.getKey()), a6, entry.getKey());
                }
            }
        }
    }

    public void a(Context context, long j6) {
        String str;
        Map<Long, String> map;
        String remove = this.f2293a.remove(Long.valueOf(j6));
        if (TextUtils.isEmpty(remove)) {
            str = "userCtrlSuccess but not found rid:" + j6;
        } else {
            cn.jiguang.bb.f.c("UserCtrlHelper", "userCtrlSuccess rid:" + j6 + ",sdkType:" + remove);
            String b6 = b.a().b(remove, "");
            if (!TextUtils.isEmpty(b6)) {
                cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.a(remove).a((cn.jiguang.e.a<String>) b6)});
                map = this.f2293a;
                if (map == null && map.isEmpty() && !cn.jiguang.ba.c.a().a(context)) {
                    g.a().a(context, "tcp_a21", null);
                    return;
                }
                return;
            }
            str = "userCtrlSuccess but not found sdkversion by sdkType:" + remove;
        }
        cn.jiguang.bb.f.c("UserCtrlHelper", str);
        map = this.f2293a;
        if (map == null) {
        }
    }

    public void a(Context context, long j6, int i6) {
        String str;
        String remove = this.f2293a.remove(Long.valueOf(j6));
        if (TextUtils.isEmpty(remove)) {
            str = "onUserCtrlFailed but not found rid:" + j6;
        } else {
            cn.jiguang.bb.f.c("UserCtrlHelper", "onUserCtrlFailed rid:" + j6 + ",sdkType:" + remove + ",errorCode:" + i6);
            if (!TextUtils.isEmpty(b.a().b(remove, ""))) {
                return;
            }
            str = "onUserCtrlFailed but not found sdkversion by sdkType:" + remove;
        }
        cn.jiguang.bb.f.c("UserCtrlHelper", str);
    }

    private void a(Context context, short s5, String str, String str2) {
        cn.jiguang.bb.f.c("UserCtrlHelper", "sendUserCtrlInfo sdkType:" + str2 + ",property:" + ((int) s5) + ",verInfo:" + str);
        long b6 = i.b();
        i.a().a(context, b6, 26, 0, cn.jiguang.bk.b.a(s5, (short) 1, str), str2, 10000L);
        this.f2293a.put(Long.valueOf(b6), str2);
    }
}
