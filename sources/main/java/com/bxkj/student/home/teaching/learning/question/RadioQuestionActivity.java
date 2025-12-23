package com.bxkj.student.home.teaching.learning.question;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class RadioQuestionActivity extends BaseActivity {
    private int F0;
    private String G0;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private RadioGroup f18758a0;

    /* renamed from: b0, reason: collision with root package name */
    private Button f18759b0;

    /* renamed from: c0, reason: collision with root package name */
    private CountDownTimer f18760c0;

    /* renamed from: k0, reason: collision with root package name */
    private List<Map<String, Object>> f18761k0;

    /* renamed from: p0, reason: collision with root package name */
    private String f18762p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RadioQuestionActivity.this.Q().setVisibility(0);
            RadioQuestionActivity.this.o0(data);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f18764a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f18765b;

        b(final List val$finalAnswers, final Map val$data) {
            this.f18764a = val$finalAnswers;
            this.f18765b = val$data;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            RadioButton radioButton = (RadioButton) RadioQuestionActivity.this.f18758a0.findViewById(checkedId);
            RadioQuestionActivity radioQuestionActivity = RadioQuestionActivity.this;
            radioQuestionActivity.G0 = JsonParse.getString((Map) this.f18764a.get(radioQuestionActivity.f18758a0.indexOfChild(radioButton)), "answerId");
            this.f18765b.put("checkAnswerId", RadioQuestionActivity.this.G0);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RadioQuestionActivity.this.finish();
        }
    }

    public void p0() {
        for (int i6 = 0; i6 < this.f18758a0.getChildCount(); i6++) {
            RadioButton radioButton = (RadioButton) this.f18758a0.getChildAt(i6);
            radioButton.setClickable(false);
            radioButton.setFocusable(false);
            radioButton.setFocusableInTouchMode(false);
            if ("0".equals(radioButton.getTag().toString())) {
                radioButton.setBackground(ContextCompat.getDrawable(this.T, R.drawable.exam_radio_right));
            }
        }
    }

    private void m0() {
        Http.with(this.T).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).c(this.f18762p0, this.F0)).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(View view) {
        if (TextUtils.isEmpty(this.G0)) {
            new iOSOneButtonDialog(this.T).setMessage("请选择答案").show();
        } else {
            Http.with(this.T).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).a(this.f18762p0, this.G0)).setDataListener(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(Map<String, Object> data) {
        setTitle("开始答题-" + JsonParse.getString(data, "questionTypeName"));
        this.X.setText(JsonParse.getString(data, "questionTypeName"));
        this.Z.setText("(" + JsonParse.getString(data, "socre") + "分)");
        this.Y.setText("1");
        this.W.setText(Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(JsonParse.getString(data, "questionName"), 63) : Html.fromHtml(JsonParse.getString(data, "questionName")));
        String string = JsonParse.getString(data, "stuAnswers");
        this.f18761k0 = (List) data.get("answers");
        this.f18758a0.removeAllViews();
        for (Map<String, Object> map : this.f18761k0) {
            RadioButton radioButton = new RadioButton(this.T);
            radioButton.setButtonDrawable(2131231133);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, cn.bluemobi.dylan.base.utils.d.a(this.T, 40.0f));
            radioButton.setPadding(cn.bluemobi.dylan.base.utils.d.a(this.T, 5.0f), 0, 0, 0);
            radioButton.setLayoutParams(layoutParams);
            radioButton.setTag(JsonParse.getString(map, "isRight"));
            radioButton.setTextSize(2, 20.0f);
            radioButton.setText(JsonParse.getString(map, "mark") + "." + ((Object) Html.fromHtml(JsonParse.getString(map, "answerOption"))));
            if (this.F0 == 1) {
                radioButton.setClickable(false);
                if (string.equals(JsonParse.getString(map, "answerId"))) {
                    radioButton.setChecked(true);
                }
            }
            this.f18758a0.addView(radioButton);
        }
        this.f18758a0.setOnCheckedChangeListener(new b(this.f18761k0, data));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f18759b0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RadioQuestionActivity.this.n0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("开始答题");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_learn_radio_question;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Q().setVisibility(8);
        if (getIntent().hasExtra("questionId")) {
            this.f18762p0 = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.F0 = getIntent().getIntExtra("isQualified", 0);
        }
        if (this.F0 == 1) {
            this.f18759b0.setText("已合格");
            this.f18759b0.setEnabled(false);
        }
        m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(R.id.tv_question);
        this.f18758a0 = (RadioGroup) findViewById(R.id.rg_answer);
        this.Y = (TextView) findViewById(R.id.tv_index);
        this.Z = (TextView) findViewById(2131299093);
        this.X = (TextView) findViewById(2131299171);
        this.f18759b0 = (Button) findViewById(2131296599);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
