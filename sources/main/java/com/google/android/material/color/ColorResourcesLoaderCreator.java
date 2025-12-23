package com.google.android.material.color;

import android.content.Context;
import android.content.res.loader.ResourcesLoader;
import android.content.res.loader.ResourcesProvider;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(30)
/* loaded from: D:\Downloads\app\classes5.dex */
final class ColorResourcesLoaderCreator {
    private static final String TAG = "ColorResLoaderCreator";

    @Nullable
    static ResourcesLoader create(@NonNull Context context, @NonNull Map<Integer, Integer> map) {
        FileDescriptor fileDescriptor;
        ResourcesProvider loadFromTable;
        try {
            byte[] create = ColorResourcesTableCreator.create(context, map);
            int length = create.length;
            if (create.length == 0) {
                return null;
            }
            try {
                fileDescriptor = Os.memfd_create("temp.arsc", 0);
                if (fileDescriptor == null) {
                    if (fileDescriptor != null) {
                        Os.close(fileDescriptor);
                    }
                    return null;
                }
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(fileDescriptor);
                    try {
                        fileOutputStream.write(create);
                        ParcelFileDescriptor dup = ParcelFileDescriptor.dup(fileDescriptor);
                        try {
                            h.a();
                            ResourcesLoader a6 = g.a();
                            loadFromTable = ResourcesProvider.loadFromTable(dup, null);
                            a6.addProvider(loadFromTable);
                            if (dup != null) {
                                dup.close();
                            }
                            fileOutputStream.close();
                            Os.close(fileDescriptor);
                            return a6;
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileDescriptor != null) {
                        Os.close(fileDescriptor);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileDescriptor = null;
            }
        } catch (Exception unused) {
            return null;
        }
    }

    private ColorResourcesLoaderCreator() {
    }
}
