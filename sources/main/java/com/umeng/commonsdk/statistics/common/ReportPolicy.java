package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.Defcon;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ReportPolicy {
    public static final int BATCH_AT_LAUNCH = 1;
    static final int BATCH_AT_TERMINATE = 2;
    public static final int BATCH_BY_INTERVAL = 6;
    public static final int DAILY = 4;
    static final int IMMEDIATE = 3;
    public static final int QUASI_REALTIME_POLICY = 11;
    public static final int REALTIME = 0;
    public static final int SMART_POLICY = 8;
    public static final int WIFIONLY = 5;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class DefconPolicy extends ReportStrategy {
        private Defcon defcon;
        private StatTracer tracer;

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean isValid() {
            return this.defcon.isOpen();
        }

        public DefconPolicy(StatTracer statTracer, Defcon defcon) {
            this.tracer = statTracer;
            this.defcon = defcon;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z5) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - UMEnvelopeBuild.getLastSuccessfulBuildTime(UMModuleRegister.getAppContext()) >= this.defcon.getReqInterval()) {
                return true;
            }
            return false;
        }

        public boolean shouldSendMessageByInstant() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - UMEnvelopeBuild.getLastInstantBuildTime(UMModuleRegister.getAppContext()) >= this.defcon.getReqInterval()) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ReportByInterval extends ReportStrategy {
        private static long MAX_REPORT_INTERVAL = 86400000;
        private static long MIN_REPORT_INTERVAL = 90000;
        private long mReportInterval;
        private StatTracer mTracer;

        public static boolean isValidValue(int i6) {
            return ((long) i6) >= MIN_REPORT_INTERVAL;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z5) {
            return z5 || System.currentTimeMillis() - UMEnvelopeBuild.getLastSuccessfulBuildTime(UMModuleRegister.getAppContext()) >= this.mReportInterval;
        }

        public long getReportInterval() {
            return this.mReportInterval;
        }

        public void setReportInterval(long j6) {
            long j7 = MIN_REPORT_INTERVAL;
            if (j6 < j7 || j6 > MAX_REPORT_INTERVAL) {
                this.mReportInterval = j7;
            } else {
                this.mReportInterval = j6;
            }
        }

        public ReportByInterval(StatTracer statTracer, long j6) {
            this.mTracer = statTracer;
            setReportInterval(j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ReportQuasiRealtime extends ReportStrategy {
        private static long DEFAULT_REPORT_INTERVAL = 15000;
        private static long MAX_REPORT_INTERVAL = 90000;
        private static long MIN_REPORT_INTERVAL = 3000;
        private long mReportInterval;

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z5) {
            return true;
        }

        public long getReportInterval() {
            return this.mReportInterval;
        }

        public void setReportInterval(long j6) {
            if (j6 < MIN_REPORT_INTERVAL || j6 > MAX_REPORT_INTERVAL) {
                this.mReportInterval = DEFAULT_REPORT_INTERVAL;
            } else {
                this.mReportInterval = j6;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ReportRealtime extends ReportStrategy {
        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z5) {
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ReportStrategy {
        public boolean isValid() {
            return true;
        }

        public boolean shouldSendMessage(boolean z5) {
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ReportWifiOnly extends ReportStrategy {
        private Context mContext;

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z5) {
            return DeviceConfig.isWiFiAvailable(this.mContext);
        }

        public ReportWifiOnly(Context context) {
            this.mContext = context;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class DebugPolicy extends ReportStrategy {
        private final long ReportInterval = 15000;
        private StatTracer mTracer;

        public DebugPolicy(StatTracer statTracer) {
            this.mTracer = statTracer;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z5) {
            if (System.currentTimeMillis() - UMEnvelopeBuild.getLastSuccessfulBuildTime(UMModuleRegister.getAppContext()) >= 15000) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class LatentPolicy extends ReportStrategy {
        private long latency;
        private long start;

        public LatentPolicy(int i6) {
            this.start = 0L;
            this.latency = i6;
            this.start = System.currentTimeMillis();
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean isValid() {
            if (System.currentTimeMillis() - this.start < this.latency) {
                return true;
            }
            return false;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z5) {
            if (System.currentTimeMillis() - this.start >= this.latency) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ReportDaily extends ReportStrategy {
        private long HOURS_DAY = 86400000;
        private StatTracer mTracer;

        public ReportDaily(StatTracer statTracer) {
            this.mTracer = statTracer;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z5) {
            if (System.currentTimeMillis() - UMEnvelopeBuild.getLastSuccessfulBuildTime(UMModuleRegister.getAppContext()) >= this.HOURS_DAY) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class SmartPolicy extends ReportStrategy {
        private final long ReportInterval = 10800000;
        private StatTracer mTracer;

        public SmartPolicy(StatTracer statTracer) {
            this.mTracer = statTracer;
        }

        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z5) {
            if (System.currentTimeMillis() - UMEnvelopeBuild.getLastSuccessfulBuildTime(UMModuleRegister.getAppContext()) >= 10800000) {
                return true;
            }
            return false;
        }
    }

    public static boolean isValid(int i6) {
        if (i6 == 8 || i6 == 11) {
            return true;
        }
        switch (i6) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            default:
                return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ReportAtLaunch extends ReportStrategy {
        @Override // com.umeng.commonsdk.statistics.common.ReportPolicy.ReportStrategy
        public boolean shouldSendMessage(boolean z5) {
            return z5;
        }
    }
}
