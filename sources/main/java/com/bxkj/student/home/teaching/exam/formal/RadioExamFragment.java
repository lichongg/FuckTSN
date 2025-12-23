package com.bxkj.student.home.teaching.exam.formal;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.IdRes;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class RadioExamFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private TextView f18181j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f18182k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f18183l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f18184m;

    /* renamed from: n, reason: collision with root package name */
    private RadioGroup f18185n;

    /* renamed from: o, reason: collision with root package name */
    private ExamActivity f18186o;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f18187a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f18188b;

        a(final Map val$data, final List val$answers) {
            this.f18187a = val$data;
            this.f18188b = val$answers;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            this.f18187a.put("checkAnswerId", JsonParse.getString((Map) this.f18188b.get(RadioExamFragment.this.f18185n.indexOfChild(RadioExamFragment.this.f18185n.findViewById(checkedId))), "answerId"));
            RadioExamFragment.this.f18186o.X.setEnabled(true);
            RadioExamFragment.this.f18186o.Y.setEnabled(true);
            RadioExamFragment.this.f18186o.Y0 = true;
        }
    }

    public void P() {
        if (this.f18186o.W0 != 1) {
            for (int i6 = 0; i6 < this.f18185n.getChildCount(); i6++) {
                RadioButton radioButton = (RadioButton) this.f18185n.getChildAt(i6);
                radioButton.setClickable(false);
                radioButton.setFocusable(false);
                radioButton.setFocusableInTouchMode(false);
            }
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f18181j = (TextView) c(R.id.tv_question);
        this.f18185n = (RadioGroup) c(R.id.rg_answer);
        this.f18183l = (TextView) c(R.id.tv_index);
        this.f18184m = (TextView) c(2131299093);
        this.f18182k = (TextView) c(2131299171);
        int i6 = getArguments().getInt("index");
        this.f18186o = (ExamActivity) getActivity();
        Map<String, Object> map = ((SeralizableMap) getArguments().getSerializable("seralizableMap")).getMap();
        this.f18183l.setText((i6 + 1) + "");
        this.f18181j.setText(Html.fromHtml(JsonParse.getString(map, "questionName")));
        this.f18184m.setText("(" + JsonParse.getString(map, "score") + ")分");
        List<Map> list = (List) map.get("answers");
        this.f18185n.removeAllViews();
        if ("0".equals(JsonParse.getString(map, "questionType"))) {
            this.f18182k.setText("单选");
        } else if ("1".equals(JsonParse.getString(map, "questionType"))) {
            this.f18182k.setText("多选");
        } else if ("3".equals(JsonParse.getString(map, "questionType"))) {
            this.f18182k.setText("判断");
        }
        for (Map map2 : list) {
            RadioButton radioButton = new RadioButton(this.f1096g);
            radioButton.setTextSize(2, 16.0f);
            radioButton.setText(JsonParse.getString(map2, "mark") + "." + ((Object) Html.fromHtml(JsonParse.getString(map2, "answerOption"))));
            this.f18185n.addView(radioButton);
            if (JsonParse.getString(map, "checkAnswerId").equals(JsonParse.getString(map2, "answerId"))) {
                radioButton.setChecked(true);
            } else {
                radioButton.setChecked(false);
            }
        }
        if (!TextUtils.isEmpty(JsonParse.getString(map, "checkAnswerId")) || JsonParse.getBoolean(map, "timeFinish")) {
            P();
        }
        this.f18185n.setOnCheckedChangeListener(new a(map, list));
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
