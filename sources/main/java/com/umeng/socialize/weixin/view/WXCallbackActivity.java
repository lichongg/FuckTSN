package com.umeng.socialize.weixin.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.stub.StubApp;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.handler.UMWXHandler;
import com.umeng.socialize.utils.SLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class WXCallbackActivity extends Activity implements IWXAPIEventHandler {
    private final String TAG = "WXCallbackActivity";
    protected UMWXHandler mWxHandler = null;

    protected void handleIntent(Intent intent) {
        this.mWxHandler.getWXApi().handleIntent(intent, this);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        UMWXHandler uMWXHandler = this.mWxHandler;
        if (uMWXHandler != null) {
            uMWXHandler.getWXEventHandler().onReq(baseReq);
        }
        finish();
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        SLog.I("WXCallbackActivity 分发回调");
        UMWXHandler uMWXHandler = this.mWxHandler;
        if (uMWXHandler != null && baseResp != null) {
            try {
                uMWXHandler.getWXEventHandler().onResp(baseResp);
            } catch (Exception e6) {
                SLog.error(e6);
            }
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SLog.I("WXCallbackActivity onCreate");
        UMShareAPI uMShareAPI = UMShareAPI.get(StubApp.getOrigApplicationContext(getApplicationContext()));
        SHARE_MEDIA share_media = SHARE_MEDIA.WEIXIN;
        this.mWxHandler = (UMWXHandler) uMShareAPI.getHandler(share_media);
        SLog.I("WXCallbackActivity mWxHandler：" + this.mWxHandler);
        this.mWxHandler.onCreate(StubApp.getOrigApplicationContext(getApplicationContext()), PlatformConfig.getPlatform(share_media));
        handleIntent(getIntent());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        SLog.I("WXCallbackActivity onNewIntent");
        setIntent(intent);
        UMShareAPI uMShareAPI = UMShareAPI.get(StubApp.getOrigApplicationContext(getApplicationContext()));
        SHARE_MEDIA share_media = SHARE_MEDIA.WEIXIN;
        UMWXHandler uMWXHandler = (UMWXHandler) uMShareAPI.getHandler(share_media);
        this.mWxHandler = uMWXHandler;
        uMWXHandler.onCreate(StubApp.getOrigApplicationContext(getApplicationContext()), PlatformConfig.getPlatform(share_media));
        handleIntent(intent);
    }
}
