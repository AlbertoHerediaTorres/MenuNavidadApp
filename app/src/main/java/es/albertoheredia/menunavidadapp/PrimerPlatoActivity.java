package es.albertoheredia.menunavidadapp;

import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import clases.Plato;

public class PrimerPlatoActivity extends AppCompatActivity {

    ListView listaPlatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primer_plato);
        declararComponentes();
        cargarListView();
    }


    private void declararComponentes(){
        listaPlatos=(ListView)findViewById(R.id.listaPlatos);
    }

    private void cargarListView(){
        ArrayList<Plato> lista_platos=new ArrayList<>();

        lista_platos.add(new Plato("steak", "Presa iberica", "Presa de bellota de grazalema",13.5));
        lista_platos.add(new Plato("sandwich", "Sandwich vegetal", "Ideal para veganos y vegetarianos",9.0));
        lista_platos.add(new Plato("broccoli", "Salteado de verduras", "Contiene brocoli, pimiento...",22.8));

        AdaptadorPlatos ap = new AdaptadorPlatos(getApplicationContext(), lista_platos);

        listaPlatos.setAdapter(ap);
    }



    class AdaptadorPlatos extends ArrayAdapter<Plato> {

        ArrayList<Plato> lista_platos = new ArrayList<>();

        public AdaptadorPlatos(Context context, ArrayList<Plato> l_platos) {
            super(context, R.layout.item_lista_platos, l_platos);
            this.lista_platos=l_platos;

        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.item_lista_platos,  null);

            ImageView imgPlato = (ImageView)item.findViewById(R.id.item_lp_imagen);
            String nombre_imagen = lista_platos.get(position).getImagen();

            int id = getApplicationContext().getResources().getIdentifier(nombre_imagen, "drawable", getApplicationContext().getPackageName());
            imgPlato.setImageResource(id);


            TextView tvNombre = (TextView)item.findViewById(R.id.item_lp_nombre);
            tvNombre.setText(lista_platos.get(position).getNombre());

            TextView tvDescripcion = (TextView)item.findViewById(R.id.item_lp_descripcion);
            tvDescripcion.setText(lista_platos.get(position).getDescripcion());

            TextView tvPrecio = (TextView)item.findViewById(R.id.item_lp_precio);
            tvPrecio.setText(lista_platos.get(position).getPrecio()+" €");

            return(item);
        }
    }
}
