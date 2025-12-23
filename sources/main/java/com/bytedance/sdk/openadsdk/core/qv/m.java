package com.bytedance.sdk.openadsdk.core.qv;

import com.bytedance.sdk.openadsdk.core.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements r {

    /* renamed from: j, reason: collision with root package name */
    private List<r> f29953j = new ArrayList();
    private cw xt;

    @Override // com.bytedance.sdk.openadsdk.core.qv.r
    public boolean j(String str, String str2, String str3, int i6, String str4, String str5, int i7, String str6, String str7) {
        Iterator<r> it = this.f29953j.iterator();
        while (it.hasNext()) {
            if (it.next().j(str, str2, str3, i6, str4, str5, i7, str6, str7)) {
                return true;
            }
        }
        return false;
    }

    public m() {
        cw cwVar = new cw(v.xt().qa());
        this.xt = cwVar;
        this.f29953j.add(new up(cwVar));
        this.f29953j.add(new ae(this.xt));
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.r
    public boolean j(String str, String str2, String str3, String str4, int i6, String str5, String str6) {
        Iterator<r> it = this.f29953j.iterator();
        while (it.hasNext()) {
            if (it.next().j(str, str2, str3, str4, i6, str5, str6)) {
                return true;
            }
        }
        return false;
    }
}
