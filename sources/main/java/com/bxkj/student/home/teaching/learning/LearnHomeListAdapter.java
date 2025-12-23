package com.bxkj.student.home.teaching.learning;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.learning.detail.LearnDetailActivity;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class LearnHomeListAdapter extends CommonAdapter<Map<String, Object>> {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(Map map, View view) {
        this.f1138e.startActivity(new Intent(this.f1138e, (Class<?>) LearnDetailActivity.class).putExtra("title", JsonParse.getString(map, "title")).putExtra("id", JsonParse.getString(map, "id")));
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
        holder.J(2131298986, JsonParse.getString(stringObjectMap, "title"));
        holder.K(2131298986, JsonParse.getInt(stringObjectMap, "isOk") == 1 ? ContextCompat.getColor(this.f1138e, R.color.tab_normal) : ContextCompat.getColor(this.f1138e, 2131099731));
        holder.J(R.id.tv_play_num, JsonParse.getString(stringObjectMap, "pv"));
        holder.J(2131299158, JsonParse.getString(stringObjectMap, "publishTime"));
        int i6 = JsonParse.getInt(stringObjectMap, "type") == 2 ? 2131231926 : JsonParse.getInt(stringObjectMap, "type") == 3 ? R.mipmap.pdf : JsonParse.getInt(stringObjectMap, "type") == 4 ? 2131231925 : 2131231184;
        holder.t(2131297182, JsonParse.getString(stringObjectMap, "indexImg"), i6, i6);
        holder.N(R.id.iv_type, JsonParse.getInt(stringObjectMap, "type") == 2);
        holder.N(R.id.cv_video_flag, JsonParse.getInt(stringObjectMap, "type") == 2);
        holder.b().setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LearnHomeListAdapter.this.o(stringObjectMap, view);
            }
        });
    }

    public LearnHomeListAdapter(Context context, List<Map<String, Object>> datas) {
        super(context, R.layout.item_for_learn_list, datas);
    }
}
