package com.sudoajay.a9xplayer;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.l4digital.fastscroll.FastScrollRecyclerView;
import com.sudoajay.a9xplayer.Custom_List_Adapter.Custom_List_Adapter_For_Music;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class Music_Video_Song_Page extends Fragment {

    // private global variable
    private Custom_List_Adapter_For_Music custom_list_adapter_for_music;
    private ArrayList<String> array_Music_Artist,array_Music_Timing;
    private HashMap<Integer , String> array_Music_Title;
    private ArrayList<Long>   array_Music_id;
    private Context mContext;


    public Music_Video_Song_Page() {
        // Required empty public constructor
    }
    //
    public Music_Video_Song_Page createInstance(Context mContext,ArrayList<String> array_Music_Artist,ArrayList<Long>  array_Music_id,
                                                ArrayList<String> array_Music_Timing, HashMap<Integer , String> array_Music_Title) {
        this.array_Music_Artist = array_Music_Artist;
        this.mContext= mContext;
        this.array_Music_id = array_Music_id;
        this.array_Music_Timing =array_Music_Timing;
        this.array_Music_Title = array_Music_Title;
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_music_songs_page, container, false);

        custom_list_adapter_for_music = new Custom_List_Adapter_For_Music(mContext,array_Music_Artist,array_Music_id,
                array_Music_Timing,array_Music_Title,null,R.layout.style_music_song_list,null);

        FastScrollRecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(custom_list_adapter_for_music);
        recyclerView.setHasFixedSize(true);
        return rootView;
    }

}
