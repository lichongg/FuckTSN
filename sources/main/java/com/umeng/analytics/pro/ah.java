package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ah {

    /* renamed from: a, reason: collision with root package name */
    private String f40831a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<ai> f40832b = new ArrayList<>();

    private void a() {
        try {
            if (!this.f40831a.contains(",")) {
                String str = this.f40831a;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String trim = str.trim();
                if (this.f40832b != null) {
                    this.f40832b.add(new ai(trim));
                    return;
                }
                return;
            }
            for (String str2 : this.f40831a.split(",")) {
                if (!TextUtils.isEmpty(str2)) {
                    String trim2 = str2.trim();
                    if (this.f40832b != null) {
                        this.f40832b.add(new ai(trim2));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public ah(String str) {
        this.f40831a = "";
        this.f40831a = str;
        if (!TextUtils.isEmpty(str)) {
            a();
        }
    }

    public boolean a(int i6) {
        try {
            ArrayList<ai> arrayList = this.f40832b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i7 = 0; i7 < size; i7++) {
                    ai aiVar = this.f40832b.get(i7);
                    if (aiVar != null && aiVar.a(i6)) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
