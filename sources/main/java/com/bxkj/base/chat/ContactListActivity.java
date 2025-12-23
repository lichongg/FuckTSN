package com.bxkj.base.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.R;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.view.SideBar;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ContactListActivity extends BaseActivity {
    private RecyclerView W;
    private SideBar X;
    private List<y.b> Y = new ArrayList();
    private CommonAdapter<y.b> Z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements SideBar.a {
        @Override // com.bxkj.base.view.SideBar.a
        public void a(int i6, String str) {
            for (int i7 = 0; i7 < ContactListActivity.this.Y.size(); i7++) {
                if (str.equalsIgnoreCase(((y.b) ContactListActivity.this.Y.get(i7)).b())) {
                    ContactListActivity.this.W.scrollToPosition(i7);
                    return;
                }
            }
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CommonAdapter<y.b> {
        private int n(String str) {
            for (int i6 = 0; i6 < getItemCount(); i6++) {
                if (str.equalsIgnoreCase(((y.b) ContactListActivity.this.Y.get(i6)).b())) {
                    return i6;
                }
            }
            return -1;
        }

        b(Context context, int i6, List list) {
            super(context, i6, list);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder viewHolder, y.b bVar) {
            int i6;
            if (viewHolder.f() == n(bVar.b())) {
                int i7 = R.id.catalog;
                viewHolder.N(i7, true);
                viewHolder.J(i7, bVar.b().toUpperCase());
            } else {
                viewHolder.N(R.id.catalog, false);
            }
            viewHolder.J(R.id.name, bVar.getName());
            if (Integer.parseInt(bVar.getType()) == 1) {
                i6 = R.mipmap.ease_default_avatar;
            } else {
                i6 = R.mipmap.ease_group_icon;
            }
            viewHolder.t(R.id.avatar, bVar.c(), i6, i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            List<Map<String, Object>> list = JsonParse.getList(map, "data");
            ContactListActivity.this.Y.clear();
            for (Map<String, Object> map2 : list) {
                y.b bVar = new y.b();
                bVar.h(JsonParse.getString(map2, "id"));
                bVar.k(JsonParse.getString(map2, "type"));
                bVar.i(JsonParse.getString(map2, CommonNetImpl.NAME));
                bVar.j(JsonParse.getString(map2, "photo"));
                ContactListActivity.this.Y.add(bVar);
            }
            Collections.sort(ContactListActivity.this.Y);
            ContactListActivity.this.Z.g(ContactListActivity.this.Y);
        }
    }

    private void l0() {
        Http.with(this.T).setObservable(((x.a) Http.getApiService(x.a.class)).f(null)).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(ViewGroup viewGroup, View view, Object obj, int i6) {
        y.b item = this.Z.getItem(i6);
        int parseInt = Integer.parseInt(item.getType());
        if (parseInt == 1 && LoginUser.getLoginUser().getUserType() == 2) {
            startActivity(new Intent(this.T, (Class<?>) ChatUserInfoActivity.class).putExtra("userId", item.getId()).putExtra("userName", item.getName()));
        } else {
            startActivity(new Intent(this.T, (Class<?>) ChatActivity.class).setFlags(67108864).putExtra("chatName", item.getName()).putExtra("chatType", parseInt).putExtra("groupId", item.getId()).putExtra("userId", item.getId()));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Z.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.base.chat.j
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i6) {
                ContactListActivity.this.m0(viewGroup, view, obj, i6);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_contact;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.X.setOnStrSelectCallBack(new a());
        this.W.setLayoutManager(new LinearLayoutManager(this.T));
        b bVar = new b(this.T, R.layout.item_for_contact_list, this.Y);
        this.Z = bVar;
        this.W.setAdapter(bVar);
        l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("联系人列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle bundle) {
        this.W = (RecyclerView) findViewById(R.id.recyclerView);
        this.X = (SideBar) findViewById(R.id.side_bar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
