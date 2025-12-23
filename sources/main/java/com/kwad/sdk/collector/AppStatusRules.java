package com.kwad.sdk.collector;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.aa;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class AppStatusRules extends BaseResultData implements com.kwad.sdk.core.b {
    public static final long DEFAULT_GRANULARITY = 60000;
    public static final long DEFAULT_START_TIME = 86400000;
    public static String SUFFIX_ALL_CHILDREN = "/*";
    public static String SUFFIX_ALL_FILE = "*";
    private static final long serialVersionUID = 3026909056348431027L;
    private AppStatusInfo data = new AppStatusInfo(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.collector.AppStatusRules$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class AppStatusInfo implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -2403646317801179050L;
        private ArrayList<Strategy> namedStrategy;
        private Strategy strategy;
        private ArrayList<com.kwad.sdk.collector.model.d> target;
        private UploadConfig uploadConfig;
        private ArrayList<com.kwad.sdk.collector.model.d> uploadTarget;

        private AppStatusInfo() {
            this.strategy = new Strategy();
            this.target = new ArrayList<>();
            this.namedStrategy = new ArrayList<>();
            this.uploadTarget = new ArrayList<>();
            this.uploadConfig = new UploadConfig();
        }

        private void duplicateTarget() {
            Set<String> targetPackages = this.strategy.getTargetPackages();
            HashSet hashSet = new HashSet();
            Iterator<Strategy> it = this.namedStrategy.iterator();
            while (it.hasNext()) {
                hashSet.addAll(it.next().getTargetPackages());
            }
            targetPackages.retainAll(hashSet);
            this.strategy.removeTargetsByPackage(targetPackages);
        }

        public Strategy getStrategy() {
            return this.strategy;
        }

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                if (jSONObject.has("namedStrategy")) {
                    this.namedStrategy = Strategy.createFromJSONArray(jSONObject.getJSONArray("namedStrategy"));
                }
                if (jSONObject.has("uploadTarget")) {
                    this.uploadTarget = com.kwad.sdk.collector.model.c.d(jSONObject.optJSONArray("uploadTarget"));
                }
                if (jSONObject.has("uploadConfig")) {
                    this.uploadConfig.parseJson(jSONObject.optJSONObject("uploadConfig"));
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("strategy");
                JSONArray optJSONArray = jSONObject.optJSONArray("target");
                this.strategy.parseJson(optJSONObject);
                ArrayList<com.kwad.sdk.collector.model.d> d6 = com.kwad.sdk.collector.model.c.d(optJSONArray);
                this.target = d6;
                this.strategy.setTarget(d6);
                duplicateTarget();
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.a(jSONObject, "strategy", this.strategy);
            aa.putValue(jSONObject, "target", this.target);
            aa.putValue(jSONObject, "namedStrategy", this.namedStrategy);
            aa.putValue(jSONObject, "uploadTarget", this.uploadTarget);
            aa.a(jSONObject, "uploadConfig", this.uploadConfig);
            return jSONObject;
        }

        /* synthetic */ AppStatusInfo(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Strategy implements com.kwad.sdk.core.b, Serializable {
        public static Strategy LOCAL_DEFAULT = null;
        private static final long serialVersionUID = -1387498537762043285L;
        private long minLaunchInterval;
        private long scanInterval;
        private long startTime = 86400000;
        private long historyGranularity = 60000;
        private String name = null;
        private HashMap<String, com.kwad.sdk.collector.model.d> targetMap = new HashMap<>();
        private boolean needLaunch = true;
        private long needSaveLaunchTime = -1;

        static {
            Strategy strategy = new Strategy();
            LOCAL_DEFAULT = strategy;
            strategy.setStartTime(86400000L);
            LOCAL_DEFAULT.setHistoryGranularity(60000L);
        }

        public static ArrayList<Strategy> createFromJSONArray(JSONArray jSONArray) {
            JSONObject jSONObject;
            ArrayList<Strategy> arrayList = new ArrayList<>();
            if (jSONArray != null && jSONArray.length() != 0) {
                int length = jSONArray.length();
                for (int i6 = 0; i6 < length; i6++) {
                    try {
                        jSONObject = jSONArray.getJSONObject(i6);
                    } catch (JSONException unused) {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        Strategy strategy = new Strategy();
                        strategy.parseJson(jSONObject);
                        arrayList.add(strategy);
                    }
                }
            }
            return arrayList;
        }

        public long getHistoryGranularity() {
            return this.historyGranularity;
        }

        public long getMinLaunchIntervalWithMS() {
            return this.minLaunchInterval * 1000;
        }

        public String getName() {
            return this.name;
        }

        public long getNeedSaveLaunchTime() {
            return this.needSaveLaunchTime;
        }

        public long getScanInterval() {
            return this.scanInterval;
        }

        public long getStartTimeWithMS() {
            return this.startTime * 1000;
        }

        public ArrayList<com.kwad.sdk.collector.model.d> getTarget() {
            return new ArrayList<>(this.targetMap.values());
        }

        public Set<String> getTargetPackages() {
            Collection<com.kwad.sdk.collector.model.d> values = this.targetMap.values();
            HashSet hashSet = new HashSet();
            Iterator<com.kwad.sdk.collector.model.d> it = values.iterator();
            while (it.hasNext()) {
                hashSet.add(com.kwad.sdk.collector.model.c.a(it.next()));
            }
            return hashSet;
        }

        public boolean isNeedLaunch() {
            return this.needLaunch;
        }

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                this.startTime = jSONObject.optLong(AnalyticsConfig.RTD_START_TIME);
                this.scanInterval = jSONObject.optLong("scanInterval");
                if (jSONObject.optInt("historyGranularity") > 0) {
                    this.historyGranularity = r0 * 1000;
                }
                this.name = jSONObject.optString(CommonNetImpl.NAME);
                this.minLaunchInterval = jSONObject.optLong("minLaunchInterval");
                this.needSaveLaunchTime = jSONObject.optLong("needSaveLaunchTime");
                this.needLaunch = jSONObject.optBoolean("needLaunch");
                setTarget(com.kwad.sdk.collector.model.c.d(jSONObject.optJSONArray("target")));
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }

        public void setHistoryGranularity(long j6) {
            this.historyGranularity = j6;
        }

        public void setNeedLaunch(boolean z5) {
            this.needLaunch = z5;
        }

        public void setNeedSaveLaunchTime(long j6) {
            this.needSaveLaunchTime = j6;
        }

        public void setScanInterval(long j6) {
            this.scanInterval = j6;
        }

        public void setStartTime(long j6) {
            this.startTime = j6;
        }

        public void setTarget(ArrayList<com.kwad.sdk.collector.model.d> arrayList) {
            if (arrayList == null) {
                this.targetMap.clear();
                return;
            }
            Iterator<com.kwad.sdk.collector.model.d> it = arrayList.iterator();
            while (it.hasNext()) {
                com.kwad.sdk.collector.model.d next = it.next();
                this.targetMap.put(com.kwad.sdk.collector.model.c.a(next), next);
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, AnalyticsConfig.RTD_START_TIME, this.startTime);
            aa.putValue(jSONObject, "scanInterval", this.scanInterval);
            aa.putValue(jSONObject, "historyGranularity", this.historyGranularity / 1000);
            aa.putValue(jSONObject, CommonNetImpl.NAME, this.name);
            aa.putValue(jSONObject, "target", getTarget());
            aa.putValue(jSONObject, "minLaunchInterval", this.minLaunchInterval);
            aa.putValue(jSONObject, "needSaveLaunchTime", this.needSaveLaunchTime);
            aa.putValue(jSONObject, "needLaunch", this.needLaunch);
            return jSONObject;
        }

        public void removeTargetsByPackage(Collection<String> collection) {
            Iterator<String> it = collection.iterator();
            while (it.hasNext()) {
                this.targetMap.remove(it.next());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class UploadConfig extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        public static final int DEFAULT_FILE_MAX_SIZE = 102400;
        private static final long serialVersionUID = 8541150615721258815L;
        public long fileMaxSize = 102400;

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject != null) {
                this.fileMaxSize = jSONObject.optLong("fileMaxSize");
            }
            super.afterParseJson(jSONObject);
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "fileMaxSize", this.fileMaxSize);
            return jSONObject;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            if (this.fileMaxSize < 0) {
                this.fileMaxSize = 102400L;
            }
        }
    }

    public static boolean isAppStatusTargetNotEmpty(AppStatusRules appStatusRules) {
        if (appStatusRules == null) {
            return false;
        }
        boolean targetNotEmpty = appStatusRules.targetNotEmpty();
        List<Strategy> obtainNamedStrategyList = appStatusRules.obtainNamedStrategyList();
        return targetNotEmpty || (obtainNamedStrategyList != null && obtainNamedStrategyList.size() > 0);
    }

    public static boolean isUploadTargetNotEmpty(AppStatusRules appStatusRules) {
        List<com.kwad.sdk.collector.model.d> uploadTargets;
        return (appStatusRules == null || (uploadTargets = appStatusRules.getUploadTargets()) == null || uploadTargets.size() <= 0) ? false : true;
    }

    @NonNull
    public static AppStatusRules createFromJson(String str) {
        AppStatusRules appStatusRules = new AppStatusRules();
        if (TextUtils.isEmpty(str)) {
            return appStatusRules;
        }
        try {
            appStatusRules.parseJson(new JSONObject(str));
            return appStatusRules;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            return appStatusRules;
        }
    }

    public ArrayList<Strategy> getAllStrategy() {
        ArrayList<Strategy> arrayList = new ArrayList<>();
        if (this.data.strategy != null) {
            arrayList.add(this.data.strategy);
        }
        if (this.data.namedStrategy != null) {
            arrayList.addAll(this.data.namedStrategy);
        }
        return arrayList;
    }

    @Nullable
    public List<com.kwad.sdk.collector.model.d> getUploadTargets() {
        AppStatusInfo appStatusInfo = this.data;
        if (appStatusInfo == null) {
            return null;
        }
        return appStatusInfo.uploadTarget;
    }

    public long obtainDefaultScanInterval() {
        AppStatusInfo appStatusInfo = this.data;
        if (appStatusInfo == null || appStatusInfo.getStrategy() == null) {
            return 0L;
        }
        long scanInterval = this.data.getStrategy().getScanInterval();
        return (scanInterval >= 0 ? scanInterval : 0L) * 1000;
    }

    public Strategy obtainDefaultStrategy() {
        AppStatusInfo appStatusInfo = this.data;
        if (appStatusInfo == null) {
            return null;
        }
        return appStatusInfo.strategy;
    }

    public List<Strategy> obtainNamedStrategyList() {
        AppStatusInfo appStatusInfo = this.data;
        if (appStatusInfo == null) {
            return null;
        }
        return appStatusInfo.namedStrategy;
    }

    public long obtainUploadConfigFileMaxSize() {
        AppStatusInfo appStatusInfo = this.data;
        if (appStatusInfo == null || appStatusInfo.uploadConfig == null) {
            return 102400L;
        }
        return this.data.uploadConfig.fileMaxSize;
    }

    public boolean targetNotEmpty() {
        AppStatusInfo appStatusInfo = this.data;
        return (appStatusInfo == null || appStatusInfo.target == null || this.data.target.size() <= 0) ? false : true;
    }

    public void initStatus(Context context) {
        Iterator<Strategy> it = getAllStrategy().iterator();
        while (it.hasNext()) {
            Strategy next = it.next();
            next.setNeedLaunch(i.a(context, next));
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.data.parseJson(new JSONObject(com.kwad.sdk.core.a.d.getResponseData(jSONObject.optString("data"))));
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        aa.a(json, "data", this.data);
        return json;
    }
}
