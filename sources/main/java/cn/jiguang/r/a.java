package cn.jiguang.r;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.ReportCallBack;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a implements ReportCallBack {

    /* renamed from: a, reason: collision with root package name */
    private Context f3201a;

    /* renamed from: b, reason: collision with root package name */
    private String f3202b;

    /* renamed from: c, reason: collision with root package name */
    private String f3203c;

    @Override // cn.jiguang.api.ReportCallBack
    public void onFinish(int i6) {
        cn.jiguang.bb.f.c("DeviceReport", "report finish code:" + i6);
        if (i6 != 0) {
            return;
        }
        cn.jiguang.m.b.h(this.f3201a, this.f3203c);
        if (TextUtils.isEmpty(this.f3202b)) {
            return;
        }
        cn.jiguang.m.b.u(this.f3201a, this.f3202b);
    }

    public a(Context context, String str, String str2) {
        this.f3201a = context;
        this.f3202b = str;
        this.f3203c = str2;
    }
}
