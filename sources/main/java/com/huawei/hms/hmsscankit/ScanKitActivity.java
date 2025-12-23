package com.huawei.hms.hmsscankit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.w7;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ScanKitActivity extends Activity {
    private static final int REQUEST_SETTING_DETAILS = 1;
    private static final String TAG = "ScanKitActivity";
    static AlertDialog alertDialog;
    static a mDialog;
    private boolean hasCameraPermission;
    private OrientationEventListener mOrientationListener;
    private RemoteView remoteView;
    private int lastRotation = Integer.MAX_VALUE;
    private boolean errorReport = false;
    private boolean showGuide = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.huawei.hms.hmsscankit.ScanKitActivity$1, reason: invalid class name */
    class AnonymousClass1 implements DialogInterface.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i6) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.huawei.hms.hmsscankit.ScanKitActivity$2, reason: invalid class name */
    class AnonymousClass2 implements DialogInterface.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i6) {
            ScanKitActivity.this.gotoSetting();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.huawei.hms.hmsscankit.ScanKitActivity$3, reason: invalid class name */
    class AnonymousClass3 implements DialogInterface.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i6) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.huawei.hms.hmsscankit.ScanKitActivity$4, reason: invalid class name */
    class AnonymousClass4 implements DialogInterface.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i6) {
            ScanKitActivity.this.gotoSetting();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.huawei.hms.hmsscankit.ScanKitActivity$5, reason: invalid class name */
    class AnonymousClass5 implements OnResultCallback {
        AnonymousClass5() {
        }

        @Override // com.huawei.hms.hmsscankit.OnResultCallback
        public void onResult(HmsScan[] hmsScanArr) {
            HmsScan hmsScan;
            if (hmsScanArr == null || hmsScanArr.length <= 0 || (hmsScan = hmsScanArr[0]) == null || TextUtils.isEmpty(hmsScan.originalValue)) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(ScanUtil.RESULT_CODE, 0);
            intent.putExtra(ScanUtil.RESULT, hmsScanArr[0]);
            ScanKitActivity.this.setResult(-1, intent);
            ScanKitActivity.this.finish();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.huawei.hms.hmsscankit.ScanKitActivity$6, reason: invalid class name */
    class AnonymousClass6 implements OnErrorCallback {
        AnonymousClass6() {
        }

        @Override // com.huawei.hms.hmsscankit.OnErrorCallback
        public void onError(int i6) {
            boolean unused = ScanKitActivity.this.errorReport;
            if (ScanKitActivity.this.errorReport) {
                Intent intent = new Intent();
                intent.putExtra(ScanUtil.RESULT_CODE, i6);
                ScanKitActivity.this.setResult(-1, intent);
                ScanKitActivity.this.finish();
            }
        }
    }

    static {
        StubApp.interface11(34293);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public native void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr);

    private void cameraPermissionChange() {
        a aVar = mDialog;
        if (aVar != null) {
            aVar.dismiss();
        }
        AlertDialog alertDialog2 = alertDialog;
        if (alertDialog2 != null && alertDialog2.isShowing()) {
            alertDialog.dismiss();
        }
        if (isFinishing()) {
            return;
        }
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoSetting() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        Uri fromParts = Uri.fromParts(WiseOpenHianalyticsData.UNION_PACKAGE, getPackageName(), null);
        o4.a(TAG, "getPackageName ", getPackageName());
        intent.setData(fromParts);
        startActivityForResult(intent, 1);
    }

    private void setActivityUseNotchScreen(Activity activity) {
        if (activity != null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            if (Build.VERSION.SDK_INT >= 28) {
                attributes.layoutInDisplayCutoutMode = 1;
            }
            activity.getWindow().setAttributes(attributes);
        }
    }

    private void startOrientationChangeListener() {
        OrientationEventListener orientationEventListener = new OrientationEventListener(this) { // from class: com.huawei.hms.hmsscankit.ScanKitActivity.7
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i6) {
                try {
                    int rotation = ScanKitActivity.this.getWindowManager().getDefaultDisplay().getRotation();
                    if (Math.abs(ScanKitActivity.this.lastRotation - rotation) == 2) {
                        ScanKitActivity.this.recreate();
                    }
                    ScanKitActivity.this.lastRotation = rotation;
                } catch (RuntimeException unused) {
                }
            }
        };
        this.mOrientationListener = orientationEventListener;
        orientationEventListener.enable();
    }

    @Override // android.app.Activity
    public void finish() {
        this.remoteView.onStop();
        w7.f34994c = true;
        super.finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i6, int i7, Intent intent) {
        super.onActivityResult(i6, i7, intent);
        this.remoteView.onActivityResult(i6, i7, intent);
        if (i6 == 1) {
            cameraPermissionChange();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.remoteView.onDestroy();
        w7.f34994c = true;
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.remoteView.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.remoteView.onResume();
        w7.f34994c = false;
        if (!this.hasCameraPermission && w7.a((Context) this)) {
            cameraPermissionChange();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.remoteView.onStart();
        w7.f34994c = false;
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (!w7.f34994c) {
            this.remoteView.onStop();
            w7.f34994c = true;
        }
    }
}
