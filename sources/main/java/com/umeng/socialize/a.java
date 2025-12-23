package com.umeng.socialize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.QueuedWork;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.handler.UMSSOHandler;
import com.umeng.socialize.net.analytics.SocialAnalytics;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.dplus.DplusApi;
import com.umeng.socialize.uploadlog.UMLog;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeSpUtils;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import com.umeng.socialize.utils.UrlUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class a extends UMShareAPI {

    /* renamed from: a, reason: collision with root package name */
    private final com.umeng.socialize.b.a f42180a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.socialize.a$a, reason: collision with other inner class name */
    private static class C0835a extends QueuedWork.UMAsyncTask<Void> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f42203a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f42204b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f42205c = SocializeUtils.isHasDplusCache();

        private boolean b() {
            return this.f42203a.getSharedPreferences(SocializeConstants.SOCIAL_PREFERENCE_NAME, 0).getBoolean("newinstall", false);
        }

        private void c() {
            SharedPreferences.Editor edit = this.f42203a.getSharedPreferences(SocializeConstants.SOCIAL_PREFERENCE_NAME, 0).edit();
            edit.putBoolean("newinstall", true);
            edit.commit();
        }

        public C0835a(Context context) {
            this.f42203a = context;
            this.f42204b = SocializeUtils.isToday(SocializeSpUtils.getTime(context));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.umeng.socialize.common.QueuedWork.UMAsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground() {
            boolean b6 = b();
            SLog.E(UmengText.CHECK.SDKVERSION + "7.3.2");
            if (!this.f42204b) {
                SocializeSpUtils.putTime(this.f42203a);
                DplusApi.uploadDAU(ContextUtil.getContext());
                SocialAnalytics.dauStats(this.f42203a, true);
            } else if (this.f42205c) {
                DplusApi.uploadDAU(ContextUtil.getContext());
                SocialAnalytics.dauStats(this.f42203a, true);
            }
            SocialAnalytics.verifyStats(this.f42203a);
            if (b6) {
                Context context = this.f42203a;
                UMWorkDispatch.sendEvent(context, SocializeConstants.AZX_TRIGGER, CommonNetImpl.get(context), null, 10000L);
                return null;
            }
            c();
            return null;
        }
    }

    private boolean a(Activity activity, SHARE_MEDIA share_media) {
        boolean z5 = false;
        for (Method method : activity.getClass().getDeclaredMethods()) {
            if (method.getName().equals("onActivityResult")) {
                z5 = true;
            }
        }
        if (!z5) {
            SLog.mutlE(UmengText.CHECK.ALL_NO_ONACTIVITY, UrlUtil.ALL_NO_ONACTIVITY);
        }
        if (share_media == SHARE_MEDIA.QQ) {
            SLog.E(UmengTool.checkQQByself(activity));
            return true;
        }
        if (share_media == SHARE_MEDIA.WEIXIN) {
            SLog.E(UmengTool.checkWxBySelf(activity));
            return true;
        }
        if (share_media == SHARE_MEDIA.SINA) {
            SLog.E(UmengTool.checkSinaBySelf(activity));
            return true;
        }
        if (share_media == SHARE_MEDIA.FACEBOOK) {
            SLog.E(UmengTool.checkFBByself(activity));
            return true;
        }
        if (share_media == SHARE_MEDIA.VKONTAKTE) {
            SLog.E(UmengTool.checkVKByself(activity));
        }
        if (share_media == SHARE_MEDIA.LINKEDIN) {
            SLog.E(UmengTool.checkLinkin(activity));
        }
        if (share_media == SHARE_MEDIA.KAKAO) {
            SLog.E(UmengTool.checkKakao(activity));
        }
        return true;
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void deleteOauth(final Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        if (activity != null) {
            new QueuedWork.DialogThread<Void>(activity) { // from class: com.umeng.socialize.a.2
                @Override // com.umeng.socialize.common.QueuedWork.UMAsyncTask
                protected Object doInBackground() {
                    a.this.f42180a.a(activity, share_media, uMAuthListener);
                    return null;
                }
            }.execute();
        } else {
            SLog.E(UmengText.CHECK.ACTIVITYNULL);
        }
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void fetchAuthResultWithBundle(Activity activity, Bundle bundle, UMAuthListener uMAuthListener) {
        this.f42180a.a(activity, bundle, uMAuthListener);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public UMSSOHandler getHandler(SHARE_MEDIA share_media) {
        com.umeng.socialize.b.a aVar = this.f42180a;
        if (aVar != null) {
            return aVar.a(share_media);
        }
        return null;
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void getPlatformInfo(final Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        if (activity == null) {
            SLog.E(UmengText.CHECK.ACTIVITYNULL);
            return;
        }
        if (!UMConfigure.getInitStatus()) {
            SLog.selfLog(UmengText.CHECK.NOINT);
            return;
        }
        UMLog.putAuth();
        if (SLog.isDebug()) {
            if (!a(activity, share_media)) {
                return;
            } else {
                UrlUtil.getInfoPrint(share_media);
            }
        }
        new QueuedWork.DialogThread<Void>(activity) { // from class: com.umeng.socialize.a.3
            @Override // com.umeng.socialize.common.QueuedWork.UMAsyncTask
            protected Object doInBackground() {
                a.this.f42180a.b(activity, share_media, uMAuthListener);
                Context context = ContextUtil.getContext();
                if (context == null) {
                    return null;
                }
                UMWorkDispatch.sendEvent(context, SocializeConstants.AZX_TRIGGER, CommonNetImpl.get(context), null, 5000L);
                return null;
            }
        }.execute();
    }

    @Override // com.umeng.socialize.UMShareAPI
    public String getversion(Activity activity, SHARE_MEDIA share_media) {
        return this.f42180a.c(activity, share_media);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public boolean isAuthorize(Activity activity, SHARE_MEDIA share_media) {
        return this.f42180a.d(activity, share_media);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public boolean isInstall(Activity activity, SHARE_MEDIA share_media) {
        return this.f42180a.a(activity, share_media);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public boolean isSupport(Activity activity, SHARE_MEDIA share_media) {
        return this.f42180a.b(activity, share_media);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void onActivityResult(int i6, int i7, Intent intent) {
        com.umeng.socialize.b.a aVar = this.f42180a;
        if (aVar != null) {
            aVar.a(i6, i7, intent);
        } else {
            SLog.E(UmengText.CHECK.ROUTERNULL);
        }
        SLog.I(UmengText.CHECK.getActivityResult(i6, i7));
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void onSaveInstanceState(Bundle bundle) {
        this.f42180a.a(bundle);
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void release() {
        this.f42180a.a();
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void setShareConfig(UMShareConfig uMShareConfig) {
        this.f42180a.a(uMShareConfig);
    }

    protected a(Context context) {
        ContextUtil.setContext(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.f42180a = new com.umeng.socialize.b.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        String currentProcessName = UMFrUtils.getCurrentProcessName(context);
        if (!TextUtils.isEmpty(currentProcessName) && currentProcessName.equals(ContextUtil.getPackageName())) {
            new C0835a(StubApp.getOrigApplicationContext(context.getApplicationContext())).execute();
        }
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void doOauthVerify(final Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        UMLog.putAuth();
        if (!UMConfigure.getInitStatus()) {
            SLog.selfLog(UmengText.CHECK.NOINT);
            return;
        }
        if (SLog.isDebug() && !a(activity, share_media)) {
            return;
        }
        if (activity != null) {
            new QueuedWork.DialogThread<Void>(activity) { // from class: com.umeng.socialize.a.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.umeng.socialize.common.QueuedWork.UMAsyncTask
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Void doInBackground() {
                    a.this.f42180a.c(activity, share_media, uMAuthListener);
                    return null;
                }
            }.execute();
        } else {
            SLog.E(UmengText.CHECK.ACTIVITYNULL);
        }
    }

    @Override // com.umeng.socialize.UMShareAPI
    public void doShare(Activity activity, final ShareAction shareAction, final UMShareListener uMShareListener) {
        UMLog.putShare();
        if (!UMConfigure.getInitStatus()) {
            SLog.selfLog(UmengText.CHECK.NOINT);
            return;
        }
        final WeakReference weakReference = new WeakReference(activity);
        if (SLog.isDebug()) {
            if (!a(activity, shareAction.getPlatform())) {
                return;
            } else {
                UrlUtil.sharePrint(shareAction.getPlatform());
            }
        }
        if (weakReference.get() != null && !((Activity) weakReference.get()).isFinishing()) {
            new QueuedWork.DialogThread<Void>((Context) weakReference.get()) { // from class: com.umeng.socialize.a.4
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.umeng.socialize.common.QueuedWork.UMAsyncTask
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Void doInBackground() {
                    if (weakReference.get() != null && !((Activity) weakReference.get()).isFinishing()) {
                        a.this.f42180a.a((Activity) weakReference.get(), shareAction, uMShareListener);
                        Context context = ContextUtil.getContext();
                        if (context != null) {
                            UMWorkDispatch.sendEvent(context, SocializeConstants.AZX_TRIGGER, CommonNetImpl.get(context), null, 5000L);
                        }
                    }
                    return null;
                }
            }.execute();
        } else {
            SLog.E(UmengText.CHECK.ACTIVITYNULL);
        }
    }
}
