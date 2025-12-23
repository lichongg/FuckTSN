package cn.jiguang.bx;

import android.text.TextUtils;
import cn.jiguang.api.JAction;
import cn.jiguang.api.JActionExtra;
import cn.jiguang.api.JCoreManager;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, g> f2635a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<String, JAction> f2636b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public static HashMap<String, JActionExtra> f2637c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private static final Object f2638d = new Object();

    /* renamed from: cn.jiguang.bx.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* renamed from: cn.jiguang.bx.a$a, reason: collision with other inner class name */
    private static final class C0038a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f2639a = new a(null);
    }

    private a() {
    }

    public JAction a(String str) {
        if (f2636b.containsKey(str)) {
            return f2636b.get(str);
        }
        return null;
    }

    public JActionExtra b(String str) {
        if (f2637c.containsKey(str)) {
            return f2637c.get(str);
        }
        return null;
    }

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static a a() {
        return C0038a.f2639a;
    }

    public void b(String str, String str2) {
        d.a("DispacthManager", "addActionExtra type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (!f2635a.containsKey(str)) {
            g gVar = new g();
            JCoreManager.addDispatchAction(str, g.class.getCanonicalName());
            f2635a.put(str, gVar);
        }
        if (f2637c.containsKey(str)) {
            return;
        }
        try {
            Object newInstance = Class.forName(str2).newInstance();
            if (newInstance instanceof JActionExtra) {
                f2637c.put(str, (JActionExtra) newInstance);
            }
        } catch (Throwable th) {
            d.d("DispacthManager", "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }

    public void a(String str, String str2) {
        d.a("DispacthManager", "addAction type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (!f2635a.containsKey(str)) {
            g gVar = new g();
            JCoreManager.addDispatchAction(str, g.class.getCanonicalName());
            f2635a.put(str, gVar);
        }
        if (f2636b.containsKey(str)) {
            return;
        }
        try {
            Object newInstance = Class.forName(str2).newInstance();
            if (newInstance instanceof JAction) {
                f2636b.put(str, (JAction) newInstance);
            }
        } catch (Throwable th) {
            d.d("DispacthManager", "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }
}
