package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
@KeepName
@SafeParcelable.Class(creator = "DataHolderCreator", validate = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {

    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<DataHolder> CREATOR = new zaf();
    private static final Builder zaf = new zab(new String[0], null);

    @SafeParcelable.VersionField(id = 1000)
    final int zaa;
    Bundle zab;
    int[] zac;
    int zad;
    boolean zae;

    @SafeParcelable.Field(getter = "getColumns", id = 1)
    private final String[] zag;

    @SafeParcelable.Field(getter = "getWindows", id = 2)
    private final CursorWindow[] zah;

    @SafeParcelable.Field(getter = "getStatusCode", id = 3)
    private final int zai;

    @Nullable
    @SafeParcelable.Field(getter = "getMetadata", id = 4)
    private final Bundle zaj;
    private boolean zak;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public static class Builder {
        private final String[] zaa;
        private final ArrayList zab = new ArrayList();
        private final HashMap zac = new HashMap();

        @NonNull
        @KeepForSdk
        public DataHolder build(int i6) {
            return new DataHolder(this, i6, (Bundle) null, (zae) (0 == true ? 1 : 0));
        }

        @NonNull
        @KeepForSdk
        public DataHolder build(int i6, @NonNull Bundle bundle) {
            return new DataHolder(this, i6, bundle, -1, (zae) null);
        }

        /* synthetic */ Builder(String[] strArr, String str, zac zacVar) {
            this.zaa = (String[]) Preconditions.checkNotNull(strArr);
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder withRow(@NonNull ContentValues contentValues) {
            Asserts.checkNotNull(contentValues);
            HashMap hashMap = new HashMap(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            return zaa(hashMap);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder zaa(@NonNull HashMap hashMap) {
            Asserts.checkNotNull(hashMap);
            this.zab.add(hashMap);
            return this;
        }
    }

    /* synthetic */ DataHolder(Builder builder, int i6, Bundle bundle, zae zaeVar) {
        this(builder, i6, (Bundle) null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    @KeepForSdk
    public void close() {
        synchronized (this) {
            try {
                if (!this.zae) {
                    this.zae = true;
                    int i6 = 0;
                    while (true) {
                        CursorWindow[] cursorWindowArr = this.zah;
                        if (i6 >= cursorWindowArr.length) {
                            break;
                        }
                        cursorWindowArr[i6].close();
                        i6++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public int getWindowIndex(int i6) {
        int length;
        int i7 = 0;
        Preconditions.checkState(i6 >= 0 && i6 < this.zad);
        while (true) {
            int[] iArr = this.zac;
            length = iArr.length;
            if (i7 >= length) {
                break;
            }
            if (i6 < iArr[i7]) {
                i7--;
                break;
            }
            i7++;
        }
        return i7 == length ? i7 - 1 : i7;
    }

    @KeepForSdk
    public boolean isClosed() {
        boolean z5;
        synchronized (this) {
            z5 = this.zae;
        }
        return z5;
    }

    @SafeParcelable.Constructor
    DataHolder(@SafeParcelable.Param(id = 1000) int i6, @SafeParcelable.Param(id = 1) String[] strArr, @SafeParcelable.Param(id = 2) CursorWindow[] cursorWindowArr, @SafeParcelable.Param(id = 3) int i7, @Nullable @SafeParcelable.Param(id = 4) Bundle bundle) {
        this.zae = false;
        this.zak = true;
        this.zaa = i6;
        this.zag = strArr;
        this.zah = cursorWindowArr;
        this.zai = i7;
        this.zaj = bundle;
    }

    @NonNull
    @KeepForSdk
    public static Builder builder(@NonNull String[] strArr) {
        return new Builder(strArr, null, 0 == true ? 1 : 0);
    }

    @NonNull
    @KeepForSdk
    public static DataHolder empty(int i6) {
        return new DataHolder(zaf, i6, (Bundle) null);
    }

    private final void zae(String str, int i6) {
        Bundle bundle = this.zab;
        if (bundle == null || !bundle.containsKey(str)) {
            throw new IllegalArgumentException("No such column: ".concat(String.valueOf(str)));
        }
        if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i6 < 0 || i6 >= this.zad) {
            throw new CursorIndexOutOfBoundsException(i6, this.zad);
        }
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.zak && this.zah.length > 0 && !isClosed()) {
                close();
            }
        } finally {
            super.finalize();
        }
    }

    @KeepForSdk
    public int getCount() {
        return this.zad;
    }

    @Nullable
    @KeepForSdk
    public Bundle getMetadata() {
        return this.zaj;
    }

    @KeepForSdk
    public int getStatusCode() {
        return this.zai;
    }

    @KeepForSdk
    public boolean hasColumn(@NonNull String str) {
        return this.zab.containsKey(str);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i6) {
        String[] strArr = this.zag;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, strArr, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zah, i6, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zaa);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i6 & 1) != 0) {
            close();
        }
    }

    public final void zad() {
        this.zab = new Bundle();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            String[] strArr = this.zag;
            if (i7 >= strArr.length) {
                break;
            }
            this.zab.putInt(strArr[i7], i7);
            i7++;
        }
        this.zac = new int[this.zah.length];
        int i8 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.zah;
            if (i6 >= cursorWindowArr.length) {
                this.zad = i8;
                return;
            }
            this.zac[i6] = i8;
            i8 += this.zah[i6].getNumRows() - (i8 - cursorWindowArr[i6].getStartPosition());
            i6++;
        }
    }

    @KeepForSdk
    public DataHolder(@NonNull String[] strArr, @NonNull CursorWindow[] cursorWindowArr, int i6, @Nullable Bundle bundle) {
        this.zae = false;
        this.zak = true;
        this.zaa = 1;
        this.zag = (String[]) Preconditions.checkNotNull(strArr);
        this.zah = (CursorWindow[]) Preconditions.checkNotNull(cursorWindowArr);
        this.zai = i6;
        this.zaj = bundle;
        zad();
    }

    private static CursorWindow[] zaf(Builder builder, int i6) {
        long j6;
        if (builder.zaa.length != 0) {
            ArrayList arrayList = builder.zab;
            int size = arrayList.size();
            CursorWindow cursorWindow = new CursorWindow(false);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(cursorWindow);
            cursorWindow.setNumColumns(builder.zaa.length);
            int i7 = 0;
            boolean z5 = false;
            while (i7 < size) {
                try {
                    if (!cursorWindow.allocRow()) {
                        cursorWindow = new CursorWindow(false);
                        cursorWindow.setStartPosition(i7);
                        cursorWindow.setNumColumns(builder.zaa.length);
                        arrayList2.add(cursorWindow);
                        if (!cursorWindow.allocRow()) {
                            arrayList2.remove(cursorWindow);
                            return (CursorWindow[]) arrayList2.toArray(new CursorWindow[arrayList2.size()]);
                        }
                    }
                    Map map = (Map) arrayList.get(i7);
                    int i8 = 0;
                    boolean z6 = true;
                    while (true) {
                        if (i8 < builder.zaa.length) {
                            if (!z6) {
                                break;
                            }
                            String str = builder.zaa[i8];
                            Object obj = map.get(str);
                            if (obj == null) {
                                z6 = cursorWindow.putNull(i7, i8);
                            } else if (obj instanceof String) {
                                z6 = cursorWindow.putString((String) obj, i7, i8);
                            } else if (obj instanceof Long) {
                                z6 = cursorWindow.putLong(((Long) obj).longValue(), i7, i8);
                            } else if (obj instanceof Integer) {
                                z6 = cursorWindow.putLong(((Integer) obj).intValue(), i7, i8);
                            } else if (obj instanceof Boolean) {
                                if (true != ((Boolean) obj).booleanValue()) {
                                    j6 = 0;
                                } else {
                                    j6 = 1;
                                }
                                z6 = cursorWindow.putLong(j6, i7, i8);
                            } else if (obj instanceof byte[]) {
                                z6 = cursorWindow.putBlob((byte[]) obj, i7, i8);
                            } else if (obj instanceof Double) {
                                z6 = cursorWindow.putDouble(((Double) obj).doubleValue(), i7, i8);
                            } else if (obj instanceof Float) {
                                z6 = cursorWindow.putDouble(((Float) obj).floatValue(), i7, i8);
                            } else {
                                throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj.toString());
                            }
                            i8++;
                        } else if (z6) {
                            z5 = false;
                        }
                    }
                    if (!z5) {
                        cursorWindow.freeLastRow();
                        cursorWindow = new CursorWindow(false);
                        cursorWindow.setStartPosition(i7);
                        cursorWindow.setNumColumns(builder.zaa.length);
                        arrayList2.add(cursorWindow);
                        i7--;
                        z5 = true;
                        i7++;
                    } else {
                        throw new zad("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                    }
                } catch (RuntimeException e6) {
                    int size2 = arrayList2.size();
                    for (int i9 = 0; i9 < size2; i9++) {
                        ((CursorWindow) arrayList2.get(i9)).close();
                    }
                    throw e6;
                }
            }
            return (CursorWindow[]) arrayList2.toArray(new CursorWindow[arrayList2.size()]);
        }
        return new CursorWindow[0];
    }

    @KeepForSdk
    public boolean getBoolean(@NonNull String str, int i6, int i7) {
        zae(str, i6);
        if (this.zah[i7].getLong(i6, this.zab.getInt(str)) == 1) {
            return true;
        }
        return false;
    }

    @NonNull
    @KeepForSdk
    public byte[] getByteArray(@NonNull String str, int i6, int i7) {
        zae(str, i6);
        return this.zah[i7].getBlob(i6, this.zab.getInt(str));
    }

    @KeepForSdk
    public int getInteger(@NonNull String str, int i6, int i7) {
        zae(str, i6);
        return this.zah[i7].getInt(i6, this.zab.getInt(str));
    }

    @KeepForSdk
    public long getLong(@NonNull String str, int i6, int i7) {
        zae(str, i6);
        return this.zah[i7].getLong(i6, this.zab.getInt(str));
    }

    @NonNull
    @KeepForSdk
    public String getString(@NonNull String str, int i6, int i7) {
        zae(str, i6);
        return this.zah[i7].getString(i6, this.zab.getInt(str));
    }

    @KeepForSdk
    public boolean hasNull(@NonNull String str, int i6, int i7) {
        zae(str, i6);
        return this.zah[i7].isNull(i6, this.zab.getInt(str));
    }

    public final double zaa(@NonNull String str, int i6, int i7) {
        zae(str, i6);
        return this.zah[i7].getDouble(i6, this.zab.getInt(str));
    }

    public final float zab(@NonNull String str, int i6, int i7) {
        zae(str, i6);
        return this.zah[i7].getFloat(i6, this.zab.getInt(str));
    }

    public final void zac(@NonNull String str, int i6, int i7, @NonNull CharArrayBuffer charArrayBuffer) {
        zae(str, i6);
        this.zah[i7].copyStringToBuffer(i6, this.zab.getInt(str), charArrayBuffer);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DataHolder(@androidx.annotation.NonNull android.database.Cursor r8, int r9, @androidx.annotation.Nullable android.os.Bundle r10) {
        /*
            r7 = this;
            com.google.android.gms.common.sqlite.CursorWrapper r0 = new com.google.android.gms.common.sqlite.CursorWrapper
            r0.<init>(r8)
            java.lang.String[] r8 = r0.getColumnNames()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r0.getCount()     // Catch: java.lang.Throwable -> L2e
            android.database.CursorWindow r3 = r0.getWindow()     // Catch: java.lang.Throwable -> L2e
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L30
            int r6 = r3.getStartPosition()     // Catch: java.lang.Throwable -> L2e
            if (r6 != 0) goto L30
            r3.acquireReference()     // Catch: java.lang.Throwable -> L2e
            r0.setWindow(r4)     // Catch: java.lang.Throwable -> L2e
            r1.add(r3)     // Catch: java.lang.Throwable -> L2e
            int r3 = r3.getNumRows()     // Catch: java.lang.Throwable -> L2e
            goto L31
        L2e:
            r8 = move-exception
            goto L78
        L30:
            r3 = 0
        L31:
            if (r3 >= r2) goto L65
            boolean r6 = r0.moveToPosition(r3)     // Catch: java.lang.Throwable -> L2e
            if (r6 == 0) goto L65
            android.database.CursorWindow r6 = r0.getWindow()     // Catch: java.lang.Throwable -> L2e
            if (r6 == 0) goto L46
            r6.acquireReference()     // Catch: java.lang.Throwable -> L2e
            r0.setWindow(r4)     // Catch: java.lang.Throwable -> L2e
            goto L51
        L46:
            android.database.CursorWindow r6 = new android.database.CursorWindow     // Catch: java.lang.Throwable -> L2e
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L2e
            r6.setStartPosition(r3)     // Catch: java.lang.Throwable -> L2e
            r0.fillWindow(r3, r6)     // Catch: java.lang.Throwable -> L2e
        L51:
            int r3 = r6.getNumRows()     // Catch: java.lang.Throwable -> L2e
            if (r3 != 0) goto L58
            goto L65
        L58:
            r1.add(r6)     // Catch: java.lang.Throwable -> L2e
            int r3 = r6.getStartPosition()     // Catch: java.lang.Throwable -> L2e
            int r6 = r6.getNumRows()     // Catch: java.lang.Throwable -> L2e
            int r3 = r3 + r6
            goto L31
        L65:
            r0.close()
            int r0 = r1.size()
            android.database.CursorWindow[] r0 = new android.database.CursorWindow[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            android.database.CursorWindow[] r0 = (android.database.CursorWindow[]) r0
            r7.<init>(r8, r0, r9, r10)
            return
        L78:
            r0.close()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.DataHolder.<init>(android.database.Cursor, int, android.os.Bundle):void");
    }

    private DataHolder(Builder builder, int i6, @Nullable Bundle bundle) {
        this(builder.zaa, zaf(builder, -1), i6, (Bundle) null);
    }

    /* synthetic */ DataHolder(Builder builder, int i6, Bundle bundle, int i7, zae zaeVar) {
        this(builder.zaa, zaf(builder, -1), i6, bundle);
    }
}
