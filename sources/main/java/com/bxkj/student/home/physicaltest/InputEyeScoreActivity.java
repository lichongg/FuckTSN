package com.bxkj.student.home.physicaltest;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class InputEyeScoreActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private TextView Y;
    private Button Z;

    /* renamed from: b0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f17907b0;

    /* renamed from: a0, reason: collision with root package name */
    private List<Map<String, Object>> f17906a0 = new ArrayList();

    /* renamed from: c0, reason: collision with root package name */
    boolean f17908c0 = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.physicaltest.InputEyeScoreActivity$a$a, reason: collision with other inner class name */
        class C0208a implements TextWatcher {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f17910a;

            C0208a(final Map val$stringObjectMap) {
                this.f17910a = val$stringObjectMap;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s5) {
                this.f17910a.put("score", s5.toString());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s5, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s5, int start, int before, int count) {
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131299053, JsonParse.getString(stringObjectMap, "examName"));
            holder.J(R.id.et_score, JsonParse.getString(stringObjectMap, "score"));
            ((EditText) holder.h(R.id.et_score)).addTextChangedListener(new C0208a(stringObjectMap));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            InputEyeScoreActivity.this.f17906a0 = JsonParse.getList(data, "data");
            InputEyeScoreActivity.this.f17907b0.g(InputEyeScoreActivity.this.f17906a0);
            if (InputEyeScoreActivity.this.f17906a0.isEmpty()) {
                return;
            }
            InputEyeScoreActivity.this.Q().setVisibility(0);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17913a;

        c(final int val$finalIndex) {
            this.f17913a = val$finalIndex;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            InputEyeScoreActivity.this.n0(this.f17913a + 1);
        }
    }

    private void m0() {
        this.f17908c0 = true;
        n0(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(int index) {
        if (index == this.f17906a0.size()) {
            o0();
            if (this.f17908c0) {
                return;
            }
            new iOSOneButtonDialog(this.T).setMessage("添加成功").show();
            return;
        }
        Map<String, Object> map = this.f17906a0.get(index);
        if (JsonParse.getString(map, "score").isEmpty()) {
            n0(index + 1);
        } else {
            this.f17908c0 = false;
            Http.with(this.T).hideSuccessMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).X(LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getAccount(), JsonParse.getString(map, "id"), JsonParse.getString(map, "score"))).setDataListener(new c(index));
        }
    }

    private void o0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).E1(LoginUser.getLoginUser().getUserId())).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.physicaltest.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputEyeScoreActivity.this.p0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("自助视力");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(View view) {
        m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_input_eye;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Q().setVisibility(8);
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        a aVar = new a(this.T, R.layout.item_for_input_eye, this.f17906a0);
        this.f17907b0 = aVar;
        this.X.setAdapter(aVar);
        this.X.setEmptyView(this.Y);
        o0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (SmartRefreshLayout) findViewById(2131298352);
        this.X = (EmptyRecyclerView) findViewById(2131298351);
        this.Y = (TextView) findViewById(2131298892);
        this.Z = (Button) findViewById(2131296599);
        this.W.h0(false);
        this.W.v(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
