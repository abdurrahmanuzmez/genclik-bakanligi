package tr.gov.gsb.bakanlik.hackathon;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CampaignPostClass extends ArrayAdapter<String> {


    private final ArrayList<String> userEmail;
    private final ArrayList<String> userComment;
    private final ArrayList<String> userCodeComment;
    private final ArrayList<String> userImage;
    private final ArrayList<String> userPlace;
    private final ArrayList<String> userVolunNumber;
    private final Activity context;

    public CampaignPostClass(ArrayList<String> userEmail, ArrayList<String> userComment, ArrayList<String> userCodeComment, ArrayList<String> userImage,ArrayList<String> userPlace,ArrayList<String> userVolunNumber, Activity context) {
        super(context,R.layout.campaign_custom,userEmail);
        this.userEmail = userEmail;
        this.userComment = userComment;
        this.userCodeComment = userCodeComment;
        this.userImage = userImage;
        this.userPlace = userPlace;
        this.userVolunNumber = userVolunNumber;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View campaignCustom = layoutInflater.inflate(R.layout.campaign_custom,null,true );

        TextView userEmailText = campaignCustom.findViewById(R.id.nope);
        TextView commentText = campaignCustom.findViewById(R.id.commentTextViewCustomView);
        TextView codeCommentText = campaignCustom.findViewById(R.id.commentCodeTextViewCustomView);
        TextView userPlace3 = campaignCustom.findViewById(R.id.userPlace);
        TextView userVolunNumb = campaignCustom.findViewById(R.id.textView4);
        ImageView imageView = campaignCustom.findViewById(R.id.imageViewCustomView);

        userEmailText.setText(userEmail.get(position));
        commentText.setText(userComment.get(position));
        codeCommentText.setText(userCodeComment.get(position));
        userPlace3.setText(userPlace.get(position));
        userVolunNumb.setText(userVolunNumber.get(position));
        Picasso.get().load(userImage.get(position)).into(imageView);

        return campaignCustom;
    }
}
