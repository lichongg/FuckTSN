package cn.jpush.android.o;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import cn.jpush.android.ad.f;
import cn.jpush.android.ad.g;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.r.d;
import cn.jpush.android.s.c;
import cn.jpush.android.u.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a implements b.a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f3742a;

    /* renamed from: b, reason: collision with root package name */
    private b f3743b;

    /* renamed from: d, reason: collision with root package name */
    private c f3745d;

    /* renamed from: e, reason: collision with root package name */
    private String f3746e;

    /* renamed from: c, reason: collision with root package name */
    private d f3744c = new d();

    /* renamed from: f, reason: collision with root package name */
    private List<String> f3747f = new ArrayList();

    /* renamed from: cn.jpush.android.o.a$a, reason: collision with other inner class name */
    public static class C0056a extends f {

        /* renamed from: a, reason: collision with root package name */
        Context f3751a;

        /* renamed from: b, reason: collision with root package name */
        cn.jpush.android.d.d f3752b;

        @Override // cn.jpush.android.ad.f
        public void a() {
            cn.jpush.android.q.a a6;
            Context context;
            cn.jpush.android.d.d dVar;
            String str;
            try {
                if (a.o(this.f3751a, this.f3752b)) {
                    a6 = cn.jpush.android.q.a.a();
                    context = this.f3751a;
                    dVar = this.f3752b;
                    str = "cn.jpush.android.intent.NOTIFY_INAPP_MESSAGE_ARRIVED";
                } else {
                    cn.jpush.android.q.a.a().a(this.f3751a, false);
                    a6 = cn.jpush.android.q.a.a();
                    context = this.f3751a;
                    dVar = this.f3752b;
                    str = "handle_message_failed";
                }
                a6.b(context, dVar, str);
            } catch (Throwable th) {
                Logger.ww("InAppManager", "notify inapp handle failed, " + th.getMessage());
            }
        }

        public C0056a(Context context, cn.jpush.android.d.d dVar) {
            this.f3751a = context;
            this.f3752b = dVar;
        }
    }

    public static a a() {
        if (f3742a == null) {
            synchronized (a.class) {
                try {
                    if (f3742a == null) {
                        f3742a = new a();
                    }
                } finally {
                }
            }
        }
        return f3742a;
    }

    private void b(Context context) {
        try {
            if (context == null) {
                Logger.w("InAppManager", "dealNextCacheMessage param is null, context: " + context);
                return;
            }
            if (!cn.jpush.android.ad.a.j(context) || c()) {
                return;
            }
            cn.jpush.android.q.a.a().a(context, (Bundle) null, "handle_cache_message");
        } catch (Throwable th) {
            Logger.d("InAppManager", "handleNextCacheMessage  throwable=" + th);
        }
    }

    private void c(Context context) {
        try {
            d();
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                d(context);
            } else {
                cn.jpush.android.q.a.a().b(context, this.f3743b.j(), 1003);
            }
        } catch (Throwable th) {
            Logger.w("InAppManager", "notify inapp dismiss failed, " + th.getMessage());
        }
    }

    private void d() {
        if (this.f3745d != null) {
            Logger.d("InAppManager", "cancel js load timer");
            this.f3745d.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean o(Context context, cn.jpush.android.d.d dVar) {
        if (context == null || dVar == null) {
            Logger.w("InAppManager", "notify inapp handle param is null");
            return false;
        }
        if ((40 == dVar.bt ? cn.jpush.android.r.c.a(context, dVar) : cn.jpush.android.r.c.b(context, dVar)) != null) {
            return true;
        }
        Logger.ww("InAppManager", "notify inapp tpl dl failed");
        return false;
    }

    private void d(Context context) {
        if (this.f3744c == null || this.f3743b == null) {
            Logger.d("InAppManager", "notify inapp destroy wm is null");
            return;
        }
        try {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                this.f3744c.b(context, this.f3743b);
                this.f3743b.a((b.a) null);
                this.f3743b = null;
            } else {
                cn.jpush.android.q.a.a().b(context, this.f3743b.j(), 1003);
            }
            Logger.d("InAppManager", "notify inapp release completed");
        } catch (Throwable th) {
            Logger.w("InAppManager", "notify inapp release failed, " + th.getMessage());
        }
    }

    private void i(final Context context, final cn.jpush.android.d.d dVar) {
        Logger.d("InAppManager", "start h5 load timeout timer listener");
        d();
        c cVar = new c();
        this.f3745d = cVar;
        cVar.a(new c.a() { // from class: cn.jpush.android.o.a.1
            @Override // cn.jpush.android.s.c.a
            public void a() {
                Logger.ww("InAppManager", "js load callback timeout");
                a.this.f(context, dVar);
            }
        }, 10000L, 1000L);
    }

    private void j(Context context, cn.jpush.android.d.d dVar) {
        try {
            Logger.d("InAppManager", "handleCancelMessage  msgId=" + dVar.f3588d);
            if (40 == dVar.bt) {
                cn.jpush.android.helper.c.a(dVar.f3588d, 1602L, context);
            } else {
                cn.jpush.android.helper.c.a(context, dVar.f3588d, 2000L, 4);
            }
        } catch (Throwable th) {
            Logger.d("InAppManager", "handleCancelMessage  throwable=" + th);
        }
    }

    private void k(Context context, cn.jpush.android.d.d dVar) {
        try {
            Logger.d("InAppManager", "handleShowSuccess  msgId=" + dVar.f3588d);
            cn.jpush.android.x.b.a(context, JPushInterface.ACTION_IN_APP_MSG_SHOW, dVar, (Intent) null);
            n(context, dVar);
            if (40 != dVar.bt) {
                this.f3743b.d();
                if (30 == dVar.bt) {
                    cn.jpush.android.q.a.a().a(context, dVar, 1005);
                }
            }
            l(context, dVar);
            this.f3747f.add(dVar.f3588d);
            a(context, true);
            cn.jpush.android.r.b.a(context, dVar.bb);
        } catch (Throwable th) {
            Logger.d("InAppManager", "handleCancelMessage  throwable=" + th);
        }
    }

    private void l(Context context, cn.jpush.android.d.d dVar) {
        int i6 = dVar.bt;
        String str = dVar.f3588d;
        if (40 == i6) {
            cn.jpush.android.helper.c.a(str, 1600L, context);
        } else {
            cn.jpush.android.helper.c.a(context, str, 3000L, 4);
        }
    }

    private void m(Context context, cn.jpush.android.d.d dVar) {
        int i6 = dVar.bt;
        String str = dVar.f3588d;
        if (40 == i6) {
            cn.jpush.android.helper.c.a(str, 1604L, context);
        } else {
            cn.jpush.android.helper.c.a(context, str, 3012L, 4);
        }
    }

    private void n(Context context, cn.jpush.android.d.d dVar) {
        try {
            if (context == null || dVar == null) {
                Logger.w("InAppManager", "checkIsNeedSeedToNotification  context: " + context);
                return;
            }
            if (dVar.az == 104) {
                Logger.d("InAppManager", "start process notify message, msgType: " + dVar.az + ", processName: " + cn.jpush.android.ad.a.d(context));
                Bundle bundle = new Bundle();
                bundle.putString("content", dVar.c());
                cn.jpush.android.q.a.a().a(context, bundle, "handle_notify_inapp_message");
            }
        } catch (Throwable th) {
            Logger.d("InAppManager", "checkIsNeedSeedToNotification  throwable=" + th);
        }
    }

    public void a(Context context) {
        if (context != null) {
            d(context);
        }
        cn.jpush.android.q.a.a().a(1005);
    }

    public void b(Context context, cn.jpush.android.d.d dVar) {
        try {
            if (context == null || dVar == null) {
                Logger.w("InAppManager", "notify inapp not display, param is null, context: " + context);
                f(context, dVar);
                return;
            }
            if (!cn.jpush.android.ad.a.j(context)) {
                Logger.ww("InAppManager", "notify inapp not display in background");
                return;
            }
            if (cn.jpush.android.x.d.a(context, dVar.f3588d, "", dVar.f3585a)) {
                Logger.dd("InAppManager", "notify inapp is canceled already, not to show");
                j(context, dVar);
                return;
            }
            Activity a6 = cn.jpush.android.s.a.a(context);
            try {
                if (!TextUtils.isEmpty(dVar.bS) && !TextUtils.equals(dVar.bS, this.f3746e)) {
                    Logger.dd("InAppManager", "notify inapp not target activity,not to show");
                    return;
                }
            } catch (Throwable unused) {
            }
            if (a6 == null || !this.f3744c.a(a6, this.f3743b)) {
                Logger.ww("InAppManager", "notify inapp message display failed");
                f(context, dVar);
            } else {
                Logger.dd("InAppManager", "notify inapp message display success");
                k(context, dVar);
            }
        } catch (Throwable th) {
            f(context, dVar);
            Logger.ww("InAppManager", "notify inapp show failed" + th.getMessage());
        }
    }

    public void c(Context context, cn.jpush.android.d.d dVar) {
        b bVar;
        cn.jpush.android.d.d j6;
        if (context == null || dVar == null) {
            return;
        }
        String str = dVar.f3588d;
        if (!c() || (bVar = this.f3743b) == null || (j6 = bVar.j()) == null) {
            return;
        }
        Logger.d("InAppManager", "notify inapp cancel, cancel_messageId: " + str + ", msgId: " + j6.f3588d);
        if (TextUtils.equals(str, j6.f3588d)) {
            cn.jpush.android.q.a.a().b(context, j6, 1003);
            cn.jpush.android.helper.c.a(str, 1602L, context);
            b(context);
            cn.jpush.android.p.a.a(context, System.currentTimeMillis());
        }
    }

    public void e(Context context, cn.jpush.android.d.d dVar) {
        try {
            Logger.d("InAppManager", "handleMessageFailed  msgId=" + dVar.f3588d);
            n(context, dVar);
            m(context, dVar);
            b(context);
        } catch (Throwable th) {
            Logger.d("InAppManager", "handleMessageFailed  throwable=" + th);
        }
    }

    public void f(Context context, cn.jpush.android.d.d dVar) {
        try {
            Logger.d("InAppManager", "handleShowFailed  msgId=" + dVar.f3588d);
            a(context, false);
            n(context, dVar);
            c(context);
            m(context, dVar);
            b(context);
        } catch (Throwable th) {
            Logger.d("InAppManager", "handleShowFailed  throwable=" + th);
        }
    }

    public void g(Context context, cn.jpush.android.d.d dVar) {
        try {
            b bVar = this.f3743b;
            if (bVar != null) {
                bVar.g();
                cn.jpush.android.q.a.a().a(context, dVar, 1005);
            }
        } catch (Throwable th) {
            Logger.d("InAppManager", "handleCancelMessage  throwable=" + th);
        }
    }

    @Override // cn.jpush.android.u.b.a
    public void a(Context context, View view) {
    }

    public void b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.w("InAppManager", "[cancelNotifyInApp] unexpected param is null, cancelIds: " + str);
            return;
        }
        String[] split = str.split(",");
        int length = split.length;
        for (int i6 = 0; i6 < length; i6++) {
            String str2 = split[i6];
            if (!TextUtils.isEmpty(str2)) {
                cn.jpush.android.d.d a6 = cn.jpush.android.p.b.a().a(str2);
                if (cn.jpush.android.p.b.a().c(str2)) {
                    if (split.length == 2) {
                        str2 = split[1];
                    }
                    if (a6 == null || 40 == a6.bt) {
                        cn.jpush.android.helper.c.a(str2, 1602L, context);
                    } else {
                        cn.jpush.android.helper.c.a(context, str2, 4005L, 4);
                    }
                } else {
                    cn.jpush.android.d.d dVar = new cn.jpush.android.d.d();
                    dVar.f3588d = str2;
                    cn.jpush.android.x.b.a(context, "cn.jpush.android.intent.NOTIFY_INAPP_MESSAGE_CANCEL", dVar, (Intent) null);
                }
            }
        }
    }

    public boolean c() {
        d dVar = this.f3744c;
        return dVar != null && dVar.b(this.f3743b);
    }

    public void d(Context context, cn.jpush.android.d.d dVar) {
        Logger.dd("InAppManager", "notify inapp click");
        if (dVar != null) {
            g.a().a(context, dVar);
        }
        cn.jpush.android.p.a.a(context, System.currentTimeMillis());
        c(context);
        b(context);
    }

    @Override // cn.jpush.android.u.b.a
    public void a(Context context, View view, Object obj) {
        Logger.dd("InAppManager", "notify inapp dismiss");
        cn.jpush.android.q.a.a().a(1005);
        cn.jpush.android.p.a.a(context, System.currentTimeMillis());
        c(context);
        b(context);
    }

    public boolean b() {
        StringBuilder sb = new StringBuilder();
        sb.append("hadDeleteMessage size=");
        sb.append(this.f3747f.size() > 0);
        Logger.d("InAppManager", sb.toString());
        return this.f3747f.size() > 0;
    }

    public void a(Context context, cn.jpush.android.d.d dVar) {
        String str;
        Logger.dd("InAppManager", "notify inapp inflate start");
        if (context == null || dVar == null) {
            str = "notify inapp inflate failed, param is null, context: " + context;
        } else {
            try {
                cn.jpush.android.r.b.a(context, dVar, dVar.bt);
                if (c()) {
                    Logger.d("InAppManager", "notify inapp is showing now, return ");
                    return;
                }
                cn.jpush.android.t.a a6 = cn.jpush.android.r.b.a(context, dVar.bt);
                if (a6 == null) {
                    f(context, dVar);
                    Logger.w("InAppManager", "notify inapp inflate failed, layout config is null");
                    return;
                }
                b a7 = b.a(context, a6, dVar, dVar.bt);
                this.f3743b = a7;
                if (!a7.f()) {
                    f(context, dVar);
                    Logger.ww("InAppManager", "notify inapp inflate failed");
                    return;
                }
                this.f3743b.a(this);
                if (40 != dVar.bt) {
                    Logger.dd("InAppManager", "inapp start to show native");
                    cn.jpush.android.q.a.a().b(context, dVar, 1002);
                } else {
                    Logger.dd("InAppManager", "inapp start to show js web");
                    i(context, dVar);
                }
                Logger.dd("InAppManager", "notify inapp inflate succeed");
                return;
            } catch (Throwable th) {
                f(context, dVar);
                str = "inflateNotifyInApp failed, " + th.getMessage();
            }
        }
        Logger.w("InAppManager", str);
    }

    public void a(Context context, cn.jpush.android.d.d dVar, boolean z5) {
        d();
        if (context != null && dVar != null && z5) {
            Logger.dd("InAppManager", "notify inapp tpl load success will display");
            cn.jpush.android.q.a.a().b(context, dVar, 1002);
            return;
        }
        f(context, dVar);
        Logger.w("InAppManager", "notify inapp  load failed");
        Logger.d("InAppManager", "onLoadFail state, context: " + context + ", isSuccess: " + z5 + ", entity: " + dVar);
    }

    public void a(Context context, String str) {
        d dVar;
        if (context == null || (dVar = this.f3744c) == null || this.f3743b == null || !dVar.a(str) || !this.f3744c.a(this.f3743b)) {
            return;
        }
        Logger.d("InAppManager", "[onActivityDestroy] dismiss showing notify inapp, activityName: " + str);
        c(context);
    }

    public void a(Context context, boolean z5) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("result", z5);
        cn.jpush.android.q.a.a().a(context, bundle, "sync_view_show_success");
    }

    public void a(Context context, boolean z5, String str) {
        Logger.d("InAppManager", "onForegroundStateChange isForeground=" + z5 + " currentActivity=" + str);
        this.f3747f.clear();
        this.f3746e = str;
        cn.jpush.android.p.a.a(context, -1L);
        a(context);
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("targert", str);
        }
        cn.jpush.android.q.a.a().a(context, bundle, "sync_target");
        if (z5) {
            Logger.d("InAppManager", "change to foreground, deal cache notify inapp");
            cn.jpush.android.q.a.a().a(context, (Bundle) null, "handle_cache_message");
        }
    }
}
