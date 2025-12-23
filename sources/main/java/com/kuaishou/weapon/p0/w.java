package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.kuaishou.weapon.p0.jni.A;
import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes6.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private Context f36206a;

    /* renamed from: b, reason: collision with root package name */
    private int f36207b;

    /* renamed from: c, reason: collision with root package name */
    private h f36208c;

    public JSONArray a(int i6) {
        try {
            new A(this.f36206a, i6);
            JSONArray jsonObject = A.getJsonObject();
            JSONArray jSONArray = new JSONArray();
            if (jsonObject != null) {
                for (int i7 = 0; i7 < jsonObject.length(); i7++) {
                    jSONArray.put(jsonObject.get(i7));
                }
                A.setJsonObject(null);
                return jSONArray;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public JSONArray d(int i6) {
        String[] strArr;
        JSONArray jSONArray = new JSONArray();
        try {
            PackageManager packageManager = this.f36206a.getPackageManager();
            for (int i7 = 1000; i7 <= 19999; i7++) {
                try {
                    strArr = packageManager.getPackagesForUid(i7);
                } catch (Exception unused) {
                    strArr = null;
                }
                if (strArr != null) {
                    for (String str : strArr) {
                        try {
                            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                            if (i6 != 1 || (packageInfo.applicationInfo.flags & 1) != 1) {
                                v vVar = new v(packageInfo, this.f36206a);
                                vVar.h();
                                jSONArray.put(vVar.k());
                            }
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
        } catch (Exception unused3) {
        }
        return jSONArray;
    }

    public w(Context context) {
        this.f36207b = 0;
        this.f36206a = context;
        h a6 = h.a(context, "re_po_rt");
        this.f36208c = a6;
        if (a6 != null) {
            this.f36207b = a6.b(df.f36005r, 0);
        }
    }

    public JSONArray b(int i6) {
        try {
            return c(i6);
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONArray c(int i6) {
        return d(i6);
    }
}
