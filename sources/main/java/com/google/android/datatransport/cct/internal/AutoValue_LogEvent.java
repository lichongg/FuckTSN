package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.LogEvent;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final class AutoValue_LogEvent extends LogEvent {
    private final Integer eventCode;
    private final long eventTimeMs;
    private final long eventUptimeMs;
    private final NetworkConnectionInfo networkConnectionInfo;
    private final byte[] sourceExtension;
    private final String sourceExtensionJsonProto3;
    private final long timezoneOffsetSeconds;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.android.datatransport.cct.internal.AutoValue_LogEvent$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class Builder extends LogEvent.Builder {
        private Integer eventCode;
        private Long eventTimeMs;
        private Long eventUptimeMs;
        private NetworkConnectionInfo networkConnectionInfo;
        private byte[] sourceExtension;
        private String sourceExtensionJsonProto3;
        private Long timezoneOffsetSeconds;

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent build() {
            String str = "";
            if (this.eventTimeMs == null) {
                str = " eventTimeMs";
            }
            if (this.eventUptimeMs == null) {
                str = str + " eventUptimeMs";
            }
            if (this.timezoneOffsetSeconds == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new AutoValue_LogEvent(this.eventTimeMs.longValue(), this.eventCode, this.eventUptimeMs.longValue(), this.sourceExtension, this.sourceExtensionJsonProto3, this.timezoneOffsetSeconds.longValue(), this.networkConnectionInfo, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder setEventCode(@Nullable Integer num) {
            this.eventCode = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder setNetworkConnectionInfo(@Nullable NetworkConnectionInfo networkConnectionInfo) {
            this.networkConnectionInfo = networkConnectionInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        LogEvent.Builder setSourceExtension(@Nullable byte[] bArr) {
            this.sourceExtension = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        LogEvent.Builder setSourceExtensionJsonProto3(@Nullable String str) {
            this.sourceExtensionJsonProto3 = str;
            return this;
        }

        Builder() {
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder setEventTimeMs(long j6) {
            this.eventTimeMs = Long.valueOf(j6);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder setEventUptimeMs(long j6) {
            this.eventUptimeMs = Long.valueOf(j6);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder setTimezoneOffsetSeconds(long j6) {
            this.timezoneOffsetSeconds = Long.valueOf(j6);
            return this;
        }
    }

    /* synthetic */ AutoValue_LogEvent(long j6, Integer num, long j7, byte[] bArr, String str, long j8, NetworkConnectionInfo networkConnectionInfo, AnonymousClass1 anonymousClass1) {
        this(j6, num, j7, bArr, str, j8, networkConnectionInfo);
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        NetworkConnectionInfo networkConnectionInfo;
        if (obj == this) {
            return true;
        }
        if (obj instanceof LogEvent) {
            LogEvent logEvent = (LogEvent) obj;
            if (this.eventTimeMs == logEvent.getEventTimeMs() && ((num = this.eventCode) != null ? num.equals(logEvent.getEventCode()) : logEvent.getEventCode() == null) && this.eventUptimeMs == logEvent.getEventUptimeMs()) {
                if (Arrays.equals(this.sourceExtension, logEvent instanceof AutoValue_LogEvent ? ((AutoValue_LogEvent) logEvent).sourceExtension : logEvent.getSourceExtension()) && ((str = this.sourceExtensionJsonProto3) != null ? str.equals(logEvent.getSourceExtensionJsonProto3()) : logEvent.getSourceExtensionJsonProto3() == null) && this.timezoneOffsetSeconds == logEvent.getTimezoneOffsetSeconds() && ((networkConnectionInfo = this.networkConnectionInfo) != null ? networkConnectionInfo.equals(logEvent.getNetworkConnectionInfo()) : logEvent.getNetworkConnectionInfo() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    private AutoValue_LogEvent(long j6, @Nullable Integer num, long j7, @Nullable byte[] bArr, @Nullable String str, long j8, @Nullable NetworkConnectionInfo networkConnectionInfo) {
        this.eventTimeMs = j6;
        this.eventCode = num;
        this.eventUptimeMs = j7;
        this.sourceExtension = bArr;
        this.sourceExtensionJsonProto3 = str;
        this.timezoneOffsetSeconds = j8;
        this.networkConnectionInfo = networkConnectionInfo;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    @Nullable
    public Integer getEventCode() {
        return this.eventCode;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public long getEventTimeMs() {
        return this.eventTimeMs;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public long getEventUptimeMs() {
        return this.eventUptimeMs;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    @Nullable
    public NetworkConnectionInfo getNetworkConnectionInfo() {
        return this.networkConnectionInfo;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    @Nullable
    public byte[] getSourceExtension() {
        return this.sourceExtension;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    @Nullable
    public String getSourceExtensionJsonProto3() {
        return this.sourceExtensionJsonProto3;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public long getTimezoneOffsetSeconds() {
        return this.timezoneOffsetSeconds;
    }

    public int hashCode() {
        long j6 = this.eventTimeMs;
        int i6 = (((int) (j6 ^ (j6 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.eventCode;
        int hashCode = num == null ? 0 : num.hashCode();
        long j7 = this.eventUptimeMs;
        int hashCode2 = (((((i6 ^ hashCode) * 1000003) ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.sourceExtension)) * 1000003;
        String str = this.sourceExtensionJsonProto3;
        int hashCode3 = str == null ? 0 : str.hashCode();
        long j8 = this.timezoneOffsetSeconds;
        int i7 = (((hashCode2 ^ hashCode3) * 1000003) ^ ((int) ((j8 >>> 32) ^ j8))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo = this.networkConnectionInfo;
        return i7 ^ (networkConnectionInfo != null ? networkConnectionInfo.hashCode() : 0);
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.eventTimeMs + ", eventCode=" + this.eventCode + ", eventUptimeMs=" + this.eventUptimeMs + ", sourceExtension=" + Arrays.toString(this.sourceExtension) + ", sourceExtensionJsonProto3=" + this.sourceExtensionJsonProto3 + ", timezoneOffsetSeconds=" + this.timezoneOffsetSeconds + ", networkConnectionInfo=" + this.networkConnectionInfo + "}";
    }
}
