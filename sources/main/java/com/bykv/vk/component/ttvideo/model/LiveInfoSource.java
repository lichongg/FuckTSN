package com.bykv.vk.component.ttvideo.model;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class LiveInfoSource {
    public static final int INFO_SOURCE_DIRECT_URLS = 1;
    public static final int INFO_SOURCE_STREAM_DATA = 2;
    public static final int INFO_SOURCE_UNKNOWN = 0;
    private String[] mAvailableURLs;
    private int mCurrentURLIndex;
    private int mEnableSR = 0;
    private LiveURL[] mPlayURLs;
    private int mSourceType;
    private LiveStreamInfo mStreamInfo;

    public LiveURL getPlayURLByCodec(@NonNull String str) {
        LiveURL[] liveURLArr;
        if (str != null && (liveURLArr = this.mPlayURLs) != null && liveURLArr.length != 0) {
            for (LiveURL liveURL : liveURLArr) {
                if (str.equals(liveURL.getVCodec()) && liveURL.mainURL != null) {
                    return liveURL;
                }
            }
        }
        return null;
    }

    public void reset() {
        this.mCurrentURLIndex = 0;
        this.mAvailableURLs = null;
        this.mStreamInfo = null;
        this.mPlayURLs = null;
        this.mEnableSR = 0;
    }

    public boolean adjustOriginBitRate(String str, String str2, long j6) {
        LiveStreamInfo liveStreamInfo = this.mStreamInfo;
        if (liveStreamInfo == null) {
            return false;
        }
        return liveStreamInfo.adjustOriginBitRate(str, str2, j6);
    }

    public JSONObject getAbrInfo() {
        LiveStreamInfo liveStreamInfo;
        if (this.mSourceType != 2 || (liveStreamInfo = this.mStreamInfo) == null) {
            return null;
        }
        return liveStreamInfo.getAbrInfo();
    }

    public String getAvLinesParams(String str, String str2) {
        LiveStreamInfo liveStreamInfo;
        if (this.mSourceType != 2 || (liveStreamInfo = this.mStreamInfo) == null) {
            return null;
        }
        return liveStreamInfo.getAvLinesParams(str, str2);
    }

    public long getBitrate(String str, String str2) {
        LiveStreamInfo liveStreamInfo;
        if (this.mSourceType != 2 || (liveStreamInfo = this.mStreamInfo) == null) {
            return 0L;
        }
        return liveStreamInfo.getBitrate(str, str2);
    }

    public int getCheckSilenceInterval(String str, String str2) {
        LiveStreamInfo liveStreamInfo;
        if (this.mSourceType != 2 || (liveStreamInfo = this.mStreamInfo) == null) {
            return -1;
        }
        return liveStreamInfo.getCheckSilenceInterval(str, str2);
    }

    public String getDefaultResolution() {
        LiveStreamInfo liveStreamInfo;
        if (this.mSourceType == 2 && (liveStreamInfo = this.mStreamInfo) != null) {
            return liveStreamInfo.getDefaultResolution();
        }
        return null;
    }

    public Map<String, String> getHTTPHeaders() {
        LiveStreamInfo liveStreamInfo;
        if (this.mSourceType != 2 || (liveStreamInfo = this.mStreamInfo) == null) {
            return null;
        }
        return liveStreamInfo.getHTTPHeaders();
    }

    public String getLabelfromBitrate(long j6, String str) {
        LiveStreamInfo liveStreamInfo;
        if (this.mSourceType != 2 || (liveStreamInfo = this.mStreamInfo) == null) {
            return null;
        }
        return liveStreamInfo.getLabelfromBitrate(j6, str);
    }

    public String getMPDForFormat(String str, String str2, String str3, String str4) {
        LiveStreamInfo liveStreamInfo;
        if (this.mSourceType != 2 || (liveStreamInfo = this.mStreamInfo) == null) {
            return null;
        }
        return liveStreamInfo.getMPDForFormat(str, str2, str3, str4);
    }

    public String getNextURL() {
        this.mCurrentURLIndex++;
        return getPlayURL();
    }

    public LiveURL getPlayLiveURL() {
        LiveURL[] liveURLArr = this.mPlayURLs;
        if (liveURLArr != null && liveURLArr.length != 0) {
            for (LiveURL liveURL : liveURLArr) {
                if (liveURL.mainURL != null) {
                    return liveURL;
                }
            }
        }
        return null;
    }

    public String getPlayURL() {
        String[] strArr = this.mAvailableURLs;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        int i6 = this.mCurrentURLIndex;
        if (i6 >= strArr.length) {
            i6 = 0;
        }
        return strArr[i6];
    }

    public String getPlayURLForResolution(String str, String str2, String str3) {
        LiveStreamInfo liveStreamInfo;
        if (this.mSourceType != 2 || (liveStreamInfo = this.mStreamInfo) == null) {
            return null;
        }
        return liveStreamInfo.getStreamUrlForResolution(str, str2, str3);
    }

    public String getPortNum(String str, String str2, String str3) {
        LiveStreamInfo liveStreamInfo = this.mStreamInfo;
        if (liveStreamInfo == null) {
            return null;
        }
        return liveStreamInfo.getPortNum(str, str2, str3);
    }

    public String getRuleIds() {
        LiveStreamInfo liveStreamInfo;
        if (this.mSourceType != 2 || (liveStreamInfo = this.mStreamInfo) == null) {
            return null;
        }
        return liveStreamInfo.getRuleIds();
    }

    public String getSDKParams(String str, String str2) {
        LiveStreamInfo liveStreamInfo;
        if (this.mSourceType != 2 || (liveStreamInfo = this.mStreamInfo) == null) {
            return null;
        }
        return liveStreamInfo.getSDKParams(str, str2);
    }

    public boolean getSREnabled(String str, String str2) {
        LiveStreamInfo liveStreamInfo = this.mStreamInfo;
        if (liveStreamInfo == null) {
            return false;
        }
        return liveStreamInfo.getSREnabled(str, str2, this.mEnableSR);
    }

    public int getSRLongerSideUpperBound() {
        LiveStreamInfo liveStreamInfo;
        if (this.mSourceType != 2 || (liveStreamInfo = this.mStreamInfo) == null) {
            return 0;
        }
        return liveStreamInfo.getSRLongerSideUpperBound();
    }

    public int getSRShorterSideUpperBound() {
        LiveStreamInfo liveStreamInfo;
        if (this.mSourceType != 2 || (liveStreamInfo = this.mStreamInfo) == null) {
            return 0;
        }
        return liveStreamInfo.getSRShorterSideUpperBound();
    }

    public String getSessionID() {
        LiveStreamInfo liveStreamInfo;
        if (this.mSourceType != 2 || (liveStreamInfo = this.mStreamInfo) == null) {
            return null;
        }
        return liveStreamInfo.getSessionID();
    }

    public JSONObject getSharpenParams(String str, String str2) {
        LiveStreamInfo liveStreamInfo;
        if (this.mSourceType != 2 || (liveStreamInfo = this.mStreamInfo) == null) {
            return null;
        }
        return liveStreamInfo.getSharpenParams(str, str2);
    }

    public int getSourceType() {
        return this.mSourceType;
    }

    public String getSuggestFormat(String str, String str2) {
        LiveStreamInfo liveStreamInfo = this.mStreamInfo;
        if (liveStreamInfo == null) {
            return null;
        }
        return liveStreamInfo.getSuggestFormat(str, str2);
    }

    public String getSuggestProtocol(String str, String str2) {
        LiveStreamInfo liveStreamInfo = this.mStreamInfo;
        if (liveStreamInfo == null) {
            return null;
        }
        return liveStreamInfo.getSuggestProtocol(str, str2);
    }

    public String getVCodec(String str, String str2) {
        LiveStreamInfo liveStreamInfo;
        if (this.mSourceType != 2 || (liveStreamInfo = this.mStreamInfo) == null) {
            return null;
        }
        return liveStreamInfo.getVCodec(str, str2);
    }

    public boolean isABRListMatch() {
        LiveStreamInfo liveStreamInfo = this.mStreamInfo;
        if (liveStreamInfo == null) {
            return false;
        }
        return liveStreamInfo.isABRListMatch();
    }

    public boolean isCodecSame(String str) {
        LiveStreamInfo liveStreamInfo = this.mStreamInfo;
        if (liveStreamInfo == null) {
            return false;
        }
        return liveStreamInfo.isCodecSame(str);
    }

    public boolean isEnableAdaptive(String str) {
        LiveStreamInfo liveStreamInfo;
        if (this.mSourceType != 2 || (liveStreamInfo = this.mStreamInfo) == null) {
            return false;
        }
        return liveStreamInfo.isEnableAdaptive(str);
    }

    public boolean isSupportResolution(String str) {
        LiveStreamInfo liveStreamInfo;
        if (this.mSourceType != 2 || (liveStreamInfo = this.mStreamInfo) == null) {
            return false;
        }
        return liveStreamInfo.isSupport(str);
    }

    public boolean isSupportSR(int i6, int i7, float f6) {
        LiveStreamInfo liveStreamInfo;
        if (this.mSourceType != 2 || (liveStreamInfo = this.mStreamInfo) == null) {
            return false;
        }
        return liveStreamInfo.isSupportSR(i6, i7, f6);
    }

    public boolean isSupportSharpen(int i6, int i7) {
        LiveStreamInfo liveStreamInfo;
        if (this.mSourceType != 2 || (liveStreamInfo = this.mStreamInfo) == null) {
            return false;
        }
        return liveStreamInfo.isSupportSharpen(i6, i7);
    }

    public void setDefaultResolution(String str) {
        LiveStreamInfo liveStreamInfo;
        if (this.mSourceType == 2 && (liveStreamInfo = this.mStreamInfo) != null) {
            liveStreamInfo.setDefaultResolution(str);
        }
    }

    public void setEnableOriginResolution(boolean z5) {
        LiveStreamInfo liveStreamInfo = this.mStreamInfo;
        if (liveStreamInfo == null) {
            return;
        }
        liveStreamInfo.setEnableOriginResolution(z5);
    }

    public void setEnableSR(int i6) {
        this.mEnableSR = i6;
    }

    public void setPlayURLs(LiveURL[] liveURLArr) {
        this.mPlayURLs = liveURLArr;
        this.mCurrentURLIndex = 0;
        this.mSourceType = 1;
        ArrayList arrayList = new ArrayList();
        for (LiveURL liveURL : liveURLArr) {
            String str = liveURL.mainURL;
            if (str != null) {
                arrayList.add(str);
            }
            String str2 = liveURL.backupURL;
            if (str2 != null) {
                arrayList.add(str2);
            }
        }
        String[] strArr = new String[arrayList.size()];
        this.mAvailableURLs = strArr;
        arrayList.toArray(strArr);
    }

    public void setRequestParams(String str) {
        LiveStreamInfo liveStreamInfo = this.mStreamInfo;
        if (liveStreamInfo != null) {
            liveStreamInfo.setRequestParams(str);
        }
    }

    public void setRequestParamsWithDNSIp(String str, String str2, String str3) {
        LiveStreamInfo liveStreamInfo = this.mStreamInfo;
        if (liveStreamInfo != null) {
            liveStreamInfo.setRequestParamsWithDNSIp(str, str2, str3);
        }
    }

    public void setRtcFallback(int i6) {
        LiveStreamInfo liveStreamInfo = this.mStreamInfo;
        if (liveStreamInfo != null) {
            liveStreamInfo.setRtcFallback(i6);
        }
    }

    public void setSourceType(int i6) {
        this.mSourceType = i6;
    }

    public void setStreamInfo(LiveStreamInfo liveStreamInfo) {
        this.mStreamInfo = liveStreamInfo;
        this.mCurrentURLIndex = 0;
        this.mSourceType = 2;
    }

    public boolean setStreamInfoFlag(int i6) {
        LiveStreamInfo liveStreamInfo = this.mStreamInfo;
        if (liveStreamInfo == null) {
            return false;
        }
        return liveStreamInfo.setFlag(i6);
    }

    public void setTransportProtocol(String str, String str2) {
        LiveStreamInfo liveStreamInfo = this.mStreamInfo;
        if (liveStreamInfo != null) {
            liveStreamInfo.setTransportProtocol(str, str2);
        }
    }
}
