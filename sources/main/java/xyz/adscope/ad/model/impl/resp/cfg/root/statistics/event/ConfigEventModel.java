package xyz.adscope.ad.model.impl.resp.cfg.root.statistics.event;

import java.util.List;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.common.analyse.model.impl.HistoryDbModel;
import xyz.adscope.common.analyse.publish.IEventConfigModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ConfigEventModel extends ASNPJsonResponseModel implements IEventConfigModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "codes")
    private List<String> f55619a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "uploadUrl")
    private String f55620b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = HistoryDbModel.COLUMN_MACROS)
    private String f55621c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "count")
    private int f55622d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = "time")
    private String f55623e;

    /* renamed from: f, reason: collision with root package name */
    @JsonParseNode(key = HistoryDbModel.COLUMN_ACCEPT_ENCRYPT)
    private String f55624f;

    @Override // xyz.adscope.common.analyse.publish.IEventConfigModel
    public String getAcceptEncrypt() {
        return this.f55624f;
    }

    @Override // xyz.adscope.common.analyse.publish.IEventConfigModel
    public List<String> getCodes() {
        return this.f55619a;
    }

    @Override // xyz.adscope.common.analyse.publish.IEventConfigModel
    public int getCount() {
        return this.f55622d;
    }

    @Override // xyz.adscope.common.analyse.publish.IEventConfigModel
    public String getMacros() {
        return this.f55621c;
    }

    @Override // xyz.adscope.common.analyse.publish.IEventConfigModel
    public String getTime() {
        return this.f55623e;
    }

    @Override // xyz.adscope.common.analyse.publish.IEventConfigModel
    public String getUploadURL() {
        return this.f55620b;
    }

    public ConfigEventModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
