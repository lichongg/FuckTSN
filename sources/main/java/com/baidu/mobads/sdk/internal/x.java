package com.baidu.mobads.sdk.internal;

import java.util.Observer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface x {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum a {
        NONE(-1, "未开始"),
        INITING(0, "下载准备中"),
        DOWNLOADING(1, "正在下载"),
        CANCELLED(2, "已取消下载"),
        COMPLETED(3, "下载完成"),
        ERROR(4, "下载失败"),
        COMPLETE_BUT_FILE_REMOVED(5, "下载完但文件异常"),
        PAUSED(6, "已暂停下载");


        /* renamed from: i, reason: collision with root package name */
        private int f11209i;

        /* renamed from: j, reason: collision with root package name */
        private String f11210j;

        public int b() {
            return this.f11209i;
        }

        public String c() {
            return this.f11210j;
        }

        a(int i6, String str) {
            this.f11209i = i6;
            this.f11210j = str;
        }
    }

    void a();

    void a(boolean z5);

    void addObserver(Observer observer);

    void b();

    void c();

    void d();

    String e();

    String f();

    String g();

    String h();

    String i();

    int j();

    float k();

    a l();

    void m();

    boolean n();
}
