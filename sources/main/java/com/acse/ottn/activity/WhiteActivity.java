package com.acse.ottn.activity;

import android.os.Bundle;
import com.acse.ottn.z;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class WhiteActivity extends z {

    /* renamed from: e, reason: collision with root package name */
    public static String f4184e = "ExcessActivity";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WhiteActivity.this.finish();
        }
    }

    static {
        StubApp.interface11(9040);
    }

    @Override // com.acse.ottn.z, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);
}
