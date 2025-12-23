package cn.jiguang.internal;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.bb.f;
import cn.jiguang.by.d;
import cn.jiguang.dy.b;
import cn.jpush.android.service.JCommonService;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\Downloads\app\classes2.dex */
public class JCoreInternalHelper {
    private static final String TAG = "JCoreInternalHelper";
    private static JCoreHelperAction jCoreHelperAction;
    private AtomicReference<JCoreHelperAction> localJCoreHelperAction;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final JCoreInternalHelper f3056a = new JCoreInternalHelper();
    }

    private JCoreInternalHelper() {
        this.localJCoreHelperAction = new AtomicReference<>();
    }

    public synchronized void initLoad(Context context) {
        if (jCoreHelperAction != null) {
            return;
        }
        if (context == null) {
            return;
        }
        try {
            b.a().a(context, 1);
        } catch (Throwable th) {
            f.c(TAG, "load d y failed :" + th.getMessage());
        }
        if (jCoreHelperAction == null) {
            f.c(TAG, "load action by local");
            jCoreHelperAction = new cn.jiguang.c.b();
        }
    }

    public Object commonMethod(final Context context, final String str, final Object obj) {
        JCoreHelperAction jCoreHelperAction2 = jCoreHelperAction;
        if (jCoreHelperAction2 != null) {
            return jCoreHelperAction2.onCommonMethod(context, str, obj);
        }
        d.a("ONCE_TASK", new cn.jiguang.by.b("JCoreInternalHelper#commonMethod") { // from class: cn.jiguang.internal.JCoreInternalHelper.3
            @Override // cn.jiguang.by.b
            public void a() {
                try {
                    JCoreInternalHelper.this.initLoad(context);
                    JCoreInternalHelper.jCoreHelperAction.onCommonMethod(context, str, obj);
                } catch (Throwable th) {
                    f.i(JCoreInternalHelper.TAG, "commonMethod e:" + th);
                }
            }
        });
        return null;
    }

    public Object onEvent(final Context context, final String str, final int i6, boolean z5, final String str2, final Bundle bundle, final Object... objArr) {
        if (z5) {
            d.a("DYNAMIC_LOAD_TASK", new cn.jiguang.by.b("JCoreInternalHelper#onEvent") { // from class: cn.jiguang.internal.JCoreInternalHelper.1
                @Override // cn.jiguang.by.b
                public void a() {
                    try {
                        JCoreInternalHelper.this.initLoad(context);
                        JCoreInternalHelper.jCoreHelperAction.onEvent(context, str, i6, str2, bundle, objArr);
                    } catch (Throwable th) {
                        f.i(JCoreInternalHelper.TAG, "onEvent e:" + th);
                    }
                }
            }, !cn.jiguang.c.b.f2800a.contains(Integer.valueOf(i6)));
            return null;
        }
        JCoreHelperAction jCoreHelperAction2 = jCoreHelperAction;
        if (jCoreHelperAction2 != null) {
            return jCoreHelperAction2.onEvent(context, str, i6, str2, bundle, objArr);
        }
        JCoreHelperAction jCoreHelperAction3 = this.localJCoreHelperAction.get();
        if (jCoreHelperAction3 == null) {
            jCoreHelperAction3 = new cn.jiguang.c.b();
            this.localJCoreHelperAction.set(jCoreHelperAction3);
        }
        return jCoreHelperAction3.onEvent(context, str, i6, str2, bundle, objArr);
    }

    public static JCoreInternalHelper getInstance() {
        return a.f3056a;
    }

    public Bundle directHandle(final Context context, final String str, final String str2, final Bundle bundle) {
        try {
            if (JCommonService.class.isAssignableFrom(Class.forName(str))) {
                getInstance().onEvent(context, JConstants.SDK_TYPE, 2, true, str2, bundle, new Object[0]);
                return new Bundle();
            }
        } catch (ClassNotFoundException unused) {
        }
        d.a("DYNAMIC_LOAD_TASK", new cn.jiguang.by.b("JCoreInternalHelper#directHandle") { // from class: cn.jiguang.internal.JCoreInternalHelper.2
            @Override // cn.jiguang.by.b
            public void a() {
                JCoreHelperAction jCoreHelperAction2;
                Context context2;
                String str3;
                String str4;
                try {
                    if (JCoreInternalHelper.jCoreHelperAction != null) {
                        jCoreHelperAction2 = JCoreInternalHelper.jCoreHelperAction;
                        context2 = context;
                        str3 = str;
                        str4 = str2;
                    } else {
                        JCoreInternalHelper.this.initLoad(context);
                        jCoreHelperAction2 = JCoreInternalHelper.jCoreHelperAction;
                        context2 = context;
                        str3 = str;
                        str4 = str2;
                    }
                    jCoreHelperAction2.directHandle(context2, str3, str4, bundle);
                } catch (Throwable th) {
                    f.i(JCoreInternalHelper.TAG, "directHandle e:" + th);
                }
            }
        });
        return new Bundle();
    }
}
