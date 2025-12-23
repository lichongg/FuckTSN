package com.bxkj.base.chat;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.R;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class ReportChatActivity$initData$1 extends CommonAdapter<Map<String, Object>> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Map map, CompoundButton compoundButton, boolean z5) {
        if (map != null) {
            map.put("isChecked", Boolean.valueOf(z5));
        }
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void c(ViewHolder viewHolder, final Map<String, Object> map) {
        CheckBox checkBox;
        if (viewHolder != null) {
            viewHolder.s(R.id.iv_head, JsonParse.getString(map, "photo"));
        }
        if (viewHolder != null) {
            viewHolder.J(R.id.tv_msg, JsonParse.getString(map, "msg"));
        }
        if (viewHolder != null) {
            viewHolder.J(R.id.tv_user, JsonParse.getString(map, "userName"));
        }
        if (viewHolder != null) {
            viewHolder.J(R.id.tv_date, JsonParse.getString(map, "createTime"));
        }
        if (viewHolder == null || (checkBox = (CheckBox) viewHolder.h(R.id.cb)) == null) {
            return;
        }
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bxkj.base.chat.p
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
                ReportChatActivity$initData$1.o(map, compoundButton, z5);
            }
        });
    }

    ReportChatActivity$initData$1(Context context, int i6, List<? extends Map<String, Object>> list) {
        super(context, i6, list);
    }
}
