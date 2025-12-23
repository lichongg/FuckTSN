package xyz.adscope.common;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import xyz.adscope.common.analyse.model.IBaseEventReportModel;
import xyz.adscope.common.analyse.model.impl.HistoryDbModel;
import xyz.adscope.common.analyse.publish.IEventConfigModel;
import xyz.adscope.common.p;
import xyz.adscope.common.v2.tool.str.RegexUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private IEventConfigModel f56448a;

    /* renamed from: b, reason: collision with root package name */
    private n f56449b;

    /* renamed from: c, reason: collision with root package name */
    private p<HistoryDbModel> f56450c;

    /* renamed from: d, reason: collision with root package name */
    private b f56451d;

    /* renamed from: e, reason: collision with root package name */
    private final c f56452e = new c(this, null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface b {
        void a(List<HistoryDbModel> list);

        void a(HistoryDbModel historyDbModel);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements p.a {
        private c() {
        }

        /* synthetic */ c(n nVar, a aVar) {
            this();
        }

        @Override // xyz.adscope.common.p.a
        public void a(List list) {
            n.this.a((List<HistoryDbModel>) list);
        }
    }

    private void b(IBaseEventReportModel iBaseEventReportModel) {
        n nVar = this.f56449b;
        if (nVar != null) {
            nVar.d(iBaseEventReportModel);
        }
    }

    private HistoryDbModel c(IBaseEventReportModel iBaseEventReportModel) {
        String macros = this.f56448a.getMacros();
        String uploadURL = this.f56448a.getUploadURL();
        String acceptEncrypt = this.f56448a.getAcceptEncrypt();
        if (TextUtils.isEmpty(macros) || TextUtils.isEmpty(uploadURL)) {
            return null;
        }
        HistoryDbModel historyDbModel = new HistoryDbModel();
        Map<String, String> macrosReplaceMap = iBaseEventReportModel.getMacrosReplaceMap();
        historyDbModel.setUrl(uploadURL);
        historyDbModel.setEncrypt(acceptEncrypt);
        historyDbModel.setApiKey("");
        historyDbModel.setStoreTime(System.currentTimeMillis());
        historyDbModel.setMacros(RegexUtil.replaceMacros(macros, macrosReplaceMap));
        return historyDbModel;
    }

    void a(b bVar) {
        this.f56451d = bVar;
    }

    void d(IBaseEventReportModel iBaseEventReportModel) {
        this.f56450c.a(this.f56452e);
        if (!a(iBaseEventReportModel)) {
            b(iBaseEventReportModel);
            return;
        }
        HistoryDbModel c6 = c(iBaseEventReportModel);
        if (c6 != null) {
            a(c6);
            this.f56450c.add((p<HistoryDbModel>) c6);
        }
    }

    n() {
    }

    void a(IEventConfigModel iEventConfigModel) {
        long j6;
        this.f56448a = iEventConfigModel;
        try {
            j6 = Long.parseLong(iEventConfigModel.getTime());
        } catch (NumberFormatException unused) {
            j6 = 0;
        }
        this.f56450c = new p<>(iEventConfigModel.getCount(), j6);
    }

    void a(n nVar) {
        this.f56449b = nVar;
    }

    private boolean a(IBaseEventReportModel iBaseEventReportModel) {
        IEventConfigModel iEventConfigModel = this.f56448a;
        if (iEventConfigModel == null || iEventConfigModel.getCodes() == null || this.f56448a.getCodes().isEmpty()) {
            return false;
        }
        return this.f56448a.getCodes().contains(iBaseEventReportModel.getEventCode());
    }

    private void a(HistoryDbModel historyDbModel) {
        b bVar = this.f56451d;
        if (bVar != null) {
            bVar.a(historyDbModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<HistoryDbModel> list) {
        b bVar = this.f56451d;
        if (bVar != null) {
            bVar.a(list);
        }
    }
}
