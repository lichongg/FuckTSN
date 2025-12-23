package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class h1 {

    /* renamed from: a, reason: collision with root package name */
    private List<f> f33583a;

    /* renamed from: b, reason: collision with root package name */
    private String f33584b;

    /* renamed from: c, reason: collision with root package name */
    private String f33585c;

    /* renamed from: d, reason: collision with root package name */
    private String f33586d;

    public void a() {
        if (!"_default_config_tag".equals(this.f33585c)) {
            b(this.f33583a, this.f33585c, this.f33584b);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (f fVar : this.f33583a) {
            String f6 = fVar.f();
            if (TextUtils.isEmpty(f6) || "oper".equals(f6)) {
                arrayList4.add(fVar);
            } else if ("maint".equals(f6)) {
                arrayList.add(fVar);
            } else if ("preins".equals(f6)) {
                arrayList2.add(fVar);
            } else if ("diffprivacy".equals(f6)) {
                arrayList3.add(fVar);
            }
        }
        b(arrayList4, "oper", "_default_config_tag");
        b(arrayList, "maint", "_default_config_tag");
        b(arrayList2, "preins", "_default_config_tag");
        b(arrayList3, "diffprivacy", "_default_config_tag");
    }

    public h1(List<f> list, String str, String str2, String str3) {
        this.f33583a = list;
        this.f33584b = str;
        this.f33585c = str2;
        this.f33586d = str3;
    }

    private void b(List<f> list, String str, String str2) {
        String str3;
        String str4;
        if (!list.isEmpty()) {
            int size = (list.size() / 500) + 1;
            int i6 = 0;
            while (i6 < size) {
                int i7 = i6 * 500;
                List<f> subList = list.subList(i7, Math.min(list.size(), i7 + 500));
                String replace = UUID.randomUUID().toString().replace("-", "");
                long currentTimeMillis = System.currentTimeMillis();
                long c6 = c.c(str2, str) * 86400000;
                ArrayList arrayList = new ArrayList();
                for (f fVar : subList) {
                    if (!h.d(fVar.d(), currentTimeMillis, c6)) {
                        arrayList.add(fVar);
                    }
                }
                if (arrayList.size() > 0) {
                    str3 = str;
                    str4 = str2;
                    new j0(str4, str3, this.f33586d, arrayList, replace).b();
                } else {
                    str3 = str;
                    str4 = str2;
                    j1.l("hmsSdk", "No data to report handler");
                }
                i6++;
                str2 = str4;
                str = str3;
            }
        }
    }
}
