package com.example.mpakoappversion02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class  AgentActivity extends AppCompatActivity {
    private TextView InfosUser;
    ListView listView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent);

        listView = (ListView)findViewById(R.id.listView);


        ArrayList<String> arrayList = new ArrayList<>();
        ArrayAdapter<String> arrayAdapter;

        String Clients = "{\"ListeClients\":[\n"+
                " {\"id\":\"01\",\"name\":\"Cedrick OKONDA\",\"typeP\":\"Trimestriel\"},\n"+
                " {\"id\":\"02\",\"name\":\"Julie KABEYA\",\"typeP\":\"Mensuel\"},\n"+
                " {\"id\":\"03\",\"name\":\"Patrick MUKALA\",\"typeP\":\"Annuel\"},\n"+
                " {\"id\":\"04\",\"name\":\"Consistance VALIRE\",\"typeP\":\"Mensuel\"},\n"+
                " {\"id\":\"05\",\"name\":\"Emmanuel PAMBI\",\"typeP\":\"Mensuel\"},\n"+
                " {\"id\":\"06\",\"name\":\"Arlette DANGA\",\"typeP\":\"Mensuel\"},\n"+
                " {\"id\":\"07\",\"name\":\"Dimercia MUSHIYA\",\"typeP\":\"Mensuel\"},\n"+
                " {\"id\":\"08\",\"name\":\"Luc-Marc MWAMBA\",\"typeP\":\"Mensuel\"},\n"+
                " {\"id\":\"09\",\"name\":\"Vanglodi KALOMBO\",\"typeP\":\"Mensuel\"},\n"+
                " {\"id\":\"10\",\"name\":\"Bienfait SHOMARI\",\"typeP\":\"Mensuel\"},\n"+
                " {\"id\":\"11\",\"name\":\"Dorcas MATANGI\",\"typeP\":\"Mensuel\"},\n"+
                " {\"id\":\"12\",\"name\":\"Didier KUMWIMBA\",\"typeP\":\"Mensuel\"},\n"+
                " {\"id\":\"13\",\"name\":\"Seth KASONGO\",\"typeP\":\"Mensuel\"},\n"+
                " {\"id\":\"14\",\"name\":\"Gedeon ISHARA\",\"typeP\":\"Mensuel\"},\n"+
                " {\"id\":\"15\",\"name\":\"Beni MILEMI\",\"typeP\":\"Mensuel\"},\n"+
                " {\"id\":\"16\",\"name\":\"Joseph KATOLO\",\"typeP\":\"Mensuel\"},\n"+
                " {\"id\":\"17\",\"name\":\"Daudet KABAMBA\",\"typeP\":\"Mensuel\"},\n"+
                " {\"id\":\"18\",\"name\":\"Henoc MUSAFIRI\",\"typeP\":\"Mensuel\"}]\n"+"}";

        try{
            JSONObject jsonObject = new JSONObject(Clients);
            JSONArray jsonArray = jsonObject.getJSONArray("ListeClients");
            for (int i=0; i<jsonArray.length(); i++){
                JSONObject object = jsonArray.getJSONObject(i);
                String ClientId = object.getString("id");
                String ClientName = object.getString("name");
                String TypePClient = object.getString("typeP");
                arrayList.add(ClientId +". "+ ClientName +"   "+ TypePClient);
            }
        } catch (JSONException e ){
            e.printStackTrace();
        }
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        arrayList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
//        InfosUser = findViewById(R.id.idTemp);
//
//        Bundle bundle = getIntent().getExtras();
//        String UserName = bundle.getString("EmailAgent");
//        String PasswordUser = bundle.getString("PasswordAgent");
//
//        InfosUser.setText("User name: "+UserName+"  Password: "+PasswordUser);
    }
}