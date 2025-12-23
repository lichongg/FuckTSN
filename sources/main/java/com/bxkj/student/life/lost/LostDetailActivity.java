package com.bxkj.student.life.lost;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.open.SocialConstants;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.c0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class LostDetailActivity extends BaseActivity {
    private TextView F0;
    private CheckBox G0;
    private RecyclerView H0;
    private Button I0;
    private RelativeLayout J0;
    private List<Map<String, Object>> K0;
    private String L0;
    private Map<String, Object> M0;
    private List<String> N0;
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> O0;
    private int P0;
    private String Q0;
    private CommonAdapter<Map<String, Object>> R0;
    private String S0;
    private TextView W;
    private TextView X;
    private TextView Y;
    private MyGridView Z;

    /* renamed from: a0, reason: collision with root package name */
    private LinearLayout f19056a0;

    /* renamed from: b0, reason: collision with root package name */
    private EditText f19057b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f19058c0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f19059k0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f19060p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(ViewHolder holder, String s5) {
            holder.t(R.id.iv_img, s5, 2131689689, 2131689689);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f19063a;

            a(final String val$question) {
                this.f19063a = val$question;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                LostDetailActivity.this.y0(this.f19063a);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.life.lost.LostDetailActivity$b$b, reason: collision with other inner class name */
        class C0239b extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.bxkj.student.life.lost.LostDetailActivity$b$b$a */
            class a implements View.OnClickListener {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Map f19066a;

                a(final Map val$stringObjectMap) {
                    this.f19066a = val$stringObjectMap;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View v5) {
                    LostDetailActivity.this.z0(JsonParse.getString(this.f19066a, "validateAnswerId"), "1");
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.bxkj.student.life.lost.LostDetailActivity$b$b$b, reason: collision with other inner class name */
            class ViewOnClickListenerC0240b implements View.OnClickListener {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Map f19068a;

                ViewOnClickListenerC0240b(final Map val$stringObjectMap) {
                    this.f19068a = val$stringObjectMap;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View v5) {
                    LostDetailActivity.this.z0(JsonParse.getString(this.f19068a, "validateAnswerId"), "0");
                }
            }

            C0239b(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(ViewHolder holder, final Map<String, Object> stringObjectMap) {
                holder.J(R.id.tv_answer, JsonParse.getString(stringObjectMap, "validateUser") + ":" + JsonParse.getString(stringObjectMap, "validateAnswer"));
                holder.N(R.id.bt_right, "Y".equals(LostDetailActivity.this.S0));
                Button button = (Button) holder.h(R.id.bt_right);
                Button button2 = (Button) holder.h(R.id.bt_error);
                Button button3 = (Button) holder.h(R.id.bt_wait);
                if ("未审核".equals(JsonParse.getString(stringObjectMap, "reviewResult"))) {
                    if ("Y".equals(LostDetailActivity.this.S0)) {
                        button3.setVisibility(8);
                        button.setVisibility(0);
                        button2.setVisibility(0);
                        button.setEnabled(true);
                        button2.setEnabled(true);
                    } else {
                        button3.setVisibility(0);
                        button.setVisibility(8);
                        button2.setVisibility(8);
                        button.setEnabled(false);
                        button2.setEnabled(false);
                    }
                } else if ("正确".equals(JsonParse.getString(stringObjectMap, "reviewResult"))) {
                    button.setEnabled(false);
                    button.setVisibility(0);
                    button2.setVisibility(8);
                    button3.setVisibility(8);
                } else if ("错误".equals(JsonParse.getString(stringObjectMap, "reviewResult"))) {
                    button2.setEnabled(false);
                    button.setVisibility(8);
                    button2.setVisibility(0);
                    button3.setVisibility(8);
                }
                holder.w(R.id.bt_right, new a(stringObjectMap));
                holder.w(R.id.bt_error, new ViewOnClickListenerC0240b(stringObjectMap));
            }
        }

        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            String string = JsonParse.getString(stringObjectMap, "question");
            holder.J(R.id.tv_question, (holder.f() + 1) + "." + string);
            holder.w(R.id.bt_response, new a(string));
            ((ListView) holder.h(R.id.lv_answer)).setAdapter((ListAdapter) new C0239b(this.f1138e, R.layout.item_for_answer_list, JsonParse.getList(stringObjectMap, "answer")));
            holder.N(R.id.bt_response, "N".equals(LostDetailActivity.this.S0));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String[] strArr = new String[LostDetailActivity.this.N0.size()];
            LostDetailActivity lostDetailActivity = LostDetailActivity.this;
            lostDetailActivity.C0((String[]) lostDetailActivity.N0.toArray(strArr), position);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.e f19071a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends HttpCallBack {
            a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                MyLostGoodsActivity myLostGoodsActivity = (MyLostGoodsActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(MyLostGoodsActivity.class);
                if (myLostGoodsActivity != null) {
                    myLostGoodsActivity.u0();
                }
                if (LostDetailActivity.this.I0.getText().toString().trim().equals("删除")) {
                    LostDetailActivity.this.g0("删除成功");
                    LostGoodsFragment lostGoodsFragment = (LostGoodsFragment) cn.bluemobi.dylan.base.utils.a.n().o(LostGoodsFragment.class);
                    if (lostGoodsFragment != null) {
                        lostGoodsFragment.f0();
                    }
                    LostDetailActivity.this.finish();
                    return;
                }
                LostDetailActivity.this.g0("已关闭");
                LostDetailActivity.this.x0();
            }
        }

        d(final rx.e val$observable) {
            this.f19071a = val$observable;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(((BaseActivity) LostDetailActivity.this).T).setObservable(this.f19071a).setDataListener(new a());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LostDetailActivity.this.J0.setVisibility(0);
            LostDetailActivity.this.M0 = data;
            LostDetailActivity.this.A0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ iOSTwoButtonDialog f19075a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f19076b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends HttpCallBack {
            a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                f.this.f19075a.dismiss();
                LostDetailActivity.this.g0("已提交回答，等待对方审核");
                LostDetailActivity.this.x0();
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnOtherStatus(int status, String msg) {
                super.netOnOtherStatus(status, msg);
                new iOSOneButtonDialog(((BaseActivity) LostDetailActivity.this).T).setMessage(msg).show();
            }
        }

        f(final iOSTwoButtonDialog val$iOSTwoButtonDialog, final String val$question) {
            this.f19075a = val$iOSTwoButtonDialog;
            this.f19076b = val$question;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            this.f19075a.show();
            String trim = ((EditText) this.f19075a.findViewById(R.id.et_answer)).getText().toString().trim();
            if (trim.isEmpty()) {
                LostDetailActivity.this.g0("答案不能为空");
            } else {
                Http.with(((BaseActivity) LostDetailActivity.this).T).hideOtherStatusMessage().setObservable(((x.e) Http.getApiService(x.e.class)).d(LostDetailActivity.this.L0, LoginUser.getLoginUser().getOpenId(), this.f19076b, trim)).setDataListener(new a());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g extends HttpCallBack {
        g() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LostDetailActivity.this.x0();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) LostDetailActivity.this).T).setMessage(msg).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        this.W.setText(JsonParse.getString(this.M0, "publishTime"));
        this.X.setText(JsonParse.getString(this.M0, "goodsTypeName"));
        this.Y.setText(JsonParse.getString(this.M0, SocialConstants.PARAM_COMMENT));
        List<String> list = JsonParse.getList(this.M0, SocialConstants.PARAM_IMG_URL, String.class);
        this.N0 = list;
        this.O0.c(list);
        MyGridView myGridView = this.Z;
        List<String> list2 = this.N0;
        myGridView.setVisibility((list2 == null || list2.size() <= 0) ? 8 : 0);
        int i6 = JsonParse.getInt(this.M0, "isValidate");
        this.S0 = JsonParse.getString(this.M0, "myMotice");
        String string = JsonParse.getString(this.M0, "validateCount");
        String string2 = JsonParse.getString(this.M0, "afterTime");
        this.f19060p0.setText("*输入答案错误超过" + string + "次，需要" + string2 + "以后再试");
        if (this.S0.equals("Y")) {
            if (i6 == 1) {
                this.G0.setVisibility(0);
                this.f19060p0.setVisibility(0);
                this.G0.setText("回答与失物有关的问题，才能查看我的联系方式");
                List<Map<String, Object>> list3 = JsonParse.getList(this.M0, "question");
                this.K0 = list3;
                this.R0.g(list3);
            } else {
                this.G0.setVisibility(8);
                this.f19060p0.setVisibility(8);
            }
            String string3 = JsonParse.getString(this.M0, NotificationCompat.CATEGORY_STATUS);
            this.I0.setVisibility(0);
            if ("0".equals(string3)) {
                this.I0.setEnabled(true);
                this.I0.setText("删除");
            } else if ("1".equals(string3)) {
                this.I0.setEnabled(true);
                this.I0.setText("关闭");
            } else if ("2".equals(string3)) {
                this.I0.setEnabled(false);
                this.I0.setText("审核不通过");
            } else {
                this.I0.setEnabled(false);
                this.I0.setText("已关闭");
            }
        } else if (i6 == 1) {
            this.G0.setVisibility(0);
            this.f19060p0.setVisibility(0);
            List<Map<String, Object>> list4 = JsonParse.getList(this.M0, "question");
            this.K0 = list4;
            this.R0.g(list4);
        } else {
            this.G0.setVisibility(8);
            this.f19060p0.setVisibility(8);
        }
        B0();
    }

    private void B0() {
        String string = JsonParse.getString(this.M0, "phone");
        if (TextUtils.isEmpty(string)) {
            ((View) this.f19058c0.getParent()).setVisibility(8);
        } else {
            ((View) this.f19058c0.getParent()).setVisibility(0);
            this.f19058c0.setText(string);
        }
        String string2 = JsonParse.getString(this.M0, ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE);
        if (TextUtils.isEmpty(string2)) {
            ((View) this.f19059k0.getParent()).setVisibility(8);
        } else {
            ((View) this.f19059k0.getParent()).setVisibility(0);
            this.f19059k0.setText(string2);
        }
        String string3 = JsonParse.getString(this.M0, "qq");
        if (TextUtils.isEmpty(string3)) {
            ((View) this.F0.getParent()).setVisibility(8);
        } else {
            ((View) this.F0.getParent()).setVisibility(0);
            this.F0.setText(string3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(String[] arr, int position) {
        Intent intent = new Intent(this.T, (Class<?>) ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.T, arr);
        intent.putExtra(ImagePagerActivity.S, position);
        startActivity(intent);
        overridePendingTransition(2130772094, 2130772095);
    }

    private void w0() {
        rx.e<c0<ResponseBody>> b6 = this.I0.getText().toString().trim().equals("删除") ? ((x.e) Http.getApiService(x.e.class)).b(this.L0, LoginUser.getLoginUser().getOpenId()) : ((x.e) Http.getApiService(x.e.class)).a(this.L0, LoginUser.getLoginUser().getOpenId());
        new iOSTwoButtonDialog(this.T).setMessage("确定要" + this.I0.getText().toString().trim() + "吗？").setRightButtonOnClickListener(new d(b6)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        Http.with(this.T).setObservable(((x.e) Http.getApiService(x.e.class)).j(this.L0, this.Q0)).setDataListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(final String question) {
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.T);
        iostwobuttondialog.setTitle("回答问题");
        iostwobuttondialog.setMessage(question).setCenterCustomView(R.layout.dialog_response).setRightButtonOnClickListener(new f(iostwobuttondialog, question)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(final String validateAnswerId, String isRight) {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((x.e) Http.getApiService(x.e.class)).h(LoginUser.getLoginUser().getOpenId(), validateAnswerId, isRight)).setDataListener(new g());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.I0.setOnClickListener(this);
        this.Z.setOnItemClickListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("物品详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_lost_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (LoginUser.getLoginUser().isAuthorizationInLost()) {
            this.Q0 = LoginUser.getLoginUser().getOpenId();
        }
        if (getIntent().hasExtra("noticeId")) {
            this.L0 = getIntent().getStringExtra("noticeId");
        }
        if (getIntent().hasExtra("lostType")) {
            int intExtra = getIntent().getIntExtra("lostType", 1);
            this.P0 = intExtra;
            if (intExtra == 1) {
                setTitle("寻物启示");
                this.G0.setVisibility(8);
                this.f19056a0.setVisibility(0);
                this.H0.setVisibility(8);
                this.f19060p0.setVisibility(8);
            } else {
                setTitle("失物招领");
                this.G0.setVisibility(0);
                this.H0.setVisibility(0);
                this.f19060p0.setVisibility(0);
            }
        }
        a aVar = new a(this.T, R.layout.item_for_lost_img, this.N0);
        this.O0 = aVar;
        this.Z.setAdapter((ListAdapter) aVar);
        this.R0 = new b(this.T, R.layout.item_for_question_list, this.K0);
        this.H0.setLayoutManager(new LinearLayoutManager(this.T));
        this.H0.setAdapter(this.R0);
        this.H0.addItemDecoration(new DividerItemDecoration(this.T, 1));
        x0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(2131298860);
        this.X = (TextView) findViewById(2131299171);
        this.Y = (TextView) findViewById(2131298878);
        this.Z = (MyGridView) findViewById(2131297030);
        this.f19056a0 = (LinearLayout) findViewById(R.id.ll_link);
        this.f19057b0 = (EditText) findViewById(R.id.et_price);
        this.f19058c0 = (TextView) findViewById(2131299035);
        this.f19059k0 = (TextView) findViewById(R.id.tv_wechat);
        this.F0 = (TextView) findViewById(R.id.tv_qq);
        this.G0 = (CheckBox) findViewById(R.id.cb_show_question);
        this.H0 = (RecyclerView) findViewById(R.id.rv_question_answer);
        this.I0 = (Button) findViewById(R.id.bt_close);
        this.f19060p0 = (TextView) findViewById(R.id.tv_notice);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2131298404);
        this.J0 = relativeLayout;
        relativeLayout.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (v5.getId() != 2131296597) {
            return;
        }
        w0();
    }
}
