package com.tencent.mmkv;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface MMKVHandler {
    void mmkvLog(MMKVLogLevel level, String file, int line, String function, String message);

    MMKVRecoverStrategic onMMKVCRCCheckFail(String mmapID);

    MMKVRecoverStrategic onMMKVFileLengthError(String mmapID);

    boolean wantLogRedirecting();
}
