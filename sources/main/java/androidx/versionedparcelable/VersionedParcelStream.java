package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.versionedparcelable.VersionedParcel;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
class VersionedParcelStream extends VersionedParcel {
    private static final int TYPE_BOOLEAN = 5;
    private static final int TYPE_BOOLEAN_ARRAY = 6;
    private static final int TYPE_DOUBLE = 7;
    private static final int TYPE_DOUBLE_ARRAY = 8;
    private static final int TYPE_FLOAT = 13;
    private static final int TYPE_FLOAT_ARRAY = 14;
    private static final int TYPE_INT = 9;
    private static final int TYPE_INT_ARRAY = 10;
    private static final int TYPE_LONG = 11;
    private static final int TYPE_LONG_ARRAY = 12;
    private static final int TYPE_NULL = 0;
    private static final int TYPE_STRING = 3;
    private static final int TYPE_STRING_ARRAY = 4;
    private static final int TYPE_SUB_BUNDLE = 1;
    private static final int TYPE_SUB_PERSISTABLE_BUNDLE = 2;
    private static final Charset UTF_16 = Charset.forName("UTF-16");
    int mCount;
    private DataInputStream mCurrentInput;
    private DataOutputStream mCurrentOutput;
    private FieldBuffer mFieldBuffer;
    private int mFieldId;
    int mFieldSize;
    private boolean mIgnoreParcelables;
    private final DataInputStream mMasterInput;
    private final DataOutputStream mMasterOutput;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class FieldBuffer {
        final DataOutputStream mDataStream;
        private final int mFieldId;
        final ByteArrayOutputStream mOutput;
        private final DataOutputStream mTarget;

        void flushField() throws IOException {
            this.mDataStream.flush();
            int size = this.mOutput.size();
            this.mTarget.writeInt((this.mFieldId << 16) | (size >= 65535 ? 65535 : size));
            if (size >= 65535) {
                this.mTarget.writeInt(size);
            }
            this.mOutput.writeTo(this.mTarget);
        }

        FieldBuffer(int i6, DataOutputStream dataOutputStream) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.mOutput = byteArrayOutputStream;
            this.mDataStream = new DataOutputStream(byteArrayOutputStream);
            this.mFieldId = i6;
            this.mTarget = dataOutputStream;
        }
    }

    public VersionedParcelStream(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean isStream() {
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected CharSequence readCharSequence() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readField(int i6) {
        while (true) {
            try {
                int i7 = this.mFieldId;
                if (i7 == i6) {
                    return true;
                }
                if (String.valueOf(i7).compareTo(String.valueOf(i6)) > 0) {
                    return false;
                }
                if (this.mCount < this.mFieldSize) {
                    this.mMasterInput.skip(r2 - r1);
                }
                this.mFieldSize = -1;
                int readInt = this.mMasterInput.readInt();
                this.mCount = 0;
                int i8 = readInt & 65535;
                if (i8 == 65535) {
                    i8 = this.mMasterInput.readInt();
                }
                this.mFieldId = (readInt >> 16) & 65535;
                this.mFieldSize = i8;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T readParcelable() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public IBinder readStrongBinder() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr) {
        try {
            if (bArr == null) {
                this.mCurrentOutput.writeInt(-1);
            } else {
                this.mCurrentOutput.writeInt(bArr.length);
                this.mCurrentOutput.write(bArr);
            }
        } catch (IOException e6) {
            throw new VersionedParcel.ParcelException(e6);
        }
    }

    private VersionedParcelStream(InputStream inputStream, OutputStream outputStream, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.mCount = 0;
        this.mFieldId = -1;
        this.mFieldSize = -1;
        DataInputStream dataInputStream = inputStream != null ? new DataInputStream(new FilterInputStream(inputStream) { // from class: androidx.versionedparcelable.VersionedParcelStream.1
            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i6 = versionedParcelStream.mFieldSize;
                if (i6 != -1 && versionedParcelStream.mCount >= i6) {
                    throw new IOException();
                }
                int read = super.read();
                VersionedParcelStream.this.mCount++;
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j6) throws IOException {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i6 = versionedParcelStream.mFieldSize;
                if (i6 != -1 && versionedParcelStream.mCount >= i6) {
                    throw new IOException();
                }
                long skip = super.skip(j6);
                if (skip > 0) {
                    VersionedParcelStream.this.mCount += (int) skip;
                }
                return skip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i6, int i7) throws IOException {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i8 = versionedParcelStream.mFieldSize;
                if (i8 != -1 && versionedParcelStream.mCount >= i8) {
                    throw new IOException();
                }
                int read = super.read(bArr, i6, i7);
                if (read > 0) {
                    VersionedParcelStream.this.mCount += read;
                }
                return read;
            }
        }) : null;
        this.mMasterInput = dataInputStream;
        DataOutputStream dataOutputStream = outputStream != null ? new DataOutputStream(outputStream) : null;
        this.mMasterOutput = dataOutputStream;
        this.mCurrentInput = dataInputStream;
        this.mCurrentOutput = dataOutputStream;
    }

    private void writeObject(Object obj) {
        if (obj == null) {
            writeInt(0);
            return;
        }
        if (obj instanceof Bundle) {
            writeInt(1);
            writeBundle((Bundle) obj);
            return;
        }
        if (obj instanceof String) {
            writeInt(3);
            writeString((String) obj);
            return;
        }
        if (obj instanceof String[]) {
            writeInt(4);
            writeArray((String[]) obj);
            return;
        }
        if (obj instanceof Boolean) {
            writeInt(5);
            writeBoolean(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof boolean[]) {
            writeInt(6);
            writeBooleanArray((boolean[]) obj);
            return;
        }
        if (obj instanceof Double) {
            writeInt(7);
            writeDouble(((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof double[]) {
            writeInt(8);
            writeDoubleArray((double[]) obj);
            return;
        }
        if (obj instanceof Integer) {
            writeInt(9);
            writeInt(((Integer) obj).intValue());
            return;
        }
        if (obj instanceof int[]) {
            writeInt(10);
            writeIntArray((int[]) obj);
            return;
        }
        if (obj instanceof Long) {
            writeInt(11);
            writeLong(((Long) obj).longValue());
            return;
        }
        if (obj instanceof long[]) {
            writeInt(12);
            writeLongArray((long[]) obj);
            return;
        }
        if (obj instanceof Float) {
            writeInt(13);
            writeFloat(((Float) obj).floatValue());
        } else if (obj instanceof float[]) {
            writeInt(14);
            writeFloatArray((float[]) obj);
        } else {
            throw new IllegalArgumentException("Unsupported type " + obj.getClass());
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        FieldBuffer fieldBuffer = this.mFieldBuffer;
        if (fieldBuffer != null) {
            try {
                if (fieldBuffer.mOutput.size() != 0) {
                    this.mFieldBuffer.flushField();
                }
                this.mFieldBuffer = null;
            } catch (IOException e6) {
                throw new VersionedParcel.ParcelException(e6);
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected VersionedParcel createSubParcel() {
        return new VersionedParcelStream(this.mCurrentInput, this.mCurrentOutput, this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readBoolean() {
        try {
            return this.mCurrentInput.readBoolean();
        } catch (IOException e6) {
            throw new VersionedParcel.ParcelException(e6);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() {
        try {
            int readInt = this.mCurrentInput.readInt();
            if (readInt <= 0) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.mCurrentInput.readFully(bArr);
            return bArr;
        } catch (IOException e6) {
            throw new VersionedParcel.ParcelException(e6);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double readDouble() {
        try {
            return this.mCurrentInput.readDouble();
        } catch (IOException e6) {
            throw new VersionedParcel.ParcelException(e6);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public float readFloat() {
        try {
            return this.mCurrentInput.readFloat();
        } catch (IOException e6) {
            throw new VersionedParcel.ParcelException(e6);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int readInt() {
        try {
            return this.mCurrentInput.readInt();
        } catch (IOException e6) {
            throw new VersionedParcel.ParcelException(e6);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public long readLong() {
        try {
            return this.mCurrentInput.readLong();
        } catch (IOException e6) {
            throw new VersionedParcel.ParcelException(e6);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String readString() {
        try {
            int readInt = this.mCurrentInput.readInt();
            if (readInt <= 0) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.mCurrentInput.readFully(bArr);
            return new String(bArr, UTF_16);
        } catch (IOException e6) {
            throw new VersionedParcel.ParcelException(e6);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setSerializationFlags(boolean z5, boolean z6) {
        if (!z5) {
            throw new RuntimeException("Serialization of this object is not allowed");
        }
        this.mIgnoreParcelables = z6;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean z5) {
        try {
            this.mCurrentOutput.writeBoolean(z5);
        } catch (IOException e6) {
            throw new VersionedParcel.ParcelException(e6);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(Bundle bundle) {
        try {
            if (bundle == null) {
                this.mCurrentOutput.writeInt(-1);
                return;
            }
            Set<String> keySet = bundle.keySet();
            this.mCurrentOutput.writeInt(keySet.size());
            for (String str : keySet) {
                writeString(str);
                writeObject(bundle.get(str));
            }
        } catch (IOException e6) {
            throw new VersionedParcel.ParcelException(e6);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected void writeCharSequence(CharSequence charSequence) {
        if (!this.mIgnoreParcelables) {
            throw new RuntimeException("CharSequence cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double d6) {
        try {
            this.mCurrentOutput.writeDouble(d6);
        } catch (IOException e6) {
            throw new VersionedParcel.ParcelException(e6);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float f6) {
        try {
            this.mCurrentOutput.writeFloat(f6);
        } catch (IOException e6) {
            throw new VersionedParcel.ParcelException(e6);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int i6) {
        try {
            this.mCurrentOutput.writeInt(i6);
        } catch (IOException e6) {
            throw new VersionedParcel.ParcelException(e6);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long j6) {
        try {
            this.mCurrentOutput.writeLong(j6);
        } catch (IOException e6) {
            throw new VersionedParcel.ParcelException(e6);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable parcelable) {
        if (!this.mIgnoreParcelables) {
            throw new RuntimeException("Parcelables cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String str) {
        try {
            if (str == null) {
                this.mCurrentOutput.writeInt(-1);
                return;
            }
            byte[] bytes = str.getBytes(UTF_16);
            this.mCurrentOutput.writeInt(bytes.length);
            this.mCurrentOutput.write(bytes);
        } catch (IOException e6) {
            throw new VersionedParcel.ParcelException(e6);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(IBinder iBinder) {
        if (!this.mIgnoreParcelables) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(IInterface iInterface) {
        if (!this.mIgnoreParcelables) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    private void readObject(int i6, String str, Bundle bundle) {
        switch (i6) {
            case 0:
                bundle.putParcelable(str, null);
                return;
            case 1:
                bundle.putBundle(str, readBundle());
                return;
            case 2:
                bundle.putBundle(str, readBundle());
                return;
            case 3:
                bundle.putString(str, readString());
                return;
            case 4:
                bundle.putStringArray(str, (String[]) readArray(new String[0]));
                return;
            case 5:
                bundle.putBoolean(str, readBoolean());
                return;
            case 6:
                bundle.putBooleanArray(str, readBooleanArray());
                return;
            case 7:
                bundle.putDouble(str, readDouble());
                return;
            case 8:
                bundle.putDoubleArray(str, readDoubleArray());
                return;
            case 9:
                bundle.putInt(str, readInt());
                return;
            case 10:
                bundle.putIntArray(str, readIntArray());
                return;
            case 11:
                bundle.putLong(str, readLong());
                return;
            case 12:
                bundle.putLongArray(str, readLongArray());
                return;
            case 13:
                bundle.putFloat(str, readFloat());
                return;
            case 14:
                bundle.putFloatArray(str, readFloatArray());
                return;
            default:
                throw new RuntimeException("Unknown type " + i6);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Bundle readBundle() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (int i6 = 0; i6 < readInt; i6++) {
            readObject(readInt(), readString(), bundle);
        }
        return bundle;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setOutputField(int i6) {
        closeField();
        FieldBuffer fieldBuffer = new FieldBuffer(i6, this.mMasterOutput);
        this.mFieldBuffer = fieldBuffer;
        this.mCurrentOutput = fieldBuffer.mDataStream;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr, int i6, int i7) {
        try {
            if (bArr != null) {
                this.mCurrentOutput.writeInt(i7);
                this.mCurrentOutput.write(bArr, i6, i7);
            } else {
                this.mCurrentOutput.writeInt(-1);
            }
        } catch (IOException e6) {
            throw new VersionedParcel.ParcelException(e6);
        }
    }
}
