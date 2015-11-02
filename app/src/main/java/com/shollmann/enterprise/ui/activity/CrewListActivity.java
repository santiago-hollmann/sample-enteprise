package com.shollmann.enterprise.ui.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.shollmann.enterprise.R;
import com.shollmann.enterprise.ui.adapter.CrewAdapter;

import java.util.ArrayList;
import java.util.List;

import model.Member;

public class CrewListActivity extends AppCompatActivity {
    private RecyclerView recyclerCrewList;
    private Toolbar toolbar;
    private FloatingActionButton fabGenerate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew_list);
        findViews();
        initialize();
    }

    private void initialize() {
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);
        new GenerateCrewAsyncTask().execute();

        fabGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GenerateCrewAsyncTask().execute();
            }
        });

    }

    private void setupRecyclerView(List<Member> listCrewMembers) {
        recyclerCrewList.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerCrewList.setLayoutManager(layoutManager);

        CrewAdapter crewAdapter = new CrewAdapter(listCrewMembers);
        recyclerCrewList.setAdapter(crewAdapter);

    }

    private void findViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerCrewList = (RecyclerView) findViewById(R.id.crew_recyclerview);
        fabGenerate = (FloatingActionButton) findViewById(R.id.crew_fab);
    }

    private class GenerateCrewAsyncTask extends AsyncTask<Void, Void, List<Member>> {

        protected List<Member> doInBackground(Void... urls) {
            return generateCrewList();
        }

        private List<Member> generateCrewList() {
            List<Member> listMembers = new ArrayList<>();
            Member newMember;
            for (int i = 0; i < 450; i++) {
                newMember = new Member(i);
                listMembers.add(newMember);
            }
            return null;
        }


        protected void onPostExecute(List<Member> listCrewMembers) {
            setupRecyclerView(listCrewMembers);
        }
    }


}
