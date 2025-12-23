package com.ss.android.downloadlib.addownload.j;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.downloadlib.addownload.o;
import com.ss.android.downloadlib.g;
import com.ss.android.j.j.up.a;
import com.ss.android.socialbase.appdownloader.f;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.downloader.ae;
import com.stub.StubApp;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import w2.w;

/* loaded from: D:\Downloads\app\classes6.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    private static final String f37758e = "b";

    /* renamed from: f, reason: collision with root package name */
    private static b f37759f;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private CopyOnWriteArrayList<o.e> f37760a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f37761b = false;

    /* renamed from: c, reason: collision with root package name */
    private String f37762c;

    /* renamed from: d, reason: collision with root package name */
    private e f37763d;

    class a implements a.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ss.android.xt.j.xt.b f37764a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f37765b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ o.e f37766c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ InterfaceC0746b f37767d;

        a(com.ss.android.xt.j.xt.b bVar, Context context, o.e eVar, InterfaceC0746b interfaceC0746b) {
            this.f37764a = bVar;
            this.f37765b = context;
            this.f37766c = eVar;
            this.f37767d = interfaceC0746b;
        }

        @Override // com.ss.android.j.j.up.a.c
        public void cw(DialogInterface dialogInterface) {
            b.this.j("");
        }

        @Override // com.ss.android.j.j.up.a.c
        public void j(DialogInterface dialogInterface) {
            com.ss.android.downloadlib.r.b.a().w("backdialog_install", this.f37764a);
            f.F(this.f37765b, (int) this.f37766c.f37935a);
            dialogInterface.dismiss();
        }

        @Override // com.ss.android.j.j.up.a.c
        public void xt(DialogInterface dialogInterface) {
            com.ss.android.downloadlib.r.b.a().w("backdialog_exit", this.f37764a);
            InterfaceC0746b interfaceC0746b = this.f37767d;
            if (interfaceC0746b != null) {
                interfaceC0746b.j();
            }
            b.this.j("");
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.j.b$b, reason: collision with other inner class name */
    public interface InterfaceC0746b {
        void j();
    }

    public cw b(Context context) {
        long s5;
        List<cw> xt;
        cw cwVar = null;
        try {
            s5 = g.c(context).s();
        } catch (Exception e6) {
            vl.j(e6);
        }
        if (m.f().optInt("enable_miniapp_dialog", 0) != 0 && (xt = ae.xt(context).xt("application/vnd.android.package-archive")) != null && !xt.isEmpty()) {
            long j6 = 0;
            for (cw cwVar2 : xt) {
                if (cwVar2 != null && !a.h.G(context, cwVar2.la()) && a.h.A(cwVar2.ws())) {
                    long lastModified = new File(cwVar2.ws()).lastModified();
                    if (lastModified >= s5 && cwVar2.h() != null) {
                        try {
                            if (new JSONObject(cwVar2.h()).has("isMiniApp") && (j6 == 0 || lastModified > j6)) {
                                cwVar = cwVar2;
                                j6 = lastModified;
                            }
                        } catch (Exception e7) {
                            vl.j(e7);
                        }
                    }
                }
            }
            return cwVar;
        }
        return null;
    }

    public static b a() {
        if (f37759f == null) {
            f37759f = new b();
        }
        return f37759f;
    }

    private boolean g(Activity activity, cw cwVar, boolean z5, InterfaceC0746b interfaceC0746b) {
        if (cwVar == null) {
            try {
                if (this.f37760a.isEmpty()) {
                    return false;
                }
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
        if (activity != null && !activity.isFinishing()) {
            boolean z6 = true;
            if (cwVar != null && this.f37760a.isEmpty()) {
                e(activity, new o.e(cwVar.ae(), 0L, 0L, cwVar.la(), cwVar.g(), null, cwVar.ws()), z5, interfaceC0746b);
                return true;
            }
            long lastModified = cwVar != null ? new File(cwVar.ws()).lastModified() : 0L;
            CopyOnWriteArrayList<o.e> copyOnWriteArrayList = this.f37760a;
            ListIterator<o.e> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    z6 = false;
                    break;
                }
                o.e previous = listIterator.previous();
                if (previous != null && !a.h.G(m.getContext(), previous.f37938d) && a.h.A(previous.f37941g)) {
                    if (new File(previous.f37941g).lastModified() >= lastModified) {
                        e(activity, previous, z5, interfaceC0746b);
                    } else {
                        e(activity, new o.e(cwVar.ae(), 0L, 0L, cwVar.la(), cwVar.g(), null, cwVar.ws()), z5, interfaceC0746b);
                    }
                }
            }
            a.k.d(f37758e, "tryShowInstallDialog isShow:".concat(String.valueOf(z6)), null);
            return z6;
        }
        return false;
    }

    public void c(long j6, long j7, long j8, String str, String str2, String str3, String str4) {
        for (int i6 = 0; i6 < this.f37760a.size(); i6++) {
            o.e eVar = this.f37760a.get(i6);
            if (eVar != null && eVar.f37936b == j7) {
                this.f37760a.set(i6, new o.e(j6, j7, j8, str, str2, str3, str4));
                this.f37763d.b("sp_ad_install_back_dialog", "key_uninstalled_list", this.f37760a);
                return;
            }
        }
        this.f37760a.add(new o.e(j6, j7, j8, str, str2, str3, str4));
        this.f37763d.b("sp_ad_install_back_dialog", "key_uninstalled_list", this.f37760a);
    }

    public void e(Context context, o.e eVar, boolean z5, InterfaceC0746b interfaceC0746b) {
        this.f37760a.clear();
        d(context, eVar, interfaceC0746b, z5);
        this.f37761b = true;
        g.c(context).b();
        this.f37763d.c("sp_ad_install_back_dialog", "key_uninstalled_list");
        a.k.d(f37758e, "tryShowInstallDialog isShow:true", null);
    }

    public boolean i(String str) {
        return TextUtils.equals(this.f37762c, str);
    }

    private b() {
        e eVar = new e();
        this.f37763d = eVar;
        this.f37760a = eVar.a("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    private void d(Context context, o.e eVar, InterfaceC0746b interfaceC0746b, boolean z5) {
        String str;
        String str2;
        String format;
        com.ss.android.xt.j.xt.b q5 = o.f.c().q(eVar.f37936b);
        if (q5 == null) {
            com.ss.android.downloadlib.up.a.a().c("showBackInstallDialog nativeModel null");
            return;
        }
        w d6 = m.d();
        a.b bVar = new a.b(context);
        if (z5) {
            str = "应用安装确认";
        } else {
            str = "退出确认";
        }
        a.b h6 = bVar.h(str);
        if (TextUtils.isEmpty(eVar.f37939e)) {
            str2 = "刚刚下载的应用";
        } else {
            str2 = eVar.f37939e;
        }
        a.b b6 = h6.p(String.format("%1$s下载完成，是否立即安装？", str2)).b("立即安装");
        if (z5) {
            format = "暂不安装";
        } else {
            format = String.format("退出%1$s", context.getResources().getString(StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationInfo().labelRes));
        }
        d6.xt(b6.l(format).i(false).f(a.h.l(context, eVar.f37941g)).g(new a(q5, context, eVar, interfaceC0746b)).e(1).j());
        com.ss.android.downloadlib.r.b.a().w("backdialog_show", q5);
        this.f37762c = eVar.f37938d;
    }

    public void f(com.ss.android.xt.j.xt.b bVar) {
        if (m.f().optInt("enable_open_app_dialog", 0) == 1 && !bVar.U0() && bVar.i() && Build.VERSION.SDK_INT < 34) {
            bVar.o0(true);
            TTDelegateActivity.h(bVar);
        }
    }

    @MainThread
    public boolean h(Activity activity, boolean z5, InterfaceC0746b interfaceC0746b) {
        if (m.f().optInt("disable_install_app_dialog") != 1 && !this.f37761b) {
            return g(activity, b(activity), z5, interfaceC0746b);
        }
        return false;
    }

    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f37762c = "";
        } else if (TextUtils.equals(this.f37762c, str)) {
            this.f37762c = "";
        }
    }
}
