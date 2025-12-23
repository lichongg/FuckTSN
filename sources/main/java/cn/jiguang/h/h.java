package cn.jiguang.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.bz.q;
import cn.jiguang.bz.v;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class h extends cn.jiguang.m.a {

    /* renamed from: a, reason: collision with root package name */
    private Context f3019a;

    /* renamed from: b, reason: collision with root package name */
    private List<cn.jiguang.common.app.entity.c> f3020b;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final h f3022a = new h();
    }

    private h() {
    }

    public static h a() {
        return a.f3022a;
    }

    private boolean b(Context context) {
        boolean z5 = Build.VERSION.SDK_INT <= 28 && (q.a(context, com.kuaishou.weapon.p0.g.f36049i) || q.a(context, com.kuaishou.weapon.p0.g.f36050j));
        cn.jiguang.bb.f.c("JPackageList", "pl has permission is " + z5);
        return z5;
    }

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        this.f3019a = context;
        return "JPackageList";
    }

    @Override // cn.jiguang.m.a
    protected boolean b(Context context, String str) {
        return cn.jiguang.m.b.y(context, str);
    }

    @Override // cn.jiguang.m.a
    protected void c(Context context, String str) {
        if (b(context)) {
            try {
                String o5 = cn.jiguang.d.a.o(context);
                cn.jiguang.bb.f.c("JPackageList", "Jpl dataDir is " + o5);
                if (TextUtils.isEmpty(o5)) {
                    return;
                }
                String[] list = new File(o5).list(new FilenameFilter() { // from class: cn.jiguang.h.h.1
                    @Override // java.io.FilenameFilter
                    public boolean accept(File file, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            return str2.matches("^([A-Za-z]{1}[A-Za-z\\d_]*\\.)+[A-Za-z][A-Za-z\\d_]*$");
                        }
                        return false;
                    }
                });
                if (list == null || list.length <= 0) {
                    cn.jiguang.bb.f.i("JPackageList", "collect failed, pl is empty");
                    return;
                }
                if (this.f3020b == null) {
                    this.f3020b = new ArrayList();
                }
                for (String str2 : list) {
                    cn.jiguang.common.app.entity.c cVar = new cn.jiguang.common.app.entity.c();
                    cVar.f2839a = str2;
                    PackageInfo packageInfo = new PackageInfo();
                    packageInfo.packageName = str2;
                    cVar.f2840b = cn.jiguang.common.app.helper.b.a(context, packageInfo, v.f2786a);
                    cVar.f2841c = cn.jiguang.common.app.helper.b.a(context, packageInfo, v.f2787b);
                    cVar.f2842d = cn.jiguang.common.app.helper.b.a(context, packageInfo, v.f2788c);
                    try {
                        String[] split = cn.jiguang.common.app.helper.b.b(str2).split(ContainerUtils.FIELD_DELIMITER);
                        cVar.f2843e = Long.parseLong(split[0]);
                        cVar.f2844f = Long.parseLong(split[1]);
                    } catch (Throwable unused) {
                    }
                    this.f3020b.add(cVar);
                }
                if (this.f3020b.size() > 0) {
                    cn.jiguang.bb.f.c("JPackageList", "collect success, size is " + this.f3020b.size());
                    super.c(context, str);
                }
            } catch (Throwable th) {
                cn.jiguang.bb.f.i("JPackageList", "package json exception:" + th.getMessage());
            }
        }
    }

    @Override // cn.jiguang.m.a
    protected void d(Context context, String str) {
        List<cn.jiguang.common.app.entity.c> list;
        if (b(context)) {
            try {
                list = this.f3020b;
            } catch (Throwable th) {
                cn.jiguang.bb.f.i("JPackageList", "package json exception:" + th.getMessage());
            }
            if (list != null && !list.isEmpty()) {
                JSONArray a6 = a(this.f3020b);
                super.d(context, str);
                ArrayList<JSONArray> a7 = cn.jiguang.common.app.helper.b.a(a6);
                if (a7 != null && !a7.isEmpty()) {
                    int size = a7.size();
                    int i6 = 0;
                    while (i6 < size) {
                        JSONObject jSONObject = new JSONObject();
                        JSONArray jSONArray = a7.get(i6);
                        i6++;
                        jSONObject.put("slice_index", i6);
                        jSONObject.put("slice_count", size);
                        jSONObject.put("data", jSONArray);
                        cn.jiguang.be.b.a(context, jSONObject, "package_list");
                        super.d(context, str);
                    }
                    this.f3020b = null;
                    return;
                }
                return;
            }
            cn.jiguang.bb.f.i("JPackageList", "there are no data to report");
        }
    }

    private JSONArray a(List<cn.jiguang.common.app.entity.c> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<cn.jiguang.common.app.entity.c> it = list.iterator();
        while (it.hasNext()) {
            JSONObject a6 = it.next().a(128);
            if (a6 != null) {
                jSONArray.put(a6);
            }
        }
        return jSONArray;
    }

    @Override // cn.jiguang.m.a
    protected boolean a(Context context, String str) {
        return cn.jiguang.m.b.x(context, str);
    }
}
