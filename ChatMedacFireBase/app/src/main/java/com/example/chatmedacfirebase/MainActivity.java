package com.example.chatmedacfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final int PHOTO_SEND = 1;
    private EditText txtMensaje;
    private EditText txtNombre;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private FirebaseStorage storage;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMensaje = findViewById(R.id.txtMensaje);
        txtNombre = findViewById(R.id.txtNombre);
        AdapterMensaje adapterMensaje = new AdapterMensaje(this);
        RecyclerView rvMensaje = findViewById(R.id.rvMensajes);
        rvMensaje.setLayoutManager(new LinearLayoutManager(this));
        rvMensaje.setAdapter(adapterMensaje);
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("CHAT");
        storage = FirebaseStorage.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference("FOTO-CHAT");
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Mensaje m = snapshot.getValue(Mensaje.class);
                adapterMensaje.addMensaje(m);
                rvMensaje.scrollToPosition(adapterMensaje.getItemCount() - 1);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        findViewById(R.id.btnEnviarFoto).setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_GET_CONTENT);
            i.setType("image/jpeg");
            i.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
            startActivityForResult(Intent.createChooser(i, "Selecciona una foto."), PHOTO_SEND);
        });
        findViewById(R.id.btnEnviar).setOnClickListener(view -> {
            Mensaje m = new Mensaje(txtNombre.getText().toString(), getHora(), txtMensaje.getText().toString(), "");

            databaseReference.push().setValue(m);
            txtMensaje.setText("");
            rvMensaje.scrollToPosition(adapterMensaje.getItemCount() - 1);
        });


    }

    private String getHora() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(new Date());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @androidx.annotation.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PHOTO_SEND && resultCode == RESULT_OK) {

            findViewById(R.id.progressBar).setVisibility(View.VISIBLE);

            final Uri u = data.getData();
            final StorageReference fotoReference = storageReference.child(u.getLastPathSegment());
            fotoReference.putFile(u).addOnSuccessListener(this, taskSnapshot ->
                    fotoReference.putFile(u).continueWithTask(task -> {
                        findViewById(R.id.progressBar).setVisibility(View.GONE);
                        if (!task.isSuccessful()) {
                            Toast.makeText(this, "Error subiendo la imagen", Toast.LENGTH_SHORT).show();
                        }
                        return fotoReference.getDownloadUrl();
                    })
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    findViewById(R.id.progressBar).setVisibility(View.GONE);
                                    Mensaje m = new Mensaje(txtNombre.getText().toString(), getHora(), "", task.getResult().toString());
                                    databaseReference.push().setValue(m);
                                }

                            })
            );
        }
    }
}