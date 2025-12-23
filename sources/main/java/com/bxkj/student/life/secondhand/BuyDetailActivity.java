package com.bxkj.student.life.secondhand;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.bxkj.student.life.lost.MyLostGoodsActivity;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.open.SocialConstants;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.c0;
import rx.e;
import x.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class BuyDetailActivity extends BaseActivity {
    private Button F0;
    private RelativeLayout G0;
    private String H0;
    private Map<String, Object> I0;
    private List<String> J0;
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> K0;
    private int L0;
    private String M0;
    private String N0;
    private TextView W;
    private TextView X;
    private TextView Y;
    private MyGridView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f19385a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f19386b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f19387c0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f19388k0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f19389p0;

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
    class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String[] strArr = new String[BuyDetailActivity.this.J0.size()];
            BuyDetailActivity buyDetailActivity = BuyDetailActivity.this;
            buyDetailActivity.t0((String[]) buyDetailActivity.J0.toArray(strArr), position);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f19392a;

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
                if (BuyDetailActivity.this.F0.getText().toString().trim().equals("删除")) {
                    BuyDetailActivity.this.g0("删除成功");
                    SecondHandListFragment secondHandListFragment = (SecondHandListFragment) cn.bluemobi.dylan.base.utils.a.n().o(SecondHandListFragment.class);
                    if (secondHandListFragment != null) {
                        secondHandListFragment.f0();
                    }
                    BuyDetailActivity.this.finish();
                    return;
                }
                BuyDetailActivity.this.g0("已关闭");
                BuyDetailActivity.this.q0();
            }
        }

        c(final e val$observable) {
            this.f19392a = val$observable;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(((BaseActivity) BuyDetailActivity.this).T).setObservable(this.f19392a).setDataListener(new a());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BuyDetailActivity.this.G0.setVisibility(0);
            BuyDetailActivity.this.I0 = data;
            BuyDetailActivity.this.r0();
        }
    }

    private void p0() {
        e<c0<ResponseBody>> b6 = this.F0.getText().toString().trim().equals("删除") ? ((i) Http.getApiService(i.class)).b(this.H0, LoginUser.getLoginUser().getOpenId()) : ((i) Http.getApiService(i.class)).a(this.H0, LoginUser.getLoginUser().getOpenId());
        new iOSTwoButtonDialog(this.T).setMessage("确定要" + this.F0.getText().toString().trim() + "吗？").setRightButtonOnClickListener(new c(b6)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        Http.with(this.T).setObservable(((i) Http.getApiService(i.class)).g(this.H0, this.M0)).setDataListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        this.W.setText(JsonParse.getString(this.I0, "publishTime"));
        this.X.setText(JsonParse.getString(this.I0, "goodsTypeName"));
        this.Y.setText(JsonParse.getString(this.I0, SocialConstants.PARAM_COMMENT));
        this.f19385a0.setText(JsonParse.getString(this.I0, "price"));
        List<String> list = JsonParse.getList(this.I0, SocialConstants.PARAM_IMG_URL, String.class);
        this.J0 = list;
        this.K0.c(list);
        MyGridView myGridView = this.Z;
        List<String> list2 = this.J0;
        myGridView.setVisibility((list2 == null || list2.size() <= 0) ? 8 : 0);
        String string = JsonParse.getString(this.I0, "myMotice");
        this.N0 = string;
        if (string.equals("Y")) {
            String string2 = JsonParse.getString(this.I0, NotificationCompat.CATEGORY_STATUS);
            this.F0.setVisibility(0);
            if ("0".equals(string2)) {
                this.F0.setEnabled(true);
                this.F0.setText("删除");
            } else if ("1".equals(string2)) {
                this.F0.setEnabled(true);
                this.F0.setText("关闭");
            } else if ("2".equals(string2)) {
                this.F0.setEnabled(false);
                this.F0.setText("审核不通过");
            } else {
                this.F0.setEnabled(false);
                this.F0.setText("已关闭");
            }
        }
        s0();
    }

    private void s0() {
        String string = JsonParse.getString(this.I0, "phone");
        if (TextUtils.isEmpty(string)) {
            ((View) this.f19386b0.getParent()).setVisibility(8);
        } else {
            ((View) this.f19386b0.getParent()).setVisibility(0);
            this.f19386b0.setText(string);
        }
        String string2 = JsonParse.getString(this.I0, ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE);
        if (TextUtils.isEmpty(string2)) {
            ((View) this.f19387c0.getParent()).setVisibility(8);
        } else {
            ((View) this.f19387c0.getParent()).setVisibility(0);
            this.f19387c0.setText(string2);
        }
        String string3 = JsonParse.getString(this.I0, "qq");
        if (TextUtils.isEmpty(string3)) {
            ((View) this.f19389p0.getParent()).setVisibility(8);
        } else {
            ((View) this.f19389p0.getParent()).setVisibility(0);
            this.f19389p0.setText(string3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(String[] arr, int position) {
        Intent intent = new Intent(this.T, (Class<?>) ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.T, arr);
        intent.putExtra(ImagePagerActivity.S, position);
        startActivity(intent);
        overridePendingTransition(2130772094, 2130772095);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.F0.setOnClickListener(this);
        this.Z.setOnItemClickListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("物品详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_buy_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (LoginUser.getLoginUser().isAuthorizationInLost()) {
            this.M0 = LoginUser.getLoginUser().getOpenId();
        }
        if (getIntent().hasExtra("noticeId")) {
            this.H0 = getIntent().getStringExtra("noticeId");
        }
        if (getIntent().hasExtra("buyType")) {
            int intExtra = getIntent().getIntExtra("buyType", 0);
            this.L0 = intExtra;
            if (intExtra == 0) {
                setTitle("求购信息");
            } else {
                setTitle("出售信息");
            }
        }
        a aVar = new a(this.T, R.layout.item_for_lost_img, this.J0);
        this.K0 = aVar;
        this.Z.setAdapter((ListAdapter) aVar);
        q0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(2131298860);
        this.X = (TextView) findViewById(2131299171);
        this.Y = (TextView) findViewById(2131298878);
        this.Z = (MyGridView) findViewById(2131297030);
        this.f19385a0 = (TextView) findViewById(2131299047);
        this.f19386b0 = (TextView) findViewById(2131299035);
        this.f19387c0 = (TextView) findViewById(R.id.tv_wechat);
        this.f19389p0 = (TextView) findViewById(R.id.tv_qq);
        this.F0 = (Button) findViewById(R.id.bt_close);
        this.f19388k0 = (TextView) findViewById(R.id.tv_notice);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2131298404);
        this.G0 = relativeLayout;
        relativeLayout.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (v5.getId() != 2131296597) {
            return;
        }
        p0();
    }
}
