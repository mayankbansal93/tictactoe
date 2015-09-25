package my.example.mayank.Tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mayank.Tictactoe.R;

public class SecondActivity extends AppCompatActivity {
    public int[][] check=new int[3][3];
    boolean type=true;
    boolean ans=true;
    String s="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        GridView gv=(GridView)findViewById(R.id.gv1);
        gv.setAdapter(new ImageAdapter(this));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if((view instanceof ImageView) && (check[i/3][i%3]==0)){
                    if(type) {
                        ((ImageView) view).setImageResource(R.drawable.cross);
                        type=false;
                        check[i/3][i%3]=1;
                    }else{
                        ((ImageView)view).setImageResource(R.drawable.zero);
                        type=true;
                        check[i/3][i%3]=2;
                    }
                    ans=fun();
                    if(!ans){
                        for(int k=0;k<3;k++){
                            for(int j=0;j<3;j++){
                                check[k][j]=0;
                            }
                        }
                        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
                        Intent i1=new Intent(SecondActivity.this,MainActivity.class);
                        startActivity(i1);
                        finish();
                    }else{
                        if(complete()){
                            for(int k=0;k<3;k++){
                                for(int j=0;j<3;j++){
                                    check[k][j]=0;
                                }
                            }
                            Toast.makeText(getApplicationContext(),"Tie",Toast.LENGTH_SHORT).show();
                            Intent i1=new Intent(SecondActivity.this,MainActivity.class);
                            startActivity(i1);
                            finish();
                        }
                    }
                }
            }
        });

    }

    public boolean fun(){
        s="";
        for(int i=0;i<3;i++){
            if(check[i][0]==check[i][1] && check[i][0]==check[i][2] && check[i][0]!=0){
                if(check[i][0]==1){
                    s="Player 1 won";
                }else{
                    s="Player 2 won";
                }
                return false;
            }
        }
        for(int i=0;i<3;i++){
            if(check[0][i]==check[1][i] && check[1][i]==check[2][i] && check[0][i]!=0){
                if(check[0][i]==1){
                    s="Player 1 won";
                }else{
                    s="Player 2 won";
                }
                return false;
            }
        }
        if(check[0][0]==check[1][1] && check[1][1]==check[2][2] && check[0][0]!=0){
            if(check[0][0]==1){
                s="Player 1 won";
            }else{
                s="Player 2 won";
            }
            return false;
        }
        if(check[0][2]==check[1][1] && check[1][1]==check[2][0] && check[0][2]!=0){
            if(check[0][2]==1){
                s="Player 1 won";
            }else{
                s="Player 2 won";
            }
            return false;
        }
        return true;
    }

    public boolean complete(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(check[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(SecondActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
