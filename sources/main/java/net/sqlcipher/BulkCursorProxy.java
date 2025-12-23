package net.sqlcipher;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class BulkCursorProxy implements IBulkCursor {
    private Bundle mExtras = null;
    private IBinder mRemote;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    @Override // net.sqlcipher.IBulkCursor
    public Bundle getExtras() throws RemoteException {
        if (this.mExtras == null) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            obtain.writeInterfaceToken(IBulkCursor.descriptor);
            this.mRemote.transact(10, obtain, obtain2, 0);
            DatabaseUtils.readExceptionFromParcel(obtain2);
            this.mExtras = obtain2.readBundle(BulkCursorProxy.class.getClassLoader());
            obtain.recycle();
            obtain2.recycle();
        }
        return this.mExtras;
    }

    public BulkCursorProxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    @Override // net.sqlcipher.IBulkCursor
    public void close() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        this.mRemote.transact(12, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // net.sqlcipher.IBulkCursor
    public int count() throws RemoteException {
        int readInt;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        boolean transact = this.mRemote.transact(2, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        if (!transact) {
            readInt = -1;
        } else {
            readInt = obtain2.readInt();
        }
        obtain.recycle();
        obtain2.recycle();
        return readInt;
    }

    @Override // net.sqlcipher.IBulkCursor
    public void deactivate() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        this.mRemote.transact(6, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // net.sqlcipher.IBulkCursor
    public boolean deleteRow(int i6) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        obtain.writeInt(i6);
        boolean z5 = false;
        this.mRemote.transact(5, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        if (obtain2.readInt() == 1) {
            z5 = true;
        }
        obtain.recycle();
        obtain2.recycle();
        return z5;
    }

    @Override // net.sqlcipher.IBulkCursor
    public String[] getColumnNames() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        this.mRemote.transact(3, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        int readInt = obtain2.readInt();
        String[] strArr = new String[readInt];
        for (int i6 = 0; i6 < readInt; i6++) {
            strArr[i6] = obtain2.readString();
        }
        obtain.recycle();
        obtain2.recycle();
        return strArr;
    }

    @Override // net.sqlcipher.IBulkCursor
    public boolean getWantsAllOnMoveCalls() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        this.mRemote.transact(9, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        int readInt = obtain2.readInt();
        obtain.recycle();
        obtain2.recycle();
        if (readInt == 0) {
            return false;
        }
        return true;
    }

    @Override // net.sqlcipher.IBulkCursor
    public CursorWindow getWindow(int i6) throws RemoteException {
        CursorWindow cursorWindow;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        obtain.writeInt(i6);
        this.mRemote.transact(1, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        if (obtain2.readInt() == 1) {
            cursorWindow = CursorWindow.newFromParcel(obtain2);
        } else {
            cursorWindow = null;
        }
        obtain.recycle();
        obtain2.recycle();
        return cursorWindow;
    }

    @Override // net.sqlcipher.IBulkCursor
    public void onMove(int i6) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        obtain.writeInt(i6);
        this.mRemote.transact(8, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // net.sqlcipher.IBulkCursor
    public int requery(IContentObserver iContentObserver, CursorWindow cursorWindow) throws RemoteException {
        int readInt;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        obtain.writeStrongInterface(iContentObserver);
        cursorWindow.writeToParcel(obtain, 0);
        boolean transact = this.mRemote.transact(7, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        if (!transact) {
            readInt = -1;
        } else {
            readInt = obtain2.readInt();
            this.mExtras = obtain2.readBundle(BulkCursorProxy.class.getClassLoader());
        }
        obtain.recycle();
        obtain2.recycle();
        return readInt;
    }

    @Override // net.sqlcipher.IBulkCursor
    public Bundle respond(Bundle bundle) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        obtain.writeBundle(bundle);
        this.mRemote.transact(11, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        Bundle readBundle = obtain2.readBundle(BulkCursorProxy.class.getClassLoader());
        obtain.recycle();
        obtain2.recycle();
        return readBundle;
    }

    @Override // net.sqlcipher.IBulkCursor
    public boolean updateRows(Map map) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken(IBulkCursor.descriptor);
        obtain.writeMap(map);
        boolean z5 = false;
        this.mRemote.transact(4, obtain, obtain2, 0);
        DatabaseUtils.readExceptionFromParcel(obtain2);
        if (obtain2.readInt() == 1) {
            z5 = true;
        }
        obtain.recycle();
        obtain2.recycle();
        return z5;
    }
}
