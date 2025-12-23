package xyz.adscope.ad.publish.ad.unified;

import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IUnifiedDownloadInfo {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface IPermissionInfo {
        String getDescribe();

        String getPermissionType();

        String getTitle();
    }

    String getApkMD5();

    String getAppIntroduction();

    String getDeveloper();

    String getIconUrl();

    String getName();

    String getPackageName();

    List<IPermissionInfo> getPermission();

    String getPermissionUrl();

    String getPolicy();

    String getPolicyUrl();

    String getSize();

    String getVersion();
}
