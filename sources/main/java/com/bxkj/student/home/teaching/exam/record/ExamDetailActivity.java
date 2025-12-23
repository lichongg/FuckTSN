package com.bxkj.student.home.teaching.exam.record;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ExamDetailActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private RecyclerView X;
    private List<Map<String, Object>> Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f18257a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f18258b0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            String str;
            String str2;
            CompoundButton radioButton;
            TextView textView = (TextView) holder.h(R.id.tv_question);
            if ("0".equals(JsonParse.getString(stringObjectMap, "questionType"))) {
                str = "单选";
            } else if ("1".equals(JsonParse.getString(stringObjectMap, "questionType"))) {
                str = "多选";
            } else if ("3".equals(JsonParse.getString(stringObjectMap, "questionType"))) {
                str = "判断";
            } else {
                str = "未知类型";
            }
            holder.J(2131299171, str);
            holder.J(R.id.tv_index, (holder.f() + 1) + "");
            holder.J(2131299093, "(" + JsonParse.getString(stringObjectMap, "score") + ")分");
            textView.setText(Html.fromHtml(JsonParse.getString(stringObjectMap, "questionName")));
            List<Map> list = (List) stringObjectMap.get("answers");
            RadioGroup radioGroup = (RadioGroup) holder.h(R.id.rg_answer);
            radioGroup.removeAllViews();
            String string = JsonParse.getString(stringObjectMap, "stuAnswers");
            for (Map map : list) {
                if (str.equals("多选")) {
                    radioButton = new CheckBox(this.f1138e);
                } else {
                    radioButton = new RadioButton(this.f1138e);
                }
                radioButton.setClickable(false);
                radioButton.setTextSize(2, 16.0f);
                radioButton.setText(JsonParse.getString(map, "mark") + "." + JsonParse.getString(map, "answerOption"));
                radioButton.setChecked(JsonParse.getString(map, "isRight").equals("0"));
                radioGroup.addView(radioButton);
            }
            holder.N(R.id.tv_right_answer, true);
            StringBuilder sb = new StringBuilder();
            sb.append("考生答案：");
            sb.append(string);
            sb.append("；是否正确：");
            if (JsonParse.getString(stringObjectMap, "isRight").equals("0")) {
                str2 = "正确";
            } else {
                str2 = "错误";
            }
            sb.append(str2);
            holder.J(R.id.tv_right_answer, sb.toString());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ExamDetailActivity.this.Y = (List) data.get("data");
            ExamDetailActivity.this.f18257a0.g(ExamDetailActivity.this.Y);
        }
    }

    private void k0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).o1(LoginUser.getLoginUser().getUserId(), this.Z, this.f18258b0)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("试卷详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return 2131492999;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("stuTeacherCurriculumId")) {
            this.Z = getIntent().getStringExtra("stuTeacherCurriculumId");
        }
        if (getIntent().hasExtra("identify")) {
            this.f18258b0 = getIntent().getStringExtra("identify");
        }
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        a aVar = new a(this.T, R.layout.fm_exam, this.Y);
        this.f18257a0 = aVar;
        this.X.setAdapter(aVar);
        k0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (SmartRefreshLayout) findViewById(2131298352);
        this.X = (RecyclerView) findViewById(2131298351);
        this.W.h0(false);
        this.W.v(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
