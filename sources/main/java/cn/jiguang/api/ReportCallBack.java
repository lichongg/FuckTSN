package cn.jiguang.api;

/* loaded from: D:\Downloads\app\classes2.dex */
public interface ReportCallBack {
    public static final int DELIVERED = 1;
    public static final int ERROR = -2;
    public static final int FAILED = -1;
    public static final int OK = 0;

    void onFinish(int i6);
}
