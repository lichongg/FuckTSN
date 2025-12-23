package cn.jpush.android.api;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes2.dex */
public class JPushMessage implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a, reason: collision with root package name */
    public int f3499a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f3500b = 0;

    /* renamed from: c, reason: collision with root package name */
    private String f3501c;

    /* renamed from: d, reason: collision with root package name */
    private Set<String> f3502d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, Object> f3503e;

    /* renamed from: f, reason: collision with root package name */
    private String f3504f;

    /* renamed from: g, reason: collision with root package name */
    private int f3505g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f3506h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3507i;

    /* renamed from: j, reason: collision with root package name */
    private int f3508j;

    /* renamed from: k, reason: collision with root package name */
    private String f3509k;

    public int getAction() {
        return this.f3500b;
    }

    public String getAlias() {
        return this.f3501c;
    }

    public String getCheckTag() {
        return this.f3504f;
    }

    public int getErrorCode() {
        return this.f3505g;
    }

    public String getMobileNumber() {
        return this.f3509k;
    }

    public Map<String, Object> getPros() {
        return this.f3503e;
    }

    public int getProtoType() {
        return this.f3499a;
    }

    public int getSequence() {
        return this.f3508j;
    }

    public boolean getTagCheckStateResult() {
        return this.f3506h;
    }

    public Set<String> getTags() {
        return this.f3502d;
    }

    public boolean isTagCheckOperator() {
        return this.f3507i;
    }

    public void setAction(int i6) {
        this.f3500b = i6;
    }

    public void setAlias(String str) {
        this.f3501c = str;
    }

    public void setCheckTag(String str) {
        this.f3504f = str;
    }

    public void setErrorCode(int i6) {
        this.f3505g = i6;
    }

    public void setMobileNumber(String str) {
        this.f3509k = str;
    }

    public void setPros(Map<String, Object> map) {
        this.f3503e = map;
    }

    public void setProtoType(int i6) {
        this.f3499a = i6;
    }

    public void setSequence(int i6) {
        this.f3508j = i6;
    }

    public void setTagCheckOperator(boolean z5) {
        this.f3507i = z5;
    }

    public void setTagCheckStateResult(boolean z5) {
        this.f3506h = z5;
    }

    public void setTags(Set<String> set) {
        this.f3502d = set;
    }

    public String toString() {
        return "JPushMessage{alias='" + this.f3501c + "', tags=" + this.f3502d + ", pros=" + this.f3503e + ", checkTag='" + this.f3504f + "', errorCode=" + this.f3505g + ", tagCheckStateResult=" + this.f3506h + ", isTagCheckOperator=" + this.f3507i + ", sequence=" + this.f3508j + ", mobileNumber=" + this.f3509k + '}';
    }
}
