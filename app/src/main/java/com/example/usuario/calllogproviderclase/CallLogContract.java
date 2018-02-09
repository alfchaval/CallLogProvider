package com.example.usuario.calllogproviderclase;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by usuario on 2/9/18.
 */

public class CallLogContract {

    interface View {
        void swapCursor(Cursor cursor);
        Context getContext();
    }

    interface Presenter {
        void getCallLogs();
    }
}
