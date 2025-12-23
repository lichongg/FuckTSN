package cn.easyar.engine;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import cn.easyar.FunctorOfVoidFromInputFrame;
import cn.easyar.InputFrame;
import cn.easyar.engine.PermissionFragment;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class CameraDeviceUtil {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InputFrameHandler implements FunctorOfVoidFromInputFrame {
        private long rawPointer = 0;
        private final Object lock = new Object();

        private static native void nativeInvoke(long rawPointer, InputFrame inputFrame);

        @Override // cn.easyar.FunctorOfVoidFromInputFrame
        public void invoke(InputFrame inputFrame) {
            synchronized (this.lock) {
                nativeInvoke(this.rawPointer, inputFrame);
            }
        }

        public void setRawPointer(long ptr) {
            synchronized (this.lock) {
                this.rawPointer = ptr;
            }
        }

        private InputFrameHandler() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onPermissionCallback(long instanceId, int status, String value);

    public static void requestPermissions(long instanceId) {
        int checkSelfPermission;
        if (Build.VERSION.SDK_INT < 23) {
            onPermissionCallback(instanceId, 0, "");
            return;
        }
        Activity activity = EasyAR.getInitializeActivity().get();
        if (activity == null) {
            onPermissionCallback(instanceId, 2, "ContextMiss");
            return;
        }
        ArrayList arrayList = new ArrayList();
        checkSelfPermission = activity.checkSelfPermission("android.permission.CAMERA");
        if (checkSelfPermission != 0) {
            arrayList.add("android.permission.CAMERA");
        }
        if (arrayList.size() == 0) {
            onPermissionCallback(instanceId, 0, "");
            return;
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        PermissionFragment newInstance = PermissionFragment.newInstance(instanceId, (String[]) arrayList.toArray(new String[0]), new PermissionFragment.PermissionCallback() { // from class: cn.easyar.engine.CameraDeviceUtil.1
            @Override // cn.easyar.engine.PermissionFragment.PermissionCallback
            public void invoke(long instanceId2, int status, String msg) {
                CameraDeviceUtil.onPermissionCallback(instanceId2, status, msg);
            }
        }, fragmentManager);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(0, newInstance);
        beginTransaction.commit();
    }

    CameraDeviceUtil() {
    }
}
