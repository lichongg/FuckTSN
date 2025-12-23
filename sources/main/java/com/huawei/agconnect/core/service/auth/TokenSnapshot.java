package com.huawei.agconnect.core.service.auth;

/* loaded from: D:\Downloads\app\classes5.dex */
public interface TokenSnapshot {

    public enum State {
        SIGNED_IN,
        TOKEN_UPDATED,
        TOKEN_INVALID,
        SIGNED_OUT
    }

    String a();

    State getState();
}
