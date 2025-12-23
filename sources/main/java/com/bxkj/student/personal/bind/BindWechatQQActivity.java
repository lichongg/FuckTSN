package com.bxkj.student.personal.bind;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.orhanobut.logger.j;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Map;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBindWechatQQActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BindWechatQQActivity.kt\ncom/bxkj/student/personal/bind/BindWechatQQActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,173:1\n1#2:174\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public class BindWechatQQActivity extends BaseActivity {

    @Nullable
    private ImageView W;

    @Nullable
    private TextView X;

    @Nullable
    private TextView Y;

    @Nullable
    private Button Z;

    /* renamed from: a0, reason: collision with root package name */
    @Nullable
    private Button f19592a0;

    /* renamed from: b0, reason: collision with root package name */
    @NotNull
    private UMAuthListener f19593b0 = new UMAuthListener() { // from class: com.bxkj.student.personal.bind.BindWechatQQActivity$umAuthListener$1
        @Override // com.umeng.socialize.UMAuthListener
        public void onCancel(SHARE_MEDIA platform, int i6) {
            Context context;
            Button button;
            Button button2;
            g0.p(platform, "platform");
            context = ((BaseActivity) BindWechatQQActivity.this).T;
            Toast.makeText(context, "您取消了登录", 1).show();
            button = BindWechatQQActivity.this.Z;
            if (button != null) {
                button.setEnabled(true);
            }
            button2 = BindWechatQQActivity.this.f19592a0;
            if (button2 != null) {
                button2.setEnabled(true);
            }
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onComplete(SHARE_MEDIA platform, int i6, Map<String, String> data) {
            Button button;
            Button button2;
            String str;
            g0.p(platform, "platform");
            g0.p(data, "data");
            String str2 = platform == SHARE_MEDIA.WEIXIN ? "1" : "0";
            String str3 = data.get("openid");
            if (str3 != null) {
                BindWechatQQActivity bindWechatQQActivity = BindWechatQQActivity.this;
                String str4 = data.get(CommonNetImpl.NAME);
                if (str4 != null && (str = data.get("iconurl")) != null) {
                    bindWechatQQActivity.t0(str2, str3, str4, str);
                }
            }
            button = BindWechatQQActivity.this.Z;
            if (button != null) {
                button.setEnabled(true);
            }
            button2 = BindWechatQQActivity.this.f19592a0;
            if (button2 != null) {
                button2.setEnabled(true);
            }
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onError(SHARE_MEDIA platform, int i6, Throwable t5) {
            Context context;
            Button button;
            Button button2;
            g0.p(platform, "platform");
            g0.p(t5, "t");
            j.c(t5.getMessage());
            j.d("action=" + i6, new Object[0]);
            context = ((BaseActivity) BindWechatQQActivity.this).T;
            Toast.makeText(context, "登录失败,请稍后再试", 1).show();
            button = BindWechatQQActivity.this.Z;
            if (button != null) {
                button.setEnabled(true);
            }
            button2 = BindWechatQQActivity.this.f19592a0;
            if (button2 != null) {
                button2.setEnabled(true);
            }
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onStart(SHARE_MEDIA platform) {
            g0.p(platform, "platform");
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, ? extends Object> data) {
            g0.p(data, "data");
            BindWechatQQActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(BindWechatQQActivity bindWechatQQActivity, View view) {
        UMShareAPI uMShareAPI = UMShareAPI.get(bindWechatQQActivity.T);
        FragmentActivity fragmentActivity = bindWechatQQActivity.U;
        SHARE_MEDIA share_media = SHARE_MEDIA.WEIXIN;
        if (!uMShareAPI.isInstall(fragmentActivity, share_media)) {
            bindWechatQQActivity.g0("您还未安装微信或微信版本过低");
            return;
        }
        Button button = bindWechatQQActivity.Z;
        if (button != null) {
            button.setEnabled(false);
        }
        UMShareAPI.get(bindWechatQQActivity.T).getPlatformInfo(bindWechatQQActivity.U, share_media, bindWechatQQActivity.f19593b0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(BindWechatQQActivity bindWechatQQActivity, View view) {
        UMShareAPI uMShareAPI = UMShareAPI.get(bindWechatQQActivity.T);
        FragmentActivity fragmentActivity = bindWechatQQActivity.U;
        SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
        if (!uMShareAPI.isInstall(fragmentActivity, share_media)) {
            bindWechatQQActivity.g0("您还未安装QQ或QQ版本过低");
            return;
        }
        Button button = bindWechatQQActivity.f19592a0;
        if (button != null) {
            button.setEnabled(false);
        }
        UMShareAPI.get(bindWechatQQActivity.T).getPlatformInfo(bindWechatQQActivity.U, share_media, bindWechatQQActivity.f19593b0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0(String str, String str2, String str3, String str4) {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).g1(LoginUser.getLoginUser().getUserId(), str, str2, str3, str4)).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        Button button = this.Z;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.bind.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BindWechatQQActivity.o0(BindWechatQQActivity.this, view);
                }
            });
        }
        Button button2 = this.f19592a0;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.bind.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BindWechatQQActivity.p0(BindWechatQQActivity.this, view);
                }
            });
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        ImageView imageView;
        TextView textView = this.X;
        if (textView != null) {
            textView.setText(LoginUser.getLoginUser().getRealName());
        }
        TextView textView2 = this.Y;
        if (textView2 != null) {
            textView2.setText(LoginUser.getLoginUser().getAccount());
        }
        String headImageUrl = LoginUser.getLoginUser().getHeadImageUrl();
        if (headImageUrl == null || (imageView = this.W) == null) {
            return;
        }
        com.bumptech.glide.b.D(this.T).a(headImageUrl).m1(imageView);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("请绑定微信或QQ");
        c0("跳过", new BaseActivity.c() { // from class: com.bxkj.student.personal.bind.c
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                BindWechatQQActivity.r0(BindWechatQQActivity.this);
            }
        });
    }

    @NotNull
    public final UMAuthListener q0() {
        return this.f19593b0;
    }

    public final void s0(@NotNull UMAuthListener uMAuthListener) {
        g0.p(uMAuthListener, "<set-?>");
        this.f19593b0 = uMAuthListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(BindWechatQQActivity bindWechatQQActivity) {
        bindWechatQQActivity.finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_bind_wechat_qq2;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(@Nullable Bundle bundle) {
        this.W = (ImageView) findViewById(2131297148);
        this.X = (TextView) findViewById(2131298986);
        this.Y = (TextView) findViewById(R.id.tv_user_number);
        this.Z = (Button) findViewById(R.id.bt_wechat_bind);
        this.f19592a0 = (Button) findViewById(R.id.bt_qq_bind);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i6, int i7, @Nullable Intent intent) {
        super.onActivityResult(i6, i7, intent);
        UMShareAPI.get(this).onActivityResult(i6, i7, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
    }
}
