package com.kwad.sdk.core.videocache;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class p implements m {
    protected volatile String aLC;
    protected volatile int length = Integer.MIN_VALUE;
    protected String url;

    public abstract String Ku();

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "UrlSource{url='" + this.url + "', length=" + this.length + ", mime='" + this.aLC + "'}";
    }
}
