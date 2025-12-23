package com.ss.android.downloadlib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.PeriodicWorkRequest;
import com.amap.api.services.core.AMapException;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.addownload.o;
import com.ss.android.downloadlib.up.b;
import com.ss.android.j.j.up.a;
import com.ss.android.socialbase.downloader.j.j;
import com.ss.android.socialbase.downloader.notification.xt;
import com.ss.android.xt.j.j.b;
import com.ss.android.xt.j.j.c;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class j implements z2.b {

    /* renamed from: b, reason: collision with root package name */
    private static String f38127b = "j";

    /* renamed from: c, reason: collision with root package name */
    private static volatile j f38128c;

    /* renamed from: a, reason: collision with root package name */
    private com.ss.android.downloadlib.g f38129a = com.ss.android.downloadlib.g.c(com.ss.android.downloadlib.addownload.m.getContext());

    class a implements b.InterfaceC0764b<Dialog> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f38130a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f38131b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f38132c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.b f38133d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.g f38134e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.c f38135f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.e f38136g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f38137h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f38138i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ w2.h f38139j;

        a(Context context, String str, boolean z5, com.ss.android.j.j.cw.b bVar, com.ss.android.j.j.cw.g gVar, com.ss.android.j.j.cw.c cVar, com.ss.android.j.j.cw.e eVar, int i6, boolean z6, w2.h hVar) {
            this.f38130a = context;
            this.f38131b = str;
            this.f38132c = z5;
            this.f38133d = bVar;
            this.f38134e = gVar;
            this.f38135f = cVar;
            this.f38136g = eVar;
            this.f38137h = i6;
            this.f38138i = z6;
            this.f38139j = hVar;
        }

        @Override // com.ss.android.downloadlib.up.b.InterfaceC0764b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Dialog xt() {
            return j.this.n(this.f38130a, this.f38131b, this.f38132c, this.f38133d, this.f38134e, this.f38135f, this.f38136g, this.f38137h, this.f38138i, this.f38139j);
        }
    }

    class b implements a.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.b f38141a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.g f38142b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.c f38143c;

        b(com.ss.android.j.j.cw.b bVar, com.ss.android.j.j.cw.g gVar, com.ss.android.j.j.cw.c cVar) {
            this.f38141a = bVar;
            this.f38142b = gVar;
            this.f38143c = cVar;
        }

        @Override // com.ss.android.j.j.up.a.c
        public void j(DialogInterface dialogInterface) {
            j.this.f38129a.j(this.f38141a.j(), this.f38141a.r(), 2, this.f38142b, this.f38143c);
            com.ss.android.downloadlib.r.b.a().l("landing_download_dialog_confirm", this.f38141a, this.f38142b, this.f38143c);
            dialogInterface.dismiss();
        }

        @Override // com.ss.android.j.j.up.a.c
        public void cw(DialogInterface dialogInterface) {
            com.ss.android.downloadlib.r.b.a().l("landing_download_dialog_cancel", this.f38141a, this.f38142b, this.f38143c);
        }

        @Override // com.ss.android.j.j.up.a.c
        public void xt(DialogInterface dialogInterface) {
            com.ss.android.downloadlib.r.b.a().l("landing_download_dialog_cancel", this.f38141a, this.f38142b, this.f38143c);
            dialogInterface.dismiss();
        }
    }

    class c implements b.InterfaceC0764b<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f38145a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Uri f38146b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.b f38147c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.g f38148d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.ss.android.j.j.cw.c f38149e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ w2.h f38150f;

        c(Context context, Uri uri, com.ss.android.j.j.cw.b bVar, com.ss.android.j.j.cw.g gVar, com.ss.android.j.j.cw.c cVar, w2.h hVar) {
            this.f38145a = context;
            this.f38146b = uri;
            this.f38147c = bVar;
            this.f38148d = gVar;
            this.f38149e = cVar;
            this.f38150f = hVar;
        }

        @Override // com.ss.android.downloadlib.up.b.InterfaceC0764b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean xt() {
            return Boolean.valueOf(j.this.q(this.f38145a, this.f38146b, this.f38147c, this.f38148d, this.f38149e, this.f38150f));
        }
    }

    public interface d {
        void j(boolean z5);
    }

    public class g {

        /* renamed from: a, reason: collision with root package name */
        private static final String f38154a = "j$g";

        static class a implements InterfaceC0759j {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ JSONObject f38155a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.ss.android.xt.j.xt.a f38156b;

            a(JSONObject jSONObject, com.ss.android.xt.j.xt.a aVar) {
                this.f38155a = jSONObject;
                this.f38156b = aVar;
            }

            @Override // com.ss.android.downloadlib.j.InterfaceC0759j
            public void j(boolean z5) {
                String str;
                com.ss.android.downloadlib.r.b a6 = com.ss.android.downloadlib.r.b.a();
                if (z5) {
                    str = "deeplink_success";
                } else {
                    str = "deeplink_failed";
                }
                a6.x(str, this.f38155a, this.f38156b);
                if (z5) {
                    com.ss.android.downloadlib.addownload.m.C();
                    com.ss.android.downloadlib.addownload.m.getContext();
                    this.f38156b.tj();
                    this.f38156b.v();
                    this.f38156b.f();
                }
            }
        }

        static class b implements InterfaceC0759j {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ JSONObject f38157a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.ss.android.xt.j.xt.a f38158b;

            b(JSONObject jSONObject, com.ss.android.xt.j.xt.a aVar) {
                this.f38157a = jSONObject;
                this.f38158b = aVar;
            }

            @Override // com.ss.android.downloadlib.j.InterfaceC0759j
            public void j(boolean z5) {
                String str;
                com.ss.android.downloadlib.r.b a6 = com.ss.android.downloadlib.r.b.a();
                if (z5) {
                    str = "deeplink_success";
                } else {
                    str = "deeplink_failed";
                }
                a6.x(str, this.f38157a, this.f38158b);
                if (z5) {
                    com.ss.android.downloadlib.addownload.m.C();
                    com.ss.android.downloadlib.addownload.m.getContext();
                    this.f38158b.tj();
                    this.f38158b.v();
                    this.f38158b.f();
                }
            }
        }

        static class c implements InterfaceC0759j {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f38159a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ o.i f38160b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ JSONObject f38161c;

            c(String str, o.i iVar, JSONObject jSONObject) {
                this.f38159a = str;
                this.f38160b = iVar;
                this.f38161c = jSONObject;
            }

            @Override // com.ss.android.downloadlib.j.InterfaceC0759j
            public void j(boolean z5) {
                if (!z5 && !"open_market".equals(this.f38159a)) {
                    g.a(a.f.b(com.ss.android.downloadlib.addownload.m.getContext(), Uri.parse("market://details?id=" + this.f38160b.up())), this.f38160b, false);
                }
                com.ss.android.downloadlib.r.b.a().r(z5 ? "market_delay_success" : "market_delay_failed", this.f38161c, this.f38160b);
                if (z5) {
                    com.ss.android.downloadlib.addownload.m.C();
                    com.ss.android.downloadlib.addownload.m.getContext();
                }
            }
        }

        public static void c(String str, @NonNull o.b bVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.xt.j.xt.a aVar) {
            a.h.u(jSONObject, "applink_source", str);
            a.h.u(jSONObject, "error_code", Integer.valueOf(bVar.a()));
            a.h.u(jSONObject, "download_scene", Integer.valueOf(aVar.kt()));
            com.ss.android.downloadlib.r.b.a().x("deeplink_app_open_fail", jSONObject, aVar);
        }

        public static void d(String str, @Nullable JSONObject jSONObject, o.i iVar, boolean z5) {
            if (jSONObject == null) {
                try {
                    jSONObject = new JSONObject();
                } catch (Exception e6) {
                    com.ss.android.downloadlib.up.a.a().j(e6, "onMarketSuccess");
                    return;
                }
            }
            a.h.u(jSONObject, "applink_source", str);
            a.h.u(jSONObject, "download_scene", Integer.valueOf(iVar.kt()));
            if (z5) {
                com.ss.android.downloadlib.r.b.a().x("market_open_success", jSONObject, iVar);
            }
            if ((com.ss.android.downloadlib.addownload.m.f().optInt("check_applink_mode") & 4) != 0) {
                l.b().e(new c(str, iVar, jSONObject));
            } else {
                com.ss.android.downloadlib.addownload.m.K();
                com.ss.android.downloadlib.addownload.m.getContext();
            }
            com.ss.android.xt.j.xt.b g6 = o.f.c().g(iVar.f37961b.s());
            if (g6 != null) {
                a.o.a().b(f38154a, "onMarketSuccess", "商店场景,缓存中已有NativeDownloadModel记录,进行复用");
            } else {
                a.o.a().b(f38154a, "onMarketSuccess", "商店场景,缓存中没有相应的NativeDownloadModel,需要新建");
                g6 = new com.ss.android.xt.j.xt.b(iVar.f37961b, iVar.f37962c, iVar.f37963d);
            }
            g6.G0(2);
            g6.V(System.currentTimeMillis());
            g6.B0(4);
            g6.y(2);
            o.f.c().l(g6);
            a.o.a().b(f38154a, "onMarketSuccess", "检测到跳商店成功事件,准备开始检测安装行为");
            com.ss.android.downloadlib.f.a().c(iVar, g6);
        }

        public static void e(String str, @NonNull JSONObject jSONObject, @NonNull com.ss.android.xt.j.xt.a aVar) {
            a.h.u(jSONObject, "applink_source", str);
            a.h.u(jSONObject, "download_scene", Integer.valueOf(aVar.kt()));
            com.ss.android.downloadlib.r.b.a().x("deeplink_app_open", jSONObject, aVar);
            str.getClass();
            switch (str) {
                case "notify_by_package":
                case "auto_by_package":
                case "by_package":
                case "dialog_by_package":
                    if ((com.ss.android.downloadlib.addownload.m.f().optInt("check_applink_mode") & 1) == 0) {
                        com.ss.android.downloadlib.addownload.m.K();
                        com.ss.android.downloadlib.addownload.m.getContext();
                        aVar.tj();
                        aVar.v();
                        aVar.f();
                        break;
                    } else {
                        a.h.u(jSONObject, "check_applink_result_by_sdk", 1);
                        l.b().c(new a(jSONObject, aVar));
                        break;
                    }
            }
        }

        public static boolean g(@NonNull o.i iVar) {
            boolean z5;
            com.ss.android.j.j.up.f l6 = iVar.f37961b.l();
            String f6 = l6 == null ? null : l6.f();
            JSONObject b6 = a.i.b(new JSONObject(), iVar);
            a.h.u(b6, "applink_source", "click_by_sdk");
            com.ss.android.downloadlib.r.b.a().x("applink_click", b6, iVar);
            o.b h6 = a.f.h(f6, iVar);
            if (h6.getType() == 2) {
                if (!TextUtils.isEmpty(f6)) {
                    k("by_url", h6, b6, iVar);
                }
                h6 = a.f.e(com.ss.android.downloadlib.addownload.m.getContext(), iVar.f37961b.s(), iVar);
            }
            boolean z6 = false;
            if (f(iVar.f37960a) && com.ss.android.downloadlib.addownload.m.f().optInt("link_ad_click_event") == 1) {
                com.ss.android.j.j.cw.b bVar = iVar.f37961b;
                if (bVar instanceof com.ss.android.xt.j.j.a) {
                    ((com.ss.android.xt.j.j.a) bVar).e(4);
                }
                com.ss.android.downloadlib.r.b.a().c(iVar.f37960a, 0);
                z5 = true;
            } else {
                z5 = false;
            }
            int type = h6.getType();
            if (type == 1) {
                l("by_url", b6, iVar);
            } else {
                if (type != 3) {
                    if (type != 4) {
                        com.ss.android.downloadlib.up.a.a().f("AppLinkClick default");
                    } else {
                        c("by_package", h6, b6, iVar);
                    }
                    if (z6 && !z5 && ((com.ss.android.downloadlib.r.a.c().e() && !com.ss.android.downloadlib.r.a.c().f(iVar.f37960a, iVar.f37961b.ch())) || com.ss.android.downloadlib.r.a.c().b())) {
                        com.ss.android.downloadlib.r.b.a().c(iVar.f37960a, 2);
                    }
                    return z6;
                }
                e("by_package", b6, iVar);
            }
            z6 = true;
            if (z6) {
                com.ss.android.downloadlib.r.b.a().c(iVar.f37960a, 2);
            }
            return z6;
        }

        public static boolean h(@NonNull o.i iVar, int i6) {
            JSONObject jSONObject = new JSONObject();
            a.h.u(jSONObject, "download_scene", Integer.valueOf(iVar.kt()));
            com.ss.android.downloadlib.r.b.a().x("market_click_open", jSONObject, iVar);
            o.b c6 = a.f.c(com.ss.android.downloadlib.addownload.m.getContext(), iVar, iVar.f37961b.s());
            String q5 = a.h.q(c6.b(), "open_market");
            int type = c6.getType();
            if (type == 5) {
                d(q5, jSONObject, iVar, true);
            } else {
                if (type == 6) {
                    a.h.u(jSONObject, "error_code", Integer.valueOf(c6.a()));
                    a.h.u(jSONObject, "download_scene", Integer.valueOf(iVar.kt()));
                    com.ss.android.downloadlib.r.b.a().x("market_open_failed", jSONObject, iVar);
                    return false;
                }
                if (type != 7) {
                    return false;
                }
            }
            com.ss.android.downloadlib.r.b.a().c(iVar.f37960a, i6);
            return true;
        }

        public static void j(com.ss.android.xt.j.xt.b bVar) {
            if (bVar == null) {
                return;
            }
            String m6 = com.ss.android.socialbase.downloader.jy.j.cw().xt("app_link_opt") == 1 ? bVar.m() : null;
            JSONObject b6 = a.i.b(new JSONObject(), bVar);
            a.h.u(b6, "applink_source", "dialog_click_by_sdk");
            com.ss.android.downloadlib.r.b.a().x("applink_click", b6, bVar);
            o.b h6 = a.f.h(m6, bVar);
            if (h6.getType() == 2) {
                if (!TextUtils.isEmpty(m6)) {
                    k("dialog_by_url", h6, b6, bVar);
                }
                h6 = a.f.e(com.ss.android.downloadlib.addownload.m.getContext(), bVar.up(), bVar);
            }
            int type = h6.getType();
            if (type == 1) {
                l("dialog_by_url", b6, bVar);
                return;
            }
            if (type == 3) {
                e("dialog_by_package", b6, bVar);
            } else if (type != 4) {
                com.ss.android.downloadlib.up.a.a().f("AppLinkClickDialog default");
            } else {
                c("dialog_by_package", h6, b6, bVar);
            }
        }

        public static void k(String str, @NonNull o.b bVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.xt.j.xt.a aVar) {
            a.h.u(jSONObject, "applink_source", str);
            a.h.u(jSONObject, "error_code", Integer.valueOf(bVar.a()));
            a.h.u(jSONObject, "download_scene", Integer.valueOf(aVar.kt()));
            com.ss.android.downloadlib.r.b.a().x("deeplink_url_open_fail", jSONObject, aVar);
        }

        public static void l(String str, @NonNull JSONObject jSONObject, @NonNull com.ss.android.xt.j.xt.a aVar) {
            a.h.u(jSONObject, "applink_source", str);
            a.h.u(jSONObject, "download_scene", Integer.valueOf(aVar.kt()));
            com.ss.android.downloadlib.r.b.a().x("deeplink_url_open", jSONObject, aVar);
            str.getClass();
            switch (str) {
                case "auto_by_url":
                case "by_url":
                case "notify_by_url":
                case "dialog_by_url":
                    if ((com.ss.android.downloadlib.addownload.m.f().optInt("check_applink_mode") & 1) == 0) {
                        com.ss.android.downloadlib.addownload.m.K();
                        com.ss.android.downloadlib.addownload.m.getContext();
                        aVar.tj();
                        aVar.v();
                        aVar.f();
                        break;
                    } else {
                        a.h.u(jSONObject, "check_applink_result_by_sdk", 1);
                        l.b().c(new b(jSONObject, aVar));
                        break;
                    }
            }
        }

        public static void a(o.b bVar, o.i iVar, boolean z5) {
            String q5 = a.h.q(bVar.b(), "open_market");
            JSONObject jSONObject = new JSONObject();
            a.h.u(jSONObject, "ttdownloader_type", LiveConfigKey.BACKUP);
            int type = bVar.getType();
            if (type != 5) {
                if (type != 6) {
                    return;
                }
                a.h.u(jSONObject, "error_code", Integer.valueOf(bVar.a()));
                a.h.u(jSONObject, "download_scene", Integer.valueOf(iVar.kt()));
                com.ss.android.downloadlib.r.b.a().x("market_open_failed", jSONObject, iVar);
                return;
            }
            d(q5, jSONObject, iVar, z5);
        }

        public static void b(@NonNull com.ss.android.xt.j.xt.b bVar) {
            String m6 = bVar.m();
            JSONObject b6 = a.i.b(new JSONObject(), bVar);
            a.h.u(b6, "applink_source", "notify_click_by_sdk");
            com.ss.android.downloadlib.r.b.a().x("applink_click", b6, bVar);
            o.b h6 = a.f.h(m6, bVar);
            if (h6.getType() == 2) {
                if (!TextUtils.isEmpty(m6)) {
                    k("notify_by_url", h6, b6, bVar);
                }
                h6 = a.f.e(com.ss.android.downloadlib.addownload.m.getContext(), bVar.up(), bVar);
            }
            int type = h6.getType();
            if (type != 1) {
                if (type != 3) {
                    if (type != 4) {
                        com.ss.android.downloadlib.up.a.a().f("AppLinkClickNotification default");
                        return;
                    } else {
                        c("notify_by_package", h6, b6, bVar);
                        return;
                    }
                }
                e("notify_by_package", b6, bVar);
                return;
            }
            l("notify_by_url", b6, bVar);
        }

        public static boolean f(long j6) {
            if (o.f.c().q(j6) == null) {
                return true;
            }
            return false;
        }

        public static boolean i(String str, @NonNull com.ss.android.xt.j.xt.b bVar) {
            if (!com.ss.android.downloadlib.addownload.d.k(bVar.t0())) {
                return false;
            }
            if (TextUtils.isEmpty(bVar.m()) && TextUtils.isEmpty(str)) {
                return false;
            }
            xt.j().m(bVar.mi());
            JSONObject jSONObject = new JSONObject();
            a.i.b(jSONObject, bVar);
            a.h.u(jSONObject, "applink_source", "auto_click");
            com.ss.android.downloadlib.r.b.a().w("applink_click", bVar);
            o.b f6 = a.f.f(bVar, bVar.m(), bVar.up());
            int type = f6.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type != 4) {
                            return false;
                        }
                        c("auto_by_package", f6, jSONObject, bVar);
                        return false;
                    }
                    e("auto_by_package", jSONObject, bVar);
                    return true;
                }
                k("auto_by_url", f6, jSONObject, bVar);
                return false;
            }
            l("auto_by_url", jSONObject, bVar);
            return true;
        }
    }

    public class h {

        /* renamed from: a, reason: collision with root package name */
        private static Handler f38162a = new Handler(Looper.getMainLooper());

        static class a implements j.InterfaceC0786j {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.ss.android.xt.j.xt.b f38163a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f38164b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ k f38165c;

            /* renamed from: com.ss.android.downloadlib.j$h$a$a, reason: collision with other inner class name */
            class RunnableC0758a implements Runnable {
                RunnableC0758a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean d6 = a.h.d(a.this.f38163a.up());
                    long k6 = h.k(a.this.f38163a);
                    if (!d6 || k6 >= System.currentTimeMillis() - a.this.f38164b) {
                        long j6 = h.j(a.this.f38163a);
                        long currentTimeMillis = System.currentTimeMillis();
                        a aVar = a.this;
                        if (currentTimeMillis - aVar.f38164b > j6) {
                            com.ss.android.downloadlib.r.b.a().m("deeplink_delay_timeout", a.this.f38163a);
                            return;
                        }
                        aVar.f38163a.N0(true);
                        com.ss.android.downloadlib.r.b.a().m("deeplink_delay_invoke", a.this.f38163a);
                        a.this.f38165c.j(true);
                        com.ss.android.xt.j.xt.b bVar = a.this.f38163a;
                        h.l(bVar, h.h(bVar));
                    }
                }
            }

            a(com.ss.android.xt.j.xt.b bVar, long j6, k kVar) {
                this.f38163a = bVar;
                this.f38164b = j6;
                this.f38165c = kVar;
            }

            @Override // com.ss.android.socialbase.downloader.j.j.InterfaceC0786j
            public void xt() {
                com.ss.android.socialbase.downloader.j.j.j().xt(this);
                com.ss.android.downloadlib.e.c().d(new RunnableC0758a());
            }

            @Override // com.ss.android.socialbase.downloader.j.j.InterfaceC0786j
            public void cw() {
            }
        }

        static class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.ss.android.xt.j.xt.b f38167a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f38168b;

            b(com.ss.android.xt.j.xt.b bVar, int i6) {
                this.f38167a = bVar;
                this.f38168b = i6;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i6 = 1;
                if (!a.h.d(this.f38167a.up())) {
                    h.l(this.f38167a, this.f38168b - 1);
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!this.f38167a.P()) {
                        i6 = 2;
                    }
                    jSONObject.putOpt("deeplink_source", Integer.valueOf(i6));
                } catch (JSONException e6) {
                    vl.j(e6);
                }
                com.ss.android.downloadlib.r.b.a().r("deeplink_success_2", jSONObject, this.f38167a);
            }
        }

        public static long k(com.ss.android.xt.j.xt.b bVar) {
            if (bVar == null) {
                return 3000L;
            }
            return a.n.k(bVar).j("app_link_opt_back_time_limit", 3) * 1000;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void l(@NonNull com.ss.android.xt.j.xt.b bVar, int i6) {
            if (i6 <= 0) {
                return;
            }
            com.ss.android.downloadlib.e.c().e(new b(bVar, i6), c(bVar) * 1000);
        }

        public static boolean b(com.ss.android.xt.j.xt.b bVar) {
            if (a.n.k(bVar).xt("app_link_opt_invoke_switch") == 1) {
                return true;
            }
            return false;
        }

        private static int c(com.ss.android.xt.j.xt.b bVar) {
            return a.n.k(bVar).j("app_link_check_delay", 1);
        }

        public static void e(com.ss.android.xt.j.xt.b bVar, @NonNull k kVar) {
            boolean z5;
            boolean xt = com.ss.android.socialbase.downloader.j.j.j().xt();
            if (!xt && Build.VERSION.SDK_INT >= 29) {
                a.h.c();
            }
            boolean xt2 = com.ss.android.socialbase.downloader.j.j.j().xt();
            if (!xt && xt2) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (bVar != null) {
                bVar.N0(z5);
            }
            kVar.j(z5);
            if (bVar != null) {
                l(bVar, h(bVar));
                if (xt2) {
                    return;
                }
                com.ss.android.socialbase.downloader.j.j.j().j(new a(bVar, System.currentTimeMillis(), kVar));
            }
        }

        public static boolean f(com.ss.android.xt.j.xt.b bVar) {
            if (a.n.k(bVar).xt("app_link_opt_switch") == 1) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int h(com.ss.android.xt.j.xt.b bVar) {
            return a.n.k(bVar).j("app_link_check_count", 10);
        }

        public static boolean i(com.ss.android.xt.j.xt.b bVar) {
            if (a.n.k(bVar).xt("app_link_opt_dialog_switch") == 1) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static long j(com.ss.android.xt.j.xt.b bVar) {
            return a.n.k(bVar).j("app_link_check_timeout", PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
        }

        public static boolean m(com.ss.android.xt.j.xt.b bVar) {
            if (a.n.k(bVar).xt("app_link_opt_install_switch") == 1) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.ss.android.downloadlib.j$j, reason: collision with other inner class name */
    public interface InterfaceC0759j {
        void j(boolean z5);
    }

    public interface k {
        void j(boolean z5);
    }

    public class l implements j.InterfaceC0786j {

        /* renamed from: a, reason: collision with root package name */
        private long f38194a;

        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f38195a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ InterfaceC0759j f38196b;

            a(long j6, InterfaceC0759j interfaceC0759j) {
                this.f38195a = j6;
                this.f38196b = interfaceC0759j;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.ss.android.socialbase.downloader.j.j.j().cw() && System.currentTimeMillis() - l.this.f38194a > this.f38195a) {
                    this.f38196b.j(false);
                } else {
                    this.f38196b.j(true);
                }
            }
        }

        private static class b {

            /* renamed from: a, reason: collision with root package name */
            private static l f38198a = new l(null);
        }

        /* synthetic */ l(a aVar) {
            this();
        }

        private l() {
            this.f38194a = 0L;
            com.ss.android.socialbase.downloader.j.j.j().j(this);
        }

        public void c(InterfaceC0759j interfaceC0759j) {
            d(interfaceC0759j, 5000L);
        }

        public void d(InterfaceC0759j interfaceC0759j, long j6) {
            if (interfaceC0759j == null) {
                return;
            }
            com.ss.android.downloadlib.e.c().e(new a(j6, interfaceC0759j), j6);
        }

        public void e(InterfaceC0759j interfaceC0759j) {
            if (interfaceC0759j == null) {
                return;
            }
            JSONObject f6 = com.ss.android.downloadlib.addownload.m.f();
            int i6 = AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS;
            int optInt = f6.optInt("check_an_result_delay", AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS);
            if (optInt > 0) {
                i6 = optInt;
            }
            d(interfaceC0759j, i6);
        }

        public static l b() {
            return b.f38198a;
        }

        @Override // com.ss.android.socialbase.downloader.j.j.InterfaceC0786j
        public void xt() {
            this.f38194a = System.currentTimeMillis();
        }

        @Override // com.ss.android.socialbase.downloader.j.j.InterfaceC0786j
        public void cw() {
        }
    }

    public static j j() {
        if (f38128c == null) {
            synchronized (j.class) {
                try {
                    if (f38128c == null) {
                        f38128c = new j();
                    }
                } finally {
                }
            }
        }
        return f38128c;
    }

    public static com.ss.android.j.j.cw.c o() {
        return k(false);
    }

    @Override // z2.b
    public Dialog b(Context context, String str, boolean z5, @NonNull com.ss.android.j.j.cw.b bVar, com.ss.android.j.j.cw.g gVar, com.ss.android.j.j.cw.c cVar, com.ss.android.j.j.cw.e eVar, int i6, w2.h hVar) {
        return h(context, str, z5, bVar, gVar, cVar, eVar, i6, false, hVar);
    }

    @Override // z2.b
    public Dialog c(Context context, String str, boolean z5, @NonNull com.ss.android.j.j.cw.b bVar, com.ss.android.j.j.cw.g gVar, com.ss.android.j.j.cw.c cVar, com.ss.android.j.j.cw.e eVar, int i6) {
        return g(context, str, z5, bVar, gVar, cVar, eVar, i6, false);
    }

    @Override // z2.b
    public boolean d(Context context, Uri uri, com.ss.android.j.j.cw.b bVar, com.ss.android.j.j.cw.g gVar, com.ss.android.j.j.cw.c cVar) {
        return a(context, uri, bVar, gVar, cVar, null);
    }

    public Dialog g(Context context, String str, boolean z5, @NonNull com.ss.android.j.j.cw.b bVar, com.ss.android.j.j.cw.g gVar, com.ss.android.j.j.cw.c cVar, com.ss.android.j.j.cw.e eVar, int i6, boolean z6) {
        return h(context, str, z5, bVar, gVar, cVar, eVar, i6, z6, null);
    }

    public Dialog n(Context context, String str, boolean z5, com.ss.android.j.j.cw.b bVar, com.ss.android.j.j.cw.g gVar, com.ss.android.j.j.cw.c cVar, com.ss.android.j.j.cw.e eVar, int i6, boolean z6, w2.h hVar) {
        if (j(bVar.r())) {
            if (z6) {
                l(bVar.r(), gVar, cVar);
            } else {
                p(bVar.r());
            }
            return null;
        }
        if (context == null || TextUtils.isEmpty(bVar.j())) {
            return null;
        }
        this.f38129a.h(context, i6, eVar, bVar);
        com.ss.android.j.j.cw.g gVar2 = (com.ss.android.j.j.cw.g) a.h.n(gVar, f());
        com.ss.android.j.j.cw.c cVar2 = (com.ss.android.j.j.cw.c) a.h.n(cVar, o());
        gVar2.j(1);
        if ((cVar2.vl() && com.ss.android.downloadlib.addownload.compliance.f.a().g(bVar)) ? true : (com.ss.android.downloadlib.addownload.m.f().optInt("disable_lp_dialog", 0) == 1) | z5) {
            this.f38129a.l(bVar.j(), bVar.r(), 2, gVar2, cVar2, hVar);
            return null;
        }
        a.k.d(f38127b, "tryStartDownload show dialog appName:" + bVar.j(), null);
        Dialog xt = com.ss.android.downloadlib.addownload.m.d().xt(new a.b(context).h(bVar.tl()).p("确认要下载此应用吗？").b("确认").l("取消").g(new b(bVar, gVar2, cVar2)).e(0).j());
        com.ss.android.downloadlib.r.b.a().l("landing_download_dialog_show", bVar, gVar2, cVar2);
        return xt;
    }

    public class e {

        static class a implements j.InterfaceC0786j {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.ss.android.xt.j.xt.b f38152a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.ss.android.downloadlib.guide.install.a f38153b;

            a(com.ss.android.xt.j.xt.b bVar, com.ss.android.downloadlib.guide.install.a aVar) {
                this.f38152a = bVar;
                this.f38153b = aVar;
            }

            @Override // com.ss.android.socialbase.downloader.j.j.InterfaceC0786j
            public void xt() {
                com.ss.android.socialbase.downloader.m.j.xt("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                com.ss.android.socialbase.downloader.j.j.j().xt(this);
                if (a.h.M(this.f38152a)) {
                    return;
                }
                this.f38152a.O(true);
                com.ss.android.downloadlib.r.b.a().m("install_delay_invoke", this.f38152a);
                this.f38153b.j();
            }

            @Override // com.ss.android.socialbase.downloader.j.j.InterfaceC0786j
            public void cw() {
            }
        }

        public static void a(com.ss.android.xt.j.xt.b bVar, @NonNull com.ss.android.downloadlib.guide.install.a aVar) {
            boolean xt = com.ss.android.socialbase.downloader.j.j.j().xt();
            if (!xt && Build.VERSION.SDK_INT >= 29) {
                a.h.c();
            }
            boolean xt2 = com.ss.android.socialbase.downloader.j.j.j().xt();
            if (!xt && xt2 && bVar != null) {
                bVar.N0(true);
            }
            aVar.j();
            com.ss.android.socialbase.downloader.m.j.xt("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::".concat(String.valueOf(xt2)));
            if (!xt2) {
                com.ss.android.socialbase.downloader.j.j.j().j(new a(bVar, aVar));
            }
        }
    }

    public class f {
        public static boolean a(@NonNull com.ss.android.xt.j.xt.a aVar) {
            if (com.ss.android.socialbase.appdownloader.m.e.r() && Build.VERSION.SDK_INT < 29 && com.ss.android.downloadlib.addownload.m.G() != null && com.ss.android.downloadlib.addownload.m.G().j() && a.n.k(aVar).xt("invoke_app_form_background_switch") == 1 && aVar.i()) {
                return true;
            }
            return false;
        }
    }

    public class i {
        public static boolean a(Uri uri) {
            return u2.a.b(uri);
        }
    }

    public class m {

        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.ss.android.xt.j.xt.b f38199a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f38200b;

            /* renamed from: com.ss.android.downloadlib.j$m$a$a, reason: collision with other inner class name */
            class C0761a implements k {
                C0761a() {
                }

                @Override // com.ss.android.downloadlib.j.k
                public void j(boolean z5) {
                    a.this.f38200b.j(z5);
                }
            }

            a(com.ss.android.xt.j.xt.b bVar, d dVar) {
                this.f38199a = bVar;
                this.f38200b = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (f.a(this.f38199a)) {
                    this.f38200b.j(false);
                } else if (h.f(this.f38199a)) {
                    h.e(this.f38199a, new C0761a());
                } else {
                    this.f38200b.j(false);
                }
            }
        }

        public void a(@NonNull com.ss.android.xt.j.xt.b bVar, @NonNull d dVar, int i6) {
            com.ss.android.downloadlib.e.c().e(new a(bVar, dVar), i6);
        }
    }

    public static com.ss.android.j.j.cw.g f() {
        return new c.a().g("landing_h5_download_ad_button").p("landing_h5_download_ad_button").m("click_start_detail").o("click_pause_detail").k("click_continue_detail").a("click_install_detail").n("click_open_detail").d("storage_deny_detail").e(1).i(false).r(true).c(false).j();
    }

    public static com.ss.android.j.j.cw.c k(boolean z5) {
        b.a l6 = new b.a().e(0).h(true).c(false).l(false);
        if (z5) {
            l6.o(2);
        } else {
            l6.o(0);
        }
        return l6.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(Context context, Uri uri, com.ss.android.j.j.cw.b bVar, com.ss.android.j.j.cw.g gVar, com.ss.android.j.j.cw.c cVar, w2.h hVar) {
        com.ss.android.j.j.cw.c cVar2 = cVar;
        if (!u2.a.b(uri) || com.ss.android.downloadlib.addownload.m.f().optInt("disable_market") == 1) {
            return false;
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.m.getContext();
        }
        String c6 = u2.a.c(uri);
        if (bVar == null) {
            return a.f.d(context, c6).getType() == 5;
        }
        if (!TextUtils.isEmpty(c6) && (bVar instanceof com.ss.android.xt.j.j.a)) {
            ((com.ss.android.xt.j.j.a) bVar).z(c6);
        }
        if (cVar2 != null) {
            cVar2.j(2);
        } else if ((bVar instanceof com.ss.android.xt.j.j.a) && TextUtils.isEmpty(bVar.j())) {
            ((com.ss.android.xt.j.j.a) bVar).v(uri.toString());
            cVar2 = k(true);
        } else {
            cVar2 = bVar.j().startsWith("market") ? k(true) : o();
        }
        o.i iVar = new o.i(bVar.r(), bVar, (com.ss.android.j.j.cw.g) a.h.n(gVar, f()), cVar2);
        o.f.c().k(iVar.f37961b);
        o.f.c().j(iVar.f37960a, iVar.f37962c);
        o.f.c().i(iVar.f37960a, iVar.f37963d);
        if (a.h.z(bVar) && com.ss.android.socialbase.downloader.jy.j.cw().xt("app_link_opt") == 1 && g.g(iVar)) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        a.h.u(jSONObject, "market_url", uri.toString());
        a.h.u(jSONObject, "download_scene", 1);
        com.ss.android.downloadlib.r.b.a().x("market_click_open", jSONObject, iVar);
        o.b c7 = a.f.c(context, iVar, c6);
        String q5 = a.h.q(c7.b(), "open_market");
        if (c7.getType() == 5) {
            g.d(q5, jSONObject, iVar, true);
            return true;
        }
        if (c7.getType() != 6) {
            return true;
        }
        a.h.u(jSONObject, "error_code", Integer.valueOf(c7.a()));
        com.ss.android.downloadlib.r.b.a().x("market_open_failed", jSONObject, iVar);
        if (com.ss.android.downloadlib.addownload.d.h(bVar, hVar)) {
            hVar.j();
        }
        return false;
    }

    @Override // z2.b
    public boolean a(Context context, Uri uri, com.ss.android.j.j.cw.b bVar, com.ss.android.j.j.cw.g gVar, com.ss.android.j.j.cw.c cVar, w2.h hVar) {
        return ((Boolean) com.ss.android.downloadlib.up.b.a(new c(context, uri, bVar, gVar, cVar, hVar))).booleanValue();
    }

    public Dialog h(Context context, String str, boolean z5, @NonNull com.ss.android.j.j.cw.b bVar, com.ss.android.j.j.cw.g gVar, com.ss.android.j.j.cw.c cVar, com.ss.android.j.j.cw.e eVar, int i6, boolean z6, w2.h hVar) {
        return (Dialog) com.ss.android.downloadlib.up.b.a(new a(context, str, z5, bVar, gVar, cVar, eVar, i6, z6, hVar));
    }

    private j() {
    }

    @Override // z2.b
    public boolean e(Context context, long j6, String str, com.ss.android.j.j.cw.e eVar, int i6) {
        com.ss.android.xt.j.xt.b q5 = o.f.c().q(j6);
        if (q5 != null) {
            this.f38129a.h(context, i6, eVar, q5.h0());
            return true;
        }
        com.ss.android.j.j.cw.b d6 = o.f.c().d(j6);
        if (d6 != null) {
            this.f38129a.h(context, i6, eVar, d6);
            return true;
        }
        return false;
    }

    public void l(long j6, com.ss.android.j.j.cw.g gVar, com.ss.android.j.j.cw.c cVar) {
        com.ss.android.j.j.cw.b d6 = o.f.c().d(j6);
        com.ss.android.xt.j.xt.b q5 = o.f.c().q(j6);
        if (d6 == null && q5 != null) {
            d6 = q5.h0();
        }
        if (d6 == null) {
            return;
        }
        if (gVar != null && cVar != null && !(gVar instanceof com.ss.android.j.j.cw.a) && !(cVar instanceof com.ss.android.j.j.cw.d)) {
            gVar.j(1);
            this.f38129a.j(d6.j(), j6, 2, gVar, cVar);
        } else {
            p(j6);
        }
    }

    public void p(long j6) {
        com.ss.android.j.j.cw.b d6 = o.f.c().d(j6);
        com.ss.android.xt.j.xt.b q5 = o.f.c().q(j6);
        if (d6 == null && q5 != null) {
            d6 = q5.h0();
        }
        if (d6 == null) {
            return;
        }
        com.ss.android.j.j.cw.g s5 = o.f.c().s(j6);
        com.ss.android.j.j.cw.c a6 = o.f.c().a(j6);
        if (s5 instanceof com.ss.android.j.j.cw.a) {
            s5 = null;
        }
        if (a6 instanceof com.ss.android.j.j.cw.d) {
            a6 = null;
        }
        if (q5 == null) {
            if (s5 == null) {
                s5 = f();
            }
            if (a6 == null) {
                a6 = o();
            }
        } else {
            if (s5 == null) {
                s5 = new c.a().g(q5.oq()).l(q5.g()).c(q5.jy()).i(false).m("click_start_detail").o("click_pause_detail").k("click_continue_detail").a("click_install_detail").d("storage_deny_detail").j();
            }
            if (a6 == null) {
                a6 = q5.P0();
            }
        }
        com.ss.android.j.j.cw.g gVar = s5;
        com.ss.android.j.j.cw.c cVar = a6;
        gVar.j(1);
        this.f38129a.j(d6.j(), j6, 2, gVar, cVar);
    }

    @Override // z2.b
    public boolean j(long j6, int i6) {
        com.ss.android.j.j.cw.b d6 = o.f.c().d(j6);
        if (d6 == null) {
            return false;
        }
        this.f38129a.i(d6.j(), i6);
        return true;
    }

    @Override // z2.b
    public boolean j(long j6) {
        return (o.f.c().d(j6) == null && o.f.c().q(j6) == null) ? false : true;
    }
}
