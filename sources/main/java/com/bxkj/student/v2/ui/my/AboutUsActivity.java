package com.bxkj.student.v2.ui.my;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.CompoundButton;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.App;
import com.bxkj.student.R;
import com.bxkj.student.databinding.V2AboutUsBinding;
import com.bxkj.student.v2.vm.my.AboutUsVM;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAboutUsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AboutUsActivity.kt\ncom/bxkj/student/v2/ui/my/AboutUsActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,168:1\n1#2:169\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class AboutUsActivity extends BaseActivity<V2AboutUsBinding, AboutUsVM> {

    @NotNull
    private final BroadcastReceiver U = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.my.AboutUsActivity$showHideBroadCast$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AboutUsActivity.this.L().tagFloatButton.setChecked(com.bxkj.base.v2.data.b.f16998d.a().n());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(AboutUsActivity aboutUsActivity, CompoundButton compoundButton, boolean z5) {
        com.bxkj.base.v2.data.b.f16998d.a().l0(z5);
        LocalBroadcastManager.getInstance(aboutUsActivity.r()).sendBroadcast(new Intent(App.f17573d.a().getPackageName() + ".FloatActionView").putExtra("isShow", z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(final AboutUsActivity aboutUsActivity, SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
        UMWeb uMWeb = new UMWeb("http://sj.qq.com/myapp/detail.htm?apkName=com.bxkj.student");
        uMWeb.setTitle("校园生活如此简单");
        uMWeb.setThumb(new UMImage(aboutUsActivity.H(), "http://m.boxkj.com/resources/wechat/images/xiaowei.png"));
        uMWeb.setDescription(aboutUsActivity.getString(R.string.welcome_user_app));
        new ShareAction(aboutUsActivity.r()).setPlatform(share_media).setCallback(new UMShareListener() { // from class: com.bxkj.student.v2.ui.my.AboutUsActivity$share$1$1
            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(SHARE_MEDIA platform) {
                g0.p(platform, "platform");
                Toast.makeText(AboutUsActivity.this.H(), " 分享取消了", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(SHARE_MEDIA platform, Throwable t5) {
                g0.p(platform, "platform");
                g0.p(t5, "t");
                t5.printStackTrace();
                Toast.makeText(AboutUsActivity.this.H(), " 分享失败啦", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(SHARE_MEDIA platform) {
                g0.p(platform, "platform");
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(SHARE_MEDIA share_media2) {
                g0.p(share_media2, "share_media");
            }
        }).withMedia(uMWeb).share();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 V(final AboutUsActivity aboutUsActivity, Map map) {
        int i6 = JsonParse.getInt(map, "versions");
        String string = JsonParse.getString(map, "versionsName");
        String string2 = JsonParse.getString(map, "instruction");
        String string3 = JsonParse.getString(map, "filePath");
        if (i6 > c0.b.f1042a.m(aboutUsActivity.H())) {
            new com.bxkj.student.common.versionupdate.a(aboutUsActivity.H()).d(string, string3, string2);
        } else {
            aboutUsActivity.D().x(new Function1() { // from class: com.bxkj.student.v2.ui.my.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 W;
                    W = AboutUsActivity.W(AboutUsActivity.this, (Map) obj);
                    return W;
                }
            });
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 W(AboutUsActivity aboutUsActivity, Map it) {
        g0.p(it, "it");
        c0 c0Var = c0.f16887a;
        int k6 = c0Var.k(it, "buildVersionNo");
        String t5 = c0Var.t(it, "buildVersion");
        String t6 = c0Var.t(it, "buildUpdateDescription");
        String t7 = c0Var.t(it, "downloadURL");
        if (k6 > c0.b.f1042a.m(aboutUsActivity.H())) {
            new com.bxkj.student.common.versionupdate.a(aboutUsActivity.H()).d(t5, t7, t6);
        } else {
            ContextExtKt.m(aboutUsActivity, "当前已是最新版本");
        }
        return n1.f44123a;
    }

    public final void M() {
        startActivity(new Intent(H(), (Class<?>) AdSwitchActivity.class));
    }

    public final void N() {
        com.bxkj.student.v2.common.utils.i iVar = com.bxkj.student.v2.common.utils.i.f20904a;
        FragmentActivity r5 = r();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(CommonNetImpl.NAME, "用户协议");
        linkedHashMap.put("linkUrl", com.bxkj.student.v2.retrofit.b.f21275a.c());
        n1 n1Var = n1.f44123a;
        iVar.b(r5, linkedHashMap);
    }

    public final void O() {
        startActivity(new Intent(H(), (Class<?>) BugReportActivity.class));
    }

    @NotNull
    public final BroadcastReceiver P() {
        return this.U;
    }

    public final void R() {
        com.bxkj.student.v2.common.utils.i iVar = com.bxkj.student.v2.common.utils.i.f20904a;
        FragmentActivity r5 = r();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(CommonNetImpl.NAME, "隐私政策");
        linkedHashMap.put("linkUrl", com.bxkj.student.v2.retrofit.b.f21275a.b());
        n1 n1Var = n1.f44123a;
        iVar.b(r5, linkedHashMap);
    }

    public final void S() {
        new ShareAction(r()).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new ShareBoardlistener() { // from class: com.bxkj.student.v2.ui.my.b
            @Override // com.umeng.socialize.utils.ShareBoardlistener
            public final void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                AboutUsActivity.T(AboutUsActivity.this, snsPlatform, share_media);
            }
        }).open();
    }

    public final void U() {
        D().y(new Function1() { // from class: com.bxkj.student.v2.ui.my.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 V;
                V = AboutUsActivity.V(AboutUsActivity.this, (Map) obj);
                return V;
            }
        });
    }

    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(r()).unregisterReceiver(this.U);
        super.onDestroy();
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        AboutUsActivity aboutUsActivity;
        if (getIntent().hasExtra("title")) {
            aboutUsActivity = this;
        } else {
            aboutUsActivity = null;
        }
        if (aboutUsActivity != null) {
            L().setTitle(getIntent().getStringExtra("title"));
        }
        L().setBackEvent(this);
        L().setActivity(this);
        L().tagFloatButton.setChecked(com.bxkj.base.v2.data.b.f16998d.a().n());
        L().tagFloatButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bxkj.student.v2.ui.my.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
                AboutUsActivity.Q(AboutUsActivity.this, compoundButton, z5);
            }
        });
        LocalBroadcastManager.getInstance(r()).registerReceiver(this.U, new IntentFilter(App.f17573d.a().getPackageName() + ".FloatActionView"));
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
