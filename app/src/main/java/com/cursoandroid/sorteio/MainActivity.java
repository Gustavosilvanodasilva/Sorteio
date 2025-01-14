package com.cursoandroid.sorteio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonNext = findViewById(R.id.button_next);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecundariaActivity.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Exibir o BottomSheetDialog
                menuRedeSocial();
            }
        });
    }

    private void menuRedeSocial() {
        // Criar um BottomSheetDialog
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);

        //  layout para o BottomSheetDialog
        View sheetView = getLayoutInflater().inflate(R.layout.activity_rede_sociais, null);
        bottomSheetDialog.setContentView(sheetView);

        // Lidar com os cliques dos botões no BottomSheet
        ImageButton btnFacebook = sheetView.findViewById(R.id.facebook_button);
        ImageButton btnWhatsApp = sheetView.findViewById(R.id.whatsapp_button);
        ImageButton btnInstagram = sheetView.findViewById(R.id.instagram_button);
        ImageButton btnlinkedin = sheetView.findViewById(R.id.linkedin_button);

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/gustavo.silvano.587"));
                    startActivity(intent);
                } catch (Exception e) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/gustavo.silvano.587"));
                    startActivity(intent);
                }
            }
        });

        btnInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/gustavo_slvn"));
                    startActivity(intent);
                } catch (Exception e) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/gustavo_slvn"));
                    startActivity(intent);
                }
            }
        });

        btnWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("whatsapp://send?phone=5532984106120"));
                    startActivity(intent);
                } catch (Exception e) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/5532984106120"));
                    startActivity(intent);
                }
            }
        });

        btnlinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://in/gustavo-silvano-0782301ba"));
                    startActivity(intent);
                } catch (Exception e) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/gustavo-silvano-0782301ba"));
                    startActivity(intent);
                }
            }
        });

        // Exibir o BottomSheetDialog
        bottomSheetDialog.show();
    }
}
