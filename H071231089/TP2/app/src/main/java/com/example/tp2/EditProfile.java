package com.example.tp2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class EditProfile extends AppCompatActivity {

    private ImageView imgProfile, ivCheck;
    private EditText etName, etUsername, etPronouns, etBio;
    private Uri imageUri;

    private static final String PREF_NAME = "USER_PREF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_profile);

        // Inisialisasi elemen UI
        imgProfile = findViewById(R.id.imgProfile);
        etName = findViewById(R.id.etName);
        etUsername = findViewById(R.id.etUsername);
        etPronouns = findViewById(R.id.etPronouns);
        etBio = findViewById(R.id.etBio);
        ivCheck = findViewById(R.id.ivCheck);

        // Load data tersimpan dari SharedPreferences
        loadUserData();

        // Aksi klik gambar untuk pilih foto dari galeri
        imgProfile.setOnClickListener(v -> {
            Intent openGallery = new Intent(Intent.ACTION_GET_CONTENT);
            openGallery.setType("image/*");
            galleryLauncher.launch(Intent.createChooser(openGallery, "Choose a picture"));
        });

        // Aksi klik tombol check untuk simpan data dan kirim ke MainActivity
        ivCheck.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String username = etUsername.getText().toString();
            String pronouns = etPronouns.getText().toString();
            String bio = etBio.getText().toString();
            String imageUriString = (imageUri != null) ? imageUri.toString() : "";

            // Simpan data ke SharedPreferences
            saveUserData(name, username, pronouns, bio, imageUriString);

            // Buat objek User dan kirim ke MainActivity
            User user = new User(name, username, pronouns, bio, imageUriString);
            Intent intent = new Intent(EditProfile.this, MainActivity.class);
            intent.putExtra("USER_DATA", user);
            startActivity(intent);
        });
    }

    // ActivityResultLauncher untuk buka galeri
    private final ActivityResultLauncher<Intent> galleryLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                                imageUri = result.getData().getData();
                                imgProfile.setImageURI(imageUri);
                            }
                        }
                    });

    // Simpan data ke SharedPreferences
    private void saveUserData(String name, String username, String pronouns, String bio, String imageUri) {
        SharedPreferences.Editor editor = getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        editor.putString("name", name);
        editor.putString("username", username);
        editor.putString("pronouns", pronouns);
        editor.putString("bio", bio);
        editor.putString("imageUri", imageUri);
        editor.apply();
    }

    // Ambil data dari SharedPreferences
    private void loadUserData() {
        SharedPreferences prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        etName.setText(prefs.getString("name", ""));
        etUsername.setText(prefs.getString("username", ""));
        etPronouns.setText(prefs.getString("pronouns", ""));
        etBio.setText(prefs.getString("bio", ""));

        String savedImageUri = prefs.getString("imageUri", null);
        if (savedImageUri != null) {
            imageUri = Uri.parse(savedImageUri);
            imgProfile.setImageURI(imageUri);
        }
    }
}
