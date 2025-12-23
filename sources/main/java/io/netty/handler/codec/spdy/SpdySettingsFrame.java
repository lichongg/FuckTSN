package io.netty.handler.codec.spdy;

import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface SpdySettingsFrame extends SpdyFrame {
    public static final int SETTINGS_CLIENT_CERTIFICATE_VECTOR_SIZE = 8;
    public static final int SETTINGS_CURRENT_CWND = 5;
    public static final int SETTINGS_DOWNLOAD_BANDWIDTH = 2;
    public static final int SETTINGS_DOWNLOAD_RETRANS_RATE = 6;
    public static final int SETTINGS_INITIAL_WINDOW_SIZE = 7;
    public static final int SETTINGS_MAX_CONCURRENT_STREAMS = 4;
    public static final int SETTINGS_MINOR_VERSION = 0;
    public static final int SETTINGS_ROUND_TRIP_TIME = 3;
    public static final int SETTINGS_UPLOAD_BANDWIDTH = 1;

    boolean clearPreviouslyPersistedSettings();

    int getValue(int i6);

    Set<Integer> ids();

    boolean isPersistValue(int i6);

    boolean isPersisted(int i6);

    boolean isSet(int i6);

    SpdySettingsFrame removeValue(int i6);

    SpdySettingsFrame setClearPreviouslyPersistedSettings(boolean z5);

    SpdySettingsFrame setPersistValue(int i6, boolean z5);

    SpdySettingsFrame setPersisted(int i6, boolean z5);

    SpdySettingsFrame setValue(int i6, int i7);

    SpdySettingsFrame setValue(int i6, int i7, boolean z5, boolean z6);
}
