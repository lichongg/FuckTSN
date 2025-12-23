package com.kwad.sdk.api;

import android.location.Location;
import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkApi
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class KsCustomController {
    @KsAdSdkApi
    @Keep
    public boolean canReadInstalledPackages() {
        return true;
    }

    @KsAdSdkApi
    @Keep
    public boolean canReadLocation() {
        return true;
    }

    @KsAdSdkApi
    @Keep
    public boolean canUseMacAddress() {
        return true;
    }

    @KsAdSdkApi
    @Keep
    public boolean canUseNetworkState() {
        return true;
    }

    @KsAdSdkApi
    @Keep
    public boolean canUseOaid() {
        return true;
    }

    @KsAdSdkApi
    @Keep
    public boolean canUsePhoneState() {
        return true;
    }

    @KsAdSdkApi
    @Keep
    public boolean canUseStoragePermission() {
        return true;
    }

    @KsAdSdkApi
    @Keep
    public String[] getImeis() {
        return null;
    }

    @KsAdSdkApi
    @Keep
    public List<String> getInstalledPackages() {
        return null;
    }

    @KsAdSdkApi
    @Keep
    public KsLocation getKsLocation() {
        return null;
    }

    @KsAdSdkApi
    @Keep
    @Deprecated
    public Location getLocation() {
        return null;
    }

    @KsAdSdkApi
    @Keep
    public String getAndroidId() {
        return "";
    }

    @KsAdSdkApi
    @Keep
    public String getImei() {
        return "";
    }

    @KsAdSdkApi
    @Keep
    public String getMacAddress() {
        return "";
    }

    @KsAdSdkApi
    @Keep
    public String getOaid() {
        return "";
    }
}
