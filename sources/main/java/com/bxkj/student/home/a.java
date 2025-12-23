package com.bxkj.student.home;

import androidx.collection.ArrayMap;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.common.db.HomeMenuDB;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f17875b;

    /* renamed from: a, reason: collision with root package name */
    private final String f17876a = "groupType";

    private List<Map<String, Object>> a() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(CommonNetImpl.NAME, "理论考试");
        arrayMap.put("icon", "icon_1_7");
        arrayMap.put("type", 2);
        arrayMap.put("groupType", -1);
        arrayList.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put(CommonNetImpl.NAME, "查看点名");
        arrayMap2.put("icon", "icon_1_3");
        arrayMap2.put("type", 2);
        arrayMap2.put("groupType", -1);
        arrayList.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put(CommonNetImpl.NAME, "查看" + LoginUser.getLoginUser().getViewAfterLabelName());
        arrayMap3.put("icon", "icon_1_1");
        arrayMap3.put("type", 2);
        arrayMap3.put("groupType", -1);
        arrayList.add(arrayMap3);
        ArrayMap arrayMap4 = new ArrayMap();
        arrayMap4.put(CommonNetImpl.NAME, "上课请假");
        arrayMap4.put("icon", "icon_1_5");
        arrayMap4.put("type", 2);
        arrayMap4.put("groupType", -1);
        arrayList.add(arrayMap4);
        ArrayMap arrayMap5 = new ArrayMap();
        arrayMap5.put(CommonNetImpl.NAME, "App跑步");
        arrayMap5.put("icon", "icon_4_1");
        arrayMap5.put("type", 2);
        arrayMap5.put("groupType", -1);
        arrayList.add(arrayMap5);
        ArrayMap arrayMap6 = new ArrayMap();
        arrayMap6.put(CommonNetImpl.NAME, "预约场馆");
        arrayMap6.put("icon", "icon_5_1");
        arrayMap6.put("type", 2);
        arrayMap6.put("groupType", -1);
        arrayList.add(arrayMap6);
        ArrayMap arrayMap7 = new ArrayMap();
        arrayMap7.put(CommonNetImpl.NAME, "体测计算器");
        arrayMap7.put("icon", "icon_2_7");
        arrayMap7.put("type", 2);
        arrayMap7.put("groupType", -1);
        arrayList.add(arrayMap7);
        return arrayList;
    }

    public static a b() {
        if (f17875b == null) {
            synchronized (a.class) {
                try {
                    if (f17875b == null) {
                        f17875b = new a();
                    }
                } finally {
                }
            }
        }
        return f17875b;
    }

    private List<Map<String, Object>> d() {
        ArrayList arrayList = new ArrayList();
        List<HomeMenuDB> query = cn.bluemobi.dylan.sqlitelibrary.c.h().query(HomeMenuDB.class);
        if (query != null) {
            for (HomeMenuDB homeMenuDB : query) {
                if (LoginUser.getLoginUser().getIsOpenKeep() != 0 || !homeMenuDB.getMenuName().equals("绑定Keep账号")) {
                    if (LoginUser.getLoginUser().getIsOpenKeep() != 0 || !homeMenuDB.getMenuName().equals("同步Keep数据")) {
                        ArrayMap arrayMap = new ArrayMap();
                        arrayMap.put(CommonNetImpl.NAME, homeMenuDB.getMenuName());
                        arrayMap.put("icon", homeMenuDB.getIconResName());
                        arrayMap.put("type", 2);
                        arrayMap.put("groupType", -1);
                        arrayList.add(arrayMap);
                    }
                }
            }
        }
        return arrayList;
    }

    private a() {
    }

    public List<Map<String, Object>> c() {
        List<Map<String, Object>> d6 = d();
        if (d6.size() == 0) {
            return a();
        }
        return d6;
    }
}
