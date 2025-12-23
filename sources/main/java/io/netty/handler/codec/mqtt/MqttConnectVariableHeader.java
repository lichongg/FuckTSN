package io.netty.handler.codec.mqtt;

import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class MqttConnectVariableHeader {
    private final boolean hasPassword;
    private final boolean hasUserName;
    private final boolean isCleanSession;
    private final boolean isWillFlag;
    private final boolean isWillRetain;
    private final int keepAliveTimeSeconds;
    private final String name;
    private final int version;
    private final int willQos;

    public boolean hasPassword() {
        return this.hasPassword;
    }

    public boolean hasUserName() {
        return this.hasUserName;
    }

    public boolean isCleanSession() {
        return this.isCleanSession;
    }

    public boolean isWillFlag() {
        return this.isWillFlag;
    }

    public boolean isWillRetain() {
        return this.isWillRetain;
    }

    public int keepAliveTimeSeconds() {
        return this.keepAliveTimeSeconds;
    }

    public String name() {
        return this.name;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "[name=" + this.name + ", version=" + this.version + ", hasUserName=" + this.hasUserName + ", hasPassword=" + this.hasPassword + ", isWillRetain=" + this.isWillRetain + ", isWillFlag=" + this.isWillFlag + ", isCleanSession=" + this.isCleanSession + ", keepAliveTimeSeconds=" + this.keepAliveTimeSeconds + ']';
    }

    public int version() {
        return this.version;
    }

    public int willQos() {
        return this.willQos;
    }

    public MqttConnectVariableHeader(String str, int i6, boolean z5, boolean z6, boolean z7, int i7, boolean z8, boolean z9, int i8) {
        this.name = str;
        this.version = i6;
        this.hasUserName = z5;
        this.hasPassword = z6;
        this.isWillRetain = z7;
        this.willQos = i7;
        this.isWillFlag = z8;
        this.isCleanSession = z9;
        this.keepAliveTimeSeconds = i8;
    }
}
