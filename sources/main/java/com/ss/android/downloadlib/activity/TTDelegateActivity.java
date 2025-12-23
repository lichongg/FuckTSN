package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.addownload.j.d;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.downloadlib.addownload.o;
import com.ss.android.downloadlib.g;
import com.ss.android.downloadlib.j;
import com.ss.android.j.j.up.a;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.downloader.ae;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import w2.t;
import w2.w;

/* loaded from: D:\Downloads\app\classes6.dex */
public class TTDelegateActivity extends Activity {

    /* renamed from: d, reason: collision with root package name */
    private static com.ss.android.downloadlib.guide.install.a f37593d;

    /* renamed from: a, reason: collision with root package name */
    protected Intent f37594a = null;

    /* renamed from: b, reason: collision with root package name */
    private boolean f37595b;

    /* renamed from: c, reason: collision with root package name */
    private com.ss.android.xt.j.xt.b f37596c;

    class a implements t {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<Activity> f37597a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f37598b;

        @Override // w2.t
        public void j() {
            a.j.b(this.f37598b);
            com.ss.android.socialbase.appdownloader.b.u(this.f37597a.get());
        }

        a(String str) {
            this.f37598b = str;
            this.f37597a = new WeakReference<>(TTDelegateActivity.this);
        }

        @Override // w2.t
        public void j(String str) {
            a.j.d(this.f37598b, str);
            com.ss.android.socialbase.appdownloader.b.u(this.f37597a.get());
        }
    }

    class b implements a.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ss.android.xt.j.xt.b f37600a;

        b(com.ss.android.xt.j.xt.b bVar) {
            this.f37600a = bVar;
        }

        @Override // com.ss.android.j.j.up.a.c
        public void cw(DialogInterface dialogInterface) {
            com.ss.android.socialbase.appdownloader.b.u(TTDelegateActivity.this);
        }

        @Override // com.ss.android.j.j.up.a.c
        public void j(DialogInterface dialogInterface) {
            j.g.j(this.f37600a);
            TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
            if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                dialogInterface.dismiss();
            }
            com.ss.android.socialbase.appdownloader.b.u(TTDelegateActivity.this);
        }

        @Override // com.ss.android.j.j.up.a.c
        public void xt(DialogInterface dialogInterface) {
            com.ss.android.downloadlib.r.b.a().w("market_openapp_cancel", this.f37600a);
            TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
            if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                dialogInterface.dismiss();
            }
            com.ss.android.socialbase.appdownloader.b.u(TTDelegateActivity.this);
        }
    }

    static {
        StubApp.interface11(41121);
    }

    public static void w(@NonNull com.ss.android.xt.j.xt.a aVar, String str, String str2, String str3) {
        i(aVar, 7, str, str2, str3, "");
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    @Override // android.app.Activity
    public native void onRequestPermissionsResult(int i6, @NonNull String[] strArr, @NonNull int[] iArr);

    private static Intent a(@NonNull com.ss.android.xt.j.xt.a aVar) {
        return new Intent(m.getContext(), (Class<?>) TTDelegateActivity.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.activity.TTDelegateActivity.b():void");
    }

    private void c(long j6) {
        new com.ss.android.downloadlib.addownload.compliance.b(this, j6).show();
    }

    public static void e(long j6) {
        Intent intent = new Intent(m.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j6);
        if (m.getContext() != null) {
            m.getContext().startActivity(intent);
        }
    }

    public static void g(Context context, String str, long j6) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 16);
        intent.putExtra(bi.f40972o, str);
        intent.putExtra("model_id", j6);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public static void k(@NonNull com.ss.android.xt.j.xt.a aVar, String str) {
        i(aVar, 19, "", "", "", str);
    }

    public static void l(@NonNull com.ss.android.xt.j.xt.a aVar, String str, String str2, String str3) {
        i(aVar, 8, str, str2, str3, "");
    }

    public static void m(@NonNull com.ss.android.xt.j.xt.a aVar, String str, String str2, String str3, String str4) {
        i(aVar, 21, str, str2, str3, str4);
    }

    public static void o(String str, long j6) {
        Intent intent = new Intent(m.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 15);
        intent.putExtra(bi.f40972o, str);
        intent.putExtra("model_id", j6);
        if (m.getContext() != null) {
            m.getContext().startActivity(intent);
        }
    }

    public static void p(String str, long j6, String str2) {
        Intent intent = new Intent(m.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 13);
        intent.putExtra(bi.f40972o, str);
        intent.putExtra("model_id", j6);
        intent.putExtra("need_comment", str2);
        if (m.getContext() != null) {
            m.getContext().startActivity(intent);
        }
    }

    public static void q(String str, long j6, String str2, @NonNull JSONObject jSONObject) {
        Intent intent = new Intent(m.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 12);
        intent.putExtra(bi.f40972o, str);
        intent.putExtra("model_id", j6);
        intent.putExtra("param", str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (m.getContext() != null) {
            m.getContext().startActivity(intent);
        }
    }

    public static void s(String str, String[] strArr) {
        Intent intent = new Intent(m.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (m.getContext() != null) {
            m.getContext().startActivity(intent);
        }
    }

    public static void v(@NonNull com.ss.android.xt.j.xt.a aVar) {
        i(aVar, 5, "", "", "", "");
    }

    public static void x(@NonNull com.ss.android.xt.j.xt.a aVar, String str, String str2, String str3, String str4) {
        i(aVar, 20, str, str2, str3, str4);
    }

    public static void z(String str, long j6, String str2) {
        Intent intent = new Intent(m.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 14);
        intent.putExtra(bi.f40972o, str);
        intent.putExtra("model_id", j6);
        intent.putExtra("market_app_id", str2);
        if (m.getContext() != null) {
            m.getContext().startActivity(intent);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void d() {
        TTDelegateActivity tTDelegateActivity;
        Intent intent = this.f37594a;
        if (intent != null) {
            switch (intent.getIntExtra("type", 0)) {
                case 1:
                    tTDelegateActivity = this;
                    B(tTDelegateActivity.f37594a.getStringExtra("permission_id_key"), tTDelegateActivity.f37594a.getStringArrayExtra("permission_content_key"));
                    break;
                case 2:
                    tTDelegateActivity = this;
                    n(tTDelegateActivity.f37594a.getStringExtra("open_url"));
                    break;
                case 3:
                case 6:
                case 17:
                case 18:
                default:
                    tTDelegateActivity = this;
                    com.ss.android.socialbase.appdownloader.b.u(this);
                    break;
                case 4:
                    tTDelegateActivity = this;
                    u(tTDelegateActivity.f37594a.getLongExtra("model_id", 0L));
                    break;
                case 5:
                    tTDelegateActivity = this;
                    f(tTDelegateActivity.f37594a.getLongExtra("model_id", 0L), "");
                    break;
                case 7:
                case 8:
                case 20:
                case 21:
                    tTDelegateActivity = this;
                    b();
                    break;
                case 9:
                    tTDelegateActivity = this;
                    com.ss.android.downloadlib.guide.install.a aVar = f37593d;
                    if (aVar != null) {
                        aVar.j();
                    }
                    com.ss.android.socialbase.appdownloader.b.u(this);
                    break;
                case 10:
                    tTDelegateActivity = this;
                    c(tTDelegateActivity.f37594a.getLongExtra("app_info_id", 0L));
                    break;
                case 11:
                    tTDelegateActivity = this;
                    y(tTDelegateActivity.f37594a.getStringExtra(bi.f40972o));
                    break;
                case 12:
                    tTDelegateActivity = this;
                    a.m.t(tTDelegateActivity, this.f37594a.getStringExtra(bi.f40972o), this.f37594a.getLongExtra("model_id", 0L), this.f37594a.getStringExtra("param"), this.f37594a.getStringExtra("ext_json"));
                    com.ss.android.socialbase.appdownloader.b.u(this);
                    break;
                case 13:
                    a.m.s(this, this.f37594a.getStringExtra(bi.f40972o), this.f37594a.getLongExtra("model_id", 0L), this.f37594a.getStringExtra("need_comment"));
                    tTDelegateActivity = this;
                    com.ss.android.socialbase.appdownloader.b.u(this);
                    break;
                case 14:
                    a.m.N(this, this.f37594a.getStringExtra(bi.f40972o), this.f37594a.getLongExtra("model_id", 0L), this.f37594a.getStringExtra("market_app_id"));
                    tTDelegateActivity = this;
                    com.ss.android.socialbase.appdownloader.b.u(this);
                    break;
                case 15:
                    a.m.r(this, this.f37594a.getStringExtra(bi.f40972o), this.f37594a.getLongExtra("model_id", 0L));
                    tTDelegateActivity = this;
                    com.ss.android.socialbase.appdownloader.b.u(this);
                    break;
                case 16:
                    a.m.M(this, this.f37594a.getStringExtra(bi.f40972o), this.f37594a.getLongExtra("model_id", 0L));
                    tTDelegateActivity = this;
                    com.ss.android.socialbase.appdownloader.b.u(this);
                    break;
                case 19:
                    f(this.f37594a.getLongExtra("model_id", 0L), this.f37594a.getStringExtra("delete_button_text"));
                    tTDelegateActivity = this;
                    break;
            }
            tTDelegateActivity.f37594a = null;
        }
    }

    public static void A(String str, com.ss.android.xt.j.xt.a aVar) {
        Intent a6 = a(aVar);
        a6.addFlags(268435456);
        a6.putExtra("type", 11);
        a6.putExtra(bi.f40972o, str);
        if (m.getContext() != null) {
            m.getContext().startActivity(a6);
        }
    }

    private void B(String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            a aVar = new a(str);
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    m.E().j(this, strArr, aVar);
                    return;
                } catch (Exception e6) {
                    m.w().j(e6, "requestPermission");
                }
            }
            aVar.j();
            return;
        }
        com.ss.android.socialbase.appdownloader.b.u(this);
    }

    private void f(long j6, String str) {
        if (com.ss.android.downloadlib.addownload.b.a() == null) {
            return;
        }
        com.ss.android.xt.j.xt.b q5 = o.f.c().q(j6);
        if (q5 != null) {
            cw tl = ae.xt(m.getContext()).tl(q5.mi());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - q5.k()));
                jSONObject.putOpt("click_download_size", Long.valueOf(q5.s()));
                if (tl != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(tl.uq()));
                    jSONObject.putOpt("download_percent", Long.valueOf(tl.uq() / tl.ka()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(tl.ka()));
                    jSONObject.putOpt("download_current_bytes", Integer.valueOf((int) (tl.uq() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED)));
                    jSONObject.putOpt("download_total_bytes", Integer.valueOf((int) (tl.ka() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED)));
                }
            } catch (Exception e6) {
                vl.j(e6);
            }
            if (!TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.r.b.a().r("cancel_pause_reserve_wifi_dialog_show", jSONObject, q5);
            } else {
                com.ss.android.downloadlib.r.b.a().x("pause_reserve_wifi_dialog_show", jSONObject, q5);
            }
        }
        d.C0747d c6 = new d.C0747d(this).e(false).c(com.ss.android.downloadlib.addownload.b.a());
        if (!TextUtils.isEmpty(str)) {
            c6.g(str).b(com.ss.android.downloadlib.addownload.b.f());
        }
        c6.f().show();
        this.f37595b = true;
        this.f37596c = q5;
    }

    public static void h(com.ss.android.xt.j.xt.a aVar) {
        Intent a6 = a(aVar);
        a6.addFlags(268435456);
        a6.putExtra("type", 4);
        a6.putExtra("model_id", aVar.xt());
        if (m.getContext() != null) {
            m.getContext().startActivity(a6);
        }
    }

    private static void i(@NonNull com.ss.android.xt.j.xt.a aVar, int i6, String str, String str2, String str3, String str4) {
        Intent a6 = a(aVar);
        a6.addFlags(268435456);
        a6.putExtra("type", i6);
        if (!TextUtils.isEmpty(str2)) {
            a6.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            a6.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            a6.putExtra("delete_button_text", str4);
        }
        if (!TextUtils.isEmpty(str)) {
            a6.putExtra("message_text", str);
        }
        a6.putExtra("model_id", aVar.xt());
        if (m.getContext() != null) {
            m.getContext().startActivity(a6);
        }
    }

    public static void j(com.ss.android.xt.j.xt.a aVar, com.ss.android.downloadlib.guide.install.a aVar2) {
        Intent a6 = a(aVar);
        a6.addFlags(268435456);
        a6.putExtra("type", 9);
        f37593d = aVar2;
        if (m.getContext() != null) {
            m.getContext().startActivity(a6);
        }
    }

    private void n(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                com.ss.android.socialbase.appdownloader.b.u(this);
                return;
            }
            try {
                Uri parse = Uri.parse(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.putExtra("open_url", str);
                intent.addFlags(268435456);
                if (com.ss.android.socialbase.downloader.jy.j.cw().j("fix_app_link_flag")) {
                    intent.addFlags(67108864);
                }
                intent.putExtra("start_only_for_android", true);
                startActivity(intent);
                com.ss.android.socialbase.appdownloader.b.u(this);
            } catch (Exception e6) {
                vl.j(e6);
                com.ss.android.socialbase.appdownloader.b.u(this);
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.appdownloader.b.u(this);
            throw th;
        }
    }

    public static void r(String str, com.ss.android.xt.j.xt.a aVar) {
        Intent a6 = a(aVar);
        a6.addFlags(268435456);
        a6.putExtra("type", 2);
        a6.putExtra("open_url", str);
        if (m.getContext() != null) {
            m.getContext().startActivity(a6);
        }
    }

    private void t() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void u(long j6) {
        String a02;
        com.ss.android.xt.j.xt.b q5 = o.f.c().q(j6);
        if (q5 == null) {
            com.ss.android.downloadlib.up.a.a().c("showOpenAppDialogInner nativeModel null");
            com.ss.android.socialbase.appdownloader.b.u(this);
            return;
        }
        w d6 = m.d();
        a.b h6 = new a.b(this).h("已安装完成");
        if (TextUtils.isEmpty(q5.a0())) {
            a02 = "刚刚下载的应用";
        } else {
            a02 = q5.a0();
        }
        d6.xt(h6.p(String.format("%1$s已安装完成，是否立即打开？", a02)).b("打开").l("取消").i(false).f(a.h.E(this, q5.up())).g(new b(q5)).e(2).j());
        com.ss.android.downloadlib.r.b.a().w("market_openapp_window_show", q5);
    }

    private void y(String str) {
        Intent a6 = a.h.a(this, str);
        if (a6 == null) {
            return;
        }
        try {
            a6.addFlags(268435456);
            a6.putExtra("start_only_for_android", true);
            startActivity(a6);
        } catch (Exception e6) {
            vl.j(e6);
        } finally {
            com.ss.android.socialbase.appdownloader.b.u(this);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f37594a = intent;
        m.L(this);
        d();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com.ss.android.xt.j.xt.b bVar;
        cw u5;
        super.onStop();
        if (this.f37595b && (bVar = this.f37596c) != null) {
            if (!TextUtils.isEmpty(bVar.h())) {
                u5 = g.c(m.getContext()).e(this.f37596c.h(), null, true);
            } else {
                u5 = g.c(m.getContext()).u(this.f37596c.j());
            }
            if (u5 != null && u5.uq() >= u5.ka() && !isFinishing()) {
                finish();
            }
        }
    }
}
