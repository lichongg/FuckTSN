package com.baidu.liantian.rp.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.liantian.b;
import com.baidu.liantian.b.e;
import com.baidu.liantian.b.h;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public Context f10493a;

    public a(Context context) {
        this.f10493a = context;
    }

    public final boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        b.a();
        try {
            TextUtils.isEmpty(str2);
            String str3 = e.b() + "p/1/r";
            b.a();
            String a6 = h.a(this.f10493a, str3, str);
            if (TextUtils.isEmpty(a6)) {
                return false;
            }
            if (new JSONObject(a6).getInt("response") == 1) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            e.a();
            return true;
        }
    }
}
