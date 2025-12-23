package com.bytedance.msdk.cw.cw.xt.j.j;

import a1.b;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r extends xt {
    public void j(com.bytedance.msdk.api.r.j.xt.j jVar) {
        if (j()) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "自定义Adapter 加载成功或者失败回调只能调用一次");
        } else {
            j(new com.bytedance.msdk.api.j(49010, com.bytedance.msdk.api.j.j(49010), jVar == null ? -1 : jVar.j(), jVar == null ? "" : jVar.xt()));
        }
    }

    public boolean cw() {
        com.bytedance.msdk.api.r.j.xt.cw.cw cwVar = ((xt) this).xt;
        return cwVar != null && cwVar.xt() == 1;
    }

    public boolean r() {
        com.bytedance.msdk.api.r.j.xt.cw.cw cwVar = ((xt) this).xt;
        return cwVar != null && cwVar.xt() == 2;
    }

    public void xt(List<Function<SparseArray<Object>, Object>> list) {
        if (list == null) {
            j(new com.bytedance.msdk.api.r.j.xt.j(49010, "list is null"));
            return;
        }
        if (xt()) {
            com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, "自定义Adapter 加载成功或者失败回调只能调用一次");
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Function<SparseArray<Object>, Object>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.bytedance.msdk.cw.j.j.up(this, b.a(it.next())));
        }
        j(arrayList);
    }

    public r(String str, com.bytedance.msdk.cw.j.xt xtVar) {
        super(str, xtVar);
    }

    @Override // com.bytedance.msdk.cw.cw.xt.j.j.xt
    public <T> T j(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i6 == 8222) {
            boolean cw = cw();
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom feed loader : isExpressRender: " + cw);
            return (T) Boolean.valueOf(cw);
        }
        if (i6 == 8223) {
            boolean r5 = r();
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom feed loader : isNativeAd: " + r5);
            return (T) Boolean.valueOf(r5);
        }
        if (i6 != 8123) {
            if (i6 != 8107) {
                return null;
            }
            List<Function<SparseArray<Object>, Object>> list = (List) pluginValueSet.objectValue(8303, List.class);
            StringBuilder sb = new StringBuilder("Adn custom feed loader : callLoadSucceed  list size:");
            sb.append(list != null ? list.size() : 0);
            com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, sb.toString());
            xt(list);
            return null;
        }
        int intValue = pluginValueSet.intValue(8014);
        String stringValue = pluginValueSet.stringValue(8015);
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "Adn custom feed loader : callLoaderFail  code:" + intValue + " msg:" + stringValue);
        j(intValue, stringValue);
        return null;
    }
}
