package com.tencent.mm.opensdk.diffdev;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface IDiffDevOAuth {
    void addListener(OAuthListener oAuthListener);

    boolean auth(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener);

    void detach();

    void removeAllListeners();

    void removeListener(OAuthListener oAuthListener);

    boolean stopAuth();
}
