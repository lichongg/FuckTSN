package com.bytedance.sdk.openadsdk.stub.server;

import android.app.Application;
import android.content.Context;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.api.up;
import com.bytedance.sdk.openadsdk.cw.r;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes4.dex */
public class MainServerManager extends AbsServerManager {
    @Override // com.bytedance.pangle.servermanager.AbsServerManager, android.content.ContentProvider
    public boolean onCreate() {
        Context origApplicationContext = StubApp.getOrigApplicationContext(getContext().getApplicationContext());
        TTAppContextHolder.setContext(origApplicationContext);
        if (!up.j() && (origApplicationContext instanceof Application)) {
            ((Application) origApplicationContext).registerActivityLifecycleCallbacks(r.j().xt());
        }
        return super.onCreate();
    }
}
