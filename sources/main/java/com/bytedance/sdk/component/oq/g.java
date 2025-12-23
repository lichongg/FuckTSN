package com.bytedance.sdk.component.oq;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class g implements Comparable<g>, Runnable {
    private int mPriority;
    private String name;

    public g(String str, int i6) {
        this.mPriority = 0;
        this.mPriority = i6 == 0 ? 5 : i6;
        this.name = str;
    }

    @Override // java.lang.Comparable
    public int compareTo(g gVar) {
        if (getPriority() < gVar.getPriority()) {
            return 1;
        }
        return getPriority() >= gVar.getPriority() ? -1 : 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public void setPriority(int i6) {
        this.mPriority = i6;
    }

    public g(String str) {
        this.mPriority = 5;
        this.name = str;
    }
}
