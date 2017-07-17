package pager.homemade.com.br.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
        private Button btnVermelh, btnAzul, btnPreto;
        private Toolbar toolbar;
        private SharedPreferences.Editor editarPreferencias;
        private SharedPreferences sharedPreferences;
        private LinearLayout meuLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVermelh = (Button) findViewById(R.id.btnVermelho);
        btnAzul = (Button) findViewById(R.id.btnAzul);
        btnPreto = (Button) findViewById(R.id.btnPreto);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        meuLayout = (LinearLayout) findViewById(R.id.layoutPrincipal);

            if(pegarCor() != ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary)){
                toolbar.setBackgroundColor(pegarCor());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(pegarCor());
                }
            }

        btnVermelh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.vermelha));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.vermelha));
                }
                armazenarCor(ContextCompat.getColor(getApplicationContext(), R.color.vermelha));

            }
        });
        btnAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorAccent));
                }
                armazenarCor(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));

            }
        });

        btnPreto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.preta));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.preta));
                }

                armazenarCor(ContextCompat.getColor(getApplicationContext(), R.color.preta));

            }
        });

    }
    private void armazenarCor(int cor){
        this.sharedPreferences = getSharedPreferences("CorDaBarra", MODE_PRIVATE);
        this.editarPreferencias = sharedPreferences.edit();
        editarPreferencias.putInt("cor", cor);
        editarPreferencias.apply();
    }

    private int pegarCor(){
        this.sharedPreferences = getSharedPreferences("CorDaBarra", MODE_PRIVATE);
      int corSelecionada =   sharedPreferences.getInt("cor",ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        return  corSelecionada;
    }

}
