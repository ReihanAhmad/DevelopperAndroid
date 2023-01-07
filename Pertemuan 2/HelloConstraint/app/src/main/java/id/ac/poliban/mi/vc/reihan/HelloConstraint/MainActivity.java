package id.ac.poliban.mi.vc.reihan.HelloConstraint;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        final Button btnZero = findViewById(R.id.button_zero);
        final Button btnCount = findViewById(R.id.button_count);
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnZero.setBackgroundColor(Color.GREEN);
                mCount = 0;
                mShowCount.setText(Integer.toString(mCount));
            }
        });

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCount.setBackgroundColor(Color.CYAN);
                mCount++;
                if (mShowCount != null) {
                    mShowCount.setText(Integer.toString(mCount));
                }
            }
        });
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    public void showZero(View view) {
    }
}