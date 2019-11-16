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

public class GiftPostClass extends ArrayAdapter<String> {


    private final ArrayList<String> userEmail;
    private final ArrayList<String> userComment;
    private final ArrayList<String> userCodeComment;

    private final Activity context;

    public GiftPostClass(ArrayList<String> userEmail, ArrayList<String> userComment, ArrayList<String> userCodeComment,Activity context) {
        super(context,R.layout.gift_custom,userEmail);
        this.userEmail = userEmail;
        this.userComment = userComment;
        this.userCodeComment = userCodeComment;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View campaignCustom = layoutInflater.inflate(R.layout.gift_custom,null,true );

        TextView userEmailText = campaignCustom.findViewById(R.id.nope);
        TextView commentText = campaignCustom.findViewById(R.id.commentTextViewCustomView);
        TextView codeCommentText = campaignCustom.findViewById(R.id.commentCodeTextViewCustomView);

        userEmailText.setText(userEmail.get(position));
        commentText.setText(userComment.get(position));
        codeCommentText.setText(userCodeComment.get(position));

        return campaignCustom;
    }
}
