package com.example.swathivarsha.janani;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ANM_HRWomanActivity extends AppCompatActivity {

    DatabaseReference com, rootRef,demoRef;

    TextView baby;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anm_hrwoman);

        rootRef = FirebaseDatabase.getInstance().getReference();
        demoRef = rootRef.child("Risk").child("HR Pregnant Women");

        baby=(TextView)findViewById(R.id.textView3) ;

        demoRef.addChildEventListener (new ChildEventListener( ) {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String string = dataSnapshot.child("Name").getValue(String.class);

               baby.setText(string);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                // whenever data at this location is updated.
                // mUsername.clear ();
                String string = dataSnapshot.getValue(String.class);
                baby.setText(string);

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                String string = dataSnapshot.getValue(String.class);
                baby.setText(string);

                // startActivity (new Intent (ViewActivity.this,CancelledActivity.class));
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}
