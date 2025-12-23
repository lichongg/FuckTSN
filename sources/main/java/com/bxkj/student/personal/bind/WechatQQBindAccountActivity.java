package com.bxkj.student.personal.bind;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.student.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Map;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nWechatQQBindAccountActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WechatQQBindAccountActivity.kt\ncom/bxkj/student/personal/bind/WechatQQBindAccountActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,104:1\n1#2:105\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public class WechatQQBindAccountActivity extends BaseActivity {

    @Nullable
    private ImageView W;

    @Nullable
    private TextView X;

    @Nullable
    private TextView Y;

    @Nullable
    private TextView Z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            g0.p(ex, "ex");
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int i6, String msg) {
            g0.p(msg, "msg");
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, ? extends Object> data) {
            g0.p(data, "data");
            com.bxkj.student.personal.login.c.b(((BaseActivity) WechatQQBindAccountActivity.this).U, data);
        }
    }

    private final void k0() {
        TextView textView = this.Y;
        String obj = textView != null ? u.Z5(textView.getText().toString()).toString() : "";
        TextView textView2 = this.Z;
        String obj2 = textView2 != null ? u.Z5(textView2.getText().toString()).toString() : "";
        if ((TextUtils.isEmpty(obj) ? this : null) != null) {
            Context mContext = this.T;
            g0.o(mContext, "mContext");
            ContextExtKt.m(mContext, "请输入姓名！");
        } else {
            if ((TextUtils.isEmpty(obj2) ? this : null) == null) {
                Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).I1(obj2, obj, getIntent().getStringExtra("login_type"), getIntent().getStringExtra("openid"), getIntent().getStringExtra(CommonNetImpl.NAME), getIntent().getStringExtra("iconurl"))).setDataListener(new a());
                return;
            }
            Context mContext2 = this.T;
            g0.o(mContext2, "mContext");
            ContextExtKt.m(mContext2, "请输入学号！");
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("绑定账号");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(WechatQQBindAccountActivity wechatQQBindAccountActivity, View view) {
        wechatQQBindAccountActivity.k0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        ((Button) findViewById(R.id.bt_login)).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.bind.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WechatQQBindAccountActivity.j0(WechatQQBindAccountActivity.this, view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_bind_wechat_qq;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        WechatQQBindAccountActivity wechatQQBindAccountActivity;
        TextView textView;
        ImageView imageView;
        WechatQQBindAccountActivity wechatQQBindAccountActivity2 = null;
        if (getIntent().hasExtra("iconurl")) {
            wechatQQBindAccountActivity = this;
        } else {
            wechatQQBindAccountActivity = null;
        }
        if (wechatQQBindAccountActivity != null && (imageView = this.W) != null) {
            com.bumptech.glide.b.D(this.T).a(getIntent().getStringExtra("iconurl")).m1(imageView);
        }
        if (getIntent().hasExtra(CommonNetImpl.NAME)) {
            wechatQQBindAccountActivity2 = this;
        }
        if (wechatQQBindAccountActivity2 != null && (textView = this.X) != null) {
            textView.setText(getIntent().getStringExtra(CommonNetImpl.NAME));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(@Nullable Bundle bundle) {
        this.W = (ImageView) findViewById(2131297148);
        this.X = (TextView) findViewById(R.id.tv_nick_name);
        this.Y = (TextView) findViewById(R.id.et_name);
        this.Z = (TextView) findViewById(R.id.et_account);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
    }
}
