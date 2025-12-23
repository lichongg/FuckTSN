package com.bxkj.base.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.R;
import com.bxkj.base.chat.db.ChatMessageDb;
import com.bxkj.base.chat.heart.AlarmChatService;
import com.bxkj.base.chat.heart.ChatBroadcastActionType;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.a0;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ConversationListActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private TextView Y;
    private LinearLayout Z;

    /* renamed from: b0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f16456b0;

    /* renamed from: c0, reason: collision with root package name */
    private com.bxkj.base.chat.heart.b f16457c0;

    /* renamed from: a0, reason: collision with root package name */
    private List<Map<String, Object>> f16455a0 = new ArrayList();

    /* renamed from: k0, reason: collision with root package name */
    private BroadcastReceiver f16458k0 = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ConversationListActivity.this.s0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CommonAdapter<Map<String, Object>> {
        b(Context context, int i6, List list) {
            super(context, i6, list);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder viewHolder, Map<String, Object> map) {
            int i6 = JsonParse.getInt(map, "type") == 1 ? R.mipmap.ease_default_avatar : R.mipmap.ease_group_icon;
            viewHolder.t(R.id.avatar, JsonParse.getString(map, "photo"), i6, i6);
            viewHolder.J(R.id.name, JsonParse.getString(map, "userName"));
            viewHolder.J(R.id.message, JsonParse.getString(map, "lastMsg"));
            viewHolder.J(R.id.time, JsonParse.getString(map, "createTime"));
            viewHolder.N(R.id.msg_status, JsonParse.getBoolean(map, "local"));
            viewHolder.N(R.id.unread_msg_number, JsonParse.getInt(map, NotificationCompat.CATEGORY_STATUS) == 0);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            ConversationListActivity.this.f16455a0 = JsonParse.getList(map, "data");
            for (int i6 = 0; i6 < ConversationListActivity.this.f16455a0.size(); i6++) {
                Map map2 = (Map) ConversationListActivity.this.f16455a0.get(i6);
                List t02 = ConversationListActivity.this.t0(JsonParse.getString(map2, "createTime"), com.tsn.chat.utils.a.c(), JsonParse.getInt(map2, "type"), JsonParse.getString(map2, "userId"), JsonParse.getString(map2, "groupId"), JsonParse.getString(map2, "userName"), JsonParse.getString(map2, "photo"));
                if (t02.size() > 0) {
                    ConversationListActivity.this.f16455a0.set(i6, (Map) t02.get(t02.size() - 1));
                }
            }
            ConversationListActivity.this.f16456b0.g(ConversationListActivity.this.f16455a0);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (ConversationListActivity.this.W != null && ConversationListActivity.this.W.x()) {
                ConversationListActivity.this.W.Y();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((x.a) Http.getApiService(x.a.class)).c()).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Map<String, Object>> t0(String str, String str2, int i6, String str3, String str4, String str5, String str6) {
        com.orhanobut.logger.j.c("查询开始时间=" + str + "结束时间=" + str2 + "的离线消息");
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder("fromUserId = ? and ");
        String[] strArr = new String[4];
        strArr[0] = LoginUser.getLoginUser().getUserId();
        if (i6 == 1) {
            sb.append("toUserId = ?");
            strArr[1] = str3;
        } else {
            sb.append("groupId = ?");
            strArr[1] = str4;
        }
        sb.append(" and createTime >= ? and createTime < ?");
        strArr[2] = str;
        strArr[3] = str2;
        List<ChatMessageDb> query = cn.bluemobi.dylan.sqlitelibrary.c.h().query(ChatMessageDb.class, sb.toString(), strArr);
        if (query != null && query.size() > 0) {
            for (ChatMessageDb chatMessageDb : query) {
                String messageId = chatMessageDb.getMessageId();
                String msg = chatMessageDb.getMsg();
                String createTime = chatMessageDb.getCreateTime();
                HashMap hashMap = new HashMap();
                hashMap.put("messageId", messageId);
                hashMap.put("userId", str3);
                hashMap.put("groupId", str4);
                hashMap.put("userName", str5);
                hashMap.put("type", Integer.valueOf(i6));
                hashMap.put("photo", str6);
                hashMap.put("createTime", createTime);
                hashMap.put("lastMsg", msg);
                hashMap.put("local", Boolean.TRUE);
                arrayList.add(hashMap);
            }
        }
        return arrayList;
    }

    private void u0() {
        this.W.v(false);
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        b bVar = new b(this.T, R.layout.item_for_conversation_list, this.f16455a0);
        this.f16456b0 = bVar;
        this.X.setAdapter(bVar);
        this.Y.setText("暂无消息,你可以点击右上角联系人按钮发起互动聊天消息");
        this.X.setEmptyView(this.Y);
        this.W.p(new n2.d() { // from class: com.bxkj.base.chat.n
            @Override // n2.d
            public final void a(m2.h hVar) {
                ConversationListActivity.this.x0(hVar);
            }
        });
        this.W.F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(boolean z5) {
        this.Z.setVisibility(z5 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0() {
        startActivity(new Intent(this.T, (Class<?>) ContactListActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f16456b0.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.base.chat.k
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i6) {
                ConversationListActivity.this.v0(viewGroup, view, obj, i6);
            }
        });
        LoginUser.getLoginUser().addChatConnectListener(new LoginUser.ChatConnectListener() { // from class: com.bxkj.base.chat.l
            @Override // com.bxkj.base.user.LoginUser.ChatConnectListener
            public final void connectStatusChange(boolean z5) {
                ConversationListActivity.this.w0(z5);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_conversation_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.Z.setVisibility(LoginUser.getLoginUser().isChatConnectStatus() ? 8 : 0);
        u0();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ChatBroadcastActionType.NOTIFY_SEND_MESSAGE_CALLBACK_SUCCESS);
        intentFilter.addAction(ChatBroadcastActionType.NOTIFY_RECEIVER_MESSAGE);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f16458k0, intentFilter);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("会话列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle bundle) {
        this.W = (SmartRefreshLayout) findViewById(R.id.refresh);
        this.X = (EmptyRecyclerView) findViewById(R.id.recyclerView);
        this.Y = (TextView) findViewById(R.id.tv_emptyView);
        int i6 = R.id.ll_status;
        this.Z = (LinearLayout) findViewById(i6);
        this.Z = (LinearLayout) findViewById(i6);
        a0(R.mipmap.my_write, new BaseActivity.c() { // from class: com.bxkj.base.chat.m
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                ConversationListActivity.this.y0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        if (this.f16458k0 != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f16458k0);
        }
        r0();
        super.onDestroy();
    }

    private void r0() {
        if (cn.bluemobi.dylan.base.utils.a.n().getActivity(ChatActivity.class) == null) {
            com.bxkj.base.chat.heart.b bVar = this.f16457c0;
            if (bVar != null) {
                bVar.a();
            }
            b3.a.a().g(this.T);
            b3.a.a().l();
            if (a0.a(this.T, AlarmChatService.class.getName())) {
                com.orhanobut.logger.j.c("AlarmChatService----------isServiceRunning");
                stopService(new Intent(this.T, (Class<?>) AlarmChatService.class));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(ViewGroup viewGroup, View view, Object obj, int i6) {
        s0();
        startActivity(new Intent(this.T, (Class<?>) ChatActivity.class).setFlags(67108864).putExtra("chatName", JsonParse.getString(this.f16456b0.getItem(i6), "userName")).putExtra("chatType", JsonParse.getInt(this.f16456b0.getItem(i6), "type")).putExtra("groupId", JsonParse.getString(this.f16456b0.getItem(i6), "groupId")).putExtra("userId", JsonParse.getString(this.f16456b0.getItem(i6), "userId")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(m2.h hVar) {
        s0();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!a0.a(this.T, AlarmChatService.class.getName())) {
            com.orhanobut.logger.j.c("AlarmChatService----------isServiceStop");
            com.bxkj.base.chat.heart.b bVar = new com.bxkj.base.chat.heart.b(this.T);
            this.f16457c0 = bVar;
            bVar.b();
            return;
        }
        if (System.currentTimeMillis() - LoginUser.getLoginUser().getLastHeartCallBackTime() > 10000) {
            com.orhanobut.logger.j.c("AlarmChatService----------timeout");
            com.bxkj.base.chat.heart.b bVar2 = new com.bxkj.base.chat.heart.b(this.T);
            this.f16457c0 = bVar2;
            bVar2.b();
            return;
        }
        com.orhanobut.logger.j.c("AlarmChatService----------isServiceRunning");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
