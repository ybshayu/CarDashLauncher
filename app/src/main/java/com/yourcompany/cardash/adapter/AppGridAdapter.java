package com.yourcompany.cardash.adapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.yourcompany.cardash.R;
import java.util.Arrays;
import java.util.List;

public class AppGridAdapter extends RecyclerView.Adapter<AppGridAdapter.VH> {
    private List<Item> items = Arrays.asList(
        new Item("地图", R.drawable.ic_map), new Item("音乐", R.drawable.ic_music),
        new Item("电话", R.drawable.ic_phone), new Item("设置", R.drawable.ic_settings),
        new Item("浏览器", R.drawable.ic_browser), new Item("视频", R.drawable.ic_video),
        new Item("文件", R.drawable.ic_files), new Item("下载", R.drawable.ic_download)
    );
    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app, parent, false);
        return new VH(v);
    }
    @Override
    public void onBindViewHolder(@NonNull VH h, int pos) {
        Item it = items.get(pos);
        h.icon.setImageResource(it.icon);
        h.name.setText(it.name);
    }
    @Override public int getItemCount() { return items.size(); }
    static class VH extends RecyclerView.ViewHolder {
        ImageView icon; TextView name;
        VH(View v) { super(v); icon = v.findViewById(R.id.app_icon); name = v.findViewById(R.id.app_name); }
    }
    static class Item { String name; int icon; Item(String n, int i) { name=n; icon=i; } }
}
