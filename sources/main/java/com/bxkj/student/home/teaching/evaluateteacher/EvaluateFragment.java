package com.bxkj.student.home.teaching.evaluateteacher;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.IdRes;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class EvaluateFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private TextView f18112j;

    /* renamed from: k, reason: collision with root package name */
    private RadioGroup f18113k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f18114a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f18115b;

        a(final Map val$data, final List val$answers) {
            this.f18114a = val$data;
            this.f18115b = val$answers;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            this.f18114a.put("checkScore", JsonParse.getString((Map) this.f18115b.get(EvaluateFragment.this.f18113k.indexOfChild(EvaluateFragment.this.f18113k.findViewById(checkedId))), "score"));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f18112j = (TextView) c(R.id.tv_question);
        this.f18113k = (RadioGroup) c(R.id.rg_answer);
        int i6 = getArguments().getInt("index");
        Map<String, Object> map = ((EvaluateActivity) getActivity()).v0().get(i6);
        this.f18112j.setText((i6 + 1) + "." + JsonParse.getString(map, "content"));
        List<Map> list = (List) map.get("scores");
        this.f18113k.removeAllViews();
        for (Map map2 : list) {
            RadioButton radioButton = new RadioButton(this.f1096g);
            radioButton.setTextSize(2, 16.0f);
            radioButton.setText(JsonParse.getString(map2, "score"));
            this.f18113k.addView(radioButton);
            if (JsonParse.getString(map, "checkScore").equals(JsonParse.getString(map2, "score"))) {
                radioButton.setChecked(true);
            } else {
                radioButton.setChecked(false);
            }
        }
        this.f18113k.setOnCheckedChangeListener(new a(map, list));
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.fm_evaluate_teacher;
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
