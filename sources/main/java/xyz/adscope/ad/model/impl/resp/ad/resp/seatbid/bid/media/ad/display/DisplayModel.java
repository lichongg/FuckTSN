package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.event.EventModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.ext.DisplayExtModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.NativeModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.report.ReportModel;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.common.v2.encrypt.impl.MD5Util;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;
import xyz.adscope.common.v2.tool.json.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DisplayModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "id")
    private String f55450a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = AMPSConstants.AdType.AD_TYPE_NATIVE)
    private NativeModel f55451b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "event")
    private List<EventModel> f55452c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "report")
    private ReportModel f55453d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = SocializeProtocolConstants.PROTOCOL_KEY_EXTEND)
    private DisplayExtModel f55454e;

    public List<EventModel> a() {
        return this.f55452c;
    }

    public DisplayExtModel b() {
        return this.f55454e;
    }

    public String c() {
        return this.f55450a;
    }

    public NativeModel d() {
        return this.f55451b;
    }

    public ReportModel e() {
        return this.f55453d;
    }

    public String f() {
        JSONArray jSONArray;
        JSONObject jSONObject = this.mJsonObject;
        return (jSONObject == null || (jSONArray = JsonUtil.getJSONArray(jSONObject, "event")) == null) ? MD5Util.md5("DEFAULT_EVENT") : MD5Util.md5(jSONArray.toString());
    }

    public DisplayModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
