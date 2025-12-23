package com.bxkj.student.home.teaching.homework.question;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CheckboxQuestionActivity extends BaseActivity {
    private List<Map<String, Object>> F0;
    private StringBuilder G0;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private RadioGroup f18321a0;

    /* renamed from: b0, reason: collision with root package name */
    private Button f18322b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f18323c0;

    /* renamed from: k0, reason: collision with root package name */
    private String f18324k0;

    /* renamed from: p0, reason: collision with root package name */
    private int f18325p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CheckboxQuestionActivity.this.Q().setVisibility(0);
            CheckboxQuestionActivity.this.m0(data);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CheckboxQuestionActivity.this.finish();
        }
    }

    private void k0() {
        Http.with(this.T).setObservable(((com.bxkj.student.home.teaching.homework.a) Http.getApiService(com.bxkj.student.home.teaching.homework.a.class)).c(this.f18324k0, this.f18325p0)).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(View view) {
        this.G0 = new StringBuilder();
        for (Map<String, Object> map : this.F0) {
            if (map.containsKey("icChecked") && ((Boolean) map.get("icChecked")).booleanValue()) {
                StringBuilder sb = this.G0;
                sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                this.G0.append(JsonParse.getString(map, "answerId"));
            }
        }
        if (TextUtils.isEmpty(this.G0)) {
            new iOSOneButtonDialog(this.T).setMessage("请选择答案").show();
        } else {
            Http.with(this.T).setObservable(((com.bxkj.student.home.teaching.homework.a) Http.getApiService(com.bxkj.student.home.teaching.homework.a.class)).a(this.f18324k0, this.G0.toString())).setDataListener(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(Map<String, Object> data) {
        boolean z5 = JsonParse.getBoolean(data, "isFlag");
        if (this.f18325p0 == 1) {
            this.f18322b0.setText("已合格");
            this.f18322b0.setEnabled(false);
        } else if (z5) {
            this.f18322b0.setText("提交");
            this.f18322b0.setEnabled(true);
        } else {
            this.f18322b0.setText("不合格");
            this.f18322b0.setEnabled(false);
            this.f18323c0.setVisibility(0);
            this.f18323c0.setText(JsonParse.getString(data, "markAnswer"));
        }
        this.W.setText(Html.fromHtml(JsonParse.getString(data, "questionName")));
        this.Z.setText("(" + JsonParse.getString(data, "socre") + "分)");
        this.F0 = (List) data.get("answers");
        this.f18321a0.removeAllViews();
        List asList = Arrays.asList(JsonParse.getString(data, "stuAnswers").split(","));
        for (final Map<String, Object> map : this.F0) {
            CheckBox checkBox = new CheckBox(this.T);
            checkBox.setTextSize(2, 16.0f);
            checkBox.setText(JsonParse.getString(map, "mark") + "." + ((Object) Html.fromHtml(JsonParse.getString(map, "answerOption"))));
            if (this.f18325p0 == 1) {
                checkBox.setClickable(false);
                checkBox.setChecked(asList.indexOf(JsonParse.getString(map, "answerId")) != -1);
            } else if (z5) {
                checkBox.setClickable(true);
            } else {
                checkBox.setClickable(false);
                checkBox.setChecked(asList.indexOf(JsonParse.getString(map, "answerId")) != -1);
            }
            this.f18321a0.addView(checkBox);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bxkj.student.home.teaching.homework.question.b
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) {
                    map.put("icChecked", Boolean.valueOf(z6));
                }
            });
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f18322b0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckboxQuestionActivity.this.l0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("课后作业开始答题-多选");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_learn_checkbox_question;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Q().setVisibility(8);
        if (getIntent().hasExtra("questionId")) {
            this.f18324k0 = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.f18325p0 = getIntent().getIntExtra("isQualified", 0);
        }
        k0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(R.id.tv_question);
        this.f18321a0 = (RadioGroup) findViewById(R.id.rg_answer);
        this.Y = (TextView) findViewById(R.id.tv_index);
        this.Z = (TextView) findViewById(2131299093);
        this.X = (TextView) findViewById(2131299171);
        this.f18322b0 = (Button) findViewById(2131296599);
        this.f18323c0 = (TextView) findViewById(R.id.tv_right_answer);
        this.X.setText("多选");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
