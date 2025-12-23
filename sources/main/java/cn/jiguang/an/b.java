package cn.jiguang.an;

import android.content.Context;
import cn.jiguang.bb.f;
import cn.jpush.android.api.InAppSlotParams;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends cn.jiguang.m.a {

    /* renamed from: a, reason: collision with root package name */
    private Context f1633a;

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        this.f1633a = context;
        return "JDataCollectStatistic";
    }

    @Override // cn.jiguang.m.a
    protected boolean a(Context context, String str) {
        return true;
    }

    @Override // cn.jiguang.m.a
    protected void d(Context context, String str) {
        if (cn.jiguang.g.a.a().g(2600)) {
            return;
        }
        try {
            JSONArray a6 = a.a(context);
            if (a6 != null && a6.length() != 0) {
                ArrayList<JSONArray> a7 = cn.jiguang.common.app.helper.b.a(a6);
                if (a7 != null && !a7.isEmpty()) {
                    int size = a7.size();
                    int i6 = 0;
                    while (i6 < size) {
                        JSONObject jSONObject = new JSONObject();
                        JSONArray jSONArray = a7.get(i6);
                        i6++;
                        jSONObject.put("slice_index", i6);
                        jSONObject.put("slice_count", size);
                        jSONObject.put("data", jSONArray);
                        jSONObject.put(InAppSlotParams.SLOT_KEY.SEQ, UUID.randomUUID().toString());
                        cn.jiguang.be.b.a(context, jSONObject, "collect_statistic");
                    }
                    a.b(context);
                    super.d(context, str);
                    return;
                }
                f.i("JDataCollectStatistic", "statistic data partition failed");
                return;
            }
            f.c("JDataCollectStatistic", "no collect statistic data to report");
        } catch (Throwable th) {
            f.i("JDataCollectStatistic", "collect data report failed: " + th.getMessage());
        }
    }

    @Override // cn.jiguang.m.a
    protected boolean b(Context context, String str) {
        return super.b(context, str);
    }

    @Override // cn.jiguang.m.a
    protected void c(Context context, String str) {
        super.c(context, str);
    }
}
