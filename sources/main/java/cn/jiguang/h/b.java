package cn.jiguang.h;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bz.j;
import com.amap.api.services.core.AMapException;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends cn.jiguang.m.a {

    /* renamed from: a, reason: collision with root package name */
    public static int f2977a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static int f2978b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static int f2979c = 0;

    /* renamed from: h, reason: collision with root package name */
    private static int f2980h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static int f2981i = 1;

    /* renamed from: j, reason: collision with root package name */
    private static int f2982j;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f2983d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f2984e;

    /* renamed from: f, reason: collision with root package name */
    private Context f2985f;

    /* renamed from: g, reason: collision with root package name */
    private List<cn.jiguang.common.app.entity.b> f2986g;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2987k;

    /* renamed from: l, reason: collision with root package name */
    private Set<cn.jiguang.common.app.entity.b> f2988l;

    /* renamed from: m, reason: collision with root package name */
    private List<cn.jiguang.common.app.entity.b> f2989m;

    /* renamed from: cn.jiguang.h.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f2990a = new b(null);
    }

    private b() {
        this.f2983d = new AtomicBoolean(true);
        this.f2984e = false;
    }

    public static b a() {
        return a.f2990a;
    }

    private void b(Context context) {
        if (cn.jiguang.g.a.a().g(AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR)) {
            cn.jiguang.bb.f.c("JAppAll", "report AppAddRmv");
            String packageName = context.getPackageName();
            try {
                List<cn.jiguang.common.app.entity.b> list = this.f2989m;
                if (list != null && !list.isEmpty()) {
                    for (cn.jiguang.common.app.entity.b bVar : this.f2989m) {
                        if (!TextUtils.equals(packageName, bVar.f2828b) && !cn.jiguang.common.app.helper.b.a(bVar.f2831e, "add")) {
                            c.a(context, bVar.f2828b, bVar.f2831e, "add", 1, bVar);
                        }
                    }
                }
                Set<cn.jiguang.common.app.entity.b> set = this.f2988l;
                if (set != null && !set.isEmpty()) {
                    for (cn.jiguang.common.app.entity.b bVar2 : this.f2988l) {
                        if (!TextUtils.equals(packageName, bVar2.f2828b) && !cn.jiguang.common.app.helper.b.a(cn.jiguang.common.app.helper.b.a(cn.jiguang.common.app.helper.b.a(context, bVar2.f2828b)), "rmv")) {
                            c.a(context, bVar2.f2828b, -1000, "rmv", 1, bVar2);
                        }
                    }
                }
                List<cn.jiguang.common.app.entity.b> list2 = this.f2989m;
                if (list2 == null || list2.isEmpty()) {
                    cn.jiguang.bb.f.c("JAppAll", "there are no add app data to report");
                }
                Set<cn.jiguang.common.app.entity.b> set2 = this.f2988l;
                if (set2 == null || set2.isEmpty()) {
                    cn.jiguang.bb.f.c("JAppAll", "there are no remove app data to report");
                }
            } catch (Throwable unused) {
            }
            this.f2989m = null;
            this.f2988l = null;
        }
    }

    @Override // cn.jiguang.m.a
    protected void c(Context context, String str) {
        cn.jiguang.bw.a.a().f((Object) 2083);
        if (!this.f2984e) {
            this.f2987k = cn.jiguang.g.a.a().e(1100);
        }
        if (this.f2984e || this.f2987k) {
            cn.jiguang.bb.f.c("JAppAll", "doBusiness isCmd :" + this.f2984e);
            this.f2983d.set(false);
            List<cn.jiguang.common.app.entity.b> a6 = cn.jiguang.common.app.helper.b.a(context, true, true, this.f2984e);
            this.f2986g = a6;
            if (a6 == null || a6.isEmpty()) {
                cn.jiguang.bb.f.c("JAppAll", "collect failed, installedAppList is empty");
                cn.jiguang.bw.a.a().f((Object) 2042);
                return;
            }
            cn.jiguang.bb.f.c("JAppAll", "collect success");
            cn.jiguang.bw.a.a().f(Integer.valueOf(GLMapStaticValue.AM_PARAMETERNAME_SETCOLORBLINDSTATUS));
            super.c(context, str);
            a(context, this.f2986g);
            String a7 = cn.jiguang.common.app.helper.b.a((Collection<cn.jiguang.common.app.entity.b>) this.f2986g);
            if (TextUtils.isEmpty(a7)) {
                return;
            }
            cn.jiguang.bb.f.c("JAppAll", "save appList [" + a7 + "]");
            cn.jiguang.bw.a.a().f((Object) 2060);
            j.a("bal.catch", a7);
        }
    }

    /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        this.f2985f = context;
        return "JAppAll";
    }

    @Override // cn.jiguang.m.a
    protected boolean b(Context context, String str) {
        if (!this.f2984e) {
            return super.b(context, str);
        }
        cn.jiguang.bb.f.c("JAppAll", "isReportEnable isCmd true");
        return true;
    }

    @Override // cn.jiguang.m.a
    protected boolean c() {
        if (!this.f2984e) {
            return cn.jiguang.g.a.a().e(1100);
        }
        cn.jiguang.bb.f.c("JAppAll", "isActionUserEnable isCmd true");
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.StringBuilder] */
    @Override // cn.jiguang.m.a
    protected void d(Context context, String str) {
        List<cn.jiguang.common.app.entity.b> list;
        cn.jiguang.bw.a a6;
        int i6;
        cn.jiguang.bw.a.a().f((Object) 2084);
        f2982j = !this.f2984e ? f2980h : f2981i;
        int i7 = 0;
        a(false);
        try {
            list = this.f2986g;
        } catch (JSONException e6) {
            cn.jiguang.bb.f.i("JAppAll", "package json exception:" + e6.getMessage());
        }
        if (list != null && !list.isEmpty()) {
            JSONArray a7 = a(this.f2986g);
            if (a7 != null && a7.length() != 0) {
                ArrayList<JSONArray> a8 = cn.jiguang.common.app.helper.b.a(a7);
                if (a8 != null && !a8.isEmpty()) {
                    boolean d6 = cn.jiguang.common.app.helper.b.d(context);
                    ?? r32 = d6;
                    if (d6) {
                        r32 = d6;
                        if (this.f2986g.size() == 1) {
                            r32 = 2;
                        }
                    }
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(f2982j);
                    jSONArray.put(f2979c);
                    int size = a8.size();
                    while (i7 < size) {
                        ?? jSONObject = new JSONObject();
                        JSONArray jSONArray2 = a8.get(i7);
                        i7++;
                        jSONObject.put("si", i7);
                        jSONObject.put("sc", size);
                        jSONObject.put("s", jSONArray);
                        jSONObject.put("q", r32);
                        jSONObject.put("pv", 1);
                        jSONObject.put("da", jSONArray2);
                        cn.jiguang.bb.f.c("JAppAll", "report json:" + jSONObject);
                        cn.jiguang.be.b.a(context, jSONObject, "app_list");
                    }
                    b(context);
                    super.d(context, str);
                    cn.jiguang.bw.a.a().f((Object) 2064);
                    this.f2986g = null;
                    return;
                }
                a6 = cn.jiguang.bw.a.a();
                i6 = 2071;
                a6.f(i6);
            }
            a6 = cn.jiguang.bw.a.a();
            i6 = 2070;
            a6.f(i6);
        }
        cn.jiguang.bb.f.i("JAppAll", "there are no data to report");
        a6 = cn.jiguang.bw.a.a();
        i6 = 2069;
        a6.f(i6);
    }

    @Override // cn.jiguang.m.a
    protected boolean e(Context context, String str) {
        if (!this.f2984e) {
            return super.e(context, str);
        }
        cn.jiguang.bb.f.c("JAppAll", "isProtectionTime isCmd true");
        return true;
    }

    private JSONArray a(List<cn.jiguang.common.app.entity.b> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<cn.jiguang.common.app.entity.b> it = list.iterator();
        while (it.hasNext()) {
            JSONObject a6 = it.next().a(128);
            if (a6 != null) {
                jSONArray.put(a6);
            }
        }
        return jSONArray;
    }

    public void a(int i6) {
        f2979c = i6;
    }

    private void a(Context context, List<cn.jiguang.common.app.entity.b> list) {
        String str;
        try {
            if (cn.jiguang.g.a.a().g(AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR)) {
                if (list != null && !list.isEmpty()) {
                    if (list.size() == 1 && list.get(0).f2828b.equals(context.getPackageName())) {
                        str = "installedAppList only has one app and this app is itself";
                    } else {
                        Set<cn.jiguang.common.app.entity.b> b6 = cn.jiguang.common.app.helper.b.b(context);
                        if (b6 != null && !b6.isEmpty()) {
                            this.f2988l = new HashSet(b6);
                            this.f2989m = new ArrayList(list);
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            for (cn.jiguang.common.app.entity.b bVar : this.f2989m) {
                                for (cn.jiguang.common.app.entity.b bVar2 : this.f2988l) {
                                    if (bVar2.f2828b.equals(bVar.f2828b)) {
                                        arrayList2.add(bVar2);
                                        arrayList.add(bVar);
                                    }
                                }
                            }
                            this.f2989m.removeAll(arrayList);
                            this.f2988l.removeAll(arrayList2);
                            return;
                        }
                        str = "doBusinessAppAddRmv installed JAppInfo Cache is null";
                    }
                    cn.jiguang.bb.f.i("JAppAll", str);
                }
                str = "doBusinessAppAddRmv installedAppList is empty";
                cn.jiguang.bb.f.i("JAppAll", str);
            }
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JAppAll", "doBusinessAppAddRmv throwable=" + th);
        }
    }

    public void a(boolean z5) {
        this.f2984e = z5;
    }

    @Override // cn.jiguang.m.a
    protected boolean a(Context context, String str) {
        if (this.f2983d.get()) {
            return true;
        }
        if (!this.f2984e) {
            return super.a(context, str);
        }
        cn.jiguang.bb.f.c("JAppAll", "isBusinessEnable isCmd true");
        return true;
    }
}
