package cn.jiguang.h;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jiguang.bz.j;
import cn.jiguang.m.c;
import com.amap.api.services.core.AMapException;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c extends cn.jiguang.m.a {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f2991a;

    /* renamed from: b, reason: collision with root package name */
    private Context f2992b;

    /* renamed from: c, reason: collision with root package name */
    private Set<cn.jiguang.common.app.entity.b> f2993c;

    /* renamed from: d, reason: collision with root package name */
    private Set<cn.jiguang.common.app.entity.b> f2994d;

    /* renamed from: e, reason: collision with root package name */
    private Set<cn.jiguang.common.app.entity.b> f2995e;

    /* renamed from: f, reason: collision with root package name */
    private List<cn.jiguang.common.app.entity.b> f2996f;

    /* renamed from: cn.jiguang.h.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public class a extends cn.jiguang.by.b {

        /* renamed from: b, reason: collision with root package name */
        private Context f2998b;

        /* renamed from: c, reason: collision with root package name */
        private Intent f2999c;

        a(Context context, Intent intent) {
            this.f2998b = context;
            this.f2999c = intent;
            this.f2653h = "JAppMovement#MovementAction";
        }

        @Override // cn.jiguang.by.b
        public void a() {
            try {
                c.this.b(this.f2998b, this.f2999c);
            } catch (Throwable th) {
                cn.jiguang.bb.f.i("JAppMovement", "dealMovementAction throwable:" + th.getMessage());
            }
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final c f3000a = new c(null);
    }

    private c() {
        this.f2991a = new AtomicBoolean(true);
    }

    public static c a() {
        return b.f3000a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, Intent intent) {
        String dataString;
        if (cn.jiguang.g.a.a().g(AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR)) {
            return;
        }
        String action = intent.getAction();
        if (action == null || TextUtils.isEmpty(action)) {
            cn.jiguang.bb.f.i("JAppMovement", "the action'" + action + "'is illegal");
            return;
        }
        boolean equals = action.equals(c.a.f3108l);
        if ((equals || action.equals(c.a.f3109m)) && (dataString = intent.getDataString()) != null && !TextUtils.isEmpty(dataString) && dataString.length() > 8 && dataString.startsWith("package:")) {
            String substring = dataString.substring(8);
            cn.jiguang.bb.f.c("JAppMovement", "receive the action'" + action + ",package:" + substring);
            String str = equals ? "add.catch" : "rmv.catch";
            String e6 = j.e(str);
            Set hashSet = new HashSet();
            if (!TextUtils.isEmpty(e6)) {
                hashSet = cn.jiguang.common.app.helper.b.a(e6);
            }
            cn.jiguang.common.app.entity.b f6 = f(context, substring);
            if (f6 == null) {
                f6 = new cn.jiguang.common.app.entity.b();
            }
            if (TextUtils.isEmpty(f6.f2828b) || !TextUtils.equals(f6.f2828b, substring)) {
                f6.f2828b = substring;
            }
            hashSet.add(f6);
            j.a(str, cn.jiguang.common.app.helper.b.a(hashSet));
        }
    }

    @Override // cn.jiguang.m.a
    protected void c(Context context, String str) {
        if (cn.jiguang.g.a.a().g(AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR)) {
            return;
        }
        super.c(context, str);
        this.f2991a.set(false);
        String e6 = j.e("add.catch");
        if (!TextUtils.isEmpty(e6)) {
            this.f2994d = cn.jiguang.common.app.helper.b.a(e6);
        }
        String e7 = j.e("rmv.catch");
        if (!TextUtils.isEmpty(e7)) {
            this.f2995e = cn.jiguang.common.app.helper.b.a(e7);
        }
        Set<cn.jiguang.common.app.entity.b> b6 = cn.jiguang.common.app.helper.b.b(context);
        if (b6 == null || b6.isEmpty()) {
            cn.jiguang.bb.f.i("JAppMovement", "current appList cache is empty,need collect appList first,to executeMovementAction JAppAll");
            cn.jiguang.h.b.a().d(context);
            return;
        }
        cn.jiguang.bb.f.c("JAppMovement", "get cache appList success");
        List<cn.jiguang.common.app.entity.b> a6 = cn.jiguang.common.app.helper.b.a(context, true, false);
        if (a6 == null || a6.isEmpty()) {
            cn.jiguang.bb.f.i("JAppMovement", "collect installedAppList failed");
            return;
        }
        cn.jiguang.bb.f.c("JAppMovement", "collect installedAppList success");
        if (a6.size() == 1 && a6.get(0).f2828b.equals(context.getPackageName())) {
            cn.jiguang.bb.f.i("JAppMovement", "installedAppList only has one app and this app is itself");
            return;
        }
        try {
            this.f2993c = new HashSet(b6);
            this.f2996f = new ArrayList(a6);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (cn.jiguang.common.app.entity.b bVar : this.f2996f) {
                for (cn.jiguang.common.app.entity.b bVar2 : this.f2993c) {
                    if (bVar2.f2828b.equals(bVar.f2828b)) {
                        arrayList2.add(bVar2);
                        arrayList.add(bVar);
                    }
                }
            }
            this.f2996f.removeAll(arrayList);
            this.f2993c.removeAll(arrayList2);
            cn.jiguang.bb.f.c("JAppMovement", "currentAppInfoList size: " + this.f2996f.size() + ", installedJAppInfoCache size: " + this.f2993c.size());
        } catch (Throwable th) {
            this.f2996f.clear();
            this.f2993c.clear();
            cn.jiguang.bb.f.i("JAppMovement", "currentAppInfoList throwable=" + th);
        }
        try {
            Set<cn.jiguang.common.app.entity.b> set = this.f2994d;
            if (set != null && !set.isEmpty()) {
                Iterator<cn.jiguang.common.app.entity.b> it = this.f2994d.iterator();
                while (it.hasNext()) {
                    cn.jiguang.common.app.entity.b next = it.next();
                    Iterator<cn.jiguang.common.app.entity.b> it2 = this.f2996f.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().f2828b.equals(next.f2828b)) {
                            it.remove();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            cn.jiguang.bb.f.i("JAppMovement", "broadcastAddJAppInfoCache throwable=" + th2);
        }
        try {
            Set<cn.jiguang.common.app.entity.b> set2 = this.f2995e;
            if (set2 != null && set2.size() > 0) {
                this.f2993c.removeAll(this.f2995e);
            }
        } catch (Throwable th3) {
            cn.jiguang.bb.f.i("JAppMovement", "installedJAppInfoCache throwable=" + th3);
        }
        if (this.f2993c.isEmpty() && this.f2996f.isEmpty()) {
            cn.jiguang.bb.f.c("JAppMovement", "installedAppList has no change");
        } else {
            String a7 = cn.jiguang.common.app.helper.b.a((Collection<cn.jiguang.common.app.entity.b>) a6);
            if (!TextUtils.isEmpty(a7)) {
                cn.jiguang.bb.f.c("JAppMovement", "update installedAppList cache:" + a6);
                j.a("bal.catch", a7);
            }
        }
        Set<cn.jiguang.common.app.entity.b> set3 = this.f2995e;
        if (set3 == null || set3.isEmpty()) {
            Set<cn.jiguang.common.app.entity.b> set4 = this.f2994d;
            if (set4 == null || set4.isEmpty()) {
                cn.jiguang.bb.f.c("JAppMovement", "no broad app data");
            }
        }
    }

    /* synthetic */ c(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        this.f2992b = context;
        return "JAppMovement";
    }

    @Override // cn.jiguang.m.a
    protected boolean b(Context context, String str) {
        List<cn.jiguang.common.app.entity.b> list = this.f2996f;
        if (list != null && !list.isEmpty()) {
            return true;
        }
        Set<cn.jiguang.common.app.entity.b> set = this.f2993c;
        if (set != null && !set.isEmpty()) {
            return true;
        }
        Set<cn.jiguang.common.app.entity.b> set2 = this.f2995e;
        if (set2 != null && !set2.isEmpty()) {
            return true;
        }
        Set<cn.jiguang.common.app.entity.b> set3 = this.f2994d;
        return (set3 == null || set3.isEmpty()) ? false : true;
    }

    @Override // cn.jiguang.m.a
    protected boolean c() {
        cn.jiguang.bb.f.c("JAppMovement", "for googlePlay:false");
        return cn.jiguang.g.a.a().e(AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR);
    }

    private static cn.jiguang.common.app.entity.b f(Context context, String str) {
        Map<String, cn.jiguang.common.app.entity.b> a6 = cn.jiguang.common.app.helper.b.a(context);
        if (a6 != null) {
            cn.jiguang.common.app.entity.b bVar = a6.get(str);
            if (bVar == null) {
                return cn.jiguang.common.app.helper.b.c(context, str);
            }
            return bVar;
        }
        return cn.jiguang.common.app.helper.b.c(context, str);
    }

    public void a(Context context, Intent intent) {
        cn.jiguang.bb.f.c("JAppMovement", "executeMovementAction: [" + a(context) + "] from broadcast");
        if (c()) {
            cn.jiguang.be.b.b(new a(context, intent));
        }
    }

    @Override // cn.jiguang.m.a
    protected void d(Context context, String str) {
        Set<cn.jiguang.common.app.entity.b> set;
        Set<cn.jiguang.common.app.entity.b> set2;
        if (cn.jiguang.g.a.a().g(AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR)) {
            return;
        }
        String packageName = context.getPackageName();
        try {
            List<cn.jiguang.common.app.entity.b> list = this.f2996f;
            if (list != null && !list.isEmpty()) {
                for (cn.jiguang.common.app.entity.b bVar : this.f2996f) {
                    if (!TextUtils.equals(packageName, bVar.f2828b)) {
                        if (!cn.jiguang.common.app.helper.b.a(bVar.f2831e, "add")) {
                            a(context, bVar.f2828b, bVar.f2831e, "add", 1, bVar);
                            super.d(context, str);
                        } else {
                            cn.jiguang.h.b.a().d(context);
                        }
                    }
                }
            }
            Set<cn.jiguang.common.app.entity.b> set3 = this.f2993c;
            if (set3 != null && !set3.isEmpty()) {
                for (cn.jiguang.common.app.entity.b bVar2 : this.f2993c) {
                    if (!TextUtils.equals(packageName, bVar2.f2828b)) {
                        if (!cn.jiguang.common.app.helper.b.a(cn.jiguang.common.app.helper.b.a(cn.jiguang.common.app.helper.b.a(context, bVar2.f2828b)), "rmv")) {
                            a(context, bVar2.f2828b, -1000, "rmv", 1, bVar2);
                            super.d(context, str);
                        } else {
                            cn.jiguang.h.b.a().d(context);
                        }
                    }
                }
            }
            Set<cn.jiguang.common.app.entity.b> set4 = this.f2994d;
            if (set4 != null && !set4.isEmpty()) {
                for (cn.jiguang.common.app.entity.b bVar3 : this.f2994d) {
                    String str2 = bVar3.f2828b;
                    if (!TextUtils.equals(packageName, str2)) {
                        int a6 = cn.jiguang.common.app.helper.b.a(cn.jiguang.common.app.helper.b.a(context, str2));
                        if (!cn.jiguang.common.app.helper.b.a(a6, "add")) {
                            a(context, str2, a6, "add", 0, bVar3);
                            super.d(context, str);
                        } else {
                            cn.jiguang.h.b.a().d(context);
                        }
                    }
                }
                cn.jiguang.bb.f.c("JAppMovement", "report broad add app data");
                j.d("add.catch");
            }
            Set<cn.jiguang.common.app.entity.b> set5 = this.f2995e;
            if (set5 != null && !set5.isEmpty()) {
                for (cn.jiguang.common.app.entity.b bVar4 : this.f2995e) {
                    if (!TextUtils.equals(packageName, bVar4.f2828b)) {
                        if (!cn.jiguang.common.app.helper.b.a(cn.jiguang.common.app.helper.b.a(cn.jiguang.common.app.helper.b.a(context, bVar4.f2828b)), "rmv")) {
                            a(context, bVar4.f2828b, -1000, "rmv", 0, bVar4);
                            super.d(context, str);
                        } else {
                            cn.jiguang.h.b.a().d(context);
                        }
                    }
                }
                cn.jiguang.bb.f.c("JAppMovement", "report broad rmv app data");
                j.d("rmv.catch");
            }
            List<cn.jiguang.common.app.entity.b> list2 = this.f2996f;
            if ((list2 == null || list2.isEmpty()) && ((set = this.f2994d) == null || set.isEmpty())) {
                cn.jiguang.bb.f.c("JAppMovement", "there are no add app data to report");
            }
            Set<cn.jiguang.common.app.entity.b> set6 = this.f2993c;
            if ((set6 == null || set6.isEmpty()) && ((set2 = this.f2995e) == null || set2.isEmpty())) {
                cn.jiguang.bb.f.c("JAppMovement", "there are no remove app data to report");
            }
        } catch (Throwable unused) {
        }
        this.f2996f = null;
        this.f2993c = null;
        this.f2994d = null;
        this.f2995e = null;
    }

    public static void a(Context context, String str, int i6, String str2, int i7, cn.jiguang.common.app.entity.b bVar) {
        try {
            Map<String, cn.jiguang.common.app.entity.b> a6 = cn.jiguang.common.app.helper.b.a(context);
            String str3 = "";
            if (a6 != null) {
                cn.jiguang.common.app.entity.b bVar2 = a6.get(str);
                if (bVar2 == null || TextUtils.isEmpty(bVar2.f2827a)) {
                    bVar2 = cn.jiguang.common.app.helper.b.c(context, str);
                }
                if (bVar2 != null) {
                    str3 = bVar2.f2827a;
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.ccg.a.f41544t, str2);
            jSONObject.put("app_name", str3);
            jSONObject.put("appid", str);
            jSONObject.put(SocialConstants.PARAM_SOURCE, i7);
            long j6 = bVar.f2837k;
            if (j6 >= 0) {
                jSONObject.put("update_time", j6);
            }
            long j7 = bVar.f2836j;
            if (j7 >= 0) {
                jSONObject.put("install_time", j7);
            }
            if (i6 != -1000) {
                jSONObject.put("install_type", i6);
            }
            cn.jiguang.be.b.a(context, jSONObject, "app_add_rmv");
        } catch (JSONException e6) {
            cn.jiguang.bb.f.i("JAppMovement", "package json exception:" + e6.getMessage());
        }
    }

    @Override // cn.jiguang.m.a
    protected boolean a(Context context, String str) {
        if (this.f2991a.get()) {
            return true;
        }
        return super.a(context, str);
    }
}
