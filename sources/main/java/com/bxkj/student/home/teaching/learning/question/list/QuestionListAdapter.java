package com.bxkj.student.home.teaching.learning.question.list;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.homework.question.list.QuestionListAdapter;
import com.bxkj.student.home.teaching.learning.m;
import com.bxkj.student.home.teaching.learning.question.CheckboxQuestionActivity;
import com.bxkj.student.home.teaching.learning.question.ImageActivity;
import com.bxkj.student.home.teaching.learning.question.RadioQuestionActivity;
import com.bxkj.student.home.teaching.learning.question.TextQuestionActivity;
import com.bxkj.student.home.teaching.learning.question.VideoQuestionActivity;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class QuestionListAdapter extends CommonAdapter<Map<String, Object>> {

    /* renamed from: k, reason: collision with root package name */
    private QuestionListAdapter.b f18803k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (QuestionListAdapter.this.f18803k != null) {
                QuestionListAdapter.this.f18803k.onRefresh();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void onRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(Map map) {
        Http.with(this.f1138e).setObservable(((m) Http.getApiService(m.class)).g(JsonParse.getString(map, "questionId"))).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(final Map map, View view) {
        new iOSTwoButtonDialog(this.f1138e).setMessage("确定要删除本次答案吗?删除后不可恢复,请谨慎操作").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.question.list.e
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                QuestionListAdapter.this.r(map);
            }
        }).show();
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
        holder.J(R.id.tv_index, (holder.f() + 1) + ".");
        holder.J(2131299171, JsonParse.getString(stringObjectMap, "questionTypeName"));
        com.bxkj.base.util.m.a((TextView) holder.h(R.id.tv_question), JsonParse.getString(stringObjectMap, "questions"));
        holder.J(2131299093, "满分：" + JsonParse.getString(stringObjectMap, "socre") + "分");
        int i6 = JsonParse.getInt(stringObjectMap, "isQualified");
        holder.K(R.id.tv_my_score, i6 == 1 ? ContextCompat.getColor(this.f1138e, 2131099731) : ContextCompat.getColor(this.f1138e, 2131099730));
        holder.J(R.id.tv_my_score, JsonParse.getString(stringObjectMap, "isQualifiedName"));
        holder.J(R.id.bt_answer, i6 == 0 ? "开始答题" : "查看答案");
        holder.N(R.id.bt_reAnswer, i6 == 2);
        holder.w(R.id.bt_reAnswer, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.list.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuestionListAdapter.this.s(stringObjectMap, view);
            }
        });
        holder.w(R.id.bt_answer, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.list.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuestionListAdapter.this.t(holder, view);
            }
        });
    }

    public void u(QuestionListAdapter.b refreshListListener) {
        this.f18803k = refreshListListener;
    }

    public void v(int position) {
        Intent intent = new Intent();
        String string = JsonParse.getString(getItem(position), "id");
        String string2 = JsonParse.getString(getItem(position), "questionId");
        if (TextUtils.isEmpty(string)) {
            string = string2;
        }
        intent.putExtra("questionId", string);
        intent.putExtra("isQualified", JsonParse.getInt(getItem(position), "isQualified"));
        if (JsonParse.getInt(getItem(position), "questionType") == 0) {
            intent.setClass(this.f1138e, RadioQuestionActivity.class);
        } else if (1 == JsonParse.getInt(getItem(position), "questionType")) {
            intent.setClass(this.f1138e, CheckboxQuestionActivity.class);
        } else if (2 == JsonParse.getInt(getItem(position), "questionType")) {
            intent.setClass(this.f1138e, RadioQuestionActivity.class);
        } else if (3 == JsonParse.getInt(getItem(position), "questionType")) {
            intent.setClass(this.f1138e, TextQuestionActivity.class);
        } else if (4 == JsonParse.getInt(getItem(position), "questionType")) {
            intent.setClass(this.f1138e, ImageActivity.class);
        } else if (5 == JsonParse.getInt(getItem(position), "questionType")) {
            intent.setClass(this.f1138e, VideoQuestionActivity.class);
        }
        this.f1138e.startActivity(intent);
    }

    public QuestionListAdapter(Context context, List<Map<String, Object>> datas) {
        super(context, R.layout.item_for_lean_question_list, datas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(ViewHolder viewHolder, View view) {
        v(viewHolder.f());
    }
}
