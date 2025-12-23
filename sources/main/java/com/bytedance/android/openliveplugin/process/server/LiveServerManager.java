package com.bytedance.android.openliveplugin.process.server;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.dy.sdk.pangle.ZeusPlatformServerManager;
import com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils;
import com.bytedance.android.openliveplugin.stub.logger.TTLogger;
import com.bytedance.sdk.openadsdk.api.m;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes3.dex */
public class LiveServerManager extends ZeusPlatformServerManager {
    @Override // com.bytedance.pangle.servermanager.AbsServerManager, android.content.ContentProvider
    public boolean onCreate() {
        TTLogger.d("LiveServerManager onCreate");
        if (getContext() != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(getContext().getApplicationContext());
            if (origApplicationContext instanceof Application) {
                try {
                    TTLogger.d("LiveServerManager initZeus");
                    ZeusPlatformUtils.initZeus((Application) origApplicationContext, true, "com.byted.live.lite");
                } catch (Throwable th) {
                    m.j(th);
                }
            }
        }
        return super.onCreate();
    }
}
