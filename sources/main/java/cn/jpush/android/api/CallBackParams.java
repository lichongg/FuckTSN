package cn.jpush.android.api;

import cn.jpush.android.helper.f;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes2.dex */
public class CallBackParams implements Serializable {
    public int action;
    public String alias;
    public Map<String, Object> pros;
    public int protoType;
    private long sendTime;
    public int sequence;
    public TagAliasCallback tagAliasCallBack;
    public Set<String> tags;

    public CallBackParams(int i6, long j6, int i7, int i8) {
        this.sequence = i6;
        this.sendTime = j6;
        this.protoType = i7;
        this.action = i8;
    }

    public CallBackParams(int i6, String str, long j6, int i7, int i8) {
        this.sequence = i6;
        this.alias = str;
        this.sendTime = j6;
        this.protoType = i7;
        this.action = i8;
    }

    public boolean isTimeOut(long j6) {
        return this.protoType == 0 && System.currentTimeMillis() - this.sendTime > j6 + 10000;
    }

    public String toString() {
        return "CallBackParams{sendTime=" + this.sendTime + ", alias='" + this.alias + "', pros='" + this.pros + "', tags=" + this.tags + ", tagAliasCallBack=" + this.tagAliasCallBack + ", sequence=" + this.sequence + ", protoType=" + this.protoType + ", action=" + this.action + '}';
    }

    public CallBackParams(int i6, Map<String, Object> map, long j6, int i7, int i8) {
        this.sequence = i6;
        this.pros = map;
        this.sendTime = j6;
        this.protoType = i7;
        this.action = i8;
    }

    public CallBackParams(int i6, Set<String> set, long j6, int i7, int i8) {
        this.sequence = i6;
        this.tags = set;
        this.sendTime = j6;
        this.protoType = i7;
        this.action = i8;
    }

    public CallBackParams(String str, Set<String> set, TagAliasCallback tagAliasCallback, long j6, int i6, int i7) {
        this.alias = str;
        this.tags = set;
        this.tagAliasCallBack = tagAliasCallback;
        this.sendTime = j6;
        this.protoType = i6;
        this.action = i7;
        this.sequence = (int) f.a();
    }
}
