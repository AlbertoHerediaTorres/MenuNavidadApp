package es.albertoheredia.menunavidadapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button menu;
    Button configurar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        declararComponentes();


    }

        private void declararComponentes() {

         menu  = (Button) findViewById(R.id.btnComenzar);
         configurar  = (Button) findViewById(R.id.btnConfiguracion);

    menu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i=new Intent(getApplicationContext(), PrimerPlatoActivity.class);
            startActivity(i);
        }
    });

    configurar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });


        }
}
