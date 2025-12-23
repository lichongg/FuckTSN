package com.google.mlkit.common.internal.model;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzu;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
@WorkerThread
/* loaded from: D:\Downloads\app\classes5.dex */
public class ModelUtils {
    private static final GmsLogger zza = new GmsLogger("ModelUtils", "");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public static abstract class AutoMLManifest {
        @NonNull
        @KeepForSdk
        public abstract String getLabelsFile();

        @NonNull
        @KeepForSdk
        public abstract String getModelFile();

        @NonNull
        @KeepForSdk
        public abstract String getModelType();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public static abstract class ModelLoggingInfo {
        @NonNull
        @KeepForSdk
        public abstract String getHash();

        @KeepForSdk
        public abstract long getSize();

        @KeepForSdk
        public abstract boolean isManifestModel();

        static ModelLoggingInfo zza(long j6, @Nullable String str, boolean z5) {
            return new AutoValue_ModelUtils_ModelLoggingInfo(j6, zzu.zzb(str), z5);
        }
    }

    @Nullable
    @KeepForSdk
    public static String getSHA256(@NonNull File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                String zzc = zzc(fileInputStream);
                fileInputStream.close();
                return zzc;
            } finally {
            }
        } catch (IOException e6) {
            zza.e("ModelUtils", "Failed to create FileInputStream for model: ".concat(e6.toString()));
            return null;
        }
    }

    @Nullable
    private static String zzc(InputStream inputStream) {
        int i6;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b6 : digest) {
                String hexString = Integer.toHexString(b6 & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (IOException unused) {
            zza.e("ModelUtils", "Failed to read model file");
            return null;
        } catch (NoSuchAlgorithmException unused2) {
            zza.e("ModelUtils", "Do not have SHA-256 algorithm");
            return null;
        }
    }

    private ModelUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0109 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo getModelLoggingInfo(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.NonNull com.google.mlkit.common.model.LocalModel r12) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.internal.model.ModelUtils.getModelLoggingInfo(android.content.Context, com.google.mlkit.common.model.LocalModel):com.google.mlkit.common.internal.model.ModelUtils$ModelLoggingInfo");
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x002b, code lost:
    
        if (new java.io.File(r5).exists() == false) goto L10;
     */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest parseManifestFile(@androidx.annotation.NonNull java.lang.String r5, boolean r6, @androidx.annotation.NonNull android.content.Context r7) {
        /*
            java.lang.String r0 = java.lang.String.valueOf(r5)
            com.google.android.gms.common.internal.GmsLogger r1 = com.google.mlkit.common.internal.model.ModelUtils.zza
            java.lang.String r2 = "Manifest file path: "
            java.lang.String r0 = r2.concat(r0)
            java.lang.String r2 = "ModelUtils"
            r1.d(r2, r0)
            r0 = 0
            if (r6 == 0) goto L22
            android.content.res.AssetManager r3 = r7.getAssets()     // Catch: java.io.IOException -> L2d
            java.io.InputStream r3 = r3.open(r5)     // Catch: java.io.IOException -> L2d
            if (r3 == 0) goto L35
            r3.close()     // Catch: java.io.IOException -> L2d
            goto L35
        L22:
            java.io.File r3 = new java.io.File
            r3.<init>(r5)
            boolean r3 = r3.exists()
            if (r3 != 0) goto L35
        L2d:
            com.google.android.gms.common.internal.GmsLogger r5 = com.google.mlkit.common.internal.model.ModelUtils.zza
            java.lang.String r6 = "Manifest file does not exist."
            r5.e(r2, r6)
            return r0
        L35:
            boolean r3 = r5.isEmpty()     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            r4 = 0
            if (r3 == 0) goto L43
            byte[] r5 = new byte[r4]     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            goto L66
        L3f:
            r5 = move-exception
            goto Laa
        L41:
            r5 = move-exception
            goto Laa
        L43:
            if (r6 == 0) goto L4e
            android.content.res.AssetManager r6 = r7.getAssets()     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            java.io.InputStream r5 = r6.open(r5)     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            goto L59
        L4e:
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            java.io.File r7 = new java.io.File     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            r7.<init>(r5)     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            r6.<init>(r7)     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            r5 = r6
        L59:
            int r6 = r5.available()     // Catch: java.lang.Throwable -> L9e
            byte[] r7 = new byte[r6]     // Catch: java.lang.Throwable -> L9e
            r5.read(r7, r4, r6)     // Catch: java.lang.Throwable -> L9e
            r5.close()     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            r5 = r7
        L66:
            java.lang.String r6 = new java.lang.String     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            java.lang.String r7 = "UTF-8"
            r6.<init>(r5, r7)     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            r5.<init>()     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            java.lang.String r7 = "Json string from the manifest file: "
            r5.append(r7)     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            r5.append(r6)     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            java.lang.String r5 = r5.toString()     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            r1.d(r2, r5)     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            r5.<init>(r6)     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            java.lang.String r6 = "modelType"
            java.lang.String r6 = r5.getString(r6)     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            java.lang.String r7 = "modelFile"
            java.lang.String r7 = r5.getString(r7)     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            java.lang.String r1 = "labelsFile"
            java.lang.String r5 = r5.getString(r1)     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            com.google.mlkit.common.internal.model.AutoValue_ModelUtils_AutoMLManifest r1 = new com.google.mlkit.common.internal.model.AutoValue_ModelUtils_AutoMLManifest     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            r1.<init>(r6, r7, r5)     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
            return r1
        L9e:
            r6 = move-exception
            if (r5 == 0) goto La9
            r5.close()     // Catch: java.lang.Throwable -> La5
            goto La9
        La5:
            r5 = move-exception
            r6.addSuppressed(r5)     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
        La9:
            throw r6     // Catch: java.io.IOException -> L3f org.json.JSONException -> L41
        Laa:
            com.google.android.gms.common.internal.GmsLogger r6 = com.google.mlkit.common.internal.model.ModelUtils.zza
            java.lang.String r7 = "Error parsing the manifest file."
            r6.e(r2, r7, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.internal.model.ModelUtils.parseManifestFile(java.lang.String, boolean, android.content.Context):com.google.mlkit.common.internal.model.ModelUtils$AutoMLManifest");
    }

    public static boolean zza(@NonNull File file, @NonNull String str) {
        String sha256 = getSHA256(file);
        zza.d("ModelUtils", "Calculated hash value is: ".concat(String.valueOf(sha256)));
        return str.equals(sha256);
    }

    @Nullable
    private static String zzb(Context context, String str, boolean z5) {
        AutoMLManifest parseManifestFile = parseManifestFile(str, z5, context);
        if (parseManifestFile == null) {
            zza.e("ModelUtils", "Failed to parse manifest file.");
            return null;
        }
        return new File(new File(str).getParent(), parseManifestFile.getModelFile()).toString();
    }
}
