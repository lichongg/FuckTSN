package com.bxkj.place.apply;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.collection.ArrayMap;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.place.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ApplyPlaceActivity extends BaseActivity {
    private List<Map<String, Object>> F0 = new ArrayList();
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> G0;
    private CardView W;
    private CardView X;
    private EditText Y;
    private Button Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f17513a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f17514b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f17515c0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f17516k0;

    /* renamed from: p0, reason: collision with root package name */
    private ListView f17517p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.place.apply.ApplyPlaceActivity$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0199a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f17519a;

            ViewOnClickListenerC0199a(final Map val$stringObjectMap) {
                this.f17519a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                ApplyPlaceActivity.this.F0.remove(this.f17519a);
                a.this.notifyDataSetChanged();
            }
        }

        a(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_name, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
            holder.J(R.id.tv_number, JsonParse.getString(stringObjectMap, "userNum"));
            holder.w(R.id.bt_del, new ViewOnClickListenerC0199a(stringObjectMap));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ iOSTwoButtonDialog f17521a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends HttpCallBack {
            a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnOtherStatus(int status, String msg) {
                new iOSOneButtonDialog(((BaseActivity) ApplyPlaceActivity.this).T).setMessage(msg).show();
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                b.this.f17521a.dismiss();
                ArrayMap arrayMap = new ArrayMap();
                arrayMap.put("userNum", JsonParse.getString(data, "userNum"));
                arrayMap.put(CommonNetImpl.NAME, JsonParse.getString(data, CommonNetImpl.NAME));
                arrayMap.put("id", JsonParse.getString(data, "id"));
                ApplyPlaceActivity.this.F0.add(arrayMap);
                ApplyPlaceActivity.this.G0.notifyDataSetChanged();
            }
        }

        b(final iOSTwoButtonDialog val$iOSTwoButtonDialog) {
            this.f17521a = val$iOSTwoButtonDialog;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            this.f17521a.show();
            EditText editText = (EditText) this.f17521a.findViewById(R.id.et_number);
            String trim = editText.getText().toString().trim();
            if (trim.isEmpty()) {
                ApplyPlaceActivity.this.g0(editText.getHint());
            } else {
                Http.with(((BaseActivity) ApplyPlaceActivity.this).T).hideSuccessMessage().hideOtherStatusMessage().setObservable(((d0.b) Http.getApiService(d0.b.class)).d(LoginUser.getLoginUser().getUserId(), trim)).setDataListener(new a());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            new iOSOneButtonDialog(((BaseActivity) ApplyPlaceActivity.this).T).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ((PlaceListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(PlaceListActivity.class)).D0();
            ApplyPlaceActivity.this.finish();
        }
    }

    private void n0() {
        this.Y = (EditText) findViewById(R.id.et_reason);
        this.Z = (Button) findViewById(R.id.bt_commit);
        this.W = (CardView) findViewById(R.id.cv_reason);
        this.X = (CardView) findViewById(R.id.cv_friend);
        this.f17516k0 = (TextView) findViewById(R.id.tv_add);
        this.f17517p0 = (ListView) findViewById(R.id.lv);
    }

    private void o0() {
        String trim = this.Y.getText().toString().trim();
        StringBuilder sb = new StringBuilder();
        if (this.f17515c0 != 2) {
            if (this.F0.size() == 0) {
                g0("请输入随行人员");
                return;
            }
            for (Map<String, Object> map : this.F0) {
                sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                sb.append(JsonParse.getString(map, "userNum"));
            }
        } else if (trim.isEmpty()) {
            g0("请输入申请理由");
            return;
        }
        Http.with(this.T).hideSuccessMessage().hideOtherStatusMessage().setObservable(((d0.b) Http.getApiService(d0.b.class)).g(LoginUser.getLoginUser().getUserId(), this.f17513a0, sb.toString(), trim, this.f17515c0, "1")).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f17516k0.setOnClickListener(this);
        this.Z.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_apply_place;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("申请场地");
    }

    public void p0() {
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.T);
        iostwobuttondialog.setMessage("请输入要添加的随行人员的学号").setCenterCustomView(R.layout.dialog_input_account).setRightButtonOnClickListener(new b(iostwobuttondialog)).show();
    }

    private void m0() {
        p0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("id")) {
            this.f17513a0 = getIntent().getStringExtra("id");
        }
        if (getIntent().hasExtra("date")) {
            this.f17514b0 = getIntent().getStringExtra("date");
        }
        if (getIntent().hasExtra("appointType")) {
            this.f17515c0 = getIntent().getIntExtra("appointType", 1);
        }
        if (this.f17515c0 == 2) {
            this.Z.setText("立即申请");
            setTitle("申请场地");
            this.W.setVisibility(0);
            this.X.setVisibility(8);
            return;
        }
        this.Z.setText("立即预约");
        setTitle("预约场地");
        this.W.setVisibility(8);
        this.X.setVisibility(0);
        a aVar = new a(this.T, R.layout.item_for_add_info, this.F0);
        this.G0 = aVar;
        this.f17517p0.setAdapter((ListAdapter) aVar);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        n0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        int id = v5.getId();
        if (id == R.id.tv_add) {
            m0();
        } else if (id == R.id.bt_commit) {
            o0();
        }
    }
}
