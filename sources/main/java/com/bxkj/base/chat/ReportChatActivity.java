package com.bxkj.base.chat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.HttpRequest;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.R;
import com.bxkj.base.chat.ReportChatActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.b0;
import com.bxkj.base.v2.common.utils.c0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nReportChatActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReportChatActivity.kt\ncom/bxkj/base/chat/ReportChatActivity\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,186:1\n106#2:187\n78#2,22:188\n1869#3:210\n1870#3:212\n1#4:211\n*S KotlinDebug\n*F\n+ 1 ReportChatActivity.kt\ncom/bxkj/base/chat/ReportChatActivity\n*L\n145#1:187\n145#1:188,22\n155#1:210\n155#1:212\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class ReportChatActivity extends BaseActivity {

    @Nullable
    private RecyclerView W;

    @Nullable
    private String Y;

    /* renamed from: a0, reason: collision with root package name */
    @Nullable
    private String f16462a0;

    /* renamed from: b0, reason: collision with root package name */
    @Nullable
    private String f16463b0;

    /* renamed from: c0, reason: collision with root package name */
    @Nullable
    private CommonAdapter<Map<String, Object>> f16464c0;

    /* renamed from: k0, reason: collision with root package name */
    @Nullable
    private EditText f16465k0;

    /* renamed from: p0, reason: collision with root package name */
    @Nullable
    private Button f16466p0;

    @NotNull
    private final List<Map<String, Object>> X = new ArrayList();
    private int Z = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, ? extends Object> data) {
            g0.p(data, "data");
            ReportChatActivity.this.f16463b0 = JsonParse.getString(data, "userIds");
            List<Map<String, Object>> list = JsonParse.getList(JsonParse.getMap(data, "messages"), "data");
            CommonAdapter commonAdapter = ReportChatActivity.this.f16464c0;
            if (commonAdapter != null) {
                commonAdapter.g(list);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, ? extends Object> data) {
            g0.p(data, "data");
            iOSOneButtonDialog message = new iOSOneButtonDialog(((BaseActivity) ReportChatActivity.this).T).setMessage("举报成功，等待后审核，请耐心等待");
            final ReportChatActivity reportChatActivity = ReportChatActivity.this;
            message.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.chat.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReportChatActivity.b.b(ReportChatActivity.this, view);
                }
            }).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ReportChatActivity reportChatActivity, View view) {
            reportChatActivity.finish();
        }
    }

    private final void o0() {
        List<Map<String, Object>> d6;
        EditText editText = this.f16465k0;
        String valueOf = String.valueOf(editText != null ? editText.getText() : null);
        int length = valueOf.length() - 1;
        int i6 = 0;
        boolean z5 = false;
        while (i6 <= length) {
            boolean z6 = g0.t(valueOf.charAt(!z5 ? i6 : length), 32) <= 0;
            if (z5) {
                if (!z6) {
                    break;
                } else {
                    length--;
                }
            } else if (z6) {
                i6++;
            } else {
                z5 = true;
            }
        }
        String obj = valueOf.subSequence(i6, length + 1).toString();
        if (obj.length() == 0) {
            g0("内容不能为空");
            return;
        }
        String userId = LoginUser.getLoginUser().getUserId();
        if (!LoginUser.getLoginUser().isLogin()) {
            userId = LoginUser.getLoginUser().getTempUserId();
        }
        String str = userId;
        StringBuilder sb = new StringBuilder();
        CommonAdapter<Map<String, Object>> commonAdapter = this.f16464c0;
        if (commonAdapter != null && (d6 = commonAdapter.d()) != null) {
            Iterator<T> it = d6.iterator();
            while (it.hasNext()) {
                Map<String, ? extends Object> map = (Map) it.next();
                c0 c0Var = c0.f16887a;
                c0Var.d(map, "isChecked");
                sb.append(c0Var.t(map, "userName"));
                sb.append(":");
                sb.append(c0Var.t(map, "msg"));
            }
        }
        Http.with(this.T).hideSuccessMessage().setObservable(((x.f) Http.getApiService(x.f.class)).x(LoginUser.getLoginUser().getSchoolId(), str, b0.h(this.T), "Android", "【举报聊天】" + ((Object) sb) + "【" + obj + "】", "a.jpg", LoginUser.getLoginUser().getRealName(), LoginUser.getLoginUser().getAccount(), this.Z == 1 ? this.f16463b0 : this.f16462a0)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        Button button = this.f16466p0;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.chat.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReportChatActivity.l0(ReportChatActivity.this, view);
                }
            });
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_report_chat;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("举报该聊天");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(@Nullable Bundle bundle) {
        View findViewById = findViewById(R.id.recyclerView);
        g0.n(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.W = (RecyclerView) findViewById;
        this.f16465k0 = (EditText) findViewById(R.id.et_reply);
        this.f16466p0 = (Button) findViewById(R.id.bt_ok);
    }

    public final void n0() {
        HttpRequest hideLoadingDialog = Http.with(this.T).hideLoadingDialog();
        x.a aVar = (x.a) Http.getApiService(x.a.class);
        int i6 = this.Z;
        hideLoadingDialog.setObservable(aVar.e(i6, i6 == 1 ? this.f16463b0 : null, i6 == 2 ? this.f16462a0 : null, 100, 1, null)).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(ReportChatActivity reportChatActivity, View view) {
        reportChatActivity.o0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("chatName")) {
            this.Y = getIntent().getStringExtra("chatName");
        }
        if (getIntent().hasExtra("chatType")) {
            this.Z = getIntent().getIntExtra("chatType", 1);
        }
        if (getIntent().hasExtra("groupId")) {
            this.f16462a0 = getIntent().getStringExtra("groupId");
        }
        if (getIntent().hasExtra("userId")) {
            this.f16463b0 = getIntent().getStringExtra("userId");
        }
        ReportChatActivity$initData$1 reportChatActivity$initData$1 = new ReportChatActivity$initData$1(this.T, R.layout.item_for_report_message, this.X);
        this.f16464c0 = reportChatActivity$initData$1;
        RecyclerView recyclerView = this.W;
        if (recyclerView != null) {
            recyclerView.setAdapter(reportChatActivity$initData$1);
        }
        n0();
    }

    private static /* synthetic */ void m0() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
    }
}
