package com.bytedance.sdk.openadsdk.tools.floatwindow.page;

/* loaded from: D:\Downloads\app\classes4.dex */
public class UGenTestToolsPage extends BaseToolPage {

    /* renamed from: j, reason: collision with root package name */
    private boolean f31850j;

    @Override // com.bytedance.sdk.openadsdk.tools.floatwindow.page.BaseToolPage
    public String getPageTitle() {
        return "UGen调试";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f31850j = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f31850j = false;
    }
}
