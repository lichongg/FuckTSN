package com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout;

import android.widget.FrameLayout;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.xt.xt;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class AbstractEndCardFrameLayout extends FrameLayout {

    /* renamed from: j, reason: collision with root package name */
    protected final TTBaseVideoActivity f28260j;
    protected final n xt;

    public abstract SSWebView getEndCardWebView();

    public abstract SSWebView getPlayableWebView();

    public abstract FrameLayout getVideoArea();

    abstract void j();

    public abstract void setClickListener(xt xtVar);

    public AbstractEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, n nVar) {
        super(tTBaseVideoActivity);
        this.f28260j = tTBaseVideoActivity;
        this.xt = nVar;
        j();
    }

    public void xt() {
    }
}
