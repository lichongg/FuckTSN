package com.clj.fastble.exception;

import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class BleException implements Serializable {
    public static final int ERROR_CODE_GATT = 101;
    public static final int ERROR_CODE_OTHER = 102;
    public static final int ERROR_CODE_TIMEOUT = 100;
    private static final long serialVersionUID = 8004414918500865564L;
    private int code;
    private String description;

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public BleException setCode(int i6) {
        this.code = i6;
        return this;
    }

    public BleException setDescription(String str) {
        this.description = str;
        return this;
    }

    public String toString() {
        return "BleException { code=" + this.code + ", description='" + this.description + "'}";
    }

    public BleException(int i6, String str) {
        this.code = i6;
        this.description = str;
    }
}
