package com.bxkj.student.life.info;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class InfoAdapter extends MultiItemCommonAdapter<Map<String, Object>> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            List list = JsonParse.getList(InfoAdapter.this.getItem(position), "titleImg", String.class);
            ((CommonAdapter) InfoAdapter.this).f1138e.startActivity(new Intent(((CommonAdapter) InfoAdapter.this).f1138e, (Class<?>) InfoDetailActivity.class).putExtra("infoId", JsonParse.getString(InfoAdapter.this.getItem(position), "id")).putExtra("inforTitle", JsonParse.getString(InfoAdapter.this.getItem(position), "inforTitle")).putExtra("imageUrl", (list == null || list.size() <= 0) ? "" : (String) list.get(0)));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> {
        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(ViewHolder holder, String url) {
            holder.t(R.id.iv_img, url, 2131689689, R.mipmap.icon_smal);
        }
    }

    public InfoAdapter(Context context, List<Map<String, Object>> datas) {
        super(context, datas, new com.bxkj.student.life.info.a());
        k(new a());
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
        holder.J(2131298946, JsonParse.getString(stringObjectMap, "inforTitle"));
        holder.J(2131299176, JsonParse.getString(stringObjectMap, "inforSource"));
        holder.J(2131299158, JsonParse.getString(stringObjectMap, "publishTime"));
        List list = JsonParse.getList(stringObjectMap, "titleImg", String.class);
        if (getItemViewType(holder.f()) == 1) {
            holder.t(R.id.iv, (String) list.get(0), 2131689689, R.mipmap.icon_smal);
            return;
        }
        if (getItemViewType(holder.f()) == 2) {
            holder.t(R.id.iv1, (String) list.get(0), 2131689689, R.mipmap.icon_smal);
            holder.t(R.id.iv2, (String) list.get(1), 2131689689, R.mipmap.icon_smal);
            return;
        }
        if (list.size() > 3) {
            list = list.subList(0, 3);
        }
        GridView gridView = (GridView) holder.h(R.id.gv_img);
        if (list == null || list.size() == 0) {
            gridView.setVisibility(8);
            return;
        }
        gridView.setVisibility(0);
        gridView.setEnabled(false);
        gridView.setPressed(false);
        gridView.setClickable(false);
        gridView.setAdapter((ListAdapter) new b(this.f1138e, R.layout.item_for_lost_img, list));
    }
}
