package com.bxkj.student.home.teaching.learning.answer;

import android.content.Context;
import android.os.Build;
import android.os.CountDownTimer;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.utils.d;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class RadioAnswerFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private TextView f18471j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f18472k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f18473l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f18474m;

    /* renamed from: n, reason: collision with root package name */
    private RadioGroup f18475n;

    /* renamed from: o, reason: collision with root package name */
    private CountDownTimer f18476o;

    /* renamed from: p, reason: collision with root package name */
    private List<Map<String, Object>> f18477p;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f18478a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AnswerActivity f18479b;

        a(final Map val$data, final AnswerActivity val$evaluateActivity) {
            this.f18478a = val$data;
            this.f18479b = val$evaluateActivity;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            Context context;
            int i6;
            RadioButton radioButton = (RadioButton) RadioAnswerFragment.this.f18475n.findViewById(checkedId);
            this.f18478a.put("checkAnswerId", JsonParse.getString((Map) RadioAnswerFragment.this.f18477p.get(RadioAnswerFragment.this.f18475n.indexOfChild(radioButton)), "answerId"));
            if ("0".equals(radioButton.getTag().toString())) {
                context = ((BaseFragment) RadioAnswerFragment.this).f1096g;
                i6 = R.drawable.exam_radio_right;
            } else {
                context = ((BaseFragment) RadioAnswerFragment.this).f1096g;
                i6 = R.drawable.exam_radio_error;
            }
            radioButton.setBackground(ContextCompat.getDrawable(context, i6));
            RadioAnswerFragment.this.R();
            this.f18479b.f18437a0.setEnabled(true);
            this.f18479b.f18438b0.setEnabled(true);
        }
    }

    public void R() {
        for (int i6 = 0; i6 < this.f18475n.getChildCount(); i6++) {
            RadioButton radioButton = (RadioButton) this.f18475n.getChildAt(i6);
            radioButton.setClickable(false);
            radioButton.setFocusable(false);
            radioButton.setFocusableInTouchMode(false);
            if ("0".equals(radioButton.getTag().toString())) {
                radioButton.setBackground(ContextCompat.getDrawable(this.f1096g, R.drawable.exam_radio_right));
            }
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        Spanned fromHtml;
        Context context;
        int i6;
        this.f18471j = (TextView) c(R.id.tv_question);
        this.f18475n = (RadioGroup) c(R.id.rg_answer);
        this.f18473l = (TextView) c(R.id.tv_index);
        this.f18474m = (TextView) c(2131299093);
        TextView textView = (TextView) c(2131299171);
        this.f18472k = textView;
        textView.setVisibility(8);
        int i7 = getArguments().getInt("index");
        AnswerActivity answerActivity = (AnswerActivity) getActivity();
        Map<String, Object> map = answerActivity.I0().get(i7);
        this.f18473l.setText((i7 + 1) + "");
        if (Build.VERSION.SDK_INT >= 24) {
            fromHtml = Html.fromHtml(JsonParse.getString(map, "questionName"), 63);
        } else {
            fromHtml = Html.fromHtml(JsonParse.getString(map, "questionName"));
        }
        this.f18471j.setText(fromHtml);
        this.f18474m.setText("(" + JsonParse.getString(map, "score") + ")分");
        this.f18477p = (List) map.get("answers");
        this.f18475n.removeAllViews();
        if ("0".equals(JsonParse.getString(map, "questionType"))) {
            this.f18472k.setText("单选");
        } else if ("1".equals(JsonParse.getString(map, "questionType"))) {
            this.f18472k.setText("多选");
        } else if ("3".equals(JsonParse.getString(map, "questionType"))) {
            this.f18472k.setText("判断");
        }
        for (Map<String, Object> map2 : this.f18477p) {
            RadioButton radioButton = new RadioButton(this.f1096g);
            radioButton.setButtonDrawable(2131231133);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, d.a(this.f1096g, 40.0f));
            layoutParams.topMargin = d.a(this.f1096g, 5.0f);
            layoutParams.leftMargin = d.a(this.f1096g, 10.0f);
            radioButton.setPadding(d.a(this.f1096g, 5.0f), 0, 0, 0);
            radioButton.setLayoutParams(layoutParams);
            String string = JsonParse.getString(map2, "isRight");
            radioButton.setTag(string);
            radioButton.setTextSize(2, 20.0f);
            radioButton.setText(JsonParse.getString(map2, "mark") + "." + ((Object) Html.fromHtml(JsonParse.getString(map2, "answerOption"))));
            this.f18475n.addView(radioButton);
            String string2 = JsonParse.getString(map, "checkAnswerId");
            if (!TextUtils.isEmpty(string2) || JsonParse.getBoolean(map, "timeFinish")) {
                radioButton.setFocusable(false);
                radioButton.setFocusableInTouchMode(false);
                if (string2.equals(JsonParse.getString(map2, "answerId"))) {
                    if ("0".equals(string)) {
                        context = this.f1096g;
                        i6 = R.drawable.exam_radio_right;
                    } else {
                        context = this.f1096g;
                        i6 = R.drawable.exam_radio_error;
                    }
                    radioButton.setBackground(ContextCompat.getDrawable(context, i6));
                    radioButton.setChecked(true);
                } else {
                    radioButton.setChecked(false);
                }
                R();
            }
        }
        this.f18475n.setOnCheckedChangeListener(new a(map, answerActivity));
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.fm_answerm;
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
