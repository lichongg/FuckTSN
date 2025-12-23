package com.bxkj.competition.score.teacher;

import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.w;
import com.bxkj.competition.R;
import com.google.android.material.tabs.TabLayout;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class FieldScoreListActivity extends BaseActivity {
    private String W;
    private TabLayout X;
    private RecyclerView Y;
    private List<Map<String, Object>> Z = new ArrayList();

    /* renamed from: a0, reason: collision with root package name */
    private List<Map<String, Object>> f17342a0 = new ArrayList();

    /* renamed from: b0, reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f17343b0;

    /* renamed from: c0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f17344c0;

    /* renamed from: k0, reason: collision with root package name */
    private EditText f17345k0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_no, JsonParse.getString(stringObjectMap, "passNum"));
            holder.J(R.id.tv_name, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
            holder.J(R.id.tv_num, JsonParse.getString(stringObjectMap, "num"));
            holder.J(R.id.tv_stateName, JsonParse.getString(stringObjectMap, "stateName"));
            holder.J(R.id.tv_check, JsonParse.getString(stringObjectMap, "check"));
            holder.J(R.id.tv_rank, JsonParse.getString(stringObjectMap, "rank"));
            holder.J(R.id.tv_time, JsonParse.getString(stringObjectMap, "time"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i6 = JsonParse.getInt(data, "data");
            for (int i7 = 1; i7 <= i6; i7++) {
                FieldScoreListActivity.this.X.addTab(FieldScoreListActivity.this.X.newTab().setText("第" + i7 + "组"));
            }
            FieldScoreListActivity.this.v0();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) FieldScoreListActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            FieldScoreListActivity.this.f17342a0 = JsonParse.getList(data, "data");
            FieldScoreListActivity.this.f17344c0.g(FieldScoreListActivity.this.f17342a0);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) FieldScoreListActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements TabLayout.OnTabSelectedListener {
        d() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            FieldScoreListActivity.this.v0();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        e() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, final int position) {
            FieldScoreListActivity.this.w0(position);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RadioGroup f17351a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EditText f17352b;

        f(final RadioGroup val$et_value, final EditText val$rg) {
            this.f17351a = val$et_value;
            this.f17352b = val$rg;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == this.f17351a.getChildAt(1).getId()) {
                this.f17352b.setVisibility(0);
            } else {
                this.f17352b.setVisibility(8);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17354a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EditText f17355b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ EditText f17356c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RadioGroup f17357d;

        g(final int val$rg, final EditText val$et_rank, final EditText val$et_value, final RadioGroup val$position) {
            this.f17354a = val$rg;
            this.f17355b = val$et_rank;
            this.f17356c = val$et_value;
            this.f17357d = val$position;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            if (TextUtils.isEmpty(JsonParse.getString((Map) FieldScoreListActivity.this.f17344c0.getItem(this.f17354a), "traffId"))) {
                new iOSOneButtonDialog(((BaseActivity) FieldScoreListActivity.this).T).setMessage("该道次为空,不能添加成绩").show();
                return;
            }
            String trim = this.f17355b.getText().toString().trim();
            String trim2 = this.f17356c.getText().toString().trim();
            String trim3 = FieldScoreListActivity.this.f17345k0.getText().toString().trim();
            HashMap hashMap = new HashMap(3);
            hashMap.put("_state", "modified");
            hashMap.put("traffId", JsonParse.getString((Map) FieldScoreListActivity.this.f17344c0.getItem(this.f17354a), "traffId"));
            hashMap.put("check", Boolean.valueOf(this.f17357d.getCheckedRadioButtonId() == this.f17357d.getChildAt(1).getId()));
            if (!TextUtils.isEmpty(trim)) {
                hashMap.put("memo", trim);
            }
            hashMap.put("rank", trim2);
            hashMap.put("time", trim3);
            FieldScoreListActivity.this.t0(hashMap, this.f17354a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f17359a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f17360b;

        h(final Map val$position, final int val$map) {
            this.f17359a = val$position;
            this.f17360b = val$map;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            Map map = this.f17359a;
            map.put("check", JsonParse.getBoolean(map, "check") ? "犯规" : "未犯规");
            if (this.f17359a.containsKey("time")) {
                Map map2 = this.f17359a;
                map2.put("time", JsonParse.getString(map2, "time"));
            }
            if (this.f17359a.containsKey("rank")) {
                Map map3 = this.f17359a;
                map3.put("rank", JsonParse.getString(map3, "rank"));
            }
            ((Map) FieldScoreListActivity.this.f17344c0.getItem(this.f17360b)).putAll(this.f17359a);
            FieldScoreListActivity.this.f17344c0.notifyItemChanged(this.f17360b);
            FieldScoreListActivity.this.w0(this.f17360b + 1);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) FieldScoreListActivity.this).T).setMessage(msg).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(final Map<String, Object> map, final int position) {
        Http.with(this.T).setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).m(LoginUser.getLoginUser().getUserId(), JSON.toJSONString(map))).setDataListener(new h(map, position));
    }

    private void u0() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).k(this.W)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).l(this.W, this.X.getSelectedTabPosition() + 1, "1")).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(final int position) {
        if (position >= this.f17344c0.getItemCount()) {
            new iOSOneButtonDialog(this.T).setMessage("最后一条已录入完毕").show();
            return;
        }
        iOSTwoButtonDialog centerCustomView = new iOSTwoButtonDialog(this.T).setTitle("道次：" + JsonParse.getString(this.f17344c0.getItem(position), "passNum") + "\u3000姓名：" + JsonParse.getString(this.f17344c0.getItem(position), CommonNetImpl.NAME)).setCenterCustomView(R.layout.dialog_add_score_field);
        EditText editText = (EditText) centerCustomView.findViewById(R.id.et_value);
        EditText editText2 = (EditText) centerCustomView.findViewById(R.id.et_rank);
        EditText editText3 = (EditText) centerCustomView.findViewById(R.id.et_time);
        this.f17345k0 = editText3;
        editText3.setFilters(new InputFilter[]{new w()});
        Window window = centerCustomView.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setGravity(48);
        attributes.width = -1;
        attributes.height = -2;
        centerCustomView.onWindowAttributesChanged(attributes);
        window.setAttributes(attributes);
        com.bxkj.base.keyboard.c cVar = new com.bxkj.base.keyboard.c(this);
        cVar.a(editText2);
        cVar.a(this.f17345k0);
        RadioGroup radioGroup = (RadioGroup) centerCustomView.findViewById(R.id.rg);
        radioGroup.setOnCheckedChangeListener(new f(radioGroup, editText));
        editText.setText(JsonParse.getString(this.f17344c0.getItem(position), "memo"));
        editText2.setText(JsonParse.getString(this.f17344c0.getItem(position), "rank"));
        this.f17345k0.setText(JsonParse.getString(this.f17344c0.getItem(position), "time"));
        if ("犯规".equals(JsonParse.getString(this.f17344c0.getItem(position), "check"))) {
            radioGroup.check(radioGroup.getChildAt(1).getId());
        }
        centerCustomView.setRightButtonOnClickListener(new g(position, editText, editText2, radioGroup));
        centerCustomView.getWindow().clearFlags(131080);
        centerCustomView.getWindow().setSoftInputMode(18);
        centerCustomView.show();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new d());
        this.f17344c0.k(new e());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_student_list_add_score;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("录入成绩");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.Y = (RecyclerView) findViewById(R.id.rv);
        this.X = (TabLayout) findViewById(R.id.tb_group);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("scheduleId")) {
            this.W = getIntent().getStringExtra("scheduleId");
        }
        this.Y.setLayoutManager(new LinearLayoutManager(this.T));
        a aVar = new a(this.T, R.layout.item_for_field_score_list, this.f17342a0);
        this.f17344c0 = aVar;
        this.Y.setAdapter(aVar);
        u0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
