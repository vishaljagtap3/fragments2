package in.bitcode.fragments2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private Button mBtnAdd, mBtnRemove, btnReset;
    private EditText mEdtCount;
    private ArrayList<CounterFragment> mListCounterFragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        mBtnAdd = findViewById(R.id.btnAdd);
        mBtnRemove = findViewById(R.id.btnRemove);
        mEdtCount = findViewById(R.id.edtCount);
        btnReset = findViewById(R.id.btnReset);

        mListCounterFragments = new ArrayList<CounterFragment>();

        mBtnAdd.setOnClickListener(new BtnAddClickListener());
        mBtnRemove.setOnClickListener(new BtnRemoveClickListener());

        btnReset.setOnClickListener(new BtnResetClickListener());
    }

    private class BtnResetClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int count = Integer.parseInt(mEdtCount.getText().toString());
            for(CounterFragment counterFragment : mListCounterFragments) {
                counterFragment.reset(count);
            }
        }
    }

    private class BtnAddClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            CounterFragment newCounterFragment = new CounterFragment();

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.mainContainer, newCounterFragment, null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            mListCounterFragments.add(newCounterFragment);

        }
    }
    private class BtnRemoveClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            if(mListCounterFragments.size() == 0 ) {
                return;
            }

            getSupportFragmentManager().beginTransaction()
                    .remove( mListCounterFragments.get(0) )
                    .addToBackStack(null)
                    .commit();
            mListCounterFragments.remove(0);

        }
    }
}