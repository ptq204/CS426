package com.example.ptquy.moviedb;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{

	private ArrayList<Movie> arrayList;
	private int resources;
	private Context context;
	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
		View itemView = layoutInflater.inflate(R.layout.movie_item_launch, parent, false);
		return new ViewHolder(itemView);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		holder.title.setText(arrayList.get(position).getTitle());
		float tmp = arrayList.get(position).getRating();
		holder.rating.setText(String.valueOf(tmp)+"/10");
		String url = arrayList.get(position).getPoster();
		holder.coverPhoto.setScaleType(ImageView.ScaleType.FIT_XY);
		Picasso.get().load(url)
					 .resize(holder.coverPhoto.getWidth(), 200)
					 .centerCrop().into(holder.coverPhoto);

		holder.setItemClickListener(new ItemClickListener() {
			@Override
			public void onClick(View view, int position, boolean isLongClick) {
				Movie movie = (Movie) arrayList.get(position);
				Intent intent = new Intent(view.getContext(), MovieInfoActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

				Bundle bundle = new Bundle();
				bundle.putSerializable("value", movie);
				intent.putExtras(bundle);
				context.startActivity(intent);
			}
		});
	}

	public MovieAdapter(ArrayList<Movie> arrayList, int resoures, Context context) {
		this.arrayList = arrayList;
		this.resources = resoures;
		this.context = context;
	}

	public ArrayList<Movie> getArrayList() {
		return arrayList;
	}

	public void setArrayList(ArrayList<Movie> arrayList) {
		this.arrayList = arrayList;
	}

	public int getResoures() {
		return resources;
	}

	public void setResoures(int resoures) {
		this.resources = resoures;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	@Override
	public int getItemCount() {
		return arrayList.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

		TextView title;
		ImageView coverPhoto;
		TextView rating;

		private ItemClickListener itemClickListener;

		public void setItemClickListener(ItemClickListener itemClickListener) {
			this.itemClickListener = itemClickListener;
		}

		public ViewHolder(View itemView) {
			super(itemView);
			title = (TextView) itemView.findViewById(R.id.title_launch);
			rating = (TextView) itemView.findViewById(R.id.rating_launch);
			coverPhoto = (ImageView) itemView.findViewById(R.id.coverphoto_launch);
			itemView.setOnClickListener(this);
			itemView.setOnLongClickListener(this);
		}

		@Override
		public void onClick(View v) {
			itemClickListener.onClick(v, getAdapterPosition(), false);
		}

		@Override
		public boolean onLongClick(View v) {
			itemClickListener.onClick(v, getAdapterPosition(), true);
			return true;
		}
	}
}
