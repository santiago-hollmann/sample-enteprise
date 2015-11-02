package com.shollmann.enterprise.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.shollmann.enterprise.R;

import model.Member;

public class CrewMemberViewHolder extends RecyclerView.ViewHolder {
    private TextView txtName;
    private TextView txtRace;
    private View viewPositionColor;
    private TextView txtSkillMultiplier;
    private Member member;

    public CrewMemberViewHolder(View view) {
        super(view);
        txtName = (TextView) view.findViewById(R.id.content_crew_name);
        txtRace = (TextView) view.findViewById(R.id.content_crew_race);
        txtSkillMultiplier = (TextView) view.findViewById(R.id.content_crew_multiplier);
        viewPositionColor = view.findViewById(R.id.content_crew_position_color);
        return;
    }

    public void setMember(Member member) {
        this.member = member;
        txtRace.setText(member.getRaceName());
        txtName.setText(member.getName());
        txtSkillMultiplier.setText(member.getSkillMultiplierForPosition());
        setPositionColor();
    }

    private void setPositionColor() {
        int color = 0;
        switch (member.getPosition()) {
            case COMMANDER:
                color = R.color.yellow;
                break;
            case SCIENTIST:
                color = R.color.blue;
                break;
            case ENGINEER:
                color = R.color.red;
                break;
        }
        viewPositionColor.setBackgroundColor(itemView.getResources().getColor(color));
    }
}
