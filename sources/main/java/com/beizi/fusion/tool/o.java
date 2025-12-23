package com.beizi.fusion.tool;

import android.util.Pair;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class o {
    public static List<Pair<String, Integer>> a(List<AdSpacesBean.DpLinkUrlListBean> list) {
        if (list == null || list.size() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (AdSpacesBean.DpLinkUrlListBean dpLinkUrlListBean : list) {
            arrayList.add(new Pair(dpLinkUrlListBean.getDpLinkUrL(), Integer.valueOf(dpLinkUrlListBean.getOptimizePercent())));
        }
        return arrayList;
    }
}
