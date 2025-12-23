package com.bxkj.student.v2.common.utils;

import android.app.Activity;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class ThirdLogin {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Activity f20865a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public final class MyUMAuthListener implements UMAuthListener {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final Function1<Map<String, String>, n1> f20866a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ThirdLogin f20867b;

        /* JADX WARN: Multi-variable type inference failed */
        public MyUMAuthListener(@NotNull ThirdLogin thirdLogin, Function1<? super Map<String, String>, n1> bind) {
            g0.p(bind, "bind");
            this.f20867b = thirdLogin;
            this.f20866a = bind;
        }

        @NotNull
        public final Function1<Map<String, String>, n1> a() {
            return this.f20866a;
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onCancel(@NotNull SHARE_MEDIA platform, int i6) {
            g0.p(platform, "platform");
            ContextExtKt.q(this.f20867b.a(), "您取消了绑定");
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onComplete(@NotNull SHARE_MEDIA platform, int i6, @NotNull Map<String, String> data) {
            g0.p(platform, "platform");
            g0.p(data, "data");
            com.orhanobut.logger.j.d("platform=" + platform.name(), new Object[0]);
            com.orhanobut.logger.j.d("data=" + data, new Object[0]);
            this.f20866a.invoke(data);
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onError(@NotNull SHARE_MEDIA platform, int i6, @NotNull Throwable t5) {
            g0.p(platform, "platform");
            g0.p(t5, "t");
            com.orhanobut.logger.j.c(t5.getMessage());
            com.orhanobut.logger.j.d("action=" + i6, new Object[0]);
            ContextExtKt.q(this.f20867b.a(), "绑定失败,请稍后再试");
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onStart(@NotNull SHARE_MEDIA platform) {
            g0.p(platform, "platform");
        }
    }

    public ThirdLogin(@NotNull Activity mActivity) {
        g0.p(mActivity, "mActivity");
        this.f20865a = mActivity;
        UMShareConfig uMShareConfig = new UMShareConfig();
        uMShareConfig.isNeedAuthOnGetUserInfo(true);
        UMShareAPI.get(mActivity).setShareConfig(uMShareConfig);
    }

    @NotNull
    public final Activity a() {
        return this.f20865a;
    }

    public final void b(@NotNull Function1<? super Map<String, String>, n1> bind) {
        g0.p(bind, "bind");
        UMShareAPI uMShareAPI = UMShareAPI.get(this.f20865a);
        Activity activity = this.f20865a;
        SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
        if (uMShareAPI.isInstall(activity, share_media)) {
            UMShareAPI.get(this.f20865a).getPlatformInfo(this.f20865a, share_media, new MyUMAuthListener(this, bind));
        } else {
            ContextExtKt.q(this.f20865a, "您还未安装QQ或QQ版本过低");
        }
    }

    public final void c(@NotNull Function1<? super Map<String, String>, n1> bind) {
        g0.p(bind, "bind");
        UMShareAPI uMShareAPI = UMShareAPI.get(this.f20865a);
        Activity activity = this.f20865a;
        SHARE_MEDIA share_media = SHARE_MEDIA.WEIXIN;
        if (uMShareAPI.isInstall(activity, share_media)) {
            UMShareAPI.get(this.f20865a).getPlatformInfo(this.f20865a, share_media, new MyUMAuthListener(this, bind));
        } else {
            ContextExtKt.q(this.f20865a, "您还未安装微信或微信版本过低");
        }
    }
}
