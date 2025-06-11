

package com.example.tp2;

//import static com.example.tp2.R.*;
//import static com.example.tp2.R.id.tvPronouns;

import static com.example.tp2.R.*;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView profileImage; // Tambahkan ImageView untuk gambar profil
    private TextView tvName, tvUsername, tvPronouns, tvBio; // Tambahkan TextView untuk menampilkan teks


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inisialisasi elemen-elemen UI dari layout berdasarkan ID nya
        profileImage = findViewById(R.id.profileImage);
        tvName = findViewById(R.id.tvName);
        tvUsername = findViewById(R.id.tvUsername);
        tvPronouns = findViewById(R.id.tvPronouns);
        tvBio = findViewById(R.id.tvBio);

        // Ambil data user dari intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("USER_DATA")) {
            User user = intent.getParcelableExtra("USER_DATA");

            // Set data user ke elemen-elemen UI
            if (user != null) { // Periksa apakah user tidak null(kosong) sebelum mengakses
                tvName.setText(user.getName()); // atur tampilan namanya menjadi nama dari data user
                tvUsername.setText(user.getUsername()); // atur tampilan usernamenya menjadi username dari data user
                tvPronouns.setText(user.getPronouns()); // atur tampilan pronounsnya menjadi pronouns dari data user
                tvBio.setText(user.getBio());// atur tampilan bionya menjadi bio dari data user

                // atur gambar profil dari data user
                String imageUriString = user.getImageUri();
                if (imageUriString != null && !imageUriString.isEmpty()) {
                    Uri imageUri = Uri.parse(imageUriString);
                    profileImage.setImageURI(imageUri);
                }
            }
        }

        // Fungsi untuk tombol Edit Profile, supaya bisa pindah ke activity edit profile.
        Button editProfile = findViewById(R.id.btnEditProfile);
        editProfile.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditProfile.class);
                startActivity(intent);
            }
        });
    }
}