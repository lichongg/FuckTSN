package com.hw.videoprocessor.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private int f35448a;

    /* renamed from: b, reason: collision with root package name */
    private int f35449b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f35450c;

    /* renamed from: d, reason: collision with root package name */
    private int f35451d;

    /* renamed from: e, reason: collision with root package name */
    private int f35452e;

    public boolean a(int i6) {
        if (this.f35450c) {
            return false;
        }
        if (i6 == 0) {
            this.f35452e++;
            return false;
        }
        float f6 = (r7 - this.f35449b) / this.f35448a;
        int i7 = this.f35451d;
        int i8 = this.f35452e;
        boolean z5 = Math.abs((((float) (i7 + 1)) / ((float) (i7 + i8))) - f6) < Math.abs((((float) i7) / ((float) ((i7 + i8) + 1))) - f6);
        if (z5) {
            this.f35451d++;
            return z5;
        }
        this.f35452e++;
        return z5;
    }

    public void b() {
        if (this.f35450c) {
            return;
        }
        int i6 = this.f35451d;
        int i7 = this.f35452e;
        int i8 = this.f35448a;
        float f6 = i7 / ((i6 + i7) / i8);
        c.k("最终帧率为:" + f6, new Object[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("实际丢帧率:");
        sb.append(this.f35451d / (r3 + this.f35452e));
        sb.append(" 目标丢帧率:");
        sb.append((i8 - this.f35449b) / i8);
        c.k(sb.toString(), new Object[0]);
    }

    public d(int i6, int i7) {
        this.f35448a = i6;
        this.f35449b = i7;
        if (i6 <= i7) {
            c.f("原始帧率:" + i6 + "小于目标帧率:" + i7 + "，不支持补帧", new Object[0]);
            this.f35450c = true;
        }
    }
}
