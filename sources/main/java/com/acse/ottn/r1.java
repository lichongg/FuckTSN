package com.acse.ottn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import com.acse.ottn.model.PlunInstallModel;
import com.acse.ottn.util.HelpShopAppUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class r1 {

    /* renamed from: a, reason: collision with root package name */
    public static r1 f5030a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f5031b = "InstallUtils";

    public static r1 a() {
        if (f5030a == null) {
            synchronized (r1.class) {
                try {
                    if (f5030a == null) {
                        f5030a = new r1();
                    }
                } finally {
                }
            }
        }
        return f5030a;
    }

    public final Object b() throws ObjectStreamException {
        return f5030a;
    }

    public void b(Activity activity) {
        try {
            InputStream open = activity.getResources().getAssets().open("detn.mp3");
            if (open == null) {
                return;
            }
            File absoluteFile = activity.getExternalFilesDir("apk").getAbsoluteFile();
            if (!absoluteFile.exists()) {
                absoluteFile.mkdir();
            }
            File file = new File(activity.getExternalFilesDir("apk").getAbsoluteFile().getPath() + "/text.apk");
            file.createNewFile();
            a(open, file);
            a(file, activity);
        } catch (IOException e6) {
            e6.getMessage();
            e6.printStackTrace();
        }
    }

    public final void a(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException e6) {
                e6.printStackTrace();
                fileOutputStream = null;
            }
            try {
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                        }
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (Exception e7) {
                e7.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e8) {
                e8.printStackTrace();
            }
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (IOException e9) {
                e9.printStackTrace();
            }
            throw th2;
        }
    }

    public boolean a(Activity activity) {
        InputStream inputStream;
        try {
            inputStream = activity.getResources().getAssets().open("detn.mp3");
        } catch (IOException e6) {
            e6.printStackTrace();
            inputStream = null;
        }
        return inputStream != null;
    }

    @RequiresApi(api = 17)
    public void a(File file, Activity activity) {
        if (file.exists()) {
            Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.addFlags(1);
                    intent.addFlags(2);
                    intent.setDataAndType(FileProvider.getUriForFile(activity, activity.getPackageName() + ".provider", file), "application/vnd.android.package-archive");
                } else {
                    intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    intent.setFlags(268435456);
                }
                if (activity.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                    activity.startActivityForResult(intent, 10010);
                }
            } catch (Exception e6) {
                e6.getMessage();
                e6.printStackTrace();
            }
        }
    }

    public PlunInstallModel a(String str) {
        PlunInstallModel plunInstallModel = new PlunInstallModel();
        try {
            if (HelpShopAppUtil.getContext() == null) {
                return plunInstallModel;
            }
            PackageManager packageManager = HelpShopAppUtil.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (TextUtils.isEmpty(packageManager.getApplicationLabel(packageInfo.applicationInfo).toString())) {
                return plunInstallModel;
            }
            plunInstallModel.setVersion(packageInfo.versionCode + "");
            return plunInstallModel;
        } catch (Exception e6) {
            plunInstallModel.setVersion("0");
            e6.getMessage();
            e6.printStackTrace();
            return plunInstallModel;
        }
    }

    public PlunInstallModel a(Context context) {
        PlunInstallModel plunInstallModel = new PlunInstallModel();
        if (context == null) {
            return plunInstallModel;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            if (TextUtils.isEmpty(packageManager.getApplicationLabel(packageInfo.applicationInfo).toString())) {
                return plunInstallModel;
            }
            plunInstallModel.setVersion(packageInfo.versionCode + "");
            return plunInstallModel;
        } catch (Exception e6) {
            plunInstallModel.setVersion("0");
            e6.getMessage();
            e6.printStackTrace();
            return plunInstallModel;
        }
    }
}
