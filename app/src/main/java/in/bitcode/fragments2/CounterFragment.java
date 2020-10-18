package in.bitcode.fragments2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CounterFragment extends Fragment {

    private TextView mTxtCount;
    private Button mBtnMinus, mBtnPlus;
    private int mCount;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mCount = 0;

        View view = inflater.inflate(R.layout.counter_fragment, null);
        mTxtCount = view.findViewById(R.id.txtCount);
        mBtnMinus = view.findViewById(R.id.btnMinus);
        mBtnPlus = view.findViewById(R.id.btnPlus);

        mTxtCount.setOnClickListener(new TxtCountClickListener());
        mBtnPlus.setOnClickListener(new BtnPlusClickListener());
        mBtnMinus.setOnClickListener(new BtnMinusClickListener());

        return view;

        /*
        mTxtCount = new TextView(getActivity());
        mTxtCount.setTextSize(20);
        mTxtCount.setGravity(Gravity.CENTER_HORIZONTAL);
        mTxtCount.setText("I am a View, which is part of CounterFragment");
        mTxtCount.setOnClickListener(new TxtCountClickListener());
        return mTxtCount;
         */
    }

    private class BtnPlusClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            mCount++;
            mTxtCount.setText(mCount + "");
        }
    }

    private class BtnMinusClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            mCount--;
            mTxtCount.setText(mCount + "");
        }
    }


    private class TxtCountClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            mTxtCount.setText("0");
            mCount = 0;
        }
    }

    public void reset(){
        reset(0);
    }

    public void reset(int count) {
        mCount = count;
        mTxtCount.setText(mCount + "");
    }
}











