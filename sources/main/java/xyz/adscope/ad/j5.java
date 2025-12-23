package xyz.adscope.ad;

import androidx.annotation.NonNull;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import xyz.adscope.common.v2.location.ILocation;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class j5 extends t {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = com.umeng.analytics.pro.d.C)
    private float f55275a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = "lon")
    private float f55276b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = SocializeProtocolConstants.PROTOCOL_KEY_EXTEND)
    private o1 f55277c;

    public j5(@NonNull ILocation iLocation) {
        this.f55275a = (float) iLocation.getLatitude();
        this.f55276b = (float) iLocation.getLongitude();
        this.f55277c = new o1(iLocation.getLocationTimestamp(), iLocation.getCoordinateType().getType());
    }
}
