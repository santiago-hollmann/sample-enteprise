package com.shollmann.enterprise.app.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shollmann.enterprise.R;
import com.shollmann.enterprise.app.ui.viewholder.CrewMemberViewHolder;

import java.util.List;

import com.shollmann.enterprise.app.model.CrewMember;

public class CrewAdapter extends RecyclerView.Adapter<CrewMemberViewHolder> {
    private List<CrewMember> listCrewCrewMembers;

    public CrewAdapter(List<CrewMember> listCrewCrewMembers) {
        this.listCrewCrewMembers = listCrewCrewMembers;
    }

    @Override
    public CrewMemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_crew_list, parent, false);
        CrewMemberViewHolder crewMemberViewHolder = new CrewMemberViewHolder(view);
        return crewMemberViewHolder;
    }

    @Override
    public void onBindViewHolder(CrewMemberViewHolder holder, int position) {
        holder.setMember(listCrewCrewMembers.get(position));
    }

    @Override
    public int getItemCount() {
        return listCrewCrewMembers.size();
    }

}
