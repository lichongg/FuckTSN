package net.sqlcipher;

import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class MatrixCursor extends AbstractCursor {
    private final int columnCount;
    private final String[] columnNames;
    private Object[] data;
    private int rowCount;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class RowBuilder {
        private final int endIndex;
        private int index;

        RowBuilder(int i6, int i7) {
            this.index = i6;
            this.endIndex = i7;
        }

        public RowBuilder add(Object obj) {
            if (this.index == this.endIndex) {
                throw new CursorIndexOutOfBoundsException("No more columns left.");
            }
            Object[] objArr = MatrixCursor.this.data;
            int i6 = this.index;
            this.index = i6 + 1;
            objArr[i6] = obj;
            return this;
        }
    }

    public MatrixCursor(String[] strArr, int i6) {
        this.rowCount = 0;
        this.columnNames = strArr;
        int length = strArr.length;
        this.columnCount = length;
        this.data = new Object[length * (i6 < 1 ? 1 : i6)];
    }

    public void addRow(Object[] objArr) {
        int length = objArr.length;
        int i6 = this.columnCount;
        if (length == i6) {
            int i7 = this.rowCount;
            this.rowCount = i7 + 1;
            int i8 = i7 * i6;
            ensureCapacity(i6 + i8);
            System.arraycopy(objArr, 0, this.data, i8, this.columnCount);
            return;
        }
        throw new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.length = " + objArr.length);
    }

    private void ensureCapacity(int i6) {
        Object[] objArr = this.data;
        if (i6 > objArr.length) {
            int length = objArr.length * 2;
            if (length >= i6) {
                i6 = length;
            }
            Object[] objArr2 = new Object[i6];
            this.data = objArr2;
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        }
    }

    private Object get(int i6) {
        int i7;
        if (i6 < 0 || i6 >= (i7 = this.columnCount)) {
            throw new CursorIndexOutOfBoundsException("Requested column: " + i6 + ", # of columns: " + this.columnCount);
        }
        int i8 = this.mPos;
        if (i8 < 0) {
            throw new CursorIndexOutOfBoundsException("Before first row.");
        }
        if (i8 < this.rowCount) {
            return this.data[(i8 * i7) + i6];
        }
        throw new CursorIndexOutOfBoundsException("After last row.");
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return this.columnNames;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getCount() {
        return this.rowCount;
    }

    public RowBuilder newRow() {
        int i6 = this.rowCount + 1;
        this.rowCount = i6;
        int i7 = i6 * this.columnCount;
        ensureCapacity(i7);
        return new RowBuilder(i7 - this.columnCount, i7);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public double getDouble(int i6) {
        Object obj = get(i6);
        if (obj == null) {
            return 0.0d;
        }
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        return Double.parseDouble(obj.toString());
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public float getFloat(int i6) {
        Object obj = get(i6);
        if (obj == null) {
            return 0.0f;
        }
        if (obj instanceof Number) {
            return ((Number) obj).floatValue();
        }
        return Float.parseFloat(obj.toString());
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getInt(int i6) {
        Object obj = get(i6);
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        return Integer.parseInt(obj.toString());
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public long getLong(int i6) {
        Object obj = get(i6);
        if (obj == null) {
            return 0L;
        }
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        return Long.parseLong(obj.toString());
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public short getShort(int i6) {
        Object obj = get(i6);
        if (obj == null) {
            return (short) 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).shortValue();
        }
        return Short.parseShort(obj.toString());
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String getString(int i6) {
        Object obj = get(i6);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor, net.sqlcipher.Cursor
    public int getType(int i6) {
        return DatabaseUtils.getTypeOfObject(get(i6));
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public boolean isNull(int i6) {
        if (get(i6) == null) {
            return true;
        }
        return false;
    }

    public MatrixCursor(String[] strArr) {
        this(strArr, 16);
    }

    public void addRow(Iterable<?> iterable) {
        int i6 = this.rowCount;
        int i7 = this.columnCount;
        int i8 = i6 * i7;
        int i9 = i7 + i8;
        ensureCapacity(i9);
        if (iterable instanceof ArrayList) {
            addRow((ArrayList) iterable, i8);
            return;
        }
        Object[] objArr = this.data;
        for (Object obj : iterable) {
            if (i8 != i9) {
                objArr[i8] = obj;
                i8++;
            } else {
                throw new IllegalArgumentException("columnValues.size() > columnNames.length");
            }
        }
        if (i8 == i9) {
            this.rowCount++;
            return;
        }
        throw new IllegalArgumentException("columnValues.size() < columnNames.length");
    }

    private void addRow(ArrayList<?> arrayList, int i6) {
        int size = arrayList.size();
        if (size == this.columnCount) {
            this.rowCount++;
            Object[] objArr = this.data;
            for (int i7 = 0; i7 < size; i7++) {
                objArr[i6 + i7] = arrayList.get(i7);
            }
            return;
        }
        throw new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.size() = " + size);
    }
}
