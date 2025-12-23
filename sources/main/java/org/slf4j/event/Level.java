package org.slf4j.event;

import com.baidu.mobads.sdk.internal.ca;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum Level {
    ERROR(40, ca.f10846l),
    WARN(30, "WARN"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, "TRACE");

    private int levelInt;
    private String levelStr;

    public int toInt() {
        return this.levelInt;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.levelStr;
    }

    Level(int i6, String str) {
        this.levelInt = i6;
        this.levelStr = str;
    }
}
