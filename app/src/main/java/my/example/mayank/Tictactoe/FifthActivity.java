package my.example.mayank.Tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mayank.Tictactoe.R;

import java.util.HashMap;
import java.util.Random;

public class FifthActivity extends AppCompatActivity implements View.OnClickListener{
    public int[][] check=new int[3][3];
    boolean type=true;
    boolean ans=true;
    String s="";
    Random r=new Random();
    HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
    HashMap<Integer,Integer> h1=new HashMap<Integer,Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        h.put(R.id.iv1, 0);
        h.put(R.id.iv2, 1);
        h.put(R.id.iv3,2);
        h.put(R.id.iv4,3);
        h.put(R.id.iv5,4);
        h.put(R.id.iv6,5);
        h.put(R.id.iv7,6);
        h.put(R.id.iv8,7);
        h.put(R.id.iv9,8);
        h1.put(0,R.id.iv1);
        h1.put(1,R.id.iv2);
        h1.put(2,R.id.iv3);
        h1.put(3,R.id.iv4);
        h1.put(4,R.id.iv5);
        h1.put(5,R.id.iv6);
        h1.put(6,R.id.iv7);
        h1.put(7,R.id.iv8);
        h1.put(8,R.id.iv9);
        int num=r.nextInt(2);
        if(num==0){
            num=r.nextInt(h.size());
            if(num%2!=0){
                num-=1;
            }
            int x=h1.get(num);
            ((ImageView)findViewById(x)).setImageResource(R.drawable.zero);
            check[h.get(x) / 3][h.get(x) % 3] = 2;
            h.remove(x);
            h1.remove(num);
        }
        findViewById(R.id.iv1).setOnClickListener(this);
        findViewById(R.id.iv2).setOnClickListener(this);
        findViewById(R.id.iv3).setOnClickListener(this);
        findViewById(R.id.iv4).setOnClickListener(this);
        findViewById(R.id.iv5).setOnClickListener(this);
        findViewById(R.id.iv6).setOnClickListener(this);
        findViewById(R.id.iv7).setOnClickListener(this);
        findViewById(R.id.iv8).setOnClickListener(this);
        findViewById(R.id.iv9).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (type && h.containsKey(view.getId()) && check[h.get(view.getId()) / 3][h.get(view.getId()) % 3] == 0) {
            ((ImageView) findViewById(view.getId())).setImageResource(R.drawable.cross);
            check[h.get(view.getId()) / 3][h.get(view.getId()) % 3] = 1;
            h1.remove(h.get(view.getId()));
            h.remove(view.getId());
            type = false;
            ans = fun();
            if (!ans) {
                for (int k = 0; k < 3; k++) {
                    for (int j = 0; j < 3; j++) {
                        check[k][j] = 0;
                    }
                }
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(FifthActivity.this, FourthActivity.class);
                startActivity(i1);
                finish();
            } else {
                if (complete()) {
                    for (int k = 0; k < 3; k++) {
                        for (int j = 0; j < 3; j++) {
                            check[k][j] = 0;
                        }
                    }
                    Toast.makeText(getApplicationContext(), "Tie", Toast.LENGTH_SHORT).show();
                    Intent i1 = new Intent(FifthActivity.this, FourthActivity.class);
                    startActivity(i1);
                    finish();
                }else{
                    int num=generatePos1();
                    if(num<0){
                        num=generatePos2();
                    }
                    if(num<0) {
                        num = r.nextInt(9);
                        if (check[num / 3][num % 3] == 0) {
                        } else {
                            num = 0;
                            while (true) {
                                if (check[num / 3][num % 3] == 0) {
                                    break;
                                }
                                num++;
                            }
                        }
                    }
                    int x = h1.get(num);
                    ((ImageView) findViewById(x)).setImageResource(R.drawable.zero);
                    check[h.get(x)/3][h.get(x) % 3] = 2;
                    h.remove(x);
                    h1.remove(num);
                    type=true;
                    ans=fun();
                    if (!ans) {
                        for (int k = 0; k < 3; k++) {
                            for (int j = 0; j < 3; j++) {
                                check[k][j] = 0;
                            }
                        }
                        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                        Intent i1 = new Intent(FifthActivity.this, FourthActivity.class);
                        startActivity(i1);
                        finish();
                    } else {
                        if (complete()) {
                            for (int k = 0; k < 3; k++) {
                                for (int j = 0; j < 3; j++) {
                                    check[k][j] = 0;
                                }
                            }
                            Toast.makeText(getApplicationContext(), "Tie", Toast.LENGTH_SHORT).show();
                            Intent i1 = new Intent(FifthActivity.this, FourthActivity.class);
                            startActivity(i1);
                            finish();
                        }
                    }
                }
            }
        }
    }

    public boolean fun(){
        s="";
        for(int i=0;i<3;i++){
            if(check[i][0]==check[i][1] && check[i][0]==check[i][2] && check[i][0]!=0){
                if(check[i][0]==1){
                    s="Player 1 won";
                }else{
                    s="Computer Won";
                }
                return false;
            }
        }
        for(int i=0;i<3;i++){
            if(check[0][i]==check[1][i] && check[1][i]==check[2][i] && check[0][i]!=0){
                if(check[0][i]==1){
                    s="Player 1 won";
                }else{
                    s="Computer Won";
                }
                return false;
            }
        }
        if(check[0][0]==check[1][1] && check[1][1]==check[2][2] && check[0][0]!=0){
            if(check[0][0]==1){
                s="Player 1 won";
            }else{
                s="Computer Won";
            }
            return false;
        }
        if(check[0][2]==check[1][1] && check[1][1]==check[2][0] && check[0][2]!=0){
            if(check[0][2]==1){
                s="Player 1 won";
            }else{
                s="Computer Won";
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
        Intent i=new Intent(FifthActivity.this,FourthActivity.class);
        startActivity(i);
        finish();
    }

    public int generatePos1(){
        int pos=-1;
        for(int i=0;i<3;i++){
            if(check[i][0]==check[i][1] && check[i][0]==2 && check[i][2]==0){
                return (3*i+2);
            }else if(check[i][0]==check[i][2] && check[i][0]==2 && check[i][1]==0){
                return (3*i+1);
            }else if(check[i][1]==check[i][2] && check[i][1]==2 && check[i][0]==0){
                return (3*i+0);
            }else if(check[0][i]==check[1][i] && check[0][i]==2 && check[2][i]==0){
                return (6+i);
            }else if(check[0][i]==check[2][i] && check[0][i]==2 && check[1][i]==0){
                return (3+i);
            }else if(check[1][i]==check[2][i] && check[1][i]==2 && check[0][i]==0){
                return (i);
            }
        }
        if(check[0][0]==check[1][1] && check[0][0]==2 && check[2][2]==0){
            return 8;
        }else if(check[0][0]==check[2][2] && check[0][0]==2 && check[1][1]==0){
            return 4;
        }else if(check[2][2]==check[1][1] && check[1][1]==2 && check[0][0]==0){
            return 0;
        }else if(check[0][2]==check[1][1] && check[0][2]==2 && check[2][0]==0){
            return 6;
        }else if(check[0][2]==check[2][0] && check[0][2]==2 && check[1][1]==0){
            return 4;
        }else if(check[2][0]==check[1][1] && check[1][1]==2 && check[0][2]==0){
            return 2;
        }
        return pos;
    }

    public int generatePos2(){
        int pos=-1;
        for(int i=0;i<3;i++){
            if(check[i][0]==check[i][1] && check[i][0]==1 && check[i][2]==0){
                return (3*i+2);
            }else if(check[i][0]==check[i][2] && check[i][0]==1 && check[i][1]==0){
                return (3*i+1);
            }else if(check[i][1]==check[i][2] && check[i][1]==1 && check[i][0]==0){
                return (3*i+0);
            }else if(check[0][i]==check[1][i] && check[0][i]==1 && check[2][i]==0){
                return (6+i);
            }else if(check[0][i]==check[2][i] && check[0][i]==1 && check[1][i]==0){
                return (3+i);
            }else if(check[1][i]==check[2][i] && check[1][i]==1 && check[0][i]==0){
                return (i);
            }
        }
        if(check[0][0]==check[1][1] && check[0][0]==1 && check[2][2]==0){
            return 8;
        }else if(check[0][0]==check[2][2] && check[0][0]==1 && check[1][1]==0){
            return 4;
        }else if(check[2][2]==check[1][1] && check[1][1]==1 && check[0][0]==0){
            return 0;
        }else if(check[0][2]==check[1][1] && check[0][2]==1 && check[2][0]==0){
            return 6;
        }else if(check[0][2]==check[2][0] && check[0][2]==1 && check[1][1]==0){
            return 4;
        }else if(check[2][0]==check[1][1] && check[1][1]==1 && check[0][2]==0){
            return 2;
        }
        return pos;
    }
}
