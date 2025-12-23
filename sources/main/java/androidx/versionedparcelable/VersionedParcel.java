package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class VersionedParcel {
    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_NETWORK_MAIN_THREAD = -6;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_PARCELABLE = -9;
    private static final int EX_SECURITY = -1;
    private static final int EX_UNSUPPORTED_OPERATION = -7;
    private static final String TAG = "VersionedParcel";
    private static final int TYPE_BINDER = 5;
    private static final int TYPE_FLOAT = 8;
    private static final int TYPE_INTEGER = 7;
    private static final int TYPE_PARCELABLE = 2;
    private static final int TYPE_SERIALIZABLE = 3;
    private static final int TYPE_STRING = 4;
    private static final int TYPE_VERSIONED_PARCELABLE = 1;
    protected final ArrayMap<String, Class> mParcelizerCache;
    protected final ArrayMap<String, Method> mReadCache;
    protected final ArrayMap<String, Method> mWriteCache;

    private <T> void writeCollection(Collection<T> collection, int i6) {
        setOutputField(i6);
        writeCollection(collection);
    }

    protected abstract void closeField();

    protected abstract VersionedParcel createSubParcel();

    public boolean isStream() {
        return false;
    }

    public <T> T[] readArray(T[] tArr, int i6) {
        return !readField(i6) ? tArr : (T[]) readArray(tArr);
    }

    protected abstract boolean readBoolean();

    public boolean readBoolean(boolean z5, int i6) {
        return !readField(i6) ? z5 : readBoolean();
    }

    public boolean[] readBooleanArray(boolean[] zArr, int i6) {
        return !readField(i6) ? zArr : readBooleanArray();
    }

    protected abstract Bundle readBundle();

    public Bundle readBundle(Bundle bundle, int i6) {
        return !readField(i6) ? bundle : readBundle();
    }

    protected abstract byte[] readByteArray();

    public byte[] readByteArray(byte[] bArr, int i6) {
        return !readField(i6) ? bArr : readByteArray();
    }

    protected abstract CharSequence readCharSequence();

    public CharSequence readCharSequence(CharSequence charSequence, int i6) {
        return !readField(i6) ? charSequence : readCharSequence();
    }

    protected abstract double readDouble();

    public double readDouble(double d6, int i6) {
        return !readField(i6) ? d6 : readDouble();
    }

    public double[] readDoubleArray(double[] dArr, int i6) {
        return !readField(i6) ? dArr : readDoubleArray();
    }

    public Exception readException(Exception exc, int i6) {
        int readExceptionCode;
        return (readField(i6) && (readExceptionCode = readExceptionCode()) != 0) ? readException(readExceptionCode, readString()) : exc;
    }

    protected abstract boolean readField(int i6);

    protected abstract float readFloat();

    public float readFloat(float f6, int i6) {
        return !readField(i6) ? f6 : readFloat();
    }

    public float[] readFloatArray(float[] fArr, int i6) {
        return !readField(i6) ? fArr : readFloatArray();
    }

    protected abstract int readInt();

    public int readInt(int i6, int i7) {
        return !readField(i7) ? i6 : readInt();
    }

    public int[] readIntArray(int[] iArr, int i6) {
        return !readField(i6) ? iArr : readIntArray();
    }

    protected abstract long readLong();

    public long readLong(long j6, int i6) {
        return !readField(i6) ? j6 : readLong();
    }

    public long[] readLongArray(long[] jArr, int i6) {
        return !readField(i6) ? jArr : readLongArray();
    }

    protected abstract <T extends Parcelable> T readParcelable();

    public <T extends Parcelable> T readParcelable(T t5, int i6) {
        return !readField(i6) ? t5 : (T) readParcelable();
    }

    protected abstract String readString();

    public String readString(String str, int i6) {
        return !readField(i6) ? str : readString();
    }

    protected abstract IBinder readStrongBinder();

    public IBinder readStrongBinder(IBinder iBinder, int i6) {
        return !readField(i6) ? iBinder : readStrongBinder();
    }

    public <T extends VersionedParcelable> T readVersionedParcelable(T t5, int i6) {
        return !readField(i6) ? t5 : (T) readVersionedParcelable();
    }

    protected abstract void setOutputField(int i6);

    public <T> void writeArray(T[] tArr, int i6) {
        setOutputField(i6);
        writeArray(tArr);
    }

    protected abstract void writeBoolean(boolean z5);

    public void writeBoolean(boolean z5, int i6) {
        setOutputField(i6);
        writeBoolean(z5);
    }

    public void writeBooleanArray(boolean[] zArr, int i6) {
        setOutputField(i6);
        writeBooleanArray(zArr);
    }

    protected abstract void writeBundle(Bundle bundle);

    public void writeBundle(Bundle bundle, int i6) {
        setOutputField(i6);
        writeBundle(bundle);
    }

    protected abstract void writeByteArray(byte[] bArr);

    public void writeByteArray(byte[] bArr, int i6) {
        setOutputField(i6);
        writeByteArray(bArr);
    }

    protected abstract void writeByteArray(byte[] bArr, int i6, int i7);

    protected abstract void writeCharSequence(CharSequence charSequence);

    public void writeCharSequence(CharSequence charSequence, int i6) {
        setOutputField(i6);
        writeCharSequence(charSequence);
    }

    protected abstract void writeDouble(double d6);

    public void writeDouble(double d6, int i6) {
        setOutputField(i6);
        writeDouble(d6);
    }

    public void writeDoubleArray(double[] dArr, int i6) {
        setOutputField(i6);
        writeDoubleArray(dArr);
    }

    protected abstract void writeFloat(float f6);

    public void writeFloat(float f6, int i6) {
        setOutputField(i6);
        writeFloat(f6);
    }

    public void writeFloatArray(float[] fArr, int i6) {
        setOutputField(i6);
        writeFloatArray(fArr);
    }

    protected abstract void writeInt(int i6);

    public void writeInt(int i6, int i7) {
        setOutputField(i7);
        writeInt(i6);
    }

    public void writeIntArray(int[] iArr, int i6) {
        setOutputField(i6);
        writeIntArray(iArr);
    }

    protected abstract void writeLong(long j6);

    public void writeLong(long j6, int i6) {
        setOutputField(i6);
        writeLong(j6);
    }

    public void writeLongArray(long[] jArr, int i6) {
        setOutputField(i6);
        writeLongArray(jArr);
    }

    protected void writeNoException() {
        writeInt(0);
    }

    protected abstract void writeParcelable(Parcelable parcelable);

    public void writeParcelable(Parcelable parcelable, int i6) {
        setOutputField(i6);
        writeParcelable(parcelable);
    }

    public void writeSerializable(Serializable serializable, int i6) {
        setOutputField(i6);
        writeSerializable(serializable);
    }

    protected abstract void writeString(String str);

    public void writeString(String str, int i6) {
        setOutputField(i6);
        writeString(str);
    }

    protected abstract void writeStrongBinder(IBinder iBinder);

    public void writeStrongBinder(IBinder iBinder, int i6) {
        setOutputField(i6);
        writeStrongBinder(iBinder);
    }

    protected abstract void writeStrongInterface(IInterface iInterface);

    public void writeStrongInterface(IInterface iInterface, int i6) {
        setOutputField(i6);
        writeStrongInterface(iInterface);
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable, int i6) {
        setOutputField(i6);
        writeVersionedParcelable(versionedParcelable);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th) {
            super(th);
        }
    }

    private Class findParcelClass(Class<? extends VersionedParcelable> cls) throws ClassNotFoundException {
        Class cls2 = this.mParcelizerCache.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.mParcelizerCache.put(cls.getName(), cls3);
        return cls3;
    }

    private Method getReadMethod(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.mReadCache.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
        this.mReadCache.put(str, declaredMethod);
        return declaredMethod;
    }

    private <T> int getType(T t5) {
        if (t5 instanceof String) {
            return 4;
        }
        if (t5 instanceof Parcelable) {
            return 2;
        }
        if (t5 instanceof VersionedParcelable) {
            return 1;
        }
        if (t5 instanceof Serializable) {
            return 3;
        }
        if (t5 instanceof IBinder) {
            return 5;
        }
        if (t5 instanceof Integer) {
            return 7;
        }
        if (t5 instanceof Float) {
            return 8;
        }
        throw new IllegalArgumentException(t5.getClass().getName() + " cannot be VersionedParcelled");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method getWriteMethod(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.mWriteCache.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class findParcelClass = findParcelClass(cls);
        System.currentTimeMillis();
        Method declaredMethod = findParcelClass.getDeclaredMethod("write", cls, VersionedParcel.class);
        this.mWriteCache.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    protected Serializable readSerializable() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        try {
            return (Serializable) new ObjectInputStream(new ByteArrayInputStream(readByteArray())) { // from class: androidx.versionedparcelable.VersionedParcel.1
                @Override // java.io.ObjectInputStream
                protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
                    Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
                    if (cls != null) {
                        return cls;
                    }
                    return super.resolveClass(objectStreamClass);
                }
            }.readObject();
        } catch (IOException e6) {
            throw new RuntimeException("VersionedParcelable encountered IOException reading a Serializable object (name = " + readString + ")", e6);
        } catch (ClassNotFoundException e7) {
            throw new RuntimeException("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = " + readString + ")", e7);
        }
    }

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.mReadCache = arrayMap;
        this.mWriteCache = arrayMap2;
        this.mParcelizerCache = arrayMap3;
    }

    private Exception createException(int i6, String str) {
        switch (i6) {
            case -9:
                return (Exception) readParcelable();
            case -8:
            default:
                return new RuntimeException("Unknown exception code: " + i6 + " msg " + str);
            case -7:
                return new UnsupportedOperationException(str);
            case -6:
                return new NetworkOnMainThreadException();
            case -5:
                return new IllegalStateException(str);
            case -4:
                return new NullPointerException(str);
            case -3:
                return new IllegalArgumentException(str);
            case -2:
                return new BadParcelableException(str);
            case -1:
                return new SecurityException(str);
        }
    }

    @NonNull
    protected static Throwable getRootCause(@NonNull Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    private <T, S extends Collection<T>> S readCollection(S s5) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 != 1) {
                if (readInt2 != 2) {
                    if (readInt2 != 3) {
                        if (readInt2 != 4) {
                            if (readInt2 == 5) {
                                while (readInt > 0) {
                                    s5.add(readStrongBinder());
                                    readInt--;
                                }
                            }
                        } else {
                            while (readInt > 0) {
                                s5.add(readString());
                                readInt--;
                            }
                        }
                    } else {
                        while (readInt > 0) {
                            s5.add(readSerializable());
                            readInt--;
                        }
                    }
                } else {
                    while (readInt > 0) {
                        s5.add(readParcelable());
                        readInt--;
                    }
                }
            } else {
                while (readInt > 0) {
                    s5.add(readVersionedParcelable());
                    readInt--;
                }
            }
        }
        return s5;
    }

    private int readExceptionCode() {
        return readInt();
    }

    private <T> void writeCollection(Collection<T> collection) {
        if (collection == null) {
            writeInt(-1);
        }
        int size = collection.size();
        writeInt(size);
        if (size > 0) {
            int type = getType(collection.iterator().next());
            writeInt(type);
            switch (type) {
                case 1:
                    Iterator<T> it = collection.iterator();
                    while (it.hasNext()) {
                        writeVersionedParcelable((VersionedParcelable) it.next());
                    }
                    break;
                case 2:
                    Iterator<T> it2 = collection.iterator();
                    while (it2.hasNext()) {
                        writeParcelable((Parcelable) it2.next());
                    }
                    break;
                case 3:
                    Iterator<T> it3 = collection.iterator();
                    while (it3.hasNext()) {
                        writeSerializable((Serializable) it3.next());
                    }
                    break;
                case 4:
                    Iterator<T> it4 = collection.iterator();
                    while (it4.hasNext()) {
                        writeString((String) it4.next());
                    }
                    break;
                case 5:
                    Iterator<T> it5 = collection.iterator();
                    while (it5.hasNext()) {
                        writeStrongBinder((IBinder) it5.next());
                    }
                    break;
                case 7:
                    Iterator<T> it6 = collection.iterator();
                    while (it6.hasNext()) {
                        writeInt(((Integer) it6.next()).intValue());
                    }
                    break;
                case 8:
                    Iterator<T> it7 = collection.iterator();
                    while (it7.hasNext()) {
                        writeFloat(((Float) it7.next()).floatValue());
                    }
                    break;
            }
        }
    }

    private void writeSerializable(Serializable serializable) {
        if (serializable == null) {
            writeString(null);
            return;
        }
        String name = serializable.getClass().getName();
        writeString(name);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            writeByteArray(byteArrayOutputStream.toByteArray());
        } catch (IOException e6) {
            throw new RuntimeException("VersionedParcelable encountered IOException writing serializable object (name = " + name + ")", e6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeVersionedParcelableCreator(VersionedParcelable versionedParcelable) {
        try {
            writeString(findParcelClass(versionedParcelable.getClass()).getName());
        } catch (ClassNotFoundException e6) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName() + " does not have a Parcelizer", e6);
        }
    }

    protected <T> T[] readArray(T[] tArr) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(readInt);
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 == 1) {
                while (readInt > 0) {
                    arrayList.add(readVersionedParcelable());
                    readInt--;
                }
            } else if (readInt2 == 2) {
                while (readInt > 0) {
                    arrayList.add(readParcelable());
                    readInt--;
                }
            } else if (readInt2 == 3) {
                while (readInt > 0) {
                    arrayList.add(readSerializable());
                    readInt--;
                }
            } else if (readInt2 == 4) {
                while (readInt > 0) {
                    arrayList.add(readString());
                    readInt--;
                }
            } else if (readInt2 == 5) {
                while (readInt > 0) {
                    arrayList.add(readStrongBinder());
                    readInt--;
                }
            }
        }
        return (T[]) arrayList.toArray(tArr);
    }

    protected boolean[] readBooleanArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        boolean[] zArr = new boolean[readInt];
        for (int i6 = 0; i6 < readInt; i6++) {
            zArr[i6] = readInt() != 0;
        }
        return zArr;
    }

    public byte readByte(byte b6, int i6) {
        if (!readField(i6)) {
            return b6;
        }
        return (byte) (readInt() & 255);
    }

    public char[] readCharArray(char[] cArr, int i6) {
        if (!readField(i6)) {
            return cArr;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        char[] cArr2 = new char[readInt];
        for (int i7 = 0; i7 < readInt; i7++) {
            cArr2[i7] = (char) readInt();
        }
        return cArr2;
    }

    protected double[] readDoubleArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        double[] dArr = new double[readInt];
        for (int i6 = 0; i6 < readInt; i6++) {
            dArr[i6] = readDouble();
        }
        return dArr;
    }

    protected float[] readFloatArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        float[] fArr = new float[readInt];
        for (int i6 = 0; i6 < readInt; i6++) {
            fArr[i6] = readFloat();
        }
        return fArr;
    }

    protected <T extends VersionedParcelable> T readFromParcel(String str, VersionedParcel versionedParcel) {
        try {
            return (T) getReadMethod(str).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e6) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e6);
        } catch (IllegalAccessException e7) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e7);
        } catch (NoSuchMethodException e8) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e8);
        } catch (InvocationTargetException e9) {
            if (e9.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e9.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e9);
        }
    }

    protected int[] readIntArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        int[] iArr = new int[readInt];
        for (int i6 = 0; i6 < readInt; i6++) {
            iArr[i6] = readInt();
        }
        return iArr;
    }

    public <T> List<T> readList(List<T> list, int i6) {
        if (!readField(i6)) {
            return list;
        }
        return (List) readCollection(new ArrayList());
    }

    protected long[] readLongArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        long[] jArr = new long[readInt];
        for (int i6 = 0; i6 < readInt; i6++) {
            jArr[i6] = readLong();
        }
        return jArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> Map<K, V> readMap(Map<K, V> map, int i6) {
        if (!readField(i6)) {
            return map;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayMap arrayMap = new ArrayMap();
        if (readInt != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            readCollection(arrayList);
            readCollection(arrayList2);
            for (int i7 = 0; i7 < readInt; i7++) {
                arrayMap.put(arrayList.get(i7), arrayList2.get(i7));
            }
        }
        return arrayMap;
    }

    public <T> Set<T> readSet(Set<T> set, int i6) {
        if (!readField(i6)) {
            return set;
        }
        return (Set) readCollection(new ArraySet());
    }

    @RequiresApi(api = 21)
    public Size readSize(Size size, int i6) {
        if (!readField(i6)) {
            return size;
        }
        if (readBoolean()) {
            return new Size(readInt(), readInt());
        }
        return null;
    }

    @RequiresApi(api = 21)
    public SizeF readSizeF(SizeF sizeF, int i6) {
        if (!readField(i6)) {
            return sizeF;
        }
        if (readBoolean()) {
            return new SizeF(readFloat(), readFloat());
        }
        return null;
    }

    public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i6) {
        if (!readField(i6)) {
            return sparseBooleanArray;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(readInt);
        for (int i7 = 0; i7 < readInt; i7++) {
            sparseBooleanArray2.put(readInt(), readBoolean());
        }
        return sparseBooleanArray2;
    }

    protected <T extends VersionedParcelable> T readVersionedParcelable() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        return (T) readFromParcel(readString, createSubParcel());
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <T> void writeArray(T[] tArr) {
        if (tArr == 0) {
            writeInt(-1);
            return;
        }
        int length = tArr.length;
        writeInt(length);
        if (length > 0) {
            int i6 = 0;
            int type = getType(tArr[0]);
            writeInt(type);
            if (type == 1) {
                while (i6 < length) {
                    writeVersionedParcelable((VersionedParcelable) tArr[i6]);
                    i6++;
                }
                return;
            }
            if (type == 2) {
                while (i6 < length) {
                    writeParcelable((Parcelable) tArr[i6]);
                    i6++;
                }
                return;
            }
            if (type == 3) {
                while (i6 < length) {
                    writeSerializable((Serializable) tArr[i6]);
                    i6++;
                }
            } else if (type == 4) {
                while (i6 < length) {
                    writeString((String) tArr[i6]);
                    i6++;
                }
            } else {
                if (type != 5) {
                    return;
                }
                while (i6 < length) {
                    writeStrongBinder((IBinder) tArr[i6]);
                    i6++;
                }
            }
        }
    }

    protected void writeBooleanArray(boolean[] zArr) {
        if (zArr != null) {
            writeInt(zArr.length);
            for (boolean z5 : zArr) {
                writeInt(z5 ? 1 : 0);
            }
            return;
        }
        writeInt(-1);
    }

    public void writeByte(byte b6, int i6) {
        setOutputField(i6);
        writeInt(b6);
    }

    public void writeByteArray(byte[] bArr, int i6, int i7, int i8) {
        setOutputField(i8);
        writeByteArray(bArr, i6, i7);
    }

    public void writeCharArray(char[] cArr, int i6) {
        setOutputField(i6);
        if (cArr != null) {
            writeInt(cArr.length);
            for (char c6 : cArr) {
                writeInt(c6);
            }
            return;
        }
        writeInt(-1);
    }

    protected void writeDoubleArray(double[] dArr) {
        if (dArr != null) {
            writeInt(dArr.length);
            for (double d6 : dArr) {
                writeDouble(d6);
            }
            return;
        }
        writeInt(-1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void writeException(Exception exc, int i6) {
        int i7;
        setOutputField(i6);
        if (exc == 0) {
            writeNoException();
            return;
        }
        if ((exc instanceof Parcelable) && exc.getClass().getClassLoader() == Parcelable.class.getClassLoader()) {
            i7 = -9;
        } else if (exc instanceof SecurityException) {
            i7 = -1;
        } else if (exc instanceof BadParcelableException) {
            i7 = -2;
        } else if (exc instanceof IllegalArgumentException) {
            i7 = -3;
        } else if (exc instanceof NullPointerException) {
            i7 = -4;
        } else if (exc instanceof IllegalStateException) {
            i7 = -5;
        } else if (exc instanceof NetworkOnMainThreadException) {
            i7 = -6;
        } else if (exc instanceof UnsupportedOperationException) {
            i7 = -7;
        } else {
            i7 = 0;
        }
        writeInt(i7);
        if (i7 == 0) {
            if (exc instanceof RuntimeException) {
                throw ((RuntimeException) exc);
            }
            throw new RuntimeException(exc);
        }
        writeString(exc.getMessage());
        if (i7 != -9) {
            return;
        }
        writeParcelable((Parcelable) exc);
    }

    protected void writeFloatArray(float[] fArr) {
        if (fArr != null) {
            writeInt(fArr.length);
            for (float f6 : fArr) {
                writeFloat(f6);
            }
            return;
        }
        writeInt(-1);
    }

    protected void writeIntArray(int[] iArr) {
        if (iArr != null) {
            writeInt(iArr.length);
            for (int i6 : iArr) {
                writeInt(i6);
            }
            return;
        }
        writeInt(-1);
    }

    public <T> void writeList(List<T> list, int i6) {
        writeCollection(list, i6);
    }

    protected void writeLongArray(long[] jArr) {
        if (jArr != null) {
            writeInt(jArr.length);
            for (long j6 : jArr) {
                writeLong(j6);
            }
            return;
        }
        writeInt(-1);
    }

    public <K, V> void writeMap(Map<K, V> map, int i6) {
        setOutputField(i6);
        if (map == null) {
            writeInt(-1);
            return;
        }
        int size = map.size();
        writeInt(size);
        if (size == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        writeCollection(arrayList);
        writeCollection(arrayList2);
    }

    public <T> void writeSet(Set<T> set, int i6) {
        writeCollection(set, i6);
    }

    @RequiresApi(api = 21)
    public void writeSize(Size size, int i6) {
        boolean z5;
        setOutputField(i6);
        if (size != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        writeBoolean(z5);
        if (size != null) {
            writeInt(size.getWidth());
            writeInt(size.getHeight());
        }
    }

    @RequiresApi(api = 21)
    public void writeSizeF(SizeF sizeF, int i6) {
        boolean z5;
        setOutputField(i6);
        if (sizeF != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        writeBoolean(z5);
        if (sizeF != null) {
            writeFloat(sizeF.getWidth());
            writeFloat(sizeF.getHeight());
        }
    }

    public void writeSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i6) {
        setOutputField(i6);
        if (sparseBooleanArray == null) {
            writeInt(-1);
            return;
        }
        int size = sparseBooleanArray.size();
        writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            writeInt(sparseBooleanArray.keyAt(i7));
            writeBoolean(sparseBooleanArray.valueAt(i7));
        }
    }

    protected <T extends VersionedParcelable> void writeToParcel(T t5, VersionedParcel versionedParcel) {
        try {
            getWriteMethod(t5.getClass()).invoke(null, t5, versionedParcel);
        } catch (ClassNotFoundException e6) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e6);
        } catch (IllegalAccessException e7) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e7);
        } catch (NoSuchMethodException e8) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e8);
        } catch (InvocationTargetException e9) {
            if (e9.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e9.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e9);
        }
    }

    protected void writeVersionedParcelable(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            writeString(null);
            return;
        }
        writeVersionedParcelableCreator(versionedParcelable);
        VersionedParcel createSubParcel = createSubParcel();
        writeToParcel(versionedParcelable, createSubParcel);
        createSubParcel.closeField();
    }

    private Exception readException(int i6, String str) {
        return createException(i6, str);
    }

    public void setSerializationFlags(boolean z5, boolean z6) {
    }
}
