package cn.easyar.engine;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import androidx.camera.core.processing.j0;
import com.stub.StubApp;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(23)
/* loaded from: D:\Downloads\app\classes2.dex */
public class PermissionFragment extends Fragment {
    private static final int PERMISSIONS_REQUEST_CODE = 43;
    private PermissionCallback callback;
    private FragmentManager fragmentManager;
    private long instanceId;
    private String[] requests;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface PermissionCallback {
        void invoke(long instanceId, int status, String msg);
    }

    public static synchronized PermissionFragment newInstance(long instanceId, String[] requests, PermissionCallback callback, FragmentManager fragmentManager) {
        PermissionFragment permissionFragment;
        synchronized (PermissionFragment.class) {
            permissionFragment = new PermissionFragment();
            permissionFragment.instanceId = instanceId;
            permissionFragment.requests = requests;
            permissionFragment.callback = callback;
            permissionFragment.fragmentManager = fragmentManager;
        }
        return permissionFragment;
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        StubApp.interface22(requestCode, permissions, grantResults);
        if (requestCode != 43) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < grantResults.length; i6++) {
            if (grantResults[i6] != 0) {
                arrayList.add(permissions[i6]);
            }
        }
        FragmentTransaction beginTransaction = this.fragmentManager.beginTransaction();
        beginTransaction.remove(this);
        beginTransaction.commit();
        if (arrayList.size() != 0) {
            this.callback.invoke(this.instanceId, 1, j0.a(" ", arrayList));
        } else {
            this.callback.invoke(this.instanceId, 0, "");
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestPermissions(this.requests, 43);
    }
}
