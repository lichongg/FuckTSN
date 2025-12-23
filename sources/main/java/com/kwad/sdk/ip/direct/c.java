package com.kwad.sdk.ip.direct;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c implements Comparable<c> {
    private String ip;
    private boolean success;
    private int weight;
    private float aRY = -1.0f;
    private int aSe = 20;
    private int aSd = 3;
    private StringBuffer aSf = new StringBuffer();

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        return (int) (this.aRY - cVar.aRY);
    }

    public final int MQ() {
        return this.aSd;
    }

    public final float MR() {
        return this.aRY;
    }

    public final void bJ(boolean z5) {
        this.success = z5;
    }

    public final void dZ(int i6) {
        this.weight = i6;
    }

    public final String getIp() {
        return this.ip;
    }

    public final int getWeight() {
        return this.weight;
    }

    public final boolean isSuccess() {
        return this.success;
    }

    public final void k(float f6) {
        this.aRY = f6;
    }

    public final String toString() {
        return "PingNetEntity{ip='" + this.ip + "', pingCount=" + this.aSd + ", pingWaitTime=" + this.aSe + ", pingTime='" + this.aRY + " ms', success=" + this.success + '}';
    }

    public c(String str) {
        this.ip = str;
    }
}
