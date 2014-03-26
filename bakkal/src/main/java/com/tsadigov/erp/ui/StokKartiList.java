package com.tsadigov.erp.ui;

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.tsadigov.erp.R;
import com.tsadigov.erp.model.BakkalDatabase;
import com.tsadigov.erp.model.pojo.StokKarti;

import java.util.List;


/**
 * Created by tural on 3/24/14.
 */
public class StokKartiList extends ListFragment {
    public BakkalDatabase _db;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        _db=new BakkalDatabase(getActivity().getApplicationContext());
        SQLiteDatabase connection=_db.getReadableDatabase();
        List<StokKarti> all=_db._stokKartiRepository.all(connection);
        ArrayAdapter<StokKarti> adp=new ArrayAdapter<StokKarti>(getActivity(), R.layout.item_stokkarti,R.id.Name, all){

            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {

                final View v= super.getView(position, convertView, parent);

                TextView txtPrice=(TextView)v.findViewById(R.id.Price);
                if(null != txtPrice)
                    txtPrice.setText(getItem(position).getPrice().toString());


                TextView txtName=(TextView)v.findViewById(R.id.Name);
                if(null != txtName){
                    txtName.setText(getItem(position).getName());
                }

                if(null != convertView)
                    return v;

                v.setOnTouchListener(new View.OnTouchListener() {
                    public float mPosX;
                    public float mPosY;

                    // The ‘active pointer’ is the one currently moving our object.
                    private int mActivePointerId = -1;

                    float mLastTouchX;
                    float mLastTouchY;


                    @Override
                    public boolean onTouch(View view, MotionEvent ev) {
                        // Let the ScaleGestureDetector inspect all events.
                        Log.i("onTouch", ev.toString());

                        final int action = ev.getAction();//MotionEventCompat.getActionMasked(ev);

                        switch (action) {
                            case MotionEvent.ACTION_DOWN: {
                                final int pointerIndex = ev.getActionIndex();
                                final float x = ev.getX( pointerIndex);
                                final float y = ev.getY( pointerIndex);

                                // Remember where we started (for dragging)
                                mLastTouchX = x;
                                mLastTouchY = y;
                                // Save the ID of this pointer (for dragging)
                                mActivePointerId = ev.getPointerId(0);
                                break;
                            }

                            case MotionEvent.ACTION_MOVE: {
                                // Find the index of the active pointer and fetch its position
                                final int pointerIndex =
                                        ev.findPointerIndex( mActivePointerId);

                                final float x = ev.getX( pointerIndex);
                                final float y = ev.getY( pointerIndex);

                                // Calculate the distance moved
                                final float dx = x - mLastTouchX;
                                final float dy = y - mLastTouchY;

                                mPosX += dx;
                                mPosY += dy;

                                v.getRootView().invalidate();

                                // Remember this touch position for the next move event
                                mLastTouchX = x;
                                mLastTouchY = y;


                                if(dx>15&&dy<15){
                                    Bundle b=new Bundle();
                                    StokKarti stokkarti=getItem(position);
                                    b.putInt("Id", stokkarti.getId());

                                    Intent i=new Intent();
                                    i.setClass(getActivity(),TransactionActivity.class);
                                    i.putExtras(b);
                                    startActivity(i);
                                }

                                break;
                            }

                            case MotionEvent.ACTION_UP: {
                                mActivePointerId = -1;
                                break;
                            }

                            case MotionEvent.ACTION_CANCEL: {
                                mActivePointerId = -1;
                                break;
                            }

                            case MotionEvent.ACTION_POINTER_UP: {

                                final int pointerIndex = ev.getActionIndex();
                                final int pointerId = ev.getPointerId(pointerIndex);

                                if (pointerId == mActivePointerId) {
                                    // This was our active pointer going up. Choose a new
                                    // active pointer and adjust accordingly.
                                    final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
                                    mLastTouchX = ev.getX(newPointerIndex);
                                    mLastTouchY = ev.getY(newPointerIndex);
                                    mActivePointerId = ev.getPointerId(newPointerIndex);
                                }
                                break;
                            }
                        }
                        return true;
                    }
                });

                return v;
            }
        };

        setListAdapter(adp);
    }
}
