package com.bxkj.base.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.HttpRequest;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.base.BaseApp;
import com.bxkj.base.R;
import com.bxkj.base.chat.ChatActivity;
import com.bxkj.base.chat.db.ChatMessageDb;
import com.bxkj.base.chat.heart.AlarmChatService;
import com.bxkj.base.chat.heart.ChatBroadcastActionType;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.a0;
import com.bxkj.base.v2.common.utils.b0;
import com.kuaishou.weapon.p0.t;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tsn.chat.model.ChatModel;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.functions.Function1;
import kotlin.n1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ChatActivity extends BaseActivity {
    private String F0;
    private String G0;
    private com.bxkj.base.chat.heart.b H0;
    private RecyclerView I0;
    private SmartRefreshLayout J0;
    private EditText W;
    private Button X;
    private ImageView Y;
    private MultiItemCommonAdapter<Map<String, Object>> Z;

    /* renamed from: b0, reason: collision with root package name */
    private String f16431b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f16432c0;

    /* renamed from: k0, reason: collision with root package name */
    private Handler f16433k0;

    /* renamed from: p0, reason: collision with root package name */
    private Runnable f16434p0;

    /* renamed from: a0, reason: collision with root package name */
    private int f16430a0 = 1;
    private List<Map<String, Object>> K0 = new ArrayList();
    private BroadcastReceiver L0 = new e();
    protected int M0 = 20;
    protected int N0 = 1;
    protected int O0 = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements cn.bluemobi.dylan.base.adapter.common.recyclerview.a<Map<String, Object>> {
        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        public int b(int i6) {
            return i6 == 1 ? R.layout.item_for_send_message : R.layout.item_for_receive_message;
        }

        a() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(int i6, Map<String, Object> map) {
            return LoginUser.getLoginUser().getUserId().equals(JsonParse.getString(map, "userId")) ? 1 : 0;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends MultiItemCommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ChatMessageDb f16437a;

            a(ChatMessageDb chatMessageDb) {
                this.f16437a = chatMessageDb;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void b() {
                ChatActivity.this.Z.notifyDataSetChanged();
            }

            private void c() {
                ChatModel chatModel = new ChatModel();
                String messageId = this.f16437a.getMessageId();
                String c6 = com.tsn.chat.utils.a.c();
                String userId = LoginUser.getLoginUser().getUserId();
                String realName = LoginUser.getLoginUser().getRealName();
                String headImageUrl = LoginUser.getLoginUser().getHeadImageUrl();
                String valueOf = String.valueOf(ChatActivity.this.f16430a0);
                String schoolCode = LoginUser.getLoginUser().getSchoolCode();
                chatModel.setMessageId(messageId);
                chatModel.setCreateTime(c6);
                chatModel.setFromUserId(userId);
                chatModel.setFromUserName(realName);
                chatModel.setPhoto(headImageUrl);
                chatModel.setType(valueOf);
                chatModel.setToUserId(ChatActivity.this.f16432c0);
                chatModel.setToUserName(ChatActivity.this.G0);
                chatModel.setSchoolId(schoolCode);
                chatModel.setMsg(this.f16437a.getMsg());
                chatModel.setGroupId(ChatActivity.this.f16431b0);
                if (ChatActivity.this.f16430a0 == 1) {
                    b3.a.a().i(chatModel);
                } else {
                    b3.a.a().h(chatModel);
                }
                this.f16437a.setCreateTime(c6);
                cn.bluemobi.dylan.sqlitelibrary.c.h().update(this.f16437a, "messageId=?", new String[]{messageId});
                b.this.notifyDataSetChanged();
                new Handler().postDelayed(new Runnable() { // from class: com.bxkj.base.chat.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        ChatActivity.b.a.this.b();
                    }
                }, 60000L);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c();
            }
        }

        b(Context context, List list, cn.bluemobi.dylan.base.adapter.common.recyclerview.a aVar) {
            super(context, list, aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(Map map, View view) {
            String string = JsonParse.getString(map, "userId");
            if (LoginUser.getLoginUser().getUserId().equalsIgnoreCase(string) || LoginUser.getLoginUser().getUserType() != 2) {
                return;
            }
            ChatActivity.this.startActivity(new Intent(this.f1138e, (Class<?>) ChatUserInfoActivity.class).putExtra("userId", string).putExtra("userName", JsonParse.getString(map, "userName")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder viewHolder, final Map<String, Object> map) {
            viewHolder.s(R.id.iv_head, JsonParse.getString(map, "photo"));
            viewHolder.J(R.id.tv_msg, JsonParse.getString(map, "msg"));
            if (getItemViewType(viewHolder.f()) == 1) {
                List query = cn.bluemobi.dylan.sqlitelibrary.c.h().query(ChatMessageDb.class, "messageId=?", new String[]{JsonParse.getString(map, "messageId")});
                if (query == null || query.size() <= 0) {
                    viewHolder.N(R.id.progress_bar, false);
                    viewHolder.N(R.id.msg_status, false);
                } else {
                    ChatMessageDb chatMessageDb = (ChatMessageDb) query.get(0);
                    try {
                        if (System.currentTimeMillis() - new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(chatMessageDb.getCreateTime()).getTime() > 60000) {
                            int i6 = R.id.msg_status;
                            viewHolder.N(i6, true);
                            viewHolder.N(R.id.progress_bar, false);
                            viewHolder.w(i6, new a(chatMessageDb));
                        } else {
                            viewHolder.N(R.id.msg_status, false);
                            viewHolder.N(R.id.progress_bar, true);
                        }
                    } catch (ParseException e6) {
                        viewHolder.N(R.id.msg_status, true);
                        viewHolder.N(R.id.progress_bar, false);
                        e6.printStackTrace();
                    }
                }
            }
            viewHolder.J(R.id.tv_user, JsonParse.getString(map, "userName"));
            viewHolder.J(R.id.tv_date, JsonParse.getString(map, "createTime"));
            viewHolder.w(R.id.ll_user, new View.OnClickListener() { // from class: com.bxkj.base.chat.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChatActivity.b.this.o(map, view);
                }
            });
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z5 = ChatActivity.this.I0.computeVerticalScrollRange() > ChatActivity.this.I0.computeVerticalScrollExtent();
            if (z5 && !((LinearLayoutManager) ChatActivity.this.I0.getLayoutManager()).getStackFromEnd()) {
                ((LinearLayoutManager) ChatActivity.this.I0.getLayoutManager()).setStackFromEnd(true);
            } else {
                if (z5 || !((LinearLayoutManager) ChatActivity.this.I0.getLayoutManager()).getStackFromEnd()) {
                    return;
                }
                ((LinearLayoutManager) ChatActivity.this.I0.getLayoutManager()).setStackFromEnd(false);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends BroadcastReceiver {
        e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase(ChatBroadcastActionType.NOTIFY_SEND_MESSAGE_CALLBACK_SUCCESS)) {
                if (intent.hasExtra("messageId")) {
                    ChatActivity.this.getIntent().getStringExtra("messageId");
                    ChatActivity.this.Z.notifyDataSetChanged();
                }
            } else if (intent.getAction().equalsIgnoreCase(ChatBroadcastActionType.NOTIFY_RECEIVER_MESSAGE) && intent.hasExtra("chatType")) {
                int intExtra = intent.getIntExtra("chatType", 1);
                String stringExtra = intent.getStringExtra("userId");
                String stringExtra2 = intent.getStringExtra("userName");
                String stringExtra3 = intent.getStringExtra("photo");
                intent.getStringExtra("toUserName");
                String stringExtra4 = intent.getStringExtra("createTime");
                String stringExtra5 = intent.getStringExtra("msg");
                String stringExtra6 = intent.getStringExtra("groupId");
                if (intExtra == ChatActivity.this.f16430a0 && ChatActivity.this.f16430a0 == 1 && ChatActivity.this.f16432c0.equalsIgnoreCase(stringExtra)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("userId", stringExtra);
                    hashMap.put("userName", stringExtra2);
                    hashMap.put("photo", stringExtra3);
                    hashMap.put("createTime", stringExtra4);
                    hashMap.put("msg", stringExtra5);
                    ChatActivity.this.K0.add(hashMap);
                    ChatActivity.this.Z.g(ChatActivity.this.K0);
                } else if (intExtra == ChatActivity.this.f16430a0 && ChatActivity.this.f16430a0 == 2 && ChatActivity.this.f16431b0.equalsIgnoreCase(stringExtra6) && !LoginUser.getLoginUser().getUserId().equalsIgnoreCase(stringExtra)) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("userId", stringExtra);
                    hashMap2.put("userName", stringExtra2);
                    hashMap2.put("photo", stringExtra3);
                    hashMap2.put("createTime", stringExtra4);
                    hashMap2.put("msg", stringExtra5);
                    ChatActivity.this.K0.add(hashMap2);
                    ChatActivity.this.Z.g(ChatActivity.this.K0);
                }
            }
            ((LinearLayoutManager) ChatActivity.this.I0.getLayoutManager()).scrollToPositionWithOffset(ChatActivity.this.Z.getItemCount() - 1, Integer.MIN_VALUE);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements n2.e {
        f() {
        }

        @Override // n2.d
        public void a(m2.h hVar) {
            ChatActivity chatActivity = ChatActivity.this;
            int i6 = chatActivity.O0;
            int i7 = chatActivity.M0;
            int i8 = i6 / i7;
            int i9 = chatActivity.N0;
            if (i6 % i7 != 0) {
                i8++;
            }
            if (i9 >= i8) {
                chatActivity.J0.Y();
                Toast.makeText(((BaseActivity) ChatActivity.this).T, "已全部加载完毕", 0).show();
            } else {
                chatActivity.N0 = i9 + 1;
                chatActivity.v0();
            }
        }

        @Override // n2.b
        public void f(m2.h hVar) {
            ChatActivity.this.B0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g extends HttpCallBack {
        g() {
        }

        public static /* synthetic */ int a(Map map, Map map2) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(JsonParse.getString(map, "createTime")).after(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(JsonParse.getString(map2, "createTime"))) ? 1 : -1;
            } catch (ParseException e6) {
                e6.printStackTrace();
                return 0;
            }
        }

        private List<Map<String, Object>> b(String str, String str2) {
            com.orhanobut.logger.j.c("查询开始时间=" + str + "结束时间=" + str2 + "的离线消息");
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder("fromUserId = ? and ");
            String[] strArr = new String[4];
            strArr[0] = LoginUser.getLoginUser().getUserId();
            if (ChatActivity.this.f16430a0 == 1) {
                sb.append("toUserId = ?");
                strArr[1] = ChatActivity.this.f16432c0;
            } else {
                sb.append("groupId = ?");
                strArr[1] = ChatActivity.this.f16431b0;
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
                    String userId = LoginUser.getLoginUser().getUserId();
                    String realName = LoginUser.getLoginUser().getRealName();
                    String headImageUrl = LoginUser.getLoginUser().getHeadImageUrl();
                    HashMap hashMap = new HashMap();
                    hashMap.put("messageId", messageId);
                    hashMap.put("userId", userId);
                    hashMap.put("userName", realName);
                    hashMap.put("photo", headImageUrl);
                    hashMap.put("createTime", createTime);
                    hashMap.put("msg", msg);
                    arrayList.add(hashMap);
                }
            }
            return arrayList;
        }

        private void c(List<Map<String, Object>> list) {
            Collections.sort(list, new Comparator() { // from class: com.bxkj.base.chat.f
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ChatActivity.g.a((Map) obj, (Map) obj2);
                }
            });
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            String str;
            ChatActivity.this.f16432c0 = JsonParse.getString(map, "userIds");
            Map<String, Object> map2 = JsonParse.getMap(map, "messages");
            ChatActivity.this.O0 = Integer.parseInt(u.O(map2, "total"));
            List<Map<String, Object>> list = JsonParse.getList(map2, "data");
            String c6 = com.tsn.chat.utils.a.c();
            str = "0";
            if (ChatActivity.this.N0 == 1) {
                c6 = com.tsn.chat.utils.a.c();
                str = list.size() != 0 ? JsonParse.getString(list.get(list.size() - 1), "createTime") : "0";
                ChatActivity.this.K0.clear();
            } else if (list.size() > 0) {
                str = JsonParse.getString(list.get(list.size() - 1), "createTime");
                c6 = JsonParse.getString((Map) ChatActivity.this.K0.get(ChatActivity.this.K0.size() - 1), "createTime");
            }
            list.addAll(b(str, c6));
            c(list);
            ChatActivity.this.K0.addAll(0, list);
            ChatActivity.this.Z.g(ChatActivity.this.K0);
            ChatActivity chatActivity = ChatActivity.this;
            if (chatActivity.N0 == 1) {
                ((LinearLayoutManager) chatActivity.I0.getLayoutManager()).scrollToPositionWithOffset(ChatActivity.this.Z.getItemCount() - 1, Integer.MIN_VALUE);
            } else {
                ((LinearLayoutManager) chatActivity.I0.getLayoutManager()).scrollToPositionWithOffset(list.size(), 0);
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ChatActivity.this.J0.B(0);
            ChatActivity.this.J0.Q();
        }
    }

    public static byte[] E0(String str) {
        Throwable th;
        IOException iOException;
        FileChannel fileChannel;
        FileChannel fileChannel2 = null;
        try {
            fileChannel = new RandomAccessFile(str, t.f36150k).getChannel();
        } catch (IOException e6) {
            iOException = e6;
            fileChannel = null;
        } catch (Throwable th2) {
            th = th2;
            try {
                fileChannel2.close();
                throw th;
            } catch (IOException e7) {
                e7.printStackTrace();
                throw th;
            }
        }
        try {
            try {
                MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size()).load();
                com.orhanobut.logger.j.c(Boolean.valueOf(load.isLoaded()));
                byte[] bArr = new byte[(int) fileChannel.size()];
                if (load.remaining() > 0) {
                    load.get(bArr, 0, load.remaining());
                }
                try {
                    fileChannel.close();
                    return bArr;
                } catch (IOException e8) {
                    e8.printStackTrace();
                    return bArr;
                }
            } catch (Throwable th3) {
                th = th3;
                fileChannel2 = fileChannel;
                fileChannel2.close();
                throw th;
            }
        } catch (IOException e9) {
            iOException = e9;
            iOException.printStackTrace();
            try {
                fileChannel.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            return null;
        }
    }

    public void B0() {
        this.N0 = 1;
        v0();
    }

    private void A0(String str) {
        if (this.K0 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < this.K0.size(); i6++) {
            if (JsonParse.getString(this.K0.get(i6), "isImg").equals("1")) {
                arrayList.add(JsonParse.getString(this.K0.get(i6), "content"));
            }
        }
        Intent intent = new Intent(this.T, (Class<?>) ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.T, (String[]) arrayList.toArray(new String[arrayList.size()]));
        intent.putExtra(ImagePagerActivity.S, arrayList.indexOf(str));
        startActivity(intent);
        overridePendingTransition(R.anim.zoom_ente, R.anim.zoom_exit);
    }

    private void C0(File file) {
        String trim;
        Runnable runnable;
        if (file == null || !file.exists()) {
            trim = this.W.getText().toString().trim();
            if (trim.isEmpty()) {
                g0("内容不能为空");
                return;
            }
        } else {
            trim = cn.bluemobi.dylan.base.utils.b.b(E0(file.getPath()));
        }
        ChatModel chatModel = new ChatModel();
        String uuid = UUID.randomUUID().toString();
        String c6 = com.tsn.chat.utils.a.c();
        String userId = LoginUser.getLoginUser().getUserId();
        String realName = LoginUser.getLoginUser().getRealName();
        String headImageUrl = LoginUser.getLoginUser().getHeadImageUrl();
        String valueOf = String.valueOf(this.f16430a0);
        String schoolCode = LoginUser.getLoginUser().getSchoolCode();
        chatModel.setMessageId(uuid);
        chatModel.setCreateTime(c6);
        chatModel.setFromUserId(userId);
        chatModel.setFromUserName(realName);
        chatModel.setPhoto(headImageUrl);
        chatModel.setType(valueOf);
        chatModel.setToUserId(this.f16432c0);
        chatModel.setToUserName(this.G0);
        chatModel.setSchoolId(schoolCode);
        chatModel.setMsg(trim);
        chatModel.setGroupId(this.f16431b0);
        if (this.f16430a0 == 1) {
            b3.a.a().i(chatModel);
        } else {
            b3.a.a().h(chatModel);
        }
        ChatMessageDb chatMessageDb = new ChatMessageDb();
        chatMessageDb.setFromUserId(userId);
        chatMessageDb.setFromUserName(realName);
        chatMessageDb.setToUserId(this.f16432c0);
        chatMessageDb.setToUserName(this.G0);
        chatMessageDb.setCreateTime(c6);
        chatMessageDb.setGroupId(this.f16431b0);
        chatMessageDb.setMessageId(uuid);
        chatMessageDb.setMsg(trim);
        chatMessageDb.setPhoto(headImageUrl);
        chatMessageDb.setType(valueOf);
        cn.bluemobi.dylan.sqlitelibrary.c.h().insert((cn.bluemobi.dylan.sqlitelibrary.c) chatMessageDb);
        HashMap hashMap = new HashMap();
        hashMap.put("messageId", uuid);
        hashMap.put("userId", userId);
        hashMap.put("userName", realName);
        hashMap.put("createTime", c6);
        hashMap.put("photo", headImageUrl);
        hashMap.put("msg", trim);
        this.K0.add(hashMap);
        this.Z.g(this.K0);
        this.W.setText("");
        ((LinearLayoutManager) this.I0.getLayoutManager()).scrollToPositionWithOffset(this.Z.getItemCount() - 1, Integer.MIN_VALUE);
        Handler handler = this.f16433k0;
        if (handler != null && (runnable = this.f16434p0) != null) {
            handler.removeCallbacks(runnable);
        }
        this.f16433k0 = new Handler();
        Runnable runnable2 = new Runnable() { // from class: com.bxkj.base.chat.a
            @Override // java.lang.Runnable
            public final void run() {
                ChatActivity.this.z0();
            }
        };
        this.f16434p0 = runnable2;
        this.f16433k0.postDelayed(runnable2, 60000L);
    }

    private void D0() {
        Http.with(this.T).hideLoadingDialog().hideOtherStatusMessage().hideSuccessMessage().hideFailMessage().setObservable(((x.a) Http.getApiService(x.a.class)).a(this.f16430a0, this.f16432c0, this.f16431b0)).setDataListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0() {
        this.Z.notifyDataSetChanged();
        LocalBroadcastManager.getInstance(this.T).sendBroadcast(new Intent(ChatBroadcastActionType.NOTIFY_SEND_MESSAGE_CALLBACK_SUCCESS));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.setOnClickListener(this);
        this.Y.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_chat;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("师生互动");
        if (getIntent().hasExtra("chatName")) {
            String stringExtra = getIntent().getStringExtra("chatName");
            this.G0 = stringExtra;
            setTitle(stringExtra);
        }
        if (getIntent().hasExtra("chatType")) {
            this.f16430a0 = getIntent().getIntExtra("chatType", 1);
        }
        if (getIntent().hasExtra("groupId")) {
            this.f16431b0 = getIntent().getStringExtra("groupId");
        }
        if (getIntent().hasExtra("userId")) {
            this.f16432c0 = getIntent().getStringExtra("userId");
        }
        if (this.f16430a0 == 2) {
            a0(R.mipmap.setting_white, new BaseActivity.c() { // from class: com.bxkj.base.chat.c
                @Override // cn.bluemobi.dylan.base.BaseActivity.c
                public final void onClick() {
                    ChatActivity.this.x0();
                }
            });
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle bundle) {
        this.I0 = (RecyclerView) findViewById(R.id.recyclerView);
        this.J0 = (SmartRefreshLayout) findViewById(R.id.refresh);
        this.W = (EditText) findViewById(R.id.et_reply);
        this.X = (Button) findViewById(R.id.bt_ok);
        this.Y = (ImageView) findViewById(R.id.bt_add);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Runnable runnable;
        Handler handler = this.f16433k0;
        if (handler != null && (runnable = this.f16434p0) != null) {
            handler.removeCallbacks(runnable);
        }
        if (this.L0 != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.L0);
        }
        u0();
        super.onDestroy();
    }

    public void v0() {
        HttpRequest hideLoadingDialog = Http.with(this.T).hideLoadingDialog();
        x.a aVar = (x.a) Http.getApiService(x.a.class);
        int i6 = this.f16430a0;
        hideLoadingDialog.setObservable(aVar.e(i6, i6 == 1 ? this.f16432c0 : null, i6 == 2 ? this.f16431b0 : null, Integer.valueOf(this.M0), Integer.valueOf(this.N0), this.N0 != 1 ? this.F0 : null)).setDataListener(new g());
    }

    public void w0() {
        this.J0.E(2.0f);
        this.J0.c0(u.a(50.0f, this.T));
        this.J0.D(new f());
    }

    private void u0() {
        if (cn.bluemobi.dylan.base.utils.a.n().getActivity(ConversationListActivity.class) == null) {
            com.bxkj.base.chat.heart.b bVar = this.H0;
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
    public /* synthetic */ void x0() {
        startActivity(getIntent().setClass(this.T, ChatInfoActivity.class).putExtra("groupId", this.f16431b0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 y0(File file) {
        C0(file);
        return null;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.F0 = com.tsn.chat.utils.a.c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ChatBroadcastActionType.NOTIFY_SEND_MESSAGE_CALLBACK_SUCCESS);
        intentFilter.addAction(ChatBroadcastActionType.NOTIFY_RECEIVER_MESSAGE);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.L0, intentFilter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.T);
        linearLayoutManager.setStackFromEnd(true);
        this.I0.setLayoutManager(linearLayoutManager);
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
        layoutAnimationController.setOrder(1);
        this.I0.setLayoutAnimation(layoutAnimationController);
        b bVar = new b(this.T, this.K0, new a());
        this.Z = bVar;
        this.I0.setAdapter(bVar);
        this.I0.getViewTreeObserver().addOnGlobalLayoutListener(new c());
        w0();
        this.J0.T();
        D0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.bt_ok) {
            C0(null);
        } else if (id == R.id.bt_add) {
            b0.f16879a.r(this.U, new Function1() { // from class: com.bxkj.base.chat.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 y02;
                    y02 = ChatActivity.this.y0((File) obj);
                    return y02;
                }
            });
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        BaseApp.h(true);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        BaseApp.h(false);
        if (!a0.a(this.T, AlarmChatService.class.getName())) {
            com.orhanobut.logger.j.c("AlarmChatService----------isServiceStop");
            com.bxkj.base.chat.heart.b bVar = new com.bxkj.base.chat.heart.b(this.T);
            this.H0 = bVar;
            bVar.b();
            return;
        }
        if (System.currentTimeMillis() - LoginUser.getLoginUser().getLastHeartCallBackTime() > 10000) {
            com.orhanobut.logger.j.c("AlarmChatService----------timeout");
            com.bxkj.base.chat.heart.b bVar2 = new com.bxkj.base.chat.heart.b(this.T);
            this.H0 = bVar2;
            bVar2.b();
            return;
        }
        com.orhanobut.logger.j.c("AlarmChatService----------isServiceRunning");
    }
}
