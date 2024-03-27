package step.learning.android111;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalcActivity extends AppCompatActivity {
    private TextView tvHistory;
    private TextView tvResult;

    @SuppressLint("DiscouragedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        for (int i = 0; i < 10; i++) {
            String buttonId = "calc_btn_" + i;
            findViewById(
                    getResources()   // R
                            .getIdentifier(
                                    buttonId,
                                    "id",
                                    getPackageName()
                            )
            ).setOnClickListener( this::digitClick ) ;
        }

        tvHistory = findViewById( R.id.calc_tv_history );
        tvResult  = findViewById( R.id.calc_tv_result  );

        findViewById( R.id.calc_btn_c ).setOnClickListener( this::cClick );

        cClick(null);
    }

    private void digitClick( View view ) {
        String result = tvResult.getText().toString();
        if(result.length() >= 10) {
            return;
        }
        if( result.equals( getString( R.string.calc_btn_0 ) ) ) {
            result = "";
        }
        result += ((Button)view).getText();
        tvResult.setText( result );
    }

    private void cClick( View view ) {
        tvHistory.setText("");
        tvResult.setText( R.string.calc_btn_0 );
    }
}
/*
Д.З. Для гри "хрестики-нолики" реалізувати динаміку:
за натисканням елементів змінюється їх контент, якщо вони порожні.
Забезпечити послідовність ходів (чергування Х та 0)
 */