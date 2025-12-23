package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.aa;
import com.snail.antifake.deviceid.e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class MemoryInfo implements b, Serializable {
    private static final long serialVersionUID = -4944913077323984734L;
    public int mAvailableMB;
    public int mFdCount;
    public int mJavaHeapLimitMB;
    public int mJavaHeapMB;
    public int mPssMB;
    public int mRssMB;
    public int mThreadsCount;
    public int mTotalMB;
    public int mVssMB;
    public List<String> mFds = new ArrayList();
    public List<ThreadInfo> mJavaThreads = new ArrayList();
    public List<ThreadInfo> mNativeThreads = new ArrayList();
    public List<ThreadInfo> mAllThreads = new ArrayList();

    public MemoryInfo() {
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mTotalMB = jSONObject.optInt("mTotalMB");
        this.mAvailableMB = jSONObject.optInt("mAvailableMB");
        this.mJavaHeapLimitMB = jSONObject.optInt("mJavaHeapLimitMB");
        this.mJavaHeapMB = jSONObject.optInt("mJavaHeapMB");
        this.mVssMB = jSONObject.optInt("mVssMB");
        this.mRssMB = jSONObject.optInt("mRssMB");
        this.mPssMB = jSONObject.optInt("mPssMB");
        this.mThreadsCount = jSONObject.optInt("mThreadsCount");
        this.mFdCount = jSONObject.optInt("mFdCount");
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("mFds");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    String optString = optJSONArray.optString(i6);
                    if (optString != null && !optString.isEmpty()) {
                        this.mFds.add(optString);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("mJavaThreads");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                    JSONObject optJSONObject = optJSONArray2.optJSONObject(i7);
                    if (optJSONObject != null) {
                        ThreadInfo threadInfo = new ThreadInfo();
                        threadInfo.parseJson(optJSONObject);
                        this.mJavaThreads.add(threadInfo);
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("mNativeThreads");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                for (int i8 = 0; i8 < optJSONArray3.length(); i8++) {
                    JSONObject optJSONObject2 = optJSONArray3.optJSONObject(i8);
                    if (optJSONObject2 != null) {
                        ThreadInfo threadInfo2 = new ThreadInfo();
                        threadInfo2.parseJson(optJSONObject2);
                        this.mNativeThreads.add(threadInfo2);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("mAllThreads");
            if (optJSONArray4 == null || optJSONArray4.length() <= 0) {
                return;
            }
            for (int i9 = 0; i9 < optJSONArray4.length(); i9++) {
                JSONObject optJSONObject3 = optJSONArray4.optJSONObject(i9);
                if (optJSONObject3 != null) {
                    ThreadInfo threadInfo3 = new ThreadInfo();
                    threadInfo3.parseJson(optJSONObject3);
                    this.mAllThreads.add(threadInfo3);
                }
            }
        } catch (Exception e6) {
            c.printStackTraceOnly(e6);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "mTotalMB", this.mTotalMB);
        aa.putValue(jSONObject, "mAvailableMB", this.mAvailableMB);
        aa.putValue(jSONObject, "mJavaHeapLimitMB", this.mJavaHeapLimitMB);
        aa.putValue(jSONObject, "mJavaHeapMB", this.mJavaHeapMB);
        aa.putValue(jSONObject, "mVssMB", this.mVssMB);
        aa.putValue(jSONObject, "mRssMB", this.mRssMB);
        aa.putValue(jSONObject, "mPssMB", this.mPssMB);
        aa.putValue(jSONObject, "mThreadsCount", this.mThreadsCount);
        aa.putValue(jSONObject, "mFdCount", this.mFdCount);
        aa.putValue(jSONObject, "mFds", this.mFds);
        aa.putValue(jSONObject, "mJavaThreads", this.mJavaThreads);
        aa.putValue(jSONObject, "mNativeThreads", this.mNativeThreads);
        aa.putValue(jSONObject, "mAllThreads", this.mAllThreads);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t总RAM容量: ");
        sb.append(this.mTotalMB);
        sb.append(" (MB)\n\t剩余RAM容量: ");
        sb.append(this.mAvailableMB);
        sb.append(" (MB)\n\t本进程Java堆上限: ");
        sb.append(this.mJavaHeapLimitMB);
        sb.append(" (MB)\n\t本进程Java堆已使用: ");
        sb.append(this.mJavaHeapMB);
        sb.append(" (MB)\n\t虚拟地址空间已使用Vss: ");
        sb.append(this.mVssMB);
        sb.append(" (MB)\n\t实际空间使用量(包含共享库) Rss: ");
        sb.append(this.mRssMB);
        sb.append(" (MB)\n\t实际空间使用量(共享库已经均摊)(高内存杀进程的依据）Pss: ");
        sb.append(this.mPssMB);
        sb.append(" (MB)\n\t打开文件描述符数: ");
        sb.append(this.mFdCount);
        sb.append(e.f37542d);
        if (this.mFds.size() > 0) {
            sb.append("\t文件描述符详情: \n");
            for (String str : this.mFds) {
                sb.append("\t");
                sb.append(str);
                sb.append(e.f37542d);
            }
        }
        sb.append("\t正在运行线程数: ");
        sb.append(this.mThreadsCount);
        sb.append("\tJava: ");
        sb.append(this.mJavaThreads.size());
        sb.append("\tNative: ");
        sb.append(this.mThreadsCount - this.mJavaThreads.size());
        sb.append("\n\n");
        if (this.mAllThreads.size() > 0) {
            sb.append("\t全部线程名: \n");
            for (ThreadInfo threadInfo : this.mAllThreads) {
                sb.append("\t");
                sb.append(threadInfo.mName);
                sb.append(e.f37542d);
            }
        }
        if (this.mJavaThreads.size() > 0) {
            sb.append("Java线程堆栈: \n");
            for (ThreadInfo threadInfo2 : this.mJavaThreads) {
                sb.append(threadInfo2.mName);
                sb.append(e.f37542d);
                sb.append(threadInfo2.mTrace.replace("#", e.f37542d));
                sb.append(e.f37542d);
            }
        }
        if (this.mNativeThreads.size() > 0) {
            sb.append("\tNative线程堆栈: \n");
            for (ThreadInfo threadInfo3 : this.mNativeThreads) {
                sb.append("\t");
                sb.append(threadInfo3.mName);
                sb.append("\t(tid=");
                sb.append(threadInfo3.mTid);
                sb.append(", index=");
                sb.append(threadInfo3.mIndex);
                sb.append("):\n");
                sb.append(threadInfo3.mTrace);
            }
        }
        return sb.substring(0);
    }

    public MemoryInfo(String str) {
        try {
            if (TextUtils.isEmpty(str) || "Unknown".equals(str)) {
                return;
            }
            parseJson(new JSONObject(str));
        } catch (JSONException e6) {
            c.printStackTraceOnly(e6);
        }
    }
}
