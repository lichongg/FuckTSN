package com.bxkj.student.home.teaching.learning.answer;

import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CheckboxAnswerFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private TextView f18464j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f18465k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f18466l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f18467m;

    /* renamed from: n, reason: collision with root package name */
    private RadioGroup f18468n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f18469a;

        a(final Map val$answer) {
            this.f18469a = val$answer;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            this.f18469a.put("icChecked", Boolean.valueOf(isChecked));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        boolean z5;
        this.f18464j = (TextView) c(R.id.tv_question);
        this.f18468n = (RadioGroup) c(R.id.rg_answer);
        this.f18466l = (TextView) c(R.id.tv_index);
        this.f18467m = (TextView) c(2131299093);
        TextView textView = (TextView) c(2131299171);
        this.f18465k = textView;
        textView.setText("多选");
        int i6 = getArguments().getInt("index");
        Map<String, Object> map = ((AnswerActivity) getActivity()).I0().get(i6);
        this.f18466l.setText((i6 + 1) + "");
        this.f18464j.setText(Html.fromHtml(JsonParse.getString(map, "questionName")));
        this.f18467m.setText("(" + JsonParse.getString(map, "score") + ")分");
        List<Map> list = (List) map.get("answers");
        this.f18468n.removeAllViews();
        for (Map map2 : list) {
            CheckBox checkBox = new CheckBox(this.f1096g);
            checkBox.setTextSize(2, 16.0f);
            checkBox.setText(JsonParse.getString(map2, "mark") + "." + ((Object) Html.fromHtml(JsonParse.getString(map2, "answerOption"))));
            this.f18468n.addView(checkBox);
            if (map2.containsKey("icChecked") && ((Boolean) map2.get("icChecked")).booleanValue()) {
                z5 = true;
            } else {
                z5 = false;
            }
            checkBox.setChecked(z5);
            checkBox.setOnCheckedChangeListener(new a(map2));
        }
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
