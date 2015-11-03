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
import com.shollmann.enterprise.app.model.CrewComparator;
import com.shollmann.enterprise.app.model.CrewMember;
import com.shollmann.enterprise.app.ui.adapter.CrewAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrewListActivity extends AppCompatActivity {
    public static final int CREW_MEMBERS = 450;

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
        populateShip();

        fabGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                populateShip();
            }
        });

    }

    private void populateShip() {
        /*
            I discourage the use of async tasks because of its known issues.
            I decided to use it here to avoid running a task that could be heavy
            on the UI thread.
            If I would have used an API I would have populated async with Retrofit or
            a Service
         */
        new GenerateCrewAsyncTask().execute();
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
            for (int i = 0; i < CREW_MEMBERS; i++) {
                newCrewMember = new CrewMember(i);
                listCrewMembers.add(newCrewMember);
            }
            Collections.sort(listCrewMembers, CrewComparator.BY_SKILLS_AND_NAME);
            return listCrewMembers;
        }


        protected void onPostExecute(List<CrewMember> listCrewCrewMembers) {
            txtCrewIsLoading.setVisibility(View.GONE);
            setupRecyclerView(listCrewCrewMembers);
        }
    }


}
