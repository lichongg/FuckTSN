package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.provider.FontsContractCompat;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.api.plugin.xt;
import com.ss.android.socialbase.appdownloader.j.m;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.downloader.ae;
import com.ss.android.socialbase.downloader.j.j;
import com.ss.android.socialbase.downloader.ws.tl;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final String f38458a = "j";

    /* renamed from: b, reason: collision with root package name */
    private static c f38459b;

    /* renamed from: c, reason: collision with root package name */
    private static d f38460c;

    public interface c {
        void a(cw cwVar, com.ss.android.socialbase.appdownloader.d dVar);
    }

    private static class d implements j.InterfaceC0786j {

        /* renamed from: a, reason: collision with root package name */
        private final f f38467a;

        /* renamed from: b, reason: collision with root package name */
        private final int f38468b;

        /* renamed from: c, reason: collision with root package name */
        private JSONObject f38469c;

        @Override // com.ss.android.socialbase.downloader.j.j.InterfaceC0786j
        public void cw() {
            int optInt = this.f38469c.optInt("time_out_second", 20);
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.f38467a.f38479d.sendMessage(obtain);
            if (optInt <= 0 || optInt >= 60) {
                return;
            }
            Message obtain2 = Message.obtain();
            obtain2.what = 2;
            this.f38467a.f38479d.sendMessageDelayed(obtain2, optInt * 1000);
        }

        @Override // com.ss.android.socialbase.downloader.j.j.InterfaceC0786j
        public void xt() {
            if (!this.f38467a.f38482g) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                this.f38467a.f38479d.sendMessage(obtain);
            }
            com.ss.android.socialbase.downloader.j.j.j().xt(this);
            d unused = j.f38460c = null;
        }

        public d(Context context, Intent intent, int i6, JSONObject jSONObject, g gVar) {
            this.f38469c = jSONObject;
            int optInt = jSONObject.optInt("query_interval", 1000);
            this.f38468b = optInt;
            this.f38467a = new f(context, intent, i6, gVar, optInt);
        }
    }

    private static class e implements Callable<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f38470a;

        /* renamed from: b, reason: collision with root package name */
        private final g f38471b;

        /* renamed from: c, reason: collision with root package name */
        private final Handler f38472c;

        /* renamed from: d, reason: collision with root package name */
        private final long f38473d;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            g gVar;
            try {
                gVar = this.f38471b;
            } catch (Throwable unused) {
            }
            if (gVar != null) {
                long j6 = this.f38473d;
                if (j6 > 0 && j6 <= 10000) {
                    Context context = this.f38470a;
                    boolean j7 = context != null ? gVar.j(context) : false;
                    Message obtain = Message.obtain();
                    if (j7) {
                        obtain.what = 2;
                        this.f38472c.sendMessage(obtain);
                    } else {
                        obtain.what = 1;
                        this.f38472c.sendMessageDelayed(obtain, this.f38473d);
                    }
                    return Boolean.FALSE;
                }
            }
            return Boolean.FALSE;
        }

        public e(Handler handler, Context context, g gVar, long j6) {
            this.f38470a = context;
            this.f38471b = gVar;
            this.f38472c = handler;
            this.f38473d = j6;
        }
    }

    private static class f implements tl.j {

        /* renamed from: h, reason: collision with root package name */
        public static int f38474h;

        /* renamed from: i, reason: collision with root package name */
        private static int f38475i;

        /* renamed from: a, reason: collision with root package name */
        private final Context f38476a;

        /* renamed from: b, reason: collision with root package name */
        private final Intent f38477b;

        /* renamed from: c, reason: collision with root package name */
        private final g f38478c;

        /* renamed from: d, reason: collision with root package name */
        private final Handler f38479d;

        /* renamed from: e, reason: collision with root package name */
        private final long f38480e;

        /* renamed from: f, reason: collision with root package name */
        private Future<Boolean> f38481f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f38482g = false;

        @Override // com.ss.android.socialbase.downloader.ws.tl.j
        public void j(Message message) {
            if (message != null) {
                int i6 = message.what;
                if (i6 == 1) {
                    long j6 = this.f38480e;
                    if (j6 <= 0 || j6 > 10000) {
                        return;
                    }
                    f38474h = 1;
                    this.f38481f = com.ss.android.socialbase.downloader.downloader.cw.qv().submit(new e(this.f38479d, this.f38476a, this.f38478c, this.f38480e));
                    return;
                }
                if (i6 == 2) {
                    f38474h = 2;
                    this.f38479d.removeMessages(2);
                    this.f38479d.removeMessages(1);
                    Future<Boolean> future = this.f38481f;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.f38482g && (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.j.j.j().xt())) {
                        Intent intent = this.f38477b;
                        if (intent != null) {
                            j.E(this.f38476a, intent);
                        } else {
                            cw tl = ae.xt(this.f38476a).tl(f38475i);
                            if (tl != null && tl.hw()) {
                                com.ss.android.socialbase.appdownloader.b.J(this.f38476a, f38475i, false);
                            }
                        }
                        this.f38482g = true;
                    }
                    j.C(f38475i, this.f38477b == null, j.n(this.f38476a));
                }
            }
        }

        public f(Context context, Intent intent, int i6, g gVar, long j6) {
            this.f38476a = context;
            this.f38477b = intent;
            f38475i = i6;
            this.f38478c = gVar;
            this.f38479d = new tl(Looper.getMainLooper(), this);
            this.f38480e = j6;
        }
    }

    interface g {
        boolean j(@NonNull Context context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean E(Context context, Intent intent) {
        return r(context, intent, true);
    }

    private static boolean F(Context context, @NonNull cw cwVar, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.d dVar) {
        if (context != null && jSONObject != null) {
            String qv = cwVar.qv();
            if (TextUtils.isEmpty(qv)) {
                return false;
            }
            dVar.f38362d = "custom";
            com.ss.android.socialbase.appdownloader.j.d a6 = com.ss.android.socialbase.appdownloader.j.i.a(context, "custom", jSONObject, cwVar);
            if (a6 != null && a6.a()) {
                Intent xt = a6.xt();
                if (xt == null) {
                    return false;
                }
                if (!w(new File(qv), cwVar, jSONObject)) {
                    dVar.f38360b = 6;
                } else {
                    if (E(context, xt)) {
                        dVar.f38360b = 0;
                        return true;
                    }
                    dVar.f38360b = 1;
                }
                return false;
            }
            dVar.f38360b = 3;
        }
        return false;
    }

    public static boolean n(Context context) {
        if (context == null) {
            return true;
        }
        if (com.ss.android.socialbase.appdownloader.m.e.e() && Build.VERSION.SDK_INT < 26) {
            return y(context);
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            return z(context);
        }
        return true;
    }

    public static boolean p(Context context, @Nullable Intent intent, int i6, JSONObject jSONObject) {
        try {
            if (com.ss.android.socialbase.appdownloader.m.e.e() && Build.VERSION.SDK_INT < 26 && !y(context)) {
                com.ss.android.socialbase.appdownloader.j.f fVar = new com.ss.android.socialbase.appdownloader.j.f(context);
                if (fVar.a()) {
                    j(context, intent, i6, jSONObject, new a());
                    return E(context, fVar.xt());
                }
            } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !z(context)) {
                m mVar = new m(context);
                if (mVar.a()) {
                    j(context, intent, i6, jSONObject, new b());
                    return E(context, mVar.xt());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean q(Context context, @Nullable Intent intent, JSONObject jSONObject, int i6, @Nullable com.ss.android.socialbase.appdownloader.d dVar) {
        if (context != null && jSONObject != null) {
            long optLong = jSONObject.optLong("jump_interval", 0L);
            if (optLong <= 0) {
                return false;
            }
            SharedPreferences xt = xt.xt(context, "sp_ah_config", 0);
            if ((System.currentTimeMillis() - xt.getLong("last_jump_unknown_source_time", 0L)) / 60000 >= optLong && !n(context)) {
                xt.edit().putLong("last_jump_unknown_source_time", System.currentTimeMillis()).apply();
                if (jSONObject.optInt("show_unknown_source_dialog", 0) != 1) {
                    if (p(context, intent, i6, jSONObject)) {
                        a(i6, jSONObject);
                    }
                    return true;
                }
                Intent intent2 = new Intent(context, (Class<?>) JumpUnknownSourceActivity.class);
                intent2.addFlags(268435456);
                intent2.putExtra("intent", intent);
                intent2.putExtra("config", jSONObject.toString());
                intent2.putExtra("id", i6);
                try {
                    if (r(context, intent2, false)) {
                        x(i6, jSONObject);
                    }
                    return true;
                } catch (Throwable th) {
                    if (dVar != null) {
                        dVar.f38360b = 1;
                        dVar.f38361c = "tryShowUnknownSourceDialog" + g(th);
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean r(Context context, Intent intent, boolean z5) {
        if (context == null || intent == null) {
            return false;
        }
        if (!z5) {
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return true;
        }
        try {
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:63:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x019d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean s(android.content.Context r11, com.ss.android.socialbase.downloader.ae.cw r12, android.content.Intent r13, org.json.JSONObject r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.j.s(android.content.Context, com.ss.android.socialbase.downloader.ae.cw, android.content.Intent, org.json.JSONObject, boolean):boolean");
    }

    private static boolean u(Context context, cw cwVar, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.d dVar) {
        String str;
        boolean z5;
        if (context != null && jSONObject != null) {
            String optString = jSONObject.optString("device_plans");
            dVar.f38363e = optString;
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split(",");
                String qv = cwVar.qv();
                if (TextUtils.isEmpty(qv)) {
                    return false;
                }
                File file = new File(qv);
                StringBuilder sb = new StringBuilder();
                int length = split.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        str = null;
                        z5 = false;
                        break;
                    }
                    str = split[i6];
                    com.ss.android.socialbase.appdownloader.j.d a6 = com.ss.android.socialbase.appdownloader.j.i.a(context, str, jSONObject, cwVar);
                    if (a6 != null) {
                        Intent xt = a6.xt();
                        if (xt == null) {
                            k(dVar, 3);
                            sb.append(str);
                            sb.append(" resolveActivity failed! ");
                        } else if (w(file, cwVar, jSONObject)) {
                            z5 = true;
                            try {
                                r(context, xt, false);
                                break;
                            } catch (Throwable th) {
                                sb.append(str);
                                sb.append(" startActivity failed : ");
                                sb.append(g(th));
                                k(dVar, 1);
                            }
                        } else {
                            k(dVar, 6);
                            sb.append(str);
                            sb.append(" createDescFile failed! ");
                        }
                    }
                    sb.append("  ");
                    i6++;
                }
                if (z5) {
                    dVar.f38362d = str;
                    dVar.f38360b = 0;
                } else {
                    dVar.f38361c = sb.toString();
                }
                return z5;
            }
        }
        return false;
    }

    private static boolean w(File file, cw cwVar, @NonNull JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject r5 = com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).r("download_dir");
        File file2 = null;
        String optString = r5 != null ? r5.optString("ins_desc") : null;
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString)) {
            file2 = new File(path + File.separator + optString);
        }
        if (file2 == null) {
            return true;
        }
        try {
            if (!file2.createNewFile()) {
                return true;
            }
            file2.deleteOnExit();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean y(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 26)
    public static boolean z(Context context) {
        boolean canRequestPackageInstalls;
        if (context == null) {
            return true;
        }
        try {
            canRequestPackageInstalls = context.getPackageManager().canRequestPackageInstalls();
            return canRequestPackageInstalls;
        } catch (Throwable unused) {
            return true;
        }
    }

    static class a implements g {
        a() {
        }

        @Override // com.ss.android.socialbase.appdownloader.j.g
        public boolean j(@NonNull Context context) {
            return j.y(context);
        }
    }

    static class b implements g {
        b() {
        }

        @Override // com.ss.android.socialbase.appdownloader.j.g
        public boolean j(@NonNull Context context) {
            return j.z(context);
        }
    }

    public static com.ss.android.socialbase.appdownloader.d A(JSONObject jSONObject, com.ss.android.socialbase.downloader.jy.j jVar) {
        com.ss.android.socialbase.appdownloader.d dVar = new com.ss.android.socialbase.appdownloader.d();
        if (jSONObject == null) {
            return dVar;
        }
        dVar.f38359a = jSONObject.optString("type");
        dVar.f38363e = "vbi";
        if (com.ss.android.socialbase.appdownloader.j.i.b(com.ss.android.socialbase.downloader.downloader.cw.nd(), "vbi", jSONObject, jVar)) {
            dVar.f38360b = 0;
            return dVar;
        }
        k(dVar, 3);
        return dVar;
    }

    public static void B(int i6, JSONObject jSONObject) {
        int i7 = 1;
        boolean z5 = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z5) {
            i7 = 2;
        }
        try {
            jSONObject2.put("scene", i7);
        } catch (Exception e6) {
            vl.j(e6);
        }
        com.ss.android.socialbase.downloader.downloader.cw.ol().xt(i6, "guide_auth_dialog_cancel", jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void C(int i6, boolean z5, boolean z6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scene", z5 ? 1 : 2);
            jSONObject.put(FontsContractCompat.Columns.RESULT_CODE, z6 ? 1 : 2);
        } catch (Exception e6) {
            vl.j(e6);
        }
        com.ss.android.socialbase.downloader.downloader.cw.ol().xt(i6, "guide_auth_result", jSONObject);
    }

    public static void a(int i6, JSONObject jSONObject) {
        int i7 = 1;
        boolean z5 = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z5) {
            i7 = 2;
        }
        try {
            jSONObject2.put("scene", i7);
        } catch (Exception e6) {
            vl.j(e6);
        }
        com.ss.android.socialbase.downloader.downloader.cw.ol().xt(i6, "guide_auth_open_setting", jSONObject2);
    }

    public static int c(@NonNull com.ss.android.socialbase.downloader.jy.j jVar) {
        if (!(jVar.r("download_dir") != null ? !TextUtils.isEmpty(r0.optString("dir_name")) : false)) {
            return 5;
        }
        if (!com.ss.android.socialbase.downloader.jy.j.cw().j("get_download_info_by_list")) {
            return 4;
        }
        JSONArray up = jVar.up("ah_plans");
        int i6 = -1;
        if (up != null) {
            int length = up.length();
            for (int i7 = 0; i7 < length; i7++) {
                JSONObject optJSONObject = up.optJSONObject(i7);
                if (com.ss.android.socialbase.appdownloader.m.b.f(optJSONObject)) {
                    String optString = optJSONObject.optString("type");
                    if ("plan_a".equals(optString) || "plan_b".equals(optString) || "plan_e".equals(optString) || "plan_f".equals(optString)) {
                        i6 = d(optJSONObject, jVar).f38360b;
                        if (i6 == 0) {
                            return 0;
                        }
                    } else if ("plan_d".equalsIgnoreCase(optString) || "plan_h".equalsIgnoreCase(optString) || ("plan_g".equalsIgnoreCase(optString) && (i6 = A(optJSONObject, jVar).f38360b) == 0)) {
                        return 0;
                    }
                }
            }
        }
        return i6;
    }

    @NonNull
    public static com.ss.android.socialbase.appdownloader.d d(JSONObject jSONObject, com.ss.android.socialbase.downloader.jy.j jVar) {
        com.ss.android.socialbase.appdownloader.d dVar = new com.ss.android.socialbase.appdownloader.d();
        if (jSONObject != null) {
            String optString = jSONObject.optString("type");
            dVar.f38359a = optString;
            if ("plan_b".equals(optString)) {
                dVar.f38363e = "custom";
                if (com.ss.android.socialbase.appdownloader.j.i.b(com.ss.android.socialbase.downloader.downloader.cw.nd(), "custom", jSONObject, jVar)) {
                    dVar.f38360b = 0;
                    return dVar;
                }
                k(dVar, 3);
                return dVar;
            }
            String optString2 = jSONObject.optString("device_plans");
            dVar.f38363e = optString2;
            if (!TextUtils.isEmpty(optString2)) {
                for (String str : optString2.split(",")) {
                    if (com.ss.android.socialbase.appdownloader.j.i.b(com.ss.android.socialbase.downloader.downloader.cw.nd(), str, jSONObject, jVar)) {
                        dVar.f38360b = 0;
                        return dVar;
                    }
                    k(dVar, 3);
                }
            }
        }
        return dVar;
    }

    public static com.ss.android.socialbase.appdownloader.d e(JSONObject jSONObject, String str, Context context, com.ss.android.socialbase.downloader.jy.j jVar) {
        com.ss.android.socialbase.appdownloader.d dVar = new com.ss.android.socialbase.appdownloader.d();
        if (jSONObject != null && com.ss.android.socialbase.appdownloader.m.e.e()) {
            dVar.f38359a = jSONObject.optString("type");
            if (jVar.j("bi", 0) == 1) {
                dVar.f38360b = 0;
                return dVar;
            }
            if (n(context)) {
                dVar.f38360b = 2;
                return dVar;
            }
            if (com.ss.android.socialbase.appdownloader.m.b.b(str) != null) {
                dVar.f38360b = 0;
                return dVar;
            }
            dVar.f38360b = 9;
        }
        return dVar;
    }

    public static void h(int i6, JSONObject jSONObject) {
        int i7 = 1;
        boolean z5 = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z5) {
            i7 = 2;
        }
        try {
            jSONObject2.put("scene", i7);
        } catch (Exception e6) {
            vl.j(e6);
        }
        com.ss.android.socialbase.downloader.downloader.cw.ol().xt(i6, "guide_auth_dialog_confirm", jSONObject2);
    }

    private static void j(Context context, Intent intent, int i6, JSONObject jSONObject, g gVar) {
        if (f38460c != null) {
            com.ss.android.socialbase.downloader.j.j.j().xt(f38460c);
            f38460c = null;
        }
        f38460c = new d(context, intent, i6, jSONObject, gVar);
        com.ss.android.socialbase.downloader.j.j.j().j(f38460c);
    }

    private static void k(com.ss.android.socialbase.appdownloader.d dVar, int i6) {
        int i7 = dVar.f38360b;
        if (i7 != -1) {
            dVar.f38360b = (i7 * 10) + i6;
        } else {
            dVar.f38360b = i6;
        }
    }

    public static void l(c cVar) {
        f38459b = cVar;
    }

    public static boolean m() {
        return f.f38474h == 1;
    }

    private static boolean v(Context context, @NonNull cw cwVar, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.d dVar, com.ss.android.socialbase.downloader.jy.j jVar) {
        boolean z5;
        String optString = jSONObject.optString("type");
        dVar.f38359a = optString;
        Intent xt = com.ss.android.socialbase.appdownloader.j.i.a(context, "vbi", jSONObject, cwVar).xt();
        StringBuilder sb = new StringBuilder();
        try {
            z5 = E(context, xt);
        } catch (Throwable th) {
            sb.append(optString);
            sb.append(" startActivity failed : ");
            sb.append(g(th));
            k(dVar, 1);
            z5 = false;
        }
        if (z5) {
            dVar.f38360b = 0;
        } else {
            dVar.f38361c = sb.toString();
        }
        return true;
    }

    private static void x(int i6, JSONObject jSONObject) {
        int i7 = 1;
        boolean z5 = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z5) {
            i7 = 2;
        }
        try {
            jSONObject2.put("scene", i7);
        } catch (Exception e6) {
            vl.j(e6);
        }
        com.ss.android.socialbase.downloader.downloader.cw.ol().xt(i6, "guide_auth_dialog_show", jSONObject2);
    }

    public static String g(Throwable th) {
        String th2 = th.toString();
        if (th2.length() > 800) {
            return th2.substring(0, 500);
        }
        return th2;
    }

    public static boolean t(Context context, cw cwVar, Intent intent, boolean z5) {
        JSONArray up = com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).up("ah_plans");
        if (up != null) {
            int length = up.length();
            for (int i6 = 0; i6 < length; i6++) {
                JSONObject optJSONObject = up.optJSONObject(i6);
                if (com.ss.android.socialbase.appdownloader.m.b.f(optJSONObject) && s(context, cwVar, intent, optJSONObject, z5)) {
                    return true;
                }
            }
        }
        return false;
    }
}
