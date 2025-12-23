package com.bykv.vk.component.ttvideo.mediakit.downloader;

import com.bytedance.sdk.component.xt.j.av;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class AVMDLRequest {
    public static final int UrlStateIsForbidden = 1;
    public static final int UrlStateIsNormal = 0;
    public HashMap<String, String> headers;
    public int mCurlUrlIndex;
    public int mMaxTryCout;
    public int mOpenTimeOut;
    public int mRWTimeOut;
    public int[] mUrlErrCount;
    public int[] mUrlState;
    public long reqOff;
    public av response;
    public long size;
    public String[] urls;

    public AVMDLRequest() {
        this.urls = null;
        this.headers = new HashMap<>();
        this.reqOff = -1L;
        this.size = 0L;
        this.response = null;
        this.mCurlUrlIndex = 0;
        this.mMaxTryCout = 0;
        this.mOpenTimeOut = 10;
        this.mRWTimeOut = 10;
    }

    public AVMDLRequest(long j6, long j7, String[] strArr, Object obj, int i6, int i7, int i8) {
        this.urls = strArr;
        this.headers = (HashMap) obj;
        this.reqOff = j6;
        this.size = j7;
        this.response = null;
        this.mUrlState = null;
        this.mCurlUrlIndex = 0;
        this.mMaxTryCout = i6;
        this.mOpenTimeOut = i7;
        this.mRWTimeOut = i8;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.mUrlState = new int[strArr.length];
        int i9 = 0;
        while (true) {
            int[] iArr = this.mUrlState;
            if (i9 >= iArr.length) {
                break;
            }
            iArr[i9] = 0;
            i9++;
        }
        this.mUrlErrCount = new int[this.urls.length];
        int i10 = 0;
        while (true) {
            int[] iArr2 = this.mUrlErrCount;
            if (i10 >= iArr2.length) {
                return;
            }
            iArr2[i10] = 0;
            i10++;
        }
    }

    public AVMDLRequest(long j6, long j7, String[] strArr, HashMap<String, String> hashMap) {
        this.urls = strArr;
        this.headers = hashMap;
        this.reqOff = j6;
        this.size = j7;
        this.response = null;
        this.mUrlState = null;
        this.mCurlUrlIndex = 0;
        this.mMaxTryCout = 0;
        this.mOpenTimeOut = 10;
        this.mRWTimeOut = 10;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.mUrlState = new int[strArr.length];
        int i6 = 0;
        while (true) {
            int[] iArr = this.mUrlState;
            if (i6 >= iArr.length) {
                return;
            }
            iArr[i6] = 0;
            i6++;
        }
    }
}
