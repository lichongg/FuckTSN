package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.ClientInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final class AutoValue_ClientInfo extends ClientInfo {
    private final AndroidClientInfo androidClientInfo;
    private final ClientInfo.ClientType clientType;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.android.datatransport.cct.internal.AutoValue_ClientInfo$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class Builder extends ClientInfo.Builder {
        private AndroidClientInfo androidClientInfo;
        private ClientInfo.ClientType clientType;

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.Builder
        public ClientInfo build() {
            return new AutoValue_ClientInfo(this.clientType, this.androidClientInfo, null);
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.Builder
        public ClientInfo.Builder setAndroidClientInfo(@Nullable AndroidClientInfo androidClientInfo) {
            this.androidClientInfo = androidClientInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.Builder
        public ClientInfo.Builder setClientType(@Nullable ClientInfo.ClientType clientType) {
            this.clientType = clientType;
            return this;
        }

        Builder() {
        }
    }

    /* synthetic */ AutoValue_ClientInfo(ClientInfo.ClientType clientType, AndroidClientInfo androidClientInfo, AnonymousClass1 anonymousClass1) {
        this(clientType, androidClientInfo);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ClientInfo) {
            ClientInfo clientInfo = (ClientInfo) obj;
            ClientInfo.ClientType clientType = this.clientType;
            if (clientType != null ? clientType.equals(clientInfo.getClientType()) : clientInfo.getClientType() == null) {
                AndroidClientInfo androidClientInfo = this.androidClientInfo;
                if (androidClientInfo != null ? androidClientInfo.equals(clientInfo.getAndroidClientInfo()) : clientInfo.getAndroidClientInfo() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    private AutoValue_ClientInfo(@Nullable ClientInfo.ClientType clientType, @Nullable AndroidClientInfo androidClientInfo) {
        this.clientType = clientType;
        this.androidClientInfo = androidClientInfo;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    @Nullable
    public AndroidClientInfo getAndroidClientInfo() {
        return this.androidClientInfo;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    @Nullable
    public ClientInfo.ClientType getClientType() {
        return this.clientType;
    }

    public int hashCode() {
        ClientInfo.ClientType clientType = this.clientType;
        int hashCode = ((clientType == null ? 0 : clientType.hashCode()) ^ 1000003) * 1000003;
        AndroidClientInfo androidClientInfo = this.androidClientInfo;
        return hashCode ^ (androidClientInfo != null ? androidClientInfo.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.clientType + ", androidClientInfo=" + this.androidClientInfo + "}";
    }
}
