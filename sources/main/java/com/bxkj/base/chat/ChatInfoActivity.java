package com.bxkj.base.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.R;
import com.bxkj.base.user.LoginUser;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ChatInfoActivity extends BaseActivity {
    private RecyclerView W;
    private List<Map<String, Object>> X = new ArrayList();
    private CommonAdapter<Map<String, Object>> Y;
    private String Z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int i6, List list) {
            super(context, i6, list);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder viewHolder, Map<String, Object> map) {
            viewHolder.s(R.id.iv_head, JsonParse.getString(map, "photo"));
            viewHolder.J(R.id.tv_name, JsonParse.getString(map, CommonNetImpl.NAME));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            ChatInfoActivity.this.Y.g(JsonParse.getList(map, "data"));
        }
    }

    private void k0() {
        Http.with(this.T).setObservable(((x.a) Http.getApiService(x.a.class)).f(this.Z)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(ViewGroup viewGroup, View view, Object obj, int i6) {
        String string = JsonParse.getString(this.Y.getItem(i6), "id");
        if (LoginUser.getLoginUser().getUserId().equalsIgnoreCase(string) || LoginUser.getLoginUser().getUserType() != 2) {
            return;
        }
        startActivity(new Intent(this.T, (Class<?>) ChatUserInfoActivity.class).putExtra("userId", string).putExtra("userName", JsonParse.getString(this.Y.getItem(i6), CommonNetImpl.NAME)));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Y.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.base.chat.g
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i6) {
                ChatInfoActivity.this.l0(viewGroup, view, obj, i6);
            }
        });
        findViewById(R.id.bt_report).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.chat.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatInfoActivity.this.m0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_chat_info;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("聊天信息");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle bundle) {
        this.W = (RecyclerView) findViewById(R.id.rv_user);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(View view) {
        startActivity(getIntent().setClass(this.T, ReportChatActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("groupId")) {
            this.Z = getIntent().getStringExtra("groupId");
        }
        this.W.setLayoutManager(new GridLayoutManager(this.T, 5));
        a aVar = new a(this.T, R.layout.item_for_menmber, this.X);
        this.Y = aVar;
        this.W.setAdapter(aVar);
        k0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
