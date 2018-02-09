package com.example.usuario.calllogproviderclase;

import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends ListActivity implements CallLogContract.View{

    private CallLogPresenter presenter;
    private CallLogAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new CallLogAdapter(this);
        presenter = new CallLogPresenter(this);
        presenter.getCallLogs();
        this.setListAdapter(adapter);
    }

    @Override
    public void swapCursor(Cursor cursor) {
        adapter.swapCursor(cursor);
    }

    @Override
    public Context getContext() {
        Context context = this;
        return context;
    }
}
