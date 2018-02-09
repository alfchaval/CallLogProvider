package com.example.usuario.calllogproviderclase;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by usuario on 2/9/18.
 */

public class CallLogAdapter extends CursorAdapter{

    public CallLogAdapter(Context context) {
        super(context, null, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_call, viewGroup, false);
        CallLogHolder callLogHolder = new CallLogHolder();
        callLogHolder.txvNumber = view.findViewById(R.id.txvNumber);
        callLogHolder.txvDate = view.findViewById(R.id.txvDate);
        callLogHolder.txvDuration = view.findViewById(R.id.txvDuration);
        callLogHolder.txvType = view.findViewById(R.id.txvType);
        view.setTag(callLogHolder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(cursor.getInt(1));

        CallLogHolder callLogHolder = (CallLogHolder) view.getTag();
        callLogHolder. txvNumber.setText(cursor.getInt(0));
        callLogHolder. txvDate.setText(calendar.get(Calendar.DAY_OF_MONTH) + "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.YEAR) + "/");
        callLogHolder. txvDuration.setText(cursor.getInt(2));
        callLogHolder. txvType.setText(cursor.getInt(3));
    }

    private class CallLogHolder {
        TextView txvNumber;
        TextView txvDate;
        TextView txvDuration;
        TextView txvType;
    }
}
