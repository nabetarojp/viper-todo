package wataanaber.example.github.com.todo.ui.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import wataanaber.example.github.com.todo.data.model.Todo;
import wataanaber.example.github.com.todo.databinding.ListItemTodoBinding;


public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Todo> items;
    private TodoListContract.Presenter listener;

    TodoAdapter(Context context, List<Todo> items, TodoListContract.Presenter presenter) {
        this.inflater = LayoutInflater.from(context);
        this.items = items;
        this.listener = presenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(ListItemTodoBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Todo a = items.get(position);
        holder.binding.setTodo(a);
        holder.binding.getRoot().setOnClickListener(v -> listener.openEditTodo(a));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Todo item);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ListItemTodoBinding binding;

        ViewHolder(ListItemTodoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}
