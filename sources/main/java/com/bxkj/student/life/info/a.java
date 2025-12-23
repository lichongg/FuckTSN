package com.bxkj.student.life.info;

import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a implements cn.bluemobi.dylan.base.adapter.common.recyclerview.a<Map<String, Object>> {
    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
    public int b(int itemType) {
        return itemType == 1 ? R.layout.item_for_info_list1 : itemType == 2 ? R.layout.item_for_info_list2 : R.layout.item_for_info_list;
    }

    @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int a(int position, Map<String, Object> stringObjectMap) {
        List list = JsonParse.getList(stringObjectMap, "titleImg", String.class);
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
