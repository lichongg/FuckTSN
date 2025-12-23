package xyz.adscope.common.analyse2.base.model.biz;

import org.json.JSONObject;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSExtraLog extends AnalyseAdEventLog {

    @JsonParseNode(key = "s_custom_data")
    private String customData;

    @JsonParseNode(key = "ecpm")
    private String ecpm;

    @JsonParseNode(key = "floor_price")
    private String floorPrice;

    @JsonParseNode(key = "bid_seat_id")
    private String mBidSeatID;

    @JsonParseNode(key = "bid_space_id")
    private String mBidSpaceID;

    @JsonParseNode(key = "bid_type")
    private String mBidType;

    @JsonParseNode(key = "s_app_id")
    private String mChannelAppID;

    @JsonParseNode(key = "s_space_id")
    private String mChannelSpaceID;

    @JsonParseNode(key = "is_hit_auction")
    private String mHitAuction;

    @JsonParseNode(key = "is_last_look")
    private String mLastLook;

    @JsonParseNode(key = "load_type")
    private String mLoadType;

    @JsonParseNode(key = "loss_reason")
    private String mLossReason;

    @JsonParseNode(key = "notice_price")
    private String mNoticePrice;

    @JsonParseNode(key = "real_price")
    private String mRealPrice;

    @JsonParseNode(key = "seat_id")
    private String mSeatID;

    @JsonParseNode(key = "s_time_out")
    private String mTimeout;

    public AMPSExtraLog(JSONObject jSONObject) {
        super(jSONObject);
    }
}
