package com.bytedance.sdk.openadsdk.core.ugeno.express;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;

/* loaded from: D:\Downloads\app\classes4.dex */
public class UGTimerContainer extends FrameLayout {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.oq.j f30693j;

    void setTimerHolder(com.bytedance.sdk.openadsdk.core.ugeno.oq.j jVar) {
        this.f30693j = jVar;
    }

    public UGTimerContainer(@NonNull Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
        com.bytedance.sdk.openadsdk.core.ugeno.oq.j jVar = this.f30693j;
        if (jVar != null) {
            if (i6 == 0) {
                jVar.j();
            } else {
                jVar.xt();
            }
        }
    }
}
