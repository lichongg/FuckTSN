package com.bxkj.base.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ChatUserInfoActivity extends BaseActivity {
    private String F0;
    private String G0;
    private ImageView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f16446a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f16447b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f16448c0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f16449k0;

    /* renamed from: p0, reason: collision with root package name */
    private Button f16450p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            ChatUserInfoActivity.this.Q().setVisibility(0);
            com.bumptech.glide.b.D(((BaseActivity) ChatUserInfoActivity.this).T).a(JsonParse.getString(map, "collectPhoto")).m1(ChatUserInfoActivity.this.W);
            ChatUserInfoActivity.this.X.setText("姓名：" + JsonParse.getString(map, CommonNetImpl.NAME));
            TextView textView = ChatUserInfoActivity.this.Y;
            StringBuilder sb = new StringBuilder();
            sb.append("性别：");
            sb.append(JsonParse.getInt(map, "sex") == 1 ? "男" : "女");
            textView.setText(sb.toString());
            ChatUserInfoActivity.this.Z.setText("学号：" + JsonParse.getString(map, "userNum"));
            ChatUserInfoActivity.this.f16446a0.setText("年级：" + JsonParse.getString(map, "grade"));
            ChatUserInfoActivity.this.f16447b0.setText("院系：" + JsonParse.getString(map, "faculty"));
            ChatUserInfoActivity.this.f16448c0.setText("专业：" + JsonParse.getString(map, "profession"));
            ChatUserInfoActivity.this.f16449k0.setText("班级：" + JsonParse.getString(map, "class"));
        }
    }

    private void r0() {
        Http.with(this.T).setObservable(((x.a) Http.getApiService(x.a.class)).b(this.F0)).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(View view) {
        startActivity(new Intent(this.T, (Class<?>) ChatActivity.class).setFlags(67108864).putExtra("chatName", this.G0).putExtra("chatType", 1).putExtra("userId", this.F0));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f16450p0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.chat.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatUserInfoActivity.this.s0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_chat_user_info;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("用户信息");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle bundle) {
        this.W = (ImageView) findViewById(R.id.iv_head);
        this.X = (TextView) findViewById(R.id.tv_name);
        this.Y = (TextView) findViewById(R.id.tv_sex);
        this.Z = (TextView) findViewById(R.id.tv_number);
        this.f16446a0 = (TextView) findViewById(R.id.tv_grade);
        this.f16447b0 = (TextView) findViewById(R.id.tv_compus);
        this.f16448c0 = (TextView) findViewById(R.id.tv_post);
        this.f16449k0 = (TextView) findViewById(R.id.tv_class);
        this.f16450p0 = (Button) findViewById(R.id.bt_chat);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Q().setVisibility(8);
        if (getIntent().hasExtra("userId")) {
            this.F0 = getIntent().getStringExtra("userId");
        }
        if (getIntent().hasExtra("userName")) {
            String stringExtra = getIntent().getStringExtra("userName");
            this.G0 = stringExtra;
            this.X.setText(stringExtra);
        }
        r0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
