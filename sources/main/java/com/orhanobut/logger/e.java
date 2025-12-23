package com.orhanobut.logger;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class e implements h {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final Handler f36479a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final String f36480a;

        /* renamed from: b, reason: collision with root package name */
        private final int f36481b;

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            String str = (String) message.obj;
            FileWriter fileWriter = null;
            try {
                FileWriter fileWriter2 = new FileWriter(a(this.f36480a, "logs"), true);
                try {
                    b(fileWriter2, str);
                    fileWriter2.flush();
                    fileWriter2.close();
                } catch (IOException unused) {
                    fileWriter = fileWriter2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.flush();
                            fileWriter.close();
                        } catch (IOException unused2) {
                        }
                    }
                }
            } catch (IOException unused3) {
            }
        }

        a(@NonNull Looper looper, @NonNull String str, int i6) {
            super((Looper) n.a(looper));
            this.f36480a = (String) n.a(str);
            this.f36481b = i6;
        }

        private File a(@NonNull String str, @NonNull String str2) {
            n.a(str);
            n.a(str2);
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, String.format("%s_%s.csv", str2, 0));
            File file3 = null;
            int i6 = 0;
            while (file2.exists()) {
                i6++;
                file3 = file2;
                file2 = new File(file, String.format("%s_%s.csv", str2, Integer.valueOf(i6)));
            }
            if (file3 != null && file3.length() < this.f36481b) {
                return file3;
            }
            return file2;
        }

        private void b(@NonNull FileWriter fileWriter, @NonNull String str) throws IOException {
            n.a(fileWriter);
            n.a(str);
            fileWriter.append((CharSequence) str);
        }
    }

    public e(@NonNull Handler handler) {
        this.f36479a = (Handler) n.a(handler);
    }

    @Override // com.orhanobut.logger.h
    public void a(int i6, @Nullable String str, @NonNull String str2) {
        n.a(str2);
        Handler handler = this.f36479a;
        handler.sendMessage(handler.obtainMessage(i6, str2));
    }
}
