package com.fontmerger;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.chaquo.python.PyObject;
import com.chaquo.python.Python;

public class MainActivity extends AppCompatActivity {

    EditText font1Input, font2Input;
    Button mergeButton;
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        font1Input = new EditText(this);
        font1Input.setHint("مسار الخط الأول");
        layout.addView(font1Input);

        font2Input = new EditText(this);
        font2Input.setHint("مسار الخط الثاني");
        layout.addView(font2Input);

        mergeButton = new Button(this);
        mergeButton.setText("دمج الخطوط");
        layout.addView(mergeButton);

        resultView = new TextView(this);
        layout.addView(resultView);

        setContentView(layout);

        mergeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String font1 = font1Input.getText().toString();
                String font2 = font2Input.getText().toString();
                Python py = Python.getInstance();
                PyObject pyobj = py.getModule("fontmerger_script");
                String result = pyobj.callAttr("main_ui", font1, font2).toString();
                resultView.setText(result);
            }
        });
    }
}