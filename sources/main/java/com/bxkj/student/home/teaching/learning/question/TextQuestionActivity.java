package com.bxkj.student.home.teaching.learning.question;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class TextQuestionActivity extends BaseActivity {
    private String F0;
    private int G0;
    private List<Map<String, Object>> H0 = new ArrayList();
    private CommonAdapter<Map<String, Object>> I0;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f18768a0;

    /* renamed from: b0, reason: collision with root package name */
    private LinearLayout f18769b0;

    /* renamed from: c0, reason: collision with root package name */
    private RecyclerView f18770c0;

    /* renamed from: k0, reason: collision with root package name */
    private EditText f18771k0;

    /* renamed from: p0, reason: collision with root package name */
    private Button f18772p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_answer, JsonParse.getString(stringObjectMap, "answerStr"));
            holder.J(R.id.tv_commit_time, "回答时间：" + JsonParse.getString(stringObjectMap, "answerTime"));
            String string = JsonParse.getString(stringObjectMap, "reviewTime");
            holder.N(R.id.tv_check_time, TextUtils.isEmpty(string) ^ true);
            holder.J(R.id.tv_check_time, "批改时间：" + string);
            int i6 = JsonParse.getInt(stringObjectMap, "isRight");
            if (i6 == 0) {
                holder.J(R.id.tv_isOK, "是否合格：不合格");
            } else if (i6 == 1) {
                holder.J(R.id.tv_isOK, "是否合格：合格");
            } else if (i6 == 2) {
                holder.J(R.id.tv_isOK, "是否合格：待批改");
            }
            String string2 = JsonParse.getString(stringObjectMap, "note");
            holder.N(R.id.tv_reviewer, !TextUtils.isEmpty(string2));
            holder.J(R.id.tv_reviewer, "备注：" + string2);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            TextQuestionActivity.this.Q().setVisibility(0);
            TextQuestionActivity.this.l0(data);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            TextQuestionActivity.this.finish();
        }
    }

    private void j0() {
        Http.with(this.T).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).c(this.F0, this.G0)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(View view) {
        String trim = this.f18771k0.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            new iOSOneButtonDialog(this.T).setMessage("请填写答案").show();
        } else {
            Http.with(this.T).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).a(this.F0, trim)).setDataListener(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(Map<String, Object> data) {
        List<Map<String, Object>> list = JsonParse.getList(data, "questionsRecord");
        this.H0 = list;
        if (list.isEmpty()) {
            this.f18769b0.setVisibility(8);
            this.f18770c0.setVisibility(8);
        } else {
            this.I0.g(this.H0);
        }
        this.Y.setText("(" + JsonParse.getString(data, "socre") + "分)");
        int i6 = JsonParse.getInt(data, "limitWordsLsl");
        int i7 = JsonParse.getInt(data, "limitWordsUsl");
        this.Z.setText("字数:" + i6 + "-" + i7 + "之间");
        this.f18768a0.setText(Html.fromHtml(JsonParse.getString(data, "questionName")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f18772p0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextQuestionActivity.this.k0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("开始答题-问答题");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_learn_text_question;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Q().setVisibility(8);
        if (getIntent().hasExtra("questionId")) {
            this.F0 = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.G0 = getIntent().getIntExtra("isQualified", 0);
        }
        int i6 = this.G0;
        if (i6 == 1) {
            this.f18772p0.setText("已合格");
            this.f18771k0.setVisibility(8);
            this.Z.setVisibility(8);
            this.f18772p0.setEnabled(false);
        } else if (i6 == 2) {
            this.f18772p0.setText("待批改");
            this.f18771k0.setVisibility(8);
            this.Z.setVisibility(8);
            this.f18772p0.setEnabled(false);
        }
        this.f18770c0.setLayoutManager(new LinearLayoutManager(this.T));
        a aVar = new a(this.T, R.layout.item_for_learn_test_question_list, this.H0);
        this.I0 = aVar;
        this.f18770c0.setAdapter(aVar);
        j0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(R.id.tv_index);
        this.X = (TextView) findViewById(2131299171);
        this.Y = (TextView) findViewById(2131299093);
        this.f18768a0 = (TextView) findViewById(R.id.tv_question);
        this.Z = (TextView) findViewById(R.id.tv_limit);
        this.f18770c0 = (RecyclerView) findViewById(R.id.rv_answer);
        this.f18769b0 = (LinearLayout) findViewById(R.id.ll_history_answer);
        this.f18771k0 = (EditText) findViewById(R.id.et_answer);
        this.f18772p0 = (Button) findViewById(2131296599);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
