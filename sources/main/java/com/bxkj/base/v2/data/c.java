package com.bxkj.base.v2.data;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f17003a = a.f17010a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f17004b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static final int f17005c = 1;

    /* renamed from: d, reason: collision with root package name */
    public static final int f17006d = 2;

    /* renamed from: e, reason: collision with root package name */
    public static final int f17007e = 3;

    /* renamed from: f, reason: collision with root package name */
    public static final int f17008f = 4;

    /* renamed from: g, reason: collision with root package name */
    public static final int f17009g = 5;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f17010a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final int f17011b = 0;

        /* renamed from: c, reason: collision with root package name */
        public static final int f17012c = 1;

        /* renamed from: d, reason: collision with root package name */
        public static final int f17013d = 2;

        /* renamed from: e, reason: collision with root package name */
        public static final int f17014e = 3;

        /* renamed from: f, reason: collision with root package name */
        public static final int f17015f = 4;

        /* renamed from: g, reason: collision with root package name */
        public static final int f17016g = 5;

        @NotNull
        public final String a(int i6) {
            return i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? i6 != 5 ? "默认卡->只读取物理卡号" : "北京邮电大学世纪学院学生卡->从卡中读取学生学号和姓名" : "信阳师范学院学生卡->从卡中读取学生学号和姓名" : "北京科技大学体测信息卡->从卡中读取学生学号和姓名" : "外交学院体测信息卡->从卡中读取学生学号和姓名" : "体适能健康测试卡->从卡中读取学生学号和姓名";
        }

        @NotNull
        public final String b() {
            return a(b.f16998d.a().E());
        }

        private a() {
        }
    }
}
