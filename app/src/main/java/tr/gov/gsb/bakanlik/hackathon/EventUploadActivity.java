package tr.gov.gsb.bakanlik.hackathon;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class EventUploadActivity extends AppCompatActivity {

    ImageView postImage;
    EditText postCommentText;
    EditText numberOfVolun;
    EditText postCommentCode;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;
    private FirebaseAuth mAuth;
    private StorageReference mStorageRef;
    Uri selectedImage;

    RadioGroup radioGroup;
    RadioButton radioButton;
    String idname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_upload);

        postCommentText = findViewById(R.id.shopUserNameText);
        postCommentCode = findViewById(R.id.shopUserNameText2);
        postImage = findViewById(R.id.postImageView);
        numberOfVolun = findViewById(R.id.editText2);


        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference();

        mAuth = FirebaseAuth.getInstance();

        mStorageRef = FirebaseStorage.getInstance().getReference();

        radioGroup = findViewById(R.id.radioGroup);
        myRef.child("Events").child("ww").child("useremail").setValue("dd");


    }
    public void checkButton(View view){
        int radioInt = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioInt);
    }

    public void upload (View view) {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final Uri photoUrl = user.getPhotoUrl();
        String downloadURL = photoUrl.toString();

        user = mAuth.getCurrentUser();
        String userEmail = user.getEmail();

        String userComment = postCommentText.getText().toString();
        String userCode = postCommentCode.getText().toString();
        String numberOfVloun = numberOfVolun.getText().toString();
        String radioInt = radioButton.getText().toString();

        UUID uuid1 = UUID.randomUUID();
        String uuidString = uuid1.toString();

        myRef.child("Events").child(uuidString).child("useremail").setValue(userEmail);
        myRef.child("Events").child(uuidString).child("descriptions").setValue(userComment);
        myRef.child("Events").child(uuidString).child("comment").setValue(userCode);
        myRef.child("Events").child(uuidString).child("codecomment").setValue(numberOfVloun);
        myRef.child("Events").child(uuidString).child("downloadurl").setValue(downloadURL);
        myRef.child("Events").child(uuidString).child("rewardnumber").setValue(radioInt + "Gönüllü");

        Toast.makeText(EventUploadActivity.this, "Post Shared", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

        }

}
