package com.shollmann.enterprise.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shollmann.enterprise.R;
import com.shollmann.enterprise.ui.viewholder.CrewMemberViewHolder;

import java.util.List;

import model.Member;

public class CrewAdapter extends RecyclerView.Adapter<CrewMemberViewHolder> {
    private List<Member> listCrewMembers;

    public CrewAdapter(List<Member> listCrewMembers) {
        this.listCrewMembers = listCrewMembers;
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
        holder.setMember(listCrewMembers.get(position));
    }

    @Override
    public int getItemCount() {
        return listCrewMembers.size();
    }

}
