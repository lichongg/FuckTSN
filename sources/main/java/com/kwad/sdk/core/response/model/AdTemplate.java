package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ab;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class AdTemplate extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -5413539480595883024L;
    public long adLoadTotalTime;
    public long adShowStartTimeStamp;
    public int adStyle;
    public AdVideoPreCacheConfig adVideoPreCacheConfig;
    public long addStartTime;
    public int contentType;
    public int defaultType;
    public long downloadDuration;
    public String extra;
    public String impAdExtra;
    public long llsid;
    public long loadDataTime;
    public int loadType;
    public SceneImpl mAdScene;
    public long mBidEcpm;
    public boolean mClickOpenAppStore;
    public long mCurPlayTime;
    public String mDataCacheTraceElement;
    public String mDataLoadTraceElement;
    public volatile transient boolean mHasAdShow;
    public int mInitVoiceStatus;
    public boolean mInstallApkFormUser;
    public boolean mInstallApkFromSDK;
    public String mOriginJString;
    public PageInfo mPageInfo;
    public int mPhotoResponseType;
    public volatile transient boolean mPvReported;
    public transient boolean mTrackUrlReported;
    public boolean notNetworkRequest;
    public long posId;
    public int realShowType;
    public long requestStartTime;
    public long showStartTime;
    public long showTime;
    public int splashAdLoadType;
    public int subType;

    @Nullable
    public TKAdLiveShopItemInfo tkLiveShopItemInfo;
    public int type;
    public List<AdInfo> adInfoList = new ArrayList();
    public PhotoInfo photoInfo = createPhotoInfo();
    public int positionShow = -1;
    public transient int adxResult = -1;
    private int serverPosition = -1;
    public boolean mIsFromContent = false;
    public boolean hasEnterAdWebViewLandPageActivity = false;
    public boolean mHasReportVideoLoad = false;
    public String mUniqueId = "";
    public boolean mHasSelected = false;
    public transient int downloadSource = 2;
    public transient String installFrom = "";
    public int mMediaPlayerType = 0;
    public VideoPlayerStatus mVideoPlayerStatus = new VideoPlayerStatus();
    public long mOutClickTimeParam = -1;
    public volatile long mVisibleTimeParam = -1;
    public int mIsLeftSlipStatus = 0;
    public boolean interactLandingPageShowing = false;
    public boolean mIsForceJumpLandingPage = false;
    public boolean mAdWebVideoPageShowing = false;
    public boolean mIsAudioEnable = false;
    public boolean mRewardVerifyCalled = false;
    public boolean mCheatingFlow = false;
    public boolean mXiaomiAppStoreDetailViewOpen = false;
    public boolean isWebViewDownload = false;
    public boolean watched = false;
    public int swipeAngle = 0;
    public boolean converted = false;
    public boolean fromCache = false;
    protected transient Map<String, Object> mLocalParams = new HashMap();

    @NonNull
    public AdStatusInfo mAdStatusInfo = new AdStatusInfo();
    public boolean isNativeRewardPreview = false;
    public int downLoadType = 3;

    @Nullable
    public <T> T getLocalParams(String str) {
        T t5;
        if (TextUtils.isEmpty(str) || (t5 = (T) this.mLocalParams.get(str)) == null) {
            return null;
        }
        return t5;
    }

    public AdResultData createAdResultData() {
        AdResultData adResultData = new AdResultData();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this);
        adResultData.setAdTemplateList(arrayList);
        return adResultData;
    }

    protected PhotoInfo createPhotoInfo() {
        return new PhotoInfo();
    }

    public boolean equals(@Nullable Object obj) {
        return obj instanceof AdTemplate ? this.mUniqueId.equals(((AdTemplate) obj).mUniqueId) : super.equals(obj);
    }

    public long getDownloadFinishTime() {
        return this.mAdStatusInfo.getDownloadFinishTime();
    }

    public long getDownloadSize() {
        return this.mAdStatusInfo.getDownloadSize();
    }

    public int getDownloadStatus() {
        return this.mAdStatusInfo.getDownloadStatus();
    }

    public int getDownloadType() {
        return this.mAdStatusInfo.getDownloadType();
    }

    public long getLoadDataTime() {
        return this.mAdStatusInfo.getLoadDataTime();
    }

    public int getServerPosition() {
        int i6 = this.serverPosition;
        return i6 != -1 ? i6 : getShowPosition();
    }

    public int getShowPosition() {
        return this.positionShow;
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    public long getmCurPlayTime() {
        return this.mCurPlayTime;
    }

    public int hashCode() {
        String str = this.mUniqueId;
        return str != null ? str.hashCode() : super.hashCode();
    }

    public boolean isCheatingFlow() {
        return this.mCheatingFlow;
    }

    public boolean isLoadFromCache() {
        return this.mAdStatusInfo.isLoadFromCache();
    }

    public void setCheatingFlow(boolean z5) {
        if (this.mCheatingFlow) {
            return;
        }
        this.mCheatingFlow = z5;
    }

    public void setDownloadFinishTime(long j6) {
        this.mAdStatusInfo.setDownloadFinishTime(j6);
    }

    public void setDownloadSize(long j6) {
        this.mAdStatusInfo.setDownloadSize(j6);
    }

    public void setDownloadStatus(int i6) {
        this.mAdStatusInfo.setDownloadStatus(i6);
    }

    public void setDownloadType(int i6) {
        this.mAdStatusInfo.setDownloadType(i6);
    }

    public void setLoadDataTime(long j6) {
        this.mAdStatusInfo.setLoadDataTime(j6);
    }

    public void setLoadFromCache(boolean z5) {
        this.mAdStatusInfo.setLoadFromCache(z5);
    }

    protected void setPhotoInfo(PhotoInfo photoInfo) {
        this.photoInfo = photoInfo;
    }

    public void setServerPosition(int i6) {
        if (this.serverPosition == -1) {
            this.serverPosition = i6;
        }
    }

    public void setShowPosition(int i6) {
        this.positionShow = i6;
    }

    public void setmCurPlayTime(long j6) {
        this.mCurPlayTime = j6;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject != null) {
            if (TextUtils.isEmpty(this.mOriginJString)) {
                this.mOriginJString = jSONObject.toString();
            }
            PhotoInfo createPhotoInfo = createPhotoInfo();
            createPhotoInfo.parseJson(jSONObject.optJSONObject("photoInfo"));
            setPhotoInfo(createPhotoInfo);
        }
        this.realShowType = this.contentType;
        if (TextUtils.isEmpty(this.mUniqueId)) {
            this.mUniqueId = String.valueOf(UUID.randomUUID());
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        aa.a(jSONObject, "photoInfo", this.photoInfo);
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void beforeToJson(JSONObject jSONObject) {
        super.beforeToJson(jSONObject);
        if (!TextUtils.isEmpty(this.mOriginJString)) {
            try {
                ab.merge(jSONObject, new JSONObject(this.mOriginJString));
            } catch (JSONException e6) {
                c.printStackTraceOnly(e6);
            }
        }
    }

    public Map<String, Object> getLocalParams() {
        return this.mLocalParams;
    }

    @Nullable
    public Object putLocalParams(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mLocalParams.put(str, obj);
    }
}
