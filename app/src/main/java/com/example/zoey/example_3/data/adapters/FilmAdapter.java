package com.example.zoey.example_3.data.adapters;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.zoey.example_3.R;
import com.example.zoey.example_3.data.models.Film;
import java.text.SimpleDateFormat;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<com.example.zoey.example_3.data.adapters.FilmAdapter.FilmViewHolder> implements View.OnClickListener{
    private String TAG = "mylog";
    private Context context;
    private List<Film> filmList;

    public FilmAdapter(List<Film> filmList, Context context) {
        this.filmList = filmList;
        this.context = context;
    }

    @NonNull
    @Override
    public com.example.zoey.example_3.data.adapters.FilmAdapter.FilmViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG, "onCreateViewHolder: " + i);
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_films, viewGroup, false);
        return new com.example.zoey.example_3.data.adapters.FilmAdapter.FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.zoey.example_3.data.adapters.FilmAdapter.FilmViewHolder filmViewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: " + i);
        filmViewHolder.itemView.setTag(i);
        filmViewHolder.poster.setTag(i);
        Film film = filmList.get(i);
        filmViewHolder.mfilmname.setText("name: " + film.getName());
        String posterPic = film.getFilmPoster();
        switch (posterPic){
            case "film_0":
                filmViewHolder.poster.setImageResource(R.drawable.film_0);
                break;
            case "film_1":
                filmViewHolder.poster.setImageResource(R.drawable.film_1);
                break;
            case "film_2":
                filmViewHolder.poster.setImageResource(R.drawable.film_2);
                break;
            case "film_3":
                filmViewHolder.poster.setImageResource(R.drawable.film_3);
                break;
            case "film_4":
                filmViewHolder.poster.setImageResource(R.drawable.film_4);
                break;
            case "film_5":
                filmViewHolder.poster.setImageResource(R.drawable.film_5);
                break;
            case "film_6":
                filmViewHolder.poster.setImageResource(R.drawable.film_6);
                break;
        }
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: ");
        return filmList.size();
    }

    public class FilmViewHolder extends RecyclerView.ViewHolder {
        private TextView mfilmname;
        private ImageView poster;
        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);
            mfilmname = itemView.findViewById(R.id.film_name_text_view);
            poster = itemView.findViewById(R.id.poster_image_view);
            poster.setOnClickListener(FilmAdapter.this);
        }

    }

    ////////////////////////////以下为item点击处理///////////////////////////////

    private OnItemClickListener  monItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.monItemClickListener = listener;
    }

    /** item里面有多个控件可以点击 */
    public enum ViewName {
        ITEM,
        PRACTISE
    }

    public interface OnItemClickListener {
        void onItemClick(View v, ViewName viewName, int position, Film film);
    }

    @Override
    public void onClick(View v) {
        //注意这里使用getTag方法获取数据
        int position = (int) v.getTag();
        if (monItemClickListener != null) {
            switch (v.getId()){
                case R.id.poster_image_view:
                    monItemClickListener.onItemClick(v, ViewName.PRACTISE, position, filmList.get(position));
                    break;
                default:
                    monItemClickListener.onItemClick(v, ViewName.ITEM, position,filmList.get(position));
                    break;
            }
        }
    }
}
