package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class j extends a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f41965a = "utdid";

    /* renamed from: b, reason: collision with root package name */
    private Context f41966b;

    private String g() {
        try {
            return this.f41966b.getSharedPreferences("Alvin2", 0).getString("UTDID2", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private String h() {
        try {
            return this.f41966b.getSharedPreferences("um_push_ut", 0).getString("d_id", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.f42132u)) {
                String h6 = h();
                return TextUtils.isEmpty(h6) ? g() : h6;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public j(Context context) {
        super(f41965a);
        this.f41966b = context;
    }
}
