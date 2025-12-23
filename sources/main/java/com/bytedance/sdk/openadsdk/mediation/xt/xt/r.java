package com.bytedance.sdk.openadsdk.mediation.xt.xt;

import a1.a;
import a1.b;
import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class r implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private PluginValueSet f31793j;

    public abstract int j(com.bytedance.sdk.openadsdk.mediation.xt.xt.j.r rVar);

    public abstract Object j(int i6, PluginValueSet pluginValueSet);

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet k6 = e.i(sparseArray).k();
        int intValue = k6.intValue(-99999987);
        k6.objectValue(-99999985, Class.class);
        switch (intValue) {
            case -99999986:
                return xt().sparseArray();
            case 270024:
                return j();
            case 271043:
                return j(k6.intValue(0), e.i((SparseArray) k6.objectValue(1, SparseArray.class)).k());
            case 271050:
                j((Map<String, Object>) k6.objectValue(0, Map.class));
                return null;
            default:
                switch (intValue) {
                    case 270013:
                        Activity activity = (Activity) k6.objectValue(0, Activity.class);
                        List list = (List) k6.objectValue(1, List.class);
                        if (list == null) {
                            list = new ArrayList(0);
                        }
                        ArrayList arrayList = new ArrayList();
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new up(b.a(it.next())));
                        }
                        j(activity, arrayList, k6.intValue(2), k6.intValue(3), b.a(k6.objectValue(4, a.a())));
                        return null;
                    case 270014:
                        j(new com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.cw((SparseArray) k6.objectValue(0, SparseArray.class)));
                        return null;
                    case 270015:
                        j((String) k6.objectValue(0, String.class));
                        return null;
                    case 270016:
                        j(new com.bytedance.sdk.openadsdk.i.cw.cw.r((SparseArray) k6.objectValue(0, SparseArray.class)));
                        return null;
                    case 270017:
                        j((Context) k6.objectValue(0, Context.class));
                        return null;
                    case 270018:
                        j((Context) k6.objectValue(0, Context.class), (int[]) k6.objectValue(1, int[].class));
                        return null;
                    case 270019:
                        j(k6.intValue(0));
                        return null;
                    case 270020:
                        return Integer.class.cast(Integer.valueOf(j(new com.bytedance.sdk.openadsdk.mediation.xt.xt.j.r(b.a(k6.objectValue(0, a.a()))))));
                    case 270021:
                        Context context = (Context) k6.objectValue(0, Context.class);
                        Function<SparseArray<Object>, Object> a6 = b.a(k6.objectValue(3, a.a()));
                        j(context, new j((SparseArray) k6.objectValue(1, SparseArray.class)), new com.bytedance.sdk.openadsdk.mediation.xt.xt.j.cw(b.a(k6.objectValue(2, a.a()))), a6);
                        return null;
                    case 270022:
                        Context context2 = (Context) k6.objectValue(0, Context.class);
                        Function<SparseArray<Object>, Object> a7 = b.a(k6.objectValue(3, a.a()));
                        j(context2, new j((SparseArray) k6.objectValue(1, SparseArray.class)), new com.bytedance.sdk.openadsdk.mediation.xt.xt.j.j(b.a(k6.objectValue(2, a.a()))), a7);
                        return null;
                    default:
                        return null;
                }
        }
    }

    public abstract Map<String, Object> j();

    public abstract void j(int i6);

    public abstract void j(Activity activity, List<up> list, int i6, int i7, Function<SparseArray<Object>, Object> function);

    public abstract void j(Context context);

    public abstract void j(Context context, j jVar, com.bytedance.sdk.openadsdk.mediation.xt.xt.j.cw cwVar, Function<SparseArray<Object>, Object> function);

    public abstract void j(Context context, j jVar, com.bytedance.sdk.openadsdk.mediation.xt.xt.j.j jVar2, Function<SparseArray<Object>, Object> function);

    public abstract void j(Context context, int[] iArr);

    public abstract void j(com.bytedance.sdk.openadsdk.i.cw.cw.r rVar);

    public abstract void j(com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.cw cwVar);

    public abstract void j(String str);

    public abstract void j(Map<String, Object> map);

    public PluginValueSet xt() {
        PluginValueSet pluginValueSet = this.f31793j;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet cw = cw();
        this.f31793j = cw;
        return cw;
    }

    private PluginValueSet cw() {
        return e.a().k();
    }
}
