package com.bytedance.sdk.openadsdk.core.qv.cw;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.ed;
import com.bytedance.sdk.openadsdk.core.multipro.xt.j;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class cw implements com.bytedance.sdk.openadsdk.core.qv.xt.cw {

    /* renamed from: j, reason: collision with root package name */
    protected boolean f29885j = true;
    protected WeakReference<j.InterfaceC0466j> xt;

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j(j.InterfaceC0466j interfaceC0466j) {
        this.xt = new WeakReference<>(interfaceC0466j);
    }

    private String m() {
        j.InterfaceC0466j interfaceC0466j;
        com.bytedance.sdk.openadsdk.core.multipro.xt.j la;
        WeakReference<j.InterfaceC0466j> weakReference = this.xt;
        if (weakReference == null || (interfaceC0466j = weakReference.get()) == null || (la = interfaceC0466j.la()) == null) {
            return null;
        }
        return la.j().toString();
    }

    protected boolean j(Context context, n nVar, String str) {
        if (!this.f29885j || !com.bytedance.sdk.openadsdk.core.rn.m.j(nVar) || !ed.j(context, nVar, uf.xt(str), str, m())) {
            return false;
        }
        TTNativePageActivity.j(this);
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void xt(boolean z5) {
        this.f29885j = z5;
    }

    public int ae() {
        return hashCode();
    }
}
