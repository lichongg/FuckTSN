package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepName;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepName
/* loaded from: D:\Downloads\app\classes5.dex */
public final class GooglePlayServicesIncorrectManifestValueException extends GooglePlayServicesManifestException {
    public GooglePlayServicesIncorrectManifestValueException(int i6) {
        super(i6, "The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE + " but found " + i6 + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
    }
}
