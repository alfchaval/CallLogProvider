package com.example.usuario.calllogproviderclase;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;

/**
 * Created by usuario on 2/9/18.
 */

public class CallLogPresenter implements LoaderManager.LoaderCallbacks<Cursor>, CallLogContract.Presenter {

    private CallLogContract.View view;
    private final static int CALLLOG = 0;

    public CallLogPresenter(CallLogContract.View view) {
        this.view = view;
    }

    @Override
    public Loader onCreateLoader(int id, Bundle bundle) {
        CursorLoader cursorLoader = null;
        switch (id) {
            case CALLLOG:
                String strOrder = CallLog.Calls.DATE+" DESC";
                String[] projection = {CallLog.Calls.NUMBER, CallLog.Calls.DATE, CallLog.Calls.DURATION, CallLog.Calls.TYPE};
                cursorLoader = new CursorLoader(view.getContext(), Uri.withAppendedPath(CallLog.CONTENT_URI, "calls"), projection, null, null, strOrder);
                break;
        }
        return cursorLoader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

    }

    @Override
    public void onLoaderReset(Loader loader) {
        view.swapCursor(null);
    }

    @Override
    public void getCallLogs() {
        ((Activity) view.getContext()).getLoaderManager().restartLoader(CALLLOG, null, this);
    }
}
