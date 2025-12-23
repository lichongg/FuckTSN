package com.bxkj.student.personal.password.forget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import com.bxkj.student.common.utils.UniversalItemDecoration;
import com.bxkj.student.common.utils.l;
import com.bxkj.student.personal.login.LoginActivity;
import com.bxkj.student.personal.password.forget.SelectClassmateActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SelectClassmateActivity extends BaseActivity {
    private EditText W;
    private RecyclerView X;
    private Button Y;
    private CommonAdapter<Map<String, Object>> Z;

    /* renamed from: a0, reason: collision with root package name */
    private List<Map<String, Object>> f19666a0 = new ArrayList();

    /* renamed from: b0, reason: collision with root package name */
    private String f19667b0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            SelectClassmateActivity.this.finish();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CommonAdapter<Map<String, Object>> {
        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, "userName"));
            holder.m(2131296715, JsonParse.getBoolean(stringObjectMap, "isChecked"));
            ((CheckBox) holder.h(2131296715)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bxkj.student.personal.password.forget.d
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
                    stringObjectMap.put("isChecked", Boolean.valueOf(z5));
                }
            });
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends UniversalItemDecoration {
        c() {
        }

        @Override // com.bxkj.student.common.utils.UniversalItemDecoration
        public UniversalItemDecoration.b a(int position) {
            UniversalItemDecoration.a aVar = new UniversalItemDecoration.a();
            aVar.f17791d = u.a(1.0f, ((BaseActivity) SelectClassmateActivity.this).T);
            aVar.f17787f = -1;
            return aVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends HttpCallBack {
            a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                SelectClassmateActivity.this.f19666a0 = JsonParse.getList(data, "data");
                SelectClassmateActivity.this.Z.g(SelectClassmateActivity.this.f19666a0);
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
        }

        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            if (status == 202) {
                new iOSOneButtonDialog(((BaseActivity) SelectClassmateActivity.this).T).setMessage(msg).show();
                Http.with(((BaseActivity) SelectClassmateActivity.this).T).setObservable(((e0.a) Http.getApiService(e0.a.class)).p1(SelectClassmateActivity.this.f19667b0)).setDataListener(new a());
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            super.netOnSuccess(data, msg);
            new iOSOneButtonDialog(((BaseActivity) SelectClassmateActivity.this).T).setMessage(msg).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.password.forget.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectClassmateActivity.d.this.b(view);
                }
            }).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            cn.bluemobi.dylan.base.utils.a.n().j();
            SelectClassmateActivity.this.startActivity(new Intent(((BaseActivity) SelectClassmateActivity.this).T, (Class<?>) LoginActivity.class));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        d0(false);
    }

    private void r0() {
        String trim = this.W.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            new iOSOneButtonDialog(this.T).setMessage("请输入身份证号").show();
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Map<String, Object> map : this.f19666a0) {
            if (JsonParse.getBoolean(map, "isChecked")) {
                String string = JsonParse.getString(map, "userName");
                sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                sb.append(string);
            }
        }
        Http.with(this.T).hideSuccessMessage().hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).U(this.f19667b0, trim, sb.toString())).setDataListener(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Y.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.password.forget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectClassmateActivity.this.s0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(View view) {
        r0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_select_classmate;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("userNumber")) {
            this.f19667b0 = getIntent().getStringExtra("userNumber");
        }
        if (getIntent().hasExtra("classmate")) {
            this.f19666a0 = JsonParse.jsonToListMap(getIntent().getStringExtra("classmate"));
        }
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        b bVar = new b(this.T, R.layout.item_for_select_classmate, this.f19666a0);
        this.Z = bVar;
        this.X.setAdapter(bVar);
        this.X.addItemDecoration(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (EditText) findViewById(R.id.et_idCard);
        this.X = (RecyclerView) findViewById(R.id.rv_classmate);
        this.Y = (Button) findViewById(2131296623);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tb);
        ((TextView) findViewById(2131299164)).setText("输入身份证号并选择行政班的同班同学");
        toolbar.setNavigationIcon(2131231200);
        toolbar.setNavigationOnClickListener(new a());
        try {
            toolbar.getRootView().getRootView().setBackgroundResource(R.mipmap.login_bg);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        l.d(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
