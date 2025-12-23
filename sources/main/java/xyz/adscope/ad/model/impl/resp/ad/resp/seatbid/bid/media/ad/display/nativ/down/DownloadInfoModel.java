package xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.down;

import android.text.TextUtils;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.List;
import org.json.JSONObject;
import xyz.adscope.ad.model.impl.resp.ASNPJsonResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.down.ext.DownloadExtModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.down.permission.PermissionModel;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DownloadInfoModel extends ASNPJsonResponseModel {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "iconUrl")
    private String f55479a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "bundle")
    private String f55480b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = CommonNetImpl.NAME)
    private String f55481c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "size")
    private String f55482d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = "developer")
    private String f55483e;

    /* renamed from: f, reason: collision with root package name */
    @JsonParseNode(key = "permission")
    private List<PermissionModel> f55484f;

    /* renamed from: g, reason: collision with root package name */
    @JsonParseNode(key = "policyUrl")
    private String f55485g;

    /* renamed from: h, reason: collision with root package name */
    @JsonParseNode(key = "version")
    private String f55486h;

    /* renamed from: i, reason: collision with root package name */
    @JsonParseNode(key = "permissionUrl")
    private String f55487i;

    /* renamed from: j, reason: collision with root package name */
    @JsonParseNode(key = bi.bt)
    private String f55488j;

    /* renamed from: k, reason: collision with root package name */
    @JsonParseNode(key = "appintro")
    private String f55489k;

    /* renamed from: l, reason: collision with root package name */
    @JsonParseNode(key = TKDownloadReason.KSAD_TK_MD5)
    private String f55490l;

    /* renamed from: m, reason: collision with root package name */
    @JsonParseNode(key = SocializeProtocolConstants.PROTOCOL_KEY_EXTEND)
    private DownloadExtModel f55491m;

    public String a() {
        return this.f55490l;
    }

    public String b() {
        return this.f55489k;
    }

    public String c() {
        return this.f55480b;
    }

    public String d() {
        return this.f55483e;
    }

    public String e() {
        return this.f55479a;
    }

    public String f() {
        return this.f55481c;
    }

    public List<PermissionModel> g() {
        return this.f55484f;
    }

    public String h() {
        return this.f55487i;
    }

    public String i() {
        return this.f55488j;
    }

    public String j() {
        return this.f55485g;
    }

    public String k() {
        return this.f55482d;
    }

    public String l() {
        return this.f55486h;
    }

    public boolean m() {
        if (TextUtils.isEmpty(this.f55481c) || TextUtils.isEmpty(this.f55483e) || TextUtils.isEmpty(this.f55486h)) {
            return false;
        }
        if (TextUtils.isEmpty(this.f55488j) && TextUtils.isEmpty(this.f55485g)) {
            return false;
        }
        List<PermissionModel> list = this.f55484f;
        return (((list == null || list.isEmpty()) && TextUtils.isEmpty(this.f55487i)) || TextUtils.isEmpty(this.f55489k)) ? false : true;
    }

    public boolean n() {
        DownloadExtModel downloadExtModel = this.f55491m;
        return downloadExtModel == null || downloadExtModel.a();
    }

    public boolean o() {
        DownloadExtModel downloadExtModel = this.f55491m;
        return downloadExtModel == null || downloadExtModel.b();
    }

    public DownloadInfoModel(JSONObject jSONObject) {
        super(jSONObject);
    }
}
