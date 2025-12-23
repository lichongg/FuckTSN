package cn.jpush.android.api;

import android.os.Bundle;

/* loaded from: D:\Downloads\app\classes2.dex */
public class CmdMessage {
    public int cmd;
    public int errorCode;
    public Bundle extra;
    public String msg;

    public CmdMessage(int i6, int i7) {
        this.cmd = i6;
        this.errorCode = i7;
    }

    public CmdMessage(int i6, int i7, String str) {
        this.cmd = i6;
        this.errorCode = i7;
        this.msg = str;
    }

    public String toString() {
        return "CmdMessage{cmd=" + this.cmd + ", errorCode=" + this.errorCode + ", msg='" + this.msg + "', extra=" + this.extra + '}';
    }

    public CmdMessage(int i6, int i7, String str, Bundle bundle) {
        this.cmd = i6;
        this.errorCode = i7;
        this.msg = str;
        this.extra = bundle;
    }
}
