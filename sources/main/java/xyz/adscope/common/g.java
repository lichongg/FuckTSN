package xyz.adscope.common;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import xyz.adscope.common.analyse2.base.model.biz.AnalyseSimpleLog;
import xyz.adscope.common.analyse2.base.model.init.AnalyseEventModel;
import xyz.adscope.common.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedList<f> f56327a = new LinkedList<>();

    void a(AnalyseSimpleLog analyseSimpleLog) {
        LinkedList<f> linkedList = this.f56327a;
        if (linkedList == null || linkedList.getFirst() == null) {
            return;
        }
        this.f56327a.getFirst().c(analyseSimpleLog);
    }

    g(String str, String str2, String str3, List<AnalyseEventModel> list, f.c cVar) {
        Collections.reverse(list);
        f fVar = null;
        for (AnalyseEventModel analyseEventModel : list) {
            f fVar2 = new f(str, str2, str3);
            fVar2.a(cVar);
            fVar2.a(analyseEventModel);
            if (fVar != null) {
                fVar2.d(fVar);
            }
            this.f56327a.addFirst(fVar2);
            fVar = fVar2;
        }
    }
}
