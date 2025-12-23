package net.sqlcipher.database;

import android.content.res.AssetFileDescriptor;
import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import net.sqlcipher.Cursor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class SQLiteContentHelper {
    public static AssetFileDescriptor getBlobColumnAsAssetFile(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) throws FileNotFoundException {
        ParcelFileDescriptor parcelFileDescriptor;
        try {
            MemoryFile simpleQueryForBlobMemoryFile = simpleQueryForBlobMemoryFile(sQLiteDatabase, str, strArr);
            if (simpleQueryForBlobMemoryFile != null) {
                try {
                    Method declaredMethod = simpleQueryForBlobMemoryFile.getClass().getDeclaredMethod("getParcelFileDescriptor", null);
                    declaredMethod.setAccessible(true);
                    parcelFileDescriptor = (ParcelFileDescriptor) declaredMethod.invoke(simpleQueryForBlobMemoryFile, null);
                } catch (Exception e6) {
                    e6.toString();
                    parcelFileDescriptor = null;
                }
                return new AssetFileDescriptor(parcelFileDescriptor, 0L, simpleQueryForBlobMemoryFile.length());
            }
            throw new FileNotFoundException("No results.");
        } catch (IOException e7) {
            throw new FileNotFoundException(e7.toString());
        }
    }

    private static MemoryFile simpleQueryForBlobMemoryFile(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) throws IOException {
        Cursor rawQuery = sQLiteDatabase.rawQuery(str, strArr);
        if (rawQuery == null) {
            return null;
        }
        try {
            if (!rawQuery.moveToFirst()) {
                return null;
            }
            byte[] blob = rawQuery.getBlob(0);
            if (blob == null) {
                return null;
            }
            MemoryFile memoryFile = new MemoryFile(null, blob.length);
            memoryFile.writeBytes(blob, 0, 0, blob.length);
            return memoryFile;
        } finally {
            rawQuery.close();
        }
    }
}
