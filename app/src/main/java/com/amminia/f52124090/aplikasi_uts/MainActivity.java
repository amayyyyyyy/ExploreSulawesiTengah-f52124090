package com.amminia.f52124090.aplikasi_uts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listWisata;

    String[] namaWisata = {
            "Pantai Tanjung Karang",
            "Danau Poso",
            "Taman Nasional Lore Lindu",
            "Kepulauan Togean",
            "Air Terjun Saluopa",
            "Danau Tambing"
    };

    String[] lokasiWisata = {
            "Donggala",
            "Poso",
            "Sigi dan Poso",
            "Tojo Una-Una",
            "Tentena, Poso",
            "Poso"
    };

    String[] deskripsiWisata = {
            "Pantai dengan air jernih dan pemandangan yang indah.",
            "Danau dengan air yang jernih dan pemandangan pegunungan.",
            "Kawasan hutan tropis dengan keanekaragaman flora dan fauna.",
            "Kepulauan dengan laut jernih dan terumbu karang yang menarik.",
            "Air terjun bertingkat dengan suasana hutan yang sejuk.",
            "Danau yang berada di kawasan Lore Lindu dengan suasana alami."
    };

    int[] gambarWisata = {
            R.drawable.tanjung_karang,
            R.drawable.danau_poso,
            R.drawable.lore_lindu,
            R.drawable.togean,
            R.drawable.saluopa,
            R.drawable.danau_tambing
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listWisata = findViewById(R.id.listWisata);

        CustomAdapter adapter = new CustomAdapter();
        listWisata.setAdapter(adapter);
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return namaWisata.length;
        }

        @Override
        public Object getItem(int position) {
            return namaWisata[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(MainActivity.this)
                        .inflate(R.layout.item_wisata, parent, false);
            }

            ImageView imgWisata = convertView.findViewById(R.id.imgWisata);
            TextView txtNama = convertView.findViewById(R.id.txtNama);
            TextView txtLokasi = convertView.findViewById(R.id.txtLokasi);
            TextView txtDeskripsi = convertView.findViewById(R.id.txtDeskripsi);

            imgWisata.setImageResource(gambarWisata[position]);
            txtNama.setText(namaWisata[position]);
            txtLokasi.setText("📍 " + lokasiWisata[position]);
            txtDeskripsi.setText(deskripsiWisata[position]);

            return convertView;
        }
    }
}