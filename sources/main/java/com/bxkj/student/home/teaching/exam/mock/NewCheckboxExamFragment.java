package com.bxkj.student.home.teaching.exam.mock;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.base.utils.d;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class NewCheckboxExamFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private TextView f18207j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f18208k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f18209l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f18210m;

    /* renamed from: n, reason: collision with root package name */
    private RadioGroup f18211n;

    /* renamed from: o, reason: collision with root package name */
    private List<Map<String, Object>> f18212o;

    /* renamed from: p, reason: collision with root package name */
    private Map<String, Object> f18213p;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f18214a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ NewExamActivity f18215b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CheckBox f18216c;

        a(final Map val$answer, final NewExamActivity val$newExamActivity, final CheckBox val$checkBox) {
            this.f18214a = val$answer;
            this.f18215b = val$newExamActivity;
            this.f18216c = val$checkBox;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Context context;
            int i6;
            this.f18214a.put("icChecked", Boolean.valueOf(isChecked));
            if (isChecked) {
                this.f18215b.f18218a0.setEnabled(true);
                this.f18215b.f18219b0.setEnabled(true);
            }
            String obj = this.f18216c.getTag().toString();
            CheckBox checkBox = this.f18216c;
            if ("0".equals(obj)) {
                context = ((BaseFragment) NewCheckboxExamFragment.this).f1096g;
                i6 = R.drawable.exam_radio_right;
            } else {
                context = ((BaseFragment) NewCheckboxExamFragment.this).f1096g;
                i6 = R.drawable.exam_radio_error;
            }
            checkBox.setBackground(ContextCompat.getDrawable(context, i6));
            this.f18216c.setFocusable(false);
            this.f18216c.setFocusableInTouchMode(false);
            this.f18216c.setClickable(false);
        }
    }

    public void P() {
        if (this.f18211n == null) {
            return;
        }
        for (int i6 = 0; i6 < this.f18211n.getChildCount(); i6++) {
            CheckBox checkBox = (CheckBox) this.f18211n.getChildAt(i6);
            checkBox.setFocusable(false);
            checkBox.setFocusableInTouchMode(false);
            checkBox.setClickable(false);
            if ("0".equals(checkBox.getTag().toString())) {
                checkBox.setBackground(ContextCompat.getDrawable(this.f1096g, R.drawable.exam_radio_right));
            }
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        Context context;
        int i6;
        boolean z5;
        this.f18207j = (TextView) c(R.id.tv_question);
        this.f18211n = (RadioGroup) c(R.id.rg_answer);
        this.f18209l = (TextView) c(R.id.tv_index);
        this.f18210m = (TextView) c(2131299093);
        TextView textView = (TextView) c(2131299171);
        this.f18208k = textView;
        textView.setText("多选");
        int i7 = getArguments().getInt("index");
        NewExamActivity newExamActivity = (NewExamActivity) getActivity();
        Map<String, Object> map = ((SeralizableMap) getArguments().getSerializable("seralizableMap")).getMap();
        this.f18209l.setText((i7 + 1) + "");
        this.f18207j.setText(Html.fromHtml(JsonParse.getString(map, "questionName")));
        this.f18210m.setText("(" + JsonParse.getString(map, "score") + ")分");
        this.f18212o = (List) map.get("answers");
        this.f18211n.removeAllViews();
        boolean z6 = false;
        for (Map<String, Object> map2 : this.f18212o) {
            CheckBox checkBox = new CheckBox(this.f1096g);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, d.a(this.f1096g, 40.0f));
            layoutParams.topMargin = d.a(this.f1096g, 10.0f);
            layoutParams.leftMargin = d.a(this.f1096g, 10.0f);
            checkBox.setPadding(d.a(this.f1096g, 10.0f), 0, 0, 0);
            checkBox.setLayoutParams(layoutParams);
            checkBox.setTextSize(2, 16.0f);
            checkBox.setText(JsonParse.getString(map2, "mark") + "." + ((Object) Html.fromHtml(JsonParse.getString(map2, "answerOption"))));
            checkBox.setTag(JsonParse.getString(map2, "isRight"));
            this.f18211n.addView(checkBox);
            if (map2.containsKey("icChecked") && ((Boolean) map2.get("icChecked")).booleanValue()) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z5) {
                z6 = true;
            }
            checkBox.setChecked(z5);
            checkBox.setOnCheckedChangeListener(new a(map2, newExamActivity, checkBox));
        }
        if (!z6 && !JsonParse.getBoolean(map, "timeFinish")) {
            return;
        }
        for (int i8 = 0; i8 < this.f18211n.getChildCount(); i8++) {
            CheckBox checkBox2 = (CheckBox) this.f18211n.getChildAt(i8);
            checkBox2.setFocusable(false);
            checkBox2.setFocusableInTouchMode(false);
            checkBox2.setClickable(false);
            String obj = checkBox2.getTag().toString();
            if (JsonParse.getBoolean(this.f18212o.get(i8), "icChecked")) {
                if ("0".equals(obj)) {
                    context = this.f1096g;
                    i6 = R.drawable.exam_radio_right;
                } else {
                    context = this.f1096g;
                    i6 = R.drawable.exam_radio_error;
                }
                checkBox2.setBackground(ContextCompat.getDrawable(context, i6));
            }
        }
        newExamActivity.f18218a0.setEnabled(true);
        newExamActivity.f18219b0.setEnabled(true);
        P();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.fm_exam;
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
