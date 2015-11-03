package com.shollmann.enterprise.app.ui.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.shollmann.enterprise.R;
import com.shollmann.enterprise.app.model.CrewMember;
import com.shollmann.enterprise.app.ui.adapter.CrewAdapter;

import java.util.ArrayList;
import java.util.List;

public class CrewListActivity extends AppCompatActivity {
    private RecyclerView recyclerCrewList;
    private Toolbar toolbar;
    private TextView txtCrewIsLoading;
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

    private void setupRecyclerView(List<CrewMember> listCrewCrewMembers) {
        recyclerCrewList.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerCrewList.setLayoutManager(layoutManager);

        CrewAdapter crewAdapter = new CrewAdapter(listCrewCrewMembers);
        recyclerCrewList.setAdapter(crewAdapter);

        recyclerCrewList.setVisibility(View.VISIBLE);

    }

    private void findViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerCrewList = (RecyclerView) findViewById(R.id.crew_recyclerview);
        txtCrewIsLoading = (TextView) findViewById(R.id.crew_loading_data);
        fabGenerate = (FloatingActionButton) findViewById(R.id.crew_fab);
    }

    private class GenerateCrewAsyncTask extends AsyncTask<Void, Void, List<CrewMember>> {

        protected List<CrewMember> doInBackground(Void... urls) {
            return generateCrewList();
        }

        private List<CrewMember> generateCrewList() {
            List<CrewMember> listCrewMembers = new ArrayList<>();
            CrewMember newCrewMember;
            for (int i = 0; i < 450; i++) {
                newCrewMember = new CrewMember(i);
                listCrewMembers.add(newCrewMember);
            }
//            Collections.sort(listCrewMembers, CrewComparator.BY_SKILLS_AND_NAME);
            return listCrewMembers;
        }


        protected void onPostExecute(List<CrewMember> listCrewCrewMembers) {
            txtCrewIsLoading.setVisibility(View.GONE);
            setupRecyclerView(listCrewCrewMembers);
        }
    }


}
