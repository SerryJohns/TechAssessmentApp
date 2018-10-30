package com.serionz.communityhealthproject.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.serionz.communityhealthproject.R;
import com.serionz.communityhealthproject.model.Child;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by johns on 30/10/2018.
 */
public class ChildListAdapter extends RecyclerView.Adapter<ChildListAdapter.ViewHolder> {
    private final List<Child> mChildList;
    private OnItemClickListener mOnItemClickListener;

    public ChildListAdapter(List<Child> childList, OnItemClickListener onItemClickListener) {
        mChildList = childList;
        mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ChildListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.child_list_item, viewGroup, false);
        return new ChildListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.onBind(mChildList.get(i));
    }

    @Override
    public int getItemCount() {
        return mChildList != null ? mChildList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_first_name)
        TextView mFirstname;
        @BindView(R.id.txt_last_name)
        TextView mLastname;

        private View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.itemView = itemView;
        }

        public void onBind(final Child child) {
            mFirstname.setText(child.getFirstName());
            mLastname.setText(child.getLastName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onChildClicked(child);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onChildClicked(Child child);
    }
}
