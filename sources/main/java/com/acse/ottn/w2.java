package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.HelpShopAppUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectStreamException;
import java.util.Random;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class w2 {

    /* renamed from: c, reason: collision with root package name */
    public static w2 f5417c;

    /* renamed from: a, reason: collision with root package name */
    public AccessibilityService f5418a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5419b = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5420a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f5421b;

        public a(int i6, int i7) {
            this.f5420a = i6;
            this.f5421b = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT >= 24) {
                if (w2.this.f5418a == null) {
                    c2.c("samon-->", "mService is null");
                    return;
                }
                if (k0.f4669e) {
                    try {
                        if (j3.a().e("ocr_screen_scroll").equals("1")) {
                            com.acse.ottn.d.d().f4341m = com.acse.ottn.b.c().a(w2.this.f5418a, this.f5420a, this.f5421b);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT >= 24 && k0.f4669e && j3.a().e("ocr_screen_scroll").equals("1")) {
                com.acse.ottn.b.c().a(w2.this.f5418a, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CURRENT_DOWNLOAD_INDEX, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CURRENT_DOWNLOAD_INDEX, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CURRENT_DOWNLOAD_INDEX, org.apache.commons.net.nntp.h.f50924w, 250);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements AccessibilityService.TakeScreenshotCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityNodeInfo f5424a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f5425b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f5426c;

        public c(AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2) {
            this.f5424a = accessibilityNodeInfo;
            this.f5425b = str;
            this.f5426c = str2;
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        public void onFailure(int i6) {
            c2.c("samon ScreenShotResult", "onFailure code is " + i6);
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        @RequiresApi(api = 30)
        public void onSuccess(@NonNull AccessibilityService.ScreenshotResult screenshotResult) {
            HardwareBuffer hardwareBuffer;
            ColorSpace colorSpace;
            Bitmap wrapHardwareBuffer;
            int i6;
            int i7;
            int i8;
            hardwareBuffer = screenshotResult.getHardwareBuffer();
            colorSpace = screenshotResult.getColorSpace();
            wrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer, colorSpace);
            try {
                Rect rect = new Rect();
                this.f5424a.getBoundsInScreen(rect);
                if ("1".equals(this.f5425b)) {
                    i7 = rect.top - 90;
                    i8 = j4.c(w2.this.f5418a);
                    i6 = 155;
                } else {
                    i6 = 150;
                    if ("2".equals(this.f5425b)) {
                        i7 = rect.bottom + 10;
                        i8 = j4.c(w2.this.f5418a);
                    } else if ("3".equals(this.f5425b)) {
                        i7 = rect.bottom + 10;
                        i8 = j4.c(w2.this.f5418a);
                    } else if ("4".equals(this.f5425b)) {
                        i7 = rect.bottom + 20;
                        i8 = j4.c(w2.this.f5418a);
                    } else if ("5".equals(this.f5425b)) {
                        i7 = rect.top - 150;
                        i8 = j4.c(w2.this.f5418a);
                    } else {
                        i7 = 0;
                        i8 = 0;
                        i6 = 0;
                    }
                }
                if (i7 <= j4.b(w2.this.f5418a) && i8 != 0 && i6 != 0) {
                    Bitmap createBitmap = Bitmap.createBitmap(wrapHardwareBuffer, 0, i7, i8, i6);
                    w2.this.a(createBitmap, this.f5426c);
                    w2.this.b(createBitmap, this.f5426c);
                }
            } catch (Throwable th) {
                c2.c("samon croppedImage", "Throwable e =  " + th.getMessage());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d implements AccessibilityService.TakeScreenshotCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityNodeInfo f5428a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f5429b;

        public d(AccessibilityNodeInfo accessibilityNodeInfo, int i6) {
            this.f5428a = accessibilityNodeInfo;
            this.f5429b = i6;
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        public void onFailure(int i6) {
            c2.c("samon startCroppedTitle", "onFailure code is " + i6);
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        @RequiresApi(api = 30)
        public void onSuccess(@NonNull AccessibilityService.ScreenshotResult screenshotResult) {
            HardwareBuffer hardwareBuffer;
            ColorSpace colorSpace;
            Bitmap wrapHardwareBuffer;
            hardwareBuffer = screenshotResult.getHardwareBuffer();
            colorSpace = screenshotResult.getColorSpace();
            wrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer, colorSpace);
            try {
                Rect rect = new Rect();
                this.f5428a.getBoundsInScreen(rect);
                Bitmap createBitmap = Bitmap.createBitmap(wrapHardwareBuffer, 0, 0, rect.right - rect.left, this.f5429b);
                w2.this.a(createBitmap, "3");
                w2.this.b(createBitmap, "3");
            } catch (Throwable th) {
                c2.c("samon startCroppedTitle", "Throwable e =  " + th.getMessage());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e implements AccessibilityService.TakeScreenshotCallback {
        public e() {
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        public void onFailure(int i6) {
            c2.c("samon startCroppedTitle", "onFailure code is " + i6);
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        @RequiresApi(api = 30)
        public void onSuccess(@NonNull AccessibilityService.ScreenshotResult screenshotResult) {
            HardwareBuffer hardwareBuffer;
            ColorSpace colorSpace;
            Bitmap wrapHardwareBuffer;
            hardwareBuffer = screenshotResult.getHardwareBuffer();
            colorSpace = screenshotResult.getColorSpace();
            wrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer, colorSpace);
            try {
                w2.this.a(wrapHardwareBuffer, "3");
                w2.this.b(wrapHardwareBuffer, "3");
            } catch (Throwable th) {
                c2.c("samon startCroppedTitle", "Throwable e =  " + th.getMessage());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class f implements AccessibilityService.TakeScreenshotCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityNodeInfo f5432a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f5433b;

        public f(AccessibilityNodeInfo accessibilityNodeInfo, int i6) {
            this.f5432a = accessibilityNodeInfo;
            this.f5433b = i6;
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        public void onFailure(int i6) {
            c2.c("samon startCroppedTitle", "onFailure code is " + i6);
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        @RequiresApi(api = 30)
        public void onSuccess(@NonNull AccessibilityService.ScreenshotResult screenshotResult) {
            HardwareBuffer hardwareBuffer;
            ColorSpace colorSpace;
            Bitmap wrapHardwareBuffer;
            Bitmap createBitmap;
            hardwareBuffer = screenshotResult.getHardwareBuffer();
            colorSpace = screenshotResult.getColorSpace();
            wrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer, colorSpace);
            try {
                Rect rect = new Rect();
                this.f5432a.getBoundsInScreen(rect);
                int c6 = j4.c(w2.this.f5418a);
                int b6 = j4.b(w2.this.f5418a);
                int i6 = this.f5433b;
                if (i6 == 0) {
                    int i7 = rect.bottom;
                    createBitmap = Bitmap.createBitmap(wrapHardwareBuffer, 0, i7 + 50, c6, (b6 - i7) / 2);
                } else {
                    createBitmap = Bitmap.createBitmap(wrapHardwareBuffer, 0, rect.bottom + 50, c6, i6);
                }
                w2.this.a(createBitmap, "3");
                w2.this.b(createBitmap, "3");
            } catch (Throwable th) {
                c2.c("samon startCroppedTitle", "Throwable e =  " + th.getMessage());
            }
        }
    }

    public void b() {
        com.acse.ottn.d.d().f4342n = "";
        com.acse.ottn.d.d().f4343o = "";
    }

    public static w2 d() {
        if (f5417c == null) {
            synchronized (w2.class) {
                try {
                    if (f5417c == null) {
                        f5417c = new w2();
                    }
                } finally {
                }
            }
        }
        return f5417c;
    }

    public final Object e() throws ObjectStreamException {
        return f5417c;
    }

    public void a(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        if (this.f5419b || this.f5418a == null) {
            return;
        }
        this.f5419b = true;
        c2.a("samon", "找到截图目标");
        a(accessibilityNodeInfo, "1", str);
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        int i6 = rect.top;
        int i7 = rect.left + 200;
        try {
            new Handler(Looper.getMainLooper()).postDelayed(new a(i7, i6 + ((rect.bottom - i6) / 2)), 0L);
            if (j4.b(HelpShopAppUtil.getContext()) - rect.bottom < 200) {
                new Handler(Looper.getMainLooper()).postDelayed(new b(), 500L);
            }
        } catch (Throwable unused) {
        }
    }

    public final void b(Bitmap bitmap, String str) {
        if (AcseHelpManager.mIsDebug) {
            if ("1".equals(str)) {
                a(bitmap, new File(c() + "/" + new Random().nextInt(10000) + "shot1.png"));
                return;
            }
            a(bitmap, new File(c() + "/" + new Random().nextInt(10000) + "shot2.png"));
        }
    }

    public final File c() {
        File externalFilesDir = HelpShopAppUtil.getContext().getExternalFilesDir("crash");
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return externalFilesDir;
    }

    public String f() {
        File file = new File(c() + "/Screenshot.png");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return Base64.encodeToString(bArr, 0);
        } catch (Throwable unused) {
            return "";
        }
    }

    public void b(AccessibilityNodeInfo accessibilityNodeInfo, int i6) {
        AccessibilityService accessibilityService;
        Executor mainExecutor;
        if (Build.VERSION.SDK_INT < 30 || (accessibilityService = this.f5418a) == null) {
            return;
        }
        mainExecutor = HelpShopAppUtil.getContext().getMainExecutor();
        accessibilityService.takeScreenshot(0, mainExecutor, new f(accessibilityNodeInfo, i6));
    }

    public void a(Bitmap bitmap, File file) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 20, byteArrayOutputStream);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void a(Bitmap bitmap, String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 20, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if ("1".equals(str)) {
                com.acse.ottn.d.d().f4343o = Base64.encodeToString(byteArray, 0);
            } else if ("2".equals(str)) {
                c2.a("samon-->", "imageBase64");
                com.acse.ottn.d.d().f4342n = Base64.encodeToString(byteArray, 0);
            } else if ("3".equals(str)) {
                com.acse.ottn.d.d().f4342n = Base64.encodeToString(byteArray, 0);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(AccessibilityService accessibilityService) {
        this.f5418a = accessibilityService;
    }

    public final void a(AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2) {
        AccessibilityService accessibilityService;
        Executor mainExecutor;
        if (Build.VERSION.SDK_INT < 30 || (accessibilityService = this.f5418a) == null) {
            return;
        }
        mainExecutor = HelpShopAppUtil.getContext().getMainExecutor();
        accessibilityService.takeScreenshot(0, mainExecutor, new c(accessibilityNodeInfo, str2, str));
    }

    public void a(AccessibilityNodeInfo accessibilityNodeInfo, int i6) {
        AccessibilityService accessibilityService;
        Executor mainExecutor;
        if (Build.VERSION.SDK_INT < 30 || (accessibilityService = this.f5418a) == null) {
            return;
        }
        mainExecutor = HelpShopAppUtil.getContext().getMainExecutor();
        accessibilityService.takeScreenshot(0, mainExecutor, new d(accessibilityNodeInfo, i6));
    }

    public void a() {
        AccessibilityService accessibilityService;
        Executor mainExecutor;
        if (Build.VERSION.SDK_INT < 30 || (accessibilityService = this.f5418a) == null) {
            return;
        }
        mainExecutor = HelpShopAppUtil.getContext().getMainExecutor();
        accessibilityService.takeScreenshot(0, mainExecutor, new e());
    }
}
