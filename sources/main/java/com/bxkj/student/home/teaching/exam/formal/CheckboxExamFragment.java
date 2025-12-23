package com.bxkj.student.home.teaching.exam.formal;

import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CheckboxExamFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private TextView f18153j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f18154k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f18155l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f18156m;

    /* renamed from: n, reason: collision with root package name */
    private RadioGroup f18157n;

    /* renamed from: o, reason: collision with root package name */
    private ExamActivity f18158o;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f18159a;

        a(final Map val$answer) {
            this.f18159a = val$answer;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            this.f18159a.put("icChecked", Boolean.valueOf(isChecked));
            if (isChecked) {
                CheckboxExamFragment.this.f18158o.X.setEnabled(true);
                CheckboxExamFragment.this.f18158o.Y.setEnabled(true);
                CheckboxExamFragment.this.f18158o.Y0 = true;
            }
        }
    }

    public void O() {
        if (this.f18158o.W0 != 1) {
            for (int i6 = 0; i6 < this.f18157n.getChildCount(); i6++) {
                CheckBox checkBox = (CheckBox) this.f18157n.getChildAt(i6);
                checkBox.setFocusable(false);
                checkBox.setFocusableInTouchMode(false);
                checkBox.setClickable(false);
            }
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        boolean z5;
        this.f18153j = (TextView) c(R.id.tv_question);
        this.f18157n = (RadioGroup) c(R.id.rg_answer);
        this.f18155l = (TextView) c(R.id.tv_index);
        this.f18156m = (TextView) c(2131299093);
        TextView textView = (TextView) c(2131299171);
        this.f18154k = textView;
        textView.setText("多选");
        int i6 = getArguments().getInt("index");
        this.f18158o = (ExamActivity) getActivity();
        Map<String, Object> map = ((SeralizableMap) getArguments().getSerializable("seralizableMap")).getMap();
        this.f18155l.setText((i6 + 1) + "");
        this.f18153j.setText(Html.fromHtml(JsonParse.getString(map, "questionName")));
        this.f18156m.setText("(" + JsonParse.getString(map, "score") + ")分");
        List<Map> list = (List) map.get("answers");
        this.f18157n.removeAllViews();
        boolean z6 = false;
        for (Map map2 : list) {
            CheckBox checkBox = new CheckBox(this.f1096g);
            checkBox.setTextSize(2, 16.0f);
            checkBox.setText(JsonParse.getString(map2, "mark") + "." + ((Object) Html.fromHtml(JsonParse.getString(map2, "answerOption"))));
            this.f18157n.addView(checkBox);
            if (map2.containsKey("icChecked") && ((Boolean) map2.get("icChecked")).booleanValue()) {
                z5 = true;
            } else {
                z5 = false;
            }
            checkBox.setChecked(z5);
            checkBox.setOnCheckedChangeListener(new a(map2));
            if (map2.containsKey("icChecked") && ((Boolean) map2.get("icChecked")).booleanValue()) {
                z6 = true;
            }
        }
        if (!z6 && !JsonParse.getBoolean(map, "timeFinish")) {
            return;
        }
        O();
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
