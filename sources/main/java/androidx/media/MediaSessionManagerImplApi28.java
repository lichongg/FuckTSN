package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(28)
/* loaded from: D:\Downloads\app\classes.dex */
class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {
    android.media.session.MediaSessionManager mObject;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class RemoteUserInfoImplApi28 implements MediaSessionManager.RemoteUserInfoImpl {
        final MediaSessionManager.RemoteUserInfo mObject;

        RemoteUserInfoImplApi28(String str, int i6, int i7) {
            this.mObject = j.a(str, i6, i7);
        }

        public boolean equals(Object obj) {
            boolean equals;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RemoteUserInfoImplApi28)) {
                return false;
            }
            equals = this.mObject.equals(((RemoteUserInfoImplApi28) obj).mObject);
            return equals;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public String getPackageName() {
            String packageName;
            packageName = this.mObject.getPackageName();
            return packageName;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getPid() {
            int pid;
            pid = this.mObject.getPid();
            return pid;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getUid() {
            int uid;
            uid = this.mObject.getUid();
            return uid;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.mObject);
        }

        RemoteUserInfoImplApi28(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.mObject = remoteUserInfo;
        }
    }

    @Override // androidx.media.MediaSessionManagerImplApi21, androidx.media.MediaSessionManagerImplBase, androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        boolean isTrustedForMediaControl;
        if (!(remoteUserInfoImpl instanceof RemoteUserInfoImplApi28)) {
            return false;
        }
        isTrustedForMediaControl = this.mObject.isTrustedForMediaControl(((RemoteUserInfoImplApi28) remoteUserInfoImpl).mObject);
        return isTrustedForMediaControl;
    }

    MediaSessionManagerImplApi28(Context context) {
        super(context);
        this.mObject = (android.media.session.MediaSessionManager) context.getSystemService("media_session");
    }
}
